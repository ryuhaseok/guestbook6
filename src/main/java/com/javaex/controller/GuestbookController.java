package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;

	
	//삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestbookController.delete");
		
		guestbookService.exeDeleteGuestbook(guestVo);
		
		return "redirect:addlist";
	}
	
	//삭제폼
	@RequestMapping(value="/deleteform", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		System.out.println("GuestbookController.deleteForm()");
		
		return "deleteForm";
	}
	
	//등록
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestbookController.add()");
		
		guestbookService.exeAdd(guestVo);
		
		return "redirect:addlist";
	}
	
	//등록폼 + 리스트
	@RequestMapping(value="/addlist", method= {RequestMethod.GET, RequestMethod.POST})
	public String addListForm(Model model) {
		System.out.println("GuestbookController.addListForm()");
		
		List<GuestVo> guestList = guestbookService.exeList();
		model.addAttribute("guestList", guestList);
		
		return "addList";
	}
	
}
