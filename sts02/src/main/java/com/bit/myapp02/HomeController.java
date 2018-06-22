package com.bit.myapp02;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp02.model.GuestDao;
import com.bit.myapp02.model.GuestDao01Impl;
import com.bit.myapp02.model.entity.GuestVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	GuestDao<GuestVo> dao;
	
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/list.bit")
	public String list(Model model) {
		
		try {
			model.addAttribute("alist", dao.selectAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "guest1/list";
	}
	
	@RequestMapping("/detail.bit")
	public String detail(Model model,HttpServletRequest req){
		GuestDao<?> dao =null;
		dao=new GuestDao01Impl();
		
		String idx=req.getParameter("idx");
		int pk=Integer.parseInt(idx);
		
		try {
			model.addAttribute("bean",dao.selectOne(pk));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "guest1/detail";
	}
	
	@RequestMapping("/edit.bit")
	public String edit(Model model,HttpServletRequest req){
		GuestDao<?> dao =null;
		dao=new GuestDao01Impl();
		
		String idx=req.getParameter("idx");
		int pk=Integer.parseInt(idx);
		
		try {
			model.addAttribute("bean",dao.selectOne(pk));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "guest1/edit";
	}
	
	@RequestMapping("add.bit")
	public String add() {
		return "guest1/add";
	}
	
	@RequestMapping("insert.bit")
	public String insert(HttpServletRequest req) {
		
		GuestVo bean = new GuestVo();
		bean.setSabun(Integer.parseInt(req.getParameter("sabun")));
		bean.setName(req.getParameter("name"));
		bean.setPay(Integer.parseInt(req.getParameter("pay")));
		try {
			dao.insertOne(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/list.bit";
	}
	
	@RequestMapping("/update.bit")
	public String update(int sabun,String name,int pay) {
		GuestVo bean=new GuestVo();
		bean.setSabun(sabun);
		bean.setName(name);
		bean.setPay(pay);
		try {
			dao.updateOne(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/detail.bit?idx"+sabun;
	}
	
}
