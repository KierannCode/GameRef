package fr.orsys.groupe3.gamerefback.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

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
    @Length(min = 8, message = "Le mot de passe doit faire au moins 8 caractères")
    private String password;

    @NotBlank(message = "Merci de rentrer une adresse mail")
    @Email(message = "Merci de rentrer une adresse mail valide")
    private String email;

    @Transient
    private String role = this.getClass().getSimpleName();


    void createNewPlayer() {
        Player p = new Player();
        p.setEmail("jiji@hotmail.com");
        p.setPseudo("bibi");
        p.setBirthDate(LocalDate.of(1988,1,3));
        p.setPassword("azerty");
        System.out.println("pseudo :" +p.getPseudo()
                + " email : " +p.getEmail()
                + "password :" +p.getPassword()
                + "Date de naissance :" +p.getBirthDate());
    }
}
