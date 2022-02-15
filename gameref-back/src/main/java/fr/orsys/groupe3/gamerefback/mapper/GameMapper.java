package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.business.Platform;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class GameMapper {
    private AgeRatingService ageRatingService;
    private CategoryService categoryService;
    private EditorService editorService;
    private PlatformService platformService;
    private EconomicModelService economicModelService;
    private UserService userService;

    public Game mapGame(Game game, GameDto dto) {
        List<Platform> platforms = new ArrayList<>();
        for (Long platformId : dto.getPlatformIds()) {
            platforms.add(platformService.getPlatform(platformId));
        }
        game.setName(dto.getName());
        game.setDescription(dto.getDescription());
        game.setReleaseDate(dto.getReleaseDate());
        game.setAgeRating(ageRatingService.getAgeRating(dto.getAgeRatingId()));
        game.setEditor(editorService.getEditor(dto.getEditorId()));
        game.setCategory(categoryService.getcategory(dto.getCategoryId()));
        game.setEconomicModel(economicModelService.geteconomicModel(dto.getEconomicModelId()));
        game.setModerator(userService.getModerator(dto.getModeratorId()));
        game.setPlatforms(platforms);
        return game;
    }
}
