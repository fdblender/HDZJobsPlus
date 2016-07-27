$(document).ready(function() {
	
	
	$('.ValidateRef').click(function (event) {
	
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(11);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='refid='+ id+ "&addcomment=" + comment;
		 $.ajax({  
			    type: "GET",  
			    url: "Workhistoryreferenceform",
           data: dataString,
           success: function(data){
        	   alert("Reference Validated!");
        	   window.location = 'http://localhost:8080/HDZJobs/workhisrefercheck.jsp';
             }                
			  });
		
	 
	 
});            
	$('.FailRef').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(7);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='refid='+ id + "&addcomment=" + comment;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "Workhistoryreferenceform",
          data: dataString,
          success: function(data){
        	  alert("Failed to Verify Reference");
        	  window.location = 'http://localhost:8080/HDZJobs/workhisrefercheck.jsp';
            }                
			  });
	}); 
		 
	$('.ValidateWork').click(function (event) {
		
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(12);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='workid='+ id + "&addcomment=" + comment;
		 $.ajax({  
			    type: "GET",  
			    url: "Workhistoryreferenceform",
          data: dataString,
          success: function(data){
       	   alert("Job History Validated!");
       	 window.location = 'http://localhost:8080/HDZJobs/workhisrefercheck.jsp';
            }                
			  });
		
	 
	 
});
	
	$('.FailWork').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(8);
		 
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='workid='+ id+ "&addcomment=" + comment;
		 $.ajax({  
			    type: "POST",  
			    url: "Workhistoryreferenceform",
         data: dataString,
         success: function(data){
       	  alert("Failed to Verify Job History");
       	 window.location = 'http://localhost:8080/HDZJobs/workhisrefercheck.jsp';
           }                
			  });
	}); 
	
	$('.ValidateVeteran').click(function (event) {
		
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(15);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='veteranid='+ id + "&addcomment=" + comment;
		 $.ajax({  
			    type: "GET",  
			    url: "Workhistoryreferenceform",
         data: dataString,
         success: function(data){
      	   alert("Job History Veteran!");
             window.location = 'http://localhost:8080/HDZJobs/workhisrefercheck.jsp';
           }                
			  });
		
	 
	 
});
	
	$('.FailVeteran').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(11);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='veteranid='+ id+ "&addcomment=" + comment;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "Workhistoryreferenceform",
        data: dataString,
        success: function(data){
      	  alert("Failed to Verify Veteran");
      	 window.location = 'http://localhost:8080/HDZJobs/workhisrefercheck.jsp';
          }                
			  });
	}); 
	 
	             
		  
	
});