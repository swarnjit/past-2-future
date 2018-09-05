<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="java.util.*, java.io.*" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.io.File"%>
<%@ page import="java.lang.String"%>
<%@ page contentType="text/html;charset=UTF-8" %>


 
<%
String selDate=request.getParameter("selDate");
String story=request.getParameter("story");
try
{
String ImageFile="";
String itemName = "";
boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if (!isMultipart)
{
}
else
{
FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
List<FileItem> items = null;
try
{
items = upload.parseRequest(request);
}
catch (FileUploadException e)
{
e.getMessage();
}
 
Iterator<FileItem> itr = items.iterator();
while (itr.hasNext())
{
FileItem item = (FileItem) itr.next();
if (item.isFormField())
{
String name = item.getFieldName();
String value = item.getString();
if(name.equals("ImageFile"))
{
ImageFile=value;
}
 
}
else
{
try
{
itemName = item.getName();
String addTime = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString();
String addTimeNoSpace = addTime.replaceAll("\\s+","");
out.print(addTime);
out.print(selDate);
out.print(story);
String str =itemName;
String kept = str.substring( 0, str.indexOf("."));
String remainder = str.substring(str.indexOf(".")+1);
String addTimeNoDots = addTimeNoSpace.replaceAll("[^a-zA-Z0-9]+","");
itemName = addTimeNoDots +"."+ remainder;
File savedFile = new File("c:\\Users\\Owner\\eclipse-workspace\\past-2-future\\src\\main\\webapp\\timelineimage\\"+itemName);
String pathOfTheImage = "c:\\Users\\Owner\\eclipse-workspace\\past-2-future\\src\\main\\webapp\\timelineimage\\" +itemName;
item.write(savedFile);

}
catch (Exception e)
{
out.println("Error"+e.getMessage());
}
}
}
}
}
catch (Exception e){
out.println(e.getMessage());
}

%>