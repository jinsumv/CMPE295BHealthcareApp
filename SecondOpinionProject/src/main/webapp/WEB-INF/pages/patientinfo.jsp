<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class = "userprofile_top" >

	<c:if test="${not empty patient}">
	    <div style="float:left; padding-right: 20px;" >  
	    <div id="profile-picture">  
	       <img class="userpic" src="${patient.profilePicUrl}"/>
	     </div>
	     <form id="profile-picture-upload-form" action="patientnewprofilepic.do" method="post" enctype="multipart/form-data">
                <input id="profile-picture-upload" type="file" name="file" accept="image/*" capture="camera" class="hidden"/>
                <!-- <input class="hidden" type="submit" name="Upload" value="Upload"/> -->
            </form>  

<script type="text/javascript">	    
$(function() {
    $('#profile-picture').bind('click', function() {
    	
        console.log("Inside click of hidden");
        $('#profile-picture-upload').click();
    });
});

$(function() {
    $("#profile-picture-upload").change(function() {
        console.log("Inside change of file upload. Submitting form");
        $("#profile-picture-upload-form").submit();
    });
});
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