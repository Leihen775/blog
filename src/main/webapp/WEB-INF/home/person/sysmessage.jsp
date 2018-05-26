<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<div class="col-md-12 person">
	<div class="col-md-12 sysmessage">
		<div class="person-title">
			<label><span>&nbsp;</span>系统通知</label>
		</div>
		<div class="sysmessage-edit">
			<dl>
				<dd>
					未读通知：<label>0</label><span>|</span><a class="edit_message">全部标为已读</a><span>|</span>
					<a class="delete_message">清空所有通知</a>
				</dd>
			</dl>
		</div>
		<div class="sysmessage-show">
			<ul class="list-group list-message"></ul>
			<div class="page" id="page-message"></div>
		</div>
		<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
						</button>
						<h4 class="modal-title" id="myModalLabel">
							查看通知
						</h4>
					</div>
					<div class="modal-body">
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							关闭
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	</div>
	
	
</div>

<script>
	$(function(){
		//查看消息
		$(".list-message").delegate('a','click',function(){
			var content = $(this).html();
			const _ref = $(this);
			var id =_ref.attr("href").split("#")[1];
			$("#messageModal .modal-body").html(content);
    	$('#messageModal').modal('show');
    	$.ajax({
    		type:"POST",
    		url:"../updateMessageRead",
    		data:{"id":id},
    		success:function(data){
    			_ref.parent().children(".fa").remove();
    		}
    	});
    });
		
		$.ajax({//查询系统消息
      type:"POST",
      url:"../findMessageList",
      data:{"pageNum":1},
      success:function(data){
        var array = data.list;
        $.each(array,function(i,e){
          var html="<li class='list-group-item'><div>"+
          "<a href='#"+e.id+"'>"+e.message.content+"</a>";
          var html2="<p>"+e.message.publishTime+"&nbsp;&nbsp;<i class='glyphicon glyphicon-trash delete'></i></p>"+
          "</div></li>";
          if(e.state==0){
        	  html=html+"&nbsp;&nbsp;<i class='fa fa-circle fa-1x' style='color:red;'></i>"+html2;
          }else{
        	  html=html+html2;
          }
          $(".list-message").append(html);
          showpage(data);
        });
      }
    });
		
		$("#page-message").delegate('a','click',function(){
      var page = $(this).attr("href").split("#")[1];
      $.ajax({//查询系统消息
          type:"POST",
          url:"../findMessageList",
          data:{"pageNum":page},
          success:function(data){
            var array = data.list;
            $(".list-group-item").remove();
            $.each(array,function(i,e){
            	var html="<li class='list-group-item'><div>"+
              "<a href='#"+e.id+"'>"+e.message.content+"</a>";
              var html2="<p>"+e.message.publishTime+"&nbsp;&nbsp;<i class='glyphicon glyphicon-trash delete'></i></p>"+
              "</div></li>";
              if(e.state==0){
                html=html+"&nbsp;&nbsp;<i class='fa fa-circle fa-1x' style='color:red;'></i>"+html2;
              }else{
                html=html+html2;
              }
              $(".list-message").append(html);
              showpage(data);
            });
          }
        });
    });
		
		$(".edit_message").click(function(){
			$.ajax({
        type:"POST",
        url:"../updateAllMessageRead",
        success:function(data){
          $(".list-message .fa").remove();
        }
      });
		});
		
		$(".list-message").delegate(".delete",'click',function(){
			const _ref =$(this).parent().parent();
			var id = _ref.children("a").attr("href").split("#")[1];
      $.ajax({
        type:"POST",
        url:"../deleteMessage",
        data:{"id":id},
        success:function(data){
          _ref.parent().remove();
        }
      });
    });
		
		$(".delete_message").click(function(){
      $.ajax({
        type:"POST",
        url:"../deleteAllMessage",
        success:function(data){
        	$(".list-group-item").remove();
        	$(".pagination").remove();
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
		      html= html+"<li><a href='#"+i+"'>"+i+"</a></li>";
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

</script>
