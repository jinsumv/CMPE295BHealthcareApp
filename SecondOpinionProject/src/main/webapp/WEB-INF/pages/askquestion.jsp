<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="initial-scale=1,maximum-scale=1,user-scalable=no" />
    <link href="css/main.css" media="screen" rel="stylesheet" type="text/css"/>
    <title></title>


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
	 	   <!-- <nav>
	  		<ul>
		  		<li class="active"><a href="#">Select a Doctor</a></li>
		  		<li><a href="#">My Questions</a></li>
		  		<li><a href="#">My Profile</a></li>
	  		</ul>
		    </nav>	 --> 	
	       </header>
	   </div>

	   <div id = "body" >
              <div class="mainContent">
	           <div class="content">
	              <section class ="topcontent" >
				     <c:if test="${not empty doctor}">
							<div id="doc_pic" class="doc_details">
							<div style="float:left;">
							<img src="${doctor.profilePicUrl}" alt="doc profile" width="92" height="92" style="border:2px solid grey;" /></a> 	
							</div>
							
							<div id="docinf" style="float:right;padding-left:20px;padding-top:10px;">	
							<label id="docname"><b>Dr. ${doctor.name}</b></label><br>
							<label id="specialisation"><i>${doctor.areaOfPractice}</i></label><br>
							<label id="achievements"><i>${doctor.achievements}</i></label><br>
							</div>
						</div>
					</c:if>	
 	              </section>

		          <article class= "bottomcontent">
				  	  <form name="askForm" action="addNewQuestion.do" method="post">
				  	  <c:if test="${not empty doctor}" >
						  <input type="hidden" name="doctorid" value="${doctor.doctorId}" />
					  </c:if>		  	  
  			          <input type="text" name="title" placeholder="Question Title" autofocus style="width:100%;height:30px;" required><br><br>
  			          <textarea name="question" placeholder="Enter your brief description.." rows="5" style="resize: none;display: table-cell;vertical-align: top;width: 100%;" required></textarea><br><br>
 			          <input class="new-button" type="submit" name="Ask Question" value="Ask Question" align="middle">
 			          </form>
		          </article>  
			</div>
           </div>
          </div>
	  </div>
      </div>
	</body>
</html>
