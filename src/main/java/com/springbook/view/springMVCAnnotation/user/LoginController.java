package com.springbook.view.springMVCAnnotation.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserDTO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping("/model2/login.do")
	public String login(UserDTO dto, UserDAO userDAO) {
		System.out.println("로그인 처리");

		if (userDAO.getUser(dto) != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}

}
