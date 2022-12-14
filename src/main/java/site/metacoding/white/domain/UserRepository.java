package site.metacoding.white.domain;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Repository // IoC 등록
public class UserRepository {

	// DI
	private final EntityManager em;

	public User save(User user) {
		// Persistence Context에 영속화 시키기 -> 자동 flush (트랜잭션 종료시)
		log.debug("디버그 : " + user.getId());
		em.persist(user);
		log.debug("디버그 : " + user.getId());
		return user;
	}

	public User findByUsername(String username) {
		return em.createQuery("select u from User u where u.username=:username", User.class)
				.setParameter("username", username)
				.getSingleResult();
	}

	public Optional<User> findById(Long id) {
		try {
			Optional<User> userOP = Optional.of(em
					.createQuery("select b from User b where b.id = :id",
							User.class)
					.setParameter("id", id)
					.getSingleResult());
			return userOP;
		} catch (Exception e) {
			return Optional.empty();
		}

	}

	public List<User> findAll() {
		List<User> userList = em.createQuery("select b from User b", User.class).getResultList();
		return userList;
	}

}