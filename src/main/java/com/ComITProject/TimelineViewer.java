package com.ComITProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TimelineViewer {
	public List<Timeline> getTimelineByUsername( String username) throws ClassNotFoundException
	{
		List<Timeline> timeline = new ArrayList<Timeline>();
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
        String sql = "SELECT timelineDesc, imgSrc, dateAdded FROM p2flife.timeline WHERE userName=?";

        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
            	String story = resultSet.getString("timelineDesc");
            	String imagepath = resultSet.getString("imgSrc");
            	String selDate = resultSet.getString("dateAdded");
            	timeline.add(new Timeline(story, imagepath, selDate));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

		return timeline;
	}
}
