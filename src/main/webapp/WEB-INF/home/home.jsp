<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的博客</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<link rel="stylesheet" href="${CTP}/static/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="${CTP}/css/common.css"/>
		<link rel="stylesheet" href="${CTP}/css/blog-home.css"/>
	  <script src="${CTP}/static/jquery/jquery-3.3.1.js"></script>
	  <script src="${CTP}/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="${CTP}/static/bootstrap/bootstrapValidator/js/bootstrapValidator.js"></script>
    <script src="${CTP/js/blog-home.js"></script>
    <style type="text/css">
    	
    </style>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 header"></div>
			</div>
			<div class="row home">
				<div class="col-md-10 col-md-offset-1">
					<div class="col-md-1 left-side">
						<ul class="nav nav-pills nav-stacked nav-side">
  						<li class="active"><a href="">推荐</a></li>
  						<li class=""><a href="#">关注</a></li>
  						<li class=""><a href="#">资讯</a></li>
  						<li class=""><a href="#">人工智能</a></li>
  						<li class=""><a href="#">云计算/大数据</a></li>
  						<li class=""><a href="#">数据库</a></li>
  						<li class=""><a href="#">程序人生</a></li>
						</ul>
					</div>
					<div class="col-md-8 center">
						<div id="myCarousel" class="carousel slide">
							<!-- 轮播（Carousel）指标 -->
							<ol class="carousel-indicators">
								<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#myCarousel" data-slide-to="1"></li>
								<li data-target="#myCarousel" data-slide-to="2"></li>
							</ol>   
							<!-- 轮播（Carousel）项目 -->
							<div class="carousel-inner">
								<div class="item active">
									<img src="${CTP}/static/image/background/bg01.jpg" alt="First slide">
								</div>
								<div class="item">
									<img src="../static/image/background/bg02.jpg" alt="Second slide">
								</div>
								<div class="item">
									<img src="${CTP}/static/image/background/bg03.jpg" alt="Third slide">
								</div>
							</div>
							<!-- 轮播（Carousel）导航 -->
							<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
								<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							</a>
							<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
								<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							</a>
						</div>
						<div class="list-group list-article">
							<div class="list-group-item">
								<div class="col-md-1">
									<a href="#" data-toggle="tooltip" title="李磊">
										<img src="${CTP}/static/image/头像.png" class="img-circle">
									</a>
								</div>
								<div class="col-md-10">
									<a href="#">五大常用算法之二：动态规划算法</a>
								</div>
								<span class="glyphicon glyphicon-eye-open pull-right" data-toggle="tooltip" title="阅读量">&nbsp;335</span>
							</div>
							<div class="list-group-item">
								<div class="col-md-1">
									<a href="#" data-toggle="tooltip" title="岁时">
										<img src="${CTP}/static/image/头像.png" class="img-circle">
									</a>
								</div>
								<div class="col-md-10">
									<a href="#">五大常用算法之二：动态规划算法</a>
								</div>
								<span class="glyphicon glyphicon-eye-open pull-right" data-toggle="tooltip" title="阅读量">&nbsp;335</span>
							</div>
							<div class="list-group-item">
								<div class="col-md-1">
									<a href="#" data-toggle="tooltip" title="夏洛克将">
										<img src="${CTP}/static/image/头像.png" class="img-circle">
									</a>
								</div>
								<div class="col-md-10">
									<a href="#">五大常用算法之二：动态规划算法</a>
								</div>
								<span class="glyphicon glyphicon-eye-open pull-right" data-toggle="tooltip" title="阅读量">&nbsp;335</span>
							</div>
							<div class="list-group-item">
								<div class="col-md-1">
									<a href="#" data-toggle="tooltip" title="米酒">
										<img src="${CTP}/static/image/头像.png" class="img-circle">
									</a>
								</div>
								<div class="col-md-10">
									<a href="#">五大常用算法之二：动态规划算法</a>
								</div>
								<span class="glyphicon glyphicon-eye-open pull-right" data-toggle="tooltip" title="阅读量">&nbsp;335</span>
							</div>
							<div class="list-group-item">
								<div class="col-md-1">
									<a href="#" data-toggle="tooltip" title="扣扣号">
										<img src="${CTP}/static/image/头像.png" class="img-circle">
									</a>
								</div>
								<div class="col-md-10">
									<a href="#">五大常用算法之二：动态规划算法</a>
								</div>
								<span class="glyphicon glyphicon-eye-open pull-right" data-toggle="tooltip" title="阅读量">&nbsp;335</span>
							</div>
							<div class="list-group-item">
								<div class="col-md-1">
									<a href="#" data-toggle="tooltip" title="小雪儿">
										<img src="${CTP}/static/image/头像.png" class="img-circle">
									</a>
								</div>
								<div class="col-md-10">
									<a href="#">五大常用算法之二：动态规划算法</a>
								</div>
								<span class="glyphicon glyphicon-eye-open pull-right" data-toggle="tooltip" title="阅读量">&nbsp;335</span>
							</div>
						</div>
						<div class="page">
							<ul class="pagination">
								<li><a href="#">Prev</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">Next</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-3 right-side">
						<div class="searchArea">
							<h2 class="title"><strong>搜索</strong></h2>
							<div>
								<form id="search">
									<div class="input-group">
				            <input type="text" class="form-control" name="title" placeholder="请输入关键字"/>
				            <span class="input-group-btn">
											<button class="btn btn-default" type="button">搜索</button>
										</span>
					        </div>
								</form>
							</div>
						</div>
						<div class="recommend">
							<h2 class="title"><strong>今日推荐</strong></h2>
							<div>
								<ul class="list-group list-article">
									<li class="list-group-item">
										<a href="#">
											<label>五一出游，“我”的隐私被扒干净了</label>
											<img src="../static/image/background/bg05.jpg" class="img-rounded"/>
										</a>
									</li>
									<li class="list-group-item">
										<a href="#">
											<label>五一出游，“我”的隐私被扒干净了</label>
											<img src="../static/image/background/bg05.jpg" class="img-rounded"/>
										</a>
									</li>
									<li class="list-group-item">
										<a href="#">
											<label>五一出游，“我”的隐私被扒干净了</label>
											<img src="../static/image/background/bg05.jpg" class="img-rounded"/>
										</a>
									</li>
									<li class="list-group-item">
										<a href="#">
											<label>五一出游，“我”的隐私被扒干净了</label>
											<img src="../static/image/background/bg05.jpg" class="img-rounded"/>
										</a>
									</li>
									<li class="list-group-item">
										<a href="#">
											<label>五一出游，“我”的隐私被扒干净了</label>
											<img src="../static/image/background/bg05.jpg" class="img-rounded"/>
										</a>
									</li>
								</ul>
							</div>
						</div>
						
						<div class="recommend">
							<h2 class="title"><strong>今日推荐</strong></h2>
							<div>
								
							</div>
						</div>
					</div>
				</div>
				<div class="meau-gotop-box">
					<a id="backtop" class="btn-meau">
						<span class="	glyphicon glyphicon-chevron-up"></span>
					</a>
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
	  
	  $(".carousel").carousel();
		var width = $(".carousel-inner").width();
		$(".carousel-inner img").css("width",width+'px');
		
		$("[data-toggle='tooltip']").tooltip();
		
	});
</script>
