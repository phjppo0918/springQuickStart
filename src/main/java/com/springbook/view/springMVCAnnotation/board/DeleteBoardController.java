package com.springbook.view.springMVCAnnotation.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {

	@RequestMapping("/model2/deleteBoard.do")
	public String deleteBoard(BoardDTO dto, BoardDAO boardDAO) {

		System.out.println("글 삭제 처리");
		boardDAO.deleteBoard(dto);

		return "getBoardList.do";
	}
}
