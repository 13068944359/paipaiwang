<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login</title>
		<style type="text/css">
* {
	margin:0;
	padding:0
}
body {
	color:#ccc;
	font-size:14px
}
#cas {
	position:fixed;
	top:0;
	left:0;
	z-index:-100
}
#login {
	width:360px;
	height:300px;
	position:absolute;
	top:50%;
	left:50%;
	margin-left:-180px;
	margin-top:-150px
}
.login-title p {
	height:40px;
	line-height:40px;
	text-align:center;
	font-family:pbfont
}
.login-title p span {
	display:inline-block
}
.login-title p span:nth-child(1) {
	font-size:36px;
	color:#d01616;
	transform:rotate(-10deg)
}
.login-title p span:nth-child(2) {
	font-size:25px;
	color:#8bc34a
}
.login-title p span:nth-child(3) {
	font-size:30px;
	color:#fce83b;
	transform:rotate(5deg)
}
.login-title p span:nth-child(4) {
	font-size:22px;
	color:#6acffd;
	transform:rotate(-8deg)
}
.login-title p span:nth-child(5) {
	font-size:34px;
	color:#f44336
}
.login-title p span:nth-child(6) {
	font-size:27px;
	color:#00bcd4;
	transform:rotate(18deg)
}
.login-title p span:nth-child(7) {
	font-size:27px;
	color:pink;
	transform:rotate(0deg)
}
.login-title p span:nth-child(8) {
	font-size:27px;
	color:green;
	transform:rotate(-18deg)
}
#loginBox {
	padding:50px 40px
}
.login-null {
	text-align:center;
	color:#f33;
	height:20px;
	line-height:20px;
	background:none;
}
.login-d {
	width:20pc
}
.login-d input {
	width:300px;
	height:44px;
	background:#666;
	outline:0;
	border:none;
	margin-bottom:10px;
	line-height:44px;
	color:#fff;
	padding-left:10px;
	border-top:1px solid rgba(33,33,33,.5)
}
#code {
	width:130px;
	display:inline-block
}
#validate img {
	width:75pt;
	height:44px;
	vertical-align:middle
}
#changeCode {
	color:#000
}
.login-d:first-child input {
	border-top:none
}
#submit {
	width:310px;
	display:block;
	height:44px;
	line-height:44px;
	text-align:center;
	border-radius:3px;
	background:rgba(0,0,0,.5);
	text-decoration:none;
	color:#fff;
	font-size:1pc;
	font-weight:600
}
#submit:hover {
	background:rgba(0,0,0,.7);
	color:orange
}
#title {
	animation:jian1 .5s
}
#uname {
	animation:jian2 .5s
}
#psw {
	animation:jian3 .5s
}
#sub {
	animation:jian4 .5s
}
#validate {
	animation:jian5 .5s
}
@-webkit-keyframes jian1 {
	0% {
	transform:translateY(-300px) rotate(-90deg)
}
60% {
	transform:translateY(0px)
}
80% {
	transform:translateY(-20px)
}
to {
	transform:translateY(0px) rotate(0deg)
}
}@-webkit-keyframes jian2 {
	0% {
	transform:translateX(-400px)
}
60% {
	transform:translateX(30px) rotate(-20deg)
}
80% {
	transform:translateX(-10px)
}
to {
	transform:translateX(0px) rotate(0deg)
}
}@-webkit-keyframes jian3 {
	0% {
	transform:translateX(500px)
}
60% {
	transform:translateX(-30px) rotate(-20deg)
}
80% {
	transform:translateX(10px)
}
to {
	transform:translateX(0px) rotate(0deg)
}
}@-webkit-keyframes jian4 {
	0% {
	transform:translateY(500px) rotate(-270deg)
}
60% {
	transform:translateY(-20px)
}
80% {
	transform:translateY(10px)
}
to {
	transform:translateY(0px) rotate(0deg)
}
}@-webkit-keyframes jian5 {
	0% {
	transform:translateX(-400px)
}
60% {
	transform:translateX(30px) rotate(-20deg)
}
80% {
	transform:translateX(-10px)
}
to {
	transform:translateX(0px) rotate(0deg)
}
}

		</style>
	</head>
	<body>
		<!-- <canvas id="cas"></canvas> -->
		<div id="login">
			<div class="login-title" id="title">
				<p>
					<span>后</span>
					<span>台</span>
					<span>管</span>
					<span>理</span>
					<span>系</span>
					<span>统</span>
					<span>登</span>
					<span>录</span>
				</p>
			</div>
			<div id="loginBox">
				<form action="${path}/admin/login" method="POST">
					<div class="login-d" id="uname">
						<input type="text" name="username" id="username" placeholder="请输入账号"/>
					</div>
					<div class="login-d" id="psw">
						<input type="password" name="password" id="password" placeholder="请输入密码"/>
					</div>
					<div class="login-d" id="validate">
						<input type="text" name="verifyCode" id="code" placeholder="请输入验证码"/>
						<img alt="验证码" src="${path}/admin/getVerifyPicture" id="verifyPicture">
						<a href="#" id="changeVerifyPicture">换一张</a>
					</div>
					<div class="login-null">
						${loginMessage}
					</div>
					<div class="login-d" id="sub">
						<a href="javascript:void(0)" id="submit">登录</a>
					</div>
				</form>
			</div>
		</div>
		<script src="${path}/js/jquery.min.js"></script>
		<script type="text/javascript">
			$(function(){
				
				
				parentWindow();
				changePictureClick();//点击更换验证码
				submitClick();//点击登录按钮
				
				
				
				//判断是否存在父窗口，如果存在，则需要重定向
				function parentWindow(){
					if(self!=top){
						window.parent.location.href="${path}/admin/loginPage";
					}
				}
				
				//点击登录按钮
				function submitClick(){
					$("#submit").click(function(){
						var form = document.forms[0];
						console.info(form);
						form.submit();
					});
				}
				
				
				//点击更换验证码
				function changePictureClick(){
					$("#changeVerifyPicture").click(function(){
						console.info("change");
						$("#verifyPicture").attr("src","${path}/admin/getVerifyPicture?time="+new Date().getTime());
					});
				}
				
				
				
				
				
			});
		</script>
	</body>
</html>
