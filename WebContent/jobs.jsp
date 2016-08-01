<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script src="javascripts/home.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>



<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://jqueryui.com/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<style>
.pageheader {
	text-align: center;
	color: #3333ff;
}

.subheader {
	text-align: center;
}

.sectionheader {
	font-weight: bold;
	color: #3333ff;
}

.theader {
	background-color: #f2f2f2;
}
</style>

<jsp:include page="bootstrap.jsp" />
<title>Job Openings</title>
</head>

<body id="body" class="ui-widget-content" style="border: 0;">
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<div class="col-sm-1"></div>
		<div class="col-sm-6">
			<h3 class="sectionheader">Job Openings</h3>			
			<h4>${query}</h4>
			<form action="JobSearch">
				<input type="text" name="search" id="search" /> <input
					type="submit" name="submit" id="submit" value="Search" />
			</form>
			<br/>
			<table class="table table-bordered">
				<tr>
					<th>Position</th>
					<th>Action</th>
				</tr>
				<c:forEach var="job" items="${jobs}">
					<tr>
						<td>${job.hdzPosition.position}</td>
						<td><c:if test="${role =='applicant'}">
								<form action="Apply">
									<input type="hidden" name="jobid" id="jobid"
										value="${job.jobsid}" /> 
									<input type="submit" name="submit" id="submit" value="Apply" />
								</form>
							</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-sm-5"></div>
	</div>
</body>

</html>