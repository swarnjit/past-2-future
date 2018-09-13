package com.ComITProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteFriendServlet
 */
@WebServlet("/DeleteFriendServlet")
public class DeleteFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProfileViewer profileViewer = new ProfileViewer();
	private ViewFriends viewFriends = new ViewFriends();
	private TimelineViewer timelineViewer = new TimelineViewer();
    public DeleteFriendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID2 = Integer.parseInt(request.getParameter("reciever"));
		int userID1 = (int) request.getSession().getAttribute("userID1");
		AddFriend addFriend = new AddFriend();
		
		try {
			if(userID1<userID2) {
				int user_id1= userID1;
				int user_id2 = userID2;
				addFriend.DeleteFriend(user_id1, user_id2);
			}else {
				int user_id2 = userID1;
				int user_id1 = userID2;
				addFriend.DeleteFriend(user_id1, user_id2);
			}
			request.setAttribute("profileinfo", profileViewer.getProfileByUserID(userID1));
			request.setAttribute("viewFriends", viewFriends.getFriendsListByUserId(userID1, userID1, 1));
			request.setAttribute("friendRequests", viewFriends.getFriendsListByUserId(userID1, userID1, 0));
			request.setAttribute("timelineInfo", timelineViewer.getTimelineByUsername(userID1, 2));
			request.setAttribute("reciever", userID1);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/mainPages/Profile.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}