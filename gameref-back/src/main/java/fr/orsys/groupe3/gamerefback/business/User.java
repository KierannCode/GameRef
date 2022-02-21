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

    @Column(unique = true)
    @NotBlank(message = "Merci de rentrer un pseudo")
    private String pseudo;

    @JsonIgnore
    @NotBlank(message = "Merci de rentrer un mot de passe")
    private String password;

    @NotBlank(message = "Merci de rentrer une adresse mail")
    @Email(message = "Merci de rentrer une adresse mail valide")
    private String email;

    @Transient
    private String role = this.getClass().getSimpleName();
}
