package fr.orsys.groupe3.gamerefback.business;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Moderator extends User {
    @NotBlank(message = "Merci de renseigner un numéro de téléphone")
    private String phoneNumber;
}
