package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.dto.*;
import fr.orsys.groupe3.gamerefback.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
@AllArgsConstructor
public class InitController {

    private AgeRatingService ageRatingService;
    private CategoryService categoryService;
    private EconomicModelService economicModelService;
    private EditorService editorService;
    private PlatformService platformService;

    private void initAgeRatings() {
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
            editorService.createEditor(new EditorDto("Epic games"));
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

    @PostConstruct
    public void initAll() {

    }
}
