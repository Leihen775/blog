<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CTP" value="${pageContext.request.contextPath}"></c:set>
<%-- <script src="${CTP}/static/fileinput/js/locales/zh.js"></script> --%>
<div class="col-md-12 person personal">
	<div class="col-md-12 info">
		<dl class="col-md-2 person-photo">
      <dt>
        <img src="${CTP }/static/image/头像.png"/>
        <span class="glyphicon glyphicon-edit edit-img"></span>
      </dt>
      <dd class="col-md-6 focus-num">
        <label></label><br/>
        <p>关注</p>
      </dd>
      <dd class="col-md-6 fans-num">
        <label></label><br/>
        <p>粉丝</p>
      </dd>
    </dl>
		<div class="col-md-10">
			<div class="person-edit">
				<a class="edit-info">
					<i class="glyphicon glyphicon-edit">修改个人资料</i>
				</a>
			</div>
			<dl>
				<dt class="person-name">
					<span></span>
				</dt>
				<dd class="person-detail"></dd>
				<dd class="person-sign">个人简介</dd>
				<dd></dd>
			</dl>
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
        <ul class="list-group list-article"></ul>
				<div class="page" id="page-article"></div>
	    </div>
	    <div class="tab-pane" id="question">  
        <ul class="list-group list-article">
					<!-- <li class="list-group-item">
						<div>
							<a href="#">五一出游，“我”的隐私被扒干净了</a>
							<label>2018-05-08 12:07:50</label>
						</div>
					</li> -->
				</ul>
				<div class="page" id="page-question"></div>
	    </div>
	    <div class="tab-pane" id="collect">  
        <!-- <ul class="list-group list-article">
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
				</ul> -->
				<div class="page" id="page-collection"></div>
	    </div>  
	    <div class="tab-pane" id="relation">  
          
	    </div> 
		</div>
	</div>
	<div class="modal fade" id="personalinfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
          </button>
          <h4 class="modal-title" id="myModalLabel"> 编辑个人资料</h4>
        </div>
        <div class="modal-body">
          <form class="form-horizontal" role="form">
            <div class="col-md-6  form-group edit-input">
              <label class="col-md-2 control-label">昵称:</label>
              <div class="col-md-9">
                <input class="form-control required" type="text" id="nickname" name="nickname"/>
              </div>
            </div>
            <div class="col-md-6 form-group edit-input">
              <label class="col-md-2 control-label">实名:</label>
              <div class="col-md-9">
                <input class="form-control required" type="text" id="realname" name="realname"/>
              </div>
            </div>
            <div class="col-md-6  form-group edit-input">
              <label class="col-md-2 control-label">工作:</label>
              <div class="col-md-9">
                <input class="form-control required" type="text" id="job" name="job"/>
              </div>
            </div>
            <div class="col-md-6  form-group edit-input">
              <label class="col-md-2 control-label">生日:</label>
              <div class="col-md-9 input-append date form_datetime">
                <input class="form-control required" type="text" id="birth" name="birth" value="" readonly>
                <span class="add-on"><i class="icon-th"></i></span>
                <span class="add-on"><i class="icon-remove"></i></span>
              </div>
            </div>
            <div class="col-md-6 form-group edit-input">
              <label class="col-md-2 control-label">行业:</label>
              <div class="col-md-9">
                <select class="form-control" id="trade" name="trade"></select>
              </div>
            </div>
            <div class="col-md-6 form-group edit-input">
              <label class="col-md-2 control-label">性别:</label>
              <div class="col-md-9" id="sex">
                <!--<input class="form-control required" type="text" id="job" name="job"/>-->
                <label class="radio-inline">
                  <input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="0" checked>男
                </label>
                <label class="radio-inline">
                  <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="1">女
                </label>
              </div>
            </div>
            <div class="col-md-12  form-group edit-input">
              <label class="col-md-1 control-label">地区:</label>
              <div class="col-md-8">
                <input class="form-control required" type="text" id="address" name="address"/>
              </div>
            </div>
            <div class="col-md-12  form-group edit-input">
              <label class="col-md-1 control-label">简介:</label>
              <div class="col-md-8">
                <textarea id="" name=""></textarea>
              </div>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          <button type="button" class="btn btn-primary btn-updateuser">提交更改</button>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
  <!-- 模态框（Modal） -->
  <div class="modal fade" id="collectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
          </button>
          <h4 class="modal-title" id="myModalLabel">编辑收藏</h4>
        </div>
        <div class="modal-body">
          <form class="form-horizontal" role="form">
            <div class="form-group">
              <label class="col-md-1 control-label">网址:</label>
              <div class="col-md-9">
                <input class="form-control required" type="text" id="url" name="url"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-md-1 control-label">标题:</label>
              <div class="col-md-9">
                <input class="form-control required" type="text" id="title" name="title"/>
              </div>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          <button type="button" class="btn btn-primary">  提交更改 </button>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
  <!-- 模态框（Modal） -->
  <div class="modal fade" id="upload" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h4 class="modal-title" id="myModalLabel">上传头像</h4>
        </div>
        <div class="modal-body">
          <div id="kv-avatar-errors" class="center-block" style="width:100%;display:none"></div>
          <div class="kv-avatar">
            <div class="file-loading">
              <input id="avatar" name="avatar" type="file" required>
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          <button type="button" class="btn btn-primary">保存 </button>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->
</div>
<script>
//上传头像
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
});


</script>
<script src="${CTP}/js/personal.js"></script>
