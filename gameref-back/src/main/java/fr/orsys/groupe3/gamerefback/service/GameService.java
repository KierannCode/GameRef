package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.dto.GameDto;

import java.util.List;

public interface GameService {
    Game createGame(GameDto dto);
    List<Game>getGames();
    Game getGame(Long id);
    Void deleteGame(Long id);
    Game updateGame(Long id, GameDto dto);
}
