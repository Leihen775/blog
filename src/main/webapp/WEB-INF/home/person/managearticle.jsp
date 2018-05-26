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
				<li><a class="all active">全部</a></li>
				<li><a class="publish">已发表</a></li>
				<li><a class="draft">草稿箱</a></li>
				<li><a class="garbage"><i class="fa fa-trash-o fa-fw"></i>回收站</a></li>
			</ul>
		</div>
		<div class="list-article">
			<ul class="list-group"></ul>
		</div>
	</div>
</div>

<script>
	$(function(){
		$("[data-toggle='tooltip']").tooltip();
		
		$(".all").click(function(){
			$(".active").removeClass("active");
			$(this).addClass("active");
			$.ajax({//查询个人文章
	      type:"POST",
	      url:"../findArticleList",
	      data:{"pageNum":1,"state":0},
	      success:function(data){
	        $(".page").remove();
	        $(".list-article").append("<div class='page' id='page-allarticle'></div>");
	        showInfo(data);
	      }
	    });
		});
    $(".list-article").delegate('#page-allarticle a','click',function(){
      var page = $(this).attr("href").split("#")[1];
      $.ajax({//查询个人文章
        type:"POST",
        url:"../findArticleList",
        data:{"pageNum":page,"state":0},
        success:function(data){
        	showInfo(data);
        }
      });
    });
    
    $(".publish").click(function(){
    	$(".active").removeClass("active");
      $(this).addClass("active");
      $.ajax({//查询个人文章
        type:"POST",
        url:"../findArticleList",
        data:{"pageNum":1,"state":1},
        success:function(data){
          $(".page").remove();
          $(".list-article").append("<div class='page' id='page-publisharticle'></div>");
          showInfo(data);
        }
      });
    });
    $(".list-article").delegate('#page-publisharticle a','click',function(){
      var page = $(this).attr("href").split("#")[1];
      $.ajax({//查询个人文章
        type:"POST",
        url:"../findArticleList",
        data:{"pageNum":page,"state":1},
        success:function(data){
          showInfo(data);
        }
      });
    });
      
    $(".draft").click(function(){
    	$(".active").removeClass("active");
      $(this).addClass("active");
      $.ajax({//查询个人文章
        type:"POST",
        url:"../findArticleList",
        data:{"pageNum":1,"state":2},
        success:function(data){
          $(".page").remove();
          $(".list-article").append("<div class='page' id='page-draftarticle'></div>");
          showInfo(data);
        }
      });
    });
    $(".list-article").delegate('#page-draftarticle a','click',function(){
      var page = $(this).attr("href").split("#")[1];
      $.ajax({//查询个人文章
        type:"POST",
        url:"../findArticleList",
        data:{"pageNum":page,"state":2},
        success:function(data){
          showInfo(data);
        }
      });
    });
    
    $(".garbage").click(function(){
      $(".active").removeClass("active");
      $(this).addClass("active");
      $.ajax({//查询个人文章
        type:"POST",
        url:"../findArticleList",
        data:{"pageNum":1,"state":3},
        success:function(data){
          $(".page").remove();
          $(".list-article").append("<div class='page' id='page-garbagearticle'></div>");
          showInfo(data);
        }
      });
    });
    $(".list-article").delegate('#page-garbagearticle a','click',function(){
      var page = $(this).attr("href").split("#")[1];
      $.ajax({//查询个人文章
        type:"POST",
        url:"../findArticleList",
        data:{"pageNum":page,"state":3},
        success:function(data){
          showInfo(data);
        }
      });
    });
    
    $(".all").trigger("click");
    
    $(".list-article").delegate('.delete','click',function(){
    	const _self = $(this).parent().siblings(".list-article-title");
    	var id = _self.children("a").attr("href").split("#")[1];
    	$.confirm({
		   	title: '警告!',
		    content: '是否删除该篇文章!',
		    confirm: function(){
		    	$.ajax({
		    		type:"POST",
		    		url:"../deleteArticle",
		    		data:{"id":id},
		    		success:function(data){
		    			if(data=="SUCCESS"){
		    				_self.parent().remove();
		    				$.alert({
 		              title: '&nbsp;',
 		              content: '<i class="fa fa-check-circle-o fa-2x"></i><label>文章删除成功!</label>',
 		              confirmButton: '确认'
 		            });
		    			}else if(data=="ERROR"){
		    				$.alert({
 		              title: '&nbsp;',
 		              content: '<i class="fa fa-times-circle-o fa-2x"></i><label>文章删除失败!</label>',
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
    	var title = subtitle(e.title);
      html=html+"<li class='list-group-item'><div class='list-article-title'>";
      if(e.is_private==0){html=html+"<label>公开</label>";}
      else{html=html+"<label>私密</label>";}
      html=html+"<a href='#"+e.id+"'>"+title+"</a></div>"+
      "<div class='list-article-info'><div class='info-left'>";
      if(e.type==0){html=html+"<span>原创</span>";}
      else if(e.type==1){html=html+"<span>转载</span>";}
      else{html=html+"<span>翻译</span>";}
      html=html+"<span>"+e.publishTime+"</span>"+
      "<span data-toggle='tooltip' title='浏览数'><i class='fa fa-eye'></i>"+e.clickCount+"</span>"+
      "<span data-toggle='tooltip' title='评论数'><i class='fa fa-commenting fa-fw'></i>"+e.commentCount+"</span>"+
      "</div><span class='delete'><a>删除</a></span><span class='show'><a>查看</a></span></div></li>"
    });
    $(".list-article ul").append(html);
    showpage(data);
	}
	
	function subtitle(data){
		var ss= null;
		if(data.length<2){
			ss=data;
		}else{
			ss = data.substring(0,2);
	    ss = ss+"。。。";
		}
		return ss;
	}
</script>
