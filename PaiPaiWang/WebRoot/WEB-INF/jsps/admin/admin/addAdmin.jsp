<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加管理员</title>
		<style type="text/css">
			* {	margin: 0px;padding: 0px;	}

			/*location start*/
			
			.location {
				width: 100%;
				height: 51px;
				border-bottom: 1px solid #ccc;
				background: #e5e5e5;
				position: relative;
				line-height: 51px;
			}
			.location i {
				display: block;
				width: 14px;
				height: 18px;
				background: url("${path}/image/ht_icon.png") no-repeat;
				float: left;
				margin: 16px 20px 0 20px;
				background-position: -16px -51px;
			}
			.location .search_bar{				position:absolute; right:5px; top:0px;padding: 0px;height: 30px;			}
			.location .search_bar #search_key_word{				height:30px;width:200px;text-align:center;			}
			.location .search_bar #search_btn{				height:34px;width:50px;				cursor: pointer;			}
			/*end location*/

			.center_table{
				width:90%; 
				margin:50px auto 20px;
				text-align: center;
			}
			.center_table th,.center_table td{
				height: 30px;
				line-height:24px;
			}
			.input{
				width:50%;
				height:24px;
				margin:10px 0px;
			}
			textarea{
				resize:none;
				margin:10px 0px;
			}
		</style>
	</head>
	<body>
		<div class="location">
			<i></i>
			<p>添加管理员</p>
		</div>
		
		<form action="${path}/admin/super_addAdmin" method="POST">
			<table border="1px" bordercolor="#cccccc" cellspacing="0px" cellpadding="0px" class="center_table">
	   			<tr>
					<td>用户名</td>
					<td>
						<input type="text" class="input" name="username" value="${requestScope.admin.username}"/><span>${usernameError}</span>
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						<input type="text" class="input" name="password"  value="${requestScope.admin.password}" /><span>${passwordError}</span>
					</td>
				</tr>
				<tr>
					<td>角色</td>
					<td>
						<input type="radio" name="superUser" value="true" <c:if test="${requestScope.admin.superUser}">checked</c:if> />超级管理员&nbsp;&nbsp;
						<input type="radio" name="superUser" value="false" <c:if test="${!requestScope.admin.superUser}">checked</c:if> />管理员
					</td>
				</tr>
				<tr>
					<td>备注</td>
					<td>
						<textarea rows="5" cols="50%" name="remark"  >${requestScope.admin.remark}</textarea><span>${remarkError}</span>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input class="input" type="submit" value="添加" />
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>


