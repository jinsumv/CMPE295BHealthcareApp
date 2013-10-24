<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%><html><head>


    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <link href="css/main.css" media="screen" rel="stylesheet" type="text/css"/>
    <title>${journal.title}</title>


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


    <script type="text/javascript" src="js/travellog.js"></script>
    
    <link rel="stylesheet" href="css/style.css" type="text/css" />
	
	<script>
	$(document).ready(function() {
		$(".doc").hide();
		$(".patient").show();	
		
		$("#patientregister").click(function() {
		$(".patient").show();
		$(".doc").hide();	
		});	
		
		$("#docregister").click(function() {
		$(".doc").show();
		$(".patient").hide();	
		});	
	});
	</script>
  </head>
  
  <body class="body">
  
	<header class="mainheader">
          <%@include file="header.jsp" %>	
	</header>

 	<div class="mainContent">
	  <div class="content">
		 <div class="topcontent">
								
			<p><a href="#" id="patientregister"><b>Are you a Patient?</b></a> OR <a href="#" id="docregister"><b>Are you a Doctor?</b></a><br>
			
			<div class="patient">
			<b>Sign Up</b> Volunteer! Your opportunity to server and connect with your patients for FREE!</p>
			<p>
			<form action="patientsignup.do" method="post">
  			  <input type="email" name="email" placeholder="Email  Eg: user@gmail.com" autofocus style='width: 100%'required ><br>
  			  <input type="text" name="pwd" placeholder="New Password" style='width: 100%' required><br><br>
			  <input type="image" src="images/SignUpBtn.jpg" name="Submit Form" width="100%" height="50px" />
 			</form></p>
			</div>
			
			<div class="doc">
			<b>Sign Up</b> Its helpful, private, and FREE!</p>
			<p>
			<form action="docsignup.do" method="post">
  			  <input type="text" name="fname" placeholder="First Name" style='width: 48%' autofocus required> 
			  <input type="text" name="lname" placeholder="Last Name" style='width: 48%' required><br>
  			  <input type="email" name="email" placeholder="Email  Eg: user@gmail.com" style='width: 100%' required><br>
  			  <input type="text" name="pwd" placeholder="New Password" style='width: 100%' required><br>
			  <select name="degree" style='width: 100%' required>
				<option value="">Qualifying degree</option>
				<option value="0">MD</option>
				<option value="1">MDCM</option>
				<option value="2">DO</option>
				<option value="3">MBBS</option>
				<option value="4">MBChB</option>
				<option value="5">DMD</option>
				<option value="6">DDS</option>
				<option value="7">DPM</option>
				<option value="8">PsYD</option>
				<option value="9">PhD</option>
				<option value="10">PharmaD</option>
			 </select><br>
			 <select name="area" style='width: 100%' required>
				<option value="">Area of practice</option>
				<option value="0">Allergy and Immunology</option>
				<option value="1">Anaesthetics</option>
				<option value="2">Pathology</option>
				<option value="3">Cardiology</option>
				<option value="4">Endocrinology</option>
				<option value="5">Gastroenterology</option>
				<option value="6">Internal Medicine</option>
				<option value="7">Neurology</option>
				<option value="8">Neurosurgery</option>
				<option value="9">Opthalmology</option>
				<option value="10">Orthopaedics</option>
				<option value="11">Pediatrics</option>
				<option value="12">Neonatology</option>
				<option value="13">Plastic Surgery</option>
				<option value="14">Radiology</option>
				<option value="15">Radiotherapy</option>
				<option value="16">General Surgery</option>
				<option value="17">Urology</option>
				<option value="18">Vascular Surgery</option>
			</select><br>
				
			<input type="text" name="license" placeholder="Professional License #" style='width: 100%' required><br><br>
			<img src="images/DocSignUpBtn.jpg" name="Submit Form" width="100%" height="50px" />
		</form></p>
    	</div>
	</div>
  </div>
</div>
	
	<footer class="mainFooter">
	  <p>Copyright &copy; <a href="#" title="1sthtml">payal.com</a></p>
	</footer>
	<script src="js/main.js" type="text/javascript"></script>
</body>
</html>  