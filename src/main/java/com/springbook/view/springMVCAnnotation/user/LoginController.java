package com.springbook.view.springMVCAnnotation.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserDTO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/model2/login.do", method = RequestMethod.GET)
	public String loginView(UserDTO dto) {
		System.out.println("로그인 화면으로 이동");
		dto.setId("test");
		dto.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value = "/model2/login.do", method = RequestMethod.POST)
	public String login(UserDTO dto, UserDAO userDAO, HttpSession session) {
		System.out.println("로그인 인증 처리...");
		//아이디 미입력시 예외처리
		if(dto.getId() ==null || dto.getId().contentEquals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다");
		}
		
		UserDTO user =userDAO.getUser(dto);
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}

}
