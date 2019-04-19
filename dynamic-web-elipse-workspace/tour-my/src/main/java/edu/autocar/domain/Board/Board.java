package edu.autocar.domain.Board;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int boardId;
	@NotEmpty(message="제목은 필수 항목입니다")
	private String title;
	@NotEmpty
	private String writer;
	@NotEmpty
	@Length(min=6)
	private String password;
	private String content;
	private int readCnt;
	private Date regDate;
	private Date updateDate;
	
	public Board(int boardId) {
		super();
		this.boardId = boardId;
		title = "제목" + boardId;
		writer = "홍길동 " + boardId;
		content = "내용 " + boardId;
		password = "123456";
		readCnt = 0;
		regDate = new Date();
		updateDate = new Date();
	}
}

	
