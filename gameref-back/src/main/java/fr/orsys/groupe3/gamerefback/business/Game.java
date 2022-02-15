package fr.orsys.groupe3.gamerefback.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "Merci de rentrer un nom pour le jeu")
    private String name;

    @NotBlank(message = "Merci de rentrer un nom description")
    @Lob
    private String description;

    @NotNull(message = "Merci de rentrer une date de sortie")
    @Past
    private LocalDate releaseDate;

    @Transient
    private Boolean hasImage;

    @OneToMany(mappedBy = "game")
    @JsonIgnore
    private List<Review> reviews;

    @ManyToOne
    private AgeRating ageRating;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Editor editor;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Platform> platforms;

    @ManyToOne
    private EconomicModel economicModel;

    @ManyToOne
    private Moderator moderator;
}