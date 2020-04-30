<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户详细信息</title>
		<style type="text/css">
			* {	margin: 0px;padding: 0px;	}

			.center_table{
				width:600px; 
				margin:50px auto;
				text-align: center;
			}
			.center_table th,.center_table td{
				padding:10px;
			}
			.center_table .title{
				width:100px;
			}
			.center_table img{
				width:400px;
			}

			
			/*顶部的位置栏*/
			.location{width:100%;height:51px;border-bottom:1px solid #ccc;background:#e5e5e5;position:relative;line-height:51px;}.location i{display:block;width:14px;height:18px;background:url("${path}/image/ht_icon.png") no-repeat;float:left;margin:16px 20px 0 20px;background-position:-16px -51px;}.location .search_bar{position:absolute;right:5px;top:0px;padding:0px;height:30px;}.location .search_bar #search_key_word{height:30px;width:200px;text-align:center;}.location .search_bar #search_btn{height:34px;width:50px;cursor:pointer;}
			/*小组件样式*/
			.tips-success,.tips-fail,.tips-warning{min-width:240px;height:40px;position:absolute;left:calc(50% - 100px);background:#fff;opacity:0;}.tips-success .icon-box{max-width:20%;height:100%;background:green;float:left;}.tips-success .icon-box .icon{background:url(${path}/image/ht_icon.png) no-repeat -172px -48px;}.tips-fail .icon-box{max-width:20%;height:100%;background:red;float:left;}.tips-warning .icon-box{max-width:20%;height:100%;background:orange;float:left;}.icon-box .icon{width:18px;height:18px;display:inline-block;margin:10px;}.tips-fail .icon-box .icon,.tips-warning .icon-box .icon{background:url(${path}/image/ht_icon.png) no-repeat -10px -132px;}.tips-success .text,.tips-fail .text,.tips-warning .text{min-width:80%;height:100%;float:left;font-weight:bold;text-align:center;line-height:40px;}.move{animation:4s jian;}@-webkit-keyframes jian{0%{top:0;opacity:0}20%{top:100px;opacity:1}90%{top:100px;opacity:.8}100%{top:100px;opacity:0;}}
			a{text-decoration:none;}.shadow{width:100%;height:100%;position:fixed;top:0;left:0;z-index:10;background:rgba(0,0,0,.4);}.loading{width:80px;height:80px;border-radius:5px;background:rgba(0,0,0,.8);position:absolute;top:calc(50% - 40px);left:calc(50% - 40px);text-align:center;line-height:100px;}.dialog{background:#222;position:fixed;overflow:hidden;color:#fff;font-size:14px;z-index:11;border-radius:6px;box-sizing:border-box;}.dialog-title{width:100%;height:45px;line-height:45px;padding-left:10px;font-weight:bold;cursor:move;border-bottom:1px solid #333;}.dialog .close{color:#fff;font-size:22px;padding:0 5px;position:absolute;right:8px;top:8px;transition:all 0.3s ease;opacity:0;}.dialog:hover .close{transition:all .3s ease;opacity:1;transform:rotate(360deg);}.dialog .dialog-content{width:100%;height:100%;}.dialog-content .dialog-body{padding:46px 0;text-align:center;}.dialog-content .dialog-buttons{border-top:1px solid #333;padding:10px;text-align:center;}.dialog-content .btn{margin-left:10px;padding:4px 12px;border:none;cursor:pointer;border-radius:2px;}.dialog-content .btn:hover{background:#aaa;}.dialog-shadow{width:100%;height:100%;background-color:#111;position:fixed;top:0;left:0;z-index:10;filter:alpha(opacity=58);-moz-opacity:0.58;-khtml-opacity:0.58;opacity:0.58;}
		
		</style>
	</head>
	<body>
		<div class="location">
			<i></i>
			<p>商品管理 > 商品审核</p>
		</div>
		
		<table border="1px" bordercolor="#cccccc" cellspacing="0px" cellpadding="0px" class="center_table">
   			<tr>
				<td class="title">商品ID</td>
				<td>${itemDetail.id}</td>
			</tr>
			<tr>
				<td>发布者</td>
				<td>${itemDetail.owner}</td>
			</tr>
			<tr>
				<td>商品名称</td>
				<td>${itemDetail.name}</td>
			</tr>
			<tr>
				<td>商品简介</td>
				<td>${itemDetail.brief}</td>
			</tr>
			<tr>
				<td>商品种类</td>
				<td>${itemDetail.type}</td>
			</tr>
			<tr>
				<td>身份数量</td>
				<td>${itemDetail.number}</td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td>${itemDetail.price}</td>
			</tr>
			<tr>
				<td>竞拍阶梯</td>
				<td>${itemDetail.priceAdd}</td>
			</tr>
			<tr>
				<td>发布时间</td>
				<td>
					<fmt:formatDate value="${itemDetail.publishTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
			<tr>
				<td>开始日期</td>
				<td>
					<fmt:formatDate value="${itemDetail.startDate}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td>
					<c:if test="${itemDetail.picture1 != null}">
						<div>
							<img src="${path}/picture/${itemDetail.picture1}">
						</div>
					</c:if>
					<c:if test="${itemDetail.picture2 != null}">
						<div>
							<img src="${path}/picture/${itemDetail.picture2}">
						</div>
					</c:if>
					<c:if test="${itemDetail.picture3 != null}">
						<div>
							<img src="${path}/picture/${itemDetail.picture3}">
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>鉴定证明</td>
				<td>
					<c:if test="${itemDetail.identifyPicture != null}">
						<div>
							<img src="${path}/picture/${itemDetail.identifyPicture}">
						</div>
					</c:if>
					<c:if test="${itemDetail.identifyPicture == null}">
						无
					</c:if>
				</td>
			</tr>
			<tr>
				<td>详细描述</td>
				<td>
					${itemDetail.itemDescription}
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${path}/item/admin_verifyItem?id=${itemDetail.id}&flag=true">审核通过</a>
					<a href="${path}/item/admin_verifyItem?id=${itemDetail.id}&flag=false">审核不通过</a>
				</td>
			</tr>
			
		</table>
		
		<script src="${path}/js/jquery.min.js"></script>
		<script type="text/javascript">
			(function(){
				//弹框
				(function(window){window.myDialog={zindex:100,alert:function(options){var $dialog=this.init(options);$dialog.find(".cancle").remove()},sure:function(options){var $dialog=this.init(options);$dialog.find(".dialog-buttons").remove()},confirm:function(options){this.init(options)},init:function(options){this.zindex++;var opts=$.extend({},window.myDialog.defaults,options);var $dialog=this.template(opts);$dialog.css({width:opts.width,height:opts.height,zIndex:this.zindex,background:opts.background}).next().css({zIndex:(this.zindex-1),});if(opts.autoHeight)$dialog.height("auto");this.j_position($dialog,opts);this.j_resize($dialog,opts);if(opts.drag)this.drag($dialog);this.events($dialog,opts);return $dialog},j_position:function($dialog,opts){var left=(window.innerWidth-$dialog.width())/2;var top=(window.innerHeight-$dialog.height())/2;$dialog.css({left:left,top:top})},j_resize:function($dialog,opts){var $this=this;$(window).resize(function(){$this.j_position($dialog,opts)})},drag:function($dialog){$dialog.find(".dialog-title").mousedown(function(e){var ev=e||window.event;var x=ev.clientX-$dialog.offset().left;var y=ev.clientY-$dialog.offset().top;var xmax=window.innerWidth-$dialog.width();var ymax=window.innerHeight-$dialog.height();$(document).mousemove(function(e){var ev=e||window.event;var l=ev.clientX-x;var t=ev.clientY-y;l=l<=0?0:l;t=t<=0?0:t;l=l>=xmax?xmax:l;t=t>=ymax?ymax:t;$dialog.css({left:l,top:t})}).mouseup(function(){$(document).off("mousemove");$(document).off("mouseup")})})},events:function($dialog,opts){$dialog.find(".sure").on("click",function(){if(opts.callback){opts.callback.call($dialog,true)}$dialog.next().remove();$dialog.remove()});$dialog.find(".cancle,.close").on("click",function(){if(opts.callback){opts.callback.call($dialog,false)}});if(opts.overlayClose){$dialog.next().click(function(){$(this).remove();$dialog.remove()})}},template:function(opts){var $dialog=$("<div class='dialog'>												<div class='dialog-title'>"+opts.title+"</div>												<a href='#' class='close' >×</a>												<div class='dialog-content'>													<div class='dialog-body'>"+opts.bodyContent+"</div>													<div class='dialog-buttons'>														<button class='btn sure'>确定</button>														<button class='btn cancle'>取消</button>													</div>												</div>											</div>");$("body").append($dialog).append("<div class='dialog-shadow'></div>");return $dialog}};window.myDialog.defaults={width:360,height:200,autoHeight:true,drag:true,overlayClose:true,background:"#222",title:"删除提示",bodyContent:"您确定要重置密码吗？<br/>（将把密码重置成“paipaiwang”）",callback:function(){}}})(window);
				
				
				
				
				
				var resetPWDUrl;
				$("#resetPWDUrl").click(function(){
					resetPWDUrl = $(this).attr("href");
					
					//模拟浏览器中的confirm弹窗
					myDialog.confirm({
						//回调函数处理相关操作,比如ajax
						callback:function(mark){
							if(mark){
								window.location.href=resetPWDUrl;
							}else{
								//alert("关闭/取消");
								this.next().remove();
								this.remove();
							}
						}
					});
					
					return false;
				});
			})();
		</script>
	</body>
</html>


