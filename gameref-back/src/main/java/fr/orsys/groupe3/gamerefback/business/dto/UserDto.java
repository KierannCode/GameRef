package fr.orsys.groupe3.gamerefback.business.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    protected String pseudo;
    protected String password;
    protected String email;
}
