/**
 * 
 */
$(document).ready(function(){
	
	 $( "#accordion" ).accordion();
     $('.buttonLink').click(function (event) {
    	 var score = $("#score").val();
    	 if (score== null || score == "") {
    		 alert("Please Enter Score");
    		 event.preventDefault();
    		 //return;
    	 }
			 var id = $("#commentInterview").val();
			 var dataString ='commentInterview='+ id + '&score=' + score;
			 
			 $.ajax({  
				    type: "POST",  
				    url: "CommentSubmit",
	             data: dataString,
	             success: function(data){
	               }                
			 });		 		 
	 });
     
     $('#submitIn').click(function (event) {
    	 var score = $("#score").val();
    	 if (score== null || score == "") {
    		 alert("Please Enter Score");
    		 event.preventDefault();
    		 //return;
    	 }
    	 var commentInterview = $("#commentInterview").val();
    	 if (commentInterview== null || commentInterview == "") {
    		 alert("Please Enter Comments");
    		 event.preventDefault();
    		 //return;
    	 }
    	 var result = $("#result").val();
    	 if (result== null || result == "") {
    		 alert("Please Enter Result");
    		 event.preventDefault();
    		 //return;
    	 }
			 	 
	 });
});