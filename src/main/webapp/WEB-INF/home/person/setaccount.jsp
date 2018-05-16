<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<div class="col-md-12 person">
	<div class="col-md-12 setaccount">
		<div class="person-title col-md-9">
			<label>
				<span>&nbsp;</span>
				账号设置
			</label>
		</div>
		<div class="col-md-12 ">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#password" role="tab" data-toggle="tab">修改密码</a></li>
				<li><a href="#email" role="tab" data-toggle="tab">修改邮箱</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">  
		    <div class="tab-pane active" id="password">  
	        <form id="form-updatepassword" class="update">
						<div class="col-md-12">
							<label class="">旧密码:</label>
	        		<div class="form-group">
		            <input class="form-control required" type="password" id="oldpassword" name="oldpassword" 
		            	placeholder="请输入旧密码"/>
	            </div>
						</div>
            <div class="col-md-12">
            	<label class="">新密码:</label>
	            <div class="form-group">
		            <input class="form-control required" type="password" id="password" name="password"
		            	placeholder="请输入新密码"/>
	            </div>
            </div>
            <div class="col-md-12">
            	<label class="">确认密码:</label>
	        		<div class="form-group">
		            <input class="form-control required" type="password" id="confirm" name="confirm" 
		            	placeholder="请再次输入密码"/>
	            </div>
            </div>
            <div class="col-md-12">
	        		<div class="form-group">
		            <button type="button" class="btn btn-success" name="submit">提交</button>
	            </div>
            </div>
          </form>
		    </div>
		    <div class="tab-pane" id="email">  
	        <form id="form-updateemail" class="update">
						<div class="col-md-12">
							<label class="">邮箱:</label>
	        		<div class="form-group">
		            <input class="form-control required" type="text" id="email" name="email" 
		            	placeholder="请输入邮箱"/>
	            </div>
						</div>
            <div class="col-md-12">
            	<label class="">密码:</label>
	            <div class="form-group">
		            <input class="form-control required" type="password" id="password" name="password"
		            	placeholder="请输入密码"/>
	            </div>
            </div>
            <div class="col-md-12">
	        		<div class="form-group">
		            <button type="button" class="btn btn-success" name="submit">提交</button>
	            </div>
            </div>
          </form>
		    </div>
			</div>
		</div>
	</div>
</div>
<script src="../../common/js/validaterule.js"></script>
<script>
	$(function(){
		$("#form-updatepassword").bootstrapValidator({
			live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证 
	    feedbackIcons: {//根据验证结果显示的各种图标
	      valid: "glyphicon glyphicon-ok",
	      invalid: "glyphicon glyphicon-remove",
	      validating: "glyphicon glyphicon-refresh"
	    },
	    fields: {
	    	oldpassword: {
	    		validators:{
	    			notEmpty: {
	            message: "内容不能为空"
	         }
	    		}
	    	},
	      password: {
	        validators: {
	          notEmpty: {
	            message: "内容不能为空"
	          },
	          stringLength: {
	            min: 6,
	            max: 12,
	            message: "长度必须在6到12位之间"
	          },
	          regexp: {
	            regexp: /^[a-zA-Z0-9_]+$/,
	            message: "只能包含英文、数字和下划线"
	          }
	        }
	      },
	      confirm: {
	      	validators:{
	      		notEmpty: {
	            message: '密码重复不能为空'
	         	},
	          identical: {
	              field: 'password',
	              message: '两次密码不同请重新输入'
	          }
	    		}
	      }
	    }
	  });
	  
	  $("#form-updateemail").bootstrapValidator({
			live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证 
	    feedbackIcons: {//根据验证结果显示的各种图标
	      valid: "glyphicon glyphicon-ok",
	      invalid: "glyphicon glyphicon-remove",
	      validating: "glyphicon glyphicon-refresh"
	    },
	    fields: {
	    	email: {
	    		validators:{
	    			notEmpty: {
	            message: "内容不能为空"
	         	},
	    			emailAddress: {
			        message: '邮箱格式不正确'
	          }
	    		}
	    	},
	      password: {
	        validators: {
	          notEmpty: {
	            message: "密码不能为空"
	          }
	        }
	      }
	    }
	  });
	  
	});
</script>
