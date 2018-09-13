package com.ComITProject;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddFriendServlet
 */
@WebServlet("/AddFriendServlet")
public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID2 = Integer.parseInt(request.getParameter("reciever"));
		int userID1 = (int) request.getSession().getAttribute("userID1");
		int actionID = userID1;
		
		
		AddFriend addFriend = new AddFriend();
		
			try {
				if(userID1<userID2) {
					int user_id1= userID1;
					int user_id2 = userID2;
					addFriend.SendRequest(user_id1, user_id2, 0, actionID);
				}else {
					int user_id2 = userID1;
					int user_id1 = userID2;
					addFriend.SendRequest(user_id1, user_id2, 0, actionID);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("StatusOfRequest", "Friend Request Sent");
			
			request.setAttribute("ReqUsername", userID2);
		
		
		request.getRequestDispatcher("/ProfileServlet").forward(request, response);	
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/ProfileServlet").forward(request, response);	
	}

}
