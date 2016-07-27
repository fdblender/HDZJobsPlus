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


<form action="Workhistoryreferenceform" method="get" >
<div class="container">

<c:set var="mesL" scope="session" value="${hiremessage}" />
			<c:if test="${mesL != null}">
				<div class="alert alert-success">
					<strong>${hiremessage}</strong> <span id="showSearchTerm"></span>
				</div>
			</c:if>

<br /><br /> 
 
 <div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">Veteran</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">App ID</div></th>
<th align="center"><div align="center">Applicant Name</div></th>
<th align="center"><div align="center">Applying</div></th>
<th align="center"><div align="center">Veteran</div></th>
<th align="center"><div align="center">Actions</div></th>
</tr>
</thead>
 <tbody>
 
<tr>   
    <td align="center">   
       
 
        
         <c:set var="myveteranid" value="${VeteranApplication.applicationid}"/>
        <c:out value="${myveteranid}"/>
        
    <td align="center"> 
	
        <c:out value="${VeteranApplication.hdzApplicant.firstname} ${VeteranApplication.hdzApplicant.lastname}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${VeteranApplication.hdzJob.position}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${VeteranApplication.hdzApplicant.veteran}"/>  
    
   </td>
  
   <td align="center">
   
   <input type="button" class="ValidateVeteran" name="ValidateVeteran${VeteranApplication.hdzApplicant.applicantid}" id="ValidateVeteran${VeteranApplication.hdzApplicant.applicantid}" value="Validate" />
   
    <input type="button" class="FailVeteran" name="FailVeteran${VeteranApplication.hdzApplicant.applicantid}" id="FailVeteran${VeteranApplication.hdzApplicant.applicantid}" value="Fail"/> 
       
    
   </td> 
   
	 </tr> 
	 
	  </tbody> 
 </table> 
 
 
 
 <div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">Job History</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">App ID</div></th>
<th align="center"><div align="center">Applicant Name</div></th>
<th align="center"><div align="center">Previous Job</div></th>
<th align="center"><div align="center">Company</div></th>
<th align="center"><div align="center">Start Date</div></th>
<th align="center"><div align="center">End Date</div></th>
<th align="center"><div align="center">Description</div></th>
<th align="center"><div align="center">Actions</div></th>
</tr>
</thead>
 <tbody>
 <c:forEach var="work" items="${WorkHistoryCheck}">
<tr>   
    <td align="center">      
        <c:set var="myworkid" value="${WorkApplicationid}"/>
        <c:out value="${myworkid}"/>
        
    <td align="center"> 
	
        <c:out value="${work.hdzApplicant.firstname} ${work.hdzApplicant.lastname}"/>
   
 	</td> 
    
	<td align="center">
    <c:out value="${work.position}"/>  
    
   </td> 
   
   <td align="center">
    <c:out value="${work.companyname}"/>  
    
   </td>
   <td align="center">
    <c:out value="${work.startdate}"/>  
    
   </td>
   <td align="center">
    <c:out value="${work.enddate}"/>  
    
   </td>
   
    <td align="center">
    <c:out value="${work.description}"/>  
    
   </td>
    
   <td align="center">
   
   <input type="button" class="ValidateWork" name="ValidateWork${work.jobhistoryid}" id="ValidateWork${work.jobhistoryid}" value="Validate" />
   
    <input type="button" class="FailWork" name="FailWork${work.jobhistoryid}" id="FailWork${work.jobhistoryid}" value="Fail"/> 
       
    
   </td> 
   
	 </tr> 
	 </c:forEach>
	  </tbody> 
 </table> 
 
  <div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">References</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">App ID</div></th>
<th align="center"><div align="center">Applicant Name</div></th>
<th align="center"><div align="center">Reference Name</div></th>
<th align="center"><div align="center">Reference Email</div></th>
<th align="center"><div align="center">Reference Phone</div></th>
<th align="center"><div align="center">Reference Position</div></th>
<th align="center"><div align="center">Actions</div></th>
</tr>
</thead>
 <tbody>
 <c:forEach var="refer" items="${ReferenceCheck}">
<tr>   
    <td align="center">      
        <c:set var="myreferid" value="${WorkApplicationid}"/>
        <c:out value="${myreferid}"/>
        
    <td align="center"> 
	
        <c:out value="${refer.hdzApplicant.firstname} ${refer.hdzApplicant.lastname}"/>
   
 	</td> 
    <td align="center"> 
	
        <c:out value="${refer.refname}"/>
    
 	</td> 
	<td align="center">
    <c:out value="${refer.refemail}"/>  
    
   </td> 
   
   <td align="center">
    <c:out value="${refer.refphone}"/>  
    
   </td>
   <td align="center">
    <c:out value="${refer.refposition}"/>  
    
    
   <td align="center">
   
   <input type="button" class="ValidateRef" name="ValidateRef${refer.refid}" id="ValidateRef${refer.refid}" value="Validate" />
   
    <input type="button" class="FailRef" name="FailRef${refer.refid}" id="FailRef${refer.refid}" value="Fail"/> 
       
    
   </td> 
   
	 </tr> 
	 </c:forEach>
	  </tbody> 
 </table> 
 
 
 
 

 </div> 
  <script  src="js/workhisrefercheck.js"></script>
</form>



</body>
</html>


