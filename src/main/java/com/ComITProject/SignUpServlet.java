package com.ComITProject;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ComITProject.SignUpUser;
@WebServlet(urlPatterns="/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/mainPages/SignUpHtml.jsp").forward(request, response);
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  
  String username=request.getParameter("username");
  String firstname=request.getParameter("firstname");
  String lastname=request.getParameter("lastname");
  String emailID=request.getParameter("emailID");
  String password=request.getParameter("password");
  String profilepicPath = request.getParameter("ProfilePic");
  boolean IsUserInSystem = false;
  CheckExistingUser obj_CheckUser = new CheckExistingUser();
  try {
		IsUserInSystem = obj_CheckUser.checkUser(username);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  if(IsUserInSystem) {
	  request.getSession().setAttribute("message1", "Username already registred");
		request.getRequestDispatcher("/WEB-INF/mainPages/SignUpHtml.jsp").forward(request, response);;
  }
  else {
  try {
	SignUpUser obj_SignUpUser= new SignUpUser();
			obj_SignUpUser.SignUp(username, firstname, lastname, emailID, password, profilepicPath);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

 
   RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/mainPages/LoginHtml.jsp");
   rd.forward(request, response);
  }}
 }

