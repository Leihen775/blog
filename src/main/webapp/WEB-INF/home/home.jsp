<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>博客学院</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<link rel="stylesheet" href="${CTP}/static/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="${CTP}/css/common.css"/>
		<link rel="stylesheet" href="${CTP}/css/blog-home.css"/>
	  <script src="${CTP}/static/jquery/jquery-3.3.1.js"></script>
	  <script src="${CTP}/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="${CTP}/static/bootstrap/bootstrapValidator/js/bootstrapValidator.js"></script>
    <script src="${CTP}/js/blog-home.js"></script>
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
  						<li class="active"><a href="homepage" id="0">推荐</a></li>
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
							
							<%-- <div class="list-group-item">
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
							</div> --%>
							
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
									<!-- <li class="list-group-item">
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
									</li> -->
								</ul>
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
		$(".header").load("http://localhost:8080/blog/header"); //加载页头
    $(".footer").load("http://localhost:8080/blog/footer"); //加载页脚
	  
	  $(".carousel").carousel();
		var width = $(".carousel-inner").width();
		$(".carousel-inner img").css("width",width+'px');
		
		$("[data-toggle='tooltip']").tooltip();
		
		$.ajax({
			type:"POST",
			url:"../findAllCategory",
      success:function(data){
        var html = "";
        $.each(data,function(i,e){
        	var id=getUrlParam("id");
          if(id==e.id){
            $(".nav-side li").removeClass("active");
            html=html+"<li class='active'><a href='homepage?id="+e.id+"'>"+e.name+"</a></li>";
          }else{
        	  html=html+"<li><a href='homepage?id="+e.id+"'>"+e.name+"</a></li>"
          }
        });
        $(".nav-side").append(html);
      }
		});
		
		$(function(){
			var id=getUrlParam("id");
			if(id==null){
				$.ajax({
					type:"POST",
					url:"findallArticleList",
					data:{"pageNum":1},
					success:function(data){
						showInfo(data);
					}
				});
			}else{
				$.ajax({
          type:"POST",
          url:"findArticleByCategory",
          data:{"pageNum":1,"cid":id},
          success:function(data){
            showInfo(data);
          }
        });
			}
			
			$.ajax({
        type:"POST",
        url:"recommends",
        success:function(data){
        	showRecommends(data);
        }
      });
		});
		
		$(".list-article").delegate('#page-allarticle a','click',function(){
			var page = $(this).attr("href").split("#")[1];
			var id=getUrlParam("id");
      if(id==null){
        $.ajax({
          type:"POST",
          url:"findallArticleList",
          data:{"pageNum":page},
          success:function(data){
            showInfo(data);
          }
        });
      }else{
        $.ajax({
          type:"POST",
          url:"findArticleByCategory",
          data:{"pageNum":page,"cid":id},
          success:function(data){
            showInfo(data);
          }
        });
      }
		});
		
	});
	
	function getUrlParam(name)
  {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r!=null) return unescape(r[2]); return null; //返回参数值
  }
	
	function showpage(data){
	    var pages = data.pages;
	    var pageNum = data.pageNum;
	    if(pages==2){
	      if(pageNum==1){
	        var html="<ul class='pagination'>"+
	        "<li><a href='#1'>1</a></li>"+
	        "<li><a href='#2'>2</a></li>"+
	        "<li><a href='#2'>下一页</a></li><li><a href='#2'>尾页</a></li></ul>";
	      }else if(pageNum==pages){
	        var html="<ul class='pagination'>"+
	      "<li><a href='#1'>首页</a></li>"+
	      "<li><a href='#1'>上一页</a></li>"+
	      "<li><a href='#1'>1</a></li>"+
	      "<li><a href='#2'>2</a></li></ul>";
	      }
	    }else if(pages>2){
	      if(pageNum==1){
	        var html = "<ul class='pagination'>";
	        for(var i=1;i<=3;i++){
	          html=html+"<li><a href='#"+i+"'>"+i+"</a></li>";
	          if(i==3){
	            html = html +"<li><a href='#"+(pageNum+1)+"'>下一页</a></li><li><a href='#"+pages+"'>尾页</a></li></ul>";
	          }
	        }
	      }else if(pageNum==pages){
	        var html="<ul class='pagination'>"+
	             "<li><a href='#1'>首页</a></li>"+
	             "<li><a href='#"+(pageNum-1)+"'>上一页</a></li>";
	        for(var i=pages-2;i<=pages;i++){
	          html=html+"<li><a href='#"+i+"'>"+i+"</a></li>";
	          if(i==pages){
	            html = html +"</ul>";
	          }
	        }
	      }else{
	        var html="<ul class='pagination'>"+
	        "<li><a href='#1'>首页</a></li>"+
	        "<li><a href='#"+(pageNum-1)+"'>上一页</a></li>"+
	        "<li><a href='#"+(pageNum-1)+"'>"+(pageNum-1)+"</a></li>"+
	        "<li><a href='#"+pageNum+"'>"+pageNum+"</a></li>"+
	        "<li><a href='#"+(pageNum+1)+"'>"+(pageNum+1)+"</a></li>"+
	        "<li><a href='#"+(pageNum+1)+"'>下一页</a></li>"+
	        "<li><a href='#"+pages+"'>尾页</a></li></ul>";
	      }
	    }
	    $(".pagination").remove();
	    $(".page").append(html);
	  }
	  
	  function showInfo(data){
	    $(".center .list-article .list-group-item").remove();
	    var array = data.list;
	    var html = "";
	    $.each(array,function(i,e){
	      var title = subtitle(e.title);
	      html=html+"<div class='list-group-item'><div class='col-md-1'>"+
	      "<a href='#' data-toggle='tooltip' title='"+e.userInfo.username+"'>"+
	      "<img src='"+e.userInfo.imagePath+"' class='img-circle'></a></div>"+
	      "<div class='col-md-10'><a href='#'>"+title+"</a></div>"+
	      "<span class='glyphicon glyphicon-eye-open pull-right' data-toggle='tooltip' title='阅读量'>&nbsp;"+e.clickCount+"</span></div>";
	    });
	    html=html+"<div class='list-group-item'><div class='page' id='page-allarticle'></div></div>"
	    $(".center .list-article").append(html);
	    showpage(data);
	  }
	  
	  function showRecommends(data){
      $(".recommend .list-article .list-group-item").remove();
      var array = data.list;
      var html = "";
      $.each(array,function(i,e){
        var title = subtitle(e.title);
        html=html+"<li class='list-group-item'><a href='#'>"+
        "<label>"+title+"</label>"+
        "<img src='../static/image/background/bg05.jpg' class='img-rounded'/>"+
        "</a></li>";
      });
      html=html+"<div class='list-group-item'><div class='page' id='page-allarticle'></div></div>"
      $(".recommend .list-article").append(html);
      showpage(data);
    }
	  
	  function subtitle(data){
	    var ss= null;
	    if(data.length<2){
	      ss=data;
	    }else{
	      ss = data.substring(0,3);
	      ss = ss+"。。。";
	    }
	    return ss;
	  }
</script>
