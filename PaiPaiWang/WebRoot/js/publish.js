$(function () {



	validationInit();//校验部分以及日期控件初始化以及初始校验
	btnLoading();//按钮动画部分





	//校验部分以及日期控件初始化以及初始校验
	function validationInit(){
		var  publish_form = document.forms['publish_form'];



		form_check();//一进来页面就校验

		// <select class="form-control" id="item_type_first">
		//   <option value="no">- 请选择 -</option>
		//   <option value="shufa">书法绘画</option>
		//   <option value="xihua">西画雕塑</option>
		//   <option value="guci">古瓷珠宝</option>
		//   <option value="dangdai">当代工艺</option>
		//   <option value="zahuo">各类杂货</option>
		//   <option value="ershou">二手商品</option>
		// </select>
		var shufa = '<select class="form-control" id="item_type_second" name="item_type_second">'+
					'  <option value="no">- 请选择 -</option>'+
					'  <option value="huihua">绘画</option>'+
					'  <option value="shufa">书法</option>'+
					'  <option value="gujiwenxian">古籍文献</option>'+
					'</select>';
		var xihua = '<select class="form-control" id="item_type_second" name="item_type_second">'+
					'  <option value="no">- 请选择 -</option>'+
					'  <option value="youhua">油画</option>'+
					'  <option value="shuicai">水彩</option>'+
					'  <option value="diaosu">雕塑</option>'+
					'</select>';
		var guci  = '<select class="form-control" id="item_type_second" name="item_type_second">'+
					'  <option value="no">- 请选择 -</option>'+
					'  <option value="yuqi">玉器</option>'+
					'  <option value="taoci">陶瓷</option>'+
					'  <option value="muqi">木器</option>'+
					'</select>';
		var dangdai='<select class="form-control" id="item_type_second" name="item_type_second">'+
					'  <option value="no">- 请选择 -</option>'+
					'  <option value="zhubao">珠宝</option>'+
					'  <option value="jinshuqi">金属器</option>'+
					'</select>';
		$('#item_type_first').change(function(){
			$('#item_type_second').remove();

			if(this.value == 'shufa'){
				$('#item_type_first').after(shufa);
			}else if(this.value == 'xihua'){
				$('#item_type_first').after(xihua);
			}else if(this.value == 'guci'){
				$('#item_type_first').after(guci);
			}else if(this.value == 'dangdai'){
				$('#item_type_first').after(dangdai);
			}

			$(publish_form. item_type_second).change(function(){
				check_type();// 商品类型
			});
		});


		
		//提交按钮
		$('#publish_submit').click(function(){
			form_check();
			
			if($(".has-error").length==0 ){

	      	  	$('#pay_earnest_window').modal('show');	//弹出缴纳保证金的弹窗
				
				
			}//if
		});


		//表单总校验，方便调用
		function form_check(){
			// console.info(publish_form.item_name.value);

			//表单校验
			check_name();// 判断商品名称
			check_number();// 商品数量
			check_price();// 商品价格
			check_date();// 商品有效日期
			check_type();//商品类型
			check_price_add();// 竞拍阶梯
			check_picture_1();//第一张图片

			if(publish_form.item_picture_1.value == ""){
				$('.has_error_item_picture').addClass("has-error");
			}else{
				$('.has_error_item_picture').removeClass("has-error");
			}
			// if(publish_form.item_identify_picture.value == ""){
				
			// }else{
			// 	$('.has_error_item_identify_picture').removeClass("has-error");
			// }

			/*
			var publish_form = document.getElementById("publish_form");
			//更改请求的url
			publish_form.action = "hello.html";

			publish_form.submit(); 
			*/




			// console.info(publish_form);
		}


		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		///////    校验部分

		$(publish_form.item_name).keyup(function(){
			check_name();// 判断商品名称
		});

		$(publish_form.item_brief).keyup(function(){
			check_brief();// 判断商品简介
		});
		
		$(publish_form.item_number).keyup(function(){
			check_number();// 商品数量
		});

		$(publish_form.item_price).keyup(function(){
			check_price();// 商品价格
		});

		$(publish_form.item_publish_date_from).change(function(){
			check_date();// 商品日期
		});
		$(publish_form.item_publish_date_to).change(function(){
			check_date();// 商品日期
		});

		$(publish_form.item_type_first).change(function(){
			check_type();// 商品类型
		});
		
		$(publish_form.item_price_add).change(function(){
			check_price_add();// 竞拍阶梯
		});
		$(publish_form.item_picture_1).change(function(){
			check_picture_1();//商品图片1
		});
		$(publish_form.item_picture_2).change(function(){
			check_picture_2();//商品图片2
		});
		$(publish_form.item_picture_3).change(function(){
			check_picture_3();//商品图片2
		});


		$(publish_form.item_identify_picture).change(function(){
			check_identify_picture();//商品鉴定图片
		});



		//判断商品简介
		function check_brief(){
			var item_brief_length = publish_form.item_brief.value.length;
			if( item_brief_length > 20){
				$('.has_error_item_brief').addClass('has-error');
			}else{
				$('.has_error_item_brief').removeClass('has-error');
			}
		}


		// 判断商品数量
		function check_number(){
			var item_num = publish_form.item_number.value;
			if(!(/^(\+|-)?\d+$/.test( item_num )) || item_num <= 0 || item_num > 10000){
				$('.has_error_item_number').addClass('has-error');
			}else{
				$('.has_error_item_number').removeClass('has-error');
			}
		}

		// 判断商品名称
		function check_name(){

			var item_name_length = publish_form.item_name.value.length;
			// console.info("item_name_length="+item_name_length);
			if(item_name_length == 0 || item_name_length > 10){
				$('.has_error_item_name').addClass('has-error');
			}else{
				$('.has_error_item_name').removeClass('has-error');
			}
		}

		// 判断商品价格
		function check_price(){
			var item_price = publish_form.item_price.value;
			if(!(/^(\+|-)?\d+$/.test( item_price )) || item_price < 0){
				$('.has_error_item_price').addClass('has-error');
			}else{
				$('.has_error_item_price').removeClass('has-error');
			}
		}

		// 判断商品有效日期
		function check_date(){
			var dateObj = new Date();
			var today_str = dateObj.getFullYear() + "/" + (dateObj.getMonth()+1) + "/" +  dateObj.getDate() ;
			var today = new Date(  today_str  );
			// console.info(today);

			//判断开始日期是否大于今天
			if(publish_form.item_publish_date_from.value != ""){
				var dateFrom = new Date(publish_form.item_publish_date_from.value);
				//类型转换时，Date对象的实例如果转为数值，则等于对应的毫秒数；
				//如果转为字符串，则等于对应的日期字符串。
				//所以，两个日期对象进行减法运算，返回的就是它们间隔的毫秒数；
				//进行加法运算，返回的就是连接后的两个字符串
				//更多详情：http://www.tuicool.com/articles/QrUrQjQ
				if((dateFrom - today) >= 0){
					//开始时间大于今天
				}else{
					//开始时间小于今天
					$("#item_publish_date_tip").html("开始日期必须大于今天");
					publish_form.item_publish_date_from.value="";
				}
				console.info("dateFrom=" + dateFrom);
			}

			//判断结束日期是否大于今天
			if(publish_form.item_publish_date_to.value != ""){
				var dateTo = new Date(publish_form.item_publish_date_to.value);
				console.info(dateTo - today);
				if((dateTo - today) >= 0){
					//结束时间大于今天
				}else{
					//结束时间小于今天
					$("#item_publish_date_tip").html("结束日期必须大于今天");
					publish_form.item_publish_date_to.value="";
				}
			}

			//判断持续时间是否超过三天
			if(publish_form.item_publish_date_from.value != "" && publish_form.item_publish_date_to.value != ""){
				var dateFrom = new Date(publish_form.item_publish_date_from.value);
				var dateTo = new Date(publish_form.item_publish_date_to.value);

				if((dateTo - dateFrom) < 0){
					//结束时间应该大于开始时间的
					$("#item_publish_date_tip").html("结束日期必须大于开始日期");
					publish_form.item_publish_date_to.value="";
				}else if((dateTo - dateFrom) > 172800000){
					//持续时间应该小于三天的  (3-1)*24*3600*1000  为什么要-1呢，因为第三天本来应该是需要+那天0点之后的24小时的，那反过来就是-1天了
					$("#item_publish_date_tip").html("持续时间不能超过3天");
					publish_form.item_publish_date_to.value="";
					publish_form.item_publish_date_from.value="";
				}
			}


			if(publish_form.item_publish_date_from.value == "" || publish_form.item_publish_date_to.value == ""){
				$('.has_error_item_publish_date').addClass('has-error');
			}else{
				$('.has_error_item_publish_date').removeClass('has-error');
			}
		}


		// 商品类型
		function check_type(){
			// 先判断是否有二级菜单
			// console.info('check_type');
			if(publish_form.item_type_second){
				if(publish_form.item_type_second.value == "no"){
					$('.has_error_item_type').addClass('has-error');
				}else{
					$('.has_error_item_type').removeClass('has-error');
				}
			}else{
				if(publish_form.item_type_first.value == "no"){
					$('.has_error_item_type').addClass('has-error');
				}else{
					$('.has_error_item_type').removeClass('has-error');
				}
			}
		}


		//竞价阶梯
		function check_price_add(){
			if(publish_form.item_price_add.value == "no"){
				$('.has_error_item_price_add').addClass('has-error');
			}else{
				$('.has_error_item_price_add').removeClass('has-error');
			}
		}


		//商品图片文件1输入框发生变化监听      
		function check_picture_1(){
			if($(publish_form.item_picture_1).val()==""){				
				$('.has_error_item_picture').addClass("has-error");	
				//隐藏图片行并
				var pic = document.getElementById("img1");
		        pic.src="";
			    $("#img_row").addClass("nondisplay");
				return;				
			}
			
			var fileName=publish_form.item_picture_1.value;  
			var suffixIndex=fileName.lastIndexOf(".");  
			var suffix=fileName.substring(suffixIndex+1).toUpperCase();  
			if(suffix!="JPG"&&suffix!="JPEG"&&suffix!="PNG"){  
				alert("请上传格式正确的图片文件");
				$('.has_error_item_picture').addClass("has-error");
				$(publish_form.item_picture_1).val('');
				
				//隐藏图片行并
				var pic = document.getElementById("img1");
		        pic.src="";
			    $("#img_row").addClass("nondisplay");
				return;
			}else{
				$('.has_error_item_picture').removeClass("has-error");
				//把图片显示到img标签上并且显示图片一整行的div标签
				var file = publish_form.item_picture_1.files[0]; 
			    var reader = new FileReader();
			    reader.readAsDataURL(file);
			    reader.onload = function(e){
					var pic = document.getElementById("img1");
			        pic.src=this.result;
			    }
			    $("#img_row").removeClass("nondisplay");
			}
		}


		//商品图片文件2输入框发生变化监听      
		function check_picture_2(){
			if($(publish_form.item_picture_2).val()==""){
				var pic = document.getElementById("img2");
		        pic.src="";
				return;				
			}
			// console.info("check_identify_picture");
			var fileName=publish_form.item_picture_2.value;  
			var suffixIndex=fileName.lastIndexOf(".");  
			var suffix=fileName.substring(suffixIndex+1).toUpperCase();  
			if(suffix!="JPG"&&suffix!="JPEG"&&suffix!="PNG"){  
				alert("请上传格式正确的图片文件");
				publish_form.item_picture_2.value = "";
				
				var pic = document.getElementById("img2");
		        pic.src="";
				return;
			}else{
				//显示图片
				var file = publish_form.item_picture_2.files[0]; 
			    var reader = new FileReader();
			    reader.readAsDataURL(file);
			    reader.onload = function(e){
					var pic = document.getElementById("img2");
			        pic.src=this.result;
			    }
			}
		}

		//商品图片文件2输入框发生变化监听      
		function check_picture_3(){
			if($(publish_form.item_picture_3).val()==""){
				var pic = document.getElementById("img3");
		        pic.src="";
				
				return;				
			}
			// console.info("check_identify_picture");
			var fileName=publish_form.item_picture_3.value;  
			var suffixIndex=fileName.lastIndexOf(".");  
			var suffix=fileName.substring(suffixIndex+1).toUpperCase();  
			if(suffix!="JPG"&&suffix!="JPEG"&&suffix!="PNG"){  
				alert("请上传格式正确的图片文件");
				publish_form.item_picture_3.value = "";
				
				var pic = document.getElementById("img3");
		        pic.src="";
				return;
			}else{
				//显示图片
				var file = publish_form.item_picture_3.files[0]; 
			    var reader = new FileReader();
			    reader.readAsDataURL(file);
			    reader.onload = function(e){
					var pic = document.getElementById("img3");
			        pic.src=this.result;
			    }
			}
		}





		//商品鉴定图片文件输入框发生变化监听      
		function check_identify_picture(){
			if($(publish_form.item_identify_picture).val()==""){
				$("#verify_img_row").addClass("nondisplay");
				return;				
			}
			// console.info("check_identify_picture");
			var fileName=publish_form.item_identify_picture.value;  
			var suffixIndex=fileName.lastIndexOf(".");  
			var suffix=fileName.substring(suffixIndex+1).toUpperCase();  
			if(suffix!="JPG"&&suffix!="JPEG"&&suffix!="PNG"){  
				alert("请上传格式正确的图片文件");
				publish_form.item_identify_picture.value = "";

			    $("#verify_img_row").addClass("nondisplay");
				return;
			}else{
				//把图片显示到img标签上并且显示图片一整行的div标签
				var file = publish_form.item_identify_picture.files[0]; 
			    var reader = new FileReader();
			    reader.readAsDataURL(file);
			    reader.onload = function(e){
					var pic = document.getElementById("vimg1");
			        pic.src=this.result;
			    }
			    $("#verify_img_row").removeClass("nondisplay");
			}
		}



	//上面是校验部分
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// 两个日期控件    输入框
		$("#publish_date_from").dateDropper({
			animate: false,
			format: 'Y/m/d',
			maxYear: '2020'
		});
		$("#publish_date_to").dateDropper({
			animate: false,
			format: 'Y/m/d',
			maxYear: '2020'
		});
	

	}





	//按钮动画部分
	function btnLoading(){
		$("#pay_earnest_window_btn").click(function(){

			var l = Ladda.create( document.querySelector( '#pay_earnest_window_btn' ) );
			l.start();
			//得先判断一下当前账户余额是否足够扣除保证金
			$.ajax({
				url: rootPath + "/item/checkMoneyForFreeze", 
				type: 'POST',  
				data:null,
				dataType:"JSON",
				async:true,
				success:function(data){
					console.info(data);
					if(data.result == "ok"){
						publish_submit_after_cost();////确认用户有足够的余额可以扣除保证金之后，可以进行后续的提交部分
					}else if(data.result == "no"){
						l.stop();
						alert("当前账户余额不足以扣除手续费，请充值");
					}else if(data.result == "error"){
						location.replace(rootPath + "/page/message");
					}else{
						location.replace(rootPath + "/page/message");
					}
				},
				error:function(data){		alert("error");		},
			});
			
			
			
		});
	}
	
	
	//确认用户有足够的余额可以扣除保证金之后，可以进行后续的提交部分
	function publish_submit_after_cost(){

		var formData = new FormData(); //$( "#publish_form" )[0]
		formData.append("name",$.trim(publish_form.item_name.value));
		formData.append("brief",$.trim(publish_form.item_brief.value));
		formData.append("number",$.trim(publish_form.item_number.value));
		formData.append("price",$.trim(publish_form.item_price.value));
		formData.append("startDate",$.trim(publish_form.item_publish_date_from.value));
		formData.append("endDate",$.trim(publish_form.item_publish_date_to.value));
		formData.append("priceAdd",$.trim(publish_form.item_price_add.value));
		formData.append("itemDescription",$.trim(publish_form.item_description.value));

		var type = null;
		if(publish_form.item_type_second){
			//第二种类类型id的确定
			if(publish_form.item_type_second.value == "huihua"){
				type = 2;
			}else if(publish_form.item_type_second.value == "shufa"){
				type = 3;
			}else if(publish_form.item_type_second.value == "gujiwenxian"){
				type = 4;
			}else if(publish_form.item_type_second.value == "youhua"){
				type = 6;
			}else if(publish_form.item_type_second.value == "shuicai"){
				type = 7;
			}else if(publish_form.item_type_second.value == "diaosu"){
				type = 8;
			}else if(publish_form.item_type_second.value == "yuqi"){
				type = 10;
			}else if(publish_form.item_type_second.value == "taoci"){
				type = 11;
			}else if(publish_form.item_type_second.value == "muqi"){
				type = 12;
			}else if(publish_form.item_type_second.value == "zhubao"){
				type = 14;
			}else if(publish_form.item_type_second.value == "jinshuqi"){
				type = 15;
			}
		}else{
			//第一种类类型id的确定
			if(publish_form.item_type_first.value == "zahuo"){
				type = 16;
			}else if(publish_form.item_type_first.value == "ershou"){
				type = 17;
			}
		}
		formData.append("type",type);//第二种类类型id的确定
		
		if(publish_form.item_picture_1.value != ""){
			formData.append("picture1",publish_form.item_picture_1.files[0]);
		}
		if(publish_form.item_picture_2.value != ""){
			formData.append("picture2",publish_form.item_picture_2.files[0]);
		}
		if(publish_form.item_picture_3.value != ""){
			formData.append("picture3",publish_form.item_picture_3.files[0]);
		}
		if(publish_form.item_identify_picture.value != ""){
			formData.append("identifyPicture",publish_form.item_identify_picture.files[0]);
		}
		
		$.ajax({  
	          url: rootPath + "/item/publish",  
	          type: 'POST',  
	          data: formData,  
	          async: true,  
	          cache: false,  
	          contentType: false,  
	          processData: false,  
	  		  dataType:"JSON",
	          success: function (data) {
	        	  console.info(data);
	              if(data.result == "ok"){
	            	  alert("商品发布成功，请等待管理员审核");
	            	  location.replace(rootPath);
	              }
	          },  
	          error: function (returndata) {  	        	  console.info(returndata);	          }  
	    });  
	}

});