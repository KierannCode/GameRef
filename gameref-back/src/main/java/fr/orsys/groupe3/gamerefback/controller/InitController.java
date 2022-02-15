package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Platform;
import fr.orsys.groupe3.gamerefback.dto.AgeRatingDto;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.service.AgeRatingService;
import fr.orsys.groupe3.gamerefback.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;

@Controller
@AllArgsConstructor
public class InitController {

    private AgeRatingService ageRatingService;
    private GameService gameService;

    @PostConstruct
    public void initAll() {
        initAgeRatings();
        //initCategories();
        //initEconomicModels();
        //initEditors();
        //initPlatforms();
        //initPlayers();
        //initReviews();
        //initModerators();
        initGames();
    }


    public void initAgeRatings() {
        if (ageRatingService.getAgeRatings().isEmpty()) {
            AgeRatingDto pegi3 = new AgeRatingDto("PEGI 3");
            AgeRatingDto pegi12 = new AgeRatingDto("PEGI 12");
            AgeRatingDto pegi16 = new AgeRatingDto("PEGI 16");
            AgeRatingDto pegi18 = new AgeRatingDto("PEGI 18");

            ageRatingService.createAgeRating(pegi3);
            ageRatingService.createAgeRating(pegi12);
            ageRatingService.createAgeRating(pegi16);
            ageRatingService.createAgeRating(pegi18);
        }
    }

    @PostConstruct
    public void initGames() {
        if (gameService.getGames().isEmpty()) {
            GameDto game1 = new GameDto("FFXIV", "Un super mmo", LocalDate.of(2010, 1, 1),  1L, 1L, 1L, Arrays.asList(1L,2L), 1L, 1L);
            GameDto game2 = new GameDto("Tomb Raider", "Une archéologue avec deux flingues", LocalDate.of(2000, 1, 1), 2L, 2L, 2L, Arrays.asList(1L), 1L, 1L);
        }
    }
}
