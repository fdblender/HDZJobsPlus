<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp"/>
<title>Your Applications</title>
</head>
<body>
<h2>Your Applications</h2>
<table>
<tr>
<th>Position</th>
<th>Status</th>
</tr>
<c:forEach var="app" items="${user.hdzapplications}">
<tr>
<td><c:out value="${app.hdzjob.position}"/></td>
<td><c:out value="${app.appstatus}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>