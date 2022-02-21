package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.business.Review;
import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.business.dto.ReviewDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface contenant l'ensemble des methodes metiers
 */
@Service
public interface ReviewService {
    Review createReview(ReviewDto dto, Player player) throws NotFoundException;

    Review validateReview(Long id, Moderator moderator) throws NotFoundException;

    Review deleteReview(Long id, User user) throws NotFoundException, SecurityException;

    Review getReview(Long id) throws NotFoundException;

    Page<Review> getReviews(Pageable pageable);

    List<Review> getReviews();
}
