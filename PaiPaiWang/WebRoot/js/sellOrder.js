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
			url: rootPath + "/order/sellOrderPage", 
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
						case 0: stateStr = "未付款";		break;
						case 1:	
							stateStr = "待发货";
							buttonStr = "<p>"+
								"<button  type='button' class='btn btn-primary send_goods_window_btn'>发货</button> "+
								"<button  type='button' class='btn btn-danger cancel_order_brn'>取消订单</button>"+
								"</p>";
							break;
						case 2:
							stateStr = "已发货";
							footerStr = "<div class='row item_order_container_row_footer'><div class='col-lg-12 col-md-12 col-sm-12 col-xs-12'><p>" + this.sendGoodsMessage + "</p></div></div>"
							break;
						case 3: 
							stateStr = "交易成功";
							if(this.evaluate){//有评价了之后才显示评价按钮
								buttonStr = "<p><button class='btn btn-default find_evaluation_btn'>查看评价</button></p>";
							}
							break;
						case 4: 
							stateStr = "申请退货中";	
							buttonStr = "<p><button  type='button' class='btn btn-primary return_goods_window_btn'>查看详情</button></p>";
							break;
						case 5: stateStr = "已退货";		break;
						case 6: stateStr = "买家取消交易";	break;
						case 7: stateStr = "卖家取消交易";	break;
						case 8: stateStr = "平台已介入";	break;
						}
						
						var interveneStr = "<p><a href='#' class='ask_intervene_btn'>申请平台介入</a></p>";
						if(this.state == 8){
							interveneStr = "";//显示已介入，无需显示更多信息
						}else if(this.intervene){//已经申请过了   handledIntervene
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
								"					<p>买家：" + this.opposite + "</p>" +
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
								"					<p>价格：" + this.price + "元</p>" +
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
							console.info(i,n);
						});
					}
					
					$(".pageNum").each(function(index){
						$(this).click(function(){
							getPage($(this).html());
						});
					});
					
					cancel_order_brn();	//卖家取消订单相关按钮
					find_evaluation_btn();//查看评价按钮监听
					pay_auction_btn();//发货按钮监听
					ask_intervene_btn();//申请平台介入按钮监听
					return_goods_btn();//申请退货的相关按钮监听
					
				}else if (data.result == "unlogin") {
					alert("登录超时，请重新登录");
					location.replace(rootPath);
				}else if(data.result == "error"){
					errorPage();
				}
				
			},
			error:function(data){		alert("error");		}
		});
	}
	
	
	
	

	var orderId;

	//卖家取消订单相关按钮
	function cancel_order_brn(){
		
		//弹窗监听
		$(".cancel_order_brn").each(function(index){
			$(this).click(function(){
				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				console.info(orderId);
				$("#cancel_order_confirm_window").modal('show');
				return false;  //禁止页面跳转“#”
			});
		});
		
		$("#cancel_order_confirm_btn").click(function(){
			$.ajax({
				url:rootPath + "/order/cancelSellOrder?id=" + orderId,
				type: 'POST',  
				data:null,
				dataType:"JSON",
				async:false,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						location.reload(true);
					}else if(data.result == "unlogin"){
						location.replace(rootPath); 
					}
				},
				error:function(data){		console.info(data);		},
			});
			
		});
	}
	
	
	
	//申请平台介入按钮监听
	function ask_intervene_btn(){

		//弹窗监听
		$(".ask_intervene_btn").each(function(index){
			$(this).click(function(){
				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				console.info(orderId);
				
				$("#interveneForWhat").val("");
				$("#interveneForWhy").val("");
				$("#ask_intervene_window").modal('show');
				return false;  //禁止页面跳转“#”
			});
		});

		//提交按钮监听
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
					url:rootPath + "/order/sellerRequestIntervene",
					type: 'POST',  
					data:postData,
					dataType:"JSON",
					async:false,
					success:function(data){
						console.info(data);
						if(data.result == "ok"){
							location.reload(true);
						}else if(data.result == "unlogin"){
							location.replace(rootPath); 
						}
					},
					error:function(data){		console.info(data);		},
				});
				
			}//if
		});
	}

	//申请退货的相关按钮监听
	function return_goods_btn(){
		//查看退货详情按钮
		$(".return_goods_window_btn").each(function(index){
			$(this).click(function(event){
				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				$.ajax({
					url:rootPath + "/order/returnReason?id=" + orderId,
					type: 'POST',  
					data:null,
					dataType:"JSON",
					async:false,
					success:function(data){
						console.info(data);
						if(data.result == "ok"){
							$("#return_reason").html(data.data);
						}else if(data.result == "unlogin"){
							location.replace(rootPath); 
						}
					},
					error:function(data){		console.info(data);		},
				});
				
				$("#return_goods_window").modal('show');
			});
		});

		//同意退货按钮监听
		$("#agree_return_btn").click(function(){
//			var l_agree_return_btn = Ladda.create( document.querySelector( '#agree_return_btn' ) );
//			l_agree_return_btn.start();
			$.ajax({
				url:rootPath + "/order/agreeReturn?id=" + orderId,
				type: 'POST',  
				data:null,
				dataType:"JSON",
				async:false,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						location.reload(true);
					}else if(data.result == "unlogin"){
						location.replace(rootPath); 
					}
				},
				error:function(data){		console.info(data);		},
			});
		});

		//拒绝退货按钮监听
		$("#disagree_return_btn").click(function(){
//			var l_disagree_return_btn = Ladda.create( document.querySelector( '#disagree_return_btn' ) );
//			l_disagree_return_btn.start();
			$.ajax({
				url:rootPath + "/order/disagreeReturn?id=" + orderId,
				type: 'POST',  
				data:null,
				dataType:"JSON",
				async:false,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						location.reload(true);
					}else if(data.result == "unlogin"){
						location.replace(rootPath); 
					}
				},
				error:function(data){		console.info(data);		},
			});
		});

	}


	//查看评价按钮监听
	function find_evaluation_btn(){
		$(".find_evaluation_btn").each(function(index){
			$(this).click(function(event){

				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				$.ajax({
					url:rootPath + "/order/findEvaluate?id=" + orderId,
					type: 'POST',  
					data:null,
					dataType:"JSON",
					async:false,
					success:function(data){
						console.info(data);
						if(data.result == "ok"){
							$("#evaulationText").html(data.data);
						}else if(data.result == "unlogin"){
							location.replace(rootPath); 
						}
					},
					error:function(data){		console.info(data);		},
				});
				
				$("#find_evaluation_window").modal("show");

			});//click
		});//each
	}

	//发货监听
	function pay_auction_btn(){
		//监听发货弹窗按钮
		$(".send_goods_window_btn").each(function(index){
			$(this).click(function(event){
				orderId = $(this).parent().parent().parent().parent().find(".orderId").html();
				
				$.ajax({
					url:rootPath + "/order/getAddressMessage?id=" + orderId,
					type: 'POST',  
					data:null,
					dataType:"JSON",
					async:false,
					success:function(data){
						console.info(data);
						if(data.result == "ok"){
							$("#address_name").html(data.data.username);
							$("#address_phone").html(data.data.phone);
							$("#address_address").html(data.data.address);
							$("#address_postcode").html(data.data.postcode);
							$("#address_other").html(data.data.other);

							$("#send_goods_window").modal('show');
						}else if(data.result == "unlogin"){
							location.replace(rootPath); 
						}
					},
					error:function(data){		console.info(data);		},
				});
			});
		});


		//提交按钮监听
		$("#send_goods_submit_btn").click(function(){
//			var l_send_goods_submit_btn = Ladda.create( document.querySelector( '#send_goods_submit_btn' ) );
//			l_send_goods_submit_btn.start();
			
			var express_company = $("#express_company").val();
			var express_id = $("#express_id").val();
			
			if(express_company=="" || express_id==""){
				return ;
			}
			
			var postData = {
					"id"				: orderId,
					"express_company"	: express_company,
					"express_id"		: express_id
			};
			$.ajax({
				url:rootPath + "/order/sendGoods",
				type: 'POST',  
				data:postData,
				dataType:"JSON",
				async:false,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						location.reload(true);
					}else if(data.result == "unlogin"){
						location.replace(rootPath); 
					}
				},
				error:function(data){		console.info(data);		},
			});
			
		});
	}

});