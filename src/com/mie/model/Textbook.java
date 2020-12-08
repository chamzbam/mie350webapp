package com.mie.model;

import java.util.ArrayList;
import java.util.Date;

public class Textbook {
	private Integer price;
	private String title;
	private String Body;
	private Date date;
	private ArrayList<Comment> postComments = new ArrayList<Comment>();

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	public String getBody() {
		return Body;
	}
	public void setBody(String body){
		this.Body=body;
	}
	public Integer getPrice(){
		
		
		return this.price;
	}

	public Date getDate() {
		return date;
	}
	public void setPrice(int price){
		this.price=price;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
