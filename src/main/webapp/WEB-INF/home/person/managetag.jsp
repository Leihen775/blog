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
        <input type="text" class="form-control" name="title" id="tag"/>
        <span class="input-group-btn">
					<button class="btn btn-default btn-addtag" type="button">添加分类</button>
				</span>
      </div>
		</form>
		<div class="list-tag">
			<dl class="col-md-12">
		    <dd class="col-md-4">标签</dd>
		    <dd class="col-md-4">文章数</dd>
		    <dd class="col-md-4">操作</dd>
			</dl>
			<ul class="list-group col-md-12"></ul>
			<div class="page" id="page-tag" style="margin-top: 20px"></div>
		</div>
	</div>
</div>

<script>
	$(function(){
		
		$.ajax({
			type:"POST",
			url:"../findTagByUser",
			data:{"pageNum":1},
			success:function(data){
				showInfo(data);
			}
		});
		$("#page-tag").delegate('a','click',function(){
      var page = $(this).attr("href").split("#")[1];
      $.ajax({//查询个人文章
        type:"POST",
        url:"../findTagByUser",
        data:{"pageNum":page},
        success:function(data){
          showInfo(data);
        }
      });
    });
		
		$(".btn-addtag").click(function(){
      $.ajax({//查询个人文章
        type:"POST",
        url:"../addTag",
        data:{"tag":$("#tag").val()},
        success:function(data){
          if(data=="SUCCESS"){
            $.alert({
              title: '&nbsp;',
              content: '<i class="fa fa-check-circle-o fa-2x"></i><label>标签添加成功!</label>',
              confirmButton: '确认'
            });
          }else if(data=="ERROR"){
            $.alert({
              title: '&nbsp;',
              content: '<i class="fa fa-times-circle-o fa-2x"></i><label>标签添加失败!</label>',
              confirmButton: '确认'
            });
          }
        }
      });
    });
		
		$(".list-tag").delegate('.tag-delete','click',function(){
			const _self = $(this);
		  var id = _self.attr("val");
			$.confirm({
        title: '警告!',
        content: '是否删除该标签!',
        confirm: function(){
          $.ajax({
            type:"POST",
            url:"../deleteTag",
            data:{"id":id},
            success:function(data){
              if(data=="SUCCESS"){
                _self.parent().parent().parent().remove();
                $.alert({
                  title: '&nbsp;',
                  content: '<i class="fa fa-check-circle-o fa-2x"></i><label>标签删除成功!</label>',
                  confirmButton: '确认'
                });
              }else if(data=="ERROR"){
                $.alert({
                  title: '&nbsp;',
                  content: '<i class="fa fa-times-circle-o fa-2x"></i><label>标签删除失败!</label>',
                  confirmButton: '确认'
                });
              }
            }
          });
        },
        cancel: function(){
        },
        confirmButton: '确认',
        cancelButton: '取消',
        confirmButtonClass: 'btn-info',
        cancelButtonClass: 'btn-danger',
      })
		});
		
	})
	
	function showpage(data){
    var pages = data.pages;
    var pageNum = data.pageNum;
    if(pages==2){
      if(pageNum==1){
        var html="<ul class='pagination'>"+
        "<li><a href='#1'>1</a></li>"+
        "<li><a href='#2'>2</a></li>"+
        "<li><a href='#2'>下一页</a></li><li><a href='#2'>尾页</a></li></ul>";
      }else if(pageNum==pages){
        var html="<ul class='pagination'>"+
      "<li><a href='#1'>首页</a></li>"+
      "<li><a href='#1'>上一页</a></li>"+
      "<li><a href='#1'>1</a></li>"+
      "<li><a href='#2'>2</a></li></ul>";
      }
    }else if(pages>2){
      if(pageNum==1){
        var html = "<ul class='pagination'>";
        for(var i=1;i<=3;i++){
          html=html+"<li><a href='#"+i+"'>"+i+"</a></li>";
          if(i==3){
            html = html +"<li><a href='#"+(pageNum+1)+"'>下一页</a></li><li><a href='#"+pages+"'>尾页</a></li></ul>";
          }
        }
      }else if(pageNum==pages){
        var html="<ul class='pagination'>"+
             "<li><a href='#1'>首页</a></li>"+
             "<li><a href='#"+(pageNum-1)+"'>上一页</a></li>";
        for(var i=pages-2;i<=pages;i++){
          html=html+"<li><a href='#"+i+"'>"+i+"</a></li>";
          if(i==pages){
            html = html +"</ul>";
          }
        }
      }else{
        var html="<ul class='pagination'>"+
        "<li><a href='#1'>首页</a></li>"+
        "<li><a href='#"+(pageNum-1)+"'>上一页</a></li>"+
        "<li><a href='#"+(pageNum-1)+"'>"+(pageNum-1)+"</a></li>"+
        "<li><a href='#"+pageNum+"'>"+pageNum+"</a></li>"+
        "<li><a href='#"+(pageNum+1)+"'>"+(pageNum+1)+"</a></li>"+
        "<li><a href='#"+(pageNum+1)+"'>下一页</a></li>"+
        "<li><a href='#"+pages+"'>尾页</a></li></ul>";
      }
    }
    $(".pagination").remove();
    $(".page").append(html);
  }
	
	function showInfo(data){
	    $(".list-group-item").remove();
	    var array = data.list;
	    var html = "";
	    $.each(array,function(i,e){
	      html=html+"<li class='list-group-item col-md-12'>"+
	      "<label class='col-md-4'>"+e.tag+"</label>"+
	      "<label class='col-md-4'>"+e.articleCount+"</label>"+
	      "<div class='col-md-4'><span><a class='tag-update' val='"+e.id+"'>修改</a>&nbsp;"+
	      "<a class='tag-delete' val='"+e.id+"'>删除</a></span></div></li>";
	      
	    });
	    $(".list-tag .list-group").append(html);
	    showpage(data);
	  }
</script>
