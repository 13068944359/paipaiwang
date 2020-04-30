<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>个人中心</title>
	<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/css/ladda-themeless.min.css">
	<link rel="stylesheet" href="${path}/css/style.css">
	<link rel="stylesheet" href="${path}/css/personCenter.css">
	
</head>
<body>

	<!-- 顶部导航  -->
	<%@ include file="../public/header.jspf" %>

	


	<div class="personCenter center">
		<div class="container">

			
			
			
			<div class="row">
				<div class="col-lg-8 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
					<p class="page_title">我的资料</p>
				</div>
			</div>
			


			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<p>用户名：</p>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<p>${user.username }</p>
				</div>
			</div>
			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<p>性别：</p>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<p>
						<c:if test="${user.gender == 0}">女</c:if>
						<c:if test="${user.gender == 1}">男</c:if>
					</p>
				</div>
			</div>

			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<p>手机号：</p>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<p>${user.mobiphone }</p>
				</div>
			</div>
			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<p>Email：</p>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<p>${user.email }</p>
				</div>
			</div>
			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<p>收货地址：</p>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<p>${user.address }</p>
				</div>
			</div>
			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<p>邮政编码：</p>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<p>${user.postcode }</p>
				</div>
			</div>
			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<p>真实姓名：</p>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<p>${user.realname }</p>
				</div>
			</div>
			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<p>身份证号：</p>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<p>${user.idcard }</p>
				</div>
			</div>
			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<!-- <p>我的余额</p> -->
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<div class="btn-group" role="group" aria-label="...">
					  <button type="button" class="btn btn-default" data-toggle="modal" data-target="#edit_message_window">修改资料</button>
					  <button type="button" class="btn btn-default" data-toggle="modal" data-target="#edit_password_window">修改密码</button>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-lg-8 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
					<p class="page_title">我的拍拍钱包</p>
				</div>
			</div>

			<!-- <div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<p>冻结金额：</p>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<p>5000元</p>
				</div>
			</div> -->
			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<p>我的余额</p>
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<p>${user.userMoney }元</p>
				</div>
			</div>

			<div class="row message_row">
				<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
					<!-- <p>我的余额</p> -->
				</div>
				<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<div class="btn-group" role="group" aria-label="...">
					  <button type="button" class="btn btn-default" data-toggle="modal" data-target="#charge_money_window">余额充值</button>
					</div>
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


	



	
	<!-- Large modal -->
	<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#regist_window">Large modal</button> -->

	<div class="modal fade" id="edit_message_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">修改个人信息</h4>
	      </div>
	      <div class="modal-body">

	        <div class="row">
	          <div class="col-md-3 center_window_key"><p>用户名：</p></div>
	          <div class="col-md-5"><input type="text" class="form-control" id="edit_username" name="realname" value="${user.username }"></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3 center_window_key"><p>性别：</p></div>
	          <div class="col-md-4">
	          		<label class="radio-inline">
					  <input type="radio" name="inlineRadioOptions" <c:if test="${user.gender == 1 }">checked</c:if> id="inlineRadio1" value="option1" > 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="inlineRadioOptions" <c:if test="${user.gender == 0 }">checked</c:if> id="inlineRadio2" value="option2"> 女
					</label>
	          </div>
	        </div>
	        <div class="row">
	          <div class="col-md-3 center_window_key"><p>Email：</p></div>
	          <div class="col-md-5"><input type="text" id="edit_email" class="form-control" name="email" value="${user.email }"></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3 center_window_key"><p>收获地址：</p></div>
	          <div class="col-md-9"><input type="text" id="edit_address" class="form-control" name="address" value="${user.address }"></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3 center_window_key"><p>邮政编码：</p></div>
	          <div class="col-md-3"><input type="text" id="edit_postcode" class="form-control" name="postcode" value="${user.postcode }"></div>
	        </div>
	       
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-success ladda-button" data-style="slide-left" id="change_person_message_btn">保&nbsp;存</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->


	<div class="modal fade" id="edit_password_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">修改密码</h4>
	      </div>
	      <div class="modal-body">

	        <div class="row">
	          <div class="col-md-3 center_window_key"><p>原密码：</p></div>
	          <div class="col-md-5"><input type="password" id="oldpwd" class="form-control" name="realname"></div>
	        </div>
	         <div class="row">
	          <div class="col-md-3 center_window_key"><p>新密码：</p></div>
	          <div class="col-md-5"><input type="password" id="newpwd" class="form-control" name="realname"></div>
	        </div>
	         <div class="row">
	          <div class="col-md-3 center_window_key"><p>确认密码：</p></div>
	          <div class="col-md-5"><input type="password" id="newpwd2" class="form-control" name="realname"></div>
	        </div>
	       
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary ladda-button" data-style="slide-left" id="change_password_btn">修&nbsp;改</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

	<!-- 余额充值 -->
	<div class="modal fade" id="charge_money_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">余额充值</h4>
	      </div>
	      <div class="modal-body">

	        <div class="row">
	          <div class="col-md-3 center_window_key"><p>充值金额：</p></div>
	          <div class="col-md-5"><input type="text" class="form-control" name="realname"></div>
	        </div>
	        
	       
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary ladda-button" data-style="slide-left" id="charge_money_btn">充&nbsp;值</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	

	<script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/spin.min.js"></script>
	<script src="${path}/js/ladda.min.js"></script>
	<script src="${path}/js/util.js"></script>
	<script type="text/javascript">
		$(function () {



			change_person_message_btn();//修改资料提交按钮监听
			change_password_btn();//修改密码提交按钮监听
			charge_money_btn();//余额充值提交按钮监听




			
			//余额充值提交按钮监听
			function charge_money_btn(){
				var l_charge_money_btn = Ladda.create( document.querySelector( '#charge_money_btn' ) );
				$("#charge_money_btn").click(function(){
					
					l_charge_money_btn.start();
				});
			}

			//修改密码提交按钮监听
			function change_password_btn(){
				$("#change_password_btn").click(function(){
					var l_change_password_btn = Ladda.create( document.querySelector( '#change_password_btn' ) );
					l_change_password_btn.start();
					
					var postdata = {
							"oldpwd":$.trim($("#oldpwd").val()),
							"newpwd":$.trim($("#newpwd").val()),
							"newpwd2":$.trim($("#newpwd2").val())
						};
					
					$.ajax({
						url:rootPath+"/user/changePwd",
						type: 'POST',  
						data:postdata,
						dataType:"JSON",
						async:true,
						success:function(data){
							l_change_password_btn.stop();
							if(data.result == "ok"){
								location.replace(location.href);
							}else if(data.result == "error"){
								$("#oldpwd").val("");
								$("#newpwd").val("");
								$("#newpwd2").val("");
								$("#oldpwd").attr("placeholder","原密码错误");
							}else if(data.result == "error patteen"){
								$("#oldpwd").val("");
								$("#newpwd").val("");
								$("#newpwd2").val("");
								$("#newpwd").attr("placeholder","密码格式只能是6-18位英文和数字组成");
							}else if(data.result == "not equal"){
								$("#oldpwd").val("");
								$("#newpwd").val("");
								$("#newpwd2").val("");
								$("#newpwd").attr("placeholder","两次输入的新密码不一致");
							}else{
								console.info("error");
								alert(data);
								console.info(data);
								location.replace(rootPath+"page/message");	
							}
						},
						error:function(data){		alert("error");		},
					});
					
					
					
				});
			}

			//修改资料提交按钮监听
			function change_person_message_btn(){
				$("#change_person_message_btn").attr("disabled",true);//首先是不可点击
				
				$("#change_person_message_btn").click(function(){
					var l_change_person_message_btn = Ladda.create( document.querySelector( '#change_person_message_btn' ) );
					l_change_person_message_btn.start();
					
					var gender = false;
					if($("#inlineRadio1").attr("checked")){
						gender = true;
					}
					
					var postdata = {
							"username":$.trim($("#edit_username").val()),
							"gender":gender,
							"email":$.trim($("#edit_email").val()),
							"address":$.trim($("#edit_address").val()),
							"postcode":$.trim($("#edit_postcode").val())
						};
					
					$.ajax({
						url:rootPath+"/user/editUser",
						type: 'POST',  
						data:postdata,
						dataType:"JSON",
						async:true,
						success:function(data){
							if(data.result == "ok"){
								location.replace(location.href);		
							}else{
								console.info(data);
								alert(1);
								location.replace(rootPath+"page/message");		
							}
						},
						error:function(data){		alert("error");		},
					});
					
				});
				
				//真实姓名的长度不能超过6
				$("#edit_username").keyup(function(){
					//最长不给超过6
					if($("#edit_username").val().length >= 7){
						$("#edit_username").val( $("#edit_username").val().substring( 0 , $("#edit_username").val().length-1 ) );
						return false;
					}
					input_null_check();//检测是否有输入框为空，如果有则按钮不予点击
				});
				
				
				//检测是否有输入框为空，如果有则按钮不予点击
				function input_null_check(){
					console.info("check");
					if($.trim($("#edit_username").val()) == "" || $.trim($("#edit_address").val()) == "" 
							|| $.trim($("#edit_email").val()) == "" || $.trim($("#edit_postcode").val()) == ""  ){
						$("#change_person_message_btn").attr("disabled",true);
					}else{
						$("#change_person_message_btn").attr("disabled",false);
					}
				}
			}
		});
	</script>
</body>
</html>