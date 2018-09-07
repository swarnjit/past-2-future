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
	public List<Profile> getProfileByUsername(String username) throws ClassNotFoundException {
		List<Profile> profile = new ArrayList<Profile>();
		SqlConnection sqlconnection = new SqlConnection();
		Connection connect = sqlconnection.get_Connection();
        String sql = "SELECT firstname, emailID  FROM p2flife.reguser WHERE username=?";
        try {
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, username);

        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next())  {
        	String firstname = resultSet.getString("firstname");
        	String emailID = resultSet.getString("emailID");
        	profile.add(new Profile(username, emailID, firstname));
        }
        }catch(SQLException e) {
            e.printStackTrace();
        }
		return profile;
		
	}

}
