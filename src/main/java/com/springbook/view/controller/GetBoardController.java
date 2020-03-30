package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");
		
		//1.검색할 게시글 번호 추출
		String seq = request.getParameter("seq");
		
		//2.DB 연동 처리
		return null;
	}

}
