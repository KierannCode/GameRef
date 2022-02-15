package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.dto.PlayerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PlayerMapper {
    private UserMapper usermapper;

    public Player mapPlayer(Player player, PlayerDto dto) {
        usermapper.mapUser(player, dto);
        player.setDateOfBirth(dto.getDateOfBirth());

        return player;
    }
}
