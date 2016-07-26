<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp"></jsp:include>
<title>Login</title>
<script>
	function validateLogin() {
		var email = $('#email').val();
		// http://stackoverflow.com/a/46181/11236

		// check the email
		var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		var goodemail = re.test(email);
		if (goodemail == false)
			alert("Invalid Email! "+email);

		// check the password and restrict the length to 4 - 15 characters
		// the passsword must be lower case, upper case or a number
		var password = $('#password').val();
		var pword = new RegExp(/^[a-zA-Z0-9]{4,15}$/)
		goodpassword = pword.test(password)
		if (!goodpassword) {
			alert("Invalid Password! "+password);
		}

		return (goodpassword && goodemail);
	}
</script>

</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
	<div class="row">
	<div class="col-sm-3"></div>	
	<div class="col-sm-6">	
	<form class="form-signin" onsubmit="return validateLogin()" action="Login"
		method="get">
		<h3 class="form-signin-heading">Please sign in</h3>		
		<label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="email" name="email" class="form-control" value="Email address" required autofocus>
         <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" value="Password" required>        
		
		<h4>Select from below</h4>
		<select id="loginrole" name="loginrole">
			<option value="applicant">Applicant</option>
			<option value="employee">Employee</option>			
		</select>
		<br/>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>		
		
	</form>
	<br/>	
	<h4><a href="./newapplicant.jsp">Create New Applicant Account</a></h4>
	</div>
	<div class="col-sm-3"></div>	

</div>
</body>
</html>