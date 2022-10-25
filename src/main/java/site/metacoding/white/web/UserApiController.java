package site.metacoding.white.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.dto.ResponseDto;
import site.metacoding.white.dto.SessionUser;
import site.metacoding.white.dto.UserReqDto.JoinReqDto;
import site.metacoding.white.dto.UserReqDto.LoginReqDto;
import site.metacoding.white.dto.UserRespDto.JoinRespDto;
import site.metacoding.white.service.UserService;

@RequiredArgsConstructor
@RestController
public class UserApiController {

	private final UserService userService;
	private final HttpSession session;

	// ResponseEntity => 상태를 줄 수 있어야 한다(코드등) 요청한 애에게 돌려줄 때는 header(json, xml이야등등)와
	// body(돌려주는 데이터)와 status (코드)
	@PostMapping("/join")
	public ResponseDto<?> save(@RequestBody JoinReqDto joinReqDto) {
		JoinRespDto joinRespDto = userService.save(joinReqDto);
		return new ResponseDto<>(1, "ok", joinRespDto); // 내가 insert한 데이터를 body로 돌려주게 해야 한다 , CREATED insert 됐을
														// 때 사용, 200은 잘 됐을 때
	}

	@PostMapping("/login")
	public ResponseDto<?> login(@RequestBody LoginReqDto loginReqDto) {
		SessionUser sessionUser = userService.login(loginReqDto);
		session.setAttribute("sessionUser", sessionUser);
		return new ResponseDto<>(1, "ok", sessionUser);
	}

}