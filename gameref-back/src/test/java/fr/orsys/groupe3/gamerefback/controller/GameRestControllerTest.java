package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.dto.GameDto;

import fr.orsys.groupe3.gamerefback.service.GameService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
public class GameRestControllerTest {
    @InjectMocks
    GameRestController gameRestController;

    @Mock
    GameService gameService;

    @Test
    public void testAddGame()  {

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
