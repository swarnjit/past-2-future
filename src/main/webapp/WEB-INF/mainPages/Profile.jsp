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
							 <% String ReqUsername = request.getAttribute("reciever").toString(); %>
							 <% String CurrentUser= session.getAttribute("userID1").toString(); %>
			 
				<c:forEach items="${profileinfo}" var="profile">
				<div class="card">
				  <img src="${profile.profilepicPath}" alt="Profile Pic" style="width:100%">
				  <h1>${profile.username}</h1>
				  <p class="title">${profile.emailID}</p>
				  
				 
				  <%if(ReqUsername.equals(CurrentUser)){
					  %>
					   <form action="/ChangeProfilePicServlet" method="POST" enctype = "multipart/form-data">
				  		<div class="image-upload">
			  		    <label for="file-input">
			            <img src="/img/fileupload.png" style=" width: 50px; height:20px;"/>Select New Picture
			    	    </label>
			    		<input id="file-input" name="ImageFile" type="file">
						</div>
				  <p><input type="submit" class="button1" value="Change Profile Picture"/></p>
					  </form> 
					  
					  <%
				  }
				  else{
					  %>
					  <c:choose>
					  <c:when test="${statusOfFriendship==1}">
					  <form action="/AddFriendServlet" method="GET" >
					  <input type="hidden" name="reciever" id="reciever" value="${profile.userID}">
				  <p><input type="submit" class="button1" value="Already a friend"/></p>
				  </form>
					  
				  </c:when>
				  <c:when test="${statusOfFriendship==0}">
				  <form action="/AddFriendServlet" method="GET" >
					  <input type="hidden" name="reciever" id="reciever" value="${profile.userID}">
				  <p><input type="submit" class="button1" value="Add Friend"/></p>
				  </form> 
				  </c:when>
				  <c:otherwise>
				  <p><input type="submit" class="button1" value="friend request sent "/></p> 
				  </c:otherwise>
				  </c:choose>

				  <%
				  }
				  %>
				 
				</div>	
				</c:forEach>
				</div>
			 
				 <div class="col-md-3">
				 <h2 class="mt-4">Friends</h2>
				 					<span><br><br></span>
				 					<fmt:parseNumber var = "CurrentUser" type = "number" value = "${profileUser}" />
				 					<c:choose>
				 					<c:when test="${!empty viewFriends }">
								 	<c:forEach items="${viewFriends}" var="friends">
								 	<table class="table">
								    		<tbody>
								      		<tr>
								        	
								        	 <td><img src="${friends.profilepicPath }" alt="Profile Pic" style="width:50px; height:50px;"></td>
								        	<td><a href="/ProfileServlet?reciever=${friends.user_id}">${friends.firstname}</a></td>
								        	  
								        	<td  align="right">
								        	<%if(ReqUsername.equals(CurrentUser)){
					  						%><form action="/DeleteFriendServlet" method="GET">
											<input type="hidden" name="reciever" id="reciever" value="${friends.user_id}">
										    <p><input type="submit" class="btn btn info" value="Delete Friend"/></p>
										    </form>
										<%
										  }
										  else{
											  %>
											  <form action="/ProfileServlet" method="GET" >
											<input type="hidden" name="reciever" id="reciever" value="${friends.user_id}">
										    <p><input type="submit" class="btn btn info" value="See Profile"/></p>
										    </form>
										  <%}
											  %>
										    </td>
								      		</tr>
					
									    	</tbody>
							  		</table>
									</c:forEach>
									</c:when>
									<c:otherwise>
									<h6>No Friends Yet</h6>
									</c:otherwise>
									</c:choose>
				 </div>
				 <div class="col-md-3">
				 <%if(ReqUsername.equals(CurrentUser)){
					  						%>
				 <h2 class="mt-4">Requests</h2>
				 <span><br><br></span>
				 					<fmt:parseNumber var = "CurrentUser" type = "number" value = "${profileUser}" />
				 					<c:choose>
				 					<c:when test="${!empty friendRequests }">
								 	<c:forEach items="${friendRequests}" var="requests">
								 	<table class="table">
								    		<tbody>
								      		<tr>
								        	
								        	 <td><img src="${requests.profilepicPath }" alt="Profile Pic" style="width:50px; height:50px;"></td>
								        	<td><a href="/ProfileServlet?reciever=${requests.user_id}">${requests.firstname}</a></td>
								        	<td><form action="/AcceptFriendServlet" method="GET" >
											<input type="hidden" name="reciever" id="reciever" value="${requests.user_id}">
										    <p><input type="submit" class="btn btn info" value="Accept"/></p>
										    </form></td>
								      		</tr>
					
									    	</tbody>
							  		</table>
									</c:forEach>
									</c:when>
									<c:otherwise>
									<h6>No Requests Yet</h6>
									</c:otherwise>
									</c:choose>
									<%}
				 %>
				 </div>
									 <div class="col-md-2">
									 <h2 class="mt-4">Recent Updates</h2>
									 <span><br><br></span>
									 <div class="row">
									 		<c:forEach items="${timelineInfo}" var="timeline">
												<div class="card" style="width: relative;">
										  		<img class="img-fluid" src="<c:url value="${timeline.selDate}"/>" alt="party" Style="height:150px; width:200px">
										  		<div class="card-body">
										  		<h5 id="#h5" class="card-title">${timeline.imagepath}</h5>
										    	<p class="card-text">${timeline.story}</p>
										    	
										  		</div>
												</div>
											</c:forEach>	
									 </div>
									 
									 </div>
	 </div>
	 </div>
	 <%@ include file="../included/footer.jsp" %>



</body>
</html>
	 