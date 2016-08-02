<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="bootstrap.jsp" />
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<link rel="stylesheet" href="css/theme.css" />

<title>Show Coding Test</title>
</head>
<body style="color: #262626;">
	<div id="container">
		<div id="header"><jsp:include page="navbar.jsp"></jsp:include></div>
		<div id="body">

			<div class="container" style="height: 100%">

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

								<input type="hidden" id="questionid" name="questionid"
									value="${question.jobquestionsid}"> <br />


								<div class="dropdown">
									<label for="comment">Enter your response</label> <select
										id="codinglanguage" name="codinglanguage">
										<option value="java">Java</option>
										<option value="python">Python</option>
										<option value="c">C#</option>
									</select>
								</div>
								<div class="form-group">
									<textarea class="form-control" rows="15" name="response"
										id="response" placeholder=""></textarea>
								</div>

								<br /> <br /> <input type="submit" id="submit"
									value="Submit »">

							</div>
							<div class="col-md-1"></div>
						</div>
						</div>
		
				</form>
			
	</div>
	<div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
	</div>
	</div>
</body>
</html>