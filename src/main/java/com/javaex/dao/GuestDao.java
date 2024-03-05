package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//방명록 삭제
	public int deleteGuestbook(GuestVo guestVo) {
		System.out.println("GuestDao.deleteGuestbook()");
		
		int count = sqlSession.delete("guestbook.deleteGuestbook", guestVo);
		
		return count;
	}
	
	//등록
	public int insertGuestbook(GuestVo guestVo) {
		System.out.println("GeustDao.insertGuestbook()");
		
		int count = sqlSession.insert("guestbook.insert", guestVo);
		
		return count;
	}//
	
	//전체 가져오기
	public List<GuestVo> guestSelectList() {
		System.out.println("GeustDao.guestSelectList()");
		
		List<GuestVo> guestList = sqlSession.selectList("guestbook.selectList");
		System.out.println(guestList);
		
		return guestList;
	}//

}
