<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>登陆</title>
<link href = "css/snow.css" rel = "stylesheet" type = "text/css"></link>
<link href = "css/input.css" rel = "stylesheet" type = "text/css"></link>
<style type="text/css">
	p {
		text-align:center;
		font-size:30px;
		color:white;
	}
	td {
		text-align:left;
		margin:0px;
	}
	.backLoginTable {
		font-size:18px;
		height:250px;
		width:400px; 
		margin:0 auto;
		margin-top:100px;
		color:white;
	}
	#code {
		font-size: 18px;
		font-family: Arial;
 		font-style: italic;
  		font-weight: bold;
  		border: 0;
  		letter-spacing: 2px;
  		color: blue;
 	}
}
</style>
<script type="text/javascript">
	//登陆验证
	function checkLogin() {
		var username = document.getElementById("username").value;
		var psw = document.getElementById("userPsw").value;
		var checkcode = document.getElementById("checkcode").value;
		var result = "";
		if(username=="") {
			result += "用户名不能为空\n";
		} 
		if(psw.length==0) {
			result += "密码不能为空\n";
		} 
		if(checkcode=="") {
			result += "验证码不能为空\n";
		}
		if(result == "") {
			return true;
		} else {
			alert(result);
			return false;
		}
	}
	function changeCode() {
		var image = document.getElementById("imageId");
		image.src = "<%=basePath%>user/validateCode?data="+Math.random();
	}
</script>
</head>
<body background = "<%=basePath%>img/bg.jpg" >
	<div class="snow-container">
		<div class="snow foreground"></div>
		<div class="snow foreground layered"></div>
		<div class="snow middleground"></div>
		<div class="snow middleground layered"></div>
		<div class="snow background"></div>
		<div class="snow background layered"></div>
	</div>
	<form action="user/login" method = "post" onsubmit="return checkLogin()">
		<table border = "0" class = "backLoginTable">
			<tr>
				<td>ID：</td>
				<td><input type="text" id = "username" name="username"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id = "userPsw" name="psw"/></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td style = "text-align:left;">
					<input type="text" id="checkcode" name="keyCode" style = "width:90px; display:inline; text-align:left;"/>
  					<!-- 描述：把验证码定义为按钮，点击刷新 -->
   					<img src="<%=basePath%>user/validateCode" id="imageId" onclick="changeCode()"/>
   					<label style="cursor: pointer;contenteditable:false;" onclick="changeCode()">看不清，换一张</label>
				</td>
			</tr>
			<tr>
				<td colspan = "2" style = "text-align:center;" >
					<input type = "submit" value = "登陆" style="margin-right: 40px;"/>
					<a href="<%=basePath%>register.jsp">
						<input type = "button" value = "注册"/>
					</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
