

var rootPath = "/PaiPaiWang";

/**
 * 同步ajax请求，注意请求过程中整个浏览器会锁住，无法进行任何操作
 * @param postdata 		要发送的json对象
 * @param posturl  		访问的链接
 * @param returntype 	返回的数据类型，主要是text和json
 * @作者 萧家洲
 */
function ajaxPost(postdata,posturl,returntype){
	var tempData = null;
	$.ajax({
		url:posturl,
		type: 'POST',  
		data:postdata,
		dataType:returntype,
		async:false,
		success:function(data){
			console.info(data);
			tempData = data;
		},
		error:function(data){		alert("error");		},
	});
	return tempData;
}


function trim(str){ //删除左右两端的空格
    return str.replace(/(^\s*)|(\s*$)/g, "");
}


//在指定元素后面添加新元素
function insertAfter(newElement, targetElement) { 
	// newElement是要追加的元素
	// targetElement 是指定元素的位置
	var parent = targetElement.parentNode; // 找到指定元素的父节点
	if (parent.lastChild == targetElement) { // 判断指定元素的是否是节点中的最后一个位置
												// 如果是的话就直接使用appendChild方法
		parent.appendChild(newElement, targetElement);
	} else {
		parent.insertBefore(newElement, targetElement.nextSibling);
	}	
}; 

//获取链接后的参数
function getParamOfUrl(){
	var thisURL = document.URL;    
	var item =thisURL.split('?')[1];
	return item;
}


//从cookie中获取保存的信息
function getCookie(c_name){
	console.info(document.cookie);
	if (document.cookie.length>0){　　
		//先查询cookie是否为空，为空就return ""
	　　　　　　c_start=document.cookie.indexOf(c_name + "=")　　
	  	//通过String对象的indexOf()来检查这个cookie是否存在，不存在就为 -1　　
	　　　　　　if (c_start!=-1){ 
	　　　　　　	c_start=c_start + c_name.length+1　　
	        	//最后这个+1其实就是表示"="号啦，这样就获取到了cookie值的开始位置
	　　　　　　	c_end=document.cookie.indexOf(";",c_start)　　
	  		//其实我刚看见indexOf()第二个参数的时候猛然有点晕，后来想起来表示指定的开始索引的位置...这句是为了得到值的结束位置。因为需要考虑是否是最后一项，所以通过";"号是否存在来判断
	　　　　　　	if (c_end==-1) c_end=document.cookie.length　　
	　　　　　　	return unescape(document.cookie.substring(c_start,c_end))　　
	      		//通过substring()得到了值。想了解unescape()得先知道escape()是做什么的，都是很重要的基础，想了解的可以搜索下，在文章结尾处也会进行讲解cookie编码细节
	　　　　　　} 
	　　　}
	　　　　return ""
	}　




//page当前页  total总页数
//函数用于返回个数为5的页码列表
function getPageList(page,total){
	var lastPage = null;
	var nextPage = null;
	
	if( page!=1 ){			
		lastPage = page - 1;		
	}else{
		lastPage = 1;
	}
	if(total != page){	
		nextPage = page+1;	
	}else{
		nextPage = page;
	}
	//前面这几行代码没有卵用，只是保留着做参考
	
	
	var left = 2;//标记，表示左边缺少两个
	var right = 2;//标记，表示右边缺少两个
	
	if( (page-2) >= 1 ){
		left = 0;//左边满足
	}else if( (page-1) == 1){
		left = 1;//左边还需要一个
	}
	
	if( (total-page) >=2 ){
		right = 0;//右边满足
	}else if( (total-page) >=1 ){
		right = 1;//右边还需要一个
	}
	
	if(left == 0 && right == 0){//左边和右边都满足了
		return [page-2 , page-1 , page , page+1 , page+2];
		
	}else if(left == 0 && right != 0){//右边没满足
		//右边只有一个
		if(right==1){
			if( (page-1-2) >= 1){
				//左边边至少有1个可用
				return [page-3, page-2 , page-1 , page , page+1 ];
			}else{
				//左边没有了
				return [page-2 , page-1 , page , page+1 ];
			}
		//右边一个都没有
		}else if(right==2){
			if( (page-1-2) >= 2 ){
				//左边有2个可用
				return [page-4 , page-3 , page-2 , page-1 , page];
			}else if( (page-1-2) == 1 ){
				//左边有1个可用
				return [page-3 , page-2 , page-1 , page];
			}else{
				//左边没有
				return [page-2 , page-1 , page  ];
			}
		}else{
			console.info("out");
		}
	}else if(left != 0 && right == 0){//左边边没满足
		console.info("left != 0 && right == 0");
		console.info(left);
		if(left==1){
			if( (total-page-2) >= 1 ){
				//左边只有1个，右边至少有1个可用
				return [ page-1 , page , page+1 , page+2 , page+3];
			}else{
				//右边没有可用的了
				return [ page-1 , page , page+1 , page+2 ];
			}
		}else if(left==2){
			if( (total-page-2) >= 2 ){
				//左边只有0个，右边至少有2个可用
				return [ page , page+1 , page+2 , page+3 , page+4];
			}else if( (total-page-2) == 1 ){
				//左边只有0个，右边只有1个可用
				return [ page , page+1 , page+2 , page+3];
			}else{
				//右边没有了
				return [ page , page+1 , page+2 ];
			}
		}else{
			console.info("out");
		}
		
	}else if(left != 0 && right != 0){//两边都没满足
		if( left==2 && right==2 ){
			return [page];
		}else if( left==1 && right==2 ){
			return [page-1 , page];
		}else if( left==2 && right==1 ){
			return [page , page+1];
		}else if( left==1 && right==1 ){
			return [page-1 , page , page+1];
		}
	}
}







////////////////////基于bootstrap的方法调用

/**
 * 输入框红色闪烁提醒
 * @param ele  		要闪烁的输入框外的div元素
 */
function inputErrorAnimation(ele){
	var times = 3;
	ele.addClass("has-error");
	var intever = setInterval(function(){
		
		if(times/2 == Math.ceil(times/2)){
			ele.addClass("has-error");
		}else{
			ele.removeClass("has-error");
		}
		
		times--;
		if(times==0){
			clearInterval(intever);
		}
		console.info("has-error");
	},500);
}















//////////////////////////////////

//   公用部分的js函数调用






//登录按钮监听注册（同时包涵cookie初始化）
function login_button_submit(){
	//如果标签不存在就不用继续往下执行了（报错问题）
	if( $("#login_button_submit").length == 0){		return ;	}

	
//	var myDate=new Date();    
//    myDate.setTime(-1000);//设置时间    
//    var data=document.cookie;    
//    var dataArray=data.split("; ");    
//    for(var i=0;i<dataArray.length;i++){    
//         var varName=dataArray[i].split("=");    
//         document.cookie=varName[0]+"=''; expires="+myDate.toGMTString();    
//    }   
//	var exdate=new Date();
//	exdate.setDate(exdate.getDate() + 30);
//	document.cookie = "phone=13123123123" +";expires="+exdate.toGMTString();
//	if(document.cookie.length == 0){
//		exdate.setDate(exdate.getDate() + 30);//+30表示有效期为30天（一个月）
//		exdate.to
//		document.cookie = "testName" +";expires="+exdate.toGMTString();
//	}else{
//		console.info(document.cookie);
//		console.info(document.cookie.length);
//	}
	
	var cookie_phone = getCookie("phone");
	console.info(cookie_phone);
	if(cookie_phone != ""){
		$("#login_username").val(cookie_phone);//如果有以保存的帐号则自动填入帐号框
		$("#remember_phone").attr("checked",true);//自动勾选上（记住帐号）
	}

	$("#login_button_submit").click(function(){
		var l_login_button_submit = Ladda.create( document.querySelector( '#login_button_submit' ) );
		
		if($("#login_username").val() == "" || $("#login_pwd").val() == ""){
			$("#login_window_message").html("帐号或者密码为空");//错误提示信息
			return;
		}
		
		l_login_button_submit.start();
		var postdata = {
				"phone":$("#login_username").val(),
				"pwd":$("#login_pwd").val()
				};
		console.info(postdata);
		$.ajax({
			url:"/PaiPaiWang/user/login",
			type: 'POST',  
			data:postdata,
			dataType:"JSON",
			async:true,
			success:function(data){
				console.info(data);
				if(data.result == "ok"){
					//登录成功了再记住帐号
					var exdate=new Date();
					exdate.setDate(exdate.getDate() + 30);
					if($("#remember_phone").get(0).checked){
						document.cookie = "phone=" + $.trim($("#login_username").val()) +";path=/;expires="+exdate.toGMTString();
					}else{
						document.cookie = "phone=" + ";expires="+exdate.toGMTString();
					}
					//登录成功
					location.reload(true);
				}else if(data.result == "error"){
					//跳转到错误提示页面
				}else if(data.result == "phone"){
					$("#login_window_message").html("帐号不存在");//错误提示信息
					l_login_button_submit.stop();
				}else if(data.result == "pwd"){
					$("#login_window_message").html("密码错误");//错误提示信息
					l_login_button_submit.stop();
				}else {
					console.info(data.result);
				}
			},
			error:function(data){		console.info(data);		},
		});//ajax
	});
}
login_button_submit();//自动调用




//监听登录点击事件，点击“请登录”则会弹出登录窗口，每次打开窗口都清空错误提示信息
function open_login_window(){
	//如果标签不存在就不用继续往下执行了（报错问题）
	if( $("#open_login_window").length == 0){		return ;	}
	
	$('#open_login_window').click(function(){
		$('.bs-example-modal-sm').modal('show');

		//清空错误提示信息
		$("#login_window_message").html("");
	});
}
open_login_window();//自动调用


//用户点击注销当前用户按钮
function logout_btn(){
	//如果标签不存在就不用继续往下执行了（报错问题）
	if( $("#logout").length == 0){		return ;	}
	
	$('#logout').click(function(){
		var data = {};
		ajaxPost(data,rootPath+"/user/logout","JSON");
		location.reload(true);
	});
}
logout_btn();//自动调用


//判断当前用户是否已经登录并返回boolean值
function check_login(){


}



function errorPage(){
	location.replace(rootPath + "/page/message");
}































