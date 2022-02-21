package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.business.Review;
import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.business.dto.ReviewDto;
import fr.orsys.groupe3.gamerefback.exception.ErrorMap;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.exception.SecurityException;
import fr.orsys.groupe3.gamerefback.service.ReviewService;
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
public class ReviewRestController {
    private ReviewService reviewService;
    private HttpSession httpSession;

    @PostMapping("/review")
    public Review addReview(@RequestBody ReviewDto dto) throws NotFoundException, SecurityException {
        Object user = httpSession.getAttribute("user");
        if (user == null) {
            throw new SecurityException("La session a expiré, veuillez retourner sur la page de connexion pour vous authentifier à nouveau");
        }
        if (!(user instanceof Player)) {
            throw new SecurityException("L'ajout d'avis est réservée aux joueurs");
        }
        return reviewService.createReview(dto, (Player) httpSession.getAttribute("user"));
    }

    @PatchMapping("/review/{id}/validate")
    public Review validateReview(@PathVariable Long id) throws SecurityException, NotFoundException {
        Object user = httpSession.getAttribute("user");
        if (user == null) {
            throw new SecurityException("La session a expiré, veuillez retourner sur la page de connexion pour vous authentifier à nouveau");
        }
        if (!(user instanceof Moderator)) {
            throw new SecurityException("La validation d'avis est réservée aux modérateurs");
        }
        return reviewService.validateReview(id, (Moderator) user);
    }

    @DeleteMapping("review/{id}")
    public Review deleteReview(@PathVariable Long id) throws NotFoundException, SecurityException {
        Object user = httpSession.getAttribute("user");
        if (user == null) {
            throw new SecurityException("La session a expiré, veuillez retourner sur la page de connexion pour vous authentifier à nouveau");
        }
        return reviewService.deleteReview(id, (User) user);
    }

    @GetMapping("/reviews/{filter}")
    public Page<Review> getReviews(@PathVariable String filter, Pageable pageable) throws SecurityException {
        Object user = httpSession.getAttribute("user");
        if (user == null) {
            throw new SecurityException("La session a expiré, veuillez retourner sur la page de connexion pour vous authentifier à nouveau");
        }
        switch (filter) {
            case "all":
                return reviewService.getReviews(pageable, (User) user);
            case "validated":
                if (!(user instanceof Moderator)) {
                    throw new SecurityException("Seul les modérateurs peuvent filtrer les avis");
                }
                return reviewService.getValidatedReviews(pageable);
            case "unvalidated":
                if (!(user instanceof Moderator)) {
                    throw new SecurityException("Seul les modérateurs peuvent filtrer les avis");
                }
                return reviewService.getUnvalidatedReviews(pageable);
        }
        throw new SecurityException("Chemin inconnu : \"reviews/" + filter + "\"");
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
