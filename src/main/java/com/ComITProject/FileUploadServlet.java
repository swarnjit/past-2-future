package com.ComITProject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.lang.String;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.annotation.MultipartConfig;



@WebServlet(urlPatterns = { "/fileUploadServlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 50) //Limiting size for the uploaded file
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "C:\\Users\\Owner\\eclipse-workspace\\past-2-future\\src\\main\\webapp\\timelineimage";
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(item.isFormField()){
                    	if(item.getFieldName().equals("selDate"))
                        {   
                          String selDate =item.getString();
                          request.getSession().setAttribute("selDate", selDate);
                        }


                        if(item.getFieldName().equals("story"))
                        {   
                             String story =item.getString();
                             request.getSession().setAttribute("story", story);
                        }

                        
                    }
                    else {
                    	String name = new File(item.getName()).getName();
                        String addTime = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString();
        				String addTimeNoSpace = addTime.replaceAll("\\s+","");
        				String str = name;

        				String basename = FilenameUtils.getBaseName(str); // code block to change uploaded file name to avoid the problem of file override with same names
        				String extension = FilenameUtils.getExtension(str);
        				String addTimeNoDots = addTimeNoSpace.replaceAll("[^a-zA-Z0-9]+","");
        				name = addTimeNoDots + basename + "." +extension; 
                        item.write( new File(UPLOAD_DIR + File.separator + name));
                        String ImagePath = "/timelineimage/" + name;
                        request.getSession().setAttribute("imagePath", ImagePath);
                        
                    }
                }
           
               
               
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
        request.getRequestDispatcher("/TimelineServlet").forward(request, response);
     
    }
  
}