package com.ComITProject;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ComITProject.LoginValidation;

@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
        super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/mainPages/LoginHtml.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				String username = request.getParameter("username");
				String password = request.getParameter("password");
				LoginValidation ob_login =new LoginValidation();
				boolean result = false;
					try {
						result = ob_login.logincheck(username, password);
					} catch (ClassNotFoundException e)
					{
						e.printStackTrace();
					}
					
							if (result) {
								LoginValidation obj_lv = new LoginValidation();
								
								try {
									int userID = obj_lv.getUserID(username);
									request.getSession().setAttribute("userID1", userID);
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								request.getSession().setAttribute("username", username);
								request.getRequestDispatcher("/TimelineViewerServlet").forward(request, response);
							}
							else {
								request.setAttribute("message", "Invalid Credentials");
								request.getRequestDispatcher("/WEB-INF/mainPages/LoginHtml.jsp").forward(request, response);
							}	
			}
		}