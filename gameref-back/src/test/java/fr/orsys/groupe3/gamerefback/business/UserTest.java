package fr.orsys.groupe3.gamerefback.business;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Classe de test de la classe User
 */
@SpringBootTest
public class UserTest {

    /**
     * Methode de test de la methode createPlayer()
     */
    @Test
    void createPLayerTest() {
        Player player = new Player();
        player.setPseudo("kiki");
        player.setEmail("kiki@free.net");
        Assertions.assertEquals("kiki",player.getPseudo());
        Assertions.assertEquals("kiki@free.net",player.getEmail());
    }


}
