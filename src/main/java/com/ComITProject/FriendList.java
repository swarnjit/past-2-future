package com.ComITProject;

import java.io.Serializable;

public class FriendList implements Serializable{
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String firstname;
	private String profilepicPath;
	
	public FriendList() {
		super();
	}
	public FriendList (int user_id, String firstname, String profilepicPath) {
		this.user_id = user_id;
		this.firstname = firstname;
		this.profilepicPath = profilepicPath;
	}

	public int getUser_id()
	{
		return user_id;
	}
	public String getFirstname()
	{
		return firstname;
	}
	
	public String getProfilepicPath()
	{
		return profilepicPath;
		}
	public void setUser_id(int user_id)
	{
		this.user_id = user_id;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public void setProfilepicPath(String profilepicPath)
	{
		this.profilepicPath = profilepicPath;
	}
	
}



