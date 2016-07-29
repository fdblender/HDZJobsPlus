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
#draggable {
	width: 0px;
	height: 0px;
	padding: 0em;
}

#resizable {
	width: 150px;
	height: 150px;
	padding: 0.5em;
}

#resizable h3 {
	text-align: center;
	margin: 0;
}

#red, #green, #blue {
	float: left;
	clear: left;
	width: 300px;
	margin: 15px;
}

#swatch {
	width: 120px;
	height: 100px;
	margin-top: 18px;
	margin-left: 350px;
	background-image: none;
}

#red .ui-slider-range {
	background: #ef2929;
}

#red .ui-slider-handle {
	border-color: #ef2929;
}

#green .ui-slider-range {
	background: #8ae234;
}

#green .ui-slider-handle {
	border-color: #8ae234;
}

#blue .ui-slider-range {
	background: #01579b;
}

#blue .ui-slider-handle {
	border-color: #01579b;
}
</style>
<script src="js/pendingAction.js"></script>
<title>Suitable Applicants</title>
</head>
<body id="body" class="ui-widget-content" style="border: 0;">
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">

		<div style="background-color: white;" class="panel-body">
			<c:set var="mesL" scope="session" value="${message}" />
			<c:if test="${mesL != null}">
				<div class="alert alert-success">
					<strong>${message}</strong> <span id="showSearchTerm"></span>
				</div>
			</c:if>
			<c:set var="job" scope="session" value="${job}" />
			<div class="row">
				<div class="col-sm-1"></div>
				<div class="col-sm-10">
				<input type="hidden" id="jobid" name="jobid" value="${job.jobsid}">
				<c:if test="${job != null}">
								<table class="table table-bordered">

									<thead>
										<tr>											
											<th>Job Id</th>
											<th>Job Title</th>
											<th>Job description</th>
											<th>Number Of Openings</th>
										</tr>
									</thead>
										<tr>
											<td><c:out value="${job.jobsid}"></c:out></td>
											<td><c:out value="${job.hdzPosition.position}"></c:out></td>
											<td><c:out value="${job.description}"></c:out></td>
											<td><c:out value="${job.numberopenings}"></c:out></td>
											
									
								</table>
								</c:if>
								<br/>
								
				<table class="table table-bordered">

									<thead>
										<tr>
											<th>AppId</th>
											<th>Applicant Name</th>
											<th>Applicant Skills</th>
											<c:if test="${job != null}">
											<th></th></c:if>
											
										</tr>
									</thead>
									<c:forEach var="applicant" items="${applicantList}">
										<tr>
											<td><c:out value="${applicant.applicantid}"></c:out></td>
											<td><c:out value="${applicant.firstname}"></c:out></td>
											<td><c:forEach var="skill" items="${applicant.hdzApplicantskills}">
											<c:out value="${skill.skills}"></c:out><br/>
											</c:forEach></td>
											<c:if test="${job != null}">
											<td><a class="btn btn-default btn-lg"
											 href="Apply?applicantid=${applicant.applicantid}">
													Apply Job</a></td></c:if>
									</c:forEach>
								</table>
				
				
				
				
				
					
				</div>
				<div class="col-sm-1"></div>
			</div>
		</div>
	</div>

</body>
</html>