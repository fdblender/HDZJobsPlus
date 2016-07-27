<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
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
<title>Login</title>
<script>
	function validateLogin() {
		var email = $('#email').val();
		// http://stackoverflow.com/a/46181/11236

		// check the email
		var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		var goodemail = re.test(email);
		if (goodemail == false)
			alert("Invalid Email! " + email);

		// check the password and restrict the length to 4 - 15 characters
		// the passsword must be lower case, upper case or a number
		var password = $('#password').val();
		var pword = new RegExp(/^[a-zA-Z0-9]{4,15}$/)
		goodpassword = pword.test(password)
		if (!goodpassword) {
			alert("Invalid Password! " + password);
		}

		return (goodpassword && goodemail);
	}
</script>

</head>
<body class ="loginBody">

	
	<div class="container">
		<c:set var="mesL" scope="session" value="${message}" />
		<c:if test="${mesL != null}">
			<div class="alert alert-success">
				<strong>${message}</strong> <span id="showSearchTerm"></span>
			</div>
		</c:if>

		<div class="row vertical-offset-100">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: white;">
						<div class="row-fluid user-row" style="background-color: white;"
							align="center">
							<br>
							<h3>HDZ Jobs Portal</h3>

						</div>
					</div>
					<div class="panel-body">
						<div role="form" class="form-signin">
							<fieldset>
								<label class="panel-login">
									<div class="login_result"></div>
								</label>
								<form class="form-signin" onsubmit="return validateLogin()"
									action="Login" method="get">
									<label for="inputEmail" class="sr-only">Email address</label> <input
										type="text" id="email" name="email" class="form-control"
										placeholder="Email address" required autofocus> <label
										for="inputPassword" class="sr-only">Password</label> <input
										type="password" id="password" name="password"
										class="form-control" placeholder="password" required>

									<br/>
									<select id="loginrole" name="loginrole" style="width: 320px;">
										<option value="applicant">Applicant</option>
										<option value="employee">Employee</option>
									</select> <br/><br/>
									<input
										class="btn btn-lg btn-success btn-block" type="submit"
										id="login" value="Login »">
								</form>
								<div class="login-help">
									<a href="./newapplicant.jsp">Create New Applicant Account</a>
								</div>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- <div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<form class="form-signin" onsubmit="return validateLogin()"
					action="Login" method="get">
					<h3 class="form-signin-heading">Please sign in</h3>
					<label for="inputEmail" class="sr-only">Email address</label> <input
						type="text" id="email" name="email" class="form-control"
						placeholder="Email address" required autofocus> <label
						for="inputPassword" class="sr-only">Password</label> <input
						type="password" id="password" name="password" class="form-control"
						placeholder="password" required>

					<h4>Select from below</h4>
					<select id="loginrole" name="loginrole">
						<option value="applicant">Applicant</option>
						<option value="employee">Employee</option>
					</select> <br />
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						in</button>

				</form>
				<br />
				<h4>
					<a href="./newapplicant.jsp">Create New Applicant Account</a>
				</h4>
			</div>
			<div class="col-sm-3"></div>
		</div> -->
	</div>
</body>
</html>