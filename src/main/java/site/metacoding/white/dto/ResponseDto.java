package site.metacoding.white.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ResponseDto<R> { // 응답할 때는 R 사용
	private Integer code;
	private String msg;
	private R data;

}
