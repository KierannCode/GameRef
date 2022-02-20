package fr.orsys.groupe3.gamerefback.dao;

import fr.orsys.groupe3.gamerefback.business.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeratorDao extends JpaRepository<Moderator, Long> {
}
