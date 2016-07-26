<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default" style="background-color: #01579b">
  <div class="container-fluid ">
    <div class="navbar-header" >
      <a class="navbar-brand " href="login.jsp" style="color: #fff; font-weight: bold;font-size:22px">HDZ Jobs</a>
    </div>
    <ul class="nav navbar-nav">   	  
      <c:if test="${userrole == 1}">
      <li ><a href="yourapplications.jsp" style="color: #fff; font-weight: bold;font-size:16px" >Your Applications</a></li> 
      <li ><a href="./Jobs" style="color: #fff; font-weight: bold;font-size:16px" >Jobs</a></li>
      </c:if>
      <c:if test="${userrole == 2}">
      <li><a href="pendingAction.jsp" style="color: #fff; font-weight: bold;font-size:16px" >Pending Actions
      </a></li>
      <li> <a href="viewapplications.jsp" style="color: #fff; font-weight: bold;font-size:16px" >View Applications
      </a></li>        
      </c:if>      
      <li ><a href="<%=request.getContextPath() %>/Logout"  style="color: #fff; font-weight: bold;font-size:16px">Log Out</a></li>
    </ul>
  
  </div>
</nav>