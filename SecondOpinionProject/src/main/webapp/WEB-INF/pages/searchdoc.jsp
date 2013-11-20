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
		
		<!--  
	 	<nav>
	  		<ul>
		  		<li class="active"><a href="#">Search a doctor</a></li>
		  		<li><a href="#">View my Profile</a></li>
		 		<li><a href="#">About</a></li>
		  		<li><a href="#">Contact Us</a></li>
	  		</ul>
		</nav>
		-->
	</header>

    <div class="mainContent" style="padding:10px;">
	    <form>
			<input type="search" name="search" placeholder="Type a speciality" autofocus style="width:90%" />
		</form>	
		<div class="specializationlist">
		   <section>
 	         	<h2> Top Doctor Specialities </h2><br>
 	         	<ul>
 	         		<li><a href="doctorsearchlist.do?speciality=Allergy+and+Immunology">Allergy and Immunology</a></li>
 	         		<li><a href="doctorsearchlist.do?speciality=Anaesthetics">Anaesthetics</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Pathology">Pathology</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Cardiology">Cardiology</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Endocrinology">Endocrinology</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Gastroenterology">Gastroenterology</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Internal+Medicine">Internal Medicine</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Neurology">Neurology</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Neurosurgery">Neurosurgery</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Opthalmology">Opthalmology</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Orthopaedics">Orthopaedics</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Pediatrics">Pediatrics</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Neonatology">Neonatology</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Plastic+Surgery">Plastic Surgery</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Radiology">Radiology</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Radiotherapy">Radiotherapy</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=General Surgery">General Surgery</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Urology">Urology</a></li>
 	         	    <li><a href="doctorsearchlist.do?speciality=Vascular+Surgery">Vascular Surgery</a></li>
			</ul>
		 </section>

 </div>
 </div>


<!--  	<footer class="mainFooter">
	  <p>Copyright &copy; <a href="#" title="3rdhtml"></a></p>
	</footer>  -->
</body>
</html>