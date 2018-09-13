package com.ComITProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TimelineServlet")
public class TimelineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimelineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ImagePath = (String) request.getSession(false).getAttribute("imagePath");
		String selDate = (String) request.getSession(false).getAttribute("selDate");
		String story = (String) request.getSession(false).getAttribute("story");
		int userID= (int) request.getSession(false).getAttribute("userID1");
		AddTimelineToDatabase obj = new AddTimelineToDatabase();
        try {
			obj.AddTimeline(selDate, story, ImagePath, userID);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/TimelineViewerServlet").forward(request, response);	
	}

}
