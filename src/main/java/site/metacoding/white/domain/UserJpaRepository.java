package site.metacoding.white.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserJpaRepository extends JpaRepository<User, Long> { // JpaRepository 붙이면 IOC에 뜬다

	// @Query(value = "select u from User u where u.username = :username")
	User findByUsername(@Param("username") String username);
	// findByEmail, findByGender
}
