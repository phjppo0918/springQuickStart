package com.springbook.view.springMVCAnnotation.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController  {

	@RequestMapping("/model2/getBoardList.do")
	public ModelAndView handleRequest(BoardDTO dto, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");

		
		mav.addObject("boardList", boardDAO.getBoardList(dto)); //Model 정보 저장
		mav.setViewName("getBoardList.jsp"); //View 정보 저장
		
		return mav;
	}

}
