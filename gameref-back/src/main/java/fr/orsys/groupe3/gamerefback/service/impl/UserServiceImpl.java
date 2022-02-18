package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.dao.ModeratorDao;
import fr.orsys.groupe3.gamerefback.dao.PlayerDao;
import fr.orsys.groupe3.gamerefback.dao.UserDao;
import fr.orsys.groupe3.gamerefback.dto.ModeratorDto;
import fr.orsys.groupe3.gamerefback.dto.PlayerDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.mapper.ModeratorMapper;
import fr.orsys.groupe3.gamerefback.mapper.PlayerMapper;
import fr.orsys.groupe3.gamerefback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private PasswordEncoder passwordEncoder;
    private PlayerDao playerDao;
    private ModeratorDao moderatorDao;
    private PlayerMapper playerMapper;
    private ModeratorMapper moderatorMapper;

    @Override
    public Moderator createModerator(ModeratorDto dto) {
        Moderator moderator = new Moderator();
        moderatorMapper.mapModerator(moderator, dto);
        return moderatorDao.save(moderator);
    }

    @Override
    public Player createPlayer(PlayerDto dto) {
        Player player = new Player();
        playerMapper.mapPlayer(player, dto);
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
    public User getUser(String pseudo, String password) throws NotFoundException {
        User user = userDao.findByPseudo(pseudo).orElseThrow(() -> new NotFoundException("No user found with pseudo \"" + pseudo +"\""));
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new NotFoundException("Incorrect password for user \"" + pseudo +"\"");
        }
    }

    @Override
    public Player getPlayer(Long id) throws NotFoundException {
        return playerDao.findById(id).orElseThrow(() -> new NotFoundException("No player found with id " + id));
    }

    @Override
    public Moderator getModerator(Long id) throws NotFoundException {
        return moderatorDao.findById(id).orElseThrow(() -> new NotFoundException("No moderator found with id " + id));
    }
}
