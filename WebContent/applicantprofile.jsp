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

.pageheader {
	text-align: center;
	font-weight: bold;		
}

.subheader {
	text-align: center;
}

.sectionheader {
	font-weight: bold;	
}

.theader {
	background-color: #f2f2f2;
}
</style>
<script src="js/pendingAction.js"></script>
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<link rel="stylesheet" href="css/theme.css" />

<title>Applicant Profile</title>
<script>
	function printMe() {
		window.print()
	}
</script>
</head>


<body style="color: #262626;" class="ui-widget-content">
	<div id="container">
		<div id="header"><jsp:include page="navbar.jsp"></jsp:include></div>
		<div id="body">
			<div class="container" style="height: 100%">

				<div style="background-color: white;" class="panel-body">
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-2">
							<img alt="Profile Picture" src="${user.gravatarurl}" width="100"
								height="100" align="left" />
						</div>
						<div class="col-sm-6">
							<h2 class="pageheader">${user.firstname} ${user.lastname}</h2>
							<h4 class="subheader">${user.email}<br /> <br />
							</h4>
						</div>
						<div class="col-sm-1"></div>
						<br /> <br />
						<div class="col-sm-2"></div>
					</div>

					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-9">
							<h4 class="sectionheader">SUMMARY OF QUALIFICATIONS</h4>
							<table class="table table-bordered">
								<tr>
									<td colspan="3">${user.resumesummary}</td>
								</tr>
								<tr>
									<th class="theader" colspan="3">OBJECTIVE</th>
								</tr>
								<tr>
									<td colspan="3">${user.resumeobjective}</td>
								</tr>
							</table>

							<h4 class="sectionheader">EDUCATION</h4>
							<table class="table table-bordered">
								<tr>
									<th class="theader" style="width: 20%">School Name</th>
									<th class="theader">Degree awarded</th>
									<th class="theader" style="width: 24%">Date Completed</th>
								</tr>
								<tbody>
									<c:forEach var="school" items="${user.hdzEducations }">
										<tr>
											<td style="width: 20%"><c:out
													value="${school.schoolname }" /></td>
											<td><c:out value="${school.degreecompleted}" /></td>
											<td style="width: 24%"><c:out
													value="${school.datecompleted}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<h4 class="sectionheader">SKILLS</h4>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th class="theader">Skill</th>
										<th class="theader" style="width: 24%">Years of
											experience</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="skill" items="${user.hdzApplicantskills }">
										<tr>
											<td><c:out value="${skill.skills }" /></td>
											<td style="width: 24%"><c:out
													value="${skill.experience}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<h4 class="sectionheader">JOB HISTORY</h4>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th class="theader" style="width: 20%">Company name</th>
										<th class="theader" style="width: 25%">Position</th>
										<th class="theader">Description</th>
										<th class="theader style="width:12%"">Start Date</th>
										<th class="theader style="width:12%"">End Date</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="job" items="${user.hdzJobhistories }">
										<tr>
											<td style="width: 20%"><c:out value="${job.companyname}" /></td>
											<td style="width: 25%"><c:out value="${job.position}" /></td>
											<td><c:out value="${job.description}" /></td>
											<td style="width: 12%"><c:out value="${job.startdate}" /></td>
											<td style="width: 12%"><c:out value="${job.enddate}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

							<h4 class="sectionheader">REFERENCES</h4>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th class="theader" style="width: 20%">Name</th>
										<th class="theader" style="width: 25%">Position</th>
										<th class="theader">Email</th>
										<th class="theader" style="width: 24%">Phone Number</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="reference" items="${user.hdzReftables }">
										<tr>
											<td style="width: 20%"><c:out
													value="${reference.refname }" /></td>
											<td style="width: 25%"><c:out
													value="${reference.refposition}" /></td>
											<td><c:out value="${reference.refemail}" /></td>
											<td style="width: 24%"><c:out
													value="${reference.refphone}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div>
								<button type="button" value="Print" onclick="printMe()">Print</button>
								<button type="button" onclick="location.href = './Jobs';">Apply</button>
								<!--   <button type="button" onclick="location.href = './editprofile.jsp';">Edit Profile</button>-->
							</div>
						</div>

						<div class="col-sm-2"></div>
					</div>
				</div>
			</div>
			<div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
		</div>
	</div>
</body>
</html>