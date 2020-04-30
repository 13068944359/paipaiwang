<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>拍拍网</title>
	<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/css/ladda-themeless.min.css">
	<link rel="stylesheet" href="${path}/css/style.css">
	<link rel="stylesheet" href="${path}/css/homepage.css">
	
</head>
<body>
	<!-- 顶部导航  -->
	<%@ include file="../public/header.jspf" %>

	<div class="homepage center">
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
					  <li role="presentation" class="active"><a href="#">首页</a></li>
					  <li role="presentation" class="dropdown">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">书<span class="hidden-md hidden-sm hidden-xs">法绘</span>画<span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					      <li><a href="${path}/page/sort?type=sort&key=2">绘画</a></li>
					      <li><a href="${path}/page/sort?type=sort&key=3">书法</a></li>
					      <li><a href="${path}/page/sort?type=sort&key=4">古籍文献</a></li>
					    </ul>
					  </li>
					  <li role="presentation" class="dropdown">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">西画雕塑<span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					      <li><a href="${path}/page/sort?type=sort&key=6">油画</a></li>
					      <li><a href="${path}/page/sort?type=sort&key=7">水彩</a></li>
					      <li><a href="${path}/page/sort?type=sort&key=8">雕塑</a></li>
					    </ul>
					  </li>
					  <li role="presentation" class="dropdown">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">古瓷珠宝<span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					      <li><a href="${path}/page/sort?type=sort&key=10">玉器</a></li>
					      <li><a href="${path}/page/sort?type=sort&key=11">陶瓷</a></li>
					      <li><a href="${path}/page/sort?type=sort&key=12">木器</a></li>
					    </ul>
					  </li>
					   <li role="presentation" class="dropdown">
					    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">当代工艺<span class="caret"></span>
					    </a>
					    <ul class="dropdown-menu">
					      <li><a href="${path}/page/sort?type=sort&key=14">珠宝</a></li>
					      <li><a href="${path}/page/sort?type=sort&key=15">金属器</a></li>
					    </ul>
					  </li>
					  <li role="presentation"><a href="${path}/page/sort?type=sort&key=16"><span class="hidden-md hidden-sm hidden-xs">各类</span>杂货</a></li>
					  <li role="presentation"><a href="${path}/page/sort?type=sort&key=17">二手<span class="hidden-md hidden-sm hidden-xs">商品</span></a></li>
					  <li role="presentation" class="hidden-sm hidden-xs"><a href="#" id="nav_no">丨</a></li>

					  <li role="presentation"><a href="${path}/page/sort?type=everyday&key=0">每日一拍</a></li>
					</ul>
				</div>
			</div>

			<div class="row display_none" id="adv_row">
				<div class="col-lg-10 col-md-12 col-sm-12 col-xs-12 col-lg-offset-1">

					<div id="paipai_carousel" class="carousel slide">
						<ol class="carousel-indicators">
							<li data-target="#paipai_carousel" data-slide-to="0" class="active"></li>
							<li data-target="#paipai_carousel" data-slide-to="1"></li>
							<li data-target="#paipai_carousel" data-slide-to="2"></li>
							<li data-target="#paipai_carousel" data-slide-to="3"></li>
						</ol>
						<!-- 下面的图片默认是不居中的，此处居中是因为引入了自己编写的css文件 -->
						<div class="carousel-inner" id="adv_picture_div">
							<div class="item active advImg" >
								<a href="#" id="advPictureFirstA"><img src="#" alt=""  id="advPictureFirstI"></a>
							</div>
							<div class="item advImg">
								<a href="#" id="advPictureSecondA"><img src="#" alt=""  id="advPictureSecondI"></a>
							</div>
							<div class="item advImg">
								<a href="#" id="advPictureThirdA"><img src="#" alt=""  id="advPictureThirdI"></a>
							</div>
							<div class="item advImg">
								<a href="#" id="advPictureForthA"><img src="#" alt=""  id="advPictureForthI"></a>
							</div>
						</div>
						<a href="#paipai_carousel" data-slide="prev" class="carousel-control left">&lsaquo;</a>
						<a href="#paipai_carousel" data-slide="next" class="carousel-control right">&rsaquo;</a>
					</div>
				</div>
			</div>


			<!-- 首页商品部分-->
			<div class="row item_row display_none" id="item_row">
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6  col-lg-offset-1">
					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/1.jpg" alt="" >
				      	</div>
				      	
				        <h5>朱继展 牵牛花</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart-empty">点击收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">
					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/2.jpg" alt="" >
				      	</div>
				      	
				        <h5>孙其峰 兰竹</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart-empty">点击收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 col-lg-offset-0">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/3.jpg" alt="" >
				      	</div>
				      	
				        <h5>孙其峰 松</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart-empty">点击收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/4.jpg" alt="" >
				      	</div>
				      	
				        <h5>宋朝 瓷碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart-empty">点击收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>
				
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 col-lg-offset-1">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 col-lg-offset-1">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/5.jpg" alt="" >
				      	</div>
				      	
				        <h5>青花瓷 碗</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-heart">已收藏</span></a>
				    </div>
				</div>

			</div>
			

			<!-- 当返回的数量为0的时候-->
			<div class="row display_none" id="lengthZero">
				<span style="display:block; font-size:28px; margin:160px 0px 30px 0px; text-align:center;">非常抱歉，这里空空如也</span>
				<span style="display:block; font-size:28px; margin:30px 0px 160px 0px; text-align:center;">请到别的页面去逛逛吧</span>
			</div>		

			<!-- 当刚进入页面还没有加载数据的时候-->
			<div class="row" id="item_loading">
				
				<div style="margin:160px 0px 160px 0px; text-align:center;">
					<img src="${path}/image/loading.gif">
				</div>
			</div>		
			
			
		</div>
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

		


	<script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/spin.min.js"></script>
	<script src="${path}/js/ladda.min.js"></script>
	<script src="${path}/js/util.js"></script>
	<script src="${path}/js/homepage.js"></script>
</body>
</html>