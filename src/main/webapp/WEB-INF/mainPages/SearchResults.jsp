<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../included/metaData.jsp" %> 
</head>
<body data-spy="scroll">
	 <%@ include file="../included/header.jsp" %>
	 <div class="container-fluid" style="margin-top:50px">
	 <div class="row">
	 			<div class="col-md-1">
				 </div>
			 <div class="col-md-3">
			 <h2 style="text-align:center"></h2>
			 
				<c:forEach items="${profileinfo}" var="profile">
				<div class="card">
				  <img src="${profile.profilepicPath}" alt="Profile Pic" style="width:100%">
				  <h1>${profile.username}</h1>
				  <p class="title">${profile.emailID}</p>
				  
				 
				  <form action="/ProfileServlet?reciever=" method="GET">
				  <input type="hidden" name="reciever" id="profileInfo" value="${profile.userID}">
				  <p><input type="submit" class="button1" value="Profile"/></p>
				 </form>
				 
				</div>	
				</c:forEach>
				</div>
			 
				 <div class="col-md-3">
				 <h2 class="mt-4">Results found for "${searchstring}"</h2>
				 					<span><br><br></span>
				 					 <% String CurrentUser= session.getAttribute("userID1").toString(); %>
				 					 <% int CurrentUserID = Integer.parseInt(CurrentUser); %>
				 					<c:set var="CurrentUserID" value="CurrentUserID" scope="page" />
				 					<c:choose>
				 					<c:when test="${!empty searchResults }">
								 	<c:forEach items="${searchResults}" var="search">
								 	<c:if test="${search.user_id!=pageScope.CurrentUSerID }">
								 	<table class="table">
								    		<tbody>
								      		<tr>
								        	
								        	 <td><img src="${search.profilepicPath }" alt="Profile Pic" style="width:50px; height:50px;"></td>
								        	<td><a href="/ProfileServlet?reciever=${search.user_id}">${search.firstname}</a></td>
								        	  
								        	<td align="right">
											  <form action="/ProfileServlet" method="GET" >
											<input type="hidden" name="reciever" id="reciever" value="${search.user_id}">
										    <p><input type="submit" class="btn btn info" value="See Profile"/></p>
										    </form>

										    </td>
								      		</tr>
					
									    	</tbody>
							  		</table>
							  		</c:if>
									</c:forEach>
									</c:when>
									<c:otherwise>
									<h4>No user found</h4>
									</c:otherwise>
									</c:choose>
				 </div>
				
									 <div class="col-md-5">
									 </div>
	 </div>
	 </div>
	 <%@ include file="../included/footer.jsp" %>



</body>
</html>
	 