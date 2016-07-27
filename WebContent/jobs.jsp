<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp" />
<title>Job Openings</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h2>Job Openings</h2>
<h4>${query}</h4>
<form action="JobSearch">
<input type="text" name="search" id="search"/>
<input type="submit" name="submit" id="submit" value="Search"/>
</form>
<table>
<tr>
<th>Position</th>
</tr>
<c:forEach var="job" items="${jobs}">
<tr>
<td>${job.position}</td>
<td>
<form action="Apply">
<input type="hidden" name="jobid" id="jobid" value="${job.jobsid}"/>
<input type="submit" name="submit" id="submit" value="Apply"/>
</form>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>