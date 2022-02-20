package fr.orsys.groupe3.gamerefback.dao;

import fr.orsys.groupe3.gamerefback.business.EconomicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EconomicModelDao extends JpaRepository<EconomicModel, Long> {
}
