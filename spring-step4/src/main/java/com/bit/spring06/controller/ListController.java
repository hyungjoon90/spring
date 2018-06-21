package com.bit.spring06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring06.model.GuestDao;

public class ListController extends AbstractController {
	private GuestDao guestDao;
	
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		return new ModelAndView("list","alist",guestDao.selectAll());
	}

}
