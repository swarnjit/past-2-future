package com.ComITProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	public static void main(String[] args) {
		SqlConnection sqlconnection = new SqlConnection();
		try {
			System.out.println(sqlconnection.get_Connection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection get_Connection() throws ClassNotFoundException{
		Connection connect = null;
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2flife", "root", "p2flife");
	     if(connect != null){
	      System.out.println("Database connected");
	     }
	    }
	    catch(SQLException e) {
	      System.err.println(e.getMessage());
	    }
		return connect;
	}

}