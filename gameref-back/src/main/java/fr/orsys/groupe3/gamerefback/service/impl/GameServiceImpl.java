package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.dao.GameDao;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.mapper.GameMapper;
import fr.orsys.groupe3.gamerefback.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private GameMapper gameMapper;

    private GameDao gameDao;

    @Override
    public Game createGame(GameDto dto, Moderator moderator) throws NotFoundException {
        Game game = new Game();
        gameMapper.mapGame(game, dto);
        game.setModerator(moderator);
        return gameDao.save(game);
    }

    @Override
    public Game updateGame(Long id, GameDto dto) throws NotFoundException {
        Game game = getGame(id);
        game = gameMapper.mapGame(game, dto);
        return gameDao.save(game);
    }

    @Override
    public Game deleteGame(Long id) throws NotFoundException {
        Game game = getGame(id);
        gameDao.deleteById(id);
        return game;
    }

    @Override
    public Game getGame(Long id) throws NotFoundException {
        return gameDao.findById(id).orElseThrow(() -> new NotFoundException("game", "Aucun jeu trouvé avec l'id " + id));
    }

    @Override
    public Page<Game> getGames(Pageable pageable) {
        return gameDao.findAll(pageable);
    }

    @Override
    public List<Game> getGames() {
        return gameDao.findAll();
    }
}
