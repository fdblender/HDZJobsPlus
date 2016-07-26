<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- <script src="js/pendingAction.js"></script> -->
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
<link rel="stylesheet" href="css/style.css" />
<title>Pending Actions</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<c:set var="mesL" scope="session" value="${message}" />
		<c:if test="${mesL != null}">
			<div class="alert alert-success">
				<strong>${message}</strong> <span id="showSearchTerm"></span>
			</div>
		</c:if>


		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div align="left">Pending Actions</div>

					</div>
					<div class="panel-body">
					
						<table>
						<thead>
						<tr>
						<th>Job ID</th>
						<th>Job Desc</th>
						<th>Applicatnt Name</th>
						<th>Applicatnt Status</th>
						<th></th>
						</tr>
						</thead>
						<c:forEach var="action" items="${actionList}">
						<tbody>
							<tr>
							<td><c:out value="${action.hdzJob.jobsid}"></c:out> </td>
							<td><c:out value="${action.hdzJob.description}"></c:out> </td>
							<td><c:out value="${action.hdzApplicant.firstname}"></c:out> </td>
							<td><c:out value="${action.appstatus}"></c:out> </td>
							<td><a href="ActionSubmit?applicationid=${action.applicationid}">
							Take Action</a></td>
							</tr>
						</tbody>
						</c:forEach>
						</table>
					</div>
					<div class="panel-footer">
						<div id="text"></div>
						<div align="right">
							
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>


</body>
</html>