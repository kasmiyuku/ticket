package com.ticket.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		List<BoardVO> boardList=sqlSession.selectList(NAMESPACE+".selectBoardList",null);
		return boardList;
	}

	@Override
	public List<BoardVO> selectBoardListBycat(String ttr_cat)
			throws SQLException {
		List<BoardVO> boardList=sqlSession.selectList(NAMESPACE+".selectBoardListByCat",ttr_cat);
		return boardList;
	}

	@Override
	public BoardVO selectBoatdByNo(int ttr_no) throws SQLException {
		BoardVO board=(BoardVO)sqlSession.selectOne(NAMESPACE+".selectBoardByNo",ttr_no);
		return board;
	}

	@Override
	public List<BoardVO> selectSearchList(SearchCriteria cri)
			throws SQLException {
		List<BoardVO> boardList=sqlSession.selectList(NAMESPACE+".selectSearchBoardList",cri);
		return boardList;
	}

	@Override
	public int selectmaxttr_no() throws SQLException {
		return (Integer)sqlSession.selectOne(NAMESPACE+".selectMaxttr_no",null);
	}

	@Override
	public void insertThumb(String thumb_name, int ttr_no) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("thumb_name",thumb_name);
		paramMap.put("ttr_no",ttr_no);
		sqlSession.update(NAMESPACE+".insertThumb",paramMap);
	}

	@Override
	public void deleteThumb(int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replaceThumb(String thumb_name, int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> selectThumb(int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertseatmap(String thumb_name, int ttr_no)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteseatmap(int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replaceseatmap(String thumb_name, int ttr_no)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> selectseatmap(int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertfile(String thumb_name, int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletefile(int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replacefile(String thumb_name, int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> selectfile(int ttr_no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
