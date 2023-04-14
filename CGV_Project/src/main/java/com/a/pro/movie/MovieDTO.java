package com.a.pro.movie;

public class MovieDTO {
	String mname,director,actor;
	int time;
	String day,gerne,show,mposter;
	public MovieDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieDTO(String mname, String director, String actor, int time, String day, String gerne, String show,
			String mposter) {
		super();
		this.mname = mname;
		this.director = director;
		this.actor = actor;
		this.time = time;
		this.day = day;
		this.gerne = gerne;
		this.show = show;
		this.mposter = mposter;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getGerne() {
		return gerne;
	}
	public void setGerne(String gerne) {
		this.gerne = gerne;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public String getMposter() {
		return mposter;
	}
	public void setMposter(String mposter) {
		this.mposter = mposter;
	}
	
	
	
	
}
