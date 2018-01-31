package com.ticket.dao;

import java.sql.SQLException;
import java.util.List;

import com.ticket.domain.BoardVO;
import com.ticket.domain.SearchCriteria;
import com.ticket.domain.Seatinfo;

public interface BoardDAO {
	void insertBoard(BoardVO board) throws SQLException;
	void updateBoard(BoardVO board) throws SQLException;
	void deleteBoard(int ttr_no) throws SQLException;
	List<BoardVO> selectBoardList() throws SQLException;
	List<BoardVO> selectBoardListBycat(String ttr_cat) throws SQLException;
	BoardVO selectBoatdByNo(int ttr_no) throws SQLException;
	
	//검색
	List<BoardVO> selectSearchList(SearchCriteria cri) throws SQLException;
	
	int selectmaxttr_no() throws SQLException;
	//썸네일추가
	void insertThumb(String thumb_name,int ttr_no) throws SQLException;
	void deleteThumb(int ttr_no) throws SQLException;
	String selectThumb(int ttr_no) throws SQLException;
	
	//구조도추가
	void insertseatmap(String seatmap_name,int ttr_no) throws SQLException;
	void deleteseatmap(int ttr_no) throws SQLException;
	String selectseatmap(int ttr_no) throws SQLException;
	
	//성명파일추가
	void insertfile(String file_name,int ttr_no) throws SQLException;
	void deletefile(int ttr_no) throws SQLException;
	List<String> selectfile(int ttr_no) throws SQLException;
	
	void insertseat(Seatinfo seat) throws SQLException;
	void deleteseatbyseat_id(String seat_id) throws SQLException;
	void deleteseatbyttr_no(int ttr_no) throws SQLException;
	void updateseatbyseat_id(Seatinfo seat) throws SQLException;
	void updateseatbyttr_no(Seatinfo seat) throws SQLException;
	List<Seatinfo> selectseatbyttr_no(int ttr_no) throws SQLException;
	Seatinfo selectseatbyseat_id(String seat_id) throws SQLException;
	List<Seatinfo> selectseat() throws SQLException;
}
