<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../included/metaData.jsp" %> 
</head>
<body >
  <%@ include file="../included/header.jsp" %>   
<div class="container-fluid" style="min-height:600px;">
  <div class="row">
   <div class="col-sm-2"></div>
    <div class="col-sm-3">
       <h2 class="mt-4">Please Login</h2>
         <form action= "/login.do" method="post">
      <div class="form-group">
        <label for="text">Username:</label>
        <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
      </div>
      <span><c:if test="${message != null }">
		<div class="alert alert-danger mt-3" role="alert">
 				${message}
		</div>
	</c:if></span><br>
      <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
      </div>
      <button type="submit" class="button1">Submit</button>
         </form>
    </div>
   
    <div class="col-sm-7">
         
    </div>
  </div>
  
 
</div>
<div class="container-fluid">
 <%@ include file="../included/footer.jsp" %>
</div>
</body>
</html>