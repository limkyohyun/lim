package com.a.pro.movie;

import java.util.ArrayList;

public interface Service1 {
	
public void movieinsert(String mname,String gerne2,String director,String actor,String day,int time,String show,String mposter);
public ArrayList<MovieDTO> movieout();
public ArrayList<MovieDTO> moviedetail(String mname);
public void moviedelete(String mname);

public ArrayList<MovieDTO> moviemodify(String mname);
public void moviemodify2(String mname,String gerne2,String director,String actor,String day,int time,String show,String mposter);
public  ArrayList<MovieDTO> searchmname(String value);
public  ArrayList<MovieDTO> searchdirector(String value);
public  ArrayList<MovieDTO> searchgerne(String value);
} 
