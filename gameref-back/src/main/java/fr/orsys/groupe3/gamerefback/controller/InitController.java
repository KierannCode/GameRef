package fr.orsys.groupe3.gamerefback.controller;

import fr.orsys.groupe3.gamerefback.dto.AgeRatingDto;
import fr.orsys.groupe3.gamerefback.service.AgeRatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
@AllArgsConstructor
public class InitController {

    AgeRatingService ageRatingService;

    @PostConstruct
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
}
