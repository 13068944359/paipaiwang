$(function () {
	getPage(1);//页面初始化获取第一页的数据
	
	function getPage(pageNum){
		
		$.ajax({
			url: rootPath + "/auction/myAuction?page="+pageNum, 
			type: 'POST',  
			data:null,
			dataType:"JSON",
			async:true,
			success:function(data){
				console.info(data);
				if(data.result == "ok"){
					$(".row_myAuction").remove();//移除原来有的内容
					$("#loadingGif").remove();//移除loading.gif
					
					if(data.data.length == 0 ){
						$("#lengthZero").removeClass("display_none");
						return;
					}
					
					var htmlStr = "";
					$(data.data).each(function(index){
						
						var currentPriceCSS = "";
						if(this.currentPrice != this.myAuctionPrice){
							currentPriceCSS = "text-danger";//当前最高价格并非当前用户所出，用户需要另行竞拍，红色高亮提示
						}
						
						var leftTimeHtmlStr = "";
						var auctionStateHtmlStr = null;
						if(this.state == "竞拍中"){
							auctionStateHtmlStr = "竞拍中";
							//只有竞拍中的商品才需要显示倒数计时
							leftTimeHtmlStr = "				<div class='col-lg-4 col-md-4 col-sm-4 col-xs-12'>" +
											"					<p>剩余拍卖时间：" + getTimeLeft(this.endDate) + "</p>" +
											"				</div>";
						}else if(this.state == "竞拍成功"){
							auctionStateHtmlStr = "<span class='text-success'>竞拍成功</span>";
						}else if(this.state == "竞拍失败"){
							auctionStateHtmlStr = "<span class='text-danger'>竞拍失败</span>";
						}
						
						htmlStr = htmlStr +
							"<div class='row row_myAuction'>" +
							"	<div class='col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1'>" +
							"		<div  class='container row_myAuction_container'>" +
							"			<div class='row row_myAuction_container_row_title'>" +
							"				<div class='col-lg-4 col-md-4 col-sm-4 col-xs-6'>" +
							"					<p>卖家：" + this.seller + "</p>" +
							"				</div>" +
							"				<div class='col-lg-4 col-md-4 col-sm-4 col-xs-6'>" +
							"					<p>商品状态：" + auctionStateHtmlStr + "</p>" +
							"				</div>" +
							leftTimeHtmlStr +
							"			</div>" +
							"			<div class='row row_myAuction_container_row_content'>" +
							"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-6'>" +
							"					<img src='" + rootPath + "/picture/" + this.picture + "' onerror='this.src=\"" + rootPath + "/image/errorImg.jpg"  + "\"' class='img-thumbnail'  class='img-thumbnail'>" +
							"				</div>" +
							"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding'>" +
							"					<div class='itemId display_none'>" + this.itemId + "</div>" +
							"					<h4 class='itemName'>" + this.name + "</h4>" +
							"					<p>简介：" + this.brief + "</p>" +
							"				</div>" +
							"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding'>" +
							"					<p>当前价格</p>" +
							"					<p class='" + currentPriceCSS + "'>" + this.currentPrice.toFixed(2) + "元</p>" +
							"				</div>" +
							"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-12 content_row_padding'>" +
							"					<p>我的出价</p>" +
							"					<p>" + this.myAuctionPrice.toFixed(2) + "元</p>" +
							"				</div>" +
							"			</div>" +
							"		</div>" +
							"	</div>" +
							"</div>";
					});
					
					$("#beforeAuctionList").after(htmlStr);
					itemNameClick();//商品点击时间监听
					
					//页码
					var pageArray = getPageList(data.page,data.total);
					console.info(pageArray);
					$("#page_list_ul").html("");//清空原列表
					$("#page_list_row").removeClass("display_none");
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
					$(".pageNum").each(function(index){
						$(this).click(function(){
							getPage($(this).html());
						});
					});
					
					
					
				}else if(data.result == "error"){
					errorPage();
				}
			},
			error:function(data){		console.info(data);		}
		});
	}
	
	
	
	
	function itemNameClick(){
		$(".itemName").click(function(){
			location.replace(rootPath + "/page/itemPage?id=" +$(this).parent().find(".itemId").html());
		});
	}
	
	
	//计算出剩余时间
	function getTimeLeft(endDate){
		var currentDate = new Date();
		var date3=new Date(endDate).getTime()-currentDate.getTime(); //时间差秒
		
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
		
		return _day + "天 " +  _hour + ":" + _minute + ":" + _second
	}
	
	
	
});