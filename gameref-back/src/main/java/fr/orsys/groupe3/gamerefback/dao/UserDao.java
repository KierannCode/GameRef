package fr.orsys.groupe3.gamerefback.dao;

import fr.orsys.groupe3.gamerefback.business.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
