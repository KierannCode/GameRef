package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.ErrorMap;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.exception.SecurityException;
import fr.orsys.groupe3.gamerefback.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class GameRestController {
    private GameService gameService;

    private HttpSession httpSession;

    @PostMapping("/game")
    public Game addGame(@RequestBody GameDto dto) throws NotFoundException, SecurityException {
        Object user = httpSession.getAttribute("user");
        if (user == null) {
            throw new SecurityException("La session a expiré, veuillez retourner sur la page de connexion pour vous authentifier à nouveau");
        }
        if (!(user instanceof Moderator)) {
            throw new SecurityException("L'ajout de jeux est réservée aux modérateurs");
        }
        return gameService.createGame(dto, (Moderator) user);
    }

    @PatchMapping("/game/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody GameDto dto) throws NotFoundException, SecurityException {
        Object user = httpSession.getAttribute("user");
        if (user == null) {
            throw new SecurityException("La session a expiré, veuillez retourner sur la page de connexion pour vous authentifier à nouveau");
        }
        if (!(user instanceof Moderator)) {
            throw new SecurityException("La modification de jeux est réservée aux modérateurs");
        }
        return gameService.updateGame(id, dto);

    }

    @DeleteMapping("game/{id}")
    public Game deleteGame(@PathVariable("id") Long id) throws NotFoundException, SecurityException {
        Object user = httpSession.getAttribute("user");
        if (user == null) {
            throw new SecurityException("La session a expiré, veuillez retourner sur la page de connexion pour vous authentifier à nouveau");
        }
        if (!(user instanceof Moderator)) {
            throw new SecurityException("La suppression de jeux est réservée aux modérateurs");
        }
        return gameService.deleteGame(id);
    }

    @GetMapping("/games")
    public Page<Game> getGames(Pageable pageable) throws SecurityException {
        Object user = httpSession.getAttribute("user");
        if (user == null) {
            throw new SecurityException("La session a expiré, veuillez retourner sur la page de connexion pour vous authentifier à nouveau");
        }
        return gameService.getGames(pageable);
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

    @ExceptionHandler(SecurityException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public ErrorMap handleSecurityException(SecurityException exception) {
        ErrorMap errors = new ErrorMap();
        errors.put("access", List.of(exception.getMessage()));
        return errors;
    }
}
