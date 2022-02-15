package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;


import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class GameRestController {
    private static final int GAMES_BY_PAGE = 5;

    private final GameService gameService;

    @GetMapping("/games")
    public Page<Game> getGames(@PageableDefault(size = GAMES_BY_PAGE, sort="id", direction = Sort.Direction.DESC) Pageable pageable) throws NotFoundException {
        return gameService.getGames(pageable);
    }
}
