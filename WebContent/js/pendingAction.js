/**
 * 
 */
$(document).ready(function(){
     $('.actionSubmit').click(function (event) {
    	 alert("in");
			 var id = $(this).attr('id');
			 var dataString ='applicationid='+ id;
			 alert(dataString);
			 $.ajax({  
				    type: "POST",  
				    url: "ActionSubmit",
	             data: dataString,
	             success: function(data){
	                 //window.location = 'http://localhost:8080/BlueHorn/home.jsp';
	            	 window.location = data.url;
	               }                
			 });		 		 
	 });
});