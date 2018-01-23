package com.ticket.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.dao.BoardDAO;
import com.ticket.domain.BoardVO;
import com.ticket.domain.SearchCriteria;
import com.ticket.service.BoardService;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO){
		this.boardDAO=boardDAO;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		boardDAO.insertBoard(board);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	@Override
	public void deleteBoard(int ttr_no) throws SQLException {
		boardDAO.deleteBoard(ttr_no);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,readOnly=true)
	@Override
	public List<BoardVO> readBoardList() throws SQLException {
		List<BoardVO> boardList=boardDAO.selectBoardList();
		return boardList;
	}

	@Override
	public BoardVO readBoardByNo(int ttr_no) throws SQLException {
		BoardVO board=boardDAO.selectBoatdByNo(ttr_no);
		return board;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,readOnly=true)
	@Override
	public List<BoardVO> readBoardListByCat(String ttr_cat) throws SQLException {
		List<BoardVO> boardList=boardDAO.selectBoardListBycat(ttr_cat);
		return boardList;
	}

	@Override
	public List<BoardVO> readSearchBoardList(SearchCriteria cri)
			throws SQLException {
		List<BoardVO> boardList=boardDAO.selectSearchList(cri);
		return boardList;
	}

}
