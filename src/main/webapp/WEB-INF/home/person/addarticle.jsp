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
    		<div class="tag"></div>
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
		    <select class="form-control" >
		    </select>
    	</div>
    	<div class="form-group">
    		<label class="col-md-1">私密文章：</label>
    		<div class="col-md-11 is_private">
    			<label class="radio-inline">
	        	<input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="0" checked> 公开
			    </label>
			    <label class="radio-inline">
		        <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="1"> 私密
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
  editor.customConfig.uploadFileName = 'img'
  editor.customConfig.uploadImgServer = "../uploads/uploadarticlepic";
  editor.customConfig.uploadImgHooks = {
		customInsert: function (insertImg, result, editor) {
      // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
      // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
      //var url =result.data;
      insertImg(result);
      // result 必须是一个 JSON 格式字符串！！！否则报错
    }
  }
  editor.create();
  
	$(function(){
		
		$.ajax({//查找分类
			type:"POST",
			url:"../findAllCategory",
			success:function(data){
				var html = "<option>请选择</option>";
				$.each(data,function(i,e){
	        html=html+"<option value='"+e.id+"'>"+e.name+"</option>"
	      });
				$(".category select").append(html);
			}
		});
		
		$.ajax({//个人标签
      type:"POST",
      url:"../findAllTagByUser",
      success:function(data){
        var html = "";
        $.each(data,function(i,e){
          html=html+"<div class='checkbox'><label><input type='checkbox' class='check' value='"+e.id+"'>"+e.tag+"</label></div>"
        });
        $(".tag").append(html);
      }
    });
		
		$(".btn-add").click(function(){
			var state = 1;
			var code = addArticle(state);
		});
		
		$(".btn-save").click(function(){
      var state = 0;
      var code = addArticle(state);
    });
		
	})
	
	function addArticle(state){
		let result = '';
		var tagList = new Array();
    var i = 0;
    $(".check").each(function(){
      if(this.checked==true){
        tagList[i] = $(this).val();
        i++;
      }
    });
    $.ajax({//上传文章
    	traditional: true,
      type: "POST",
      url: "../addArticle",
      data:{
        "type":$(".article-type select option:selected").val(),
        "title":$("#title").val(),
        "content":editor.txt.html(),
        "categoryId":$(".category select option:selected").val(),
        "state":state,
        "is_private":$(".is_private input:radio:checked").val(),
        "tag":tagList,
      },
      success:function(data){
    	  var message = null;
    		if(data=="SUCCESS"){
    			if(state==1){
    				$.alert({
              theme: 'black',
              title: '&nbsp;',
              content: '<i class="fa fa-check-circle-o fa-2x"></i><label>文章保存成功!</label>',
              confirmButton: '确认'
            });
    			}else{
    				$.alert({
              theme: 'black',
              title: '&nbsp;',
              content: '<i class="fa fa-check-circle-o fa-2x"></i><label>文章保存成功!</label>',
              confirmButton: '确认'
            });
    			}
 		    }else if(data=="ERROR"){
 		    	if(state==1){
 		    		$.alert({
    	        theme: 'black',
    	        title: '&nbsp;',
    	        content: '<i class="fa fa-times-circle-o fa-2x"></i><label>文章发布失败!</label>',
    	        confirmButton: '确认'
    	      });
          }else{
        	  $.alert({
     	        theme: 'black',
     	        title: '&nbsp;',
     	        content: '<i class="fa fa-times-circle-o fa-2x"></i><label>文章保存失败!</label>',
     	        confirmButton: '确认'
     	      });
          }
 		    }
      }
    });
	}
	
</script>

