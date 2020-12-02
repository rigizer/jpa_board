package gd.fintech.jpatest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	// lombok 라이브러리 이용
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
	private Integer boardId;
	private String boardTitle;
	private String boardWriter;
}
