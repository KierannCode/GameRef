package fr.orsys.groupe3.gamerefback.dao;

import fr.orsys.groupe3.gamerefback.business.AgeRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeRatingDao extends JpaRepository<AgeRating, Long> {
}
