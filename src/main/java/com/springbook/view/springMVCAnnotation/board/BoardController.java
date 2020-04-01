package com.springbook.view.springMVCAnnotation.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {

	// 글 등록
	@RequestMapping(value = "/model2/insertBoard.do")
	public String insertBoard(BoardDTO dto, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");

		boardDAO.insertBoard(dto);
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping("/model2/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardDTO dto, BoardDAO boardDAO) {

		System.out.println("글 수정 처리");
		System.out.println("번호: "+dto.getSeq());
		System.out.println("제목: "+dto.getTitle());
		System.out.println("작성자: "+dto.getWriter());
		System.out.println("내용: "+dto.getContent());
		System.out.println("등록일: "+dto.getRegDate());
		System.out.println("조회수: "+dto.getCnt());
		boardDAO.updateBoard(dto);
		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/model2/deleteBoard.do")
	public String deleteBoard(BoardDTO dto, BoardDAO boardDAO) {

		System.out.println("글 삭제 처리");
		boardDAO.deleteBoard(dto);

		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/model2/getBoard.do")
	public ModelAndView getBoard(BoardDTO dto, BoardDAO boardDAO, ModelAndView mav, Model model) {
		System.out.println("글 상세 조회 처리");
		
		model.addAttribute("board",boardDAO.getBoard(dto)); // Model 정보 저장
		
		//mav.addObject("board", boardDAO.getBoard(dto)); // Model 정보 저장
		mav.setViewName("getBoard.jsp"); // View 정보 저장
		return mav;
	}

	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println("검색 조건 목록 처리");
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	// 글 목록 검색
	@RequestMapping("/model2/getBoardList.do")
	public ModelAndView getBoardList(
			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String Condition,
			BoardDTO dto, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");

		mav.addObject("boardList", boardDAO.getBoardList(dto)); // Model 정보 저장
		mav.setViewName("getBoardList.jsp"); // View 정보 저장

		return mav;
	}

}
