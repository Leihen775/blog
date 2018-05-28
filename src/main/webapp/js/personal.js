$(function(){
	
	$.ajax({//查询行业信息
		type:"POST",
		url:"../findTrade",
		success:function(data){
			var html = "<option>请选择</option>";
			$.each(data,function(i,e){
		        html=html+"<option value='"+e.id+"'>"+e.name+"</option>"
		    });
			$("#personalinfoModal #trade").append(html);
		}
	});
		
	$.ajax({//查询个人信息
		type:"POST",
		url:"../findUserInfo",
		success:function(data){
			var html = "";
			$(".person-photo img").attr({src:data.imagePath});
			if(data.nickname!=null){
				$(".person-name span").text(data.nickname);
				$("#personalinfoModal #nickname").val(data.nickname);
			}else{
				$(".person-name span").text(data.username);
				$("#personalinfoModal #nickname").val(data.username);
			}
			if(data.trade!=null){
				html=html+data.trade.name+"<span>|</span>";
				$("#personalinfoModal #trade").val(data.trade.id);
			}else{
				html=html+"<span class='info_null'>未填写行业</span><span>|</span>";
			}
			if(data.job!=null){
				html=html+data.job+"<span>|</span>";
				$("#personalinfoModal #job").val(data.job);
			}else{
				html=html+"<span class='info_null'>未填写工作</span><span>|</span>";
			}
			if(data.realname!=null){
				html=html+data.realname+"<span>|</span>";
				$("#personalinfoModal #realname").val(data.realname);
			}else{
				html=html+"<span class='info_null'>未填写姓名</span><span>|</span>";
			}
			if(data.address!=null){
				html=html+data.address+"<span>|</span>";
				$("#personalinfoModal #address").val(data.address);
			}else{
				html=html+"<span class='info_null'>未填写地址</span><span>|</span>";
			}
			if(data.sex!=null){
				if(data.sex==0){
					html=html+"男<span>|</span>";
					$("#personalinfoModal #sex input[value=0]").attr("checked", true);
				}else{
					html=html+"女<span>|</span>";
					$("#personalinfoModal #sex input[value=1]").attr("checked", true);
				}
			}else{
				html=html+"<span class='info_null'>未填写性别</span><span>|</span>";
			}
			if(data.birth!=null){
				html=html+data.birth;
				$("#personalinfoModal #birth").val(data.birth);
			}else{
				html=html+"<span class='info_null'>未填写生日</span>";
			}
			$(".person-detail").html(html);
		}
	});
	
	$(".btn-updateuser").click(function(){//修改个人资料
		$.confirm({
			title: '警告!',
			content: '确认修改个人信息!',
			confirm: function(){
				$.ajax({
					type:"POST",
					url:"../updateUserInfo",
					data:{
						"nickname":$("#personalinfoModal #nickname").val(),
						"realname":$("#personalinfoModal #realname").val(),
						"job":$("#personalinfoModal #job").val(),
						"birth":$("#personalinfoModal #birth").val(),
						"tradeId":$("#personalinfoModal #trade option:selected").val(),
						"sex":$("#personalinfoModal #sex input:radio:checked").val(),
						"address":$("#personalinfoModal #address").val(),
						"summary":$("#personalinfoModal #summary").val()
					},
					success:function(data){
						if(data=="SUCCESS"){
							$("#personalinfoModal .modal-footer .btn-default").trigger("click");
							message("check","信息修改成功!");
						}else if(data=="ERROR"){
							message("times","信息修改失败!");
						}
					}
				});
          	},
          	cancel: function(){},
          	confirmButton: '确认',
          	cancelButton: '取消',
          	confirmButtonClass: 'btn-info',
          	cancelButtonClass: 'btn-danger',
		})
	});
		
	$.ajax({//查询个人文章
        type:"POST",
        url:"../findArticleList",
        data:{"pageNum":1,"state":1},
        success:function(data){
    	    var array = data.list;
    	    var pageid=$("#page-article");
    	    var html = "";
    	    $.each(array,function(i,e){
 	            html=html+"<li class='list-group-item'><div>"+
 	                 "<a href='#'>"+e.title+"</a>"+
 	                 "<label>"+e.publishTime+"</label>"+
 	                 "</div></li>";
 	        
 	        });
    	    $("#blog .list-article").append(html);
            showpage(data,'page-article');
        }
    });
    $("#page-article").delegate('a','click',function(){
		var page = $(this).attr("href").split("#")[1];
		$.ajax({//查询个人文章
	        type:"POST",
	        url:"../findArticleList",
	        data:{"pageNum":page,"state":1},
	        success:function(data){
    	        $("#blog .list-group-item").remove();
	            var array = data.list;
	            var html = "";
	            $.each(array,function(i,e){
	                html=html+"<li class='list-group-item'><div>"+
	                   "<a href='#'>"+e.title+"</a>"+
	                   "<label>"+e.publishTime+"</label>"+
	                   "</div></li>";
	            });
                $("#blog .list-article").append(html);
                showpage(data,'page-article');
	        }
	    });
    });
    
	$.ajax({//查询个人问题
        type:"POST",
        url:"../findQuestionList",
        data:{"pageNum":1,"state":0},
        success:function(data){
    	    var array = data.list;
    	    var html = "";
    	    $.each(array,function(i,e){
 	            html=html+"<li class='list-group-item'><div>"+
 	                 "<a href='#'>"+e.title+"</a>"+
 	                 "<label>"+e.publishTime+"</label>"+
 	                 "</div></li>";
 	        });
    	    $("#question .list-article").append(html);
    	    showpage(data,'page-question');
        }
    });
	$("#page-question").delegate('a','click',function(){
		var page = $(this).attr("href").split("#")[1];
		$.ajax({
	        type:"POST",
	        url:"../findQuestionList",
	        data:{"pageNum":page,"state":0},
	        success:function(data){
    	        $("#question .list-group-item").remove();
	            var array = data.list;
	            var html = "";
	            $.each(array,function(i,e){
	                html=html+"<li class='list-group-item'><div>"+
	                   "<a href='#'>"+e.title+"</a>"+
	                   "<label>"+e.publishTime+"</label>"+
	                   "</div></li>";
	            });
	            $("#question .list-article").append(html);
	    	    showpage(data,'page-question');
	        }
	    });
    });
		
	$.ajax({//查询粉丝
        type:"POST",
        url:"http://localhost:8080/blog/findFocusAndFans",
        success:function(data){
    	    $(".focus-num label").text(data[0]);
    	    $(".fans-num label").text(data[1]);
        }
    });
		
		/*展示选项卡*/
    $("#myTab a").click(function(e){
        e.preventDefault();
        $(this).tab("show");
    });
		
    $(".form_datetime").datetimepicker({
      minView: "month",//设置只显示到月份
      format: "yyyy-mm-dd",
      autoclose: true,
      todayBtn: true,
      pickerPosition: "bottom-left"
    });//日期控件
    
    //显示修改收藏信息
    $(".edit").click(function(){
    	var url = $(this).parent().prev().attr("href");
    	var title = $(this).parent().prev().text();
    	$("#collectModal #url").val(url);
    	$("#collectModal #title").val(title);
    	$('#collectModal').modal('show');
    });
    
    //显示修改个人信息
    $(".edit-info").click(function(){
    	$('#personalinfoModal').modal('show');
    });
    
    //显示头像上传
    $(".edit-img").click(function(){
    	$('#upload').modal('show');
    });
    
    /*//上传头像
    $("#avatar").fileinput({
    	language: 'zh',
      overwriteInitial: true,
      maxFileSize: 1500,
      showClose: false,
      showCaption: false,
      showBrowse: false,
      browseOnZoneClick: true,
      showRemove:false,
      showUpload:false,
      elErrorContainer: '#kv-avatar-errors',
      msgErrorClass: 'alert alert-block alert-danger',
      msgSizeTooLarge:'图片 "{name}" (<b>{size} KB</b>) 超过了允许大小 <b>{maxSize} KB</b>',
      defaultPreviewContent: '<img src="${CTP}/static/image/icon/img-bg.jpg" alt="Your Avatar"><h6 class="text-muted">请点击这里</h6>',
      layoutTemplates: {main: '{preview} {remove} {browse}'},
      allowedFileExtensions: ["jpg", "png", "gif"],
	    uploadUrl: "http://localhost:8080/blog/uploads/uploaduserpic",
	    uploadAsync: false,
	    maxFileCount: 1
    }).on('fileuploaded', function(event, data) {
      $.ajax({
    	  type: "POST",
    	  url: "http://localhost:8080/blog/action/updateUserImg",
        data: {
          "imagePath":data.response
        },
        success: function(data){
        	console.log(data);
        }
      });
    });*/
    
    //修改用户信息
    
    
})
	
function showpage(data,pageid){
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
    var doc1;
    var doc2;
    if(pageid=='page-article'){
    	doc1 = $("#page-article");
    	doc2 = $("#page-article .pagination")
    }else if(pageid=='page-question'){
    	doc1 = $("#page-question");
    	doc2 = $("#page-question .pagination");
    }else if(pageid=='page-collection'){
    	doc1 = $("#page-collection");
    	doc2 = $("#page-collection .pagination");
    }
    doc2.remove();
    doc1.append(html);
}

function message(c,m){
	$.alert({
		title: "&nbsp;",
		content: "<i class='fa fa-"+c+"-circle-o fa-2x'></i><label>"+m+"</label>",
		confirmButton: "确认"
	});
}