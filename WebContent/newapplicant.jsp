<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="bootstrap.jsp" />
<title>HDZ - Create account</title>
<script>
	function validateForm() {
		var x = document.forms["applicant"]["firstname"].value;
		var text;
		if (x == null || x == "") {
			text = "Name must be filled out";
			document.getElementById("invalid").innerHTML = text;
			return false;
		}
		x = document.forms["applicant"]["email"].value;
		if (x == null || x == "") {
			text = ("Email must be filled out");
			document.getElementById("invalid").innerHTML = text;
			return false;
		}
		x = document.forms["applicant"]["password"].value;
		if (x == null || x == "") {
			text = ("Password must be filled out");
			document.getElementById("invalid").innerHTML = text;
			return false;
		}
		x = document.forms["applicant"]["dob"].value;
		if (x == null || x == "") {
			text = ("Birthdate must be filled out");
			document.getElementById("invalid").innerHTML = text;
			return false;
		}
		x = document.forms["applicant"]["skill1"].value;
		if (x == null || x == "") {
			text = ("You must specify at least one skill");
			document.getElementById("invalid").innerHTML = text;
			return false;
		}
		x = document.forms["applicant"]["edu1"].value;
		if (x == null || x == "") {
			text = ("You must specify one degree");
			document.getElementById("invalid").innerHTML = text;
			return false;
		}
		x = document.forms["applicant"]["job1"].value;
		if (x == null || x == "") {
			text = ("You must specify one job");
			document.getElementById("invalid").innerHTML = text;
			return false;
		}
	}
</script>
<script>
	function validateEmailPswd() {
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
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<link rel="stylesheet" href="css/theme.css" />
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-lg-7">
				<form action="NewApplicant" onsubmit="return validateForm()"
					onsubmit="return validateEmailPswd" name="applicant" id="applicant">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div align="left">Personal</div>
						</div>

						<div class="panel-body">

							<fieldset align="left">
							<div class="row">
								<div class="col-sm-4">First name:<br /> <input type="text" maxlength="100"
									name="firstname" id="firstname" /><br /> Last name: <br /> <input
									type="text" maxlength="100" name="lastname" id="lastname" />
									</div>
								<div class="col-sm-4">Email: <br /> <input type="email" maxlength="50" name="email"
									id="email" /><br /> Password:<br /> <input type="password"
									name="password" id="password" /></div>
								<div class="col-sm-4">Date of Birth:<br />
								<input type="date" name="dob" id="dob" /><br /> Veteran
								Status: <br /> <select name="veteran">
									<option value="yes">Veteran</option>
									<option value="no">Non-veteran</option>
								</select> <br /> Citizenship<br /> <select name="citizen">
									<option value="yes">Citizen</option>
									<option value="no">Non-citizen</option>
								</select></div>
							</div>
								
							</fieldset>
						</div>
					</div>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div align="left">Initial Resume Data</div>
						</div>

						<div class="panel-body">

							<fieldset align="center">
								Resume Objective :<br />
								<textarea form="applicant" id="objective" name="objective"
									rows="7" cols="55" maxlength="200"></textarea>
								<br /> Resume Summary :<br />
								<textarea form="applicant" name="summary" id="summary" rows="7"
									cols="55" maxlength="200"></textarea>
								<br />
							</fieldset>
						</div>
					</div>
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div align="left">Skills</div>
						</div>
						<div class="panel-body">
							<fieldset>
								<table class="table">
									<tr>
										<td>Skill 1<br /> <input type="text" name="skill1"
											id="skill1" /><br /> Experience:<br /> <input
											type="number" name="exp1" id=exp1 /><br />
										</td>
										<td>Skill 2<br /> <input type="text" name="skill2"
											id="skill2" /><br /> Experience:<br /> <input
											type="number" name="exp2" id=exp2 /><br />
										</td>
										<td>Skill 3<br /> <input type="text" name="skill3"
											id="skill3" /><br /> Experience:<br /> <input
											type="number" name="exp3" id=exp3 /><br />
										</td>
									</tr>
								</table>
							</fieldset>
						</div>
					</div>
					<br />
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div align="left">Education</div>
						</div>
						<div class="panel-body">
							<fieldset>
								<table class="table">
									<tr>
										<td>Institution 1:<br /> <input type="text" name="edu1"
											id="edu1" /><br /> Degree 1:<br /> <input type="text"
											name="degree1" id="degree1" /><br /> Date completed 1:<br />
											<input type="date" name="date1" id="date1" /> <br />
										</td>
										<td>Institution 2:<br /> <input type="text" name="edu2"
											id="edu2" /><br /> Degree 2:<br /> <input type="text"
											name="degree2" id="degree2" /><br /> Date completed 2:<br />
											<input type="date" name="date2" id="date2" /> <br />
										<td>Institution 3:<br /> <input type="text" name="edu3"
											id="edu3" /><br /> Degree 3:<br /> <input type="text"
											name="degree3" id="degree3" /><br /> Date completed 3:<br />
											<input type="date" name="date3" id="date3" /><br />
										</td>
									</tr>
								</table>
							</fieldset>
						</div>
					</div>
					<br />

					<div class="panel panel-primary">
						<div class="panel-heading">
							<div align="left">Job History</div>
						</div>
						<div class="panel-body">
							<fieldset>
								<table class="table">
									<tr>
										<td>Job title:<br /> <input type="text" name="job1"
											id="job1" /> <br /> Company:<br /> <input type="text"
											name="company1" id="company1" /><br /> Job Description: <br />
											<input type="text" name="jobdesc1" id="jobdesc1" /><br />
											Start date: <br /> <input type="date" name="start1"
											id="start1" /><br /> End date: <br /> <input type="date"
											name="leave1" id="leave1" /> <br />
										</td>
										<td>Job title: <br /> <input type="text" name="job2"
											id="job2" /><br /> Company: <br /> <input type="text"
											name="company2" id="company2" /><br /> Job Description: <br />
											<input type="text" name="jobdesc2" id="jobdesc2" /> <br />
											Start date:<br /> <input type="date" name="start2"
											id="start2" /><br /> End date: <br /> <input type="date"
											name="leave2" id="leave2" /><br />
										</td>
										<td>Job title: <br /> <input type="text" name="job3"
											id="job3" /><br /> Company: <br /> <input type="text"
											name="company3" id="company3" /><br /> Job Description: <br />
											<input type="text" name="jobdesc3" id="jobdesc3" /><br />
											Start date: <br /> <input type="date" name="start3"
											id="start3" /><br /> End date:<br /> <input type="date"
											name="leave3" id="leave3" /> <br />
										</td>
									</tr>
								</table>
							</fieldset>
						</div>
					</div>

					<div class="panel panel-primary">
						<div class="panel-heading">
							<div align="left">References</div>
						</div>
						<div class="panel-body">
							<fieldset>
								<table class="table">
									<tr>
										<td>Name:<br /> <input type="text" name="refname1"
											id="refname1" /><br /> Phone:<br /> <input type="text"
											name="refphone1" id="refphone1" /><br /> Email:<br /> <input
											type="email" name="refemail1" id="refemail1" /><br />
											Position:<br /> <input type="text" name="refpos1"
											id="refpos1" /><br />
										</td>
										<td>Name: <br /> <input type="text" name="refname2"
											id="refname2" /><br /> Phone:<br /> <input type="text"
											name="refphone2" id="refphone2" /><br /> Email: <br /> <input
											type="email" name="refemail2" id="refemail2" /><br />
											Position:<br /> <input type="text" name="refpos2"
											id="refpos2" /><br />
										</td>
										<td>Name:<br /> <input type="text" name="refname3"
											id="refname3" /><br /> Phone:<br /> <input type="text"
											name="refphone3" id="refphone3" /><br /> Email:<br /> <input
											type="email" name="refemail3" id="refemail3" /><br />
											Position:<br /> <input type="text" name="refpos3"
											id="refpos3" /><br />
										</td>
									</tr>
								</table>
							</fieldset>
						</div>
					</div>
					<p id="invalid"></p>
					<input type="submit" name="submit" id="submit" value="Submit" />
				</form>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
</body>
</html>