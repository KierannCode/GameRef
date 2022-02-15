package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {
    Game createGame(GameDto dto) throws NotFoundException;

    List<Game> getGames();

    Game getGame(Long id) throws NotFoundException;

    Game deleteGame(Long id) throws NotFoundException;

    Game updateGame(Long id, GameDto dto) throws NotFoundException;
}
