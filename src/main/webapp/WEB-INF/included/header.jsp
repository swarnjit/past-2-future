<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<nav class="navbar navbar-expand-md bg-main navbar-dark">
		<div class="container-fluid">
		<div class="navbar-header">
        	<a class="navbar-brand" href="/LandingPageServlet"><img src="/img/logo1.png" alt="logo" style="width:100px; height:40px"></a></div>
        		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
          			<span class="navbar-toggler-icon"></span>
        		</button>
        			<div class="collapse navbar-collapse" id="collapsibleNavbar">
          			<ul class="navbar-nav">
          			<c:choose>
    
           				<c:when test="${empty sessionScope.username}">
				            <li class="nav-item" >
				              <a class="navbar-brand" href="/login.do" >Login</a>
				            </li>
				            <li class="nav-item">
				              <a class="navbar-brand" href="/SignUpServlet">SignUp</a>
				            </li> 
             			</c:when>
             			<c:otherwise>
				            <li class="nav-item">
				              <a class="navbar-brand" href="/TimelineViewerServlet">TimeLine</a>
				            </li>
				            <li class="nav-item">
				              <a class="navbar-brand" href="/LogoutServlet">Logout</a>
				            </li>
				           
            			</c:otherwise>
           			 </c:choose>
          			</ul>
          			<form class="form-inline" action="/SearchServlet" Method="GET">
						    <input class="form-control mr-sm-2" name="search" value="" type="text" placeholder="Search">
						    <button class="btnsearch" style="border: none; outline: 0; display: inline-block;  padding: 8px;  color: white;  background-color: #97a1b2; text-align: center;  cursor: pointer; width: 30px; font-size: 18px;" type="submit">Search</button>
  					</form>
        </div>  
        </div>
      </nav>
