package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    private PasswordEncoder passwordEncoder;

    public User mapUser(User user, UserDto dto) {
        user.setPseudo(dto.getPseudo());
        System.out.println(dto.getPassword());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        System.out.println(user.getPassword());
        user.setEmail(dto.getEmail());
        return user;
    }
}
