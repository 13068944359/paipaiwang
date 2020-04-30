$(function () {

	var para = getParamOfUrl();
	var id = para.split('=')[1];//商品id
	
	var currentPrice;//标记当前价格
	var auctioned = false;//标记是否已经有人出价
	var moneyAdd;
	
	var endDate;//标记结束时间
	
	initPage();//初始化页面基本商品数据
	initAuctionState();//初始化拍卖状态最新信息以及用户交互组件（按钮等）
	
	

	

	
	
	
	

	//加价、减价的按钮监听
	function addAndSubBtnClick(){
		//subMoneyBtn    addMoneyBtn
		//减价要求不能低于当前价格+阶梯（或者还没有人竞拍的时候，需要不小于原价）
		$("#subMoneyBtn").click(function(){
			var moneyInput = parseFloat($("#want_to_buy_money").val());
			
			if(auctioned){
				if(moneyInput == (moneyAdd+currentPrice) ){
					return;
				}else if(moneyInput > (moneyAdd+currentPrice) ){
					$("#want_to_buy_money").val( (moneyInput-moneyAdd).toFixed(2) )
				}else{
					console.info("other");
				}
			}else{
				if(moneyInput == currentPrice ){
					return;
				}else if(moneyInput > currentPrice ){
					$("#want_to_buy_money").val( (moneyInput-moneyAdd).toFixed(2) )
				}else{
					console.info("other");
				}
			}
			return false;
		});
		
		//加价则无需任何判断
		$("#addMoneyBtn").click(function(){
			var moneyInput = parseFloat($("#want_to_buy_money").val());
			$("#want_to_buy_money").val( (moneyInput+moneyAdd).toFixed(2) );
		});
		
		$("#pay_auction_btn").click(function(){
			var l_pay_auction_btn = Ladda.create( document.querySelector( '#pay_auction_btn' ) );
			l_pay_auction_btn.start();
			
			var moneyInput = parseFloat($("#want_to_buy_money").val());
			var data = {
					"itemId":id,
					"price":moneyInput
			};
			$.ajax({
				url: rootPath + "/auction/auction", 
				type: 'POST',  
				data:data,
				dataType:"JSON",
				async:true,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						//出价成功
						alert("成功");
					}else if(data.result == "no"){
						//出价失败，可能刚好同一时间有另一个人先出价了
					}else{
						alert("error");
					}
					l_pay_auction_btn.stop();
					latestAuction();//更新一下最新的拍卖价格
				},
				error:function(data){		console.info(data)		}
			});
		});
		
	}
	
	//页面商品基本数据初始化
	function initPage(){
		
		$.ajax({
			url: rootPath + "/item/itemPage?id=" + id, 
			type: 'POST',  
			data:null,
			dataType:"JSON",
			async:true,
			success:function(data){
				console.info(data);
				
				$("#item_picture").attr("src",rootPath + "/picture/" + data.picture1);
				$("#item_name").html(data.name);
				$("#item_brief").html("简介：" + data.brief);
				
				var startDate = new Date(data.startDate);
				$("#startDate").html("开始日期：" + startDate.getFullYear()+"/"+(startDate.getMonth()+1)+"/"+(startDate.getDate()));
				endDate = new Date(data.endDate);
				$("#endDate").html("结束日期：" + endDate.getFullYear()+"/"+(endDate.getMonth()+1)+"/"+(endDate.getDate()));
				$("#item_brief").html("简介：" + data.brief);
				endDate.setDate(endDate.getDate()+1);//当天结束，则准确的结束时间应该是隔天的凌晨0点整，故需要+1
				
				$("#current_price").html(parseFloat(data.price).toFixed(2));
				$("#price").html(parseFloat(data.price).toFixed(2));
				$("#priceAdd").html(parseFloat(data.priceAdd).toFixed(2));

				currentPrice = data.price;
				moneyAdd = data.priceAdd;
				$("#want_to_buy_money").val(parseFloat(data.price).toFixed(2));
				
				$("#itemName").html(data.name);
				$("#itemBrief").html(data.brief);
				$("#itemType").html(data.type);
				$("#itemNumber").html(data.number);
				
				$("#itemPicture1").html("<img src='" + rootPath  + "/picture/" + data.picture1  + "' class='item_picture' onerror='this.src=\"" + rootPath + "/image/errorImg.jpg"  + "\"'>"	);
				if(data.picture2){
					$("#itemPicture2").html("<img src='" + rootPath  + "/picture/" + data.picture2  + "' class='item_picture' onerror='this.src=\"" + rootPath + "/image/errorImg.jpg"  + "\"'>"	);
				}
				if(data.picture3){
					$("#itemPicture3").html("<img src='" + rootPath  + "/picture/" + data.picture3  + "' class='item_picture' onerror='this.src=\"" + rootPath + "/image/errorImg.jpg"  + "\"'>"	);
				}
				
				if(data.identifyPicture){
					$("#itemIdentify").html("<img src='" + rootPath  + "/picture/" + data.identifyPicture  + "' class='item_picture' onerror='this.src=\"" + rootPath + "/image/errorImg.jpg"  + "\"'>"	);
				}else{
					$("#itemIdentify").html("（无）"	);
				}
				
				$("#itemDescription").html(data.itemDescription);
			},
			error:function(data){		console.info(data)		}
		});
		
	}
	
	
	
	
	function initAuctionState(){
		//itemAuctionState
		
		$.ajax({
			url: rootPath + "/item/itemAuctionState?id=" + id, 
			type: 'POST',  
			data:null,
			dataType:"JSON",
			async:true,
			success:function(data){
				console.info(data);
				if(data.result == "ok"){
					if(data.data.freeze == null){
						$("#freezeBtn").html("请先登录");
					}
					
					if(data.data.mine == true){
						$("#freezeBtn").html("不允许竞拍自己发布的商品");
						$("#freezeBtn").attr("disabled",true);
						
						countDown();//自动刷新时间
						latestAuction();//更新一下最新的拍卖价格
						autoFlash();//竞拍中，需要不断刷新最新价格
						return;
					}
					
					if(data.data.state == 2){
						//通过审核==尚未开始 
//						$("#freezeBtn").html("尚未开始");
//						$("#freezeBtn").attr("disabled",true);
						
					}else if(data.data.state == 3){
						//正在进行
						if(data.data.who != null){
							$("#current_action_name").html("当前出价人：" + data.data.who);
							$("#current_price").html(data.data.price);
						}
						
						if(data.data.freeze == true){
							$("#freezeBtn").addClass("display_none");
							$("#auctionBtnRow").removeClass("display_none");
							addAndSubBtnClick();//加价、减价的按钮监听   提交按钮的监听
						}else if(data.data.freeze == false){
							//报名交保证金
							$("#freezeBtn").html("报名交保证金");
							$("#freezeBtn").attr("disabled",false);
							pay_earnest_window_btn();//同意缴纳保证金按钮监听
						}
						countDown();//自动刷新时间
						latestAuction();//更新一下最新的拍卖价格
						
						autoFlash();//竞拍中，需要不断刷新最新价格
					}else if(data.data.state == 4){
						//流拍
						$("#freezeBtn").html("拍卖已结束");
						
					}else if(data.data.state == 5){
						//成交
						$("#current_action_name").html("当前出价人：" + data.who);
						$("#current_price").html(data.price);
						$("#freezeBtn").html("拍卖已结束");
					}
				}else if(data.result == "error"){
					console.info("error");
				}
				
			},
			error:function(data){		console.info(data)		}
		});
	}
	
	
	
	//定时器，每5秒钟从服务器获取最新的竞拍价格和竞拍用户名称
	function autoFlash(){
		//30秒查询一次
		setInterval(latestAuction,10000);
	}
	
	function latestAuction(){
		$.ajax({
			url: rootPath + "/auction/latestAuction?itemId=" + id, 
			type: 'POST',  
			data:null,
			dataType:"JSON",
			async:true,
			success:function(data){
				console.info(data);
				if(data.result == "ok"){
					if(data.data.who != null){
						//如果已经有人出价了
						$("#current_action_name").html("当前出价人：" + data.data.who);
						$("#current_price").html(data.data.price.toFixed(2));
						auctioned = true;//标志位为true，意味着此刻竞拍金额不能等于起拍价
						currentPrice = data.data.price;//当前价格刷新
						$("#want_to_buy_money").val((data.data.price + moneyAdd).toFixed(2));//起拍价不能等于了
					}
				}else{
					errorPage();
				}
			},
			error:function(data){		console.info(data)		}
		});
	}
	
	
	

	//同意缴纳保证金按钮监听
	function pay_earnest_window_btn(){
		$("#pay_earnest_window_btn").click(function(){
			var l_pay_earnest_window_btn = Ladda.create( document.querySelector( '#pay_earnest_window_btn' ) );
			l_pay_earnest_window_btn.start();
			
			
			$.ajax({
				url: rootPath + "/auction/payAuctionFreeze?itemId=" + id, 
				type: 'POST',  
				data:null,
				dataType:"JSON",
				async:true,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						location.replace(location.href);
					}else if(data.result == "no"){
						alert("账户余额不足支付200元的保证金，请先进行冲值");
						console.info("replace");
						location.reload(true);
					}else{
						alert(error);
					}
				},
				error:function(data){		console.info(data)		}
			});
		});
	}
	

	
	//检测到如果是正在竞拍，则调用次方法，定时自动更新页面上的剩余时间
	function countDown(){
		
		var task = setInterval(leftTimeChange,1000);
		
		function leftTimeChange(){
			var currentDate = new Date();
			
			var date3=endDate.getTime()-currentDate.getTime(); //时间差秒
			if(date3==0){
				console.info("replace");
				location.reload(true);
			}
			if(date3<=0){
				clearInterval(task);
				$("#leftTime").html("剩余时间： ");
				return;
			}
			
			//计算出相差天数
			var _day=Math.floor(date3/(24*3600*1000));
			//计算出小时数
			var leave1=date3%(24*3600*1000);  //计算天数后剩余的毫秒数
			var _hour=Math.floor(leave1/(3600*1000));
			//计算相差分钟数
			var leave2=leave1%(3600*1000);       //计算小时数后剩余的毫秒数
			var _minute=Math.floor(leave2/(60*1000));
			//计算相差秒数
			var leave3=leave2%(60*1000);     //计算分钟数后剩余的毫秒数
			var _second=Math.round(leave3/1000);
			
			$("#leftTime").html(
					"剩余时间： "+
					_day + "天 " +
					_hour + ":" + _minute + ":" + _second
			);
			
			
		}
		
	}
	
	
	
});