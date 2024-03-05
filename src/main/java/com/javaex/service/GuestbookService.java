package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestDao guestDao;
	
	
	//삭제
	public int exeDeleteGuestbook(GuestVo guestVo) {
		System.out.println("GuestbookService.exeDeleteGuestbook()");
		
		int count = guestDao.deleteGuestbook(guestVo);
		
		return count;
	}
	
	//등록
	public int exeAdd(GuestVo guestVo) {
		System.out.println("GuestbookService.exeAdd()");
		
		int count = guestDao.insertGuestbook(guestVo);
		
		return count;
	}
	
	//전체 리스트 가져오기
	public List<GuestVo> exeList() {
		System.out.println("GuestbookService.exeList()");
		
		List<GuestVo> guestList = guestDao.guestSelectList();
		
		return guestList;
	}

}
