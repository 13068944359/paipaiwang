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
	<link rel="stylesheet" href="${path}/css/ladda-themeless.min.css">
	<link rel="stylesheet" href="${path}/css/style.css">
	<link rel="stylesheet" href="${path}/css/regist.css">
	
</head>
<body>

	<!-- 顶部导航  -->
	<%@ include file="../public/header.jspf" %>



	<div class="regist center">
		<div class="container">

			
			
			
			<div class="row">
				<div class="col-lg-8 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
					<p class="page_title">新用户注册</p>
				</div>
			</div>


			<div class="row regist_row">
				<div class="col-lg-4 col-lg-offset-2 col-md-5 col-md-offset-1 col-sm-6 col-sm-offset-1">
					<div class="input-group  has_error_item_name">
					  <span class="input-group-addon" id="sizing-addon2">手机号码：</span>
					  <input type="text" id="input_phone" class="form-control" placeholder="" aria-describedby="sizing-addon2">
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4">
					<p class="regist_tip text-success phone_success display_none"><span class="glyphicon glyphicon-ok"></span></p>
					<p class="regist_tip text-danger phone_fail display_none"><span class="glyphicon glyphicon-remove"></span>手机号码错误</p>
					<p class="regist_tip text-danger phone_existed display_none"><span class="glyphicon glyphicon-remove"></span>手机号码已被注册</p>
				</div>
			</div>
		
			
			<div class="row regist_row">
				<div class="col-lg-4 col-lg-offset-2 col-md-5 col-md-offset-1 col-sm-6 col-sm-offset-1">
					<div class="input-group  has_error_item_name">
					  <span class="input-group-addon" id="sizing-addon2">用户名：</span>
					  <input type="text" id="input_name" class="form-control" placeholder="" aria-describedby="sizing-addon2">
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4">
					<p class="regist_tip text-success name_success display_none"><span class="glyphicon glyphicon-ok"></span></p>
					<p class="regist_tip text-danger name_fail display_none"><span class="glyphicon glyphicon-remove"></span>用户名长度不能超过8位</p>
				</div>
			</div>
			

			<div class="row regist_row">
				<div class="col-lg-4 col-lg-offset-2 col-md-5 col-md-offset-1 col-sm-6 col-sm-offset-1">
					<div class="input-group  has_error_item_name">
					  <span class="input-group-addon" id="sizing-addon2">账户密码：</span>
					  <input type="password" id="input_pwd" class="form-control" placeholder="" aria-describedby="sizing-addon2">
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-4">
					<p class="regist_tip text-success pwd_success display_none"><span class="glyphicon glyphicon-ok"></span></p>
					<p class="regist_tip text-danger pwd_fail display_none"><span class="glyphicon glyphicon-remove"></span>密码必须是6-18位的英文和数字组成</p>
				</div>
			</div>


			<div class="row regist_row">
				<div class="col-lg-4 col-lg-offset-2 col-md-5 col-md-offset-1 col-sm-6 col-sm-offset-1">
					<div class="input-group  has_error_item_name">
					  <span class="input-group-addon" id="sizing-addon2">确认密码：</span>
					  <input type="password" id="input_pwd2" class="form-control" placeholder="" aria-describedby="sizing-addon2">
					</div>
				</div>
				<div class="col-lg-4 col-md-4 col-sm-4">
					<p class="regist_tip text-success pwd2_success display_none"><span class="glyphicon glyphicon-ok"></span></p>
					<p class="regist_tip text-danger pwd2_fail display_none""><span class="glyphicon glyphicon-remove"></span>两次输入密码不一致</p>
				</div>
			</div>


			<div class="row regist_row">
				<div class="col-lg-4 col-lg-offset-2 col-md-5 col-md-offset-1 col-sm-6 col-sm-offset-1">
					<div class="input-group  has_error_item_name">
					  <span class="input-group-addon" id="sizing-addon2">手机验证码：</span>
					  <input type="text" id="input_verify" class="form-control" placeholder="" aria-describedby="sizing-addon2">
					</div>
				</div>
				<!-- <div class="col-lg-4 col-md-4 col-sm-4">
					<p class="regist_tip text-danger"><span class="glyphicon glyphicon-remove"></span>验证码错误</p>
				</div> -->

				<div class="col-lg-2 col-md-2 col-sm-2">
					<button id="phone_check_num_btn" type="button" class="btn btn-primary ladda-button" data-style="slide-left">获取手机验证码</button>
				</div>
					

			</div>

			<div class="row regist_row">
				<div class="col-lg-4 col-lg-offset-3 col-md-5 col-md-offset-2 col-sm-6 col-sm-offset-2 col-xs-offset-2">
					<div class="form-group">
					      <div class="checkbox" id="check_rule_box">
					        <label>
					          <input type="checkbox" id="input_rule"> 我已查看并同意
					        </label>
					        <a href="${path}/page/auctionRule" target="_blank"  >《拍拍网拍卖规则》</a>
					      </div>
					</div>
				</div>
			</div>

			<div class="row regist_row regist_row_last ">
				<div class="col-lg-4 col-lg-offset-2 col-md-5 col-md-offset-1 col-sm-6 col-sm-offset-1">
					<button type="button" class="btn btn-primary btn-block ladda-button" data-style="slide-left" id="regist_submit_btn">提 交</button>
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


	
	<!-- 登录窗口  -->
	<%@ include file="../public/loginWindow.jspf" %>
	






	<!-- 注册信息完善模态框 -->
	<!-- Large modal -->
	<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#regist_window">Large modal</button> -->

	<div class="modal fade" id="regist_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
	        <h4 class="modal-title" id="gridSystemModalLabel">完善注册信息</h4>
	      </div>
	      <div class="modal-body">
	        <div class="row">
	          <div class="col-md-3 regist_window_key"><p>真实姓名：</p></div>
	          <div class="col-md-4"><input type="text" id="realname" class="form-control" name="realname"></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3 regist_window_key"><p>身份证件号码：</p></div>
	          <div class="col-md-6 col-lg-6"><input type="text" id="idcard" class="form-control" name="idcard"></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3 regist_window_key"><p>性别：</p></div>
	          <div class="col-md-4">
	          		<label class="radio-inline">
					  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1" checked> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 女
					</label>
	          </div>
	        </div>
	        <div class="row">
	          <div class="col-md-3 regist_window_key"><p>Email：</p></div>
	          <div class="col-md-4"><input type="text" id="email" class="form-control" name="email"></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3 regist_window_key"><p>配送地址：</p></div>
	          <div class="col-md-9"><input type="text" id="address" class="form-control" name="address"></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3 regist_window_key"><p>邮政编码：</p></div>
	          <div class="col-md-3"><input type="text" id="postcode" class="form-control" name="postcode"></div>
	        </div>
	       
	      </div>
	      <div class="modal-footer">
	        <button type="button" id="cancel_finish_regist_btn" class="btn btn-danger" >取消</button>
	        <button type="button" id="finish_regist_btn" class="btn btn-success ladda-button" data-style="slide-left">完成</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->


		


	<script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/spin.min.js"></script>
	<script src="${path}/js/ladda.min.js"></script>
	<script src="${path}/js/util.js"></script>
	<script src="${path}/js/regist.js"></script>
	<script type="text/javascript">
		


	</script>
</body>
</html>