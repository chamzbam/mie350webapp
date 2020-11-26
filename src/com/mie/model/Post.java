package com.mie.model;

import java.util.Date;

public class Post {

	
	private String title;
	private String Body;
	private Date date;
	

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
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	//@Override
	/*public String toString() {
		return "Student [studentid=" + studentid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email + "]";
	} */
	
	
	
	
}
