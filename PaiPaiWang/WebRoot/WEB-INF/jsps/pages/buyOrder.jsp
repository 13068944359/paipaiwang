<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>我的订单</title>
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
								<p>卖家：李小明（13033333333）</p>
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
								<p>
									<button  type="button" class="btn btn-primary pay_btn">付款</button>
									<button  type="button" class="btn btn-danger cancel_order_btn">取消订单</button>
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
								<p>卖家：李小明（13033333333）</p>
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
								<p>卖家：李小明（13033333333）</p>
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
								<!-- <p>圆通快递：888888888888</p> -->
								<p><button  type="button" class="btn btn-success receive_goods_btn">确认收货</button></p>
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
								<p>卖家：李小明（13033333333）</p>
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
								<p>
									<button type="button" class="btn btn-warning return_goods_window_btn" >申请退货</button>
									<button type="button" class="btn btn-default evaluate_window_btn">评价</button>
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
								<p>卖家：李小明（13033333333）</p>
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
								<p>卖家：李小明（13033333333）</p>
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
								<p>卖家：李小明（13033333333）</p>
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
								<p>状态：申请退货中</p>
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
								<p>卖家：李小明（13033333333）</p>
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
				<span style="display:block; font-size:28px; margin:160px 0px 30px 0px; text-align:center; color:#4bb;">您尚未成功竞拍商品</span>
				<span style="display:block; font-size:28px; margin:30px 0px 160px 0px; text-align:center; color:#4bb;">赶快去竞拍吧！</span>
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

	
	<!-- 评价模态框 -->

	<div class="modal fade" id="evaluate_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">请填写商品评价</h4>
	      </div>
	      <div class="modal-body">
	        
	        <div class="row">
	            <div class="col-md-12">
	          		<textarea id="evaluation" class="form-control"></textarea>
	          </div>
	        </div>
	        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary ladda-button" data-style="slide-left" id="evaluate_btn">提&nbsp;交</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->


	
	<!-- 退货模态框 -->
	<!-- Large modal -->
	<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#send_goods_window">Large modal</button> -->

	<div class="modal fade" id="return_goods_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">请填写退货理由</h4>
	      </div>
	      <div class="modal-body">
	        
	        <div class="row">
	            <div class="col-md-12">
	          		<textarea class="form-control" id="return_reason" placeholder="请输入遇到的问题···"></textarea>
	          </div>
	        </div>
	        
	       
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary ladda-button" data-style="slide-left" id="return_goods_btn">提&nbsp;交</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->



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
	          		<h3 id="confirm_text">取消订单将会把竞拍保证金赔付给卖家，确认要取消吗？</h3>
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
	

	<!-- 确认模态框 -->
	<!-- Large modal -->
	<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#send_goods_window">Large modal</button> -->

	<div class="modal fade" id="receive_goods_confirm_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">请确认操作</h4>
	      </div>
	      <div class="modal-body">
	        
	        <div class="row">
	            <div class="col-md-12">
	          		<h3 id="confirm_text">确认收货后，交易金额将进入对方账户，确定吗？</h3>
	            </div>
	        </div>
	        
	      </div>
	      <div class="modal-footer">
        	<button type="button" class="btn btn-default" data-dismiss="modal">取&nbsp;消</button>
	        <button type="button" class="btn btn-warning ladda-button" data-style="slide-left" id="receive_goods_confirm_btn">确&nbsp;认</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->



	<!-- 付款前填写收货信息模态框 -->
	
	<div class="modal fade" id="pay_confirm_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      
	      	<!-- <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
	      <div class="modal-body">
	        <div class="row first_row">
	          <div class="col-md-3"><p>金额：</p></div>
	          <div class="col-md-9"><p id="address_money">10000.00</p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3"><p>收货人：</p></div>
	          <div class="col-md-6"><p><input type="text" class="form-control" id="address_username" ></p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3"><p>联系电话：</p></div>
	          <div class="col-md-6"><p><input type="text" class="form-control" id="address_phone" ></p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3"><p>收货地址：</p></div>
	          <div class="col-md-9"><p><input type="text" class="form-control" id="address_address" ></p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3"><p>邮政编码：</p></div>
	          <div class="col-md-6"><p><input type="text" class="form-control" id="address_postcode" ></p></div>
	        </div>
	       	<div class="row">
	          <div class="col-md-3"><p>备注：</p></div>
	          <div class="col-md-9"><p><input type="text" class="form-control" id="address_others" ></p></div>
	        </div>
	      </div>
	      <div class="modal-footer">
	      	<button type="button" class="btn btn-default" data-dismiss="modal">取&nbsp;消</button>
	        <button type="button" id="pay_window_btn" class="btn btn-warning  ladda-button" data-style="slide-left">
	        	确认并付款
	        </button>
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





	<script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/js/jquery.cookie.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/spin.min.js"></script>
	<script src="${path}/js/ladda.min.js"></script>
	<script src="${path}/js/buyOrder.js"></script>
	<script src="${path}/js/util.js"></script>
	
</body>
</html>