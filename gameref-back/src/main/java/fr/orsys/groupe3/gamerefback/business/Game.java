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

/**
 * Cette classe permet de conceptualiser la notion de Jeu dans le cahier de charges donné,
 * on y trouve les attributs permettant de caracteriser un Jeu(Game)
 */
@Entity
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Merci de rentrer le nom du jeu")
    private String name;

    @Lob
    @NotBlank(message = "Merci de rentrer une description")
    private String description;

    @NotNull(message = "Merci de rentrer une date de sortie")
    @Past(message = "Impossible d'ajouter un jeu qui n'est pas encore sorti")
    private LocalDate releaseDate;

    @JsonIgnore
    @OneToMany(mappedBy = "game")
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
