package fr.orsys.groupe3.gamerefback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ModeratorDto extends UserDto {

    private String phoneNumber;


    public ModeratorDto(String pseudo, String password, String email) {
        super(pseudo, password, email);
    }
}
