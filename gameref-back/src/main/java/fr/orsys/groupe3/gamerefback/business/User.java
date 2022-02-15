package fr.orsys.groupe3.gamerefback.business;

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
    protected Long id;

    @NotBlank(message = "Merci de rentrer un pseudo")
    protected String pseudo;

    @NotBlank(message = "Merci de rentrer un mot de passe")
    @Length(min = 8, message = "Le mot de passe doit faire au moins 8 charactères")
    protected String password;

    @NotBlank(message = "Merci de rentrer un mot de passe")
    @Email
    protected String email;
}