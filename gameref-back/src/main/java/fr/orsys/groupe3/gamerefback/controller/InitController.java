package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.dto.*;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.*;

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
import java.time.Month;
import java.util.Arrays;

@Controller
@AllArgsConstructor
public class InitController {
    private AgeRatingService ageRatingService;
    private CategoryService categoryService;
    private EconomicModelService economicModelService;
    private EditorService editorService;
    private PlatformService platformService;
    private UserService userService;
    private GameService gameService;

    @PostConstruct
    public void initAll() {
        initAgeRatings();
        initCategories();
        initEconomicModels();
        initEditors();
        initPlatforms();
        initPlayers();
        initModerators();
        initGames();
    }

    public void initAgeRatings() {
        if (ageRatingService.getAgeRatings().isEmpty()) {
            ageRatingService.createAgeRating(new AgeRatingDto("PEGI 3"));
            ageRatingService.createAgeRating(new AgeRatingDto("PEGI 12"));
            ageRatingService.createAgeRating(new AgeRatingDto("PEGI 16"));
            ageRatingService.createAgeRating(new AgeRatingDto("PEGI 18"));
        }
    }

    private void initCategories() {
        if (categoryService.getCategories().isEmpty()) {
            categoryService.createCategory(new CategoryDto("Aventure"));
            categoryService.createCategory(new CategoryDto("Fps"));
            categoryService.createCategory(new CategoryDto("Metroidvania"));
            categoryService.createCategory(new CategoryDto("Rogue-like"));
        }
    }

    private void initEconomicModels() {
        if (economicModelService.getEconomicModels().isEmpty()) {
            economicModelService.createEconomicModel(new EconomicModelDto("Free to play"));
            economicModelService.createEconomicModel(new EconomicModelDto("Buy to play"));
            economicModelService.createEconomicModel(new EconomicModelDto("Abonnement"));
        }
    }

    private void initEditors() {
        if (editorService.getEditors().isEmpty()) {
            editorService.createEditor(new EditorDto("Epic games"));
            editorService.createEditor(new EditorDto("Blizzard"));
            editorService.createEditor(new EditorDto("Microsoft"));
        }
    }

    private void initPlatforms() {
        if (platformService.getPlatforms().isEmpty()) {
            platformService.createPlatform(new PlatformDto("Switch"));
            platformService.createPlatform(new PlatformDto("Pc"));
            platformService.createPlatform(new PlatformDto("Ps5"));
            platformService.createPlatform(new PlatformDto("Xbox series x"));
        }
    }

    public void initModerators() {
        if (userService.getModerators().isEmpty()) {
            ModeratorDto moderatorOne = new ModeratorDto("Moderator1", "azertyuiop", "moderator1@gmail.com", "0666666666");
            ModeratorDto moderatorTwo = new ModeratorDto("Moderator2", "qwertyuiop", "moderator2@gmail.com", "0412345678");
            ModeratorDto moderatorThree = new ModeratorDto("Moderator3", "123456789", "moderator3@gmail.com", "0800000000");

            userService.createModerator(moderatorOne);
            userService.createModerator(moderatorTwo);
            userService.createModerator(moderatorThree);
        }
    }

    public void initPlayers() {
        if (userService.getPlayers().isEmpty()) {
            PlayerDto playerOne = new PlayerDto("Player1", "azertyuiop", "player1@gmail.com", LocalDate.of(1995, Month.APRIL, 15));
            PlayerDto playerTwo = new PlayerDto("Player2", "qwertyuiop", "player2@gmail.com", LocalDate.of(1996, Month.JUNE, 2));
            PlayerDto playerThree = new PlayerDto("Player3", "123456789", "player3@gmail.com", LocalDate.of(1993, Month.DECEMBER, 30));

            userService.createPlayer(playerOne);
            userService.createPlayer(playerTwo);
            userService.createPlayer(playerThree);
        }
    }

    public void initGames() {
        if (gameService.getGames().isEmpty()) {
            GameDto game1 = new GameDto("FFXIV", "Un super mmo", LocalDate.of(2010, 1, 1), 1L, 1L, 1L, Arrays.asList(1L, 2L), 1L, 4L);
            GameDto game2 = new GameDto("Tomb Raider", "Une archéologue avec deux flingues", LocalDate.of(2000, 1, 1), 2L, 2L, 2L, Arrays.asList(1L), 1L, 5L);

            try {
                gameService.createGame(game1);
                gameService.createGame(game2);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
