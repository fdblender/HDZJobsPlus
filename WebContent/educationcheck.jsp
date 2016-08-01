<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%

	
%> 
<fmt:setLocale value="en_US"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pending Actions Details</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="css/mycss.css" />
</head>
<body >

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


<form action="EducationForm" method="get" >
<div class="container">
<%-- <c:set var="mesL" scope="session" value="${hiremessage}" />
			<c:if test="${mesL != null}">
				<div class="alert alert-success">
					<strong>${hiremessage}</strong> <span id="showSearchTerm"></span>
				</div>
			</c:if> --%>


<br /><br />

<table align="center" border="0" class="table">
<thead>
<tr ><th>Add comment</th></tr>
</thead>
<tbody>

<tr style="backgroundcolor:#4db6ac ">

<td >Please enter comment:</td></tr>
<tr align="center"><td><input type="text" name="addcomment" value="" id="addcomment"/></td></tr>

</tbody>
</table>

<div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">Education</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">App ID</div></th>
<th align="center"><div align="center">Applicant Name</div></th>
<th align="center"><div align="center">School Name</div></th>
<th align="center"><div align="center">Degree</div></th>
<th align="center"><div align="center">Date</div></th>
<th align="center"><div align="center">Comment</div></th>
<th align="center"><div align="center">Actions</div></th>

</tr>
</thead>
 <tbody>
 <c:forEach var="edu" items="${EducationCheck}">
<tr>   
    <td align="center">      
        <c:set var="myeduid" value="${EduApplicationid}"/>
        <c:out value="${myeduid}"/>
        
    <td align="center"> 
	
        <c:out value="${edu.hdzApplicant.firstname} ${edu.hdzApplicant.lastname}"/>
   
 	</td> 
    
	<td align="center">
    <c:out value="${edu.schoolname}"/>  
    
   </td> 
   
   <td align="center">
    <c:out value="${edu.degreecompleted}"/>  
    
   </td>
   <td align="center">
    <c:out value="${edu.datecompleted}"/>  
    
   </td>
   
    <td align="center">
    <c:out value="${ApplicationComment.comments}"/>  
    
   </td>
    
   <td align="center">
   
   <input type="button" class="ValidateEdu" name="ValidateEdu${edu.educationid}" id="ValidateEdu${edu.educationid}" value="Validate" />
   
    <input type="button" class="FailEdu" name="FailEdu${edu.educationid}" id="FailEdu${edu.educationid}" value="Fail"/> 
       
    
   </td> 
   
	 </tr> 
	 </c:forEach>
	  </tbody> 
 </table> 
 
 
 
 
 

 </div> 
  <script  src="js/educationcheck.js"></script>
</form>



</body>
</html>


