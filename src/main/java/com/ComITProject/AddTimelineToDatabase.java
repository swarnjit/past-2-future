package com.ComITProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTimelineToDatabase {
	public AddTimelineToDatabase() {
		super();
	}
	public void AddTimeline( String selDate, String story, String ImagePath , String userName) throws ClassNotFoundException {
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
		PreparedStatement ps = null;
	
	try {
		String addTimelineDetails = "insert into p2flife.timeline(timelineDesc,imgSrc,dateAdded,userName) values(?,?,?,?)";
		ps = connect.prepareStatement(addTimelineDetails);
		ps.setString(1, story);
		ps.setString(2, ImagePath);// image stored in folder and path is saved to Database
		ps.setString(3, selDate);
		ps.setString(4, userName);
		ps.executeUpdate();
		
	} 
	catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	
	
}
}