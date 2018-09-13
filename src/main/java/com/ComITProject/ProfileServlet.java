package com.ComITProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfileViewer profileViewer = new ProfileViewer();
	private ViewFriends viewFriends = new ViewFriends();
	private TimelineViewer timelineViewer = new TimelineViewer();
	private AddFriend addFriend = new AddFriend();
	
	
    public ProfileServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int userID1 = Integer.parseInt(request.getParameter("reciever"));
			int userID2 = (int) request.getSession(false).getAttribute("userID1");
			if(userID1==userID2) {
				try {
					request.setAttribute("profileinfo", profileViewer.getProfileByUserID(userID1));
					request.setAttribute("viewFriends", viewFriends.getFriendsListByUserId(userID1, userID2, 1));
					request.setAttribute("friendRequests", viewFriends.getFriendsListByUserId(userID1, userID2, 0));
					request.setAttribute("timelineInfo", timelineViewer.getTimelineByUsername(userID1, 2));
					request.setAttribute("reciever", userID1);
				    } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }
							request.getRequestDispatcher("/WEB-INF/mainPages/Profile.jsp").forward(request, response);
			}else {
				try {
					if(userID1<userID2) {
						int user_id1= userID1;
						int user_id2 = userID2;
						request.setAttribute("statusOfFriendship", addFriend.CheckFriendship(user_id1, user_id2) );
						request.setAttribute("profileinfo", profileViewer.getProfileByUserID(user_id1));
						request.setAttribute("viewFriends", viewFriends.getFriendsListByUserId(user_id1, user_id2, 1));
						request.setAttribute("friendRequests", viewFriends.getFriendsListByUserId(user_id1, user_id2, 0));
						request.setAttribute("timelineInfo", timelineViewer.getTimelineByUsername(user_id1, 2));
						request.setAttribute("reciever", user_id1);
						request.getRequestDispatcher("/WEB-INF/mainPages/Profile.jsp").forward(request, response);
					}else {
						int user_id2 = userID1;
						int user_id1 = userID2;
						request.setAttribute("statusOfFriendship", addFriend.CheckFriendship(user_id1, user_id2) );
						request.setAttribute("profileinfo", profileViewer.getProfileByUserID(userID1));
						request.setAttribute("viewFriends", viewFriends.getFriendsListByUserId(user_id2, user_id1, 1));
						request.setAttribute("friendRequests", viewFriends.getFriendsListByUserId(user_id1, user_id2, 0));
						request.setAttribute("timelineInfo", timelineViewer.getTimelineByUsername(userID1, 2));
						request.setAttribute("reciever", user_id2);
						request.getRequestDispatcher("/WEB-INF/mainPages/Profile.jsp").forward(request, response);
					}
					
					
					
					
				    } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				    }
							
			}
			
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
					request.getRequestDispatcher("/WEB-INF/mainPages/Profile.jsp").forward(request, response);
	}

}
