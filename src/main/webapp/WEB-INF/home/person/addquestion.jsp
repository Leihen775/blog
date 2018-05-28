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
		$(".btn-add").click(function(){
			addQuestion();
		});
		
		$(".btn-back").click(function(){
			$.confirm({
	      title: '警告!',
	      content: '是否返回!',
	      confirm: function(){
	    	  $("a[index='5']").trigger("click");
	      },
	      cancel: function(){},
	      confirmButton: '确认',
	      cancelButton: '取消',
	      confirmButtonClass: 'btn-info',
	      cancelButtonClass: 'btn-danger',
	    });
		});
	})
	
	function addQuestion(){
    $.ajax({//上传问题
      traditional: true,
      type: "POST",
      url: "../addQuestion",
      data:{
        "title":$("#title").val(),
        "content":editor.txt.html(),
        "state":0
      },
      success:function(data){
        if(data=="SUCCESS"){
          message("check","问题发布成功!");
        }else if(data=="ERROR"){
          message("times","问题发布失败!");
        }
      }
    });
  }
	
	function message(c,m){
    $.alert({
      title: "&nbsp;",
      content: "<i class='fa fa-"+c+"-circle-o fa-2x'></i><label>"+m+"</label>",
      confirmButton: "确认"
    });
  }
	
</script>
