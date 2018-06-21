package com.bit.spring06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.spring06.model.GuestDao;

public class DelController extends AbstractController {
	// 1. Ÿ�� �ʵ�� ��ġ
	// 2. Ÿ��(super O)x �ʵ�� ��ġ
	// 3. Ÿ��o  �ʵ�� x
	// 4. Ÿ��(super O)x �ʵ��x
	
	// 1.@Autowired setter
	// 2.@Autowired �ʵ���
	
	private GuestDao guestDao;

	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int sabun=Integer.parseInt(request.getParameter("idx"));
		System.out.println(guestDao);
		if(guestDao.deleteOne(sabun)>0)return new ModelAndView("redirect:/list.bit");
		return new ModelAndView("redirect:/detail.bit?idx="+sabun);
	}


}
