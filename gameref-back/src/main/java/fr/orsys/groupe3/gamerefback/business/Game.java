package fr.orsys.groupe3.gamerefback.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Merci de rentrer le nom du jeu")
    private String name;

    @NotBlank(message = "Merci de rentrer une description")
    @Lob
    private String description;

    @NotNull(message = "Merci de rentrer une date de sortie")
    @Past(message = "La date de sortie doit être antérieure à aujourd'hui")
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "game")
    @JsonIgnore
    private List<Review> reviews;

    @ManyToOne
    @NotNull(message = "Merci de sélectionner une classification")
    private AgeRating ageRating;

    @ManyToOne
    @NotNull(message = "Merci de sélectionner une catégorie")
    private Category category;

    @ManyToOne
    @NotNull(message = "Merci de sélectionner un éditeur")
    private Editor editor;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotEmpty(message = "Merci de sélectionner au moins une plateforme")
    private List<Platform> platforms;

    @ManyToOne
    @NotNull(message = "Merci de sélectionner un modèle économique")
    private EconomicModel economicModel;

    @ManyToOne
    private Moderator moderator;
}