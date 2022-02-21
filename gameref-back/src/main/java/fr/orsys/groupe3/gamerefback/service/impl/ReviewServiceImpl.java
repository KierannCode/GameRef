package fr.orsys.groupe3.gamerefback.service.impl;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.business.Review;
import fr.orsys.groupe3.gamerefback.business.User;
import fr.orsys.groupe3.gamerefback.dao.ReviewDao;
import fr.orsys.groupe3.gamerefback.business.dto.ReviewDto;
import fr.orsys.groupe3.gamerefback.exception.NotFoundException;
import fr.orsys.groupe3.gamerefback.business.mapper.ReviewMapper;
import fr.orsys.groupe3.gamerefback.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private ReviewMapper reviewMapper;

    private ReviewDao reviewDao;

    @Override
    public Review createReview(ReviewDto dto, Player player) throws NotFoundException {
        Review review = new Review();
        reviewMapper.mapReview(review, dto);
        review.setSubmitDate(LocalDateTime.now());
        review.setPlayer(player);
        return reviewDao.save(review);
    }

    @Override
    public Review validateReview(Long id, Moderator moderator) throws NotFoundException {
        Review review = getReview(id);
        review.setModerationDate(LocalDateTime.now());
        review.setModerator(moderator);
        return reviewDao.save(review);
    }

    @Override
    public Review deleteReview(Long id, User user) throws NotFoundException, SecurityException {
        Review review = getReview(id);
        if (user instanceof Player && user.getId() != review.getPlayer().getId()) {
            throw new SecurityException("Impossible de supprimer l'avis d'un autre joueur");
        }
        reviewDao.deleteById(id);
        return review;
    }

    @Override
    public Review getReview(Long id) throws NotFoundException {
        return reviewDao.findById(id).orElseThrow(() -> new NotFoundException("review", "Aucun avis trouvé avec l'id " + id));
    }

    @Override
    public Page<Review> getReviews(Pageable pageable, User user) {
        switch (user.getRole()) {
            case "Player":
                return reviewDao.findByPlayerOrModeratorIsNotNull((Player) user, pageable);
            case "Moderator":
                return reviewDao.findAll(pageable);
        }
        return Page.empty();
    }

    @Override
    public List<Review> getReviews() {
        return reviewDao.findAll();
    }
}
