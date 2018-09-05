package com.ComITProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginValidation {
	public boolean logincheck (String username, String password) throws ClassNotFoundException {
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
		PreparedStatement ps = null;
		boolean validity = false;
		try {
			String queryString = "SELECT username, password FROM p2flife.reguser where username=? and password=?";
		    ps = connect.prepareStatement(queryString);
		    ps.setString(1,username);
		    ps.setString(2,password);
		    ResultSet results = ps.executeQuery();

		    if (results.next()) {
		        validity = true;
		        
		    }else {
		         validity = false;
		         
		    }
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return validity;
	}


}
