package com.ComITProject;

import java.io.File;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@WebServlet("/ChangeProfilePicServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 50)
public class ChangeProfilePicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "C:\\Users\\Owner\\eclipse-workspace\\past-2-future\\src\\main\\webapp\\profileimg";
    public ChangeProfilePicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private ProfileViewer profileViewer = new ProfileViewer();
	private ViewFriends viewFriends = new ViewFriends();
	private TimelineViewer timelineViewer = new TimelineViewer();
	private ChangeProfilePic obj = new ChangeProfilePic();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	
		int userID = (int) request.getSession(false).getAttribute("userID1");
	    if(ServletFileUpload.isMultipartContent(request)){
	            try {
	                List<FileItem> multiparts = new ServletFileUpload(
	                                         new DiskFileItemFactory()).parseRequest(request);
	              
	                for(FileItem item : multiparts){
	                    if(item.isFormField()){    
	                    }{
	                    	String name = new File(item.getName()).getName();
	                        item.write( new File(UPLOAD_DIR + File.separator + name));
	                        String profilepicPath = "/profileimg/" + name;
	                        obj.ChangeProfilePicture(profilepicPath, userID);
	                    }
	                }
	            } catch (Exception ex) {
	               request.setAttribute("message", "File Upload Failed due to " + ex);
	            }          
	         
	        }
							    try {
									request.setAttribute("profileinfo", profileViewer.getProfileByUserID(userID));
									request.setAttribute("viewFriends", viewFriends.getFriendsListByUserId(userID, userID, 1));
									request.setAttribute("friendRequests", viewFriends.getFriendsListByUserId(userID, userID, 0));
									request.setAttribute("timelineInfo", timelineViewer.getTimelineByUsername(userID, 2));
									request.setAttribute("reciever", userID);
									request.setAttribute("userID1", userID);
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		
	    request.getRequestDispatcher("/WEB-INF/mainPages/Profile.jsp").forward(request, response);

			}
}
