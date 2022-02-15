package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapUser(User user, UserDto dto) {
        user.setPseudo(dto.getPseudo());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        return user;
    }
}
