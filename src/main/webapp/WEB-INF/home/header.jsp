<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<div class="col-md-10 col-md-offset-1">
	<div class="col-md-2">
		<h4 class="logo">我的博客</h4>
	</div>
	<div class="col-md-6">
		<ul class="nav navbar-nav content-nav">
			<li>
				<a href="#home/homepage">博客学院</a>
			</li>
			<li>
				<a href="#home/questionlistpage">有问必答</a>
			</li>
		</ul>
	</div>
	<div class="col-md-4">
		<ul class="nav edit-nav col-md-12">
			<li class="col-md-4">
				<a href="#personinfopage?index=2" class="showpage"><span><img src="${CTP}/static/image/icon/编辑.png"/></span>&nbsp;写博客</a>
			</li>
			<li class="col-md-4">
				<a href="#personinfopage?index=5" class="showpage"><span><img src="${CTP}/static/image/icon/信息.png"/></span>&nbsp;提问题</a>
			</li>
			<c:if test="${empty sessionScope.user }">
			  <li class="col-md-2 not-logged">
	        <a href="${CTP}/loginpage">登录</a>
	      </li>
	      <li class="col-md-2 not-logged">
	        <a href="${CTP}/registpage">注册</a>
	      </li>
      </c:if>
      <c:if test="${not empty sessionScope.user }">
        <li class="dropdown col-md-4 user">
	        <a href="#personinfopage?index=0" class="dropdown-toggle">
	            ${sessionScope.user.nickname }&nbsp;
	        </a>
	        <ul class="dropdown-menu">
	            <li><a href="#personinfopage?index=3" class="showpage">我的博客</a></li>
	            <li class="divider"></li>
	            <li><a href="#personinfopage?index=7" class="showpage">账号设置</a></li>
	            <li class="divider"></li>
	            <li><a href="#personinfopage?index=1" class="showpage">消息</a></li>
	            <li class="divider"></li>
	            <li><a id="logout">退出</a></li>
	        </ul>
	      </li>
      </c:if>
      <li class="user_info" value="${sessionScope.user }" hidden="true"></li>
		</ul>
	</div>
</div>
<script>
	$(function(){
		
		if($(".user_info").attr("value")!=null&&$(".user_info").attr("value")!=""){
			$.ajax({
	      type: "POST",
	      url: "../findcount",
	      success: function(data){
	        if(data!=0){
	          var html = "<span class='badge'>"+data+"</span>"
	          $(".user>a").append(html);
	        }
	      }
	    });
		}
		
		
		$(".dropdown").mouseover(function(){
			$(this).addClass('open');
		});
		$(".dropdown").mouseout(function(){
			$(this).removeClass('open');
		});
		
		
		$(".showpage").click(function(){
			var url = "http://localhost:8080/blog/person/"+$(this).attr("href").split("#")[1];
			window.location.href = url;
		})
		
		$(".content-nav a").click(function(){
      var url = "http://localhost:8080/blog/"+$(this).attr("href").split("#")[1];
      window.location.href = url;
		});
		
		$("#logout").click(function(){
			$.ajax({
         type: "POST",
         url: "../action/logout",
         success: function(data){
           if(data=="SUCCESS"){
             window.location.href = "http://localhost:8080/blog/loginpage";
           }else if(data=="ERROR"){
             alert("账号或密码错误")
           }
         }
      });
		});
		
	});
</script>

