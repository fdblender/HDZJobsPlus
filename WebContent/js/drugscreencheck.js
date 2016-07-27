$(document).ready(function() {
	
	
	$('.PositiveStd').click(function (event) {
	
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(11);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='stdid='+ id+ "&addcomment=" + comment;
		 $.ajax({  
			    type: "GET",  
			    url: "DrugCheckForm",
           data: dataString,
           success: function(data){
        	   alert("STD is Positive!");
               window.location = 'http://localhost:8080/HDZJobs/drugscreencheck.jsp';
             }                
			  });
		
	 
	 
});            
	$('.NegativeStd').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(11);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='stdid='+ id+ "&addcomment=" + comment;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "DrugCheckForm",
          data: dataString,
          success: function(data){
        	  alert("STD is Negative");
              window.location = 'http://localhost:8080/HDZJobs/drugscreencheck.jsp';
            }                
			  });
	}); 
		 
	$('.PositiveDot').click(function (event) {
		
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(11);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='dotid='+ id+ "&addcomment=" + comment;
		 $.ajax({  
			    type: "GET",  
			    url: "DrugCheckForm",
          data: dataString,
          success: function(data){
       	   alert("DOT is Positive!");
              window.location = 'http://localhost:8080/HDZJobs/drugscreencheck.jsp';
            }                
			  });
		
	 
	 
});            
	$('.NegativeDot').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(11);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='dotid='+ id+ "&addcomment=" + comment;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "DrugCheckForm",
         data: dataString,
         success: function(data){
       	  alert("DOT is Negative");
             window.location = 'http://localhost:8080/HDZJobs/drugscreencheck.jsp';
           }                
			  });
	}); 	
	 
	$('.PositiveAlcohol').click(function (event) {
		
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(15);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='alcoholid='+ id+ "&addcomment=" + comment;
		 $.ajax({  
			    type: "GET",  
			    url: "DrugCheckForm",
         data: dataString,
         success: function(data){
      	   alert("Alcohol is Positive!");
             window.location = 'http://localhost:8080/HDZJobs/drugscreencheck.jsp';
           }                
			  });
		
	 
	 
});            
	$('.NegativeAlcohol').click(function (event) {
		 var idItem = $(this).attr('id');
		 var id = idItem.substring(15);
		 var comment=document.getElementById('addcomment').value;
		 var dataString ='alcoholid='+ id+ "&addcomment=" + comment;
		 
		 $.ajax({  
			    type: "POST",  
			    url: "DrugCheckForm",
        data: dataString,
        success: function(data){
      	  alert("Alcohol is Negative");
            window.location = 'http://localhost:8080/HDZJobs/drugscreencheck.jsp';
          }                
			  });
	}); 
	
	
	             
		  
	
});