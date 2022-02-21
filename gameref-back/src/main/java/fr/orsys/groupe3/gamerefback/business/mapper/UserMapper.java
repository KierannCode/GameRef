package fr.orsys.groupe3.gamerefback.business.mapper;

import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.business.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    private PasswordEncoder passwordEncoder;

    public User mapUser(User user, UserDto dto) {
        if (dto.getPseudo() != null) {
            user.setPseudo(dto.getPseudo());
        }
        if (dto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }
        return user;
    }
}
