<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>商品详情</title>
	<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/css/ladda-themeless.min.css">
	<link rel="stylesheet" href="${path}/css/style.css">
	<link rel="stylesheet" href="${path}/css/itemPage.css">
	
</head>
<body>
<!-- 顶部导航  -->
	<%@ include file="../public/header.jspf" %>


	<div class="itemPage center">
		<div class="container">

			<div class="row search_row">
				<div class="col-lg-8 col-md-8 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-1 search">
					<div class="input-group">
				      <input type="text" class="form-control" id="search_frame" placeholder="请输入要搜索的商品">
				      <span class="input-group-btn">
				        <button class="btn btn-default" type="button" id="search_btn"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索</button>
				      </span>
				    </div>
				</div>
			</div>
			
			<div class="row nav_row">
				<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 col-md-offset-1 col-lg-offset-1">
					<ul class="nav nav-tabs">
					  <li role="presentation"><a href="#">首页</a></li>
					  <li role="presentation" class="dropdown">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">书<span class="hidden-md hidden-sm hidden-xs">法绘</span>画<span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					      <li><a href="#">绘画</a></li>
					      <li><a href="#">书法</a></li>
					      <li><a href="#">古籍文献</a></li>
					    </ul>
					  </li>
					  <li role="presentation" class="dropdown">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">西画雕塑<span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					      <li><a href="#">油画</a></li>
					      <li><a href="#">水彩</a></li>
					      <li><a href="#">雕塑</a></li>
					    </ul>
					  </li>
					  <li role="presentation" class="dropdown">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">古瓷珠宝<span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					      <li><a href="#">玉器</a></li>
					      <li><a href="#">陶瓷</a></li>
					      <li><a href="#">木器</a></li>
					    </ul>
					  </li>
					   <li role="presentation" class="dropdown">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">当代工艺<span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					      <li><a href="#">珠宝</a></li>
					      <li><a href="#">金属器</a></li>
					    </ul>
					  </li>
					  <li role="presentation"><a href="#"><span class="hidden-md hidden-sm hidden-xs">各类</span>杂货</a></li>
					  <li role="presentation"><a href="#">二手<span class="hidden-md hidden-sm hidden-xs">商品</span></a></li>
					  <li role="presentation" class="hidden-sm hidden-xs"><a href="#" id="nav_no">丨</a></li>

					  <li role="presentation"><a href="#">每日一拍</a></li>
					</ul>
				</div>
			</div>

			<div class="row">
				<div class="col-md-4 col-lg-4 col-sm-4 col-xs-12 col-md-offset-1 col-lg-offset-1">
					
					<img src="${path}/image/loading.gif" onerror="this.src='${path}/image/errorImg.jpg'" class="img-thumbnail item_picture" id="item_picture">
					<!-- <img src="${path}/image/loading.gif" alt="..." class="img-thumbnail item_picture" id="item_picture"> -->
				</div>
				<div class="col-md-6 col-lg-6 col-sm-8 col-xs-12 container inner_container">
					<div class="row">
						<h3 id="item_name">loading...</h3>
						<p id="item_brief">loading...</p>
					</div>

					

					<div class="row time_row">
						<div class="col-md-10 col-md-offset-1 col-lg-offset-1 col-xs-offset-1 col-sm-offset-1">
							<span id="startDate">开始日期：----/--/--</span>
						</div>
						<div class="col-md-10 col-md-offset-1 col-lg-offset-1 col-xs-offset-1 col-sm-offset-1">
							<span id="endDate">结束日期：----/--/--</span>
						</div>
						<div class="col-md-10 col-md-offset-1 col-lg-offset-1 col-xs-offset-1 col-sm-offset-1">
							<span id="leftTime">剩余时间：</span>
							<!-- <span>剩余时间：拍卖已结束</span> -->
						</div>
					</div>
					

					

					<div class="row price_row">
						<div class="col-md-12">
							<table class="table table-bordered">
							  <tr>
							  	<td>当前价</td>
							  	<td>起拍价</td>
							  	<td>竞拍阶梯</td>
							  </tr>
							  <tr>
							  	<td id="current_price">0.0</td>
							  	<td id="price">0.0</td>
							  	<td id="priceAdd">0.0</td>
							  </tr>
							</table>
						</div>
					</div>
					
					<div class="row" >
						<div class="col-md-12 col-sm-12 col-lg-12 col-xs-12">
							<p id="current_action_name">当前出价人：（无）</p>
						</div>
					</div>

					<div class="row" >
						<div class="col-md-10 col-md-offset-1">
						
							<button id="freezeBtn" class="btn btn-block btn-danger" disabled="true" data-toggle="modal" data-target="#pay_earnest_window">尚未开始</button> 
							   
							<div class="input-group display_none" id="auctionBtnRow">
							  <div class="input-group-btn">
							    <button class="btn btn-default" id="subMoneyBtn">&nbsp;-&nbsp;</button>
							  </div>
							  <input type="text" value="1,000.00" id="want_to_buy_money" class="form-control" aria-label="..." disabled>
							  <div class="input-group-btn">
							    <button class="btn btn-default" id="addMoneyBtn">&nbsp;+&nbsp;</button>
							    <button class="btn btn-danger ladda-button" data-style="slide-left" id="pay_auction_btn">&nbsp;&nbsp;&nbsp;出&nbsp;价&nbsp;&nbsp;&nbsp;</button>
							  </div>
							</div>
							

						</div>
					</div>




				</div>
			</div><!-- row   container -->

			<div class="row item_message_row">
				<div class="col-lg-10 col-md-10 col-sm-12 col-xs-12 col-md-offset-1 col-lg-offset-1">
					<div class="panel panel-default">
					  <div class="panel-heading">
					    <h3 class="panel-title">商品详情</h3>
					  </div>
					  <div class="panel-body">
					  	
						<div class="row message_row">
							<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
								<p>商品名称：</p>
							</div>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<!-- <p>孙其峰 兰竹</p> -->
								<p id="itemName"> </p>
							</div>
						</div>
						<div class="row message_row">
							<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
								<p>商品简介：</p>
							</div>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<!-- <p>孙其峰所作油墨画</p> -->
								<p id="itemBrief"> </p>
							</div>
						</div>
						<div class="row message_row">
							<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
								<p>商品种类：</p>
							</div>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<!-- <p>书法绘画 / 绘画</p> -->
								<p id="itemType"> </p>
							</div>
						</div>
						<div class="row message_row">
							<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
								<p>商品数量：</p>
							</div>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
								<!-- <p>1</p> -->
								<p id="itemNumber"> </p>
							</div>
						</div>
						<div class="row message_row">
							<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
								<p>商品图片：</p>
							</div>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
								<!--
								<p>
									<img src="${path}/picture/1.jpg" alt="..." class="item_picture">
								</p>
								<p>
									<img src="${path}/picture/1.jpg" alt="..." class="item_picture">
								</p>
								 -->
								<p id="itemPicture1"> </p>
								<p id="itemPicture2"> </p>
								<p id="itemPicture3"> </p>
							</div>
						</div>
						<div class="row message_row">
							<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
								<p>鉴定证明：</p>
							</div>
							<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
								<!--
								<p>
									<img src="${path}/picture/1.jpg" alt="..." id="item_identify_picture">
								</p>
								 -->
								
								<p id="itemIdentify"> </p>
							</div>
						</div>
						<div class="row message_row">
							<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2 col-sm-2 col-sm-offset-2 col-xs-4">
								<p>商品详细描述：</p>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
								<p id="itemDescription"> </p>
							</div>
						</div>

					  </div>
					</div>

				</div>

			</div><!-- row   -->
			



		</div><!-- container -->
	</div>



	<div class="footer">
		<div class="container">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<p>企业培训 | 合作事宜 | 版权投诉</p>
				<p>© 2017 拍拍网. Powered by paipaiwang.net</p>
			</div>
		</div>
	</div>


	
	



<!-- 
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#pay_earnest_window">缴纳保证金弹窗</button>
 -->


	<div class="modal fade" id="pay_earnest_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">您需要交纳200元的保证金</h4>
	      </div>
	      <div class="modal-body">
	        <div class="row">
	          <div class="col-md-3"><p>竞买人：</p></div>
	          <div class="col-md-9"><p>${user.username}</p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3"><p>手机号码：</p></div>
	          <div class="col-md-7"><p>${user.mobiphone}</p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3"><p>家庭地址：</p></div>
	          <div class="col-md-9"><p>${user.address}</p></div>
	        </div>
	        <hr>
	       	<div class="row">
	          <div class="col-md-12"><p>说明:</p></div>
	        </div>
	       	<div class="row">
	          <div class="col-md-12"><p>此保证金仅使用于该标的。</p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-12"><p>若竞拍不成功： 保证金将在竞买结束后3-5个工作日 自动退回</p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-12"><p>若竞拍成功：保证金直接抵扣货款至资产处置机构账户，请在规定时间内按机构指定方式完成尾款支付。</p></div>
	        </div>


	      </div>
	      <div class="modal-footer">
	        <button type="button" id="pay_earnest_window_btn" class="btn btn-warning  ladda-button" data-style="slide-left">
	        	确认并缴纳保证金
	        </button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
		



	<!-- 登录窗口  -->
	<%@ include file="../public/loginWindow.jspf" %>

		
		


	<script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/spin.min.js"></script>
	<script src="${path}/js/ladda.min.js"></script>
	<script src="${path}/js/util.js"></script>
	<script src="${path}/js/itemPage.js"></script>
</body>
</html>