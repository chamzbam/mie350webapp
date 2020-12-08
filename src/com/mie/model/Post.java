package com.mie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private Integer ID;
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
	public Integer getID(){
		
		
		return this.ID;
	}

	public Date getDate() {
		return date;
	}
	public void setID(int ID){
		this.ID=ID;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public void addComment(Comment comment){
		
		postComments.add(comment);
	}
	public List<Comment> getComments(){
		
		return postComments;
		
		
	}
	
	
	
	
	

	

	//@Override
	/*public String toString() {
		return "Student [studentid=" + studentid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email + "]";
	} */
	
	
	
	
}
