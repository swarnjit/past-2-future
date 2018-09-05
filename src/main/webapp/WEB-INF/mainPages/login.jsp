<%@page import="com.ComITProject.LoginValidation"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String username=request.getParameter("username");
String password=request.getParameter("password");
LoginValidation ob_login =new LoginValidation();
boolean result = ob_login.logincheck(username, password);
    if (result){
%>
    	<jsp:forward page="timeline.jsp" />
   <% 
   request.getSession().setAttribute("username", username);
   }
   else {
   %>
   <jsp:forward page="LoginHtml.jsp"/>
   <%
   }
   %> 

</body>
</html>