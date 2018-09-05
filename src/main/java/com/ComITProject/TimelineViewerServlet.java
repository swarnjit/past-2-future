package com.ComITProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimelineViewerServlet
 */
@WebServlet("/TimelineViewerServlet")
public class TimelineViewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TimelineViewer timelineViewer = new TimelineViewer();
    public TimelineViewerServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession(false).getAttribute("username");
		try {
			request.setAttribute("timelineInfo", timelineViewer.getTimelineByUsername(username));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/mainPages/timeline.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession(false).getAttribute("username");
		try {
			request.setAttribute("timelineInfo", timelineViewer.getTimelineByUsername(username));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/mainPages/timeline.jsp").forward(request, response);
	}

}
