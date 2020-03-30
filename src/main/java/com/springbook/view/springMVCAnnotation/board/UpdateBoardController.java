package com.springbook.view.springMVCAnnotation.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController {

	@RequestMapping("/model2/updateBoard.do")
	public String updateBoard(BoardDTO dto, BoardDAO boardDAO) {

		System.out.println("글 수정 처리");
		boardDAO.updateBoard(dto);
		return "getBoardList.do";
	}

}
