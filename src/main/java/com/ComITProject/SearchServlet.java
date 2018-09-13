package com.ComITProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ViewFriends searchresults = new ViewFriends();
	private ProfileViewer profileViewer = new ProfileViewer();
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int userID = (int) request.getSession(false).getAttribute("userID1");
		String SearchString=request.getParameter("search");
		request.setAttribute("searchResults", searchresults.getResultsBySearchString(SearchString));
		request.setAttribute("profileinfo", profileViewer.getProfileByUserID(userID));
		request.setAttribute("reciever", userID);
		request.setAttribute("searchstring", SearchString);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
					request.getRequestDispatcher("/WEB-INF/mainPages/SearchResults.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
