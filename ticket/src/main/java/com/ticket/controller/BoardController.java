package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticket.domain.BoardVO;
import com.ticket.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bs;
	
	@RequestMapping(value = "/etc", method = RequestMethod.GET)
	public String readEtc(Model model) throws Exception{
		String url="board/etc";
		String ttr_cat="기타";
		List<BoardVO> boardList=bs.readBoardListByCat(ttr_cat);
		model.addAttribute("list",boardList);
		return url;
	}
}
