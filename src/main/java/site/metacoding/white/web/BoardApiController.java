package site.metacoding.white.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.white.domain.Board;
import site.metacoding.white.service.BoardService;

// 앞으로 할 일
// 1. Entity -> Dto 변환
// 2. 다른 테이블과 fk 달아주기
// 3. return OK 말고 통일된 Dto 만들어주기 
// 4. 예외처리
// 5. 객체그래프 탐색

@RequiredArgsConstructor
@RestController
public class BoardApiController {

	private final BoardService boardService;

	@GetMapping("/board/{id}")
	public Board findById(@PathVariable long id) {
		return boardService.findById(id);
	}

	@GetMapping("/board")
	public List<Board> findAll() {
		List<Board> boardList = boardService.findAll();
		return boardList;
	}

	@PostMapping("/board")
	public String save(@RequestBody Board board) {
		boardService.save(board);
		return "OK";
	}

	@PutMapping("/board/{id}")
	public String update(@PathVariable Long id, @RequestBody Board board) {
		boardService.update(id, board);
		return "ok";
	}

	@DeleteMapping("/board/{id}")
	public String deleteById(@PathVariable Long id) {
		boardService.deleteById(id);
		return "ok";
	}

}