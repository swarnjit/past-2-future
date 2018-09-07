package com.ComITProject;

import java.io.Serializable;

public class Profile implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String emailID;
	private String firstName;
	public Profile() {
		super();
	}
	public Profile (String username, String emailID, String firstName) {
		this.username = username;
		this.emailID = emailID;
		this.firstName = firstName;
		
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public String getEmailID()
	{
		return emailID;
	}
	public void setUseranme(String username)
	{
		this.username = username;
	}
	
	public void setImagepath(String firstName)
	{
		this.firstName = firstName;
	}
	public void setEmailID(String emailID)
	{
		this.emailID = emailID;
	}
	
}



