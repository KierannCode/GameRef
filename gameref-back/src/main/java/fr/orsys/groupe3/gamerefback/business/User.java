package fr.orsys.groupe3.gamerefback.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Merci de rentrer un pseudo")
    private String pseudo;

    @JsonIgnore
    @NotBlank(message = "Merci de rentrer un mot de passe")
    @Length(min = 8, message = "Le mot de passe doit faire au moins 8 charactères")
    private String password;

    @NotBlank(message = "Merci de rentrer un mot de passe")
    @Email
    private String email;
}