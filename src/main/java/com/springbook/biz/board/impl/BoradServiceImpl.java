package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.board.BoardService;

@Service("boardService")
public class BoradServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	public void insertBoard(BoardDTO dto) {
		boardDAO.insertBoard(dto);
		
	}

	public void updateBoard(BoardDTO dto) {
		boardDAO.updateBoard(dto);
		
	}

	public void deleteBoard(BoardDTO dto) {
		boardDAO.deleteBoard(dto);
		
	}

	public BoardDTO getBoard(BoardDTO dto) {
		return boardDAO.getBoard(dto);
	}

	public List<BoardDTO> getBoardList(BoardDTO dto) {
		return boardDAO.getBoardList(dto);
	}

}
