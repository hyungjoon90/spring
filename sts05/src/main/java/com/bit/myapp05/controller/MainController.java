package com.bit.myapp05.controller;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp05.model.GuestDao;
import com.bit.myapp05.model.entity.GuestVo;
import com.bit.myapp05.service.GuestService;

@Controller
public class MainController {
	@Autowired
	GuestService service;
	
	String view="redirect:/guest/";
	
	@RequestMapping("/")
	public String test() {
		return "home";
	}
	
	@RequestMapping(value="/guest/", method=RequestMethod.GET)
	public String list(Model model) throws SQLException{
		service.listPage(model);
		return "list";
	}
	
	@RequestMapping(value="/guest/", method=RequestMethod.POST)
	public String add(@ModelAttribute GuestVo bean, String name) throws SQLException{
		service.addPage(bean);
		return view;
	}
	@RequestMapping(value="/guest/{sabun}", method=RequestMethod.DELETE)
	public String del(@PathVariable int sabun) throws SQLException{
		service.deletePage(sabun);
		return view;
	}
	
	@RequestMapping(value="/guest/{sabun}", method=RequestMethod.PUT)
	public String edit(@PathVariable int sabun, @ModelAttribute GuestVo bean) throws SQLException{
		service.updatePage(bean);
		return view+sabun;
	}
	
	
}
