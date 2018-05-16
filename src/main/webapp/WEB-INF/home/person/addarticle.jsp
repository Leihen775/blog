<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<div class="col-md-12 person">
	<div class="col-md-12 addarticle">
		<div class="person-title">
			<label>
				<span>&nbsp;</span>
				添加文章
			</label>
		</div>
		<form>
			<div class="form-group">
        <input class="form-control required" type="text" id="title" name="title" 
        	autofocus="autofocus" placeholder="输入文章标题"/>
      </div>
      <div id="editor">
        <p>欢迎使用 ....</p>
    	</div>
    	<div class="personal-tag">
    		<label class="col-md-1">个人标签：</label>
    		<div class="">
    			<div class="checkbox">
						<label><input type="checkbox">java</label>
					</div>
					<div class="checkbox">
						<label><input type="checkbox">java</label>
					</div>
					<div class="checkbox">
						<label><input type="checkbox">java</label>
					</div>
					<div class="checkbox">
						<label><input type="checkbox">java</label>
					</div>

    		</div>
    	</div>
    	<div class="form-group article-type">
    		<label for="name">文章类型：</label>
		    <select class="form-control">
		    	<option>请选择</option>
		      <option value="0">原创</option>
		      <option value="1">转载</option>
		      <option value="2">翻译</option>
		    </select>
    	</div>
    	<div class="form-group category">
    		<label for="name">博客分类：</label>
		    <select class="form-control">
		    	<option>请选择</option>
		      <option value="0">原创</option>
		      <option value="1">转载</option>
		      <option value="2">翻译</option>
		    </select>
    	</div>
    	<div class="form-group">
    		<label class="col-md-1">私密文章：</label>
    		<div class="col-md-11">
    			<label class="radio-inline">
	        	<input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1" checked> 公开
			    </label>
			    <label class="radio-inline">
		        <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="option2"> 私密
			    </label>
    		</div>
    	</div>
    	<div class="btn-addarticle">
    		<div class="form-group">
	    		<button type="button" class="btn btn-add" name="submit">发布博客</button>
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
