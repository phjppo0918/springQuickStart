package com.springbook.view.springMVC.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserDTO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");

		// 1. 사용자 입력 정보 추출

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DB 연동 처리

		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserDTO user = userDAO.getUser(dto);

		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			mav.setViewName("redirect:getBoardList.do");
		} else {
			mav.setViewName("redirect:login.jsp");
		}

		return mav;
	}

}
