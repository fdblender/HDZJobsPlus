<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Joshua Tucker-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp" />
<title>Applicant Profile</title>
<script>
function printMe() {
    window.print()
}
</script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<h1>Welcome ${user.firstname}</h1>
	<p>Your current email address is: ${user.email}</p>
	<!--Here we put user info-->
	<!--resume data provide a button to print and one to apply and one to edit-->
	<img alt="Profile Picture" src="${user.gravatarurl}" width="100"
		height="100" align="left" />
		
	<div>
	<h1>Resume Data</h1>
	<h2>Summary</h2>
	<p>${user.resumesummary}</p>
	<h2>Objective</h2>
	<p>${user.resumeobjective}</p>
	<h2>Education History</h2>
		<table >
			<thead>
				<tr>
					<th>School Name</th>
					<th>Degree awarded</th>
					<th>Date Completed</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="school" items="${user.hdzEducations }">
					<tr>
						<td><c:out value="${school.schoolname }" /></td>
						<td><c:out value="${school.degreecompleted}" /></td>
						<td><c:out value="${school.datecompleted}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<h2>Skills</h2>
		<table >
			<thead>
				<tr>
					<th>Skill</th>
					<th>Years of experience</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="skill" items="${user.hdzApplicantskills }">
					<tr>
						<td><c:out value="${skill.skills }" /></td>
						<td><c:out value="${skill.experience}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2>Job History</h2>
		<table >
			<thead>
				<tr>
					<th>Company name</th>
					<th>Position</th>
					<th>Description</th>
					<th>Start Date</th>
					<th>End Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="job" items="${user.hdzJobhistories }">
					<tr>
						<td><c:out value="${job.companyname}" /></td>
						<td><c:out value="${job.description}" /></td>
						<td><c:out value="${job.position}" /></td>
						<td><c:out value="${job.startdate}" /></td>
						<td><c:out value="${job.enddate}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2>References</h2>
		<table >
			<thead>
				<tr>
					<th>Name</th>
					<th>Position</th>
					<th>Email</th>
					<th>Phone Number</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="reference" items="${user.hdzReftables }">
					<tr>
						<td><c:out value="${reference.refname }" /></td>
						<td><c:out value="${reference.refposition}" /></td>
						<td><c:out value="${reference.refemail}" /></td>
						<td><c:out value="${reference.refphone}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<button type="button" value="Print" onclick="printMe()">Print</button>
		<button type="button" ><a href="./jobs.jsp">Apply</a></button>
		<button type="button">Edit</button>
	</div>
</body>
</html>