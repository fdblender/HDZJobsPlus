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


<form action="Nationalityform" method="get" >
<div class="container">

<c:set var="mesL" scope="session" value="${hiremessage}" />
			<c:if test="${mesL != null}">
				<div class="alert alert-success">
					<strong>${hiremessage}</strong> <span id="showSearchTerm"></span>
				</div>
			</c:if>

<br /><br />

<table align="center" border="0" class="table">
<thead>
<tr ><th>Add comment</th></tr>
</thead>
<tbody>

<tr style="backgroundcolor:#4db6ac ">

<td >Please enter comment:</td></tr>
<tr align="center"><td><input type="text" name="addcomment" value=""/></td></tr>

</tbody>
</table>

<div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">Nationality</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">App ID</div></th>
<th align="center"><div align="center">Applicant Name</div></th>
<th align="center"><div align="center">Applying</div></th>
<th align="center"><div align="center">Citizen</div></th>
<th align="center"><div align="center">Visa</div></th>
<th align="center"><div align="center">Actions</div></th>
</tr>
</thead>
 <tbody>
 
<tr>   
    <td align="center">   
       
        <c:out value="${NationalityCheck.applicationid}"/>
    <td align="center"> 
	
        <c:out value="${NationalityCheck.hdzApplicant.firstname} ${NationalityCheck.hdzApplicant.lastname}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${NationalityCheck.hdzJob.position}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${NationalityCheck.hdzApplicant.citizen}"/>  
    
   </td>
   <td align="center">
    <c:out value="${NationalityCheck.hdzApplicant.visa}"/>  
    
   </td>  
   
   <td align="center">
   
   <input type="button" class="ValidateNationality" name="ValidateNation${NationalityCheck.hdzApplicant.applicantid}" id="ValidateNation${NationalityCheck.hdzApplicant.applicantid}" value="Validate" />
   
    <input type="button" class="FailNationality" name="FailNation${NationalityCheck.hdzApplicant.applicantid}" id="FailNation${NationalityCheck.hdzApplicant.applicantid}" value="Fail"/> 
       
    
   </td> 
   
	 </tr> 
	 
	  </tbody> 
 </table> 

 </div> 
  <script  src="js/nationalitycheck.js"></script>
</form>



</body>
</html>


