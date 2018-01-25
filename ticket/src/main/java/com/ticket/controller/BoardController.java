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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticket.domain.BoardVO;
import com.ticket.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bs;
	
	@InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); }

	
	@RequestMapping(value = "/etc", method = RequestMethod.GET)
	public String readEtc(Model model) throws Exception{
		String url="board/etc";
		String ttr_cat="기타";
		List<BoardVO> boardList=bs.readBoardListByCat(ttr_cat);
		model.addAttribute("list",boardList);
		return url;
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
