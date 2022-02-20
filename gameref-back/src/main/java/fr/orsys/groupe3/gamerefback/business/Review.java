package fr.orsys.groupe3.gamerefback.business;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @NotBlank(message = "Merci de rentrer une description")
    private String description;

    private LocalDateTime submitDate;

    @NotNull(message = "Merci de rentrer une note")
    @Range(min = 0, max = 20, message = "La note doit être comprise entre 0 et 20")
    private Float rating;

    private LocalDateTime moderationDate;

    @ManyToOne
    @NotNull(message = "Merci de sélectionner le jeu à évaluer")
    private Game game;

    @ManyToOne
    private Moderator moderator;

    @ManyToOne
    private Player player;
}
