package com.bit.spring02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.spring02.model.GuestDao1;

public class DetailController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		String idx=req.getParameter("idx");
		ModelAndView mav =new ModelAndView();
		GuestDao1 dao =new GuestDao1();
		mav.addObject("bean",dao.selectOne(Integer.parseInt(idx)));
		mav.setViewName("detail");
		
		return mav;
	}

}
