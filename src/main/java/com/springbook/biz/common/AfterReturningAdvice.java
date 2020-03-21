package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserDTO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnObj")
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
