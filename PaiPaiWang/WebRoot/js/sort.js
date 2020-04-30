$(function () {

	var paraStr = getParamOfUrl();
	var typeStr = paraStr.split('&')[0];
	var keyStr = paraStr.split('&')[1];
	
	var type = typeStr.split('=')[1];
	var key = keyStr.split('=')[1];
	
	if(type == "search"){
		key = unescape(key);//由于包涵中文，编码问题需要解决,原来使用escape()方法被替换成了十六进制的转义序列，现在使用unescape方法反编码
	}
	
	
	if(type != "sort" && type!="search" && type!="everyday"){
		console.info("type null");//违法操作
		return;
	}
	
	
	getPage(1);
	initPathAndActiveNav();//页面路径和分类栏名称
	
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
	
	
	//分页
	function getPage(page){
		var postData = {
				"type":type,
				"key":key,
				"page":page
		};
		
		$.ajax({
			url: rootPath + "/item/sortPage", 
			type: 'POST',  
			data:postData,
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
						
						htmlStr = htmlStr + 
							"<div class='col-lg-2 col-md-3 col-sm-4 col-xs-6'>" +
							"	<div class='item'>"+
							"		<div class='itemId display_none'>" + this.id + "</div>"+
							"		<div class='picture'>"+
							"			<img  class='itemPicture' src='" + rootPath + "/picture/" + this.picture  + "' onerror='this.src=\"" + rootPath + "/image/errorImg.jpg"  + "\"'>"+
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
					
					itemClickListener();//注册商品图片和名称点击监听
					collectBtnListener();//注册收藏按钮点击监听
					
					
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
	
	
	//页面的分类路径显示
	function initPathAndActiveNav(){
		if(type == "sort"){
			var pathStr = "";
			if(key == 2){
				pathStr = "&nbsp;&nbsp;&nbsp;书法绘画&nbsp;/&nbsp;绘画";
				$("#li1").addClass("active");
			}else if(key == 3){
				pathStr = "&nbsp;&nbsp;&nbsp;书法绘画&nbsp;/&nbsp;书法";
				$("#li1").addClass("active");
			}else if(key == 4){
				pathStr = "&nbsp;&nbsp;&nbsp;书法绘画&nbsp;/&nbsp;古籍文献";
				$("#li1").addClass("active");
			}else if(key == 6){
				pathStr = "&nbsp;&nbsp;&nbsp;西画雕塑&nbsp;/&nbsp;油画";
				$("#li2").addClass("active");
			}else if(key == 7){
				pathStr = "&nbsp;&nbsp;&nbsp;西画雕塑&nbsp;/&nbsp;水彩";
				$("#li2").addClass("active");
			}else if(key == 8){
				pathStr = "&nbsp;&nbsp;&nbsp;西画雕塑&nbsp;/&nbsp;雕塑";
				$("#li2").addClass("active");
			}else if(key == 10){
				pathStr = "&nbsp;&nbsp;&nbsp;古瓷珠宝&nbsp;/&nbsp;玉器";
				$("#li3").addClass("active");
			}else if(key == 11){
				pathStr = "&nbsp;&nbsp;&nbsp;古瓷珠宝&nbsp;/&nbsp;陶瓷";
				$("#li3").addClass("active");
			}else if(key == 12){
				pathStr = "&nbsp;&nbsp;&nbsp;古瓷珠宝&nbsp;/&nbsp;木器";
				$("#li3").addClass("active");
			}else if(key == 14){
				pathStr = "&nbsp;&nbsp;&nbsp;当代工艺&nbsp;/&nbsp;珠宝";
				$("#li4").addClass("active");
			}else if(key == 15){
				pathStr = "&nbsp;&nbsp;&nbsp;当代工艺&nbsp;/&nbsp;金属器";
				$("#li4").addClass("active");
			}else if(key == 16){
				$("#li5").addClass("active");
			}else if(key == 17){
				$("#li6").addClass("active");
			}
			
			$("#path").html(pathStr);
		}else if(type == "everyday"){
			$("#li7").addClass("active");
		}
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