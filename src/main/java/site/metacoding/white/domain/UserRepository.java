package site.metacoding.white.domain;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository // IoC 등록
public class UserRepository {

	// DI
	private final EntityManager em;

	public User save(User user) { // 여기 User는 그냥 User인데 em.persist에 들어가면 영속화 된다 flush 이후에 동기화를 한다
		// Persistence Context에 영속화 시키기 -> 자동 flush (트랜잭션 종료시)
		System.out.println("ccc: " + user.getId()); // 아래와 같은 객체인데 영속화 전
		em.persist(user);
		System.out.println("ccc: " + user.getId()); // 영속화 후
		return user;
	}

	public User findByUsername(String username) {
		return em.createQuery("select u from User u where u.username=:username", User.class)
				.setParameter("username", username)
				.getSingleResult();
	}
// 바자 오브젝트와 테이블 로우 한줄을 지속적으로 감지하면서 자동으로 맵핑되어 있다 우리는 PersistContext에 넣기만 하면 된다 계속 객체를 추적한다
}
