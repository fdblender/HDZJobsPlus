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
<title>Application Details</title>
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


<form action="ApplicationDetail" method="get" >
<div class="container" Style="width:600px">
<c:if test="${questionlist != null }">
<div>
<table>
<thead>
<tr>
<th>Question</th>
<th>Response</th>
</tr>
</thead>
<tbody>
<c:forEach var="question" items="${questionlist}">
<tr>
<td><c:out value="${question.hdzJobquestion.jobquestion }"/></td>
<td><c:out value="${question.testresponse}"/></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</c:if>
<br /><br /> 
 <c:if test="${role=='HRManager' or role=='HiringManager'}">
 <div align="center" Style="background-color: #01579b ;color: #fff;border-bottom-width: 0;font-weight: bold;font-size:16px; height:34px">Application Details</div>
<table border="1" align="center" class="table responstable table-bordered table-hover">
<thead align="center">
<tr align="center">
<th align="center"><div align="center">Fields</div></th>
<th align="center"><div align="center">Results</div></th>
</tr>
</thead>
 <tbody>
 <c:set var="role" value="${role}"/>
<tr>   
    <td align="center" Style="background-color: #01579b ;color: #fff;font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Application ID"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.applicationid}"/>
 		</td>	   
        </tr>
        <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Application Status"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.appstatus}"/>
 		</td>	
     </tr>
        <tr>
     <td align="center" Style="background-color: #01579b ;color: #fff;font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Applicant Name"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.firstname} ${myapplicationdetail.hdzApplicant.lastname}"/>
 		</td>	
     </tr>
     
    
       <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Coding Test"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.codingtest}"/>
 		</td>	
     </tr>
    
     
     
     <tr>
     
     
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Email"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.email}"/>
 		</td>	
     </tr>
     
     <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Birthday"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.bday}"/>
 		</td>	
     </tr>
     
     <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Citizen"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.citizen}"/>
 		</td>	
     </tr>
     
 
       <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Citizen Test"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.citizenflag}"/>
 		</td>	
     </tr>
    
     
     <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Visa"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.visa}"/>
 		</td>	
     </tr>
     
    
       <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Visa Test"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.visaflag}"/>
 		</td>	
     </tr>
     
     <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Veteran"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.veteran}"/>
 		</td>	
     </tr>
    
       <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Veteran Test"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.veteranflag}"/>
 		</td>	
     </tr>
   
     
<!--       <tr> -->
<!--      <td align="center" Style="font-weight: bold;font-size:16px; " >    -->
       
<%--  		<c:out value="Drug Test"/> --%>
<!--  		</td> -->
 	<%--  <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.drugtest}"/>
 		</td> --%>	
<!--      </tr> -->
      
       <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Drug Test Result"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.drugtestflag}"/>
 		</td>	
     </tr>
     
     
<!--      <tr> -->
<!--      <td align="center" Style="font-weight: bold;font-size:16px; " >    -->
       
<%--  		<c:out value="STD Panel"/> --%>
<!--  		</td> -->
 	<%--  <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.stdpanel}"/>
 		</td> --%>	
<!--      </tr> -->
         
       <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="STD Panel Test"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.stdpanelflag}"/>
 		</td>	
     </tr>
    
     
<!--       <tr> -->
<!--      <td align="center" Style="font-weight: bold;font-size:16px; " >    -->
       
<%--  		<c:out value="DOT Test"/> --%>
<!--  		</td> -->
 	<%--  <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.dottest}"/>
 		</td>	 --%>
<!--      </tr> -->
     
       
       <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="DOT Test"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.dottestflag}"/>
 		</td>	
     </tr>
    
     
     <tr>
<!--      <td align="center" Style="font-weight: bold;font-size:16px; " >    -->
       
<%--  		<c:out value="Alcohol Test"/> --%>
<!--  		</td> -->
 	<%--  <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.alcoholtest}"/>
 		</td> --%>	
     </tr>
     
     
       <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Alchohol Test"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzApplicant.alcoholtestflag}"/>
 		</td>	
     </tr>
     
     
     
     
         <tr>
     <td align="center" Style="background-color: #01579b ;color: #fff; font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Job"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzJob.hdzPosition.position}"/>
 		</td>	
     </tr>
     <tr>
     <td align="center" Style="font-weight: bold;font-size:16px; " >   
       
 		<c:out value="Job Description"/>
 		</td>
 	 <td align="center" Style="font-size:16px; " >   
       
 		<c:out value="${myapplicaitondetail.hdzJob.description}"/>
 		</td>	
     </tr>
     
	 
     
     
     
	  </tbody> 
 </table> 
 
 
 
 
 </c:if>
 
 <c:if test="${role!='HRManager' and role!='HiringManager'}">
			
				<div class="alert alert-success">
					<strong>You are not allowed to see this page!!</strong> <span id="showSearchTerm"></span>
				</div>
			
 
 </c:if>

 </div> 
 
</form>



</body>
</html>


