package fr.orsys.groupe3.gamerefback.business.mapper;

import fr.orsys.groupe3.gamerefback.business.AgeRating;
import fr.orsys.groupe3.gamerefback.business.dto.AgeRatingDto;
import org.springframework.stereotype.Component;

@Component
public class AgeRatingMapper {
    public AgeRating mapAgeRating(AgeRating ageRating, AgeRatingDto dto) {
        if (dto.getName() != null) {
            ageRating.setName(dto.getName());
        }
        return ageRating;
    }
}
