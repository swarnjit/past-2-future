package com.ComITProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckExistingUser {
	public CheckExistingUser() {
		super();
	}
	public boolean checkUser (String username) throws ClassNotFoundException {
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
		PreparedStatement ps = null;
		boolean UserInSystem = false;
		try {
			String queryString = "SELECT username FROM p2flife.reguser where username=?";
		    ps = connect.prepareStatement(queryString);
		    ps.setString(1,username);
		    ResultSet results = ps.executeQuery();

		    if (results.next()) {
		       UserInSystem = true;
		        
		    }else {
		    	UserInSystem = false;
		         
		    }
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return UserInSystem;

}
}
