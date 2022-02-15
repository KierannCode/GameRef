package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.dto.PlayerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerMapper {
    private UserMapper usermapper;

    public Player mapPlayer(Player player, PlayerDto dto) {
        usermapper.mapUser(player, dto);
        player.setBirthDate(dto.getBirthDate());
        return player;
    }
}
