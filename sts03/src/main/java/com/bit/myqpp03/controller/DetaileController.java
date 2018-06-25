package com.bit.myqpp03.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myqpp03.entity.GuestVo;
import com.bit.myqpp03.model.GuestDao;

@Controller
public class DetaileController {
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	GuestDao guestDao;
	
	@RequestMapping(value="/guest/{idx}",method=RequestMethod.GET)
	public String detail(@PathVariable int idx, Model model) throws SQLException {
		model.addAttribute("bean",guestDao.selectOne(idx));
		model.addAttribute("path","myqpp03");
		return "detaile";
	}
	
	//spring restful 累悼规过
	//PUT,Delete method 荤侩规过
	// form -> <input type="hidden" name="_method" value="put">
	//web.xml -> org.springframework.web.filter.HiddenHttpMethodFilter
	//pattern -> /*
	
	
	@RequestMapping(value="/guest/{idx}",method=RequestMethod.PUT)
	public String edit(@PathVariable int idx, @ModelAttribute GuestVo bean) throws SQLException {
		log.debug("PUT:"+bean);
		guestDao.updateOne(bean);
		return "redirect:/guest/"+idx;
	}
	
	@RequestMapping(value="/guest/{idx}",method=RequestMethod.DELETE)
	public String delte(@PathVariable int idx, @ModelAttribute GuestVo bean) throws SQLException {
		log.debug("Delete:"+idx);
		guestDao.deleteOne(idx);
		return "redirect:/guest/";
	}
}
