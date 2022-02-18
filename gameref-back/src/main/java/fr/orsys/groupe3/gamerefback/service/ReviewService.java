package fr.orsys.groupe3.gamerefback.service;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.business.Review;
import fr.orsys.groupe3.gamerefback.dto.GameDto;
import fr.orsys.groupe3.gamerefback.dto.ReviewDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {


    Review createReview(ReviewDto dto) throws NotFoundException;

    Page<Review> getReviews(Pageable pageable);
    List<Review> getReviews();
    Review getReview(Long id) throws NotFoundException;

    Review deleteReview(Long id) throws NotFoundException;

    Review updateReview(Long id, ReviewDto dto) throws NotFoundException;
}
