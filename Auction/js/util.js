
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























//////////////////////////////////

//   公用部分的js函数调用






//登录按钮监听注册
function login_button_submit(){
	//如果标签不存在就不用继续往下执行了（报错问题）
	if( $("#login_button_submit").length == 0){		return ;	}

	var l_login_button_submit = Ladda.create( document.querySelector( '#login_button_submit' ) );
	$("#login_button_submit").click(function(){
		
		l_login_button_submit.toggle();
		//模拟错误提示信息
		$("#login_window_message").html("密码错误");
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






//判断当前用户是否已经登录并返回boolean值
function check_login(){


}



//判断当前用户是否已经登录，若未登录，则直接返回首页
function check_login_return_homepage(){


}






























