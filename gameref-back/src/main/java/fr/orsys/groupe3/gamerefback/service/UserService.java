package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.dto.ModeratorDto;
import fr.orsys.groupe3.gamerefback.dto.PlayerDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.exception.PseudoAlreadyTakenException;

import java.util.List;

public interface UserService {
    Player createPlayer(PlayerDto dto) throws PseudoAlreadyTakenException;

    Player getPlayer(Long id)  throws NotFoundException;

    List<Player> getPlayers();

    Moderator createModerator(ModeratorDto dto);

    Moderator getModerator(Long id)  throws NotFoundException;

    List<Moderator> getModerators();

    User getUser(String pseudo, String password) throws NotFoundException;
}
