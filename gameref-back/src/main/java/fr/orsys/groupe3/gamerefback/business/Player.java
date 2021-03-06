package fr.orsys.groupe3.gamerefback.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Player extends User {
    @NotNull(message = "Merci de rentrer une date de naissance")
    @Past(message = "Merci de saisir une date de naissance valide")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "player")
    private List<Review> reviews;
}
