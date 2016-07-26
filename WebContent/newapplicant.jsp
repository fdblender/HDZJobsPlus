<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HDZ - Create account</title>
<script>
function validateForm() {
    var x = document.forms["applicant"]["name"].value;
    var text;
    if (x == null || x == "") {
        text= "Name must be filled out";
        document.getElementById("invalid").innerHTML = text;
        return false;
    }
    x = document.forms["applicant"]["email"].value;
    if (x == null || x == "") {
        text=("Email must be filled out");
        document.getElementById("invalid").innerHTML = text;
        return false;
    }
    x = document.forms["applicant"]["password"].value;
    if (x == null || x == "") {
        text=("Password must be filled out");
        document.getElementById("invalid").innerHTML = text;
        return false;
    }
    x = document.forms["applicant"]["dob"].value;
    if (x == null || x == "") {
        text=("Birthdate must be filled out");
        document.getElementById("invalid").innerHTML = text;
        return false;
    }
    x = document.forms["applicant"]["edu1"].value;
    if (x == null || x == "") {
        text=("You must specify one degree");
        document.getElementById("invalid").innerHTML = text;
        return false;
    }
    x = document.forms["applicant"]["job1"].value;
    if (x == null || x == "") {
        text=("You must specify one job");
        document.getElementById("invalid").innerHTML = text;
        return false;
    }
}
</script>
</head>
<body>
<form action="NewApplicant" onsubmit="return validateForm()" name="applicant" method="post">
Name<input type="text" name="firstname" id="firstname" placeholder="firstname"/>
	<input type ="text" name="aastneme" id="lastname" placeholder="lastname"/>
<br/>
Email Address<input type="text" name="email" id="email"/>
Password<input type="password" name="password" id="password"/><br/>
Date of Birth<input type="text" name="dob" id="dob"/>
<fieldset>
<legend>Education</legend>
Institution: <input type="text" name="edu1" id="edu1"/>
Field: <input type="text" name="field1" id="field1"/><br/>
Degree Awarded: <input type="text" name="degree1" id="degree1"/>
<br/>
Institution: <input type="text" name="edu2" id="edu2"/>
Field: <input type="text" name="field2" id="field2"/><br/>
Degree Awarded: <input type="text" name="degree2" id="degree2"/>
<br/>
Institution: <input type="text" name="edu3" id="edu3"/>
Field: <input type="text" name="field3" id="field3"/><br/>
Degree Awarded: <input type="text" name="degree3" id="degree3"/>
</fieldset>
<br/>
<fieldset>
<legend>Job history</legend>
Job title: <input type="text" name="job1" id="job1"/>
Company: <input type="text" name="company1" id="company1"/>
<br/>
Start date: <input type="text" name="start1" id="start1"/>
Leave date: <input type="text" name="leave1" id="leave1"/>
<br/>
Job title: <input type="text" name="job2" id="job2"/>
Company: <input type="text" name="company2" id="company2"/>
<br/>
Start date: <input type="text" name="start2" id="start2"/>
Leave date: <input type="text" name="leave2" id="leave2"/>
<br/>
Job title: <input type="text" name="job3" id="job3"/>
Company: <input type="text" name="company3" id="company3"/>
<br/>
Start date: <input type="text" name="start3" id="start3"/>
Leave date: <input type="text" name="leave3" id="leave3"/>
<br/>
</fieldset>
Veteran status
<select name="veteran">
  <option value="yes">Veteran</option>
  <option value="no">Non-veteran</option>
</select>
<br/>
Citizenship
<select name="citizen">
  <option value="yes">Citizen</option>
  <option value="no">Non-citizen</option>
</select>
<br/>
Nationality<input type="text" name="nationality" id="nationality"/><br/>
<p id="invalid"></p>
<input type="submit" name="submit" id="submit" value="Submit"/>
</form>
</body>
</html>