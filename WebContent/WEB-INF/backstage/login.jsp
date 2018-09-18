<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>健康散检</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>

<body>
	<div id="center">
		<div id="top">
			<h2>健康散检</h2>
		</div>
		<form role="form" id="loginForm" method="post">
			<div class="div1" id="d_name">
				<label>用户名</label> <input name="uname" id="uname" type="text"
					class="inp" placeholder="请输入用户名..." />
			</div>
			<div class="div1" id="d_pwd">
				<label>密码</label> <input name="pwd" type="password" class="inp"
					id="pwd" placeholder="请输入用户名..." />
			</div>
			<div class="div1" id="d_pwd">
				<label>验证码</label> <input name="verification" id="verification"
					type="text" class="inp" id="verification" maxlength="4" /><img
					id="img" src="user/validateCode.action" /><a href="#"
					onclick="click1()">看不清换一张</a>
			</div>
			<input id="login" type="button" class="btn" value="登录" />
		</form>

	</div>
</body>
</html>
