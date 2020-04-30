$(function () {
	getPage(1);//页面初始化获取第一页的数据
	
	function getPage(pageNum){
		
		$.ajax({
			url: rootPath + "/item/collectionPage?page="+pageNum, 
			type: 'POST',  
			data:null,
			dataType:"JSON",
			async:true,
			success:function(data){
				console.info(data);
				if(data.result == "ok"){
					$("#item_row").html("");
					$("#loadingGif").remove();//移除loading.gif
					if(data.data.length == 0 ){
						$("#lengthZero").removeClass("display_none");
						return;
					}
					
					var htmlStr = "";
					$(data.data).each(function(index){
						htmlStr = htmlStr +
						"<div class='col-lg-2 col-md-3 col-sm-4 col-xs-6'>" +
						"	<div class='item'>" +
						"		<div class='picture'>" +
						"			<img class='itemPicture' src='" + rootPath + "/picture/" + this.picture + "' onerror='this.src=\"" + rootPath + "/image/errorImg.jpg"  + "\"'  >" +
						"		</div>" +
						"		<div class='itemId display_none'>" + this.id + "</div>" +
						"		<h5 class='itemName'>" + this.name + "</h5>" +
						"		<span class='price'>￥" + this.currentPrice.toFixed(2) + "</span>" +
						"		<p class='offline_time'>下线时间：" + this.endDate + "</p>" +
						"		<a href='#' class='collection'><span class='glyphicon glyphicon-trash delete_collection'></span></a>" +
						"	</div>" +
						"</div>";
					});
					
					$("#item_row").html(htmlStr);
					itemClick();//点击图片和名称都能进行页面跳转
					deleteCollectionClick();//删除按钮
					
					//页码
					var pageArray = getPageList(data.page,data.total);
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
	
	
	
	function itemClick(){
		$(".itemName").click(function(){
			location.replace(rootPath + "/page/itemPage?id=" +$(this).parent().find(".itemId").html());
		});
		$(".itemPicture").click(function(){
			location.replace(rootPath + "/page/itemPage?id=" +$(this).parent().parent().find(".itemId").html());
		});
	}
	
	
	function deleteCollectionClick(){
		
		$(".collection").click(function(){
			var itemId = $(this).parent().find(".itemId").html();
			
			var postData = {
					"id":itemId,
					"flag":false
			};
			
			$.ajax({
				url: rootPath + "/item/changeItemCollect", 
				type: 'POST',  
				data:postData,
				dataType:"JSON",
				async:true,
				success:function(data){
					console.info(data);
				},
				error:function(data){		console.info(data);		}
			});
			
			$(this).parent().parent().remove();
		});
	}
	
});