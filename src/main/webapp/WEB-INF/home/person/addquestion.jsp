<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<div class="col-md-12 person">
	<div class="col-md-12 addquestion">
		<div class="person-title">
			<label>
				<span>&nbsp;</span>
				添加问题
			</label>
		</div>
		<form>
			<div class="form-group">
        <input class="form-control required" type="text" id="title" name="title" 
        	autofocus="autofocus" placeholder="输入问题"/>
      </div>
      <div id="editor">
        <p>欢迎使用 ....</p>
    	</div>
    	<div class="btn-addquestion">
    		<div class="form-group">
	    		<button type="button" class="btn btn-add" name="submit">发布问题</button>
	    	</div>
	    	<div class="form-group">
	    		<button type="button" class="btn btn-save" name="submit">保存为草稿</button>
	    	</div>
	    	<div class="form-group">
	    		<button type="button" class="btn btn-back" name="submit">返回</button>
	    	</div>
    	</div>

		</form>
	</div>
</div>

<script>
	var E = window.wangEditor;
  var editor = new E('#editor');
  editor.customConfig.uploadImgServer = '/upload';
  editor.create();
	$(function(){
		
	})
</script>
