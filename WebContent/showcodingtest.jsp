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
<script src="javascripts/home.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
<link rel="stylesheet" href="css/style.css" />
<title>Show Coding Test</title>

</head>
<body class="">
<form class="form-signin" action="SaveCodingTest" method="get">
	<div class="container">
		<c:set var="mesL" scope="session" value="${message}" />
		<c:if test="${mesL != null}">
			<div class="alert alert-success">
				<strong>${message}</strong> <span id=""></span>
			</div>
		</c:if>

		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<br />
				<h3>Coding Test</h3>
				<br />
				<h4>Question: ${question.jobquestion}</h4>
				--<c:out value="${question.jobquestionsid}"></c:out>--
				<input type="hidden" id="questionid" name="questionid"
					value="${question.jobquestionsid}"> <br />
				

					<div class="dropdown">
						<label for="comment">Enter your response</label> 
							<select id="codinglanguage" name="codinglanguage">
							<option value="java">Java</option>
							<option value="python">Python</option>
							<option value="c">C</option>
						</select>
					</div>
					<div class="form-group">
						<textarea class="form-control" rows="15" name="response"
							id="response" placeholder=""></textarea>
					</div>

					<br />
					<br /> <input class="btn btn-lg btn-success btn-block"
						type="submit" id="submit" value="Submit »">
				
			</div>
			<div class="col-md-1"></div>
</div>
		</div>
		</form>
</body>
</html>