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

<jsp:include page="bootstrap.jsp" />
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<link rel="stylesheet" href="css/theme.css" />
<title>Pending Actions Details</title>

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
	<div id="container">
		<div id="header"><jsp:include page="navbar.jsp"></jsp:include></div>
		<div id="body">
			<div class="container">

				<form action="DrugCheckForm" method="get">
					<div class="container">
						<%-- 
<c:set var="mesL" scope="session" value="${hiremessage}" />
			<c:if test="${mesL != null}">
				<div class="alert alert-success">
					<strong>${hiremessage}</strong> <span id="showSearchTerm"></span>
				</div>
			</c:if> --%>

						<table align="center" border="0" class="table">
							<thead>
								<tr>
									<th>Add comment</th>
								</tr>
							</thead>
							<tbody>

								<tr style="backgroundcolor: #fadddc">

									<td>Please enter comment:</td>
								</tr>
								<tr align="center">
									<td><input type="text" name="addcomment" id="addcomment" /></td>
								</tr>

							</tbody>
						</table>
						<c:set var="STD" scope="session"
							value="${DrugApplication.hdzApplicant.stdpanelflag}" />
						<c:set var="DOT" scope="session"
							value="${DrugApplication.hdzApplicant.dottestflag}" />
						<c:set var="Alcohol" scope="session"
							value="${DrugApplication.hdzApplicant.alcoholtestflag}" />

						<div align="center"
							Style="background-color: #fadddc; color: #fff; border-bottom-width: 0; font-weight: bold; font-size: 16px; height: 34px">Drug
							Screen Test</div>
						<table border="1" align="center"
							class="table responstable table-bordered table-hover">
							<thead align="center">
								<tr align="center">
									<th align="center"><div align="center">App ID</div></th>
									<th align="center"><div align="center">Applicant
											Name</div></th>
									<th align="center"><div align="center">Applying</div></th>
									<c:if test="${STD == null}">
										<th align="center"><div align="center">STD Panel</div></th>
									</c:if>
									<c:if test="${DOT == null}">
										<th align="center"><div align="center">DOT Test</div></th>
									</c:if>
									<c:if test="${Alcohol == null}">
										<th align="center"><div align="center">Alcohol Test</div></th>
									</c:if>
									<th align="center"><div align="center">Drug Test</div></th>
									<th align="center"><div align="center">Comment</div></th>
								</tr>
							</thead>
							<tbody>

								<tr>
									<td align="center"><c:out
											value="${DrugApplication.applicationid}" />
									<td align="center"><c:out
											value="${DrugApplication.hdzApplicant.firstname} ${NationalityCheck.hdzApplicant.lastname}" />

									</td>
									<td align="center"><c:out
											value="${DrugApplication.hdzJob.hdzPosition.position}" /></td>
									<c:if test="${STD == null}">
										<td align="center"><input type="button"
											class="PositiveStd"
											name="PositiveStd${DrugApplication.hdzApplicant.applicantid}"
											id="PositiveStd${DrugApplication.hdzApplicant.applicantid}"
											value="Positive" /> <input type="button" class="NegativeStd"
											name="NegativeStd${DrugApplication.hdzApplicant.applicantid}"
											id="NegativeStd${DrugApplication.hdzApplicant.applicantid}"
											value="Negative" /></td>
									</c:if>
									<c:if test="${DOT == null}">
										<td align="center"><input type="button"
											class="PositiveDot"
											name="PositiveDot${DrugApplication.hdzApplicant.applicantid}"
											id="PositiveDot${DrugApplication.hdzApplicant.applicantid}"
											value="Positive" /> <input type="button" class="NegativeDot"
											name="NegativeDot${DrugApplication.hdzApplicant.applicantid}"
											id="NegativeDot${DrugApplication.hdzApplicant.applicantid}"
											value="Negative" /></td>
									</c:if>
									<c:if test="${Alcohol == null}">
										<td align="center"><input type="button"
											class="PositiveAlcohol"
											name="PositiveAlcohol${DrugApplication.hdzApplicant.applicantid}"
											id="PositiveAlcohol${DrugApplication.hdzApplicant.applicantid}"
											value="Positive" /> <input type="button"
											class="NegativeAlcohol"
											name="NegativeAlcohol${DrugApplication.hdzApplicant.applicantid}"
											id="NegativeAlcohol${DrugApplication.hdzApplicant.applicantid}"
											value="Negative" /></td>
									</c:if>

									<td align="center"><c:out
											value="${DrugApplicant.drugtestflag}" /></td>

									<td align="center">${DrugApplication.comments}</td>

								</tr>

							</tbody>
						</table>

					</div>
					<script src="js/drugscreencheck.js"></script>
				</form>
			</div>
		</div>
		<div id="footer"><jsp:include page="footer.jsp"></jsp:include></div>
	</div>

</body>
</html>


