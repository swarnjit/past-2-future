package com.ComITProject;

import java.io.Serializable;

public class Friends implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String firstname;
	private String profilepic;
	public Friends(){
		super();
	}
	public Friends(String username, String firstname, String profilepic) {
		this.username = username;
		this.firstname = firstname;
		this.profilepic = profilepic;
	}
	public String getUsername()
	{
		return username;
	}
	public String getFirstname()
	{
		return firstname;
	}
	public String getProfilePic()
	{
		return profilepic;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public void setProfilePic(String profilepic)
	{
		this.profilepic = profilepic;
	}

}
