package fr.orsys.groupe3.gamerefback.mapper;

import fr.orsys.groupe3.gamerefback.business.Review;
import fr.orsys.groupe3.gamerefback.dto.ReviewDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReviewMapper {
    private GameService gameService;

    public Review mapReview(Review review, ReviewDto dto) throws NotFoundException {
        if (dto.getDescription() != null) {
            review.setDescription(dto.getDescription());
        }
        if (dto.getRating() != null) {
            review.setRating(dto.getRating());
        }
        if (dto.getGameId() != null) {
            review.setGame(gameService.getGame(dto.getGameId()));
        }
        return review;
    }
}
