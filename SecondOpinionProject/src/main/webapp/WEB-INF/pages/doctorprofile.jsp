<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%><html><head>

    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no" />
    <link href="css/main.css" media="screen" rel="stylesheet" type="text/css"/>
    <title>Healthcare App</title>

    <!-- Popup related includes -->
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/jquery.jmpopups-0.5.1.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
    <script type="text/javascript" src="js/jquery.simplemodal-1.3.5.min.js"></script>
    <!--  End popup includes -->

     <!--  JQuery Lightbox includes -->
    <script type="text/javascript" src="js/jquery.lightbox-0.5.min.js"></script>
    <link rel="stylesheet" href="css/jquery.lightbox-0.5.css" type="text/css" media="screen" />
    <!--  End JQuery Lightbox includes -->

    <link href="css/jquery-ui.css" rel="stylesheet" type="text/css"/>

    <!-- DWR includes -->
    <script type="text/javascript" src="dwr/interface/AjaxController.js"></script>
    <script type="text/javascript" src="dwr/engine.js"></script>
    <!-- End DWR includes -->

	<link rel="stylesheet" href="css/style.css" type="text/css" />

    <script type="text/javascript" src="js/travellog.js"></script>
    <script type="text/javascript">
		$( document ).ready(function() {
			$("#bio-detail").show();
		    $("#bio-header").click(function() {
		    	$("#bio-detail").toggle();
		    });
		    
		    $("#practice-detail").hide();
		    $("#practice-header").click(function() {
		    	$("#practice-detail").toggle();
		    });
		    
		    $("#education-detail").hide();
		    $("#education-header").click(function() {
		    	$("#education-detail").toggle();
		    });
		});
    </script>
    <style type="text/css">
    ul {
    	list-style-type: none;
    }
    
    .headers {
    	font-size: 18px;
    	font-weight: bold;
    	padding: 8px 20px;
    	background-image: -webkit-gradient(
			linear,
			left top,
			left bottom,
			color-stop(0.19, #FFFFFF),
			color-stop(0.65, #F0F0F0),
			color-stop(1, #E3E3E3)
		);
		background-image: -o-linear-gradient(bottom, #FFFFFF 19%, #F0F0F0 65%, #E3E3E3 100%);
		background-image: -moz-linear-gradient(bottom, #FFFFFF 19%, #F0F0F0 65%, #E3E3E3 100%);
		background-image: -webkit-linear-gradient(bottom, #FFFFFF 19%, #F0F0F0 65%, #E3E3E3 100%);
		background-image: -ms-linear-gradient(bottom, #FFFFFF 19%, #F0F0F0 65%, #E3E3E3 100%);
		background-image: linear-gradient(to bottom, #FFFFFF 19%, #F0F0F0 65%, #E3E3E3 100%);
		border-top: 1px solid #E3E3E3;
    }
    .sub-headers {
    	padding: 8px 20px;
    }
    .followers, .reviews {
    	float:left;
    	width:152px;
    	height:50px;
    	color:royalblue;
    	text-align: center; "
    	font-size: 18px;
    	font-weight: bold;
    	background:#E3E3E3;
		border-radius: 5px;
    }

  	input[type=text], textarea{
  		line-height: 25px;
	    border: none;
	    font-size: 14px;
	    width: 90%;
	    background-color: #F0F0F0;
  	}
  	.basicdetails td {
  		width: 30%;
		padding-left: 20px;
  	}
    </style>
  </head>
  
  <body class="body">
	<header class="mainheader">
	<%@include file="header.jsp" %>
	</header>

 	<div class="mainContent">
		<div class="content">
		<section class ="topcontent" >
		
		<div id="doc_pic" class="doc_details" style="position:relative;">
			<div id = "dr-profile-picture" style="float:left;">
			<img src="${doctor.profilePicUrl}"  alt="doc profile" width="92" height="92" style="border:2px solid grey;" /></a> 	
			</div>
			
			
			<div id="docinf" style="float:right;padding-left:20px;padding-top:10px;">	
			<label id="docname"><b>Dr. ${doctor.name}</b></label><br>
			<label id="specialisation"><i>${doctor.areaOfPractice}</i></label><br />
			<label id="achievements"><i>${doctor.qualifyingDegree}</i></label>
			</div>
		</div>
		<div style="clear:both;padding-bottom:10px;"></div>
		
		<form id="dr-profile-picture-upload-form" action="doctornewprofilepic.do" method="post" enctype="multipart/form-data">
                <input id="dr-profile-picture-upload" onchange="javascript:console.log('Submitting form');$('#dr-profile-picture-upload-form').submit();" type="file" name="file" accept="image/*" capture="camera" class="hidden"/>
            </form>  

<script type="text/javascript">     
$(function() {
    $('#dr-profile-picture').bind('click', function() {
        console.log("Inside click of hidden");
        $('#dr-profile-picture-upload').click();
    });
});
</script>           
            
			
		<div class="followers">${followercount} <br/> FOLLOWERS</div>
		
		<div class="reviews" style="margin-left:5px;">
			<a href="reviewlist.do?doctorid=${doctor.doctorId}" style="text-decoration:none;">${reviewcount} <br/> REVIEWS</a>
		</div>
		<div style="clear:both;"></div>
		
		</section>
		
<section class="bottomcontent" style="padding:0px;">
	<div id="bio-header" class="headers">BIOGRAPHY</div>
	<div id="bio-detail">	
		<form action="updatedoctorbiography.do" method="post">
	    <div class="sub-headers">
	    	<h4>SPECIALITIES</h4>
	    	<table class = "usertable">
	    		<tr class = "basicdetails">
              		<td> Speciality </td>
              		<td ><input type="text" name="areaOfPracticeName" value="${doctorDetails.areaOfPracticeName}" /></td>
                </tr>
	    		<tr class = "basicdetails">
              		<td> Speciality Details </td>
              		<td ><textarea name="areaOfPracticeDetails" rows="2" style="resize: none;display: table-cell;vertical-align: top;width: 100%;">${doctorDetails.areaOfPracticeDetails}</textarea></td>
                </tr>
			</table>
			
	    </div>
	    <div class="sub-headers">
		   <h4>SPECIAL HONORS</h4>
		   <table class = "usertable">
	    		<tr class = "basicdetails">
              		<td> Special Honors 1 </td>
              		<td ><input type="text" name="specialHonors1" value="${doctorDetails.specialHonors1}" /></td>
                </tr>
	    		<tr class = "basicdetails">
              		<td> Special Honors 2 </td>
              		<td ><input type="text" name="specialHonors2" value="${doctorDetails.specialHonors2}" /></td>
                </tr>
	    		<tr class = "basicdetails">
              		<td> Special Honors 3 </td>
              		<td ><input type="text" name="specialHonors3" value="${doctorDetails.specialHonors3}" /></td>
                </tr>
			</table>
	  	</div>
	  	<div style="padding-left:20px;margin-bottom: 10px;"><input class="new-button" type="submit" value="UPDATE" /></div>
	  	</form>
  	</div>



  <div  id="practice-header" class="headers">PRACTICE INFORMATION</div>
     <div id="practice-detail">
     	<form action="updatedoctorpracticeinfo.do" method="post">
		<div class="sub-headers">
		   <h4>PRACTICE LOCATION</h4>
		   <table class = "usertable">
	    		<tr class = "basicdetails">
              		<td> Practice Name </td>
              		<td ><input type="text" name="practiceName" value="${doctorDetails.practiceName}" /></td>
                </tr>
	    		<tr class = "basicdetails">
              		<td> Address </td>
              		<td ><input type="text" name="practiceAddress" value="${doctorDetails.practiceAddress}" /></td>
                </tr>
	    		<tr class = "basicdetails">
              		<td> City </td>
              		<td ><input type="text" name="practiceCity" value="${doctorDetails.practiceCity}" /></td>
                </tr>
	    		<tr class = "basicdetails">
              		<td> State </td>
              		<td ><input type="text" name="practiceState" value="${doctorDetails.practiceState}" /></td>
                </tr>
	    		<tr class = "basicdetails">
              		<td> Zip </td>
              		<td ><input type="text" name="practiceZip" value="${doctorDetails.practiceZip}" /></td>
                </tr>
			</table>
		</div>
		
		<div class="sub-headers">
		  <h4>OFFICE HOURS &amp; PRACTICE WEBSITE</h4>
		  <table class = "usertable">
	    		<tr class = "basicdetails">
              		<td> Practice Hours 1 </td>
              		<td > <input type="text" name="practiceHours1" value="${doctorDetails.practiceHours1}" /></td>
                </tr>
	    		<tr class = "basicdetails">
              		<td> Practice Hours 2 </td>
              		<td > <input type="text" name="practiceHours2" value="${doctorDetails.practiceHours1}" /></td>
                </tr>
	    		<tr class = "basicdetails">
              		<td> Website </td>
              		<td > <input type="text" name="website" value="${doctorDetails.website}" /></td>
                </tr>
			</table>
		</div>
		<div style="padding-left:20px;margin-bottom: 10px;"><input class="new-button" type="submit" value="UPDATE" /></div>
		</form>
	</div>
  

    <div id="education-header" class="headers">EDUCATION &amp; EXPERIENCE</div>
	<div id="education-detail">
		<form action="updatedoctoreducation.do" method="post">
		<div class="sub-headers">
	    <h4>RESIDENCIES</h4>
	    <table class = "usertable">
    		<tr class = "basicdetails">
             		<td> Residency 1 </td>
             		<td > <input type="text" name="residencies1" value="${doctorDetails.residencies1}" /></td>
               </tr>
    		<tr class = "basicdetails">
             		<td> Residency 2 </td>
             		<td > <input type="text" name="residencies2" value="${doctorDetails.residencies2}" /></td>
               </tr>
    		<tr class = "basicdetails">
             		<td> Residency 3 </td>
             		<td > <input type="text" name="residencies3" value="${doctorDetails.residencies3}" /></td>
               </tr>
		</table>
	  </div>
	  
	    <div class="sub-headers">
	    <h4>MEDICAL/GRADUATE SCHOOL</h4>
	    <table class = "usertable">
    		<tr class = "basicdetails">
             		<td> Medical School 1 </td>
             		<td > <input type="text" name="medicalSchool1" value="${doctorDetails.medicalSchool1}" /></td>
               </tr>
    		<tr class = "basicdetails">
             		<td> Medical School 2 </td>
             		<td > <input type="text" name="medicalSchool2" value="${doctorDetails.medicalSchool2}" /></td>
               </tr>
    		<tr class = "basicdetails">
             		<td> Medical School 3 </td>
             		<td > <input type="text" name="medicalSchool3" value="${doctorDetails.medicalSchool3}" /></td>
               </tr>
		</table>
	  </div>
	  
	  <div class="sub-headers">
	    <h4>AFFILIATIONS</h4>
	    <table class = "usertable">
    		<tr class = "basicdetails">
             		<td> Affliciation 1 </td>
             		<td > <input type="text" name="affiliations1" value="${doctorDetails.affiliations1}" /></td>
               </tr>
    		<tr class = "basicdetails">
             		<td> Affliciation 2 </td>
             		<td > <input type="text" name="affiliations2" value="${doctorDetails.affiliations2}" /></td>
               </tr>
    		<tr class = "basicdetails">
             		<td> Affliciation 3 </td>
             		<td > <input type="text" name="affiliations3" value="${doctorDetails.affiliations3}" /></td>
               </tr>
		</table>
	  </div>
	  <div style="padding-left:20px;margin-bottom: 10px;"><input class="new-button" type="submit" value="UPDATE" /></div>
	  </form>
  </div>
  
</section>
</div></div>

	 </body>
</html>