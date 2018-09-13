package com.ComITProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileViewer {
	public ProfileViewer() {
		super();
	}
	public List<Profile> getProfileByUserID(int userID1) throws ClassNotFoundException {
		List<Profile> profile = new ArrayList<Profile>();
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
        String sql = "SELECT userID, username, firstname, emailID, profilepicPath  FROM p2flife.reguser WHERE userID=?";
        try {
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setInt(1, userID1);

        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next())  {
        	int userID = resultSet.getInt("userID");
        	String username = resultSet.getString("username");
        	String firstname = resultSet.getString("firstname");
        	String emailID = resultSet.getString("emailID");
        	String profilepicPath = resultSet.getString("profilepicPath");
        	profile.add(new Profile(userID, username, emailID, firstname, profilepicPath));
        }
        }catch(SQLException e) {
            e.printStackTrace();
        }
		return profile;
		
	}

}
