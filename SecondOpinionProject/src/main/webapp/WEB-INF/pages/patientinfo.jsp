<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class = "userprofile_top" >
<c:if test="${not empty patient}">
	<div id = "profile-picture" style="float:left; padding-right: 20px;padding-left: 15px;" >		
			
			<img class="userpic" src="${patient.profilePicUrl}"  style="border:2px solid grey;"/>
			
			
	</div>	
	
	    <div style="float:left; padding-right: 20px;" >  
	    
	    <form id="profile-picture-upload-form" action="patientnewprofilepic.do" method="post" enctype="multipart/form-data">
                <input id="profile-picture-upload" onchange="javascript:console.log('Submitting form');$('#profile-picture-upload-form').submit();" type="file" name="file" accept="image/*" capture="camera" class="hidden"/>
         </form>  

<script type="text/javascript">     
$(function() {
    $('#profile-picture').bind('click', function() {
        console.log("Inside click of hidden");
        $('#profile-picture-upload').click();
    });
});


// Does not work on Android webview. Commenting it out.
// $("document").ready(function() {
//    $('#profile-picture-upload2').change(function() {
//        console.log("Inside change of file upload. Submitting form");
//        $('#profile-picture-upload-form').submit();
//    });
//});
</script>     
            
	           
        </div>  
		<div id = "userinf">
			<p > Name: ${patient.name} </p>
			<p > Age: ${patient.age} </p>
			<p> Gender: ${patient.gender} </p>
			<p > Location: ${patient.location} </p>
		</div>
	</c:if>	
 </div> 
