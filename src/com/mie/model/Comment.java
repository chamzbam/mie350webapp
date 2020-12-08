package com.mie.model;

import java.util.Date;

public class Comment {

	
	
	private Integer ID;
	
	private String Body;
	private Date date;
	

	
	
	public String getBody() {
		return Body;
	}
	public void setBody(String body){
		this.Body=body;
	}
	public Integer getID(){
		
		
		return this.ID;
	}
	public void setID(Integer ID){
		
		this.ID=ID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
}
