package com.ComITProject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/TimelineViewerServlet")
public class TimelineViewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TimelineViewer timelineViewer = new TimelineViewer();
	private ProfileViewer profileViewer = new ProfileViewer();
    public TimelineViewerServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = (int) request.getSession(false).getAttribute("userID1");
		try {
			request.setAttribute("timelineInfo", timelineViewer.getTimelineByUsername(userID, 10));
			request.setAttribute("profileinfo", profileViewer.getProfileByUserID(userID));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/mainPages/timeline.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = (int) request.getSession(false).getAttribute("userID1");
		
		try {
			request.setAttribute("timelineInfo", timelineViewer.getTimelineByUsername(userID, 10));
			request.setAttribute("profileinfo", profileViewer.getProfileByUserID(userID));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/mainPages/timeline.jsp").forward(request, response);
	}

}
