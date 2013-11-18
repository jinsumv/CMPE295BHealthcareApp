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
								
			<div class="patient">
			<b>Sign Up</b> Its helpful, private, and FREE!</p>
			<p>
			<form action="patientsignup.do" method="post" modelAttribute="addPatientForm">
  			  <input type="email" name="email" placeholder="Email  Eg: user@gmail.com" autofocus style="width: 100%" required ><br><br>
  			  <input type="password" name="pwd" placeholder="New Password" style='width: 100%' required ><br><br>
  			  <input type="text" name="fullname" placeholder="Full Name" style='width: 100%' required ><br><br>
  			  <input type="text" name="dateofbirth" placeholder="Date of Birth (MM/DD/YYYY)" style='width: 100%' required ><br><br>Gender&nbsp;&nbsp;&nbsp;
  			  <input type="radio" name="gender" value="Male" checked >&nbsp;Male&nbsp;&nbsp;
  			  <input type="radio" name="gender" value="Female" >&nbsp;Female<br><br>
  			  <input type="text" name="location" placeholder="Location" style='width: 100%' required /><br><br>

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