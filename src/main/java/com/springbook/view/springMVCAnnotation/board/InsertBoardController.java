package com.springbook.view.springMVCAnnotation.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {

	@RequestMapping(value="/model2/insertBoard.do")
	public String insertBoard(BoardDTO dto, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");

	
		// 2. DB 연동 처리		
		boardDAO.insertBoard(dto);
		return "getBoardList.do";
	}

}
