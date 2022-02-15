package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.dao.GameDao;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class GameRestController {


    private GameService gameService;


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


    @ExceptionHandler(NotFoundException.class)
    public void handleNotFoundException(NotFoundException e) {
        e.printStackTrace();
    }
}
