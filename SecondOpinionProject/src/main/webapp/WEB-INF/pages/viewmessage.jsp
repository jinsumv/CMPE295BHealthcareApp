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
    <style type="text/css">
    .comment {
    	border: 1px solid grey;
    	padding: 10px;
    	border-radius: 5px;
    	margin-bottom: 10px;
    	font-size: 13px;
		font-style: italic;
    	background-color: #FFFFFF;
    }
    .commenter {
    	font-weight:bold;
    	font-size: 14px;
    	font-style: normal;
    }
    </style>
  </head>
  
  <body class="body">
	<header class="mainheader">
       <%@include file="header.jsp" %>   
	</header>

    <div class="mainContent" style="padding:10px;">
	    
	    <div class="messageslist">
		   <section>
 	         	<h2> Question : ${conversation.title} </h2><br>
 	         	<c:if test="${not empty commentList}">
			      	<c:set var="author" value="${commentList[0].commenter.name}" />
			      	<c:forEach var="comment" items="${commentList}" varStatus="outer">
			   			<div class="comment">
			   				
			   				<c:choose>
			   					<c:when test="${author == comment.commenter.name}">
			   						<span class="commenter">${comment.commenter.name}</span> asked
			   					</c:when>
			   					<c:otherwise>
			   						<span class="commenter">Dr. ${comment.commenter.name}</span> answered
			   					</c:otherwise>
			   				</c:choose> on <fmt:formatDate pattern="d MMM h:mm a" value="${comment.commentDate}" />
			   			 	<br/>
			   			 	<span style="font-size: 14px;">${comment.text}</span>
			   			 	<c:if test="${outer.index == 0}">
				   			 	<% if(request.getParameter("disablelike")!=null && request.getParameter("disablelike")!="") { %>
				   			 	<br/>
				   			 	Like: ${conversation.likes}&nbsp;<img src="images/like.jpg" width=30px height=30px style="opacity:0.4;">&nbsp;&nbsp;
				   				Dislike: ${conversation.dislikes}&nbsp;<img src="images/dislike.jpg" width=30px height=30px style="opacity:0.4;">
				   				<%} else {%>
				   			 	<br/>
				   			 	Like: ${conversation.likes}&nbsp;<a href="addlikes.do?conversationid=${conversation.conversationId}"><img src="images/like.jpg" width=30px height=30px></a>&nbsp;&nbsp;
				   				Dislike: ${conversation.dislikes}&nbsp;<a href="adddislikes.do?conversationid=${conversation.conversationId}"><img src="images/dislike.jpg" width=30px height=30px></a>
				   				<%}%>
			   			 	</c:if>
			   			</div>
					</c:forEach>
					<c:if test="${showreplybox}">
						<div class="comment">
							<form name="replyForm" action="addcomment.do" method="post">
								<textarea name="replytext" placeholder="Reply.." rows="5" rows="5" style="resize: none;display: table-cell;vertical-align: top;width: 100%;"></textarea>
								<br>
								<input type="hidden" name="conversationid" value="${conversation.conversationId}" />
								<input type="submit" value="Send"/>
							</form> 
						</div>
					</c:if>	
		        </c:if>
				
		 </section>

 </div>
 </div>
</body>
</html>