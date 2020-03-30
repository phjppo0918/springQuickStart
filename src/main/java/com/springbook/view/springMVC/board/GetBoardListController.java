package com.springbook.view.springMVC.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.springMVC.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");

		// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
		// 2. DB 연동 처리

		BoardDTO dto = new BoardDTO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> boardList = boardDAO.getBoardList(dto);

		// 3. 검색 결과를 세션에 저장하고 목록 화면을 리턴한다.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";

	}

}