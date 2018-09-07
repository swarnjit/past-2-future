<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../included/metaData.jsp" %>
</head>
<body id="grad1">
<%@ include file="../included/header.jsp" %> 
<div class="container-fluid">
<div class="row">
<div class="col-sm-2">
</div>
<div class="col-sm-3">
<h1>Sign-Up Please</h1>
<form action="/SignUpServlet" onsubmit="return validateForm()" method="POST" name="SignUp">
         <div class="form-group">
            <label for="text">Username:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter Unique Username" name="username">
		            <span><c:if test="${message != null }">
					<div class="alert alert-danger mt-3" role="alert">
		 				${message}
					</div>
					</c:if></span><br>
          </div>
          <div class="form-group">
            <label for="text">Firstname:</label>
            <input type="text" class="form-control" id="firstname" placeholder="Enter Your First Name" name="firstname">
          </div>
          <div class="form-group">
            <label for="text">Lastname:</label>
            <input type="text" class="form-control" id="lastname" placeholder="Enter Your Last Name" name="lastname">
          </div>
          <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter Your Email ID" name="emailID">
          </div>
          <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
          </div>
          <div class="form-group">
              <label for="pwd">Re-enter Password:</label>
              <input type="password" class="form-control" id="pwd" placeholder="Re-Enter password" name="re-pswd">
            </div>
            <div>
            </div>
          <button type="submit" class="button1">Submit</button>
          </form>
</div>
<div class="col-sm-4">
</div>

<div class="col-sm-3">
</div>
</div>
<%@ include file="../included/footer.jsp" %>
</div>

</body>
</html>