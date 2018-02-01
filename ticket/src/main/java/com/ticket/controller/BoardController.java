package com.ticket.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ticket.domain.BoardVO;
import com.ticket.domain.Seatinfo;
import com.ticket.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bs;
	
	@InitBinder public void initBinder(WebDataBinder binder) 
	{ 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); binder.registerCustomEditor(Date.class,"ttr_sdate", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class,"ttr_edate", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class,"ttr_date", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class,"seat_date", new CustomDateEditor(dateFormat, true));
		SimpleDateFormat time = new SimpleDateFormat("hh:mm"); binder.registerCustomEditor(Date.class,"seat_time", new CustomDateEditor(time, true));
	}
	

	
	@RequestMapping(value = "/etc", method = RequestMethod.GET)
	public String readEtc(Model model) throws Exception{
		String url="board/etc";
		String ttr_cat="기타";
		List<BoardVO> boardList=bs.readBoardListByCat(ttr_cat);
		model.addAttribute("list",boardList);
		return url;
	}
	
	@RequestMapping(value="/etc/etcdetail",method=RequestMethod.GET)
	public String etcdetail(@RequestParam("ttr_no")int ttr_no,Model model) throws Exception{
		String url="board/etc/etcdetail";
		BoardVO board=bs.readBoardByNo(ttr_no);
		model.addAttribute(board);
		return url;
	}
	
	@RequestMapping(value="etc/etcupdate",method=RequestMethod.GET)
	public String etcupdate(@RequestParam("ttr_no")int ttr_no,Model model) throws Exception{
		String url="board/etc/etcupdate";
		BoardVO board=bs.readBoardByNo(ttr_no);
		model.addAttribute(board);
		return url;
	}
	
	@RequestMapping(value="etc/etcupdate",method=RequestMethod.POST)
	public String etcupdate(BoardVO board,Model model) throws Exception{
		String url="redirect:/board/etc";
		try{
			bs.updateBoard(board);
			model.addAttribute(board);
		}catch(SQLException e){
			throw e;
		}
		return url;
	}
	
	@RequestMapping(value="/etc/delete",method=RequestMethod.GET)
	public String etcdelete(int ttr_no) throws Exception{
		String url="redirect:/board/etc";
		bs.deleteBoard(ttr_no);
		return url;
	}
	
	@RequestMapping("/getFiles/{ttr_no}")
	@ResponseBody
	public List<String> getFiles(@PathVariable("ttr_no") int ttr_no) throws Exception{
		return bs.getFiles(ttr_no);
	}
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public void etcwriteForm() throws Exception{}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String etcwriteSubmit(BoardVO board,Model model) throws Exception{
		String url="redirect:/board/etc";
		try{
			bs.insertBoard(board);
			model.addAttribute(board);
		}catch(SQLException e){
			throw e;
		}
		return url;
	}
}
