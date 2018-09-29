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


<script>
function check() {
	var mangerName = document.getElementById('mangerName').value;
	var password = document.getElementById('password').value;
	var verification = document.getElementById('verification').value;
	if(mangerName == null || mangerName == "" || mangerName == "null"){
		alert("请输入账号");
  		return false;
	}if(password == null || password == "" || password == "null"){
		alert("请输入密码");
  		return false;
	}if(verification == null || verification == "" || verification == "null"){
		alert("请输入验证码");
  		return false;
	}
	 $.ajax({
		url : "backstage/login.action",
		data : "mangerName=" + mangerName + "&verification="+verification+"&password="+password,
		dataType : "text",
		type : "post",
		success : function(redata) {
			if(redata=="\"错误\""){
				alert("登录失败");
				return false;
			}else{
				window.location.href = "backstage/index.action"
			}
		}
	}); 
	
}
</script>





<body>
	<div id="center">
		<div id="top">
			<h2>健康散检后台登录</h2>
		</div>
		<form action="" role="form" id="loginForm"  method="post">
			<div class="div1" id="d_name">
				<label>用户名</label> <input name="mangerName" id="mangerName"
					type="text" class="inp" placeholder="请输入用户名..." />
			</div>
			<div class="div1" id="d_pwd">
				<label>密码</label> <input name="password" type="password" class="inp"
					id="password" placeholder="请输入用户名..." />
			</div>
			<div class="div1" id="d_pwd">
				<label>验证码</label> <input name="verification" id="verification"
					type="text" class="inp" id="verification" maxlength="4" /><img
					id="img" src="user/validateCode.action" /><a href="#"
					onclick="click1()">看不清换一张</a>
			</div>
			<input type="button"  onclick="check()" class="btn" value="登录" />
		</form>

	</div>
</body>
</html>
