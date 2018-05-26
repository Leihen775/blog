<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>用户登录</title>
    <meta charset="utf-8">
    <c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
    <link type="text/css" rel="stylesheet" href="${CTP}/static/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${CTP}/static/font-awesome/css/font-awesome.css" />
    <link rel="stylesheet" href="${CTP}/css/blog-home.css"/>
    <script type="text/javascript" src="${CTP}/static/jquery/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="${CTP}/static/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${CTP}/static/bootstrap/bootstrapValidator/js/bootstrapValidator.js"></script>
    <script type="text/javascript" src="${CTP}/js/validaterule.js"></script> 
    <style type="text/css">
      body{
        background: url(${pageContext.request.contextPath}/static/image/background/bg01.jpg);
        background-size: 100% 720px;
      }
    </style>
  </head>
  <body>
    <div class="container login">
      <div class="form row">
        <div class="col-md-8 col-md-offset-2">
          <h3 class="form-title">LOGIN</h3>
          <form id="form-login">
            <div class="form-group">
              <span class="icon glyphicon glyphicon-user"></span>
              <div class="form-group input-login">
                <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="16"/>
              </div>
            </div>
            <div class="form-group">
              <span class="icon glyphicon glyphicon-lock"></span>
              <div class="form-group input-login">
                <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="12"/>
              </div>
            </div>
            <div class="form-group">
              <div class="form-group input-login" id="code-login">
                <input class="form-control required" type="text" placeholder="验证码" id="code" name="code" autofocus="autofocus" maxlength="4"/>
              </div>
              <img src="${CTP}/authImage"  class="img-responsive" id="code-img" />
            </div>
            <div>
              <label class="checkbox">
                <input type="checkbox" name="remember"/>记住我 
              </label>
            </div>
          </form>
          <div class="form-group">
            <button type="button" class="btn btn-success btn-login" name="submit">登录</button>
          </div>
        </div>
      </div>
     </div>
     <div class="alert alert-warning" style="position:absolute;">
			  <i class="fa fa-times-circle fa-1x" style="color: #C92027;"></i>
			  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账号或密码不正确。
		 </div>
  </body>
</html>
<script type="text/javascript">
  $(function(){
	  
	  //点击刷新验证码事件
	  $("#code-img").click(function(){
		  var timestamp = new Date().getTime();
		  //加时间戳避免读取缓存
		  $(this).attr("src",$(this).attr('src') + '?' +timestamp );
	  });
	  
	  $(".alert").hide();
	  
	  //点击登录事件
	  $(".btn-login").click(function(){
		  $("#form-login").bootstrapValidator('validate');
		  if($("#code-login").hasClass("has-error")){
			  $("#code-img").css("margin-bottom","60px")
		  }
		  $(".has-success i").remove();
		  $(".has-success small").remove();//不显示校验成功样式
		  var flag = $("#form-login").data('bootstrapValidator').isValid();
		  if(flag){
			  $(".form-group").removeClass("has-success");
	      var isRemember=$("input[name='remember']").is(':checked');
	      $.ajax({
	         type: "POST",
	         url: "login",
	         data: {
             "username":$("#username").val(),
             "password":$("#password").val(),
             "code":$("#code").val(),
             "isRemember":isRemember,
           },
	         success: function(data){
	        	 if(data=="SUCCESS"){
	        		 window.location.href = "person/personinfopage";
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
	  });
	  
	  $("#code").blur(function(){
		  $("#code-img").css("margin-bottom","0");
		  $("#code-login i").remove();
      $("#code-login small").remove();
	  });
  });
  
  jQuery.fn.extend({
	  erroralert: function() {
		  var width =$(window).width();
	    width = (width-200)/2-33+"px";
	    $(this).css({"width":"265px","left":width,"top":"120px"});
	    const _self = $(this);
	    $(this).fadeIn("slow",function(){
	    	setTimeout(function(){
    	    _self.hide();
    	  },2000)
   	  });
	  }
	});
  

</script>
