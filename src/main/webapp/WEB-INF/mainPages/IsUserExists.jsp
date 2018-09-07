<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection connect = null;
	      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/p2flife", "root", "p2flife");
            PreparedStatement ps = connect.prepareStatement("SELECT  * FROM p2flife.reguser where username=?");
            ps.setString(1,request.getParameter("username"));
            ResultSet res = ps.executeQuery();
            if(res.first()){
                out.print("User already exists");
            }else{
                out.print("User name is valid");
            }
        }catch (Exception e){
            System.out.println(e);  
        }
%>