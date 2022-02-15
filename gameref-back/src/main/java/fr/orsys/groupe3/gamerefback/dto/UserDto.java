package fr.orsys.groupe3.gamerefback.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UserDto {
    protected String pseudo;
    protected String password;
    protected String email;
}
