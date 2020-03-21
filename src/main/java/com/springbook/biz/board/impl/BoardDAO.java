package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardDTO;
import com.springbook.biz.common.JDBCUtil;

//DAO (Data Access Object)
@Repository("boardDAO")
public class BoardDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// SQL 명령어들
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content)"
			+ " values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title = ?, content = ?" + " where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardDTO dto) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, dto.getTitle());
			stmt.setString(2, dto.getWriter());
			stmt.setString(3, dto.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//글 수정
	
}
