$(function () {


	keyup_verify_listener();//焦点在输入框中时，keyup则会触发监听
	phone_check_num_btn();//获取验证码按钮的监听注册
	regist_submit_btn();//注册提交按钮监听注册
	finish_regist_btn();//注册完成按钮监听注册（模态框）
	cancel_finish_regist_btn();//不想继续完善注册信息了
	
	//焦点在输入框中时，keyup则会触发监听
	function keyup_verify_listener(){
		var input_phone = $("#input_phone");
		var input_name = $("#input_name");
		var input_pwd = $("#input_pwd");
		var input_pwd2 = $("#input_pwd2");
		var input_verify = $("#input_verify");
		var input_rule = $("#input_rule");
		var regist_submit_btn = $("#regist_submit_btn");
		regist_submit_btn.attr("disabled",true);
		
		var flag_phone = false;
		var flag_name = false;
		var flag_pwd = false;
		var flag_pwd2 = false;
		var flag_verify = false;
		var flag_rule = false;
		
		input_phone.keyup(function(){
			if(/^1[34578]\d{9}$/.test(input_phone.val())){
				$(".phone_success").removeClass("display_none");
				$(".phone_fail").addClass("display_none");
				$(".phone_existed").addClass("display_none");
				flag_phone = true;
				$("#phone_check_num_btn").attr("disabled",false);
			}else{
				flag_phone = false;
				$("#phone_check_num_btn").attr("disabled",true);
				$(".phone_success").addClass("display_none");
				$(".phone_fail").removeClass("display_none");
				$(".phone_existed").addClass("display_none");
			}
			verify_input();
		});
		input_name.keyup(function(){
			if(input_name.val().length<=8){
				flag_name = true;
				$(".name_success").removeClass("display_none");
				$(".name_fail").addClass("display_none");
			}else{
				flag_name = false;
				$(".name_fail").removeClass("display_none");
				$(".name_success").addClass("display_none");
			}
			verify_input();
		});
		input_pwd.keyup(function(){
			if( /^[0-9a-zA-Z]{6,18}$/.test(input_pwd.val()) ){
				flag_pwd = true;
				$(".pwd_success").removeClass("display_none");
				$(".pwd_fail").addClass("display_none");
			}else{
				flag_pwd = false;
				$(".pwd_success").addClass("display_none");
				$(".pwd_fail").removeClass("display_none");
			}
			if(input_pwd.val() != input_pwd2.val()){
				flag_pwd2 = false;
				$(".pwd2_success").addClass("display_none");
				$(".pwd2_fail").removeClass("display_none");
			}else{
				flag_pwd2 = true;
				$(".pwd2_success").removeClass("display_none");
				$(".pwd2_fail").addClass("display_none");
			}
			verify_input();
		});
		input_pwd2.keyup(function(){
			if(input_pwd.val() != input_pwd2.val()){
				flag_pwd2 = false;
				$(".pwd2_success").addClass("display_none");
				$(".pwd2_fail").removeClass("display_none");
			}else{
				flag_pwd2 = true;
				$(".pwd2_success").removeClass("display_none");
				$(".pwd2_fail").addClass("display_none");
			}
			verify_input();
		});
		input_verify.keyup(function(){
			if(input_verify.val().length == 4){
				flag_verify = true;
			}else{
				flag_verify = false;
			}
			verify_input();
		});
		input_rule.change(function(){
			if(input_rule.is(':checked')){
				flag_rule = true;
			}else{
				flag_rule = false;
			}
			verify_input();
		});
		
		//用于确认“提交”按钮是否要变成激活
		function verify_input(){
			if(flag_phone && flag_name && flag_pwd && flag_pwd2 && flag_verify && flag_rule){
				regist_submit_btn.attr("disabled",false);
			}else{
				regist_submit_btn.attr("disabled",true);
			}
			
		}//verify_input
		
	}//function
	
	//获取验证码按钮的监听注册
	function phone_check_num_btn(){
		$("#phone_check_num_btn").attr("disabled",true);
		$("#phone_check_num_btn").click(function(){
			console.info("start");
			var l_phone_check_num_btn = Ladda.create( document.querySelector( '#phone_check_num_btn' ) );
			l_phone_check_num_btn.start();
			//ajaxPost(postdata,posturl,returntype)
			var postdata = {
				"phone":$("#input_phone").val()
				};
			
			$.ajax({
				url:rootPath+"/user/getRegistVerifyCode",
				type: 'POST',  
				data:postdata,
				dataType:"JSON",
				async:true,
				success:function(data){
					if(data.result == "ok"){
						//发送手机验证码成功
						var t = 5;
						l_phone_check_num_btn.stop();
						$("#phone_check_num_btn").attr("disabled",true);
						$("#phone_check_num_btn").html("已发送(" + t + ")");
						var intever = setInterval(function(){
							t--;
							if(t == 0){
								clearInterval(intever);
								$("#phone_check_num_btn").html("再次发送");
								$("#input_phone").trigger("keyup");
								//为什么要用keyup呢，因为在定时器结束之前用户可能修改电话号码
								//这样的话定时任务执行完毕之后需要在此判断该按钮是否还激活
							}else{
								$("#phone_check_num_btn").html("已发送(" + t + ")");
							}
						},1000);
						
					}else if(data.result == "fail"){
						//该手机号码已经被使用过了
						$(".phone_success").addClass("display_none");
						$(".phone_fail").addClass("display_none");
						$(".phone_existed").removeClass("display_none");
						l_phone_check_num_btn.stop();
						$("#phone_check_num_btn").attr("disabled",true);
					}
				},
				error:function(data){		alert("error");		},
			});
		});
	}

	
	//注册提交按钮监听注册
	function regist_submit_btn(){
		var flag = true;//信息提交
			
		$("#regist_submit_btn").click(function(){
			var l_regist_submit_btn = Ladda.create( document.querySelector( "#regist_submit_btn" ) );
			l_regist_submit_btn.start();
			
			var postdata = {
					"phone":$("#input_phone").val(),
					"name":$("#input_name").val(),
					"pwd":$("#input_pwd").val(),
					"pwd2":$("#input_pwd2").val(),
					"verifyCode":$("#input_verify").val()
					};
			$.ajax({
				url:rootPath+"/user/registOne",
				type: 'POST',  
				data:postdata,
				dataType:"JSON",
				async:true,
				success:function(data){
					if(data.result == "ok"){
						//发送手机验证码成功
						$('#regist_window').modal({backdrop: 'static', keyboard: false});
						$('#regist_window').modal('show');
						l_regist_submit_btn.stop();
					}else if(data.result == "verifyCode"){
						$("#input_verify").val("");
						$("#input_verify").attr("placeholder","验证码错误");
						l_regist_submit_btn.stop();
						$("#input_verify").trigger("keyup");
					}else {
						console.info(data.result);
					}
				},
				error:function(data){		alert("error");		},
			});
				
		});//click
	}

	//注册完成按钮监听注册
	function finish_regist_btn(){
		$("#finish_regist_btn").click(function(){
			var l_finish_regist_btn = Ladda.create( document.querySelector( '#finish_regist_btn' ) );
//			inputErrorAnimation($("#realname").parent());
			
			//先检查是否全部填写
			var flag = true;
			if($("#realname").val() == ""){
				inputErrorAnimation($("#realname").parent());
				flag = false;
			}
			if($("#idcard").val() == ""){
				inputErrorAnimation($("#idcard").parent());
				flag = false;
			}
			if($("#email").val() == ""){
				inputErrorAnimation($("#email").parent());
				flag = false;
			}
			if($("#address").val() == ""){
				inputErrorAnimation($("#address").parent());
				flag = false;
			}
			if($("#postcode").val() == ""){
				inputErrorAnimation($("#postcode").parent());
				flag = false;
			}
			
			if(flag){
				l_finish_regist_btn.start();
				
				var gender = 0;
				if($("#inlineRadio1").attr("checked")){
					gender = 1;
				}
				//都有填写，下一步提交
				var postdata = {
						"realname":$("#realname").val(),
						"idcard":$("#idcard").val(),
						"email":$("#email").val(),
						"gender":gender,
						"address":$("#address").val(),
						"postcode":$("#postcode").val()
						};
				console.info(postdata);
				$.ajax({
					url:rootPath+"/user/registTwo",
					type: 'POST',  
					data:postdata,
					dataType:"JSON",
					async:true,
					success:function(data){
						if(data.result == "ok"){
							//完善注册信息成功
							window.location.href = rootPath;
						}else {
							console.info(data.result);
						}
					},
					error:function(data){		alert("error");		},
				});
				
			}
		});//click
		
		//限定一下输入内容的长度
		$("#realname").keyup(function(){
			//最长不给超过6
			if($("#realname").val().length == 7){
				$("#realname").val( $("#realname").val().substring( 0 , $("#realname").val().length-1 ) );
				return false;
			}
		});
		$("#postcode").keyup(function(){
			//最长不给超过6
			if($("#postcode").val().length == 7){
				$("#postcode").val( $("#postcode").val().substring( 0 , $("#postcode").val().length-1 ) );
				return false;
			}
		});
	}//function

	//不想继续完善注册信息了
	function cancel_finish_regist_btn(){
		$("#cancel_finish_regist_btn").click(function(){
			location.replace(location.href);
		});
	}
	

});