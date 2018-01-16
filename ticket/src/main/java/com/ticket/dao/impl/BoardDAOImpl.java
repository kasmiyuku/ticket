package com.ticket.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ticket.dao.BoardDAO;
import com.ticket.domain.BoardVO;
import com.ticket.domain.SearchCriteria;

public class BoardDAOImpl implements BoardDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	private static final String NAMESPACE="BoardMapper";

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		sqlSession.update(NAMESPACE+".insertBoard",board);
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		sqlSession.update(NAMESPACE+".updateBoard",board);
	}

	@Override
	public void deleteBoard(int ttr_no) throws SQLException {
		sqlSession.update(NAMESPACE+".deleteBoard",ttr_no);
	}

	@Override
	public List<BoardVO> selectBoardList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectBoardListBycat(String ttr_cat)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO selectBoatdByBno(int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectSearchList(SearchCriteria cri)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
