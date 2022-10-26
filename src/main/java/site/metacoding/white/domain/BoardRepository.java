package site.metacoding.white.domain;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardRepository {

	private final EntityManager em;

	public Board save(Board board) {
		em.persist(board);
		return board;
	}

	public Optional<Board> findById(Long id) {
		// JPQL 문법
		// Board boardPS = em.createQuery("select b from Board b where b.id = :id",
		// Board.class)
		// .setParameter("id", id)
		// .getSingleResult();

		// Board boardPS = (Board) em
		// .createNativeQuery("select * from board b inner join user u on b.user_id =
		// u.id where b.id = :id",
		// Board.class)
		// .setParameter("id", id)
		// .getSingleResult();

		// Board boardPS = em
		// .createQuery("select b from Board b join fetch b.user u where b.id = :id",
		// Board.class)
		// .setParameter("id", id)
		// .getSingleResult();

		Optional<Board> boardOP = Optional.ofNullable(em // null 에 대해 체크가 가능해서 nullpointexception 오류를 잡아낼 수 있다 => null이 들어오면 optional 박스 안에
				.createQuery("select b from Board b where b.id = :id",
						Board.class)
				.setParameter("id", id)
				.getSingleResult());

		return boardOP;
	}

	public List<Board> findAll() {
		// JPQL 문법
		List<Board> boardList = em.createQuery("select b from Board b", Board.class)
				.getResultList();
		return boardList;
	}

	public void deleteById(Long id) {
		em.createQuery("delete from Board b where b.id = :id")
				.setParameter("id", id)
				.executeUpdate();
	}

}