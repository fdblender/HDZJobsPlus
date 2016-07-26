$(document).ready(function() {
	
	
	$('.ValidateDrug').click(function (event) {
	
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(12);
		 var dataString ='drugid='+ id;
		 $.ajax({  
			    type: "GET",  
			    url: "DrugCheckForm",
           data: dataString,
           success: function(data){
        	   alert("Drug Screen Validated!");
               window.location = 'http://localhost:8080/HDZJobs/drugscreencheck.jsp';
             }                
			  });
		
	 
	 
});            
	$('.FailDrug').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(8);
		 var dataString ='drugid='+ id;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "DrugCheckForm",
          data: dataString,
          success: function(data){
        	  alert("Failed to Verify Drug Screen");
              window.location = 'http://localhost:8080/HDZJobs/drugscreencheck.jsp';
            }                
			  });
	}); 
		 
		
	 
	             
		  
	
});
