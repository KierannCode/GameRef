package fr.orsys.groupe3.gamerefback.business.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserDto {
    protected String pseudo;
    @Length(min = 8, message = "Le mot de passe doit faire au moins 8 caractères")
    protected String password;
    protected String email;
}
