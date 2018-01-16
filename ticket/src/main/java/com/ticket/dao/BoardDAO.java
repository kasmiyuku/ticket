package com.ticket.dao;

import java.sql.SQLException;
import java.util.List;

import com.ticket.domain.BoardVO;
import com.ticket.domain.SearchCriteria;

public interface BoardDAO {
	void insertBoard(BoardVO board) throws SQLException;
	void updateBoard(BoardVO board) throws SQLException;
	void deleteBoard(int ttr_no) throws SQLException;
	List<BoardVO> selectBoardList() throws SQLException;
	List<BoardVO> selectBoardListBycat(String ttr_cat) throws SQLException;
	BoardVO selectBoatdByBno(int ttr_no) throws SQLException;
	
	//검색
	List<BoardVO> selectSearchList(SearchCriteria cri) throws SQLException;
}
