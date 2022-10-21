package site.metacoding.white.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@Column(length = 1000)
	private String content;
	private String author;
	// 하이버네이트라는 기술을 들고 있는데 이 기술의 첫 번째는 테이블을 자동생성해준다
	// 프라이머리키가 자동으로 붙는다
	// 255 바이트가 나오고 콘텐트는 바차가 1000인걸로 만들어 질 것이다
}
