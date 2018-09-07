package com.ComITProject;

import java.io.Serializable;

public class FriendList implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userID1;
	private String userID2;
	private int status;
	private String actionID;
	public FriendList() {
		super();
	}
	public FriendList (String userID1, String userID2, int status, String actionID) {
		this.userID1 = userID1;
		this.userID2 = userID2;
		this.status = status;
		this.actionID = actionID;
	}

	public String getUserid1()
	{
		return userID1;
	}
	
	public String getUserID2()
	{
		return userID2;
	}
	public int getStatus()
	{
		return status;
	}
	public String getActionID()
	{
		return actionID;
		}
	public void setUserID1(String userID1)
	{
		this.userID1 = userID1;
	}
	
	public void setUserID2(String userID2)
	{
		this.userID2 = userID2;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public void setActionID(String actionID)
	{
		this.actionID = actionID;
	}
	
}



