<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户注册</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<link rel="stylesheet" href="${CTP}/static/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="${CTP}/static/font-awesome/css/font-awesome.css" />
		<link rel="stylesheet" href="${CTP}/css/common.css"/>
		<link rel="stylesheet" href="${CTP}/css/blog-home.css"/>
	  <script src="${CTP}/static/jquery/jquery-3.3.1.js"></script>
	  <script src="${CTP}/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="${CTP}/static/bootstrap/bootstrapValidator/js/bootstrapValidator.js"></script>
    <script src="${CTP}/js/validaterule.js"></script>
    <style type="text/css">
    	
    </style>
	</head>
	<body style="overflow: hidden;">
		<div class="container-fluid regist">
			<div class="row">
				<div class="col-md-12 header"></div>
			</div>
			<div class="row regist-content">
				<div class="form col-md-6 col-md-offset-3">
					<div class="col-md-8 col-md-offset-2">
						<h3 class="form-title">欢迎注册</h3>
						<form id="form-regist">
							<div class="col-md-12">
								<label class="">账号:</label>
								<div class="form-group input-regist">
			            <input class="form-control required regist-check" type="text" id="account" name="account" 
			            	autofocus="autofocus" placeholder="请输入账号（请使用邮箱注册）"/>
		            </div>
							</div>
							<div class="col-md-12">
								<label class="">用户名:</label>
		        		<div class="form-group input-regist">
			            <input class="form-control required regist-check" type="text" id="username" name="username" 
			            	placeholder="请输入用户名"/>
		            </div>
							</div>
	            <div class="col-md-12">
	            	<label class="">密码:</label>
		            <div class="form-group input-regist">
			            <input class="form-control required" type="password" id="password" name="password"
			            	placeholder="请输入密码"/>
		            </div>
	            </div>
	            <div class="col-md-12">
	            	<label class="">确认密码:</label>
		        		<div class="form-group input-regist">
			            <input class="form-control required" type="password" id="confirm" name="confirm" 
			            	placeholder="请再次输入密码"/>
		            </div>
	            </div>
	            <div class="col-md-12">
	            	<label class="">验证码:</label>
		          	<div class="form-group input-regist" id="code-regist">
		            	<input class="form-control required" type="text"  id="code" name="code"
		            		placeholder="验证码" maxlength="4"/>
		            </div>
		            <img src="${CTP }/authImage" class="img-responsive" id="code-regist-img" data-toggle="tooltip" title="点击刷新"/>
	            </div>
						</form>
						<div class="form-group">
	        		<button type="button" class="btn btn-success btn-regist" name="submit">登录</button>
	        	</div>
	        	<div class="form-group checkbox">
	        		<input type="checkbox" name="remember"/>我已阅读并同意《<a href="#">用户协议</a>》
	        	</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 footer"></div>
			</div>
			<div class="alert alert-warning">
	      <i></i>
	      <label></label>
	    </div>
		</div>
	</body>
</html>
<script>
	$(function(){
	  $(".header").load("header.html");
	  $(".footer").load("footer.html");
	  $("[data-toggle='tooltip']").tooltip();
	  
		$("#code-regist-img").click(function(){
      var timestamp = new Date().getTime();
      //加时间戳避免读取缓存
      $(this).attr("src",$(this).attr('src') + '?' +timestamp );
    });
		
		$("#code").blur(function(){
			var flag = $("#form-regist").data('bootstrapValidator').isValid();
			if(!flag){
				$("#code-regist-img").trigger("click");//模拟点击事件刷新验证码
			}
    });
		
		
		//点击注册事件
    $(".btn-regist").click(function(){
      var flag = $("#form-regist").data('bootstrapValidator').isValid();
      if(flag){
        var isRemember=$("input[name='remember']").is(':checked');
        if(isRemember){
        	$.ajax({
             type: "POST",
             url: "action/regist",
             data: {
            	 "accountNum":$("#account").val(),
               "username":$("#username").val(),
               "password":$("#password").val(),
             },
             success: function(data){
               if(data=="SUCCESS"){
            	   $(".alert").msgalert(true);
               }else if(data=="ERROR"){
                 $(".alert").msgalert(false);
               }
             }
          });
        }
      }
    });
	});
	
	jQuery.fn.extend({
    msgalert: function(flag) {
    	const _self = $(this);
    	if(flag){
    		_self.children("i").addClass("fa fa-check-circle-o fa-3x ok");
    		_self.children("label").text("注册成功,3秒后跳转登录页面");
    	}else{
    		_self.children("i").addClass("fa fa-times-circle-o fa-3x fail");
        _self.children("label").text("注册失败,请重试！");
    	}
      var width =$(window).width();
      width = (width-300)/2-13+"px";
      _self.css({"left":width,"top":"80px"});
      _self.fadeIn("fast",function(){
        setTimeout(function(){
        	if(flag){
        		window.location.href = "loginpage";
        	}else{
        		_self.hide("slow");
        		_self.children("i").removeClass("times-circle-o");
            _self.children("i").removeClass("fail");
        	}
        },3000)
      });
    }
  });
</script>
