<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>订单详细信息</title>
		<style type="text/css">
			* {	margin: 0px;padding: 0px;	}

			.center_table{
				width:600px; 
				margin:50px auto;
				text-align: center;
			}
			.center_table th,.center_table td{
				padding:10px;
			}
			.center_table .title{
				width:200px;
			}
			.center_table img{
				width:400px;
			}

			
			/*顶部的位置栏*/
			.location{width:100%;height:51px;border-bottom:1px solid #ccc;background:#e5e5e5;position:relative;line-height:51px;}.location i{display:block;width:14px;height:18px;background:url("${path}/image/ht_icon.png") no-repeat;float:left;margin:16px 20px 0 20px;background-position:-16px -51px;}.location .search_bar{position:absolute;right:5px;top:0px;padding:0px;height:30px;}.location .search_bar #search_key_word{height:30px;width:200px;text-align:center;}.location .search_bar #search_btn{height:34px;width:50px;cursor:pointer;}
			/*小组件样式*/
			.tips-success,.tips-fail,.tips-warning{min-width:240px;height:40px;position:absolute;left:calc(50% - 100px);background:#fff;opacity:0;}.tips-success .icon-box{max-width:20%;height:100%;background:green;float:left;}.tips-success .icon-box .icon{background:url(${path}/image/ht_icon.png) no-repeat -172px -48px;}.tips-fail .icon-box{max-width:20%;height:100%;background:red;float:left;}.tips-warning .icon-box{max-width:20%;height:100%;background:orange;float:left;}.icon-box .icon{width:18px;height:18px;display:inline-block;margin:10px;}.tips-fail .icon-box .icon,.tips-warning .icon-box .icon{background:url(${path}/image/ht_icon.png) no-repeat -10px -132px;}.tips-success .text,.tips-fail .text,.tips-warning .text{min-width:80%;height:100%;float:left;font-weight:bold;text-align:center;line-height:40px;}.move{animation:4s jian;}@-webkit-keyframes jian{0%{top:0;opacity:0}20%{top:100px;opacity:1}90%{top:100px;opacity:.8}100%{top:100px;opacity:0;}}
			a{text-decoration:none;}.shadow{width:100%;height:100%;position:fixed;top:0;left:0;z-index:10;background:rgba(0,0,0,.4);}.loading{width:80px;height:80px;border-radius:5px;background:rgba(0,0,0,.8);position:absolute;top:calc(50% - 40px);left:calc(50% - 40px);text-align:center;line-height:100px;}.dialog{background:#222;position:fixed;overflow:hidden;color:#fff;font-size:14px;z-index:11;border-radius:6px;box-sizing:border-box;}.dialog-title{width:100%;height:45px;line-height:45px;padding-left:10px;font-weight:bold;cursor:move;border-bottom:1px solid #333;}.dialog .close{color:#fff;font-size:22px;padding:0 5px;position:absolute;right:8px;top:8px;transition:all 0.3s ease;opacity:0;}.dialog:hover .close{transition:all .3s ease;opacity:1;transform:rotate(360deg);}.dialog .dialog-content{width:100%;height:100%;}.dialog-content .dialog-body{padding:46px 0;text-align:center;}.dialog-content .dialog-buttons{border-top:1px solid #333;padding:10px;text-align:center;}.dialog-content .btn{margin-left:10px;padding:4px 12px;border:none;cursor:pointer;border-radius:2px;}.dialog-content .btn:hover{background:#aaa;}.dialog-shadow{width:100%;height:100%;background-color:#111;position:fixed;top:0;left:0;z-index:10;filter:alpha(opacity=58);-moz-opacity:0.58;-khtml-opacity:0.58;opacity:0.58;}
		
		</style>
	</head>
	<body>
		<div class="location">
			<i></i>
			<p>订单管理 > 订单详细</p>
		</div>
		
		<table border="1px" bordercolor="#cccccc" cellspacing="0px" cellpadding="0px" class="center_table">
   			<tr>
				<td class="title">订单ID</td>
				<td>${orderVO.id}</td>
			</tr>
			<tr>
				<td>卖家</td>
				<td>${orderVO.seller}</td>
			</tr>
			<tr>
				<td>买家</td>
				<td>${orderVO.buyer}</td>
			</tr>
			<tr>
				<td>价格</td>
				<td>${orderVO.price}</td>
			</tr>
			<tr>
				<td>生成日期</td>
				<td>
					<fmt:formatDate value="${orderVO.createDate}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td>订单状态</td>
				<td>${orderVO.state}</td>
			</tr>
			<c:if test="${orderVO.finishTime!=null}">
				<tr>
					<td>完成交易时间</td>
					<td>
						<fmt:formatDate value="${orderVO.finishTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
				</tr>
			</c:if>
			
			<c:if test="${orderVO.sendName!=null}">
				<tr>
					<td>收货人姓名</td>
					<td>${orderVO.sendName}</td>
				</tr>
				<tr>
					<td>收货人电话号码</td>
					<td>${orderVO.sendPhone}</td>
				</tr>
				<tr>
					<td>收货人地址</td>
					<td>${orderVO.sendAddress}</td>
				</tr>
				<tr>
					<td>收货人邮政编码</td>
					<td>${orderVO.sendPostcode}</td>
				</tr>
				<tr>
					<td>收货备注信息</td>
					<td>${orderVO.sendOthers}</td>
				</tr>
			</c:if>
			
			<c:if test="${orderVO.expressCompany!=null}">
				<tr>
					<td>快递公司</td>
					<td>${orderVO.expressCompany}</td>
				</tr>
				<tr>
					<td>快递单号</td>
					<td>${orderVO.expressCode}</td>
				</tr>
			</c:if>
			
			<c:if test="${orderVO.evaluation!=null}">
				<tr>
					<td>用户评价</td>
					<td>${orderVO.evaluation}</td>
				</tr>
			</c:if>
			
			<c:if test="${orderVO.returnReason!=null}">
				<tr>
					<td>退货理由描述</td>
					<td>${orderVO.returnReason}</td>
				</tr>
			</c:if>
			
		</table>
		
	</body>
</html>


