$(document).ready(function() {
	
	
	$('.ValidateRef').click(function (event) {
	
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(11);
		 var dataString ='refid='+ id;
		 $.ajax({  
			    type: "GET",  
			    url: "Workhistoryreferenceform",
           data: dataString,
           success: function(data){
        	   alert("Reference Validated!");
               window.location = 'http://localhost:8080/HDZjobs/workhisrefercheck.jsp';
             }                
			  });
		
	 
	 
});            
	$('.FailRef').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(7);
		 var dataString ='refid='+ id;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "Workhistoryreferenceform",
          data: dataString,
          success: function(data){
        	  alert("Failed to Verify Reference");
              window.location = 'http://localhost:8080/HDZjobs/workhisrefercheck.jsp';
            }                
			  });
	}); 
		 
	$('.ValidateWork').click(function (event) {
		
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(12);
		 var dataString ='workid='+ id;
		 $.ajax({  
			    type: "GET",  
			    url: "Workhistoryreferenceform",
          data: dataString,
          success: function(data){
       	   alert("Job History Validated!");
              window.location = 'http://localhost:8080/HDZjobs/workhisrefercheck.jsp';
            }                
			  });
		
	 
	 
});
	
	$('.FailWork').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(8);
		 var dataString ='workid='+ id;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "Workhistoryreferenceform",
         data: dataString,
         success: function(data){
       	  alert("Failed to Verify Job History");
             window.location = 'http://localhost:8080/HDZjobs/workhisrefercheck.jsp';
           }                
			  });
	}); 
	
	$('.ValidateVeteran').click(function (event) {
		
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(15);
		 var dataString ='veteranid='+ id;
		 $.ajax({  
			    type: "GET",  
			    url: "Workhistoryreferenceform",
         data: dataString,
         success: function(data){
      	   alert("Job History Validated!");
             window.location = 'http://localhost:8080/HDZjobs/workhisrefercheck.jsp';
           }                
			  });
		
	 
	 
});
	
	$('.FailVeteran').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(11);
		 var dataString ='veteranid='+ id;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "Workhistoryreferenceform",
        data: dataString,
        success: function(data){
      	  alert("Failed to Verify Job History");
            window.location = 'http://localhost:8080/HDZjobs/workhisrefercheck.jsp';
          }                
			  });
	}); 
	 
	             
		  
	
});
