package fr.orsys.groupe3.gamerefback.dao;

import fr.orsys.groupe3.gamerefback.business.Editor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest

public class EditorDaoTest {

    @Autowired
    private  EditorDao editorDao;

    @Test
    public void testEditorfindByName() {
        String editeur = "Blizzard";
        Editor editeurrecup = editorDao.findByName(editeur);
        assertEquals(editeurrecup.getName(), editeur);

    }


}
