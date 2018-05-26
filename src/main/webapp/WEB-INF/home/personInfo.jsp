<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<link rel="stylesheet" href="${CTP}/static/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${CTP}/static/metisMenu/metisMenu.min.css" />
    <link rel="stylesheet" href="${CTP}/static/font-awesome/css/font-awesome.css" />
    <link rel="stylesheet" href="${CTP}/static/datetimepicker/datetimepicker.min.css" />
    <link rel="stylesheet" href="${CTP}/static/fileinput/css/fileinput.min.css" />
    <link rel="stylesheet" href="${CTP}/static/jquery-confirm/css/jquery-confirm.css" />
		<link rel="stylesheet" href="${CTP}/css/common.css"/>
		<link rel="stylesheet" href="${CTP}/css/blog-home.css"/>
		<script src="${CTP}/static/jquery/jquery-3.3.1.js"></script>
		<script src="${CTP}/static/jquery-confirm/js/jquery-confirm.js"></script>
		<script src="${CTP}/static/bootstrap/js/bootstrap.min.js"></script>
		<script src="${CTP}/static/bootstrap/bootstrapValidator/js/bootstrapValidator.js"></script>
		<script src="${CTP}/static/datetimepicker/datetimepicker.min.js"></script>
		<script src="${CTP}/static/metisMenu/metisMenu.js"></script>
		<script src="${CTP}/static/wangEditor/release/wangEditor.min.js"></script>
		<script src="${CTP}/static/fileinput/js/fileinput.min.js"></script>
		<script src="${CTP}/static/fileinput/js/locales/zh.js"></script>
		<script src="${CTP}/js/blog-home.js"></script>
    <style type="text/css">
    	.meau-person{
    		height: 516px;
    	}
    	nav{
    		padding-top: 20px;
    		padding-bottom: 20px;
    	}
    	
    </style>
	</head>
	<body>
		<div class="container-fluid personinfo">
			<div class="row">
				<div class="col-md-12 header"></div>
			</div>
			<div class="row" style="background-color: #EEEFED;">
				<div class="col-md-12">
					<div class="col-md-2 meau-person">
						<nav class="navbar navbar-default navbar-static-top">
						  <div class="navbar-default sidebar" role="navigation">
						    <div class="sidebar-nav navbar-collapse">
						      <ul class="nav" id="side-menu">
							      <li>
							        <a href="#person/personalpage" index="0" class="nav-first-level" id="personal"><i class="fa fa-star fa-fw"></i> 个人中心</a>
							      </li>
							      <li>
							        <a href="#person/sysmessagepage" index="1" class="nav-first-level" id="message-sys"><i class="fa fa-commenting fa-fw"></i> 我的消息</a>
							      </li>
							      <li>
							        <a href="#" id="article"><i class="fa fa-book fa-fw"></i> 我的博客<span class="fa arrow"></span></a>
							        <ul class="nav nav-second-level">
							          <li>
							            <a href="#person/addarticlepage" index="2" id="add-article">添加文章</a>
							          </li>
							          <li>
							            <a href="#person/managearticlepage" index="3" id="manage-article">文章管理</a>
							          </li>
							          <li>
							            <a href="#person/managetagpage" index="4" id="manage-tag">个人标签管理</a>
							          </li>
							        </ul>
							      </li>
							      <li>
							        <a href="#"><i class="fa fa-edit fa-fw"></i> 我的问答<span class="fa arrow"></span></a>
							        <ul class="nav nav-second-level">
							          <li>
							            <a href="#person/addquestionpage" index="5">添加问题</a>
							          </li>
							          <li>
							            <a href="#person/managequestionpage" index="6">问题管理</a>
							          </li>
							        </ul>
							      </li>
							      <li>
							        <a href="#person/setaccountpage" index="7" class="nav-first-level"><i class="fa fa-wrench fa-fw"></i> 账号设置</a>
							        <!-- /.nav-second-level -->
							      </li>
							    </ul>
							  </div>
							  <!-- /.sidebar-collapse -->
							</div>
						</nav>
					</div>
					<div class="col-md-10 content">
						
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 footer"></div>
			</div>
		</div>
	</body>
</html>
<script>
	/*查询url附带参数值*/
	function getUrlParam(name)
	{
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg);  //匹配目标参数
		if (r!=null) return unescape(r[2]); return null; //返回参数值
	}
	
	$(function(){
	  $(".header").load("http://localhost:8080/blog/header"); //加载页头
	  $(".footer").load("http://localhost:8080/blog/footer"); //加载页脚
	  
	  $("#side-menu").metisMenu(); //加载侧边菜单
	  
		/*根据   url中index的值获取相应页面 */
		for(i=0;i<12;i++){
			if(getUrlParam("index")==i){
		  	var url = $("a[index$="+i+"]").attr("href");
		  	var title = $("a[index$="+i+"]").text();
		  	$("title").html(title);
		  	url = url.split("#")[1];
		  	$(".content").load("http://localhost:8080/blog/"+url);
	  	}
		}
	  
	  $(".nav-first-level").click(function(){
	  	var url = "personinfopage?index="+$(this).attr("index");
	  	window.location.href = url;
	  });
	  $(".nav-second-level a").click(function(){
	  	var url = "personinfopage?index="+$(this).attr("index");
	  	window.location.href = url;
	  });
	  
	});
	
</script>
