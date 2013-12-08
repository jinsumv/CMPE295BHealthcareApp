<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%><html><head>

    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
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
			<div style="float:left;">
			<c:if test="${not showfollowbutton}">
				<img src="images/blue-ribbon.png" width=30px height=30px style="position:absolute;top:5px;">
			</c:if>
			<img src="images/doctor1.jpg" alt="doc profile" width="92" height="92" style="border:2px solid grey;" /></a> 	
			</div>
			
			<div id="docinf" style="float:right;padding-left:20px;padding-top:10px;">	
			<label id="docname"><b>Dr. ${doctor.name}</b></label><br>
			<label id="specialisation"><i>${doctor.areaOfPractice}</i></label><br />
			<label id="achievements"><i>${doctor.qualifyingDegree}</i></label>
			</div>
		</div>
			
		<div style="padding-top:10px;padding-bottom:10px;">
			<c:choose>
				<c:when test="${showfollowbutton}">
				<a href="followdoctor.do?doctorid=${doctor.doctorId}"><img src="images/FollowBtn.png" alt="follow doc" width="152" height="35"/></a>
				</c:when>
				<c:otherwise>
				<img style="opacity:0.4" src="images/FollowBtn.png" alt="follow doc" width="152" height="35"/>
				</c:otherwise>
			</c:choose>
			<a href="askquestion.do?doctorid=${doctor.doctorId}"><img src="images/SendmsgBtn.png" alt="send " width="152" height="35"/></a>
		</div>
			
		<div class="followers">${followercount} <br/> FOLLOWERS</div>
		
		<div class="reviews" style="margin-left:5px;">
			<a href="reviewlist.do?doctorid=${doctor.doctorId}" style="text-decoration:none;">${reviewcount} <br/> REVIEWS</a>
		</div>
		<div style="clear:both;"></div>
		
		</section>
		
<section class="bottomcontent" style="padding:0px;">
	<div id="bio-header" class="headers">BIOGRAPHY</div>
	<div id="bio-detail">
	    <div class="sub-headers">
	    	<div style="float:left;padding-right:10px;">
	    		<img src="images/doc_speciality.png" width=50px height=60px />
	    	</div>
	    	<div style="float:left;">
			<h4>SPECIALITIES</h4>
			  
			${doctorDetails.areaOfPracticeName}
			 
			<p>
			${doctorDetails.areaOfPracticeDetails}
			</p>
			</div>
			<div style="clear:both;"></div>
	    </div>
	    <div class="sub-headers">
	    	<div style="float:left;padding-right:10px;">
	    		<img src="images/doc_honors.png" width=50px height=60px />
	    	</div>
	    	<div style="float:left;">
			   <h4>SPECIAL HONORS</h4>
			   <ul>
			   	  <c:if test="${not empty doctorDetails.specialHonors1}"><li>${doctorDetails.specialHonors1}</li></c:if>	
			   	  <c:if test="${not empty doctorDetails.specialHonors2}"><li>${doctorDetails.specialHonors2}</li></c:if>	
			   	  <c:if test="${not empty doctorDetails.specialHonors3}"><li>${doctorDetails.specialHonors3}</li></c:if>	
			   </ul>
		   </div>
		   <div style="clear:both;"></div>
	  	</div>
  	</div>



  <div  id="practice-header" class="headers">PRACTICE INFORMATION</div>
     <div id="practice-detail">
		<div class="sub-headers">
		   <div style="float:left;padding-right:10px;">
	    		<img src="images/doc_location.png" width=50px height=70px />
	    	</div>
	    	<div style="float:left;">
			   <h4>PRACTICE LOCATION</h4>
			    <p>
			    ${doctorDetails.practiceName}<br/>
			    ${doctorDetails.practiceAddress}<br/>
			    ${doctorDetails.practiceCity}, ${doctorDetails.practiceState}<br/>
			    ${doctorDetails.practiceZip}
			   </p>
		   </div>
		   <div style="clear:both;"></div>
		</div>
		
		<div class="sub-headers">
			<div style="float:left;padding-right:10px;">
	    		<img src="images/doc_hours.gif" width=50px height=50px />
	    	</div>
	    	<div style="float:left;">
			  <h4>OFFICE HOURS</h4>
			  <p>
			    <c:if test="${not empty doctorDetails.practiceHours1}">${doctorDetails.practiceHours1}</c:if><br/>
			    <c:if test="${not empty doctorDetails.practiceHours2}">${doctorDetails.practiceHours2}</c:if>
			  </p>
		  	</div>
		  	<div style="clear:both;"></div>
		</div>
		
		<div class="sub-headers">
			<div style="float:left;padding-right:10px;">
	    		<img src="images/doc_website.png" width=50px height=50px />
	    	</div>
	    	<div>
		  		<h4>PRACTICE WEBSITE</h4>
		  		<c:if test="${not empty doctorDetails.website}"><a href="${doctorDetails.website}">${doctorDetails.website}</a></c:if>
	  		</div>
		</div>
	</div>
  

    <div id="education-header" class="headers">EDUCATION &amp; EXPERIENCE</div>
	<div id="education-detail">
		<div class="sub-headers">
		<div style="float:left;padding-right:10px;">
	    		<img src="images/doc_residency.png" width=50px height=50px />
	    	</div>
	    	<div style="float:left;">
				<h4>RESIDENCIES</h4>
			    <ul>
			       <c:if test="${not empty doctorDetails.residencies1}"><li>${doctorDetails.residencies1}</li></c:if>
			       <c:if test="${not empty doctorDetails.residencies2}"><li>${doctorDetails.residencies2}</li></c:if>
			       <c:if test="${not empty doctorDetails.residencies3}"><li>${doctorDetails.residencies3}</li></c:if>
			    </ul>
		    </div>
		    <div style="clear:both;"></div>
	  </div>
	  
	    <div class="sub-headers">
	    <div style="float:left;padding-right:10px;">
	    		<img src="images/doc_graduate.jpg" width=50px height=50px />
	    	</div>
	    	<div style="float:left;">
			  	<h4>MEDICAL/GRADUATE SCHOOL</h4>
			    <ul>
			      <c:if test="${not empty doctorDetails.medicalSchool1}"><li>${doctorDetails.medicalSchool1}</li></c:if>
			      <c:if test="${not empty doctorDetails.medicalSchool2}"><li>${doctorDetails.medicalSchool2}</li></c:if>
			      <c:if test="${not empty doctorDetails.medicalSchool3}"><li>${doctorDetails.medicalSchool3}</li></c:if>
			    </ul>
		    </div>
		    <div style="clear:both;"></div>
	  </div>
	  
	  <div class="sub-headers">
	  	<div style="float:left;padding-right:10px;">
	    		<img src="images/doc_affiliations.png" width=50px height=70px />
	    	</div>
	    	<div style="float:left;">
				<h4>AFFILIATIONS</h4>
			    <ul>
			      <c:if test="${not empty doctorDetails.affiliations1}"><li>${doctorDetails.affiliations1}</li></c:if>
			      <c:if test="${not empty doctorDetails.affiliations2}"><li>${doctorDetails.affiliations2}</li></c:if>
			      <c:if test="${not empty doctorDetails.affiliations3}"><li>${doctorDetails.affiliations3}</li></c:if>
			    </ul>
	    	</div>
    		<div style="clear:both;"></div>
	  </div>
  </div>
  
</section>
</div></div>

	 </body>
</html>