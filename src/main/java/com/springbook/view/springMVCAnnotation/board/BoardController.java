package com.springbook.view.springMVCAnnotation.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {

	//글 등록
	@RequestMapping(value="/model2/insertBoard.do")
	public String insertBoard(BoardDTO dto, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");

		boardDAO.insertBoard(dto);
		return "getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/model2/updateBoard.do")
	public String updateBoard(BoardDTO dto, BoardDAO boardDAO) {

		System.out.println("글 수정 처리");
		boardDAO.updateBoard(dto);
		return "getBoardList.do";
	}
	//글 삭제
	@RequestMapping("/model2/deleteBoard.do")
	public String deleteBoard(BoardDTO dto, BoardDAO boardDAO) {

		System.out.println("글 삭제 처리");
		boardDAO.deleteBoard(dto);

		return "getBoardList.do";
	}
	//글 상세 조회
	@RequestMapping("/model2/getBoard.do")
	public ModelAndView getBoard(BoardDTO dto, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");

		mav.addObject("board", boardDAO.getBoard(dto)); // Model 정보 저장
		mav.setViewName("getBoard.jsp"); // View 정보 저장
		return mav;
	}
	//글 목록 검색
	@RequestMapping("/model2/getBoardList.do")
	public ModelAndView getBoardList(BoardDTO dto, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");

		
		mav.addObject("boardList", boardDAO.getBoardList(dto)); //Model 정보 저장
		mav.setViewName("getBoardList.jsp"); //View 정보 저장
		
		return mav;
	}
	
}
