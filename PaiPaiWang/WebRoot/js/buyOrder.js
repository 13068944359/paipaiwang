$(function () {

	
	getPage(1);//页面初始化获取第一页的数据
	
	function getPage(pageNum){
		//移除原来所有的标签
		$(".item_order").each(function(){
			$(this).remove();
		});
		$("#page_list_ul").html("");//清空原页码列表
		$("#loadingGif").removeClass("display_none");//旋转图
		
		var postData = {	"page":pageNum};
		$.ajax({
			url: rootPath + "/order/buyOrderPage", 
			type: 'POST',  
			data:postData,
			dataType:"JSON",
			async:true,
			success:function(data){
				console.info(data);
				$("#loadingGif").addClass("display_none");
				
				if(data.result == "ok"){
					if(data.data.length == 0){
						$("#lengthZero").removeClass("display_none");
						return;
					}
					
					//迭代
					$(data.data).each(function(){
						var stateStr;//状态
						var buttonStr = "";//按钮
						var footerStr = ""//快递信息（状态为“已发货”的时候才需要显示）
						switch(this.state){
						case 0:
							stateStr = "未付款";
							buttonStr = "<p>"+
									"<button  type='button' class='btn btn-primary pay_btn'>付款</button> "+
									"<button  type='button' class='btn btn-danger cancel_order_btn'>取消订单</button>"+
								"</p>";
							break;
						case 1:	stateStr = "待发货";		break;
						case 2:
							stateStr = "已发货";
							buttonStr = "<p><button  type='button' class='btn btn-success receive_goods_btn'>确认收货</button></p>";
							footerStr = "<div class='row item_order_container_row_footer'><div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'><p>" + this.sendGoodsMessage + "</p></div></div>"
							break;
						case 3: 
							stateStr = "交易成功";
							buttonStr = "<p>"+"<button type='button' class='btn btn-warning return_goods_window_btn' >申请退货</button> "	;
							if(!this.evaluate){//还没有评价，显示评价按钮
								buttonStr = buttonStr + "<button type='button' class='btn btn-default evaluate_window_btn'>评价</button>";
							}
							buttonStr = buttonStr +	"</p>";
							break;
						case 4: stateStr = "申请退货中";	break;
						case 5: stateStr = "已退货";		break;
						case 6: stateStr = "买家取消交易";	break;
						case 7: stateStr = "卖家取消交易";	break;
						case 8: stateStr = "平台已介入";	break;
						}
						
						var interveneStr = "<p><a href='#' class='ask_intervene_btn'>申请平台介入</a></p>";
						if(this.state == 8){
							interveneStr = "";//显示已介入，无需显示更多信息
						}else if(this.intervene){//已经申请过了
							if(this.handledIntervene){
								var interveneStr = "<p>平台拒绝介入</p>";
							}else{
								var interveneStr = "<p>等待平台介入</p>";
							}
						}
						
						$("#page_list_row").before(
								"<div class='row item_order'>" +
								"	<div class='col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 '>" +
								"		<div  class='container item_order_container'>" +
								"			<div class='row item_order_container_row_title'>" +
								"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-6'>" +
								"					<p>订单号：<span  class='orderId'>" + this.id + "</span></p>" +
								"				</div>" +
								"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-6'>" +
								"					<p>生成日期：" + this.createDate + "</p>" +
								"				</div>" +
								"				<div class='col-lg-6 col-md-6 col-sm-6 col-xs-12'>" +
								"					<p>卖家：" + this.opposite + "</p>" +
								"				</div>" +
								"			</div>" +
								"			<div class='row item_order_container_row_content'>" +
								"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-6'>" +
								"					<img src='" + rootPath + "/picture/" + this.picture + "' onerror='this.src=\"" + rootPath + "/image/errorImg.jpg"  + "\"'  class='img-thumbnail'>" +
								"				</div>" +
								"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding'>" +
								"					<h4>" + this.name + "</h4>" +
								"					<p>简介：" + this.brief + "</p>" +
								"				</div>" +
								"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding'>" +
								"					<p>价格：<span class='itemPrice'>" + this.price.toFixed(2) + "元</span></p>" +
								"					<p>数量：" + this.number + "</p>" +
								"				</div>" +
								"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding'>" +
								"					<p>状态：" + stateStr + "</p>" +
								buttonStr +
								interveneStr +
								"				</div>" +
								"			</div>" +
								footerStr +
								"		</div>" +
								"	</div>" +
								"</div>" 
						);
					});
					
					if(data.totalPage == 1 || data.totalPage == 0){
						
					}else{
						var pageArray = getPageList(data.page,data.totalPage);//util.js函数调用
						$.each(pageArray,function(i,n){
							if(n == data.page){
								$("#page_list_ul").html(
										$("#page_list_ul").html() +
										"<li class='active'><a href='#'>" + n + "</a></li>"
								);
							}else{
								$("#page_list_ul").html(
										$("#page_list_ul").html() +
										"<li><a href='#'  class='pageNum'>" + n + "</a></li>"
								);
							}
						});
					}
					
					$(".pageNum").each(function(index){
						$(this).click(function(){
							getPage($(this).html());
						});
					});
					
					pay_window_btn();//付款相关按钮事件
					cancel_order_btn();//取消订单相关按钮事件
					ask_intervene_btn();// 申请平台介入相关事件
					receive_goods_btn();// 确认收货相关事件监听
					return_goods();// 申请退货相关事件监听
					evaluation();// 评价相关事件

				} else if (data.result == "unlogin") {
					alert("登录超时，请重新登录");
					location.replace(rootPath);
				} else if (data.result == "error") {
					errorPage();
				}

			},
			error : function(data) {
				alert("error");
			}
		});
	}
	
	
	

	var orderId;//用于标记正在操作的订单id


	//评价相关事件
	function evaluation(){
		//弹窗事件
		$(".evaluate_window_btn").each(function(index){
			$(this).click(function(){
				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				$("#evaluate_window").modal('show');
			});
		});


		//评价按钮监听
		$("#evaluate_btn").click(function(){
//			var l_evaluate_btn = Ladda.create( document.querySelector( '#evaluate_btn' ) );
//			l_evaluate_btn.start();
			var evaluation = $.trim($("#evaluation").val());
			if(evaluation == ""){
				return ;
			}
			
			var postData = {
					"id":	orderId,
					"evaluation":evaluation
			};
			$.ajax({
				url:rootPath + "/order/evaluate",
				type: 'POST',  
				data:postData,
				dataType:"JSON",
				async:false,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						location.reload(true);
					}else if(data.result == "unlogin"){
		            	  alert("登录超时，请重新登录");
		            	  location.replace(rootPath);
		              }
				},
				error:function(data){		console.info(data);		},
			});
			
			
			
		});

	}

	//申请退货相关事件监听
	function return_goods(){
		//弹窗事件
		$(".return_goods_window_btn").each(function(index){
			$(this).click(function(){
				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				console.info(orderId);
				$("#return_reason").val("");
				$("#return_goods_window").modal('show');
			});
		});

		//退货提交按钮监听
		$("#return_goods_btn").click(function(){
//			var l_return_goods_btn = Ladda.create( document.querySelector( '#return_goods_btn' ) );
//			l_return_goods_btn.start();
			
			var return_reason = $.trim($("#return_reason").val());
			
			if(return_reason == ""){
				alert("请输入退货理由");
				return;
			}
			
			var postData = {
					"id":	orderId,
					"return_reason":return_reason
			};
			$.ajax({
				url:rootPath + "/order/requestReturn",
				type: 'POST',  
				data:postData,
				dataType:"JSON",
				async:false,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						location.reload(true);
					}else if(data.result == "unlogin"){
		            	  alert("登录超时，请重新登录");
		            	  location.replace(rootPath);
		              }
				},
				error:function(data){		console.info(data);		},
			});
		});
	}//function

	//确认收货相关事件监听
	function receive_goods_btn(){
		//确认收货弹窗按钮
		$(".receive_goods_btn").each(function(index){
			$(this).click(function(){
				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				console.info(orderId);
				$("#receive_goods_confirm_window").modal('show');
			});
		});

		//确认收货按钮提交监听
		$("#receive_goods_confirm_btn").click(function(){
//			var l_receive_goods_confirm_btn = Ladda.create( document.querySelector( '#receive_goods_confirm_btn' ) );
//			l_receive_goods_confirm_btn.start();
			$.ajax({
				url:rootPath + "/order/getGoodsConfirm?id=" + orderId,
				type: 'POST',  
				data:null,
				dataType:"JSON",
				async:false,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						location.reload(true);
					}else if(data.result == "unlogin"){
		            	  alert("登录超时，请重新登录");
		            	  location.replace(rootPath);
		              }
				},
				error:function(data){		console.info(data);		},
			});
			
		});
	}//function
		
	
	//申请平台介入相关事件
	function ask_intervene_btn(){
		//申请平台介入按钮监听
		$(".ask_intervene_btn").each(function(index){
			$(this).click(function(){
				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				console.info(orderId);
				
				$("#interveneForWhat").val("");
				$("#interveneForWhy").val("");
				$("#ask_intervene_window").modal('show');
				return false;//href=#
			});
		});

		//申请平台介入提交按钮监听
		$("#ask_intervene_btn").click(function(){
			var l_ask_intervene_btn = Ladda.create( document.querySelector( '#ask_intervene_btn' ) );
			
			var forWhat = $.trim($("#interveneForWhat").val());
			var forWhy = $.trim($("#interveneForWhy").val());
			if( forWhat != "" && forWhy != "" ){
				l_ask_intervene_btn.start();
				
				var postData = {
					"id":	orderId,
					"forWhat":forWhat,
					"forWhy":forWhy
				};
				$.ajax({
					url:rootPath + "/order/buyerRequestIntervene",
					type: 'POST',  
					data:postData,
					dataType:"JSON",
					async:false,
					success:function(data){
						console.info(data);
						if(data.result == "ok"){
							location.reload(true);
						}else if(data.result == "unlogin"){
			            	  alert("登录超时，请重新登录");
			            	  location.replace(rootPath);
			              }
					},
					error:function(data){		console.info(data);		},
				});
				
			}
		});
	}//function


	//取消订单相关按钮事件
	function cancel_order_btn(){
		//取消订单弹窗按钮
		$(".cancel_order_btn").each(function(index){
			console.info(index);
			$(this).click(function(){
				// $("#confirm_text").html("取消订单将会赔付对方200元，确认要取消吗？");
				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				console.info(orderId);
				$("#cancel_order_confirm_window").modal('show');
			});
		});


		//取消订单确认按钮监听
		$("#cancel_order_confirm_btn").click(function(){
			var l_cancel_order_confirm_btn = Ladda.create( document.querySelector( '#cancel_order_confirm_btn' ) );
			l_cancel_order_confirm_btn.start();
			
			$.ajax({
				url:rootPath + "/order/cancelBuyOrder?id=" + orderId,
				type: 'POST',  
				data:null,
				dataType:"JSON",
				async:false,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						location.reload(true);
					}else if(data.result == "unlogin"){
		            	  alert("登录超时，请重新登录");
		            	  location.replace(rootPath);
		              }
				},
				error:function(data){		console.info(data);		},
			});
			
			
			
		});
	}//function
		

	//付款相关按钮事件
	function pay_window_btn(){
		var username;
		var phone;
		var address;
		var postcode;
		
		//加载页面完毕先获取当前用户的基础收货地址信息
		$.ajax({
			url:rootPath + "/user/getAddressMessage",
			type: 'POST',  
			data:null,
			dataType:"json",
			async:false,
			success:function(data){
				console.info(data);
				if(data.result == "ok"){
					username = data.data.username;
					phone = data.data.phone;
					address = data.data.address;
					postcode = data.data.postcode;
				}else if(data.result == "unlogin"){
	            	  alert("登录超时，请重新登录");
	            	  location.replace(rootPath);
	              }
			},
			error:function(data){		console.info(data);		},
		});
		

		//付款弹窗按钮监听
		$(".pay_btn").each(function(index){
			$(this).click(function(){
				console.info(index);
				$("#address_username").val(username);
				$("#address_phone").val(phone);
				$("#address_address").val(address);
				$("#address_postcode").val(postcode);
				
				var itemPriceStr = $(this).parent().parent().parent().find(".itemPrice").html();
				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				$("#address_money").html(itemPriceStr);
				
				$("#pay_confirm_window").modal("show");
				// return true;  加不加都会调用模态框弹出事件
			});
		});

		//付款按钮监听
		$("#pay_window_btn").click(function(){
			var l_pay_window_btn = Ladda.create( document.querySelector( '#pay_window_btn' ) );
			l_pay_window_btn.start();
			
			var address_username = $("#address_username").val();
			var address_phone = $("#address_phone").val();
			var address_address = $("#address_address").val();
			var address_postcode = $("#address_postcode").val();
			var address_others = $("#address_others").val();
			
			if( address_username=="" || address_phone=="" || address_address=="" || address_postcode=="" ){
				alert("请完善地址信息后再提交");
				l_pay_window_btn.stop();
				return;
			}
			
			var postData = {
					"orderId"	:	orderId,
					"name"		:	address_username,
					"phone"		:	address_phone,
					"address"	:	address_address,
					"postcode"	:	address_postcode,
					"other"		:	address_others
			};
			console.info(postData);
			$.ajax({
				url:rootPath + "/order/payForOrder",
				type: 'POST',  
				data:postData,
				dataType:"json",
				async:false,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						location.reload(true);
					}else if(data.result == "no"){
						alert("账户余额不足，请先充值。");
						l_pay_window_btn.stop();
					}else if(data.result == "unlogin"){
		            	  alert("登录超时，请重新登录");
		            	  location.replace(rootPath);
		              }
				},
				error:function(data){		console.info(data);		},
			});
			
		});
	}//function


});