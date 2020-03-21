package com.springbook.biz.user.impl;

import com.springbook.biz.user.UserDTO;
import com.springbook.biz.user.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	
	public UserDTO getUser(UserDTO dto) {
		return userDAO.getUser(dto);
	}


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
