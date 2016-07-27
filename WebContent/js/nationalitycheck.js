$(document).ready(function() {
	
	
	$('.ValidateNationality').click(function (event) {
	
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(14);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='applicantid='+ id + "&addcomment=" + comment;
		 $.ajax({  
			    type: "GET",  
			    url: "Nationalityform",
           data: dataString,
           success: function(data){
        	   alert("Nationality Validated!");
               window.location = 'http://localhost:8080/HDZJobs/nationalitycheck.jsp';
             }                
			  });
		
	 
	 
});            
	$('.FailNationality').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(10);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='applicantid='+ id+ "&addcomment=" + comment;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "Nationalityform",
          data: dataString,
          success: function(data){
        	  alert("Failed to Verify Nationality");
              window.location = 'http://localhost:8080/HDZJobs/nationalitycheck.jsp';
            }                
			  });
	}); 
		 
		
	 
	             
		  
	
});