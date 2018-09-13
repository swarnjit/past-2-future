package com.ComITProject;

import java.io.Serializable;

public class Profile implements Serializable{
	private static final long serialVersionUID = 1L;
	private int userID;
	private String username;
	private String emailID;
	private String firstName;
	private String profilepicPath;
	public Profile() {
		super();
	}
	public Profile (int userID, String username, String emailID, String firstName, String profilepicPath) {
		this.userID = userID;
		this.username = username;
		this.emailID = emailID;
		this.firstName = firstName;
		this.profilepicPath = profilepicPath;
		
	}
	public int getUserID() {
		return userID;
	}
	public String getUsername()
	{
		return username;
	}
	public String getEmailID()
	{
		return emailID;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getProfilepicPath() {
		return profilepicPath;
	}
	public void setUserID(int userID) {
		this.userID= userID;
	}
	public void setUseranme(String username)
	{
		this.username = username;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void setEmailID(String emailID)
	{
		this.emailID = emailID;
	}
	public void setProfilepicPath(String profilepicPath) {
		this.profilepicPath = profilepicPath;
	}
	
}



