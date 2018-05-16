<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<div class="col-md-12 person personal">
	<div class="col-md-12 info">
		<div class="col-md-2 person-photo">
			<img src="${CTP}/static/image/头像.png"/>
			<br />
			<div>
				<div class="attention-count">
					<label>1</label><br/>
					<p>关注</p>
				</div>
				<div class="fans-count">
					<label>0</label><br/>
					<p>粉丝</p>
				</div>
			</div>
		</div>
		<div class="col-md-10">
			<div class="person-edit">
				<a class="edit-info">
					<i class="glyphicon glyphicon-edit">修改个人资料</i>
				</a>
			</div>
			<dl>
				<dt class="person-name">
					<span>Leihen775</span>
				</dt>
				<dd class="person-detail">
					计算机软件<span>|</span><span class="info_null">未填写职位</span><span>|</span>
					<span class="info_null">未填写姓名</span><span>|</span>中国-河南省-郑州市<span>|</span>
					男<span>|</span><span class="info_null">未填写生日</span>
				</dd>
				<dd class="person-sign">个人简介</dd>
			</dl>
			<div class="modal fade" id="personalinfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
							</button>
							<h4 class="modal-title" id="myModalLabel">
								编辑个人资料
							</h4>
						</div>
						<div class="modal-body">
							<form class="form-horizontal" role="form">
								<div class="form-group">
                  <label for="user_id" class="col-md-1 control-label">网址:</label>
                  <div class="col-md-9">
                    <input class="form-control required" type="text" id="url" name="url"/>
                  </div>
                </div>
                <div class="form-group">
                  <label for="user_id" class="col-md-1 control-label">标题:</label>
                  <div class="col-md-9">
                    <input class="form-control required" type="text" id="title" name="title"/>
                  </div>
                </div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">
								关闭
							</button>
							<button type="button" class="btn btn-primary">
								提交更改
							</button>
						</div>
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
		</div>
	</div>
	<div class="col-md-12 ">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#blog" role="tab" data-toggle="tab">我的博客</a></li>
			<li><a href="#question" role="tab" data-toggle="tab">我的问答</a></li>
			<li><a href="#collect" role="tab" data-toggle="tab">我的收藏</a></li>
			<li><a href="#relation" role="tab" data-toggle="tab">我的关系</a></li>
		</ul>
		<div id="myTabContent" class="tab-content">  
	    
	    <div class="tab-pane active" id="blog">  
        <ul class="list-group list-article">
					<li class="list-group-item">
						<div>
							<a href="#">五一出游，</a>
							<label>2018-05-08 12:07:50</label>
						</div>
					</li>
				</ul> 
	    </div>
	    <div class="tab-pane" id="question">  
        <ul class="list-group list-article">
					<li class="list-group-item">
						<div>
							<a href="#">五一出游，“我”的隐私被扒干净了</a>
							<label>2018-05-08 12:07:50</label>
						</div>
					</li>
				</ul> 
	    </div>
	    <div class="tab-pane" id="collect">  
        <ul class="list-group list-article">
					<li class="list-group-item">
						<div>
							<a href="#">五一出游，“我”的隐私被扒干净了</a>
							<p>2018-05-08&nbsp;&nbsp;
								<i class="glyphicon glyphicon-edit edit"></i>&nbsp;
								<i class="glyphicon glyphicon-trash delete"></i>
							</p>
						</div>
					</li>
					<li class="list-group-item">
						<div>
							<a href="#">kwjfksdnlkhfiew</a>
							<p>2018-05-08&nbsp;&nbsp;
								<i class="glyphicon glyphicon-edit edit"></i>&nbsp;
								<i class="glyphicon glyphicon-trash delete"></i>
							</p>
						</div>
					</li>
				</ul>
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="collectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
								</button>
								<h4 class="modal-title" id="myModalLabel">
									编辑收藏
								</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal" role="form">
									<div class="form-group">
                    <label for="user_id" class="col-md-1 control-label">网址:</label>
                    <div class="col-md-9">
                      <input class="form-control required" type="text" id="url" name="url"/>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="user_id" class="col-md-1 control-label">标题:</label>
                    <div class="col-md-9">
                      <input class="form-control required" type="text" id="title" name="title"/>
                    </div>
                  </div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">
									关闭
								</button>
								<button type="button" class="btn btn-primary">
									提交更改
								</button>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</div><!-- /.modal -->
				
				
	    </div>  
	    <div class="tab-pane" id="relation">  
        <p>我这里是我的关系选项卡显现的</p>  
	    </div> 
		</div>
	</div>
</div>

<script>
	$(function(){
		
		/*展示选项卡*/
    $("#myTab a").click(function(e){
      e.preventDefault();
      $(this).tab("show");
    });
    
    $(".edit").click(function(){
    	var url = $(this).parent().prev().attr("href");
    	var title = $(this).parent().prev().text();
    	$("#collectModal #url").val(url);
    	$("#collectModal #title").val(title);
    	
    	$('#collectModal').modal('show');
    
    });
    
    $(".edit-info").click(function(){
    	
    	$('#personalinfoModal').modal('show');
    
    });
	})
</script>
