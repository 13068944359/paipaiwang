<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户管理</title>
		<style type="text/css">
			* {margin:0px;padding:0px;}
			.center_table {
				width:90%;
				margin:50px auto 20px;
				text-align:center;
			}
			.center_table th,.center_table td {				height:30px;			}
			.page_bar {
				height:40px;
				width:90%;
				margin:0px auto;
				text-align:center;
				line-height:40px;
				padding:0px;
			}
			.page_bar a {
				display:inline-block;
				height:100%;
				width:35%;
				color:#000;
				text-decoration:none;
			}
			.page_bar a:hover {
				background:#4bb;
				color:#fff;
			}
			.page_bar span {
				display:inline-block;
				height:100%;
				width:20%;
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
			<p>用户管理</p>
			<div class="search_bar">
				<input id="search_key_word" type="text" name="search_key_word" placeholder="请输入关键字"><input id="search_btn" type="submit" value="搜索">
			</div>
		</div>
		
		
		<table border="1px" bordercolor="#cccccc" cellspacing="0px" cellpadding="0px" class="center_table">
			<tr>
				<th>用户id</th>
				<th>用户名</th>
				<th>手机号</th>
				<th>邮箱</th>
				<th>身份证号</th>
				<th>真实姓名</th>
				<th>帐号状态</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pageMap.rows}" var="object">
    			<tr>
					<td>${object.id}</td>
					<td>${object.username}</td>
					<td>${object.mobiphone}</td>
					<td>${object.email}</td>
					<td>${object.idcard}</td>
					<td>${object.realname}</td>
					
					<c:if test="${object.freeze}">
						<td style="color:#f22;">冻结</td>
					</c:if>
					<c:if test="${!object.freeze}">
						<td>正常</td>
					</c:if>
					
					<td>
						<a href="${path}/user/admin_userDetail?id=${object.id}">详细/管理</a>
						<c:if test="${object.freeze}">
							<a href="${path}/user/admin_freezeUser?id=${object.id}&flag=false">激活帐号</a>
						</c:if>
						<c:if test="${!object.freeze}">
							<a href="${path}/user/admin_freezeUser?id=${object.id}&flag=true">冻结帐号</a>
						</c:if>
					</td>
				</tr>
    		</c:forEach>
			

		</table>

		<div class="page_bar">
			<a href="${path}/user/admin_getUserListPage?page=${requestScope.page.lastPage}&keyWord=${requestScope.page.keyWord}">上一页</a>
			<span>第${currentPage}页/共${totalPage}页</span>
			<a href="${path}/user/admin_getUserListPage?page=${requestScope.page.nextPage}&keyWord=${requestScope.page.keyWord}">下一页</a>
		</div>

		<script src="${path}/js/jquery.min.js"></script>
		<script type="text/javascript">
			(function(){
				
				$("#search_btn").click(function(){
					var keyWord = $("#search_key_word").val();
					keyWord = $.trim(keyWord);
					//只有当输入框中不为空的时候才进行搜索
					if(keyWord != ""){
						window.location.href="${path}/user/admin_getUserListPage?keyWord="+keyWord;
					}
				});
				
				
				
				//操作成功的提示信息
				<c:if test="${requestScope.successTip==true}" >
					setTimeout(function(){
						$("body").append('<div class="tips-success move">'+
								'<div class="icon-box">'+
								'	<span class="icon"></span>'+
								'</div>'+
								'<div class="text">操作成功！</div>'+
							'</div>');
					},500);
					
				</c:if>
				
			})();
		</script>
	</body>
</html>



