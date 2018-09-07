<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-md bg-main navbar-dark">
        <a class="navbar-brand" href="/LandingPageServlet"><img src="/img/logo.png" alt="logo" style="width:40px;"></a>
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
        </div>  
      </nav>
