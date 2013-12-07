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
    
  </head>
  
  <body class="body">
	<header class="mainheader">
	<%@include file="header.jsp" %>	
	</header>

 	<div class="mainContent">
		<div class="content">
		<section class ="topcontent" >
		
		<div id="doc_pic" class="doc_details">
			<div style="float:left;">
			<img src="images/doctor1.jpg" alt="doc profile" style="border:2px solid grey;" width="92" height="92"/></a> 	
			</div>
			
			<div id="docinf" style="float:right;padding-left:20px;padding-top:10px;">	
			<label id="docname"><b>Dr. ${doctor.name}</b></label><br>
			<label id="specialisation"><i>${doctor.areaOfPractice}</i></label><br>
			<label id="achievements"><i>${doctor.achievements}</i></label><br>
			<label id="rating"><i>${doctor.achievements}</i></label><br>
			<div class="rating">
			    <input type="radio" name="rating" value="0" <c:if test="${doctor.rating == 0}">checked</c:if> disabled/><span id="hide"></span>
			    <input type="radio" name="rating" value="1" <c:if test="${doctor.rating == 1}">checked</c:if> disabled/><span></span>
			    <input type="radio" name="rating" value="2" <c:if test="${doctor.rating == 2}">checked</c:if> disabled/><span></span>
			    <input type="radio" name="rating" value="3" <c:if test="${doctor.rating == 3}">checked</c:if> disabled/><span></span>
			    <input type="radio" name="rating" value="4" <c:if test="${doctor.rating == 4}">checked</c:if> disabled/><span></span>
			    <input type="radio" name="rating" value="5" <c:if test="${doctor.rating == 5}">checked</c:if> disabled/><span></span>
			</div>
			</div>
		</div>
		<br/>	
		
		<div style="float:left;background-color:#E1E1E8;width:152px;height:50px;color:royalblue;font-size:18px;text-align: center; font-weight: bold;">${followercount} <br> FOLLOWERS</div>
		
		<div style="margin-left:160px;background-color:#E1E1E8;width:152px;height:50px;color:royalblue;font-size:18px;vertical-align:middle;text-align: center; font-weight: bold;">
			<a href="reviewlist.do?doctorid=${doctor.doctorId}" style="text-decoration:none;">${reviewcount} <br> REVIEWS</a>
		</div>
		</section>
		
<div class="bottomcontent">
<details>
    <summary>BIO</summary>
     <h5>SPECIALITIES/AREAS OF PRACTICE</h5>
      <ul><li>Family Medicine</li></ul>
     
     <p><strong>Types of dental treatment: </strong> <em> ozone dentisty, laser, implants.</em><br>
    I was formerly an Assistant Professor at university of Illinois.<br>  Aenean ultricies mi vitae est.
    Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, 
    ornare sit amet, wisi. </p>
    
    <h5>SPECIAL HONORS</h5>
    <ul>
      <li>Top Doctor, Chicago,IL - Winter 2013</li>
      <li>Top Doctor, Chicago Region, IL - Summer 2013</li>
    </ul>
</details>

<details>
  <summary>PRACTICE INFORMATION</summary>
     <p><h5>PRACTICE LOCATION</h5>
      Dentistry at Millenium Park<br>
      8 S Michigan Avenue, Suite 1800<br>
      Chicago, IL<br>
      <b>P</b> 312750-900
   	</p>
  
   <p><h5>OFFICE HOURS</h5>
    <ul>
      <li>Mon - Wed 8am - 5pm</li>
      <li>Thurs & Fri 8am - 3pm</li>
    </ul>
  </p>
  
  <p>
    <h5>PRACTICE WEBSITE</h5>
    <a href="www.test.com">www.test.com</a>
  </p>
</details>

<details>

    <summary>EDUCATION & EXPERIENCE</summary>

    <div>
    <h5>RESIDENCIES</h5>
    <ul>
      <li>St Michael Medical Center, Newark, NJ</li>
    </ul>
  </div>
  
    <div>
    <h5>MEDICAL/GRADUATE SCHOOL</h5>
    <ul>
      <li>University of illinois College of Dentistry, Class of 1970</li>
    </ul>
  </div>
  
  <div>
    <h5>AFFILIATIONS</h5>
    <ul>
      <li>WEST ESSEX MEDICAL GROUP</li>
    </ul>
  </div>
  
</details>
</div>
</div></div>

<!--  	<footer class="mainFooter">
	  <p>Copyright &copy; <a href="#" title="2ndhtml"></a></p>
	</footer> -->
	 </body>
</html>