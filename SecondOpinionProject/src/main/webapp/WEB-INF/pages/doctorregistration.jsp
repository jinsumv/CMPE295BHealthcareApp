<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
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
	

  </head>
  
  <body class="body">
  
	<header class="mainheader">
          <%@include file="header.jsp" %>	
	</header>

 	<div class="mainContent">
	  <div class="content">
		 <div class="topcontent">
								

			
			<div class="doc">
			<b>Sign Up</b> Volunteer! Your opportunity to serve and connect with your patients for FREE!</p>
			<p>
			<form action="doctorsignup.do" method="post">
  			  <input type="text" name="fullname" placeholder="Full Name" style='width: 48%' autofocus required><br><br>
  			  <input type="email" name="email" placeholder="Email  Eg: user@gmail.com" style='width: 100%' required><br><br>
  			  <input type="password" name="pwd" placeholder="New Password" style='width: 100%' required><br><br>
  			  <input type="text" name="dateofbirth" placeholder="Date of Birth (MM/DD/YYYY)" style='width: 100%' required ><br><br>
  			  Gender&nbsp;&nbsp;&nbsp;
  			  <input type="radio" name="gender" value="Male" checked >&nbsp;Male&nbsp;&nbsp;
  			  <input type="radio" name="gender" value="Female" >&nbsp;Female<br><br>
  			  <select name="qualifyingdegree" style='width: 100%' required>
				<option value="">Qualifying degree</option>
				<option value="MD">MD</option>
				<option value="MDCM">MDCM</option>
				<option value="DO">DO</option>
				<option value="MBBS">MBBS</option>
				<option value="MBChB">MBChB</option>
				<option value="DMD">DMD</option>
				<option value="DDS">DDS</option>
				<option value="DPM">DPM</option>
				<option value="PsYD">PsYD</option>
				<option value="PhD">PhD</option>
				<option value="PharmaD">PharmaD</option>
			 </select><br><br>
			 <select name="areaofpractice" style='width: 100%' required>
				<option value="">Area of practice</option>
				<option value="Allergy and Immunology">Allergy and Immunology</option>
				<option value="Anaesthetics">Anaesthetics</option>
				<option value="Pathology">Pathology</option>
				<option value="Cardiology">Cardiology</option>
				<option value="Endocrinology">Endocrinology</option>
				<option value="Gastroenterology">Gastroenterology</option>
				<option value="Internal Medicine">Internal Medicine</option>
				<option value="Neurology">Neurology</option>
				<option value="Neurosurgery">Neurosurgery</option>
				<option value="Opthalmology">Opthalmology</option>
				<option value="Orthopaedics">Orthopaedics</option>
				<option value="Pediatrics">Pediatrics</option>
				<option value="Neonatology">Neonatology</option>
				<option value="Plastic Surgery">Plastic Surgery</option>
				<option value="Radiology">Radiology</option>
				<option value="General Surgery">General Surgery</option>
				<option value="Urology">Urology</option>
				<option value="Vascular Surgery">Vascular Surgery</option>
			</select><br><br>
			<input type="text" name="licensenumber" placeholder="Professional License #" style='width: 100%' required><br><br>
			<input type="text" name="achievements" placeholder="Achievements" style='width: 100%'><br><br>
			 <c:if test="${param.invalidRecaptcha == 'true'}">
  			   <span class="error_validation"><spring:message code="invalid.captcha" text="Invalid captcha please try again"/></span>
  			 </c:if>
            
			<%
              ReCaptcha reCaptchaVar = ReCaptchaFactory.newReCaptcha("6LfARuoSAAAAAKXdB0wLyJu7pVBl8nfp0-SpAL6X", "6LfARuoSAAAAAKoszbmVYYkidNNvv-3kWQhcghpd", false);
  			  out.print(reCaptchaVar.createRecaptchaHtml("ReCaptchaError", null, null));
            %>
			<input type="image" src="images/SignUpBtn.jpg" name="Submit Form" width="100%" height="50px" />
		</form></p>
    	</div>
    	  			  
		

             
			  
	</div>
  </div>
</div>
	
	<!--   <footer class="mainFooter">
	  <p>Copyright &copy; <a href="#" title="1sthtml">payal.com</a></p>
	</footer> -->
	<script src="js/main.js" type="text/javascript"></script>
</body>
</html>  