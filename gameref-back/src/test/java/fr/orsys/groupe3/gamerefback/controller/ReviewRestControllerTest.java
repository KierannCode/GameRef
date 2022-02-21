package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.business.Review;
import fr.orsys.groupe3.gamerefback.dto.PlayerDto;
import fr.orsys.groupe3.gamerefback.dto.ReviewDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.ReviewService;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class ReviewRestControllerTest {

    @InjectMocks
    ReviewRestController reviewRestController;

    @Mock
    ReviewService reviewService;


    @Test
    public void testAddReview() throws NotFoundException {

        PlayerDto pdto = new PlayerDto();
        Player player = new Player();
        pdto.setPseudo("ThePlayer");
        player.setEmail("theplayer@gmail.com");
        player.setPassword("thepasswordplayer");
        player.setBirthDate(LocalDate.of(1980, 8,15));
        ReviewDto rdto = new ReviewDto();
        rdto.setRating(12F);
        rdto.setDescription("Une description");
        reviewService.createReview(rdto,player);
        // verifier si la methode à bien été appeler
        verify(reviewService).createReview(rdto,player);

    }

}
