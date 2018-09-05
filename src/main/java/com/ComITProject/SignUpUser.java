package com.ComITProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpUser {
	public SignUpUser() {
		super();
	}
	public void SignUp(String username, String firstname, String lastname, String emailID, String password) throws ClassNotFoundException{
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
		PreparedStatement ps = null;
		
		try {
			String SignUpQuery = "insert into p2flife.reguser(username,firstname,lastname,emailID,password) values(?,?,?,?,?)";
			ps = connect.prepareStatement(SignUpQuery);
			ps.setString(1, username);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, emailID);
			ps.setString(5, password);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	} 

}
