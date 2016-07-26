<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Applications</title>
</head>
<body>
			<h3>View Applications</h3>
							<form action="ViewApplications"  method="post">
							<div class="form-group">
								<label for="typeAssgn">Position:</label> <input type="text"
									name="position" id="position" value=""
									class="form-control">
							<input type="submit" name="submit" id="submit" value="Search">
							</div>
														
							
							<table width="100%">
							<thead>
							<tr>
							<th>AppId</th>
							<th>Status</th>
							<th>Job Id</th>
							<th>Job description</th>
							</tr>
							</thead>
							<c:forEach var="app" items="${app}">
							<tr>
							<td><c:out value="${app.applicationid}"></c:out> </td>
							<td><c:out value="${app.appstatus}"></c:out> </td>
							<td><c:out value="${app.hdzJob.jobsid}"></c:out> </td>	
							<td><c:out value="${app.hdzJob.description}"></c:out> </td>			
							</c:forEach>
							</table>													
							
																			
							</form>
						
</body>
</html>
