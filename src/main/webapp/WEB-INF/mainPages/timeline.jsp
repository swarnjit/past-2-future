<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
<!DOCTYPE html>
<html lang="en">
<head>
   <%@ include file="../included/metaData.jsp" %> 
  <script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v3.0";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));</script>
   
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
 <div class="col-md-2"></div>
 <div class="col-md-7">
 <div id="status-overlay" style="display: none"></div>
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
          <button type="submit" class="btn btn-primary">Add to Timeline</button>
        </form>
 </div>
 
 <div class="col-md-3"></div>
 </div>
 
  <div class="row top-buffer">
  </div>
  
 <div class="row">
			<div class="col-md-2">
	 
			
			
			
			</div>
	<div class="col-md-7">
	<div class="timeline">
	<c:forEach items="${timelineInfo}" var="timeline">
    	<div class="container left">
        <div class="content">
    	<div class="card" style="width: relative;">
  <img class="img-fluid" src="<c:url value="${timeline.selDate}"/>" alt="party">
  <div class="card-body">
  <h5 class="card-title">${timeline.imagepath}</h5>
    <p class="card-text">${timeline.story}</p>
    <div class="fb-share-button" 
    data-href="https://www.your-domain.com/your-page.html" 
    data-layout="button_count">
  </div>
  </div>
</div>
      </div>
    </div> 
  </c:forEach>
  </div>
</div>
<div class="col-md-3"></div>
</div>
<%@ include file="../included/footer.jsp" %>
</div>


</body>
</html>
