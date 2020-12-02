package gd.fintech.jpatest.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString	// lombok.jar
@NoArgsConstructor	// lombok.jar에 있는 애노테이션. default 생성자를 만들어주는 역할
@Entity(name = "board")	// 데이터베이스에 생성되는 테이블 이름
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// Database에서의 Auto Increment 옵션
	@Column(name = "board_id")	// 데이터베이스에 실제로 생성되는 컬럼 이름 (@Column: 일반 컬럼, @Id: primaryKey)
	private Integer boardId;	// 필드 이름
	
	@Column(name = "board_title", nullable = false, length = 500)
	private String boardTitle;
	
	@Column(name = "board_writer", nullable = false, length = 50)
	private String boardWriter;
	
	@Builder
	public Board(String boardTitle, String boardWriter) {
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
	}
}
