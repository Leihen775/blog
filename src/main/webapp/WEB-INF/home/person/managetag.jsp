<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<div class="col-md-12 person">
	<div class="col-md-12 managetag">
		<div class="person-title col-md-9">
			<label>
				<span>&nbsp;</span>
				个人标签管理
			</label>
		</div>
		<form>
			<div class="input-group">
        <input type="text" class="form-control" name="title"/>
        <span class="input-group-btn">
					<button class="btn btn-default" type="button">添加分类</button>
				</span>
      </div>
		</form>
		<div class="list-tag">
			<dl class="col-md-12">
		    <dd class="col-md-4">标签</dd>
		    <dd class="col-md-4">文章数</dd>
		    <dd class="col-md-4">操作</dd>
			</dl>
			<ul class="list-group">
				<li class="list-group-item col-md-12">
					<label class="col-md-4">JAVA</label>
					<label class="col-md-4">0</label>
					<div class="col-md-4">
						<span>
							<a>修改</a>
							<a>删除</a>
						</span>
					</div>
				</li>
				<li class="list-group-item col-md-12">
					<label class="col-md-4">JAVA</label>
					<label class="col-md-4">0</label>
					<div class="col-md-4">
						<span>
							<a>修改</a>
							<a>删除</a>
						</span>
					</div>
				</li>
				<li class="list-group-item col-md-12">
					<label class="col-md-4">JAVA</label>
					<label class="col-md-4">0</label>
					<div class="col-md-4">
						<span>
							<a>修改</a>
							<a>删除</a>
						</span>
					</div>
				</li>
			</ul> 
		</div>
	</div>
</div>

<script>
	
</script>
