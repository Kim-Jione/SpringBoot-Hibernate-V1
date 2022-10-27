package site.metacoding.white.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.dto.BoardReqDto.BoardSaveReqDto;
import site.metacoding.white.dto.BoardReqDto.BoardUpdateReqDto;
import site.metacoding.white.dto.BoardRespDto.BoardSaveRespDto;
import site.metacoding.white.dto.ResponseDto;
import site.metacoding.white.dto.SessionUser;
import site.metacoding.white.service.BoardService;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

	private final BoardService boardService;
	private final HttpSession session;

	@PostMapping("/board")
	public ResponseDto<?> save(@RequestBody BoardSaveReqDto boardSaveReqDto) {
		SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
		boardSaveReqDto.setSessionUser(sessionUser);
		BoardSaveRespDto boardSaveRespDto = boardService.save(boardSaveReqDto); // 서비스에는 단 하나의 객체만 전달한다, sesstionUser를
																				// 따로 더 받아도 되지만 일관성을 지켜야 한다
		return new ResponseDto<>(1, "성공", boardSaveRespDto);
	}

	// 게시글 상세보기 (Board + User + List<Comment>)
	@CrossOrigin // 자바스크립트는 스프링에게 Ajax 요청을 할 수 없다 <- 이 정책에서 벗어날 수 있다
	@GetMapping("/board/{id}")
	public ResponseDto<?> findById(@PathVariable Long id) { // ? = Object를 의미한다, extends Object
		return new ResponseDto<>(1, "성공", boardService.findById(id));
	}

	@GetMapping("/board")
	public ResponseDto<?> findAll() {
		return new ResponseDto<>(1, "성공", boardService.findAll());
	}

	@PutMapping("/board/{id}")
	public ResponseDto<?> update(@PathVariable Long id, @RequestBody BoardUpdateReqDto boardUpdateReqDto) {
		boardUpdateReqDto.setId(id);
		return new ResponseDto<>(1, "성공", boardService.update(boardUpdateReqDto));
	}

	@DeleteMapping("/board/{id}")
	public ResponseDto<?> deleteById(@PathVariable Long id) {
		boardService.deleteById(id);
		return new ResponseDto<>(1, "성공", null);
	}

	// @GetMapping("/v2/board/{id}")
	// public String findByIdV2(@PathVariable Long id) {
	// System.out.println("현재 open-in-view는 true 인가 false 인가 생각해보기!!");
	// Board boardPS = boardService.findById(id);
	// System.out.println("board.id : " + boardPS.getId());
	// System.out.println("board.title : " + boardPS.getTitle());
	// System.out.println("board.content : " + boardPS.getContent());
	// System.out.println("board.user.username : " +
	// boardPS.getUser().getUsername());
	// System.out.println("open-in-view가 false이면 Lazy 로딩 못함");

	// em.createNativeQuery("select * from board b inner join user u on b.user_id =
	// u.id where b.id=:id",Board.class).setParameter("id",id).getSingleResult();

	// // 날라감)
	// return "ok";
	// }
}