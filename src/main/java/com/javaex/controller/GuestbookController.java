package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;
import com.javaex.vo.PersonVo;

@Controller
public class GuestbookController {
	
	//필드
	@Autowired
	private GuestbookService guestbookService;
	
	
	//생성자
	
	//메소드 g/s
	
	//메소드 일반
	//리스트
	@RequestMapping(value="/guest/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController.list()");
			
		List<GuestbookVo> guestList=GuestbookService.exeList();
		model.addAttribute("guestList", guestList);
		return "";
	}
	
	//삭제
	@RequestMapping(value="/phone/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no) {
		System.out.println("phoneBookController.delete()");
		
		System.out.println(no);
		GuestbookService guestbookService = new GuestbookService();
		GuestbookService.exeDelete(no);
		
		GuestbookDao guestbookDao = new GuestbookDao();
		guestbookDao.guestDelete(no);
		
		return "redirect:/guest/list";
	}
	
	@RequestMapping(value="/guest/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write2(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("phoneBookController.write2()");
		
		//GuestbookVo GuestbookVo = new GuestbookVo(name, hp, company);
		
		System.out.println(guestbookVo.toString());
		
		//서비스를 메모리에 올리고
		//서비스의 메소드를 사용해야함
		//PhonebookService phonebookService = new PhonebookService();
		GuestbookService.exeWrite(guestVo);
		
		//PhoneDao phoneDao = new PhoneDao();
		//phoneDao.personInsert(personVo);
		
		return "redirect:/guest/list";
	}
}
