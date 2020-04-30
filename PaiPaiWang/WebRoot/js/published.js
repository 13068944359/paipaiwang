$(function () {

	getPage(1);//页面初始化获取第一页的数据
	
	
	function getPage(pageNum){
		$(".item_published").each(function(){
			$(this).remove();
		});
		$("#page_list_ul").html("");//清空原页码列表
		$("#loadingGif").removeClass("display_none");
		
		$.ajax({
			url: rootPath + "/item/publishedPage?page="+pageNum, 
			type: 'POST',  
			data:null,
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
					
					var rows = $(data.data);
					rows.each(function(index){

						var nameLink = null;//根据物品当前状态，决定物品名称是否为跳转到详情页面的超链接，如果尚未通过审核则不给展示
						if(this.state != 0 && this.state != 1){
							nameLink = "<a href='" + rootPath + "/page/itemPage?id=" + this.id + "'><h4>" + this.name + "</h4></a>";
						}else{
							nameLink = "<a href='#'><h4>" + this.name + "</h4></a>";
						}
						
						var stateValue = null;
						if(this.state == 0){
							stateValue = "<p>状态：待审核</p>";
						}else if(this.state == 1){
							stateValue = "<p class='text-danger'>状态：未通过审核</p>";
						}else if(this.state == 2){
							stateValue = "<p>状态：审核通过</p>";
						}else if(this.state == 3){
							stateValue = "<p  class='text-primary'>状态：拍卖中</p>";
						}else if(this.state == 4){
							stateValue = "<p class='text-danger'>状态：流拍</p>";
						}else if(this.state == 5){
							stateValue = "<p  class='text-success'>状态：成交</p>";
						}
						
						$("#page_list_row").before(
								"<div class='row item_published'>"+
								"	<div class='col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1 '>"+
								"		<div  class='container item_published_container'>"+
								"			<div class='row item_published_container_row_title'>"+
								"				<div class='col-lg-4 col-md-4 col-sm-4 col-xs-6'>"+
								"					<p>发布日期：" + this.publishTime + "</p>"+
								"				</div>"+
								"				<div class='col-lg-6 col-md-6 col-sm-6 col-xs-8'>"+
								stateValue +
								"				</div>"+
								"			</div>"+
								"			<div class='row item_published_container_row_content'>"+
								"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-6'>"+
								"					<img src='" + rootPath + "/picture/" + this.picture + "' onerror='this.src=\"" + rootPath + "/image/errorImg.jpg"  + "\"' class='img-thumbnail'>"+
								"				</div>"+
								"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-6 content_row_padding'>"+
								nameLink +
								"					<p>简介：" + this.brief + "</p>"+
								"				</div>"+
								"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding'>"+
								"					<p>商品底价：" + this.price + "元</p>"+
								"					<p>开始日期：" + this.startDate + "</p>"+
								"					<p>结束日期：" + this.endDate + "</p>"+
								"				</div>"+
								"				<div class='col-lg-3 col-md-3 col-sm-3 col-xs-6 hidden-xs content_row_padding'>"+
								"					<p>数量：" + this.number + "</p>"+
								"					<p>竞拍阶梯：" + this.priceAdd + "元</p>"+
								"					<p>商品种类：" + this.type + "</p>"+
								"				</div>"+
								"			</div>"+
								"		</div><!-- container -->"+
								"	</div>"+
								"</div><!-- row -->"+
								""
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
						
						$(".pageNum").each(function(index){
							$(this).click(function(){
								getPage($(this).html());
							});
						});
					}//if
				
				}else if(data.result == "error"){
					errorPage();
				}
				
			},
			error:function(data){		alert("error");		}
		});
	}
	
});