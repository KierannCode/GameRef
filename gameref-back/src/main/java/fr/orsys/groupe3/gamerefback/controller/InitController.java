package fr.orsys.groupe3.gamerefback.controller;


import fr.orsys.groupe3.gamerefback.dto.AgeRatingDto;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.dto.ModeratorDto;
import fr.orsys.groupe3.gamerefback.dto.PlayerDto;
import fr.orsys.groupe3.gamerefback.service.AgeRatingService;
import fr.orsys.groupe3.gamerefback.service.GameService;
import fr.orsys.groupe3.gamerefback.service.UserService;
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
    private UserService userService;

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

    public void initGames() {
        if (gameService.getGames().isEmpty()) {
            GameDto game1 = new GameDto("FFXIV", "Un super mmo", LocalDate.of(2010, 1, 1),  1L, 1L, 1L, Arrays.asList(1L,2L), 1L, 1L);
            GameDto game2 = new GameDto("Tomb Raider", "Une archéologue avec deux flingues", LocalDate.of(2000, 1, 1), 2L, 2L, 2L, Arrays.asList(1L), 1L, 1L);

            gameService.createGame(game1);
            gameService.createGame(game2);
        }
    }

    public void initModerators() {
        if(userService.getModerators().isEmpty()){
            ModeratorDto moderatorOne = new ModeratorDto("Moderator1","azerty","moderator1@gmail.com");
            ModeratorDto moderatorTwo = new ModeratorDto("Moderator2","qwerty","moderator2@gmail.com");
            ModeratorDto moderatorThree = new ModeratorDto("Moderator3","123456","moderator3@gmail.com");

            userService.createModerator(moderatorOne);
            userService.createModerator(moderatorTwo);
            userService.createModerator(moderatorThree);
        }

    }

    public void initPlayers() {
        if(userService.getPlayers().isEmpty()) {

            PlayerDto playerOne = new PlayerDto("Player1","azerty","player1@gmail.com");
            PlayerDto playerTwo = new PlayerDto("Player2","qwerty","player2@gmail.com");
            PlayerDto playerThree = new PlayerDto("Player3","123456","player3@gmail.com");

            userService.createPlayer(playerOne);
            userService.createPlayer(playerTwo);
            userService.createPlayer(playerThree);
        }

    }

}
