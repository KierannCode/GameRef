package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.AgeRating;
import fr.orsys.groupe3.gamerefback.dto.AgeRatingDto;
import org.springframework.stereotype.Service;

@Service
public interface AgeRatingService {
    public AgeRating createAgeRating(AgeRatingDto dto);
}
