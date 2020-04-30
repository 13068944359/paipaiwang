$(function () {

	initAdv();//初始化轮播图
	carousel_btn_center();//设置轮播图中的按钮垂直居中
	carousel_auto();//轮播自动播放
	initItem();
	
	SearchBtnClick();//搜索按钮点击注册
	
	
	
	//搜索按钮点击注册
	function SearchBtnClick(){
		$("#search_btn").click(function(){
			var keyWord = $("#search_frame").val();
			if(keyWord != ""){
				location.replace(rootPath + "/page/sort?type=search&key=" + escape(keyWord));
			}
		});
	}
	
	//获取首页展示的商品列表
	function initItem(){
		
		$.ajax({
			url: rootPath + "/item/homepageItem", 
			type: 'POST',  
			data:null,
			dataType:"JSON",
			async:true,
			success:function(data){
				console.info(data);
				if(data.result == "ok"){
					$("#item_loading").addClass("display_none");
					
					if(data.data.length == 0 ){
						$("#lengthZero").removeClass("display_none");
						return;
					}
					
					var htmlStr = "";
					$(data.data).each(function(index){
						
						//布局问题，当lg的时候，每5个一行
						if(index%5 == 0){
							htmlStr = htmlStr + "<div class='col-lg-2 col-md-3 col-sm-4 col-xs-6  col-lg-offset-1'>";
						}else{
							htmlStr = htmlStr + "<div class='col-lg-2 col-md-3 col-sm-4 col-xs-6 '>";
						}
						
						htmlStr = htmlStr + 
							"	<div class='item'>"+
							"		<div class='itemId display_none'>" + this.id + "</div>"+
							"		<div class='picture'>"+
							"			<img  class='itemPicture' src='" + rootPath + "/picture/" + this.picture  + "' onerror='this.src=\"" + rootPath + "/image/errorImg.jpg"  + "\"' >"+
							"		</div>"+
							""+
							"		<h5 class='itemName'>" + this.name + "</h5>"+
							"		<span class='price'>￥" + this.currentPrice.toFixed(2) + "</span>"+
							"		<p class='offline_time'>下线时间：" + this.endDate + "</p>";
						if(this.collected){
							htmlStr = htmlStr + "<a href='#' class='collection collected'><span class='glyphicon glyphicon-heart'>已收藏</span></a>";
						}else{
							htmlStr = htmlStr + "<a href='#' class='collection uncollected'><span class='glyphicon glyphicon-heart-empty'>点击收藏</span></a>";
						}
						
						htmlStr = htmlStr + 
							"	</div>"+
							"</div>";
					});//each
					
					$("#item_row").html(htmlStr);
					$("#item_row").removeClass("display_none");
					
					itemClickListener();//注册商品图片和名称点击监听
					collectBtnListener();//注册收藏按钮点击监听
					
					
				}else if(data.result == "error"){
					errorPage();//跳转错误提示页面
				}
			},
			error:function(data){		alert("error");		},
		});
		
		
		
	}

	//初始化轮播图
	function initAdv(){
		$.ajax({
			url: rootPath + "/adv/advPictures", 
			type: 'POST',  
			data:null,
			dataType:"JSON",
			async:true,
			success:function(data){
				console.info(data);
				if(data.result == "ok"){
					
					$("#advPictureFirstA").attr("href",data.data[0].url);
					$("#advPictureSecondA").attr("href",data.data[1].url);
					$("#advPictureThirdA").attr("href",data.data[2].url);
					$("#advPictureForthA").attr("href",data.data[3].url);
					
					$("#advPictureFirstI").attr("src",rootPath + "/picture/" +data.data[0].picture);
					$("#advPictureSecondI").attr("src",rootPath + "/picture/" +data.data[1].picture);
					$("#advPictureThirdI").attr("src",rootPath + "/picture/" +data.data[2].picture);
					$("#advPictureForthI").attr("src",rootPath + "/picture/" +data.data[3].picture);

					//alt属性并不能生效，因为轮播图的a标签影响
//					$("#advPictureFirstI").attr("alt",data.data[0].title);
//					$("#advPictureSecondI").attr("alt",data.data[1].title);
//					$("#advPictureThirdI").attr("alt",data.data[2].title);
//					$("#advPictureForthI").attr("alt",data.data[3].title);


					$("#adv_row").removeClass("display_none");
				}else if(data.result == "error"){
					//跳转错误提示页面
				}
			},
			error:function(data){		console.info(data);		},
		});
	}
	
	


	//设置轮播图中的按钮垂直居中
	function carousel_btn_center(){
		$('.carousel-control').css('line-height', $('.carousel-inner img').height() + 'px');
		$(window).resize(function () {
			var $height = $('.carousel-inner img').eq(0).height() || 
						  $('.carousel-inner img').eq(1).height() || 
						  $('.carousel-inner img').eq(2).height();
			$('.carousel-control').css('line-height', $height + 'px');
		});
	}
	//轮播自动播放
	function carousel_auto(){
		$('#paipai_carousel').carousel({
			//自动4秒播放
			interval : 4000,
		});

	}

	//注册商品图片和名称点击监听
	function itemClickListener(){
		$(".itemName").click(function(){
			itemClick($(this).parent().find(".itemId").html());
		});
		$(".itemPicture").click(function(){
			itemClick($(this).parent().parent().find(".itemId").html());
		});
	}
	//点击图片和商品名称则会跳转到商品的竞拍页面
	function itemClick(itemId){
		location.replace(rootPath + "/page/itemPage?id=" + itemId);
	}
	
	
	var resultflag;
	//注册收藏按钮点击监听
	function collectBtnListener(){
		$('.collected').unbind();
		$(".collected").click(function(){
			collectBtn($(this).parent().parent().find(".itemId").html(),false);
			console.info(resultflag);
			if(resultflag){
				$(this).removeClass("collected");
				$(this).addClass("uncollected");
				$(this).html("<span class='glyphicon glyphicon-heart-empty'>点击收藏</span>");
				collectBtnListener();
			}
		});
		$('.uncollected').unbind();
		$(".uncollected").click(function(){
			collectBtn($(this).parent().parent().find(".itemId").html(),true);
			if(resultflag){
				$(this).removeClass("uncollected");
				$(this).addClass("collected");
				$(this).html("<span class='glyphicon glyphicon-heart'>已收藏</span>");
				collectBtnListener();
			}
		});
	}
	//请求更改收藏状况
	function collectBtn(itemId,flag){
		var postData = {
				"id" : itemId,
				"flag":flag
		};		
		
		$.ajax({
			url: rootPath + "/item/changeItemCollect", 
			type: 'POST',  
			data:postData,
			dataType:"JSON",
			async:false,
			success:function(data){
				console.info(data);
				if(data.result == "ok"){
					resultflag =  true;
				}else if(data.result == "unlogin"){
					$('.bs-example-modal-sm').modal('show');
					//清空错误提示信息
					$("#login_window_message").html("");
					resultflag =  false;
				}else if(data.result == "error"){
					errorPage();//跳转错误提示页面
				}
			},
			error:function(data){		console.info(data);	},
		});
	}
	
});