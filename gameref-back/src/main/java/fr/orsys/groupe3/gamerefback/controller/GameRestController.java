package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

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
    public String handleNotFoundException(NotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public List<Pair<String, String>> handleValidationErrors(ConstraintViolationException exception) {
        List<Pair<String, String>> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            errors.add(Pair.of(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        return errors;
    }
}
