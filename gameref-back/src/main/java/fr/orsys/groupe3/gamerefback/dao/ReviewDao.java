package fr.orsys.groupe3.gamerefback.dao;

import fr.orsys.groupe3.gamerefback.business.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de la classe Review qui herite JpaRepository, permettant d'avoir acces aux methode de persistances  JPA ,Hibernate
 */
public interface ReviewDao extends JpaRepository<Review, Long> {
}
