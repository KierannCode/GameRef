package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.dto.ModeratorDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ModeratorMapper {

    private UserMapper usermapper;
    public Moderator mapModerator(Moderator moderator, ModeratorDto dto) {
        usermapper.mapUser(moderator, dto);
        moderator.setPhoneNumber(dto.getPhoneNumber());

        return moderator;
    }
}
