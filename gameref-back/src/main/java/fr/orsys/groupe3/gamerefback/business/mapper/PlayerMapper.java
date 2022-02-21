package fr.orsys.groupe3.gamerefback.business.mapper;

import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.business.dto.PlayerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerMapper {
    private UserMapper usermapper;

    public Player mapPlayer(Player player, PlayerDto dto) {
        usermapper.mapUser(player, dto);
        if (dto.getBirthDate() != null) {
            player.setBirthDate(dto.getBirthDate());
        }
        return player;
    }
}
