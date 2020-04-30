<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>用户注册</title>
	<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/css/style.css">
	<link rel="stylesheet" href="${path}/css/message.css">
	
</head>
<body>
<!-- 顶部导航  -->
	<%@ include file="../public/header.jspf" %>

	<div class="message center">
		<div class="container">

			
			
			
			<div class="row">
				<div class="col-lg-2 col-lg-offset-5  col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4 col-xs-4 col-xs-offset-4">
					
					<a href="#" class="thumbnail">
				      <img id="message_icon" src="${path}/image/error.jpg" class="img-rounded">
				    </a>
				</div>
			</div>


			<div class="row message_row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-10 col-xs-offset-1">
					<h3>可能是你打开的方式不对，页面出现了错误</h3>
					<h3>页面将在3秒后跳回首页</h3>
				</div>
			</div>


		</div>  <!-- container -->
	</div>
	

	<div class="footer">
		<div class="container">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<p>企业培训 | 合作事宜 | 版权投诉</p>
				<p>© 2017 拍拍网. Powered by paipaiwang.net</p>
			</div>
		</div>
	</div>


	




	<!-- Small modal   登录模态框
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button>
-->

	<div class="modal  fade bs-example-modal-sm" tabindex="-1" id="login_window" role="dialog" aria-labelledby="mySmallModalLabel">
	  <div class="modal-dialog modal-sm" role="document">
	    <div class="modal-content">

	    	<button type="button" id="close_login_window" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		
	        <h3><span class="glyphicon glyphicon-user"></span></h3>
	        <div class="login_window_line"><input type="text" class="form-control" placeholder="用户名/手机"></div>
	        <div class="login_window_line"><input type="password" class="form-control" placeholder="密码"></div>

			<div class="login_window_line find_pwd">
				<div class="checkbox" id="remember_account">
			        <label>
			          <input type="checkbox"> 记住用户名
			        </label>
			    </div>

			    <a href="#">找回密码</a>
			</div>
			<div class="login_window_line">
				<button id="login_button_submit" type="button" class="btn  btn-block">登录</button>
			</div>
	    </div>
	  </div>
	</div>


		


	<script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/util.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>