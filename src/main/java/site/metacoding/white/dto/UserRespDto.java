package site.metacoding.white.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white.domain.User;

//  응답을 Dto로 한다

public class UserRespDto {

    @Setter
    @Getter
    public static class JoinRespDto {
        private Long id;
        private String username;

        // 응답의 DTO는 생성자로 처리한다.
        public JoinRespDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }
    }

    @Setter
    @Getter
    public static class UserAllRespDto {

        private String username;

        // 응답의 DTO는 생성자로 처리한다.
        public UserAllRespDto(User user) {
            this.username = user.getUsername();
        }
    }

    @Setter
    @Getter
    public static class UserUpdateRespDto {

        private String username;
        private String password;

        // 응답의 DTO는 생성자로 처리한다.
        public UserUpdateRespDto(User user) {
            this.username = user.getUsername();
            this.password = user.getPassword();
        }
    }

    @Setter
    @Getter
    public static class UserDetailRespDto {

        private String username;

        // 응답의 DTO는 생성자로 처리한다.
        public UserDetailRespDto(User user) {
            this.username = user.getUsername();
            
        }
    }

}