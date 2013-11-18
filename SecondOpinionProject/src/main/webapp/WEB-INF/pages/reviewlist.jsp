<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <div class="mainContent" style="padding:10px;">
	    
	    <div class="messageslist">
		   <section>
 	         	<h2> Reviews for Dr. ${doctor.name} </h2><br>
 	         	<c:choose>
				      <c:when test="${not empty reviewList}">
				      	<c:forEach var="review" items="${reviewList}">
				   			<div style="border:1px solid grey; margin:15px; background:#FFF; border-radius:5px;">
				   				<p>From: ${review.patient.name}</p>
				   				<p>Message: ${review.text}</p>
				   				<p>Date: <fmt:formatDate pattern="MM/dd/yyyy" value="${review.reviewDate}" /></p>
			   				</div>
						</c:forEach>
				      </c:when>
				
				      <c:otherwise>
				      	No reviews yet!!
				      </c:otherwise>
				</c:choose>
		 	</section>
			<section>
				<div style="border:1px solid grey; margin:15px; border-radius:5px;">
					<form name="replyForm" action="addreview.do" method="post">
						<textarea name="reviewtext" placeholder="Review doctor" cols="50" rows="5"></textarea><br><br>
						<input type="hidden" name="doctorid" value="${doctor.doctorId}" />
						<input type="submit" value="Add Review"/>
					</form> 
				</div>
			</section>		 

 		</div>
 	</div>
</body>
</html>