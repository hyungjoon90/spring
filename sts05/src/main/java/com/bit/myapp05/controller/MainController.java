package com.bit.myapp05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.myapp05.model.GuestDao;

@Controller
public class MainController {
	@Autowired
	GuestDao guestDao;
	
	
	@RequestMapping("/")
	public String test() {
		System.out.println(guestDao);
		return "home";
	}
}
