<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改广告位</title>
		<style type="text/css">
			* {	margin: 0px;padding: 0px;	}


			.center_table{
				width:90%; 
				margin:50px auto 20px;
				text-align: center;
			}
			.center_table th,.center_table td{
				height: 30px;
				line-height:24px;
				padding:10px;
			}
			input{
				width:50%;
				height:24px;
				margin:10px 0px;
			}
			#preview{
				display:block;
				width:70%;
				margin:10px auto;				
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
			<p>修改管理员信息</p>
		</div>
		
		<form action="${path}/adv/admin_updateAdv" method="POST" enctype="multipart/form-data">
			<table border="1px" bordercolor="#cccccc" cellspacing="0px" cellpadding="0px" class="center_table">
	   			<tr>
					<td>用户名</td>
					<td>
						${requestScope.adv.id}
					</td>
				</tr>
				<tr>
					<td>图片</td>
					<td>
						<input type="file" name="picture" id="picture" /><input type="hidden" name="id" value="${requestScope.adv.id}" />
					</td>
				</tr>
				<tr>
					<td>标题</td>
					<td>
						<input type="text" name="title" />
					</td>
				</tr>
				<tr>
					<td>链接</td>
					<td>
						<input type="text" name="url" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input class="input" type="submit" value="提交" />
					</td>
				</tr>
			</table>
		</form>
		<img alt="" id="preview" >
		
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
				
				
				$("#picture").change(function(){
					change();
				});
				
				function change() {
				    var pic = document.getElementById("preview"),
				        file = document.getElementById("picture");

				    var ext=file.value.substring(file.value.lastIndexOf(".")+1).toLowerCase();

				    /*  // gif在IE浏览器暂时无法显示
				     if(ext!='png'&&ext!='jpg'&&ext!='jpeg'){
				         //alert("图片的格式必须为png或者jpg或者jpeg格式！"); 
				         return;
				     } */
				     if(ext!='jpg'){
				         //alert("图片的格式必须为png或者jpg或者jpeg格式！"); 
				         $("body").append('<div class="tips-fail move">'+
								'<div class="icon-box">'+
								'	<span class="icon"></span>'+
								'</div>'+
								'<div class="text">请上传jpg格式的图片！</div>'+
							'</div>');
				         $("#picture").val("");
				         return;
				     }
				     
				     
				     var isIE = navigator.userAgent.match(/MSIE/)!= null,
				         isIE6 = navigator.userAgent.match(/MSIE 6.0/)!= null;

				     if(isIE) {
				        file.select();
				        var reallocalpath = document.selection.createRange().text;

				        // IE6浏览器设置img的src为本地路径可以直接显示图片
				         if (isIE6) {
				            pic.src = reallocalpath;
				         }else {
				            // 非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现
				             pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
				             // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
				             pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
				         }
				     }else {
				        html5Reader(file);
				     }
				}
				
				function html5Reader(file){
				     var file = file.files[0];
				     var reader = new FileReader();
				     reader.readAsDataURL(file);
				     reader.onload = function(e){
				         var pic = document.getElementById("preview");
				         pic.src=this.result;
				     }
				 }
				
				
			})();
		</script>
	</body>
</html>


