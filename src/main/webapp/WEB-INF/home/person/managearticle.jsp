<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<div class="col-md-12 person">
	<div class="col-md-12 managearticle">
		<div class="person-title">
			<label>
				<span>&nbsp;</span>
				文章管理
			</label>
		</div>
		<div class="nav-tabs">
			<ul>
				<li><a href="#" class="active">全部</a></li>
				<li><a href="#">已发表</a></li>
				<li><a href="#">草稿箱</a></li>
				<li><a href="#"><i class="fa fa-trash-o fa-fw"></i>回收站</a></li>
			</ul>
		</div>
		<div class="list-article">
			<ul class="list-group">
				<li class="list-group-item">
					<div class="list-article-title">
						<label>私密</label>
						<a href="#">五一出游，好好学习听你</a>
					</div>
					<div class="list-article-info">
						<div class="info-left">
							<span>原创</span>
							<span>2018年05月11日 13:43:44</span>
							<span data-toggle="tooltip" title="浏览数"><i class="fa fa-eye"></i>1</span>
							<span data-toggle="tooltip" title="评论数"><i class="fa fa-commenting fa-fw"></i>0</span>
						</div>
						<span class="delete"><a>删除</a></span>
						<span class="show"><a>查看</a></span>
					</div>
				</li>
			</ul> 
		</div>
	</div>
</div>

<script>
	$(function(){
		
		$("[data-toggle='tooltip']").tooltip();
		
	});
</script>
