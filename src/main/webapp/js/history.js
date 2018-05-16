$.extend({
	/**
	*  使用jquery的load方法加载页面, 
	*  根据url地址加载该页面中的id为content的内容 到 本页面的ID为content的位置
	*  url        链接URL
	*  data    链接请求参数
	*/
	loadPage: function(url, data) {
		$.ajaxSetup({cache: false });
		$("#content").load(url+ " #content ", data, function(result){
			// 将被加载页的JavaScript加载到本页执行
			$result = $(result); 
			// 将页面传递参数data定义为param 在被加载页接收
			$result.find("script").prepend("var param = "+JSON.stringify(data)).appendTo('#content');
		});
	},
	/**
	* 保存链接url、菜单ID、链接请求数据到 历史记录中
	* url        链接URL
	* menuId    菜单ID
	* data        链接请求参数
	*/
	pushState : function(url, menuId, data) {
		console.log("pushState:"+url+":::"+ menuId+":::"+ data)
		 
		// 如果URL没有menuId，即认为该菜单页面中链接跳转，使用该链接所在页的menuId
		if(menuId == null || menuId == ''){
			menuId = history.state.menuId;
		}
		// 将URL，menuId, 请求参数保存到历史记录中
		history.pushState({urlStr : url, menuId : menuId, data : data}, "页面标题", "?_url="+url);
	},
	/**
	* 浏览器 前进、后退事件
	*/
	popState : function(){
		window.addEventListener("popstate", function() {
			var currentState = history.state;
			if(currentState!=null){
				url = ".."+currentState.urlStr;
				this.menuOpen(currentState.menuId);
				var primitiveUrl = currentState.urlStr.split("#")[0];
				//aa = primitiveUrl;
				$.loadPage(url, currentState.data);
			}
		});
	},
	/**
	* 浏览器刷新事件
	*/ 
	refresh : function(){
		var currentState = history.state;
		if(currentState!=null){
			loadUrl = ".."+currentState.urlStr;
			var primitiveUrl = currentState.urlStr.split("#")[0];
			aa = primitiveUrl;
			var page = loadUrl.split("#")[1];
			pageScript = "";
			if(page !=null){
				pageScript = " $table.page("+page+").draw(false);";
			}
			//console.log(loadUrl+":::"+ currentState.data);
			$.loadPage(loadUrl, currentState.data);
		}
	},
	/**
	* 菜单树展开方法
	* menuId      菜单对应的ID
	*/
	menuOpen : function(menuId){
		$("#leftMenu").find(".active").removeClass("active");
		$("#leftMenu").find("ul").css({"display":"none"});
		 
		$("#"+menuId).addClass("active");
		$("#"+menuId).parents("li").addClass("active");
		$("#"+menuId).parents("ul").addClass("menu-open").css({"display":"block"});
	}
});