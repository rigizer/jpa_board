package gd.fintech.jpatest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gd.fintech.jpatest.dto.BoardDto;
import gd.fintech.jpatest.repository.Board;
import gd.fintech.jpatest.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public List<BoardDto> getBoardList() {
		List<Board> boardList = boardRepository.findAll();
		List<BoardDto> boardDtoList = new ArrayList<>();
		
		for(Board b : boardList) {
			BoardDto bd = new BoardDto(b.getBoardId(), b.getBoardTitle(), b.getBoardWriter());
			boardDtoList.add(bd);
		}
		
		return boardDtoList;
	}
	
	@Transactional
	public void addBoard(BoardDto boardDto) {
		boardRepository.save(Board.builder()
				.boardTitle(boardDto.getBoardTitle())
				.boardWriter(boardDto.getBoardWriter())
				.build());
	}
	
	@Transactional
	public BoardDto getBoardOne(int boardId) {
		Board board = boardRepository.getOne(boardId);
		BoardDto boardDto = new BoardDto(board.getBoardId(), board.getBoardTitle(), board.getBoardWriter());
		
		return boardDto;
	}
	
	@Transactional
	public void removeBoard(int boardId) {
		boardRepository.deleteById(boardId);
	}
	
	@Transactional
	public void modifyBoard(BoardDto boardDto) {
		Board board = boardRepository.getOne(boardDto.getBoardId());
		
		board.setBoardId(boardDto.getBoardId());
		board.setBoardTitle(boardDto.getBoardTitle());
		board.setBoardWriter(boardDto.getBoardWriter());
	}
}
