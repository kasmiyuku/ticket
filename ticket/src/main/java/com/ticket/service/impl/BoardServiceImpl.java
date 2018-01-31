package com.ticket.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.dao.BoardDAO;
import com.ticket.domain.BoardVO;
import com.ticket.domain.SearchCriteria;
import com.ticket.domain.Seatinfo;
import com.ticket.service.BoardService;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		boardDAO.insertBoard(board);

		String[] files = board.getFiles();

		Seatinfo[] seats = null;

		String[] seat_grds = board.getSeat_grd();
		String[] seat_nos = board.getSeat_no();
		String[] seat_pris = board.getSeat_pri();
		Date[] seat_times = board.getSeat_time();

		for (int i = 0; i < seat_grds.length; i++) {
			seats[i].setSeat_grd(seat_grds[i]);
			seats[i].setSeat_no(seat_nos[i]);
			seats[i].setSeat_pri(seat_pris[i]);
			seats[i].setSeat_time(seat_times[i]);
		}

		int ttr_no = boardDAO.selectmaxttr_no();
		String thumb = board.getThumb_name();
		String seatmap = board.getThumb_name();
		boardDAO.insertThumb(thumb, ttr_no);
		boardDAO.insertseatmap(seatmap, ttr_no);
		if (files == null)
			return;
		for (String file_name : files) {
			boardDAO.insertfile(file_name, ttr_no);
		}
		if (seats == null)
			return;
		for (Seatinfo seat : seats) {
			boardDAO.insertseat(seat);
		}

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);

		int ttr_no = board.getTtr_no();
		boardDAO.deletefile(ttr_no);
		boardDAO.deleteThumb(ttr_no);
		boardDAO.deleteseatmap(ttr_no);

		String[] files = board.getFiles();

		Seatinfo[] seats = null;

		String[] seat_grds = board.getSeat_grd();
		String[] seat_nos = board.getSeat_no();
		String[] seat_pris = board.getSeat_pri();
		Date[] seat_times = board.getSeat_time();

		for (int i = 0; i < seat_grds.length; i++) {
			seats[i].setSeat_grd(seat_grds[i]);
			seats[i].setSeat_no(seat_nos[i]);
			seats[i].setSeat_pri(seat_pris[i]);
			seats[i].setSeat_time(seat_times[i]);
		}

		boardDAO.insertThumb(board.getThumb_name(), ttr_no);
		boardDAO.insertseatmap(board.getThumb_name(), ttr_no);
		if (files == null)
			return;
		for (String file_name : files) {
			boardDAO.insertfile(file_name, ttr_no);
		}
		if (seats == null)
			return;
		for (Seatinfo seat : seats) {
			boardDAO.updateseatbyttr_no(seat);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void deleteBoard(int ttr_no) throws SQLException {
		boardDAO.deleteBoard(ttr_no);
		boardDAO.deletefile(ttr_no);
		boardDAO.deleteThumb(ttr_no);
		boardDAO.deleteseatmap(ttr_no);
		boardDAO.deleteseatbyttr_no(ttr_no);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
	@Override
	public List<BoardVO> readBoardList() throws SQLException {
		List<BoardVO> boardList = boardDAO.selectBoardList();
		for (int i = 0; i < boardList.size(); i++) {
			BoardVO bef = boardList.get(i);
			String thumb = boardDAO.selectThumb(bef.getTtr_no());
			bef.setThumb_name(thumb);
			boardList.set(i, bef);
		}
		;
		return boardList;
	}

	@Override
	public BoardVO readBoardByNo(int ttr_no) throws SQLException {
		BoardVO board = boardDAO.selectBoatdByNo(ttr_no);
		
		List<Seatinfo> seats=boardDAO.selectseatbyttr_no(ttr_no);
		
		String[] seat_grds = null;
		String[] seat_nos = null;
		String[] seat_pris = null;
		Date[] seat_times = null;
		
		for(int i=0;i<seats.size();i++){
			seat_grds[i]=seats.get(i).getSeat_grd();
			seat_nos[i]=seats.get(i).getSeat_no();
			seat_pris[i]=seats.get(i).getSeat_pri();
			seat_times[i]=seats.get(i).getSeat_time();
		}
		
		board.setThumb_name(boardDAO.selectThumb(ttr_no));
		board.setSeatmap_name(boardDAO.selectseatmap(ttr_no));
		board.setSeat_grd(seat_grds);
		board.setSeat_no(seat_nos);
		board.setSeat_pri(seat_pris);
		board.setSeat_time(seat_times);
		
		return board;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
	@Override
	public List<BoardVO> readBoardListByCat(String ttr_cat) throws SQLException {
		List<BoardVO> boardList = boardDAO.selectBoardListBycat(ttr_cat);
		for (int i = 0; i < boardList.size(); i++) {
			BoardVO bef = boardList.get(i);
			String thumb = boardDAO.selectThumb(bef.getTtr_no());
			bef.setThumb_name(thumb);
			boardList.set(i, bef);
		}
		;
		return boardList;
	}

	@Override
	public List<BoardVO> readSearchBoardList(SearchCriteria cri)
			throws SQLException {
		List<BoardVO> boardList = boardDAO.selectSearchList(cri);
		return boardList;
	}

	@Override
	public List<String> getFiles(int ttr_no) throws SQLException {
		List<String> files = boardDAO.selectfile(ttr_no);
		return files;
	}
	@Override
	public Seatinfo readseatbyseat_id(String seat_id) throws SQLException {
		Seatinfo seat = boardDAO.selectseatbyseat_id(seat_id);
		return seat;
	}

	@Override
	public List<Seatinfo> readseatbyttr_no(int ttr_no) throws SQLException {
		List<Seatinfo> seat = boardDAO.selectseatbyttr_no(ttr_no);
		return seat;
	}

	@Override
	public List<Seatinfo> readseat() throws SQLException {
		List<Seatinfo> seat = boardDAO.selectseat();
		return seat;
	}
}
