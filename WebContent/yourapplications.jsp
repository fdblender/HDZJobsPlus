<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp" />
<title>Your Applications</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
			
				<h2>Your Applications</h2>
				<table class="table table-bordered table-striped table-hover">
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
					<form id="target" action="ShowCodingTest" method="get">
						<input type="submit" class="" name="showtests" id="showtests" value="Complete Outstanding Coding Test"/>
					</form>
				</c:if>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
		
</body>
</html>