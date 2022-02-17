package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.*;
import fr.orsys.groupe3.gamerefback.dao.GameDao;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.mapper.GameMapper;
import fr.orsys.groupe3.gamerefback.service.impl.GameServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class GameServiceTest {

    @InjectMocks
    GameServiceImpl gameService;

    @Mock
    GameDao gameDao;

    @Mock
    GameMapper gameMapper;

    @Test
    public void updateGameNominalTest() throws NotFoundException {
        Long id = 1L;
        Game game = new Game();
        game.setId(id);

        GameDto dto = new GameDto("new game", "new description", LocalDate.now(), 1L,
                1L, 1L, Arrays.asList(1L, 2L), 1L);

        Game mappedGame = new Game();
        mappedGame.setId(id);

        Game expectedResult = new Game();
        expectedResult.setId(id);

        doReturn(Optional.of(game)).when(gameDao).findById(any(Long.class));
        doReturn(mappedGame).when(gameMapper).mapGame(any(Game.class), any(GameDto.class));
        doReturn(expectedResult).when(gameDao).save(any(Game.class));

        Game result = gameService.updateGame(id, dto);

        verify(gameDao).findById(id);
        verify(gameMapper).mapGame(game, dto);
        verify(gameDao).save(mappedGame);

        assertEquals(expectedResult, result);
    }

    @Test
    public void updateGameThrowTest() {
        Long id = 1L;

        GameDto dto = new GameDto("new game", "new description", LocalDate.now(), 1L,
                1L, 1L, Arrays.asList(1L, 2L), 1L);

        doReturn(Optional.empty()).when(gameDao).findById(any(Long.class));

        assertThrows(NotFoundException.class, () -> gameService.updateGame(id, dto));
    }
}
