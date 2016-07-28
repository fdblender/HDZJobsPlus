<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Joshua Tucker-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp" />
<title>Applicant Profile</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h1>Welcome ${applicant.firstname}</h1>
<!--Here we put user info-->
<!--resume data provide a button to print and one to apply and one to edit-->
<div>
<button>Print</button>
<button>Apply</button>
<button>Edit</button>
</div>
<!-- pending applications -->
<div>
</div>
</body>
</html>