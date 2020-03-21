package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

import com.springbook.biz.user.UserDTO;

public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		System.out.println("[사후 처리] 비즈니스 로직 수행 후 동작");

		String method = jp.getSignature().getName();
		if (returnObj instanceof UserDTO) {
			UserDTO user = (UserDTO) returnObj;
			if (user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "로그인(Admin)");
			}else {
				System.out.println(user.getName() + "로그인(user)");
			}
		}
		System.out.println("[사후 처리] " + method + "()메소드 리턴값 : " + returnObj.toString());
	}
}
