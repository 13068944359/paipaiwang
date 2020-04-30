$(function () {


	pay_window_btn();//付款相关按钮事件
	cancel_order_btn();//取消订单相关按钮事件
	ask_intervene_btn();//申请平台介入相关事件
	receive_goods_btn();//确认收货相关事件监听
	return_goods();//申请退货相关事件监听
	evaluation();//评价相关事件


	//评价相关事件
	function evaluation(){
		//弹窗事件
		$(".evaluate_window_btn").each(function(index){
			console.info(index);
			$(this).click(function(){
				$("#evaluate_window").modal('show');
			});
		});


		//评价按钮监听
		var l_evaluate_btn = Ladda.create( document.querySelector( '#evaluate_btn' ) );
		$("#evaluate_btn").click(function(){
			l_evaluate_btn.start();
		});

	}

	//申请退货相关事件监听
	function return_goods(){
		//弹窗事件
		$(".return_goods_window_btn").each(function(index){
			console.info(index);
			$(this).click(function(){
				$("#return_goods_window").modal('show');
			});
		});

		//退货提交按钮监听
		var l_return_goods_btn = Ladda.create( document.querySelector( '#return_goods_btn' ) );
		$("#return_goods_btn").click(function(){
			l_return_goods_btn.start();
		});
	}//function


	//确认收货相关事件监听
	function receive_goods_btn(){
		//确认收货弹窗按钮
		$(".receive_goods_btn").each(function(index){
			console.info(index);
			$(this).click(function(){
				$("#receive_goods_confirm_window").modal('show');
			});
		});


		//确认收货按钮提交监听
		var l_receive_goods_confirm_btn = Ladda.create( document.querySelector( '#receive_goods_confirm_btn' ) );
		$("#receive_goods_confirm_btn").click(function(){
			l_receive_goods_confirm_btn.start();
		});
	}//function
		

	//申请平台介入相关事件
	function ask_intervene_btn(){

		//申请平台介入按钮监听
		$(".ask_intervene_btn").each(function(index){
			$(this).click(function(){
				console.info(index);
				$("#ask_intervene_window").modal('show');


				return false;//href=#
			});
		});

		//申请平台介入提交按钮监听
		var l_ask_intervene_btn = Ladda.create( document.querySelector( '#ask_intervene_btn' ) );
		$("#ask_intervene_btn").click(function(){
			l_ask_intervene_btn.start();
		});
	}//function


	//取消订单相关按钮事件
	function cancel_order_btn(){
		//取消订单弹窗按钮
		$(".cancel_order_btn").each(function(index){
			console.info(index);
			$(this).click(function(){
				// $("#confirm_text").html("取消订单将会赔付对方200元，确认要取消吗？");
				$("#cancel_order_confirm_window").modal('show');
			});
		});


		//取消订单确认按钮监听
		var l_cancel_order_confirm_btn = Ladda.create( document.querySelector( '#cancel_order_confirm_btn' ) );
		$("#cancel_order_confirm_btn").click(function(){
			l_cancel_order_confirm_btn.start();
		});
	}//function
		

	//付款相关按钮事件
	function pay_window_btn(){

		//付款弹窗按钮监听
		$(".pay_btn").each(function(index){
			$(this).click(function(){
				console.info(index);
				$("#pay_confirm_window").modal("show");

				// return true;  加不加都会调用模态框弹出事件
			});
		});

		//付款按钮监听
		var l_pay_window_btn = Ladda.create( document.querySelector( '#pay_window_btn' ) );
		$("#pay_window_btn").click(function(){
			l_pay_window_btn.start();
		});
	}//function




});