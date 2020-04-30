<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!doctype html>
<html>
	<head>
		<!--声明当前页面的编码集：charset=gbk,gb2312(中文编码)，utf-8国际编码-->
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<!--当前页面的三要素-->
		<title>拍拍网后台管理系统</title>
		<meta name="keywords" content="关键词">
		<meta name="scription" content="">
		<!-- <link rel="stylesheet" type="text/css" href="css/main.css"/> -->
		<style type="text/css">
			* {
				margin: 0px;
				padding: 0px;
			}
			
			body {
				font-size: 12px;
				font-family: "微软雅黑";
				color: #666;
			}
			html,body{
				width: 100%;
				height: 100%;
			}
			
			a {
				text-decoration: none;
			}
			/*left start*/
			
			.left {
				width: 200px;
				height: 100%;
				background: #282828;
				position: fixed;
				top: 0;
				left: 0;
				z-index: 1
			}
			
			.left .logo {
				width: 100%;
				height: 108px;
				background: url("${path}/image/logo.png") no-repeat center;
				border-bottom: 1px solid #000;
			}
			/*nav start*/
			
			.left .nav {
				width: 100%;
				border-bottom: 1px solid #414141;
			}
			
			.left .nav ul li {
				list-style: none;
				border-bottom: 1px solid #000;
				border-top: 1px solid #414141;
				line-height: 52px;
				overflow: hidden;
			}
			
			.left .nav ul li a {
				color: #fff;
				display: block;
				padding-left: 30px;
				transition: all .5s ease;
			}
			/*高亮显示*/
			.left .nav ul li a.active{
				background: #1A6748;
			}
			/*二级菜单背景色*/
			.left .nav ul li ul{
				width: 100%;
				height: auto;
				background: #403E3E;
				display: none;
			}
			.left .nav ul li a:hover {
				background: #28b779;
				transition: all .3s ease; 
			}
			
			.left .nav ul li a p {
				font-size: 14px;
				padding-left: 25px;
			}
			
			.left .nav ul li a i {
				width: 16px;
				height: 16px;
				display: block;
				background: url("${path}/image/ht_icon.png") no-repeat;
				float: left;
				margin-top: 20px;
			}
			
			.left .nav ul li .icon-1 {
				background-position: -234px -52px;
			}
			
			.left .nav ul li .icon-2 {
				background-position: -255px -52px;
			}
			
			.left .nav ul li .icon-3 {
				background-position: -212px -52px;
			}
			
			.left .nav ul li .icon-4 {
				background-position: -91px -25px;
			}
			
			.left .nav ul li .icon-5 {
				background-position: -295px -52px;
			}
			
			.left .nav ul li .icon-6 {
				background-position: -316px -48px;
				width: 18px;
				height: 16px;
			}
			/*end nav*/
			/*end left*/

			/*header start*/
			
			.header {
				width: 100%;
				height: 56px;
				background: #2f3437;
				position: fixed;
				top: 0;
			}
			/*nav start*/
			/*.header .nav {
				height: 56px;
				margin-left: 200px;
				float: left;
			}*/
			/*end nav*/
			/*info start*/
			/*用户登录状态*/
			.header .info {
				position: absolute;
				top: 0;
				right: 10px;
			}
			/*当前用户 用户身份*/
			.header .info .user {
				color: #fff;
				line-height: 56px;
				float: left;
			}
			/*登录退出按钮*/
			.header .info .out,.header .info .login {
				width: 65px;
				height: 30px;
				background: #28b779;
				float: right;
				margin: 13px 15px;
			}
			.out{
				display: none;
			}
			.login{
				background: #CD3F45;
			}
			
			.header .info .out a,.login a {
				color: #fff;
				line-height: 30px;
				display: block;
				padding-left: 10px;
			}
			.login a{
				padding-left:0;
				color: #fefefe;
				text-align: center;
			}
			.header .info .out a p {
				float: left;
			}
			
			.header .info .out a i {
				width: 14px;
				height: 14px;
				display: block;
				float: left;
				background: url("images/ht_icon.png") no-repeat;
				background-position: 0 -51px;
				margin: 7px 8px;
			}
			/*end info*/
			/*end header*/

			.right {
				height: 100%;
				box-sizing: border-box;
				background: #f3f4f5;
				margin-left: 200px;
				padding-top: 56px;
			}
			
			
			/*footer*/
			.footer{
				width: 100%;
				height: 50px;
				background: #282828;
				position: fixed;
				bottom: 0;
			}
			.footer p{
				color: #ccc;
				text-align: center;
				line-height: 1.5;
				
			}
			.footer p:nth-of-type(1){
				margin-top: 8px;
			}
			.footer p a{
				color:#999;
			}
			/*footer*/
			
			@media screen and (max-width:1360px) {
				/*nav start*/
				.header .nav {
					margin-left: 200px;
				}
				.header .nav ul li {
					width: 80px;
				}
				/*end nav*/
			}
			/*头部导航和左侧导航小于1024的时候 用下边的样式*/
			
			@media screen and (max-width:1024px) {
				/*right start*/
				.right {
					margin-left: 50px;
				}
				/*end right*/
				/*left start*/
				.left {
					width: 50px;
				}
				.left .logo {
					height: 54px;
					background: url("") no-repeat center;
				}
				.left .nav ul li a {
					padding-left: 16px;
					height: 52px;
				}
				.left .nav ul li a p {
					display: none;
				}
				/*end left*/
				/*nav start*/
				.header .nav {
					margin-left: 50px;
				}
				.header .nav ul li {
					width: 60px;
				}
				.header .nav ul li a p {
					display: none;
				}
				.header .nav ul li a i {
					margin: 18px auto;
				}
				/*end nav*/
				/*.header .info .user {
					display: none;
				}*/
			}
			
			/*“小组件样式”注释后的样式全部迁移到子页面中*/
		
		</style>
	</head>
		<body>
			<!--left start-->
				<div class="left">
					<div class="logo">
					</div>
					<div class="nav">
						<ul>
							<li>
								<a href="#">
									<i class="icon-1"></i>
									<p>商品</p>
								</a>
								<ul class="ni">
									<li><a href="${path}/item/admin_getUnverifyItemPage" target="myIframe" >待审核商品</a></li>
									<li><a href="${path}/item/admin_getVerifiedItemPage" target="myIframe" >已审核商品</a></li>
								</ul>
							</li>
							<li>
								<a href="#">
									<i class="icon-2"></i>
									<p>订单</p>
								</a>
								<ul class="ni">
									<li><a href="${path}/order/admin_getOrderListPage" target="myIframe" >订单列表</a></li>
									<li><a href="${path}/order/admin_getInterveneListPage" target="myIframe" >纠纷处理</a></li>
								</ul>
							</li>
							<li>
								<a href="${path}/adv/admin_getAdvertisementListPage"  target="myIframe">
									<i class="icon-3"></i>
									<p>广告位管理</p>
								</a>
							</li>
							<li>
								<a href="${path}/user/admin_getUserListPage"  target="myIframe">
									<i class="icon-4"></i>
									<p>用户管理</p>
								</a>
							</li>
							
							<%-- 只有超级管理员才能显示管理员管理相关的功能 --%>
							<c:if test="${admin.superUser==true}">
								<li>
									<a href="${path}/admin/super_getAdminListPage"  target="myIframe">
										<i class="icon-4"></i>
										<p>管理员管理</p>
									</a>
								</li>
							</c:if>
						</ul>
					</div>

				</div>
			<!--end left-->

			<!--header start-->
				<div class="header">
					<!-- <div class="nav">

					</div> -->

					<div class="info">
						<div class="user">
							<span>当前用户：${admin.username}&nbsp;&nbsp;</span>
							<span>身份：</span>
							<span>
								<c:if test="${admin.superUser==true}">超级管理员</c:if>
								<c:if test="${admin.superUser==false}">管理员</c:if>
							</span>
							<span>&nbsp;&nbsp;</span>
							<a href="${path}/admin/admin_changePWDPage" target="myIframe" style="color:#4bb;">修改密码</a></div>
						<div class="out">
							<a href="#">
								<p>退出<p>
								<i></i>							
							</a>
						</div>
						<div class="login">
							<a href="${path}/admin/loginPage">退出</a>
						</div>
					</div>
				</div>
			<!--end header-->

				<div class="right">
					<iframe src="${path}/admin/admin_welcomePage" name="myIframe" width="99%" height="94%" scrolling="yes"></iframe>
				</div>
			<!--end right-->
			
			<!--footer start-->
			<div class="footer">
				<p>版权所有 paipaiwang团队（<a href="http://www.paipaiwang.com" target="_blank"> www.paipaiwang.com</a>） 设计维护</p>
				<p>Copyright © cosyit Team. All Rights Reserved.</p>
			</div>
			
			<script src="${path}/js/jquery.min.js"></script>
			<script  type="text/javascript" charset="utf-8">
				(function(){

					


					initNavBar();//左边菜单栏

					customWindow();//自定义弹窗封装对象






					function initNavBar(){
						//左边菜单栏
						$(".nav>ul>li>a").click(function(e){

							console.info($(this).attr("href"));
							

							//e.preventDefault();
							
							var $ul = $(this).siblings("ul");
							//高亮切换
							if(!$(this).hasClass("active")){
								$(this).addClass("active").parent().siblings().find("a").removeClass("active");
							}
							
							if($ul.is(":visible")){
								$ul.slideUp();
							}else{
								//判断ul元素是否存在于页面中
								if($ul.length>0){
									$ul.slideDown().parent("li").siblings().find("ul").slideUp();
								}else{
									$(this).parent("li").siblings().find("ul").slideUp();
								}
							}
							
							if($(this).attr("href")!="#"){
								$(".pageUrl").each(function(){
									$(this).removeClass("active");
								});
								
								return true;
							}else{
								e.preventDefault();
							}
						});
					}
					

					//自定义弹框
					function customWindow(){
						//弹框
						 (function(window){
						
							//组件 三种显示方式
							window.myDialog = {
								zindex:100,
								alert:function(options){
									var $dialog = this.init(options);
									$dialog.find(".cancle").remove();
								},
								sure:function(options){
									var $dialog = this.init(options);
									$dialog.find(".dialog-buttons").remove();
								},
								confirm:function(options){
									this.init(options);
								},
								//初始化
								init:function(options){
									this.zindex++;
									//对象的继承和覆盖，后面的对象覆盖前面相同属性的值，用户的优先级高于默认值
									var opts = $.extend({},window.myDialog.defaults,options);
									//弹窗初始化
									var $dialog = this.template(opts);
									//更改大下，颜色，位置
									//$dialog.width(opts.width).height(opts.height);
									$dialog.css({
										width:opts.width,
										height:opts.height,
										zIndex:this.zindex,
										background:opts.background
									}).next().css({
										zIndex:(this.zindex-1),
									});


									if(opts.autoHeight)$dialog.height("auto"); 
									//位置
									this.j_position($dialog,opts);
									//绑定窗口事件
									this.j_resize($dialog,opts);
									//拖拽
									if(opts.drag)this.drag($dialog);
									//触发事件初始化
									this.events($dialog,opts);
									return $dialog;
								},
								//定位居中
								j_position:function($dialog,opts){
									var left = (window.innerWidth - $dialog.width())/2;	
									var top = (window.innerHeight - $dialog.height())/2;
									$dialog.css({left:left,top:top});
									
								},
								//窗口改变失事改变位置
								j_resize:function($dialog,opts){
									var $this = this;
									$(window).resize(function(){//这里不用传参数吗？？？？？？
										$this.j_position($dialog,opts);
									});
								},
								//拖拽
								drag:function($dialog){
									$dialog.find(".dialog-title").mousedown(function(e){
										var ev = e || window.event;
										var x = ev.clientX - $dialog.offset().left;
										var y = ev.clientY - $dialog.offset().top;
										//窗口最大位置
										var xmax = window.innerWidth - $dialog.width();
										var ymax = window.innerHeight - $dialog.height();
										$(document).mousemove(function(e){
											var ev = e || window.event;
											var l = ev.clientX - x;
											var t = ev.clientY - y;
											//边界的控制
											//左上角限制
											l = l<=0?0:l;
											t = t<=0?0:t;
											//右下角限制
											l = l>=xmax?xmax:l;
											t = t>=ymax?ymax:t;

											$dialog.css({left:l,top:t});
										}).mouseup(function(){
											$(document).off("mousemove");
											$(document).off("mouseup");
										});
									});
								},
								//触发按钮的事件和回调函数
								events:function($dialog,opts){
									//确定按钮
									$dialog.find(".sure").on("click",function(){
										if(opts.callback){
											opts.callback.call($dialog,true);
										}
										//移除阴影层
										$dialog.next().remove();
										//移除本身窗口
										$dialog.remove();
									});
									//取消按钮
									$dialog.find(".cancle,.close").on("click",function(){
										if(opts.callback){
											opts.callback.call($dialog,false);
											//加call把对象传出去，在外面直接操作对象，移除本身窗口和阴影层，也可以直接在这里完成操作，比如上面的确定按钮
										}
									});
									//点击阴影层关闭弹出层
									if(opts.overlayClose){
										$dialog.next().click(function(){
											$(this).remove();
											$dialog.remove();
										});
									}
								},
								//弹出层模板，皮肤
								template:function(opts){
									//alert(opts.height);
									//style='width:"+opts.width+"px;height:"+opts.height+"px;'
									var $dialog = $("<div class='dialog'>\
														<div class='dialog-title'>"+opts.title+"</div>\
														<a href='#' class='close' >×</a>\
														<div class='dialog-content'>\
															<div class='dialog-body'>"+opts.bodyContent+"</div>\
															<div class='dialog-buttons'>\
																<button class='btn sure'>确定</button>\
																<button class='btn cancle'>取消</button>\
															</div>\
														</div>\
													</div>");
									//追加到body中
									$("body").append($dialog).append("<div class='dialog-shadow'></div>");	
									return $dialog;//return出去加样式，改颜色等 
								}
							};
							
							//默认参数的初始化定义
							window.myDialog.defaults = {
								width:360,
								height:200,
								autoHeight:true,//自适应高度
								drag:true,//控制是否可以拖拽
								overlayClose:true,//默认点击阴影层关闭
								background:"#222",
								title:"删除提示",
								bodyContent:"你确定要删除吗？",
								callback:function(){
									
								}
							};
						})(window);				
					}


				})();
			</script>
		</body>
</html>