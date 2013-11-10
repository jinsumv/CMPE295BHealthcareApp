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
				  <header><h2 class = "heading"> Allergies </h2></header>
				  <p><em> Complete your Allergy details. </em> </p>
				  <a href="patientaddallergy.do"><img id="addimage" src="images/add.png" /></a>
				  </article>  
				  
				  <article class= "bottomcontent">
				  <table class = "usertable" >
				   <c:if test="${not empty patientAllergies}">
                        <c:forEach var="allergy" items="${patientAllergies}">
                            <tr>
                                <td class = "borderbottom" style="width:40%;">${allergy.allergyName}</td>
                                <td class = "borderbottom" style="width:50%;">${allergy.notes}</td>
                                <td class = "borderbottom" style="width:10%;">
                                    <form name="deleteForm_${allergy.patientAllergyId}" action="removepatientallergy.do" method="post">
                                        <input type="hidden" name="allergyId" value="${allergy.patientAllergyId}" />
                                        <a href="javascript:" onclick="document.deleteForm_${allergy.patientAllergyId}.submit()">
                                            <img align="top" style="width:30px; height:30px;" src="images/DeleteBtn.png" />
                                        </a>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if> 
				  </table>
				  </article>
				  			
 			
			</div>
		</div>
	</div>
	
   <!--   <div id = "footer">
	 	<footer >
	  		<p>Copyright &copy; <a href="#" title="2ndhtml"></a></p>
		</footer> -->
	</div>
	</div>
	
	</body>
</html>