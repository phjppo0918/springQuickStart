package com.springbook.biz.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardDTO;

@Repository
public class BoardDAOJPA {
	@PersistenceContext
	private EntityManager em;
	
	public void insertBoard(BoardDTO dto) {
		System.out.println("===> JPA로 insertBoard() 기능 처리");
		em.persist(dto);
	}
	
	public void updateBoard(BoardDTO dto) {
		System.out.println("===> JPA로 updateBoard() 기능 처리");
		em.merge(dto);
	}

	public void deleteBoard(BoardDTO dto) {
		System.out.println("===> JPA로 deleteBoard() 기능 처리");
		em.remove(dto);
	}
	
	public BoardDTO getBoard(BoardDTO dto) {
		System.out.println("===> JPA로 getBoard() 기능 처리");
		return (BoardDTO)em.find(BoardDTO.class, dto.getSeq());
	}
	
	public List<BoardDTO> getBoardList(BoardDTO dto) {
		System.out.println("===> JPA로 getBoardList() 기능 처리");
		return em.createQuery("from BoardDTO b order by b.seq desc").getResultList();
	}
}
