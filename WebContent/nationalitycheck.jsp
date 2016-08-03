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
<!-- <link rel="stylesheet" type="text/css" href="css/mycss.css" /> -->
<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<link rel="stylesheet" href="css/theme.css" />
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

<%-- <c:set var="mesL" scope="session" value="${hiremessage}" />
			<c:if test="${mesL != null}">
				<div class="alert alert-success">
					<strong>${hiremessage}</strong> <span id="showSearchTerm"></span>
				</div>
			</c:if> --%>

<br /><br />
<c:if test="${NationalityCheck.hdzApplicant.citizenflag != null}">
<div ><h3>Validation Complete!!</h3></div>
</c:if>
 <c:if test="${NationalityCheck.hdzApplicant.citizenflag == null}">
<table  border="0" class="table">
<thead>
<tr ><th>Add comment</th></tr>
</thead>
<tbody>

<tr style="backgroundcolor:#fadddc ">

<td >Please enter comment:</td></tr>
<tr ><td><input type="text" name="addcomment" value="" id="addcomment"/></td></tr>

</tbody>
</table>

<div  Style="background-color: #fadddc ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">Nationality</div>
<table border="1"  class="table responstable table-bordered table-hover">
<thead >
<tr >
<th ><div >App ID</div></th>
<th ><div >Applicant Name</div></th>
<th ><div >Applying</div></th>
<th ><div >Citizen</div></th>
<th ><div >Visa</div></th>
<th ><div >Comments</div></th>
<th ><div >Actions</div></th>
</tr>
</thead>
 <tbody>
 
<tr>   
    <td >   
       
        <c:out value="${NationalityCheck.applicationid}"/>
    <td > 
	
        <c:out value="${NationalityCheck.hdzApplicant.firstname} ${NationalityCheck.hdzApplicant.lastname}"/>
   
 	</td> 
    <td > 
	
        <c:out value="${NationalityCheck.hdzJob.hdzPosition.position}"/>
    
 	</td> 
	<td >
    <c:out value="${NationalityCheck.hdzApplicant.citizen}"/>  
    
   </td>
   <td >
    <c:out value="${NationalityCheck.hdzApplicant.visa}"/>  
    
   </td>  
   
     <td >
    ${NationalityCheck.comments}
    
   </td>
   
   <td >
   
   <input type="button" class="ValidateNationality" name="ValidateNation${NationalityCheck.hdzApplicant.applicantid}" id="ValidateNation${NationalityCheck.hdzApplicant.applicantid}" value="Validate" />
   
    <input type="button" class="FailNationality" name="FailNation${NationalityCheck.hdzApplicant.applicantid}" id="FailNation${NationalityCheck.hdzApplicant.applicantid}" value="Fail"/> 
       
    
   </td> 
   
	 </tr> 
	 
	  </tbody> 
 </table> 
</c:if>
 </div> 
  <script  src="js/nationalitycheck.js"></script>
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>


