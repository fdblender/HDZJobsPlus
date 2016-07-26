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


<form action="DrugCheckForm" method="get" >
<div class="container">

<br /><br />

<div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">Nationality</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">Application ID</div></th>
<th align="center"><div align="center">Applicant Name</div></th>
<th align="center"><div align="center">Applying</div></th>
<th align="center"><div align="center">Drug Test</div></th>
<th align="center"><div align="center">STD Panel</div></th>
<th align="center"><div align="center">DOT Test</div></th>
<th align="center"><div align="center">Alcohol Test</div></th>
<th align="center"><div align="center">Actions</div></th>
</tr>
</thead>
 <tbody>
 
<tr>   
    <td align="center">   
       
        <c:out value="${DrugApplication.applicationid}"/>
    <td align="center"> 
	
        <c:out value="${DrugApplication.hdzApplicant.firstname} ${NationalityCheck.hdzApplicant.lastname}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${DrugApplication.hdzJob.position}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${DrugApplication.hdzApplicant.drugtest}"/>  
    
   </td>
   
   <td align="center">
    <c:out value="${DrugApplication.hdzApplicant.stdpanel}"/>  
    
   </td>
   
   <td align="center">
    <c:out value="${DrugApplication.hdzApplicant.dottest}"/>  
    
   </td>
   <td align="center">
    <c:out value="${DrugApplication.hdzApplicant.alcoholtest}"/>  
    
   </td>
   
   
   <td align="center">
   
   <input type="button" class="ValidateDrug" name="ValidateDrug${DrugApplication.hdzApplicant.applicantid}" id="ValidateDrug${DrugApplication.hdzApplicant.applicantid}" value="Validate" />
   
    <input type="button" class="FailDrug" name="FailDrug${DrugApplication.hdzApplicant.applicantid}" id="FailDrug${DrugApplication.hdzApplicant.applicantid}" value="Fail"/> 
       
    
   </td> 
   
	 </tr> 
	 
	  </tbody> 
 </table> 

 </div> 
  <script  src="js/drugscreencheck.js"></script>
</form>



</body>
</html>


