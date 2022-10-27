package site.metacoding.white.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity // 테이블 자동생성, 개발할 때는 자동으로 만들고 실제로 배포할 때는 테이블을 직접 만든다 개발할 때 쿼리들은 따로 복사해두고 나중에 fk만 지우고 고친다
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;

	// User 누가 썼는지
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	// Board 어디에 썼는지
	@ManyToOne(fetch = FetchType.LAZY)
	private Board board;

	@Builder
	public Comment(Long id, String content, User user, Board board) {
		this.id = id;
		this.content = content;
		this.user = user;
		this.board = board;
	}

}