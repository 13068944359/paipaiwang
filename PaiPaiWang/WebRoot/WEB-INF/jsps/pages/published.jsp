<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>我发布的商品</title>
	<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/css/style.css">
	<link rel="stylesheet" href="${path}/css/published.css">
	
</head>
<body>
<!-- 顶部导航  -->
	<%@ include file="../public/header.jspf" %>

	<div class="published center" >
		<div class="container" id="publish_container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
					<p class="have_been_published">已发布的商品</p>
				</div>
			</div>
<%-- 
			<div class="row item_published">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_published_container">
						<div class="row item_published_container_row_title">
							
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>发布日期：2017-2-5</p>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-8">
								<p>状态：待审核</p>
							</div>
						</div>
						<div class="row item_published_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<a href="#"><h4>孙其峰 兰竹</h4></a>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>商品底价：3000元</p>
								<p>开始时间：2017-3-2</p>
								<p>结束时间：2017-4-6</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>数量：1</p>
								<p>竞拍阶梯：100元</p>
								<p>商品种类：绘画</p>
							</div>
						</div>

					</div><!-- container -->
				</div>

			</div><!-- row -->




			<div class="row item_published">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_published_container">
						<div class="row item_published_container_row_title">
							<!-- <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>商品ID：11111111</p>
							</div> -->
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>发布日期：2017-2-5</p>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-8">
								<p>状态：审核通过</p>
							</div>
						</div>
						<div class="row item_published_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/3.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<a href="#"><h4>孙其峰 松</h4></a>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>商品底价：3000元</p>
								<p>开始时间：2017-3-2</p>
								<p>结束时间：2017-4-6</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>数量：1</p>
								<p>竞拍阶梯：100元</p>
								<p>商品种类：绘画</p>
							</div>

						</div>

					</div><!-- container -->
				</div>

			</div><!-- row -->

			<div class="row item_published">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_published_container">
						<div class="row item_published_container_row_title">
							<!-- <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>商品ID：11111111</p>
							</div> -->
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>发布日期：2017-2-5</p>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-8">
								<p class="text-danger">状态：未通过审核</p>
							</div>
						</div>
						<div class="row item_published_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/5.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<a href="#"><h4>孙其峰 松</h4></a>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>商品底价：3000元</p>
								<p>开始时间：2017-3-2</p>
								<p>结束时间：2017-4-6</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>数量：1</p>
								<p>竞拍阶梯：100元</p>
								<p>商品种类：绘画</p>
							</div>

						</div>

					</div><!-- container -->
				</div>

			</div><!-- row -->

			<div class="row item_published">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_published_container">
						<div class="row item_published_container_row_title">
							<!-- <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>商品ID：11111111</p>
							</div> -->
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>发布日期：2017-2-5</p>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-8">
								<p class="text-primary">状态：拍卖中（当前价格：5000元）</p>
							</div>
						</div>
						<div class="row item_published_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<a href="#"><h4>孙其峰 松</h4></a>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>商品底价：3000元</p>
								<p>开始时间：2017-3-2</p>
								<p>结束时间：2017-4-6</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>数量：1</p>
								<p>竞拍阶梯：100元</p>
								<p>商品种类：绘画</p>
							</div>

						</div>

					</div><!-- container -->
				</div>

			</div><!-- row -->

			<div class="row item_published">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_published_container">
						<div class="row item_published_container_row_title">
							<!-- <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>商品ID：11111111</p>
							</div> -->
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>发布日期：2017-2-5</p>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-8">
								<p class="text-danger">状态：流拍</p>
							</div>
						</div>
						<div class="row item_published_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/4.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<a href="#"><h4>孙其峰 松</h4></a>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>商品底价：3000元</p>
								<p>开始时间：2017-3-2</p>
								<p>结束时间：2017-4-6</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>数量：1</p>
								<p>竞拍阶梯：100元</p>
								<p>商品种类：绘画</p>
							</div>

						</div>

					</div><!-- container -->
				</div>

			</div><!-- row -->

			<div class="row item_published">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_published_container">
						<div class="row item_published_container_row_title">
							<!-- <div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>商品ID：11111111</p>
							</div> -->
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>发布日期：2017-2-5</p>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-8">
								<p class="text-success">状态：已成交（成交价：8000元）</p>
							</div>
						</div>
						<div class="row item_published_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/5.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<a href="#"><h4>孙其峰 松</h4></a>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>商品底价：3000元</p>
								<p>开始时间：2017-3-2</p>
								<p>结束时间：2017-4-6</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding">
								<p>数量：1</p>
								<p>竞拍阶梯：100元</p>
								<p>商品种类：绘画</p>
							</div>

						</div>

					</div><!-- container -->
				</div>

			</div><!-- row --> 
--%>
			<div class="row" id="page_list_row">
				<nav aria-label="Page navigation page" class="page_list">
				  <ul class="pagination" id="page_list_ul">
				   <!--  <li class="active"><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li> -->
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
				<span style="display:block; font-size:28px; margin:160px 0px 30px 0px; text-align:center; color:#4bb;">您尚未发布商品</span>
				<span style="display:block; font-size:28px; margin:30px 0px 160px 0px; text-align:center; color:#4bb;">请到别的页面去逛逛吧</span>
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
	<script src="${path}/js/jquery.cookie.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/util.js"></script>
	<script src="${path}/js/published.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>