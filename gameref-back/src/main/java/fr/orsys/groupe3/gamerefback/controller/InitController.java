package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.dto.*;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.exception.PseudoAlreadyTakenException;
import fr.orsys.groupe3.gamerefback.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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
    private ReviewService reviewService;

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
        initReviews();
    }

    public void initAgeRatings() {
        if (ageRatingService.getAgeRatings().isEmpty()) {
            ageRatingService.createAgeRating(new AgeRatingDto("PEGI 3"));
            ageRatingService.createAgeRating(new AgeRatingDto("PEGI 7"));
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
            categoryService.createCategory(new CategoryDto("RPG"));
            categoryService.createCategory(new CategoryDto("MmoRPG"));
            categoryService.createCategory(new CategoryDto("Combat"));
            categoryService.createCategory(new CategoryDto("Plateforme"));
            categoryService.createCategory(new CategoryDto("Bac à sable"));
            categoryService.createCategory(new CategoryDto("Course"));
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
            editorService.createEditor(new EditorDto("Square Enix"));
            editorService.createEditor(new EditorDto("Moon Studios"));
            editorService.createEditor(new EditorDto("Nintendo"));
            editorService.createEditor(new EditorDto("Extremely OK Games"));
            editorService.createEditor(new EditorDto("Mojang Studios"));
            editorService.createEditor(new EditorDto("Team Cherry"));
            editorService.createEditor(new EditorDto("Bandai Namco"));
        }
    }

    private void initPlatforms() {
        if (platformService.getPlatforms().isEmpty()) {
            platformService.createPlatform(new PlatformDto("Switch"));
            platformService.createPlatform(new PlatformDto("Pc"));
            platformService.createPlatform(new PlatformDto("Playstation"));
            platformService.createPlatform(new PlatformDto("Xbox"));
            platformService.createPlatform(new PlatformDto("Android"));
        }
    }

    public void initPlayers() {
        if (userService.getPlayers().isEmpty()) {
            try {
                userService.createPlayer(new PlayerDto("Player1", "azertyuiop", "player1@gmail.com", LocalDate.of(1995, Month.APRIL, 15)));
                userService.createPlayer(new PlayerDto("Player2", "qwertyuiop", "player2@gmail.com", LocalDate.of(1996, Month.JUNE, 2)));
                userService.createPlayer(new PlayerDto("player", "12345678", "player3@gmail.com", LocalDate.of(1993, Month.DECEMBER, 30)));
            } catch (PseudoAlreadyTakenException e) {
                System.out.println("Players initialization failed : " + e.getMessage());
            }
        }
    }

    public void initModerators() {
        if (userService.getModerators().isEmpty()) {
            userService.createModerator(new ModeratorDto("Moderator1", "azertyuiop", "moderator1@gmail.com", "0666666666"));
            userService.createModerator(new ModeratorDto("Moderator2", "qwertyuiop", "moderator2@gmail.com", "0412345678"));
            userService.createModerator(new ModeratorDto("modo", "12345678", "moderator3@gmail.com", "0800000000"));
        }
    }

    public void initGames() {
        if (gameService.getGames().isEmpty()) {
            GameDto game1 = new GameDto("Final Fantasy XIV", "Explorer Éorzéa avec de nombreux compagnons", LocalDate.of(2010, Month.SEPTEMBER, 30), 4L, 6L, 4L, List.of(2L, 3L), 3L);
            GameDto game2 = new GameDto("Zelda : Breath Of The Wild", "Partez à l'aventure en incarnant Zel...Link, et confrontez-vous une nouvelle fois au mal qui ronge le monde", LocalDate.of(2017, Month.MARCH, 3), 3L, 1L, 6L, List.of(1L), 2L);
            GameDto game3 = new GameDto("Hollow Knight", "Sautez dans tous les sens avec un insecte agile", LocalDate.of(2017, Month.FEBRUARY, 24), 1L, 3L, 9L, List.of(2L), 2L);
            GameDto game4 = new GameDto("Minecraft", "Minecraft, ou comment faire suer votre carte graphique dernier cri avec des cubes", LocalDate.of(2011, Month.NOVEMBER, 18), 2L, 9L, 8L, List.of(2L, 4L), 2L);
            GameDto game5 = new GameDto("Céleste", "Accompagnez Madeline dans son escalade sans fin", LocalDate.of(2018, Month.JANUARY, 25), 2L, 8L, 7L, List.of(2L), 2L);
            GameDto game6 = new GameDto("Final Fantasy VII", "Suivez l'histoire d'un mercenaire avec une épée beaucoup trop grosse pour lui", LocalDate.of(1997, Month.JANUARY, 31), 3L, 5L, 4L, List.of(2L, 3L, 5L), 2L);
            GameDto game7 = new GameDto("Tomb Raider", "Une archéologue avec deux flingues, que demander de plus ?", LocalDate.of(2013, Month.MARCH, 5), 1L, 1L, 4L, List.of(2L, 3L, 4L), 2L);
            GameDto game8 = new GameDto("Pokémon Go", "Attrapez-les (presque) tous ! Et (presque) en vrai !", LocalDate.of(2016, Month.JULY, 6), 1L, 1L, 6L, List.of(5L), 2L);
            GameDto game9 = new GameDto("Mario Kart 8", "Si vous ralez à cause des carapaces bleues, c'est que vous n'êtes pas si mauvais que ça !", LocalDate.of(2017, Month.APRIL, 28), 1L, 10L, 6L, List.of(1L), 2L);
            GameDto game10 = new GameDto("Soulcalibur 6", "Hadoken ! Ah non, mauvais jeu...", LocalDate.of(2018, Month.OCTOBER, 19), 3L, 7L, 10L, List.of(3L, 4L), 2L);
            GameDto game11 = new GameDto("Ori", "Encore une petite bestiole brillante qui saute dans tous les sens", LocalDate.of(2015, Month.MARCH, 11), 2L, 1L, 5L, List.of(2L), 2L);
            GameDto game12 = new GameDto("Vagrant Story", "Découvrez Léamundis, la ville de tous les secrets", LocalDate.of(2000, Month.FEBRUARY, 10), 3L, 5L, 4L, List.of(3L), 2L);
            try {
                Moderator moderator = userService.getModerator(6L);
                gameService.createGame(game1, moderator);
                gameService.createGame(game2, moderator);
                gameService.createGame(game3, moderator);
                gameService.createGame(game4, moderator);
                gameService.createGame(game5, moderator);
                gameService.createGame(game6, moderator);
                gameService.createGame(game7, moderator);
                gameService.createGame(game8, moderator);
                gameService.createGame(game9, moderator);
                gameService.createGame(game10, moderator);
                gameService.createGame(game11, moderator);
                gameService.createGame(game12, moderator);
            } catch (NotFoundException e) {
                System.out.println("Games initialization failed : " + e.getMessage());
            }
        }
    }

    public void initReviews() {
        if (reviewService.getReviews().isEmpty()) {
            ReviewDto review1 = new ReviewDto("Je trouve ce jeu trop balaise", 18F, 2L);
            ReviewDto review2 = new ReviewDto("Jeu très moyen ", 10F, 5L);
            ReviewDto review3 = new ReviewDto("Excellent scenario du debut à la fin", 20F, 1L);
            ReviewDto review4 = new ReviewDto("Nul, nul, et nul!", 5F, 10L);
            ReviewDto review5 = new ReviewDto("Graphismes à améliorer, mais je me suis bien amusé", 18F, 2L);
            try {
                reviewService.createReview(review1, userService.getPlayer(1L));
                reviewService.createReview(review2, userService.getPlayer(2L));
                reviewService.createReview(review3, userService.getPlayer(1L));
                reviewService.createReview(review4, userService.getPlayer(3L));
                reviewService.createReview(review5, userService.getPlayer(3L));
            } catch (NotFoundException e) {
                System.out.println("Reviews initialization failed : " + e.getMessage());
            }
        }
    }
}
