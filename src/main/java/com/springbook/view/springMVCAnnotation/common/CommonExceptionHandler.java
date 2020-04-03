package com.springbook.view.springMVCAnnotation.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//xml 기반 예외처리를 위해 임시적으로 주석처리
//@ControllerAdvice("com.springbook.view.springMVCAnnotation")
public class CommonExceptionHandler {
	
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("../common/arithmeticError.jsp");
		return mav;
	} 

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("../common/nullPointerError.jsp");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("../common/error.jsp");
		return mav;
	}
}
