package com.a.pro.member;

import javax.servlet.http.HttpServletRequest;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@Autowired
	SqlSession sqlsession;
	@RequestMapping(value="/member_jo")
	public String ko1() {
		
		return "member_join";
	}
	@RequestMapping(value="membersave")
	public String ko2(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String jumin = request.getParameter("jumin");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		Service2 ss2 = sqlsession.getMapper(Service2.class);
		ss2.insert(id, pw, name, jumin, phone, address, email);
		return "redirect:member_jo";
	}
	
	
	
	
}