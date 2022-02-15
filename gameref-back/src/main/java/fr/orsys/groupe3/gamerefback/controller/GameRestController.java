package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GameRestController {

    private GameService gameService;
    private static final int GAMES_BY_PAGE = 5;

    // Ajout d'un jeu
    @PostMapping("/game")
    public Game addGame(@RequestBody GameDto dto) throws NotFoundException {

        return gameService.createGame(dto);
    }

    // Suppression d'un jeu
    @DeleteMapping("game/{id}")
    public Game deleteGame(@PathVariable("id") long id) throws NotFoundException {
        return gameService.deleteGame(id);
    }

    @GetMapping("/games")
    public Page<Game> getGames(@PageableDefault(size = GAMES_BY_PAGE, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) throws NotFoundException {
        return gameService.getGames(pageable);
    }

    @PatchMapping("/game/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody GameDto dto) throws NotFoundException {
        System.out.println("Hello from update");
        return gameService.updateGame(id, dto);

    }

    @ExceptionHandler(NotFoundException.class)
    public void handleNotFoundException(NotFoundException e) {
        e.printStackTrace();
    }
}
