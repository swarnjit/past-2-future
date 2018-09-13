package com.ComITProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddFriend {
	public AddFriend() {
		super();
	}
	public void SendRequest(int sender, int reciever, int status, int actionID) throws ClassNotFoundException, SQLException{
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
		PreparedStatement ps = null;
		try {
		String InsertFriendRequest = "INSERT INTO p2flife.friendlist(userID1, userID2, status, actionId) VALUES(?,?,?,?)";
		ps = connect.prepareStatement(InsertFriendRequest);
		ps.setInt(1, sender);
		ps.setInt(2, reciever);
		ps.setInt(3, status);
		ps.setInt(4, actionID);
		ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}
	public void AcceptFriendRequest(int userID1, int userID2, int actionID) throws ClassNotFoundException {
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
		PreparedStatement ps = null;
		try {
		String AcceptFriendRequest = "update p2flife.friendlist set status=1, actionID=? Where userID1=? AND userID2=?";
		ps = connect.prepareStatement(AcceptFriendRequest);
		ps.setInt(1, actionID);
		ps.setInt(2, userID1);
		ps.setInt(3, userID2);
		ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}
	public void DeleteFriend(int userID1, int userID2) throws ClassNotFoundException {
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
		PreparedStatement ps = null;
		try {
		String AcceptFriendRequest = "DELETE FROM p2flife.friendlist WHERE userID1=? AND userID2=?";
		ps = connect.prepareStatement(AcceptFriendRequest);
		ps.setInt(1, userID1);
		ps.setInt(2, userID2);
		ps.executeUpdate();
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
	}
	public int CheckFriendship(int userID1, int userID2) throws ClassNotFoundException {
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
		int StatusOfFriendship = 0;
		PreparedStatement ps = null;
		try {
			if(userID1<userID2) {
		String CheckFriendship = "Select * FROM p2flife.friendlist WHERE userID1=? AND userID2=? AND status=1";
		ps = connect.prepareStatement(CheckFriendship);
		ps.setInt(1, userID1);
		ps.setInt(2, userID2);
		 ResultSet results = ps.executeQuery();
		 if (results.next()) {
		        StatusOfFriendship = 1;
		        
		    }else {
		    	StatusOfFriendship = 0;
		         
		    }
			}
			else {
				String AcceptFriendRequest = "Select * FROM p2flife.friendlist WHERE userID1=? AND userID2=? AND status=1";
				ps = connect.prepareStatement(AcceptFriendRequest);
				ps.setInt(1, userID2);
				ps.setInt(2, userID1);
				 ResultSet results = ps.executeQuery();
				 if (results.next()) {
				        StatusOfFriendship = 1;
				        
				    }else {
				    	StatusOfFriendship = 0;
				         
				    }
			}
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		return StatusOfFriendship;
		
	}

}
