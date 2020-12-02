package gd.fintech.jpatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gd.fintech.jpatest.dto.BoardDto;
import gd.fintech.jpatest.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 게시물 목록
	@GetMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardDtoList", boardService.getBoardList());
		return "boardList";
	}
	
	// 게시물 추가 Form
	@GetMapping("/addBoard")
	public String addBoard() {
		return "addBoard";
	}
	
	// 게시물 추가 Action
	@PostMapping("/addBoard")
	public String addBoard(BoardDto boardDto) {
		System.out.println(boardDto);
		
		boardService.addBoard(boardDto);
		
		return "redirect:/boardList";
	}
	
	// 게시물 조회
	@GetMapping("/boardOne/{boardId}")
	public String boardOne(Model model, 
			@PathVariable(value = "boardId") int boardId) {
		System.out.println("Debug: boardOne 실행");
		System.out.println("Debug: boardId[" + boardId + "]");
		
		model.addAttribute("board", boardService.getBoardOne(boardId));
		
		return "boardOne";
	}
	
	// 게시물 삭제
	@GetMapping("/deleteBoard/{boardId}")
	public String deleteBoard(@PathVariable(value = "boardId") int boardId) {
		System.out.println("Debug: deleteBoard 실행");
		System.out.println("Debug: boardId[" + boardId + "]");
		
		boardService.removeBoard(boardId);
		
		return "redirect:/boardList"; 
	}
	
	// 게시물 수정 Form
	@GetMapping("/modifyBoard/{boardId}")
	public String modifyBoard(Model model, 
			@PathVariable(value = "boardId") int boardId) {
		System.out.println("Debug: modifyBoard 실행");
		System.out.println("Debug: boardId[" + boardId + "]");
		
		model.addAttribute("board", boardService.getBoardOne(boardId));
		
		return "modifyBoard";
	}
	
	// 게시물 수정 Action
	@PostMapping("/modifyBoard")
	public String modifyBoard(BoardDto boardDto) {
		System.out.println(boardDto);
		
		boardService.modifyBoard(boardDto);
		
		return "redirect:/boardOne/" + boardDto.getBoardId();
	}
}
