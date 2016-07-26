<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interview</title>
</head>
<body>
<c:set var="type" scope="session" value="${interviewType}" />
<c:if test="${type == 'Group Interview'}">
	<c:set var="coding" scope="session" value="${coding}" />
	<c:if test="${coding == 'N'}">
		<a href="InterviewReportSubmission?groupInterviewCoding='Y'">Coding Interview Completed</a>
		<a href="InterviewReportSubmission?groupInterviewCoding='N'">Coding Interview Failed</a>
	</c:if>

<a href="InterviewReportSubmission?groupInterview='Pass'">Group Interview Passed</a>
<a href="InterviewReportSubmission?groupInterview='Fail'">Group Interview Failed</a>
</c:if>

<c:if test="${type == 'HM Interview'}">
		<a href="InterviewReportSubmission?hmInterviewCoding='Y'">Coding Interview Completed</a>
		<a href="InterviewReportSubmission?hmInterviewCoding='N'">Coding Interview Failed</a>
<a href="InterviewReportSubmission?hmInterview='Pass'">Hiring Manager Interview Passed</a>
<a href="InterviewReportSubmission?hmInterview='Fail'">Hiring Manager Interview Failed</a>
</c:if>

<c:if test="${type == 'HR Interview'}">
		
<a href="InterviewReportSubmission?hrInterview='Pass'">Hiring Manager Interview Passed</a>
<a href="InterviewReportSubmission?hrInterview='Fail'">Hiring Manager Interview Failed</a>
</c:if>


</body>
</html>