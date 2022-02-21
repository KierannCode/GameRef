package fr.orsys.groupe3.gamerefback.dao;

import fr.orsys.groupe3.gamerefback.business.Player;
import fr.orsys.groupe3.gamerefback.business.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDao extends JpaRepository<Review, Long> {
    Page<Review> findByPlayerOrModeratorIsNotNull(Player player, Pageable pageable);

    Page<Review> findByModeratorIsNotNull(Pageable pageable);

    Page<Review> findByModeratorIsNull(Pageable pageable);
}
