package fr.orsys.groupe3.gamerefback.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Player extends User {
    @NotBlank(message = "Merci de rentrer une date de naissance")
    @Past
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy="player")
    @JsonIgnore
    private List<Review> reviews;
}