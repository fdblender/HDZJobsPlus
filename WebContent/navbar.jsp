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
<br/> <br/><br/><br/>
 
<!--  <div id="myCarousel" class="carousel slide" data-ride="carousel">
  Indicators
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  Wrapper for slides
  <div class="carousel-inner" role="listbox">
    <div class="item active" align="center">
      <img src="images/party2.jpeg" alt="New York" width="50%">
      <div class="carousel-caption">
        <h3>CEO</h3>
        <p>Our CEO is lorem ipsum.</p>
      </div>
    </div>

    <div class="item" align="center">
      <img src="images/part3.jpeg" alt="Chicago" width="50%">
      <div class="carousel-caption">
        <h3>Success</h3>
        <p>Thanks to our Employees.</p>
      </div>
    </div>

    <div class="item" align="center">
      <img src="images/party1.jpeg" alt="Los Angeles" width="50%">
      <div class="carousel-caption">
        <h3>Celebration</h3>
        <p>Yay!! Party.</p>
      </div>
    </div>
  </div>

  Left and right controls
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div> -->