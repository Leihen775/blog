<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/common.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/blog-home.css"/>
	  <script src="${pageContext.request.contextPath}/static/jquery/jquery-3.3.1.js"></script>
	  <script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap/bootstrapValidator/js/bootstrapValidator.js"></script>
    <style type="text/css">
    	
    </style>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 header"></div>
			</div>
			<div class="row article">
				<div class="col-md-10 col-md-offset-1">
					<div class="col-md-9 content">
						
					</div>
					<div class="col-md-3"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 footer"></div>
			</div>
		</div>
	</body>
</html>
<script>
	$(function(){
	  $(".header").load("header.html");
	  $(".footer").load("footer.html");
	  
	});
</script>
