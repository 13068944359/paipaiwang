<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>我的竞拍</title>
	<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/css/style.css">
	<link rel="stylesheet" href="${path}/css/myAuction.css">
	
</head>
<body>

<!-- 顶部导航  -->
	<%@ include file="../public/header.jspf" %>
	
	
	<div class="myAuction center">
		<div class="container">
			<div class="row" id="beforeAuctionList">
				<div class="col-lg-8 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
					<p class="have_been_published">我的竞拍</p>
				</div>
			</div>
<!-- display_none
			<div class="row row_myAuction">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container row_myAuction_container">
						<div class="row row_myAuction_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>卖家：潘美少女</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>商品状态：拍卖中</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
								<p>剩余拍卖时间：11:11:11</p>
							</div>
							
						</div>
						<div class="row row_myAuction_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>当前价格</p>
								<p class="text-danger">5000元</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>我的出价</p>
								<p>3000元</p>
							</div>
						</div>

					</div>
				</div>
			</div>

			<div class="row row_myAuction">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container row_myAuction_container">
						<div class="row row_myAuction_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>卖家：潘美少女</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>商品状态：拍卖中</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
								<p>剩余拍卖时间：11:11:11</p>
							</div>
							
						</div>
						<div class="row row_myAuction_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>当前价格</p>
								<p>3000元</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>我的出价</p>
								<p>3000元</p>
							</div>
						</div>

					</div>
				</div>
			</div>



			<div class="row row_myAuction">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container row_myAuction_container">
						<div class="row row_myAuction_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>卖家：潘美少女</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>商品状态：<span class="text-success">竞拍成功</span></p>
							</div>							
						</div>
						<div class="row row_myAuction_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>当前价格</p>
								<p>5000元</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>我的出价</p>
								<p>3000元</p>
							</div>
						</div>

					</div>
				</div>
			</div>






			<div class="row row_myAuction">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container row_myAuction_container">
						<div class="row row_myAuction_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>卖家：潘美少女</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>商品状态：<span class="text-danger">竞拍失败</span></p>
							</div>							
						</div>
						<div class="row row_myAuction_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>当前价格</p>
								<p class="text-danger">5000元</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>我的出价</p>
								<p>3000元</p>
							</div>
						</div>

					</div>
				</div>
			</div>
 -->


			<div class="row display_none" id="page_list_row">
				<nav aria-label="Page navigation page" class="page_list">
				  <ul class="pagination " id="page_list_ul">
				    <li>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li class="active"><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div><!-- row  -->


			<!-- 当刚进入页面还没有加载数据的时候 -->
			<div class="row" id="loadingGif">
				<div style="margin:160px 0px 160px 0px; text-align:center;">
					<img src="${path}/image/loading.gif">
				</div>
			</div>		
			

			
			<!-- 当返回的数量为0的时候-->
			<div class="row display_none" id="lengthZero">
				<span style="display:block; font-size:28px; margin:160px 0px 30px 0px; text-align:center;">非常抱歉，这里空空如也</span>
				<span style="display:block; font-size:28px; margin:30px 0px 160px 0px; text-align:center;">请到别的页面去逛逛吧</span>
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

	


	<script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/util.js"></script>
	<script src="${path}/js/myAuction.js"></script>
</body>
</html>