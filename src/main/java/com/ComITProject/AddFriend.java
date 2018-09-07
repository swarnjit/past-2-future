package com.ComITProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddFriend {
	public AddFriend() {
		super();
	}
	public void SendRequest(String sender, String reciever, int status, String actionID) throws ClassNotFoundException, SQLException{
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
		PreparedStatement ps = null;
		try {
		String InsertFriendRequest = "INSERT INTO p2flife.friendlist(userID1, userID2, status, actionId) VALUES(?,?,?,?)";
		ps = connect.prepareStatement(InsertFriendRequest);
		ps.setString(1, sender);
		ps.setString(2, reciever);
		ps.setInt(3, status);
		ps.setString(4, actionID);
		ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
