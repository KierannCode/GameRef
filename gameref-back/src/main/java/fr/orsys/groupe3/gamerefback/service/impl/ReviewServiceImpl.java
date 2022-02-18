package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.Game;
import fr.orsys.groupe3.gamerefback.business.Review;
import fr.orsys.groupe3.gamerefback.dao.ReviewDao;
import fr.orsys.groupe3.gamerefback.dto.ReviewDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.mapper.ReviewMapper;
import fr.orsys.groupe3.gamerefback.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewMapper reviewMapper;
    private ReviewDao reviewDao;
    @Override
    public Review createReview(ReviewDto dto) throws NotFoundException {

        Review review = new Review();
        reviewMapper.mapReview(review, dto);
        return reviewDao.save(review);
    }

    @Override
    public Page<Review> getReviews(Pageable pageable) {
        return reviewDao.findAll(pageable);
    }

    @Override
    public List<Review> getReviews() {
        return reviewDao.findAll();
    }

    @Override
    public Review getReview(Long id) throws NotFoundException {
        return reviewDao.findById(id).orElseThrow(() -> new NotFoundException("No Review found with id " + id));
    }

    @Override
    public Review deleteReview(Long id) throws NotFoundException {
        Review review = reviewDao.findById(id).orElseThrow(()->new NotFoundException("No review found with id :" +id));
        reviewDao.deleteById(id);
        return review;
    }

    @Override
    public Review updateReview(Long id, ReviewDto dto) throws NotFoundException {
        Review review = reviewDao.findById(id).orElseThrow(() -> new NotFoundException("No game found with id " + id));
        reviewMapper.mapReview(review, dto);
        return reviewDao.save(review);

    }
}
