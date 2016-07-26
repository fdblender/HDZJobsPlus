<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Jobs</title>
</head>
<body>
<h3>Add Jobs:</h3>
					<div>
						<form id="target" action="AddJobs" method="post">
							<div class="form-group">
								<label for="typeAssgn">JobId:</label> <input type="text"
									name="jobsid" id="jobsid" value=""
									class="form-control">
							</div>
							<div class="form-group">
								<label for="typeAssgn">Position:</label> <input type="text"
									name="position" id="position" value=""
									class="form-control">
							</div>
							<div class="form-group">
								<label for="typeAssgn">Description:</label> <input type="text"
									name="description" id="description" value="" 
									class="form-control">
							</div>
														
							<input type="submit" name="submit" id="submit" value="Add">

						</form>
					</div>
</body>
</html>