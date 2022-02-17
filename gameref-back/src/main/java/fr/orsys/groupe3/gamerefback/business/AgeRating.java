package fr.orsys.groupe3.gamerefback.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
public class AgeRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Merci de donner un nom à cette classification")
    private String name;

    @NotBlank(message = "Merci de donner un slug à cette classification")
    private String slug;

    @JsonIgnore
    @OneToMany(mappedBy = "ageRating")
    private List<Game> games;
}