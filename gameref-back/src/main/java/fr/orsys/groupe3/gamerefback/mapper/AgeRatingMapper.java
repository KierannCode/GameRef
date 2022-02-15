package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.AgeRating;
import fr.orsys.groupe3.gamerefback.dto.AgeRatingDto;
import org.springframework.stereotype.Component;

@Component
public class AgeRatingMapper {
    public AgeRating mapAgeRating(AgeRating ageRating, AgeRatingDto dto) {
        ageRating.setName(dto.getName());
        return ageRating;
    }
}
