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
    
  </head>
  
  <body class="body">
	<div id = "main_container">
	
	<div id = "header" >
		<header class="mainheader">
        	<%@include file="header.jsp" %>
		</header>
	</div>

	<div id = "body" >
 		<div class="mainContent">
			<div class="content">
			<section class ="topcontent" >
				   <%@include file="patientinfo.jsp" %>	
			</section>	
				  <article class= "bottomcontent">
				  <header><h2>Add symptoms </h2></header>
				  <form action="addpatientsymptom.do" method="post">
				  <h3> Symptom</h3>
  			  	  <input class = "category" type="text" name="symptom"  autofocus required><br>
  			  	  <h3>Notes</h3>
  			      <input class = "notes" type="text" name="notes"  autofocus required><br>
  			      <p>  </p>
 			      <input type="submit" name="Add symptom" value="Add Symptom">
			</form>
				  </article>  
				  				
 				
			</div>
		</div>
	</div>
	
    <!--  <div id = "footer">
	 	<footer >
	  		<p>Copyright &copy; <a href="#" title="2ndhtml"></a></p>
		</footer> -->
	</div>
	</div>
	
	</body>
</html>