<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="bootstrap.jsp" />
<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<link rel="stylesheet" href="css/theme.css" />

<title>Your Applications</title>
</head>
<body style="color: #262626;">
	<div id="container">
		<div id="header"><jsp:include page="navbar.jsp"></jsp:include></div>
		<div id="body" style="height: 550px">
			<div class="container" style="height: 100%">

				<c:set var="mesL" scope="session" value="${message}" />
				<c:if test="${mesL != null}">
					<div class="alert alert-success">
						<strong>${message}</strong> <span id="showSearchTerm"></span>
					</div>
				</c:if>

				<div class="row">
					<div class="col-sm-1"></div>
					<div class="col-sm-10">

						<h2>Your Applications</h2>
						<table class="table table-bordered table-striped table-hover" >
							<tr>
								<th>Position</th>
								<th>Job Description</th>
								<th>Status</th>
							</tr>
							<c:forEach var="app" items="${yourApps}">
								<tr>
									<td><c:out value="${app.hdzJob.hdzPosition.position}" /></td>
									<td><c:out value="${app.hdzJob.description}" /></td>
									<td><c:out value="${app.appstatus}" /></td>
								</tr>
							</c:forEach>
						</table>
						<br />
						<c:if test="${pendingcodingtest == 'yes'}">
							<form id="target" action="ShowCodingTest" method="post">
								<input type="submit" class="" name="showtests" id="showtests"
									value="Complete Outstanding Coding Test" />
							</form>
						</c:if>
					</div>
					<div class="col-sm-1"></div>
				</div>
			</div>
		</div>
		<div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
	</div>
</body>
</html>