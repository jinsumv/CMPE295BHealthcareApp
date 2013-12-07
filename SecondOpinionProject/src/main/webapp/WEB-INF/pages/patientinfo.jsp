<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class = "userprofile_top" >
	<div style="float:left; padding-right: 20px;padding-left: 15px;" onclick="location.href='patientprofile.do;'">		
			<img class="userpic" src="images/patient.jpg" style="border:2px solid grey;"/>
	</div>	
	<c:if test="${not empty patient}">
		<div id = "userinf">
			<p > Name: ${patient.name} </p>
			<p > Age: ${patient.age} </p>
			<p> Gender: ${patient.gender} </p>
			<p > Location: ${patient.location} </p>
		</div>
	</c:if>	
 </div> 