package fr.orsys.groupe3.gamerefback.dao;

import fr.orsys.groupe3.gamerefback.business.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformDao extends JpaRepository<Platform, Long> {
}
