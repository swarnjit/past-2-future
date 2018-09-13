package com.ComITProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeProfilePic {
public ChangeProfilePic() {
	super();
}
public void ChangeProfilePicture (String profilepicPath, int userID) throws ClassNotFoundException {
	SqlConnection sqlconnection = new SqlConnection();
	Connection connect = sqlconnection.get_Connection();
	PreparedStatement ps = null;
	try {
		String changeProfilePic= "update p2flife.reguser set profilepicPath=? Where userID=?";
		ps = connect.prepareStatement(changeProfilePic);
		ps.setString(1, profilepicPath);
		ps.setInt(2, userID);
		ps.executeUpdate();
		
	} 
	catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	
}
}
