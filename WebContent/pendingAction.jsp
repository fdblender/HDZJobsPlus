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
<title>Home</title>
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
			<div class="row">
				<div class="col-sm-1"></div>
				<div class="col-sm-10">
					<div id="accordion">
					<h3 style="background-color: #01579b; color: #ffffff;">Search Applications</h3>
						<div>
							<form action="ViewApplications" method="post">
								<div class="form-group">
									<label for="typeAssgn">Position:</label> <input type="text"
										name="position" id="position" value="" class="form-control">
									<input type="submit" name="submit" id="submit" value="Search">
								</div>


								<c:set var="application" scope="session" value="${applicationsSearch}" />
								<c:if test="${application != null && application != ''}">
								
								<table class="table table-bordered">

									<thead>
										<tr>
											<th>AppId</th>
											<th>Status</th>
											<th>Job Id</th>
											<th>Job Title</th>
											<th>Job description</th>
										</tr>
									</thead>
									<c:forEach var="app" items="${applicationsSearch}">
										<tr>
											<td><a href="ApplicationDetail?applicationid=${app.applicationid}">
											<c:out value="${app.applicationid}"></c:out></a></td>
											<td><c:out value="${app.appstatus}"></c:out></td>
											<td><c:out value="${app.hdzJob.jobsid}"></c:out></td>
											<td><c:out value="${app.hdzJob.hdzPosition.position}"></c:out></td>
											<td><c:out value="${app.hdzJob.description}"></c:out></td>
									</c:forEach>
								</table>
								</c:if>
								<c:if test="${application == null}">
								<h4>No records found!</h4>
								</c:if>
							</form>
						</div>
						<h3 style="background-color: #01579b;color: #ffffff;">Pending Actions</h3>
						<div>
						<c:set var="actions" scope="session" value="${actionList}" />
								<c:if test="${actions != null}">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Job ID</th>
										<th>Job Title</th>
										<th>Job Desc</th>
										<th>Applicant Name</th>
										<th>Applicant Status</th>
										<th>Take Action</th>
									</tr>
								</thead>
								<c:forEach var="action" items="${actionList}">
									<tbody>
										<tr>
											<td><c:out value="${action.hdzJob.jobsid}"></c:out></td>
											<td><c:out value="${action.hdzJob.hdzPosition.position}"></c:out></td>
											<td><c:out value="${action.hdzJob.description}"></c:out>
											</td>
											<td><c:out value="${action.hdzApplicant.firstname}"></c:out>
											</td>
											<td><c:out value="${action.appstatus}"></c:out></td>
											<td><a
												href="ActionSubmit?applicationid=${action.applicationid}">
													Take Action</a></td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
							</c:if>
							<c:if test="${actions == null}">
								<h2>No Action Pending!!</h2>
								</c:if>
						</div>
						<h3 style="background-color: #01579b;color: #ffffff;">Add Jobs</h3>
						<div>
							<form id="target" action="AddJobs" method="post">
								
								<div class="form-group">
									<label for="typeAssgn">Position:</label> <input type="text"
										name="position" id="position" value="" class="form-control">
								</div>
								<div class="form-group">
									<label for="typeAssgn">Description:</label> <input type="text"
										name="description" id="description" value=""
										class="form-control">
								</div>

								<input type="submit" name="submit" id="submit" value="Add">

							</form>
						</div>
						<c:if test="${role == 'HiringManager'}">
						<h3 style="background-color: #01579b;color: #ffffff;">Select Applicants</h3>
						<div>
								<table class="table table-bordered">
								<tr>
								<thead>
									<tr>
										<th>Job ID</th>
										<th>Job Title</th>
										<th>Job Desc</th>
										<th>Choose</th>
									</tr>
								</thead>
								
								<c:forEach var="job" items="${jobList}">
									<tbody>
										<tr>
											<td><c:out value="${job.jobsid}"></c:out></td>
											<td><c:out value="${job.hdzPosition.position}"></c:out></td>
											<td><c:out value="${job.description}"></c:out>
											</td>
											<td><a class="btn btn-default btn-lg"
											 href="ApplicantSelection?jobid=${job.jobsid}">
													Select</a></td>
										</tr>
									</tbody>
								</c:forEach>
								</table>

						</div>
						<h3 style="background-color: #01579b;color: #ffffff;">Find Applicants</h3>
						<div>
						<form action="FindApplicants" method="post">
						<div class="form-group">
									<label for="typeAssgn">Skill:</label> 
									<input type="text"
										name="skill" id="skill" value="" class="form-control">
										
									<label for="typeAssgn">Experience:</label> 
									<input type="text"
										name="experience" id="experience" value="" class="form-control">
									<input type="submit" id="submit" name="submit" value="Submit">
								</div>
								</form>
								
								<table class="table table-bordered">
								<tr>
								<thead>
									<tr>
										<th>Job ID</th>
										<th>Job Title</th>
										<th>Job Desc</th>
										<th>Choose</th>
									</tr>
								</thead>
								
								<c:forEach var="job" items="${jobList}">
									<tbody>
										<tr>
											<td><c:out value="${job.jobsid}"></c:out></td>
											<td><c:out value="${job.hdzPosition.position}"></c:out></td>
											<td><c:out value="${job.description}"></c:out>
											</td>
											<td><a class="btn btn-default btn-lg"
											 href="FindApplicants?jobid=${job.jobsid}">
													Select</a></td>
										</tr>
									</tbody>
								</c:forEach>
								</table>
						</div>
						</c:if>
						
					</div>
					
				</div>
				<div class="col-sm-1"></div>
			</div>
		</div>
	</div>

</body>
</html>