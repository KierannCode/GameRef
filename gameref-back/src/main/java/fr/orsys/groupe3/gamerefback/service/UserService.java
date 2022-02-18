package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.dto.ModeratorDto;
import fr.orsys.groupe3.gamerefback.dto.PlayerDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;

import java.util.List;

public interface UserService {
    Moderator createModerator(ModeratorDto dto);

    Player createPlayer(PlayerDto dto);

    List<Player> getPlayers();

    List<Moderator> getModerators();

    User getUser(String pseudo, String password) throws NotFoundException;

    Player getPlayer(Long id)  throws NotFoundException;

    Moderator getModerator(Long id)  throws NotFoundException;
}
