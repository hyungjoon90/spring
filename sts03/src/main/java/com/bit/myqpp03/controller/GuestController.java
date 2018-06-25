package com.bit.myqpp03.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.myqpp03.model.GuestDao;

@Controller
public class GuestController {
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	GuestDao guestDao;
	
	@RequestMapping("/guest/")
	public String list(Model model,HttpServletRequest req) throws SQLException {
		model.addAttribute("alist", guestDao.selectAll());
		model.addAttribute("path","myqpp03");
		return "list";
	}
}
