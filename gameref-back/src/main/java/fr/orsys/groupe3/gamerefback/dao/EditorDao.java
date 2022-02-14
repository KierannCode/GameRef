package fr.orsys.groupe3.gamerefback.dao;

import fr.orsys.groupe3.gamerefback.business.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorDao extends JpaRepository<Editor,Long> {
}
