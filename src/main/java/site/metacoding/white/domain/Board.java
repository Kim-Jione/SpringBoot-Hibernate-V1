package site.metacoding.white.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter // 하이버네이트라는 기술을 들고 있는데 이 기술의 첫 번째는 테이블을 자동생성해준다
@Getter
@Entity //
public class Board {
	@Id // 프라이머리키가 자동으로 붙는다
	@GeneratedValue // 오토 인크리멘티, 엔티티 만들면 테이블이 자동으로 생성됨
	private Long id; // 8바이트
	private String title; // 바차 사이즈는 기본으로 255바이트 정도 들어간다 약 150~200자, 바이트 설정은
	@Column(length = 1000) // Board 라는 테이블이 만들어지고 id가 만들어지는데 프라이머리키로 잡고 오토가 걸린 코드로 나올 것이다 .그리고 타이틀이 만등러지는데
							// 255 바이트가 나오고 콘텐트는 바차가 1000인걸로 만들어 질 것이다
	private String content;
}
