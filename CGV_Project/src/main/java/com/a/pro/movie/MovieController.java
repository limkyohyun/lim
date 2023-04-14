package com.a.pro.movie;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



	@Controller
	public class MovieController {

	@Autowired
	SqlSession sqlSession;
	
   @RequestMapping(value="/moviechartinput")
   public String ko1() {
      return "moviechart_input";
   }
   

   @RequestMapping(value="/moviechartsave",method = RequestMethod.POST)
   public String ko2(MultipartHttpServletRequest mul ) {
	   String mname =mul.getParameter("mname");
	   String director = mul.getParameter("director");
	   String actor = mul.getParameter("actor");
	   int time = Integer.parseInt(mul.getParameter("time"));
	   String day = mul.getParameter("day");
	   String[] gerne = mul.getParameterValues("gerne");
	   String gerne2 ="";
	   for(int i=0; i<gerne.length;i++) {
		   gerne2+=gerne[i]+"";
	   }
	   
	   String show = mul.getParameter("show");
	   MultipartFile mf = mul.getFile("mposter");
	   String mposter = mf.getOriginalFilename();
	   
	   Service1 ss1 = sqlSession.getMapper(Service1.class);
	   ss1.movieinsert(mname,gerne2,director,actor,day,time,show,mposter);
	   
	 return "moviechart_input";
	 
	 }
   @RequestMapping(value="/moviechartout")
   public String ko3(Model mo) {
	  
	   Service1 ss1 = sqlSession.getMapper(Service1.class);
	   ArrayList<MovieDTO> list = ss1.movieout();
	   mo.addAttribute("list", list);
	   
	 return "moviechart_out2";
	 
	 }
   @RequestMapping(value="/detail")
   public String ko3(HttpServletRequest request,Model mo) {
	   String mname = request.getParameter("mname");
	   
	   Service1 ss1 = sqlSession.getMapper(Service1.class);
	  ArrayList<MovieDTO> list2 =ss1.moviedetail(mname);
	   mo.addAttribute("list2", list2);
	 return "moviechart_detail";
	
	 }
   
   @RequestMapping(value="/moviedelete")
   public String ko4(HttpServletRequest request) {
	   String mname = request.getParameter("mname");
	   
	   Service1 ss1 = sqlSession.getMapper(Service1.class);
	 ss1.moviedelete(mname);
	   
	 return "redirect:moviechartout";
	
	 }
   
   @RequestMapping(value="/moviemodify")
   public String ko5(HttpServletRequest request,Model mo) {
	   String mname = request.getParameter("mname");
	   
	   Service1 ss1 = sqlSession.getMapper(Service1.class);
	 ArrayList<MovieDTO> list2 = ss1.moviemodify(mname);
	   mo.addAttribute("list2", list2);
	 return "moviechart_modify";
	
	 }
   @RequestMapping(value="/moviemodifysave",method = RequestMethod.POST)
   public String ko3(MultipartHttpServletRequest mul ) {
	   String mname =mul.getParameter("mname");
	   String director = mul.getParameter("director");
	   String actor = mul.getParameter("actor");
	   int time = Integer.parseInt(mul.getParameter("time"));
	   String day = mul.getParameter("day");
	   String[] gerne = mul.getParameterValues("gerne");
	   String gerne2 ="";
	   for(int i=0; i<gerne.length;i++) {
		   gerne2+=gerne[i]+"";
	   }
	   
	   String show = mul.getParameter("show");
	   MultipartFile mf = mul.getFile("mposter");
	   String mposter = mf.getOriginalFilename();
	   
	   Service1 ss1 = sqlSession.getMapper(Service1.class);
	   ss1.moviemodify2(mname,gerne2,director,actor,day,time,show,mposter);
	   
	 return "main";
	 
	 }
   @RequestMapping(value ="/moviechartsearchsave" )
	public String ko10(HttpServletRequest request,Model mo) {
		String item=request.getParameter("item");
		String value=request.getParameter("value");	
		Service1 ss=sqlSession.getMapper(Service1.class);
		ArrayList<MovieDTO> list=null;
		if(item.equals("mname")) {
			list=ss.searchmname(value);
		}
		else if(item.equals("director"))
		{
			list=ss.searchdirector(value);
		}
			
		else if(item.equals("gerne"))
		{			
			list=ss.searchgerne(value);
		}
		mo.addAttribute("list2", list);
		
		return "moviechart_out2";
	}
}