package fr.orsys.groupe3.gamerefback.dao;


import fr.orsys.groupe3.gamerefback.business.Platform;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class PlatformDaoTest {

    @Autowired
    private PlatformDao platformDao;

    @Test
    public void testPlatformfindByName() {
        String nomPlatform = "Android";
        Platform plateformerecupere = platformDao.findByName(nomPlatform);
        assertEquals(plateformerecupere.getName(), nomPlatform);
    }
}
