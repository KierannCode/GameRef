package fr.orsys.groupe3.gamerefback.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Getter
@Setter
@Entity
public class AgeRating {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Merci de donner un nom à ce jeu")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "ageRating")
    private List<Game> games;

}