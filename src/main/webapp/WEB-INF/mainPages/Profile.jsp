<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../included/metaData.jsp" %> 
</head>
<body id="grad1">
	 <%@ include file="../included/header.jsp" %>
	 <div class="container-fluid">  
	 <div class="row">
		 <div class="col-md-1">
		 		
		 </div>
			 <div class="col-md-3">
			 <h2 style="text-align:center"></h2>
			 <% String ReqUsername = (String) request.getAttribute("ReqUsername"); %>
			 <% String CurrentUser= (String) session.getAttribute("username"); %>
			<%=ReqUsername %>
			<%=CurrentUser %>
			 
			 
				<c:forEach items="${profileinfo}" var="profile">
				<div class="card">
				  <img src="/img/me.jpg" alt="John" style="width:100%">
				  <h1>${profile.username}</h1>
				  <p class="title">${profile.emailID}</p>
				  <%if(ReqUsername.equals(CurrentUser)){
					  %>
					  <form action="/ViewFriendsServlet" method="POST" >
					  <p><button class="button1" >View Friends</button></p>
					  </form>  
					  <%
				  }
				  else{
					  %>
					  <c:choose>
					  <c:when test="${empty StatusOfRequest}">
					  <form action="/AddFriendServlet?reciever=" method="GET" >
					  <input type="hidden" name="reciever" id="reciever" value="<%=ReqUsername %>">
				  <p><input type="submit" class="button1" value="Add Friend"/></p>
				  </form>
					  
				  </c:when>
				  <c:otherwise>
				  
				  <p><input type="submit" class="button1" value="Friend Request Sent"/></p>
				  </c:otherwise>
				  </c:choose>

				  <%
				  }
				  %>
				 
				</div>	
				</c:forEach>
				</div>
			 
	 <div class="col-md-8">
	
	 </div>
	 </div>
	 </div> 
	 <%@ include file="../included/footer.jsp" %>



</body>
</html>
	 