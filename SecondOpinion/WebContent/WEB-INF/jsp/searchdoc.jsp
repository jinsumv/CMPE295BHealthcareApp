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
       <img src="images/Header.jpg">	   
		
	 	<nav>
	  		<ul>
		  		<li class="active"><a href="#">Search a doctor</a></li>
		  		<li><a href="#">View my Profile</a></li>
		 		<li><a href="#">About</a></li>
		  		<li><a href="#">Contact Us</a></li>
	  		</ul>
		</nav>
	</header>

    <div class="mainContent">
	    <div class="home_content">
			<section class ="home_topcontent" >
				<form>
					<input name="search" placeholder="Search a Doctor" autofocus>
					<input type="submit" value="Search">
				</form>	
 			</section>

 	         <section class="home_bottomcontent">
 	         	<p> Top Doctor Specialities </p>
 	         	<ul class= "list_Deptmt">
 	         		<a href="#">
 	         			<li>Allergy and Immunology</li></a>
 	         		<a href="#">
 	         	    <li>Anaesthetics</li></a>
 	         	    <a href="#">
 	         	    <li>Pathology</li></a>
 	         	    <a href="#">
 	         	    <li>Cardiology</li></a>
 	         	    <a href="#">
 	         	    <li>Endocrinology</li></a>
 	         	    <a href="#">
 	         	    <li>Gastroenterology</li></a>
 	         	    <a href="#">
 	         	    <li>Internal Medicine</li></a>
 	         	    <a href="#">
 	         	    <li>Neurology</li></a>
 	         	    <a href="#">
 	         	    <li>Neurosurgery</li></a>
 	         	    <a href="#">
 	         	    <li>Opthalmology</li></a>
 	         	    <a href="#">
 	         	    <li>Orthopaedics</li></a>
 	         	    <a href="#">
 	         	    <li>Pediatrics</li></a>
 	         	    <a href="#">
 	         	    <li>Neonatology</li></a>
 	         	    <a href="#">
 	         	    <li>Plastic Surgery</li></a>
 	         	    <a href="#">	
 	         	    <li>Radiology</li></a>
 	         	    <a href="#">
 	         	    <li>Radiotherapy</li></a>
 	         	    <a href="#">
 	         	    <li>General Surgery</li></a>
 	         	    <a href="#">
 	         	    <li>Urology</li></a>
 	         	    <a href="#">
 	         	    <li>Vascular Surgery</li></a>
	</ul>
			 </section>

 </div>
 </div>


	<footer class="mainFooter">
	  <p>Copyright &copy; <a href="#" title="3rdhtml"></a></p>
	</footer>
</body>
</html>