package fr.orsys.groupe3.gamerefback.business.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ModeratorDto extends UserDto {
    private String phoneNumber;

    public ModeratorDto(String pseudo, String password, String email, String phoneNumber) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
