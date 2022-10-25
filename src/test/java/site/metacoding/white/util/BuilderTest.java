package site.metacoding.white.util;

import org.junit.jupiter.api.Test;

class MyUser {
	private Long id;
	private String username;
	private String password;

	public MyUser id(Long id) {
		this.id = id;
		return this;
	}

	public MyUser username(String username) {
		this.username = username;
		return this;
	}

	public MyUser password(String password) {
		this.password = password;
		return this;
	}

	public static MyUser builder() {
		return new MyUser();
	}
}

public class BuilderTest {

	@Test
	public void 빌더_테스트() {
		MyUser.builder().id(1L).username("ssar").password("1234");
	}
}// 1. 순서가 필요없다 2. 컴파일시 에러가 잡힌다 3. 원하는 값만 넣어줄 수 있다 실제로는 .build 는 빌드한걸 객체로 변환시켜준다
