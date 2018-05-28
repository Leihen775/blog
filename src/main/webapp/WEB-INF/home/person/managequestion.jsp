<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<div class="col-md-12 person">
	<div class="col-md-12 managequestion">
		<div class="person-title">
			<label>
				<span>&nbsp;</span>
				问题管理
			</label>
		</div>
		<div class="nav-tabs">
			<ul>
				<li><a class="active all">全部</a></li>
				<li><a class="solve">已解决</a></li>
				<li><a class="unsolved">待回答</a></li>
				<li><a class="garbage"><i class="fa fa-trash-o fa-fw"></i>回收站</a></li>
			</ul>
		</div>
		<div class="list-question">
			<ul class="list-group">
			</ul>
		</div>
	</div>
</div>

<script>
	$(function(){
		$("[data-toggle='tooltip']").tooltip();
		
		$(".all").click(function(){
      $(".active").removeClass("active");
      $(this).addClass("active");
      $.ajax({
        type:"POST",
        url:"../findQuestionList",
        data:{"pageNum":1,"state":0},
        success:function(data){
          $(".page").remove();
          $(".list-question").append("<div class='page' id='page-allQues'></div>");
          showInfo(data);
        }
      });
    });
    $(".list-question").delegate('#page-allarticle a','click',function(){
      var page = $(this).attr("href").split("#")[1];
      $.ajax({
        type:"POST",
        url:"../findQuestionList",
        data:{"pageNum":page,"state":0},
        success:function(data){
          showInfo(data);
        }
      });
    });
    
    $(".solve").click(function(){
      $(".active").removeClass("active");
      $(this).addClass("active");
      $.ajax({
        type:"POST",
        url:"../findQuestionList",
        data:{"pageNum":1,"state":1},
        success:function(data){
          $(".page").remove();
          $(".list-question").append("<div class='page' id='page-solveQues'></div>");
          showInfo(data);
        }
      });
    });
    $(".list-question").delegate('#page-solveQues a','click',function(){
      var page = $(this).attr("href").split("#")[1];
      $.ajax({
        type:"POST",
        url:"../findQuestionList",
        data:{"pageNum":page,"state":1},
        success:function(data){
          showInfo(data);
        }
      });
    });
    
    $(".unsolved").click(function(){
      $(".active").removeClass("active");
      $(this).addClass("active");
      $.ajax({
        type:"POST",
        url:"../findQuestionList",
        data:{"pageNum":1,"state":2},
        success:function(data){
          $(".page").remove();
          $(".list-question").append("<div class='page' id='page-unsolvedQues'></div>");
          showInfo(data);
        }
      });
    });
    $(".list-question").delegate('#page-draftarticle a','click',function(){
      var page = $(this).attr("href").split("#")[1];
      $.ajax({
        type:"POST",
        url:"../findQuestionList",
        data:{"pageNum":page,"state":2},
        success:function(data){
          showInfo(data);
        }
      });
    });
    
    $(".garbage").click(function(){
      $(".active").removeClass("active");
      $(this).addClass("active");
      $.ajax({
        type:"POST",
        url:"../findQuestionList",
        data:{"pageNum":1,"state":3},
        success:function(data){
          $(".page").remove();
          $(".list-question").append("<div class='page' id='page-garbageQues'></div>");
          showInfo(data);
        }
      });
    });
    $(".list-question").delegate('#page-garbageQues a','click',function(){
      var page = $(this).attr("href").split("#")[1];
      $.ajax({
        type:"POST",
        url:"../findQuestionList",
        data:{"pageNum":page,"state":3},
        success:function(data){
          showInfo(data);
        }
      });
    });
    
    $(".all").trigger("click");
    
    $(".list-question").delegate('.delete','click',function(){//删除文章进回收站
      var state = $(this).attr("data");
      const _self = $(this).parent().siblings(".list-question-title");
      var id = _self.children("a").attr("href").split("#")[1];
      if(state==2){
        $.confirm({
          title: '警告!',
          content: '是否彻底删除该问题!',
          confirm: function(){
            $.ajax({
              type:"POST",
              url:"../deleteQuestion",
              data:{"id":id},
              success:function(data){
                if(data=="SUCCESS"){
                  _self.parent().remove();
                  message("check","问题删除成功!");
                }else if(data=="ERROR"){
                  message("times","问题删除失败!");
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
      }else{
        $.confirm({
          title: '警告!',
          content: '是否删除该问题!',
          confirm: function(){
            $.ajax({
              type:"POST",
              url:"../trashQuestion",
              data:{"id":id},
              success:function(data){
                if(data=="SUCCESS"){
                  _self.parent().remove();
                  message("check","问题删除成功!");
                }else if(data=="ERROR"){
                  message("times","问题删除失败!");
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
      }
      
    });
		
	});
	
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
      html=html+"<li class='list-group-item'><div class='list-question-title'>"+
      "<a href='#"+e.id+"'>"+e.title+"</a></div><div class='list-question-info'>"+
      "<div class='info-left'><span>"+e.publishTime+"</span>"+
      "<span data-toggle='tooltip' title='浏览数'><i class='fa fa-eye'></i>"+e.clickCount+"</span>"+
      "<span data-toggle='tooltip' title='评论数'><i class='fa fa-commenting fa-fw'></i>"+e.answerCount+"</span>"+
      "</div><span class='delete' data='"+e.state+"'><a>删除</a></span><span class='show'><a>查看</a></span></div></li>";
    });
    $(".list-question ul").append(html);
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

