package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.dao.GameDao;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.mapper.GameMapper;
import fr.orsys.groupe3.gamerefback.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {

    private GameMapper gameMapper;
    private GameDao gameDao;


    @Override
    public Game createGame(GameDto dto) {
        Game game = new Game();
        gameMapper.mapGame(game, dto);
        game.setHasImage(false);
        return gameDao.save(game);
    }

    @Override
    public List<Game> getGames() {
        return gameDao.findAll();
    }

    @Override
    public Game getGame(Long id) {
        return gameDao.findById(id).orElseThrow();
    }

    @Override
    public Void deleteGame(Long id) {
        gameDao.deleteById(id);
        return null;
    }

    @Override
    public Game updateGame(Long id, GameDto dto) {
        Game game = gameDao.findById(id).orElseThrow();
        gameMapper.mapGame(game, dto);
        return gameDao.save(game);
    }
}
