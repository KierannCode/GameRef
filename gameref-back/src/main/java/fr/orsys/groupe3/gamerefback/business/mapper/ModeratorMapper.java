package fr.orsys.groupe3.gamerefback.business.mapper;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.dto.ModeratorDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ModeratorMapper {
    private UserMapper usermapper;

    public Moderator mapModerator(Moderator moderator, ModeratorDto dto) {
        usermapper.mapUser(moderator, dto);
        if (dto.getPhoneNumber() != null) {
            moderator.setPhoneNumber(dto.getPhoneNumber());
        }
        return moderator;
    }
}
