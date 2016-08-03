<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	
%>
<fmt:setLocale value="en_US" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pending Actions Details</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
<!-- <link rel="stylesheet" type="text/css" href="css/mycss.css" /> -->
<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<link rel="stylesheet" href="css/theme.css" />
</head>
<body>

	<script language="javascript" type="text/javascript">
		function limitText(limitField, limitCount, limitNum) {
			if (limitField.value.length > limitNum) {
				limitField.value = limitField.value.substring(0, limitNum);
			} else {
				limitCount.value = limitNum - limitField.value.length;
			}
		}
	</script>

	<jsp:include page="navbar.jsp" />


	<form action="Workhistoryreferenceform" method="get">
		<div class="container">
			<%-- 
<c:set var="mesL" scope="session" value="${hiremessage}" />
			<c:if test="${mesL != null}">
				<div class="alert alert-success">
					<strong>${hiremessage}</strong> <span id="showSearchTerm"></span>
				</div>
			</c:if> --%>

			<br />
			<br />

			<c:if test="${VeteranApplication.hdzApplicant.workrefflag != null}">
				<div >
					<h3>Validation Complete!!</h3>
				</div>
			</c:if>
			<c:if test="${VeteranApplication.hdzApplicant.workrefflag == null}">
				<table  border="0"class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<th>Add comment</th>
						</tr>
					</thead>
					<tbody>

						<tr style="backgroundcolor: #24bdc2">

							<td>Please enter comment:</td>
						</tr>
						<tr >
							<td><input type="text" name="addcomment" value=""
								id="addcomment" /></td>
						</tr>

					</tbody>
				</table>

				<c:if test="${VeteranApplication.hdzApplicant.veteranflag == null}">
					<div 
						Style="background-color: #fadddc; color: #fff; border-bottom-width: 0; font-weight: bold; font-size: 16px; height: 34px">Veteran</div>
					<table border="1" 
						class="table table-bordered table-striped table-hover">
						<thead >
							<tr >
								<th ><div >App ID</div></th>
								<th ><div >Applicant Name</div></th>
								<th ><div >Applying</div></th>
								<th ><div >Veteran</div></th>
								<th ><div >Comments</div></th>
								<th ><div >Actions</div></th>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td ><c:set var="myveteranid"
										value="${VeteranApplication.applicationid}" /> <c:out
										value="${myveteranid}" />
								<td ><c:out
										value="${VeteranApplication.hdzApplicant.firstname} ${VeteranApplication.hdzApplicant.lastname}" />

								</td>
								<td ><c:out
										value="${VeteranApplication.hdzJob.hdzPosition.position}" /></td>
								<td ><c:out
										value="${VeteranApplication.hdzApplicant.veteran}" /></td>
								<td >${VeteranApplication.comments}</td>


								<td ><input type="button"
									class="ValidateVeteran"
									name="ValidateVeteran${VeteranApplication.hdzApplicant.applicantid}"
									id="ValidateVeteran${VeteranApplication.hdzApplicant.applicantid}"
									value="Validate" /> <input type="button" class="FailVeteran"
									name="FailVeteran${VeteranApplication.hdzApplicant.applicantid}"
									id="FailVeteran${VeteranApplication.hdzApplicant.applicantid}"
									value="Fail" /></td>

							</tr>

						</tbody>
					</table>
				</c:if>


				<div 
					Style="background-color: #fadddc; color: #fff; border-bottom-width: 0; font-weight: bold; font-size: 16px; height: 34px">Job
					History</div>
				<table border="1" 
					class="table table-bordered table-striped table-hover">
					<thead >
						<tr >
							<th ><div >App ID</div></th>
							<th ><div >Applicant Name</div></th>
							<th ><div >Previous Job</div></th>
							<th ><div >Company</div></th>
							<th ><div >Start Date</div></th>
							<th ><div >End Date</div></th>
							<th ><div >Description</div></th>
							<th ><div >Comments</div></th>
							<th ><div >Actions</div></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="work" items="${WorkHistoryCheck}">
							<c:if test="${work.jobhistoryflag == null}">
								<tr>
									<td ><c:set var="myworkid"
											value="${WorkApplicationid}" /> <c:out value="${myworkid}" />
									<td ><c:out
											value="${work.hdzApplicant.firstname} ${work.hdzApplicant.lastname}" />

									</td>

									<td ><c:out value="${work.position}" /></td>

									<td ><c:out value="${work.companyname}" /></td>
									<td ><c:out value="${work.startdate}" /></td>
									<td ><c:out value="${work.enddate}" /></td>

									<td ><c:out value="${work.description}" /></td>

									<td >${VeteranApplication.comments}</td>

									<td ><input type="button"
										class="ValidateWork" name="ValidateWork${work.jobhistoryid}"
										id="ValidateWork${work.jobhistoryid}" value="Validate" /> <input
										type="button" class="FailWork"
										name="FailWork${work.jobhistoryid}"
										id="FailWork${work.jobhistoryid}" value="Fail" /></td>

								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>

				<div 
					Style="background-color: #fadddc; color: #fff; border-bottom-width: 0; font-weight: bold; font-size: 16px; height: 34px">References</div>
				<table border="1" 
					class="table table-bordered table-striped table-hover">
					<thead >
						<tr >
							<th ><div >App ID</div></th>
							<th ><div >Applicant Name</div></th>
							<th ><div >Reference Name</div></th>
							<th ><div >Reference Email</div></th>
							<th ><div >Reference Phone</div></th>
							<th ><div >Reference
									Position</div></th>

							<th ><div >Comments</div></th>
							<th ><div >Actions</div></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="refer" items="${ReferenceCheck}">
							<c:if test="${refer.refflag == null}">
								<tr>
									<td ><c:set var="myreferid"
											value="${WorkApplicationid}" /> <c:out value="${myreferid}" />
									<td ><c:out
											value="${refer.hdzApplicant.firstname} ${refer.hdzApplicant.lastname}" />

									</td>
									<td ><c:out value="${refer.refname}" /></td>
									<td ><c:out value="${refer.refemail}" /></td>

									<td ><c:out value="${refer.refphone}" /></td>
									<td ><c:out value="${refer.refposition}" />

									</td>

									<td >${VeteranApplication.comments}</td>

									<td ><input type="button"
										class="ValidateRef" name="ValidateRef${refer.refid}"
										id="ValidateRef${refer.refid}" value="Validate" /> <input
										type="button" class="FailRef" name="FailRef${refer.refid}"
										id="FailRef${refer.refid}" value="Fail" /></td>

								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>


			</c:if>


		</div>
		<script src="js/workhisrefercheck.js"></script>
	</form>
<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>