<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>发布商品</title>
	<link rel="stylesheet" href="${path}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/css/ladda-themeless.min.css">
	<link rel="stylesheet" href="${path}/css/style.css">
	<link rel="stylesheet" href="${path}/css/datedropper.css">
	<link rel="stylesheet" href="${path}/css/publish.css">
	
</head>
<body>

	<!-- 顶部导航  -->
	<%@ include file="../public/header.jspf" %>


	<div class="publish center">
		<div class="container">
			<form name="publish_form" id="publish_form"  enctype="multipart/form-data">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-1 col-md-offset-1 col-sm-offset-1">
						<p class="want_to_publish">我要发布</p>
					</div>
				</div>
				
				<!-- has-error    配合  input标签的placeholder  对错误信息进行提示 -->
				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group  has_error_item_name">
						  <span class="input-group-addon" id="sizing-addon2">商品名称：</span>
						  <input type="text" name="item_name" class="form-control" placeholder="" aria-describedby="sizing-addon2">
						</div>
					</div>
					<div class="col-lg-4 col-md-3" >
						<p class="tip" >1-10个字符</p>
					</div>
				</div>
				


				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group has_error_item_brief">
						  <span class="input-group-addon" id="sizing-addon2">商品简介：</span>
						  <input type="text"  name="item_brief" class="form-control" placeholder="" aria-describedby="sizing-addon2">
						</div>
					</div>
					<div class="col-lg-4 col-md-3" >
						<p class="tip" >不能超过20个字符</p>
					</div>
				</div>

				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group has_error_item_type">
						    <span class="input-group-addon" id="sizing-addon2">商品种类：</span>
						  	<select class="form-control" id="item_type_first"  name="item_type_first">
							  <option value="no">- 请选择 -</option>
							  <option value="shufa">书法绘画</option>
							  <option value="xihua">西画雕塑</option>
							  <option value="guci">古瓷珠宝</option>
							  <option value="dangdai">当代工艺</option>
							  <option value="zahuo">各类杂货</option>
							  <option value="ershou">二手商品</option>
							</select>
							<!-- <select class="form-control" id="item_type_second" name="item_type_second">
							  <option>- 请选择子类 -</option>
							  <option>10</option>
							  <option>50</option>
							  <option>100</option>
							  <option>500</option>
							  <option>1000</option>
							</select> -->
						</div>
					</div>
				</div>


				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group has_error_item_number">
						    <span class="input-group-addon" id="sizing-addon2">商品数量：</span>
						  	<input type="text"  name="item_number" class="form-control" placeholder="" aria-describedby="sizing-addon2">
						</div>
					</div>
					<div class="col-lg-4 col-md-3" >
						<p class="tip" >1-10000之间的整数</p>
					</div>
				</div>
				

				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group has_error_item_price">
						    <span class="input-group-addon" id="sizing-addon2">商品底价：</span>
						  	<input type="text"  name="item_price" class="form-control" placeholder="" aria-describedby="sizing-addon2">
						  	<span class="input-group-addon" id="sizing-addon2">元</span>
						</div>
					</div>
				</div>

				


				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						
						<div class="input-group has_error_item_price_add">
					        <span class="input-group-addon" id="sizing-addon2">竞价阶梯：</span>
					      
					        <select  name="item_price_add" class="form-control ">
							  <option value="no">- 请选择 -</option>
							  <option value="10">10</option>
							  <option value="50">50</option>
							  <option value="100">100</option>
							  <option value="500">500</option>
							  <option value="1000">1000</option>
							</select>

							<span class="input-group-addon" id="sizing-addon2">元</span>
						</div>

					</div>
				</div>

				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group  has_error_item_publish_date">
						  <span class="input-group-addon" id="sizing-addon2">有效日期：</span>
						  <input type="text" name="item_publish_date_from" class="form-control" id="publish_date_from" aria-describedby="sizing-addon2">
						  <div id="publish_date_from_bottom"></div>
						  <span class="input-group-addon" id="sizing-addon2">到</span>
						  <input type="text" name="item_publish_date_to" class="form-control" id="publish_date_to" aria-describedby="sizing-addon2">
						</div>
					</div>
					<div class="col-lg-4 col-md-3" >
						<p class="tip" id="item_publish_date_tip"></p>
					</div>
				</div>



				
				<!-- <div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group">
						  <span class="input-group-addon" id="sizing-addon2">商品图片：</span>
						  <input type="text" class="form-control" disabled placeholder="" aria-describedby="sizing-addon2" value="请选择图片文件">
						  <span class="input-group-btn">
					        <button class="btn btn-default" type="button">浏览文件</button>
					      </span>
						</div>
					</div>
				</div>

				

				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group">
						  <span class="input-group-addon" id="sizing-addon2">鉴定证明：</span>
						  <input type="text" class="form-control" disabled placeholder="" aria-describedby="sizing-addon2" value="请选择图片文件">
						  <span class="input-group-btn">
					        <button class="btn btn-default" type="button">浏览文件</button>
					      </span>
						</div>
					</div>
				</div> -->


				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group has_error_item_picture">
						  <span class="input-group-addon" id="sizing-addon2">商品图一：</span>
						  <input type="file" name="item_picture_1" class="form-control" placeholder="支持jpg或者png格式" aria-describedby="sizing-addon2">
						</div>
					</div>
					<div class="col-lg-4 col-md-3" >
						<p class="tip" >只支持jpg或者png格式</p>
					</div>
				</div>
				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group">
						  <span class="input-group-addon" id="sizing-addon2">商品图二：</span>
						  <input type="file" name="item_picture_2" class="form-control" placeholder="支持jpg或者png格式" aria-describedby="sizing-addon2">
						</div>
					</div>
					<div class="col-lg-4 col-md-3" >
						<p class="tip" >可选项</p>
					</div>
				</div>
				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group">
						  <span class="input-group-addon" id="sizing-addon2">商品图三：</span>
						  <input type="file" name="item_picture_3" class="form-control" placeholder="支持jpg或者png格式" aria-describedby="sizing-addon2">
						</div>
					</div>
					<div class="col-lg-4 col-md-3" >
						<p class="tip" >可选项</p>
					</div>
				</div>

				<div class="row item_message nondisplay" id="img_row">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<img src="" id="img1" class="item_img">
						<img src="" id="img2" class="item_img">
						<img src="" id="img3" class="item_img">
					</div>
				</div>
				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<div class="input-group has_error_item_identify_picture">
						  <span class="input-group-addon" id="sizing-addon2">鉴定证明：</span>
						  <input type="file" name="item_identify_picture" class="form-control" placeholder="" aria-describedby="sizing-addon2">
						</div>
					</div>
					<div class="col-lg-4 col-md-3" >
						<p class="tip" >可选项</p>
					</div>
				</div>
				<div class="row item_message nondisplay" id="verify_img_row">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<img src="" id="vimg1" class="verify_img">
					</div>
				</div>

				
				
				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						

						<textarea class="form-control" name="item_description" placeholder="在此处输入商品的详细描述···"></textarea>
					</div>
				</div>

				<div class="row item_message">
					<div class="col-lg-4 col-lg-offset-4 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
						<button id="publish_submit" type="button"  class="btn  btn-block" >登记</button>
					</div>
				</div>
			

			</form>


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

		


<!-- 

	  
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#pay_earnest_window">缴纳保证金弹窗</button>

 -->

	<div class="modal fade" id="pay_earnest_window" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">您需要交纳200元的手续费</h4>
	      </div>
	      <div class="modal-body">
	        <div class="row">
	          <div class="col-md-3"><p>拍卖人：</p></div>
	          <div class="col-md-9"><p>${user.username }</p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3"><p>手机号码：</p></div>
	          <div class="col-md-7"><p>${user.mobiphone }</p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-3"><p>家庭地址：</p></div>
	          <div class="col-md-9"><p>${user.address }</p></div>
	        </div>
	        <hr>
	       	<div class="row">
	          <div class="col-md-12"><p>说明:</p></div>
	        </div>
	       	<div class="row">
	          <div class="col-md-12"><p>此保证金仅使用于该标的。</p></div>
	        </div>
	        <div class="row">
	          <div class="col-md-12"><p>拍卖结束后，倘若商品流拍，则手续费将在竞买结束后1-3个工作日内自动退回</p></div>
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
		


	<script src="${path}/js/jquery.min.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/spin.min.js"></script>
	<script src="${path}/js/ladda.min.js"></script>
	<script src="${path}/js/datedropper.min.js"></script>
	<script src="${path}/js/util.js"></script>
	<script src="${path}/js/publish.js"></script>
	<script type="text/javascript">
		

	



	</script>
</body>
</html>