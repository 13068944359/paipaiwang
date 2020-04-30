<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>卖家中心-订单管理</title>
	<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/css/ladda-themeless.min.css">
	<link rel="stylesheet" href="${path}/css/style.css">
	<link rel="stylesheet" href="${path}/css/order.css">
	
</head>
<body>
	
	<!-- 顶部导航  -->
	<%@ include file="../public/header.jspf" %>


	<div class="order center">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
					<p class="have_been_published">我的订单</p>
				</div>

			</div>
<%-- 
			<div class="row item_order">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_order_container">
						<div class="row item_order_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>订单号：888888888</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>生成日期：2017-2-5</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
								<p>买家：李小明（13033333333）</p>
							</div>
							
						</div>
						<div class="row item_order_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>价格：3000元</p>
								<p>数量：1</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>状态：待付款</p>
								<p>等待平台介入处理</p>
							</div>
						</div>

					</div><!-- container -->
				</div>
			</div><!-- row -->


			<div class="row item_order">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_order_container">
						<div class="row item_order_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>订单号：888888888</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>生成日期：2017-2-5</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
								<p>买家：李小明（13033333333）</p>
							</div>
							
						</div>
						<div class="row item_order_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>价格：3000元</p>
								<p>数量：1</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>状态：买家取消订单</p>
								<p><a href="#" class="ask_intervene_btn">申请平台介入</a></p>
							</div>
						</div>

					</div><!-- container -->
				</div>
			</div><!-- row -->
			
			<div class="row item_order">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_order_container">
						<div class="row item_order_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>订单号：888888888</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>生成日期：2017-2-5</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
								<p>买家：李小明（13033333333）</p>
							</div>
							
						</div>
						<div class="row item_order_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>价格：3000元</p>
								<p>数量：1</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>状态：已发货</p>
								<p><a href="#" class="ask_intervene_btn">申请平台介入</a></p>
							</div>
						</div>
						

						<div class="row item_order_container_row_footer">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<p>快递信息：圆通快递&nbsp;&nbsp;&nbsp;&nbsp;单号：888888888888</p>
							</div>
						</div>


					</div><!-- container -->
				</div>
			</div><!-- row -->


			<div class="row item_order">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_order_container">
						<div class="row item_order_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>订单号：888888888</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>生成日期：2017-2-5</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
								<p>买家：李小明（13033333333）</p>
							</div>
							
						</div>
						<div class="row item_order_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>价格：3000元</p>
								<p>数量：1</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>状态：交易完成</p>
								<p><button class="btn btn-default find_evaluation_btn">查看评价</button></p>
								<p><a href="#" class="ask_intervene_btn">申请平台介入</a></p>
							</div>
						</div>

					</div><!-- container -->
				</div>
			</div><!-- row -->


			

			<div class="row item_order">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_order_container">
						<div class="row item_order_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>订单号：888888888</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>生成日期：2017-2-5</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
								<p>买家：李小明（13033333333）</p>
							</div>
							
						</div>
						<div class="row item_order_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>价格：3000元</p>
								<p>数量：1</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>状态：卖家取消交易</p>
								<p><a href="#" class="ask_intervene_btn">申请平台介入</a></p>
							</div>
						</div>

					</div><!-- container -->
				</div>
			</div><!-- row -->

			<div class="row item_order">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_order_container">
						<div class="row item_order_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>订单号：888888888</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>生成日期：2017-2-5</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
								<p>买家：李小明（13033333333）</p>
							</div>
							
						</div>
						<div class="row item_order_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>价格：3000元</p>
								<p>数量：1</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>状态：待发货</p>
								<p>
									<!-- 点击发货按钮弹窗  需要显示对方付款时候填写的收货地址等信息，以及提供快递单号和快递公司的输入框 -->
									<button  type="button" class="btn btn-primary send_goods_window_btn">发货</button>
								</p>
								<p><a href="#" class="ask_intervene_btn">申请平台介入</a></p>
							</div>
						</div>

					</div><!-- container -->
				</div>
			</div><!-- row -->

			<div class="row item_order">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_order_container">
						<div class="row item_order_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>订单号：888888888</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>生成日期：2017-2-5</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
								<p>买家：李小明（13033333333）</p>
							</div>
							
						</div>
						<div class="row item_order_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>价格：3000元</p>
								<p>数量：1</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>状态：申请退货</p>
								<p><button  type="button" class="btn btn-primary return_goods_window_btn">查看详情</button></p>
								<p><a href="#" class="ask_intervene_btn">申请平台介入</a></p>
							</div>
						</div>

					</div><!-- container -->
				</div>
			</div><!-- row -->


			<div class="row item_order">
				<div class="col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 ">
					<div  class="container item_order_container">
						<div class="row item_order_container_row_title">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>订单号：888888888</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-6">
								<p>生成日期：2017-2-5</p>
							</div>
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
								<p>买家：李小明（13033333333）</p>
							</div>
							
						</div>
						<div class="row item_order_container_row_content">
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
								<img src="${path}/picture/1.jpg" alt="..." class="img-thumbnail">
							</div>


							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding">
								<h4>孙其峰 兰竹</h4>
								<p>简介：孙其峰所作油墨画</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>价格：3000元</p>
								<p>数量：1</p>
							</div>
							<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding">
								<p>状态：已退货</p>
								<p><a href="#" class="ask_intervene_btn">申请平台介入</a></p>
								
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
				<span style="display:block; font-size:28px; margin:160px 0px 30px 0px; text-align:center; color:#4bb;">您尚未有商品出售订单</span>
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


	



	<!-- 确认模态框 -->
	<!-- Large modal -->
	<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#send_goods_window">Large modal</button> -->

	<div class="modal fade" id="cancel_order_confirm_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">请确认操作</h4>
	      </div>
	      <div class="modal-body">
	        
	        <div class="row">
	            <div class="col-md-12">
	          		<h3 id="confirm_text">取消订单将会把手续费赔付给对方，确认要取消吗？</h3>
	            </div>
	        </div>
	        
	      </div>
	      <div class="modal-footer">
        	<button type="button" class="btn btn-default" data-dismiss="modal">取&nbsp;消</button>
	        <button type="button" class="btn btn-warning ladda-button" data-style="slide-left" id="cancel_order_confirm_btn">确&nbsp;认</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

	<!-- 发货模态框 -->
	<!-- Large modal -->
	<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#send_goods_window">Large modal</button> -->

	<div class="modal fade" id="send_goods_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">请填写发货资料</h4>
	      </div>
	      <div class="modal-body">
	        <div class="row">
	            <div class="col-md-3 col-md-offset-1">
				    <p>收货人：</p>
	         	</div>
	         	<div class="col-md-7">
	         		<p id="address_name">李小明</p>
	         	</div>
	        </div>
			<div class="row">
	            <div class="col-md-3 col-md-offset-1">
				    <p>收货地址：</p>
	         	</div>
	         	<div class="col-md-7">
	         		<p id="address_address">广东省湛江市麻章区广东海洋大学广东海洋大学广东海洋大学广东海洋大学广东海洋大学广东海洋大学</p>
	         	</div>
	        </div>
	        <div class="row">
	        	<div class="col-md-3 col-md-offset-1">
				    <p>手机号码：</p>
	         	</div>
	         	<div class="col-md-7">
	         		<p id="address_phone">13000000000</p>
	         	</div>
	           
	        </div>
	        <div class="row">
	            <div class="col-md-3 col-md-offset-1">
				    <p>邮政编码：</p>
	         	</div>
	         	<div class="col-md-7">
	         		<p id="address_postcode">510000</p>
	         	</div>
	        </div>
	        <div class="row">
	            <div class="col-md-3 col-md-offset-1">
				    <p>备注：</p>
	         	</div>
	         	<div class="col-md-7">
	         		<p  id="address_other">发票balabalabalabala备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注备注</p>
	         	</div>
	        </div>


	        <div class="row">
	            <div class="col-md-10 col-md-offset-1">
	          		<div class="input-group">
					  <span class="input-group-addon" id="sizing-addon2">快递公司：</span>
					  <input type="text"  id="express_company" class="form-control" placeholder="" aria-describedby="sizing-addon2">
				    </div>
	         	</div>
	        </div>
	        <div class="row">
	          <div class="col-md-10 col-md-offset-1">
	          		<div class="input-group">
					  <span class="input-group-addon" id="sizing-addon2">快递单号：</span>
					  <input type="text"  id="express_id" class="form-control" placeholder="" aria-describedby="sizing-addon2">
				    </div>
	          </div>
	        </div>
	       
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-default" data-dismiss="modal">取&nbsp;消</button>
	        <button type="button" class="btn btn-primary ladda-button" data-style="slide-left" id="send_goods_submit_btn">提&nbsp;交</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->


	<!-- 退货模态框 -->
	<div class="modal fade" id="return_goods_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">退货理由:</h4>
	      </div>
	      <div class="modal-body">
	        <div class="row">
	            <!-- <div class="col-md-3 col-md-offset-1">
				    <p>退货理由：</p>
	         	</div> -->
	         	<div class="col-md-12">
	         		<p id="return_reason">退货理由退货理由</p>
	         	</div>
	        </div>
			
	      </div>
	      <div class="modal-footer">
	      	<button type="button" id="agree_return_btn" class="btn btn-primary ladda-button" data-style="slide-left" >同意退货</button>
	        <button type="button" id="disagree_return_btn" class="btn btn-danger ladda-button" data-style="slide-left" >拒绝退货</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->


	<!-- 申请平台介入模态框 -->
	<div class="modal fade" id="ask_intervene_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">申请平台介入</h4>
	      </div>
	      <div class="modal-body">

	        <div class="row">
	          <div class="col-md-3 center_window_key"><p>申请诉求：</p></div>
	          <div class="col-md-8"><input type="text" id="interveneForWhat" class="form-control" ></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3 center_window_key"><p>申请原因：</p></div>
	          <div class="col-md-8">
				<textarea class="form-control" id="interveneForWhy" placeholder="请输入遇到的问题···"></textarea>
	          </div>
	        </div>
	         
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary ladda-button" data-style="slide-left" id="ask_intervene_btn">提&nbsp;交</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

	<!-- 查看评价内容模态框 -->
	<div class="modal fade" id="find_evaluation_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">买家评价内容:</h4>
	      </div>
	      <div class="modal-body">
	        <div class="row">
	            
	         	<div class="col-md-12">
	         		<p id="evaulationText">好棒棒棒</p>
	         	</div>
	        </div>
			
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-danger" data-dismiss="modal">关&nbsp;闭</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

	<script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/js/jquery.cookie.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/spin.min.js"></script>
	<script src="${path}/js/ladda.min.js"></script>
	<script src="${path}/js/util.js"></script>
	<script src="${path}/js/sellOrder.js"></script>
</body>
</html>