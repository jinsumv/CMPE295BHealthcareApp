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

  </head>
  
  <body class="body">
  
	<header class="mainheader">
          <img src="images/Header.jpg">		
	  
	</header>

 	<div class="mainContent">
	  <div class="content">
		 <article class="topcontent">
			<header>
			  <h2><a href="#" title="First Post"></a></h2>
			</header>
			<b>Already have an account?</b>
			<p>
			<form action="j_spring_security_check" name="loginForm" method="post">
				<c:if test="${popupScreen!=null}">
					<div class="popupFieldLabel">
						<div class="error"><br/>Bad username/password</div>
					</div>
				</c:if>
  			  <input type="text" name="j_username" placeholder="Email Eg:test@gmail.com" autofocus required style='width: 100%'/><br><br>
  			  <input type="password" name="j_password" placeholder="Password" autofocus required style='width: 100%'/><br><br>
 			  <a class="saveButton" href="javascript:" onclick="document.loginForm.submit()">
 			  	<input type="image" src="images/Login.jpg" name="Submit Form" width="100%" height="50px" />
 			  </a>
			</form>			
		  	
		  <p>
		  	   <b> New user?</b><br>
			   <a href="registration.do"><img src="images/Register.jpg" name="Create New Account" width="100%" height="50px"/></a>
		</p>
		
		<p><a href="forgotpassword.do">Forgot Password? - Help Center</a>
	 </article>
	</div>
     </div>
	
	<!--  <footer class="mainFooter">
	  <p>Copyright &copy; <a href="#" title="1sthtml">payal.com</a></p>
	</footer> -->
	<script src="js/main.js" type="text/javascript"></script>
</body>
</html>  