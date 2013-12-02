<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class = "userprofile_top" >

	<c:if test="${not empty patient}">
	    <div style="float:left; padding-right: 20px;" onclick="location.href='patientprofile.do;'">    
	     <img class="userpic" src="${patient.profilePicUrl}"/>
	     <form action="patientnewprofilepic.do" method="post" enctype="multipart/form-data">
                <input type="file" name="file" accept="image/*" capture="camera" />
                <input type="submit" name="Upload" value="Upload"/>
            </form>  
	     
           
        </div>  
		<div id = "userinf">
			<p > Name: ${patient.name} </p>
			<p > Age: ${patient.age} </p>
			<p> Gender: ${patient.gender} </p>
			<p > Location: ${patient.location} </p>
		</div>
	</c:if>	
 </div> 