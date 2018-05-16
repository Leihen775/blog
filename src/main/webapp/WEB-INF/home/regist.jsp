<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户注册</title>
		<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
		<link rel="stylesheet" href="${CTP}/static/bootstrap/css/bootstrap.min.css"/>
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
		
		$(".regist-check").blur(function(){
			var account = $(this).val();
			const _self = $(this).parent();
			if(!_self.hasClass("has-error")){
			  $.ajax({
	        type: "POST",
	        url: "action/isExist",
	        data: "inputinfo="+account,
	        success: function(data){
	        	_self.children("i").remove();
	          _self.children("small").remove();
	          if(data=="SUCCESS"){
	            var message = "<i class='form-control-feedback bv-no-label glyphicon glyphicon-ok'></i><small class='help-block' data-bv-result='INVALID'>用户名可用</small>"
	            _self.append(message);
	          }else if(data=="ERROR"){
	            var message = "<i class='form-control-feedback bv-no-label glyphicon glyphicon-remove'></i><small class='help-block' data-bv-result='INVALID'>用户名不可用</small>"
	            _self.removeClass("has-success");
	            _self.addClass("has-error");
	            _self.append(message);
	          }
	        }
        });
	    }
		});
		
		//点击注册事件
    $(".btn-regist").click(function(){
      $("#form-regist").bootstrapValidator('validate');
      
      var isEmpty = $("#form-regist").data('bootstrapValidator').isValid();
      if(isEmpty){
        $(".form-group").removeClass("has-success");

        var username=$("#username").val();
        var password=$("#password").val();
        var code=$("#code").val();
        var isRemember=$("input[name='remember']").is(':checked');
        if(isRemember){
        	$.ajax({
             type: "POST",
             url: "action/login",
             data: "account="+account+"&username="+username+"&password="+password+"&code="+code,
             success: function(data){
               if(data=="SUCCESS"){
                 window.location.href = "personinfopage";
               }else if(data=="ERROR"){
                 $(".alert").erroralert();
                 $("#code-img").trigger("click");//模拟点击事件刷新验证码
               }else if(data=="CODEERROR"){
                 var message = "<i style='' class='form-control-feedback bv-no-label glyphicon glyphicon-remove'></i><small style='' class='help-block' data-bv-result='INVALID'>验证码不正确</small>"
                 $("#code-login").addClass("has-error");
                 if($("#code-login").hasClass("has-error")){
                    $("#code-img").css("margin-bottom","60px")
                 }
                 $("#code-login").append(message);
                 $("#code-img").trigger("click");//模拟点击事件刷新验证码
               }
             }
          });
        }
      }
    });
	});
</script>
