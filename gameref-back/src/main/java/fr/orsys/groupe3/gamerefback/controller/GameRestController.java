package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class GameRestController {

    private GameService gameService;

    // Ajout d'un jeu
    @PostMapping("/game")
    public Game addGame(@RequestBody GameDto dto) throws NotFoundException {
        return gameService.createGame(dto, null);
    }

    // Suppression d'un jeu
    @DeleteMapping("game/{id}")
    public Game deleteGame(@PathVariable("id") long id) throws NotFoundException {
        return gameService.deleteGame(id);
    }

    @GetMapping("/games")
    public Page<Game> getGames(Pageable pageable) throws NotFoundException {
        return gameService.getGames(pageable);
    }

    @PatchMapping("/game/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody GameDto dto) throws NotFoundException {
        return gameService.updateGame(id, dto);

    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, List<String>> handleNotFoundException(NotFoundException exception) {
        Map<String, List<String>> errors = new HashMap<>();
        if (exception.getEntity().equals("platform")) {
            errors.put("platform", List.of(exception.getMessage()));
        } else {
            errors.put(exception.getEntity(), List.of(exception.getMessage()));
        }
        return errors;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, List<String>> handleValidationErrors(ConstraintViolationException exception) {
        Map<String, List<String>> errors = new HashMap<>();
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
}
