package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContextDataSource.xml");

		// 2. Spring 컨테이너로부터 BoardServiceImpl 객체를 lookup 한다.
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 3. 글 등록 기능 테스트
		BoardDTO dto = new BoardDTO();
		dto.setTitle("안녕안녕Spring하세요~");
		dto.setWriter("사용자2");
		dto.setContent("하이하이 잘 부탁드립니당~");
		boardService.insertBoard(dto);

		// 4. 글 목록 검색 기능 테스트
		List<BoardDTO> boardList = boardService.getBoardList(dto);
		for (BoardDTO board : boardList) {
			System.out.println("--->" + board.toString());
		}

		// 5. Spring 컨테이너 종료
		container.close();
	}
}
