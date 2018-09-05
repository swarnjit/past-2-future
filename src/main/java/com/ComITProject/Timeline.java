package com.ComITProject;

import java.io.Serializable;

public class Timeline implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String story;
	private String selDate;
	private String imagepath;
	public Timeline() {
		super();
	}
	public Timeline (String story, String selDate, String imagepath) {
		this.story = story;
		this.selDate = selDate;
		this.imagepath = imagepath;
		
	}

	public String getStory()
	{
		return story;
	}
	
	public String getImagepath()
	{
		return imagepath;
	}
	public String getSelDate()
	{
		return selDate;
	}
	public void setStory(String story)
	{
		this.story = story;
	}
	
	public void setImagepath(String imagepath)
	{
		this.imagepath = imagepath;
	}
	public void setSelDate(String selDate)
	{
		this.selDate = selDate;
	}
	
}
