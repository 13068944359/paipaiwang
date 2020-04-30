<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>我的收藏</title>
	<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/css/style.css">
	<link rel="stylesheet" href="${path}/css/myCollection.css">
	
</head>
<body>
<!-- 顶部导航  -->
	<%@ include file="../public/header.jspf" %>


	<div class="myCollection center">
		<div class="container">

			
			<div class="row">
				<div class="col-lg-8 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
					<p class="page_title">我的收藏</p>
				</div>

			</div>

			<div class="row item_row" id="item_row">
			
			<%-- 
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6">
					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/1.jpg" alt="" >
				      	</div>
				      	
				        <h5>朱继展 牵牛花</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
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
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
				    </div>
				</div>
				<div class="col-lg-2 col-md-3 col-sm-4 col-xs-6 ">

					<div class="item">
						<div class="picture">
				        	<img src="${path}/picture/3.jpg" alt="" >
				      	</div>
				      	
				        <h5>孙其峰 松</h5>
				        <span class="price">￥22000.00</span>
				        <p class="offline_time">下线时间：2/27 14:02</p>
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
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
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
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
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
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
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
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
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
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
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
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
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
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
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
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
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
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
				    	<a href="" class="collection"><span class="glyphicon glyphicon-trash delete_collection"></span></a>
				    </div>
				</div>
 --%>
			</div>
	
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
	<script src="${path}/js/myCollection.js"></script>
</body>
</html>