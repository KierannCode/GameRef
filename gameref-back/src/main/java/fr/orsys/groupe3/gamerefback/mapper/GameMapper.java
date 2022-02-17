package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.business.Platform;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
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

    public Game mapGame(Game game, GameDto dto) throws NotFoundException {
        if (dto.getName() != null) {
            game.setName(dto.getName());
        }
        if (dto.getDescription() != null) {
            game.setDescription(dto.getDescription());
        }
        if (dto.getReleaseDate() != null) {
            game.setReleaseDate(dto.getReleaseDate());
        }
        if (dto.getAgeRatingId() != null) {
            game.setAgeRating(ageRatingService.getAgeRating(dto.getAgeRatingId()));
        }
        if (dto.getEditorId() != null) {
            game.setEditor(editorService.getEditor(dto.getEditorId()));
        }
        if (dto.getCategoryId() != null) {
            game.setCategory(categoryService.getCategory(dto.getCategoryId()));
        }
        if (dto.getEconomicModelId() != null) {
            game.setEconomicModel(economicModelService.getEconomicModel(dto.getEconomicModelId()));
        }
        if (dto.getPlatformIds() != null) {
            List<Platform> platforms = new ArrayList<>();
            for (Long platformId : dto.getPlatformIds()) {
                platforms.add(platformService.getPlatform(platformId));
            }
            game.setPlatforms(platforms);
        }
        return game;
    }
}
