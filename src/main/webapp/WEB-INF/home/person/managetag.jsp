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
		<form class="add-tag">
			<div class="input-group">
        <input type="text" class="form-control" name="tag" id="tag"/>
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
		<!-- 模态框（Modal） -->
	  <div class="modal fade" id="tagModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
	          </button>
	          <h4 class="modal-title" id="myModalLabel">编辑标签</h4>
	        </div>
	        <div class="modal-body">
	          <form class="form-horizontal" role="form">
	            <div class="form-group">
	              <label for="user_id" class="col-md-2 control-label" style="padding-right:20px">标签:</label>
	              <div class="col-md-9">
	                <input type="text" id="tag_id" name="tag_id" style="display:none"/>
	                <input class="form-control required" type="text" id="tag" name="tag"/>
	              </div>
	            </div>
	          </form>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	          <button type="button" class="btn btn-primary btn-updatetag">  提交更改 </button>
	        </div>
	      </div><!-- /.modal-content -->
	    </div><!-- /.modal-dialog -->
	  </div><!-- /.modal -->
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
        data:{"tag":$(".add-tag #tag").val()},
        success:function(data){
          if(data=="SUCCESS"){
        	  message("check","标签添加成功!");
          }else if(data=="ERROR"){
        	  message("times","标签添加失败!");
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
                message("check","标签删除成功!");
              }else if(data=="ERROR"){
            	  message("times","标签删除失败!");
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
		
		//显示修改信息
		$(".list-tag").delegate('.tag-update','click',function(){
			var id = $(this).attr("val");
      var info = $(this).parent().parent().siblings("label[name='tag']").text();
      $("#tagModal #tag_id").val(id);
      $("#tagModal #tag").val(info);
      $('#tagModal').modal('show');
    });
		//提交修改
		$(".btn-updatetag").click(function(){
			$.ajax({
				type:"POST",
				url:"../updateTag",
				data:{"id":$("#tagModal #tag_id").val(),"tag":$("#tagModal #tag").val()},
				success:function(data){
					$(".modal-footer .btn-default").trigger("click");
			    if(data=="SUCCESS"){
			    	message("check","标签修改成功!");
          }else if(data=="ERROR"){
        	  message("times","标签修改失败!");
          }
				}
			});
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
      "<label class='col-md-4' name='tag'>"+e.tag+"</label>"+
      "<label class='col-md-4' name='count'>"+e.articleCount+"</label>"+
      "<div class='col-md-4'><span><a class='tag-update' val='"+e.id+"'>修改</a>&nbsp;"+
      "<a class='tag-delete' val='"+e.id+"'>删除</a></span></div></li>";
      
    });
    $(".list-tag .list-group").append(html);
    showpage(data);
	}
	
	function message(c,m){
		$.alert({
      title: "&nbsp;",
      content: "<i class='fa fa-"+c+"-circle-o fa-2x'></i><label>"+m+"</label>",
      confirmButton: "确认"
    });
	}

</script>
