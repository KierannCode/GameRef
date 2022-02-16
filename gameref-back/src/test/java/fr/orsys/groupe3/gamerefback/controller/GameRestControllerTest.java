package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class GameRestControllerTest {
    @InjectMocks
    GameRestController gameRestController;

    @Mock
    GameService gameService;

    @Test
    public void testAddGame() {

    }

    @Test
    public void deleteAddGame() {

    }

    @Test
    public void testGetGames() {

    }

    @Test
    public void testUpdateGame() {

    }
}
