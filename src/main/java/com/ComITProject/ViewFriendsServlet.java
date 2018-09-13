package com.ComITProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewFriendsServlet")
public class ViewFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  private ViewFriends viewFriends = new ViewFriends();
    public ViewFriendsServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID1 = Integer.parseInt(request.getParameter("reciever"));
		int userID2 = (int) request.getSession(false).getAttribute("userID1");
		
		try {
			request.setAttribute("viewFriends", viewFriends.getFriendsListByUserId(userID1, userID2, 1));
			request.setAttribute("profileUser", userID1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/mainPages/ViewFriends.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/mainPages/ViewFriends.jsp").forward(request, response);
	}
	}


