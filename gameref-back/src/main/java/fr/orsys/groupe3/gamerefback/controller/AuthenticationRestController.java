package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.business.dto.PlayerDto;
import fr.orsys.groupe3.gamerefback.business.dto.UserDto;
import fr.orsys.groupe3.gamerefback.exception.*;
import fr.orsys.groupe3.gamerefback.exception.SecurityException;
import fr.orsys.groupe3.gamerefback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class AuthenticationRestController {
    private UserService userService;
    private HttpSession httpSession;

    @PostMapping("/login")
    public User login(@RequestBody UserDto dto) throws NotFoundException {
        User user = userService.getUser(dto.getPseudo(), dto.getPassword());
        httpSession.setAttribute("user", user);
        return user;
    }

    @PostMapping("/logout")
    public void logout() {
        httpSession.invalidate();
    }

    @PostMapping("/signIn")
    public User signIn(@RequestBody @Valid PlayerDto dto, BindingResult result) throws CustomValidationException {
        if (result.hasErrors()) {
            throw new CustomValidationException("password", Objects.requireNonNull(result.getFieldError("password")).getDefaultMessage());
        }
        return userService.createPlayer(dto);
    }

    @GetMapping("/user")
    public User getSessionUser() throws SecurityException {
        Object user = httpSession.getAttribute("user");
        if (user == null) {
            throw new SecurityException("La session a expiré, veuillez vous authentifier à nouveau");
        }
        return (User) user;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorMap handleNotFoundException(NotFoundException exception) {
        ErrorMap errors = new ErrorMap();
        errors.put(exception.getEntity(), List.of(exception.getMessage()));
        return errors;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMap handleValidationErrors(ConstraintViolationException exception) {
        ErrorMap errors = new ErrorMap();
        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            String property = violation.getPropertyPath().toString();
            if (errors.containsKey(property)) {
                errors.get(property).add(violation.getMessage());
            } else {
                errors.put(property, List.of(violation.getMessage()));
            }
        }
        return errors;
    }

    @ExceptionHandler(CustomValidationException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMap handleCustomValidationException(CustomValidationException exception) {
        ErrorMap errors = new ErrorMap();
        errors.put(exception.getAttribute(), List.of(exception.getMessage()));
        return errors;
    }

    @ExceptionHandler(SecurityException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public ErrorMap handleSecurityException(SecurityException exception) {
        ErrorMap errors = new ErrorMap();
        errors.put("access", List.of(exception.getMessage()));
        return errors;
    }
}
