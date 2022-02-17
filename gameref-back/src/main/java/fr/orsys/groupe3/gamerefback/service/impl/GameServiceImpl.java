package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.dao.GameDao;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.mapper.GameMapper;
import fr.orsys.groupe3.gamerefback.service.GameService;
import fr.orsys.groupe3.gamerefback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private GameMapper gameMapper;
    private GameDao gameDao;

    private UserService userService;

    @Override
    public Game createGame(GameDto dto) throws NotFoundException {
        Game game = new Game();
        gameMapper.mapGame(game, dto);
        if (game.getModerator() == null) {
            game.setModerator(userService.getModerator(6L));
        }
        return gameDao.save(game);
    }

    @Override
    public Page<Game> getGames(Pageable pageable) {
        return gameDao.findAll(pageable);
    }

    @Override
    public List<Game> getGames() {
        return gameDao.findAll();
    }

    @Override
    public Game getGame(Long id) throws NotFoundException {
        return gameDao.findById(id).orElseThrow(() -> new NotFoundException("No game found with id " + id));
    }

    @Override
    public Game deleteGame(Long id) throws NotFoundException {
        Game game = gameDao.findById(id).orElseThrow(() -> new NotFoundException("No game found with id " + id));
        gameDao.deleteById(id);
        return game;
    }

    @Override
    public Game updateGame(Long id, GameDto dto) throws NotFoundException {
        Game game = gameDao.findById(id).orElseThrow(() -> new NotFoundException("No game found with id " + id));
        gameMapper.mapGame(game, dto);
        return gameDao.save(game);
    }
}
