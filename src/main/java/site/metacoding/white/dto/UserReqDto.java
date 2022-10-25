package site.metacoding.white.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white.domain.User;

public class UserReqDto { // 여기에 모든 Dto를 다 넣는다

    @Setter
    @Getter
    public static class JoinReqDto { // f로그인 전 로직들은 전부다 앞에 엔티티 안붙임. POST /user -> /join
        private String username;
        private String password;

        public User toEntity() {
            return User.builder().username(username).password(password).build(); // 마지마겡 빌드할 때 객체로 변환시켜준다
        }
    }

    @Setter // Dto는 변경 가능한 객체라고 약속함
    @Getter
    public static class LoginReqDto { // 내부 클래스 만드는데 외부에서 쓰고 싶을 때는 static을 붙이자. 내부에서 쓸 때는 안 붙여도 된다
        private String username;
        private String password;
    }

}