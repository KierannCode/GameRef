package fr.orsys.groupe3.gamerefback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private String pseudo;
    private String password;
    private String email;
}
