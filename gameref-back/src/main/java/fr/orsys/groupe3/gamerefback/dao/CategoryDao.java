package fr.orsys.groupe3.gamerefback.dao;

import fr.orsys.groupe3.gamerefback.business.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Long> {

}
