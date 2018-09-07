<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../included/metaData.jsp" %> 
			   
			  <script>
			$( function() {
			    $( "#datepicker" ).datepicker({
			      changeMonth: true,
			      changeYear: true
			    });
			  } );
			</script>   
</head>
<body id="grad1">
	 <%@ include file="../included/header.jsp" %>
	 <div class="container-fluid">  
	 <div class="row">
	 <div class="col-md-1">
		 </div>
	 <div class="col-md-3">
	 <span><br><br><br></span>
	  <c:forEach items="${profileinfo}" var="profile">
				<div class="card">
				  <img src="/img/me.jpg" alt="John" style="width:100%">
				  <h1>${profile.username}</h1>
				  <p class="title">${profile.emailID}</p>
				  <form action="/ViewFriendsServlet" method="POST" >
					  <p><button class="button1" >View Friends</button></p>
					  </form> 
				  <form action="/ProfileServlet?reciever=" method="GET">
				  <input type="hidden" name="reciever" id="profileInfo" value="${profile.username}">
				  <p><input type="submit" class="button1" value="Profile"/></p>
				 </form>
				</div>	
				</c:forEach>
	 </div>
	 <div class="col-md-6">
	 	    <div id="status-overlay" style="display: none"></div>
	 	    <span><br><br><br></span>
		    <form action="/fileUploadServlet" method="POST" enctype = "multipart/form-data">
				<div class="form-group">
		            <label for="datepicker">Enter date:</label>
		        
		            <input class="form-control" type="text" title="Select a date for an event you want to add" name="selDate" id="datepicker" value="">       
		            <label for="text">Say Something about the post:</label>     
		        	<textarea class="form-control" title="Say Something" name="story" placeholder="Say Something"></textarea>
	        	</div>      
	            <div class="form-group">  
		        <div class="image-upload">
	  		    <label for="file-input">
	            <img src="/img/fileupload.png"/>
	    	    </label>
	    		<input id="file-input" name="ImageFile" type="file">
				</div>
				</div>
	            <button type="submit" class="button1">Add to Timeline</button>
            </form>
            <span><br></span>
            <div class="timeline">
					<c:forEach items="${timelineInfo}" var="timeline">
				    	<div class="container left">
				        <div class="content">
				    	<div class="card" style="width: relative;">
				  		<img class="img-fluid" src="<c:url value="${timeline.selDate}"/>" alt="party">
				  		<div class="card-body">
				  		<h5 id="#h5" class="card-title">${timeline.imagepath}</h5>
				    	<p class="card-text">${timeline.story}</p>
				    	
				  		</div>
						</div>
				      	</div>
				    	</div> 
				  </c:forEach>
</div>
    </div>
		 
		 <div class="col-md-2">
		 </div>
		 </div>
		 
		 <div class="row top-buffer">
		 </div>
		  
		
<%@ include file="../included/footer.jsp" %>
</div>


</body>
</html>
