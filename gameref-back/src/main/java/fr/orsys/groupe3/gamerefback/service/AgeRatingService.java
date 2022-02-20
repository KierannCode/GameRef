package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.AgeRating;
import fr.orsys.groupe3.gamerefback.dto.AgeRatingDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgeRatingService {
    AgeRating createAgeRating(AgeRatingDto dto);

    AgeRating getAgeRating(Long id) throws NotFoundException;

    List<AgeRating> getAgeRatings();
}
