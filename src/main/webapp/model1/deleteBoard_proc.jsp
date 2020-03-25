<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 사용자 입력 정보 추출
	String seq = request.getParameter("seq");

	//2. DB 연동 처리
	BoardDTO dto = new BoardDTO();
	dto.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(dto);
	
	//3. 화면 네비게이션
	response.sendRedirect("getBoardList.jsp");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>