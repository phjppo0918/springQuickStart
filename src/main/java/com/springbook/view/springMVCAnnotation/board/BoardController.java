package com.springbook.view.springMVCAnnotation.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 글 등록
	@RequestMapping(value = "/model2/insertBoard.do")
	public String insertBoard(BoardDTO dto) throws IOException {
		System.out.println("글 등록 처리");

		//파일 업로드 처리
		MultipartFile uploadFile = dto.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/" +fileName));
		}
		// boardDAO.insertBoard(dto);
		boardService.insertBoard(dto);
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping("/model2/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardDTO dto) {

		System.out.println("글 수정 처리");
		System.out.println("번호: " + dto.getSeq());
		System.out.println("제목: " + dto.getTitle());
		System.out.println("작성자: " + dto.getWriter());
		System.out.println("내용: " + dto.getContent());
		System.out.println("등록일: " + dto.getRegDate());
		System.out.println("조회수: " + dto.getCnt());

		// boardDAO.updateBoard(dto);
		boardService.updateBoard(dto);
		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/model2/deleteBoard.do")
	public String deleteBoard(BoardDTO dto) {

		System.out.println("글 삭제 처리");

		// boardDAO.deleteBoard(dto);
		boardService.deleteBoard(dto);
		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/model2/getBoard.do")
	public ModelAndView getBoard(BoardDTO dto, ModelAndView mav, Model model) {
		System.out.println("글 상세 조회 처리");

		// model.addAttribute("board",boardDAO.getBoard(dto)); // Model 정보 저장
		model.addAttribute("board", boardService.getBoard(dto)); // Model 정보 저장

		// mav.addObject("board", boardDAO.getBoard(dto)); // Model 정보 저장
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
	public ModelAndView getBoardList(BoardDTO dto, Model model, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");

		// Null Check
		if (dto.getSearchConditon() == null) {
			dto.setSearchConditon("TITLE");
		}
		if (dto.getSearchKeyword() == null) {
			dto.setSearchKeyword("");
		}
		
		// mav.addObject("boardList", boardDAO.getBoardList(dto)); // Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardList(dto));
		mav.setViewName("getBoardList.jsp"); // View 정보 저장

		return mav;
	}

}
