package com.ComITProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileViewer profileViewer = new ProfileViewer();
	
    		public ProfileServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ReqUsername = request.getParameter("reciever");
		
		
		
		try {
			request.setAttribute("profileinfo", profileViewer.getProfileByUsername(ReqUsername));
			request.setAttribute("ReqUsername", ReqUsername);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/mainPages/Profile.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/mainPages/Profile.jsp").forward(request, response);
	}

}
