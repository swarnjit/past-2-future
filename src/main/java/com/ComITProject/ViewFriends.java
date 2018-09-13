package com.ComITProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewFriends {
	public ViewFriends() {
		super();
	}
        public List<FriendList> getFriendsListByUserId(int userID1, int userID2, int status) throws ClassNotFoundException{
        	List<FriendList> friendList = new ArrayList<FriendList>();
        	SqlConnection sqlconnection = new SqlConnection();
    		Connection connect = sqlconnection.get_Connection();
    		if(userID1<=userID2) {
    			String sql = "SELECT userID, firstname, profilepicPath FROM p2flife.reguser WHERE userID IN (SELECT userID2 FROM p2flife.friendlist WHERE userID1=? AND status=?)";

	            try {
	                PreparedStatement ps = connect.prepareStatement(sql);
	                ps.setInt(1, userID2);
	                ps.setInt(2, status);
	               
	
	                ResultSet resultSet = ps.executeQuery();
	
	                while(resultSet.next()) {
	                	 int userID = resultSet.getInt("userID");
	                	String firstname = resultSet.getString("firstname");
	                	String profilepicPath= resultSet.getString("profilepicPath");
	                	
	                	friendList.add(new FriendList(userID, firstname, profilepicPath));
	                }
	
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	
	    		return friendList;
	        	
	        }else {
	        	 String sql = "SELECT userID, firstname, profilepicPath FROM p2flife.reguser WHERE userID IN (SELECT userID1 FROM p2flife.friendlist WHERE userID2=? AND status=?)";
	
	             try {
	                 PreparedStatement ps = connect.prepareStatement(sql);
	                 ps.setInt(1, userID1);
	                 ps.setInt(2, status);
	
	                 ResultSet resultSet = ps.executeQuery();
	
	                 while(resultSet.next()) {
	                	 int userID = resultSet.getInt("userID");
	                 	String firstname = resultSet.getString("firstname");
	                 	String profilepicPath= resultSet.getString("profilepicPath");
	                 	
	                 	friendList.add(new FriendList(userID, firstname, profilepicPath));
	                 }
	
	             } catch (SQLException e) {
	                 e.printStackTrace();
	             }
	
	        	
	        	return friendList;
	        }
    	}
    public void AcceptFriendRequest(int userID1, int userID2) throws ClassNotFoundException {
    	SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
		PreparedStatement ps = null;
		try {
			String accept= "update p2flife.friendlist set status=1 , actionID=? Where userID=?";
			ps = connect.prepareStatement(accept);
			ps.setInt(1, userID1);
			ps.setInt(2, userID1);
			ps.setInt(3, userID2);
			ps.executeUpdate();
			
		} 
		catch (SQLException e) {
			System.err.println(e.getMessage());
		}
    }
      public List<FriendList> getResultsBySearchString( String SearchString) throws ClassNotFoundException  {
        List<FriendList> SearchResults = new ArrayList<FriendList>();
      	SqlConnection sqlconnection = new SqlConnection();
  		Connection connect = sqlconnection.get_Connection(); 
  		String sql = "SELECT userID, firstname, profilepicPath FROM p2flife.reguser WHERE (username LIKE ? OR firstname LIKE ?)";
  		
  		try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, "%"+SearchString+"%");
            ps.setString(2, "%"+SearchString+"%");
            
           

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
            	int userID = resultSet.getInt("userID");
            	String firstname = resultSet.getString("firstname");
            	String profilepicPath= resultSet.getString("profilepicPath");
            	
            	SearchResults.add(new FriendList(userID, firstname, profilepicPath));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		return SearchResults;
    	  
      }
}
