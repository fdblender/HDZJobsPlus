<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage"><b>HDZ Careers</b></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
      <li><a href="#">About</a></li>
      <li><a href="./Jobs">Jobs</a></li>
      <c:if test="${role =='applicant'}">  
        <li><a href="./YourApplications">Your Applications</a></li>
        <li><a href="./applicantprofile.jsp">My Profile</a></li>
        </c:if>
        <c:if test="${role != 'applicant'}">
        <li><a href="./PendingAction">Home</a></li>
        </c:if>
         <c:if test="${user != null}">  
        <li><a href="<%=request.getContextPath() %>/Logout">Log Out</a></li>
        </c:if>
        <c:if test="${user == null}">
        <li><a href="login.jsp">Login</a></li>
        <li><a href="./newapplicant.jsp">Sign Up</a>
        </c:if>
        <li><a href="#">Contact</a></li>
      </ul>
    </div>
  </div>
</nav>

<%-- 

<nav class="navbar navbar-default" style="background-color: #01579b">
  <div class="container-fluid ">
    <div class="navbar-header" >
      <a class="navbar-brand " href="" style="color: #fff;font-weight: bold;font-size: 20px">HDZ Jobs</a>
    </div>
    <ul class="nav navbar-nav">
       <li ><a href="./Jobs" style="color: #fff;font-weight: bold;font-size: 16px" >Jobs</a></li>	  
       <c:if test="${role =='applicant'}">  
      <li ><a href="./YourApplications" style="color: #fff; font-weight: bold;font-size: 16px" >Your Applications</a></li> 
      <li><a href="./applicantprofile.jsp" style="color: #fff;font-weight: bold;font-size: 16px">My Profile</a></li>
    </c:if>
      <c:if test="${role != 'applicant'}">
      <li><a href="./PendingAction" style="color: #fff;font-weight: bold;font-size: 16px" >Home
      </a></li>
      </c:if>
    
        <c:if test="${user != null}">  
      <li ><a href="<%=request.getContextPath() %>/Logout"  style="color: #fff;font-weight: bold;font-size: 16px">Log Out</a></li>
    </c:if>
    <c:if test="${user == null}"> 
     <li ><a href="login.jsp"  style="color: #fff;font-weight: bold;font-size: 16px">Log Out</a></li>
    </c:if>
    </ul>
 
  </div>
</nav> --%>