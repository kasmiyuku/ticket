package com.ticket.service;

import java.sql.SQLException;
import java.util.List;

import com.ticket.domain.BoardVO;
import com.ticket.domain.SearchCriteria;
import com.ticket.domain.Seatinfo;

public interface BoardService {
	void insertBoard(BoardVO board) throws SQLException;
	void updateBoard(BoardVO board) throws SQLException;
	void deleteBoard(int ttr_no) throws SQLException;
	List<BoardVO> readBoardList() throws SQLException;
	BoardVO readBoardByNo(int ttr_no) throws SQLException;
	List<BoardVO> readBoardListByCat(String ttr_cat) throws SQLException;
	List<BoardVO> readSearchBoardList(SearchCriteria cri) throws SQLException;
	List<String> getFiles(int ttr_no) throws SQLException;
	
	Seatinfo readseatbyseat_id(String seat_id) throws SQLException;
	List<Seatinfo> readseatbyttr_no(int ttr_no) throws SQLException;
	List<Seatinfo> readseat() throws SQLException;
}
