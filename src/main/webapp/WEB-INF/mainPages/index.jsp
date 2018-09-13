<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<%@ include file="../included/metaData.jsp" %> 
	</head>
			<body>
  	<%@ include file="../included/header.jsp" %>   
		<div class="container-fluid">
			<span><br></span>
				  <div class="row">
				  <div class="col-md-2">
				  <span class="glyphicon glyphicon-globe logo slideanim"></span></div>
				  <div class="col-md-8">
				   <div id="demo" class="carousel slide" data-ride="carousel">
				
				  <ul class="carousel-indicators">
				    <li data-target="#demo" data-slide-to="0" class="active"></li>
				    <li data-target="#demo" data-slide-to="1"></li>
				    <li data-target="#demo" data-slide-to="2"></li>
				  </ul>
				  
				
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="/img/1.png" alt="Los Angeles" width="1100" height="500">
				    </div>
				    <div class="carousel-item">
				      <img src="/img/2.png" alt="Chicago" width="1100" height="500">
				    </div>
				    <div class="carousel-item">
				      <img src="/img/3.png" alt="New York" width="1100" height="500">
				    </div>
				  </div>
				  
				  <!-- Left and right controls -->
				  <a class="carousel-control-prev" href="#demo" data-slide="prev">
				    <span class="carousel-control-prev-icon"></span>
				  </a>
				  <a class="carousel-control-next" href="#demo" data-slide="next">
				    <span class="carousel-control-next-icon"></span>
				  </a>
		</div>
		</div>
		<div class="col-md-2"></div>

  		</div>
  		<%@ include file="../included/footer.jsp" %>
		</div>

	</body>
</html>