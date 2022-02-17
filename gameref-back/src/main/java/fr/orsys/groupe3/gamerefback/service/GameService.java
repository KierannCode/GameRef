package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public interface GameService {
    Game createGame(GameDto dto, Moderator moderator) throws NotFoundException;

    Page<Game> getGames(Pageable pageable);
    List<Game> getGames();
    Game getGame(Long id) throws NotFoundException;

    Game deleteGame(Long id) throws NotFoundException;

    Game updateGame(Long id, GameDto dto) throws NotFoundException;
}
