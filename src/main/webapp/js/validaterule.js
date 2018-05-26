$(function(){
	$("#form-login").bootstrapValidator({
		live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证 
    feedbackIcons: {//根据验证结果显示的各种图标
      valid: "glyphicon glyphicon-ok",
      invalid: "glyphicon glyphicon-remove",
      validating: "glyphicon glyphicon-refresh"
    },
    fields: {
      username: {
        validators: {
          notEmpty: {
            message: "用户名不能为空"
          }
        }
      },
      password: {
        validators: {
          notEmpty: {
            message: "密码不能为空"
          },
          regexp: {
            regexp: /^[a-zA-Z0-9_]+$/,
            message: "只能包含英文、数字和下划线"
          }
        }
      },
      code:{
      	validators: {
          notEmpty: {
            message: "验证码不能为空"
          },
          /*remote: {
            url: "/action/codeValidator",
          	message: '验证码不正确',
          	//delay :  2000,
          	type: 'POST'
          }*/
        }
      }
    }
  });
	/*$(".btn-login").click(function(){
		$("#form-login").bootstrapValidator('validate');
		$("#form-login").data('bootstrapValidator').validate();
		console.log($("#form-login").data('bootstrapValidator').isValid());
	});*/
	
	
	$("#form-regist").bootstrapValidator({
		live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证 
    feedbackIcons: {//根据验证结果显示的各种图标
      valid: "glyphicon glyphicon-ok",
      invalid: "glyphicon glyphicon-remove",
      validating: "glyphicon glyphicon-refresh"
    },
    fields: {
      account: {
        validators:{
    	  notEmpty: {
            message: "账号不能为空"
          },
    	  emailAddress: {
		    message: '邮箱格式不正确'
          },
          remote: {
            url: "action/isExist",
        	message: '账号已存在',
        	type: 'POST'
          }
    	}
      },
      username: {
        validators: {
          notEmpty: {
            message: "用户名不能为空"
          },
          stringLength: {
            min: 2,
            max: 8,
            message: '用户名长度不能小于2位或超过8位'
          },
          remote: {
            url: "action/isExist",
          	message: '用户名不可用',
          	type: 'POST'
          }
        }
      },
      password: {
        validators: {
          notEmpty: {
            message: "密码不能为空"
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
      },
      code:{
      	validators: {
          notEmpty: {
            message: "验证码不能为空"
          },
          remote: {
            url: "action/codeValidator",
        	message: '验证码不正确',
        	type: 'POST'
          }
        }
      }
    }
  });
  /*$(".btn-regist").click(function(){
  	$("#form-regist").data('bootstrapValidator').validate();
	console.log($("#form-regist").data('bootstrapValidator').isValid());
  });*/
  
  
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
              message: "密码不能为空"
         	}
    	  }
    	},
      password: {
        validators: {
          notEmpty: {
            message: "密码不能为空"
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
	
});