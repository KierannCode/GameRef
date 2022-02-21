package fr.orsys.groupe3.gamerefback.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PlayerDto extends UserDto {
    private LocalDate birthDate;

    public PlayerDto(String pseudo, String password, String email, LocalDate birthDate) {
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
    }

    public PlayerDto() {

    }
}
