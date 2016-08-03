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
.pageheader {
	text-align: center;
	color: #3333ff;
}

.subheader {
	text-align: center;
}

.theader {
	background-color: #f2f2f2;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="bootstrap.jsp" />
<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<link rel="stylesheet" href="css/theme.css" />

<title>Job Openings</title>
</head>
<body style="color: #262626;">
<div id="container">
	<div id="header"><jsp:include page="navbar.jsp"></jsp:include></div>
	<div id="body">
		<div class="container" class="ui-widget-content" style="height: 100%">

			<!--   <body id="body" class="ui-widget-content" style="border: 0;">  -->


			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<h2>Contact Information</h2>
				<p>Contact the Java Web Bootcamp instructor at 
				<a href="http://cms.montgomerycollege.edu/wdce/">Montgomery College</a>.</p>				
				
			</div>
			<div class="col-sm-2"></div>

		</div>
	</div>
	<div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
</div>

</body>

</html>