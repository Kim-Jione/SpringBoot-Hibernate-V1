package site.metacoding.white.domain;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.service.BoardService;

@Repository // IOC 컨테이너 등록
@RequiredArgsConstructor
public class BoardRepository {

	private final EntityManager em; // 하이버네이트 기술, DB에서 들고온 오브젝트를 타입이 다르니 자바 오브젝트로 바꿔준다 => 더 편하게 해줌

	public void save(Board board) {

		em.persist(board); // insert

	}

	public Board findById(Long id) {
		Board boardPS = em.createQuery("select b from Board b where b.id=:id", Board.class)
				.setParameter("id", id)
				.getSingleResult();
		return boardPS;
	}

	public List<Board> findAll() {
		List<Board> boardList = em.createQuery("select b from Board b ", Board.class)
				.getResultList();
		return boardList;
	}

	public void deleteById(Long id) {
		em.createQuery("delete from Board b where b.id = :id")
				.setParameter("id", id)
				.executeUpdate();
	}
}
