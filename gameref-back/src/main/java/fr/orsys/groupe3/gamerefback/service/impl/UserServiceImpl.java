package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.dao.ModeratorDao;
import fr.orsys.groupe3.gamerefback.dao.PlayerDao;
import fr.orsys.groupe3.gamerefback.dto.ModeratorDto;
import fr.orsys.groupe3.gamerefback.dto.PlayerDto;
import fr.orsys.groupe3.gamerefback.mapper.ModeratorMapper;
import fr.orsys.groupe3.gamerefback.mapper.PlayerMapper;
import fr.orsys.groupe3.gamerefback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private PlayerDao playerDao;
    private ModeratorDao moderatorDao;
    private PlayerMapper playerMapper;
    private ModeratorMapper moderatorMapper;

    @Override
    public Moderator createModerator(ModeratorDto dto) {
        Moderator moderator = new Moderator();
        moderatorMapper.mapModerator(moderator,dto);
        return moderatorDao.save(moderator);
    }

    @Override
    public Player createPlayer(PlayerDto dto) {

        Player player = new Player();
        playerMapper.mapPlayer(player,dto);
        return playerDao.save(player);
    }

    @Override
    public List<Player> getPlayers() {
        return playerDao.findAll();
    }

    @Override
    public List<Moderator> getModerators() {
        return moderatorDao.findAll();
    }

    @Override
    public Player getPlayer(Long id) {
        return playerDao.findById(id).orElseThrow();
    }

    @Override
    public Moderator getModerator(Long id) {
        return moderatorDao.findById(id).orElseThrow();
    }
}
