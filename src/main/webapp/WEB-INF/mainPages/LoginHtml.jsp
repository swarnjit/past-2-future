<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="../included/metaData.jsp" %> 
</head>
<body id="grad1">
  <%@ include file="../included/header.jsp" %>   
<div class="container-fluid">
  <div class="row">
   <div class="col-sm-2"></div>
    <div class="col-sm-3">
      <h1>Login</h1>
         <form action= "/login.do" method="post">
      <div class="form-group">
        <label for="text">Username:</label>
        <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
      </div>
      <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
      </div>
      <div class="form-group form-check">
        <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
        </label>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
         </form>
    </div>
   
    <div class="col-sm-7">
         
    </div>
  </div>
  <%@ include file="../included/footer.jsp" %>
</div>

</body>
</html>