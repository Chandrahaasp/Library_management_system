package org.cts.lms.repository;

import java.util.Optional;

import org.cts.lms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.userName = ?1")
	User findByName(String username);
	@Query("SELECT u FROM User u WHERE u.userName = ?1")
	Optional<User> findByUsername(String username);
}
