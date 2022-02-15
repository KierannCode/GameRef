package fr.orsys.groupe3.gamerefback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class PlayerDto extends UserDto {

    private LocalDate dateOfBirth;

    public PlayerDto(String pseudo, String password, String email) {
        super(pseudo, password, email);
    }
}
