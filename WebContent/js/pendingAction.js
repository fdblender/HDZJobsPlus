/**
 * 
 */
$(document).ready(function(){
	 $( "#accordion" ).accordion();
     $('.buttonLink').click(function (event) {
    	 
			 var id = $("#commentInterview").val();
			 var dataString ='commentInterview='+ id;
			 
			 $.ajax({  
				    type: "POST",  
				    url: "CommentSubmit",
	             data: dataString,
	             success: function(data){
	               }                
			 });		 		 
	 });
});