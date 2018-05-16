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
			<ul class="list-group list-article">
				<li class="list-group-item">
					<div>
						<a href="#">五一出游，“我”的隐私被扒干净了</a>
						<p>2018-05-08&nbsp;&nbsp;
							<i class="glyphicon glyphicon-trash delete"></i>
						</p>
					</div>
				</li>
				<li class="list-group-item">
					<div>
						<a href="#">kwjfksdnlkhfiew</a>
						<p>2018-05-08&nbsp;&nbsp;
							<i class="glyphicon glyphicon-trash delete"></i>
						</p>
					</div>
				</li>
			</ul>
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
		
		$(".sysmessage-show a").click(function(){
    	
    	$('#messageModal').modal('show');
    
    });
	})
</script>
