<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href = "<%=basePath%>css/snow.css" rel = "stylesheet" type = "text/css"></link>
<link href = "<%=basePath%>css/input.css" rel = "stylesheet" type = "text/css"></link>
<link href = "<%=basePath%>css/check.css" rel = "stylesheet" type = "text/css"></link>
<style>
	td {
		text-align:left;
		margin:0px;
	}
	.registerTable {
		font-size:18px;
		height:350px;
		width:500px; 
		margin-left:450px;
		margin-top:100px;
		color:white;
	}
</style>
<script src="<%=basePath%>js/checkForm.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.getJSON("<%=basePath%>jsp/JsonAction!getEdu", 
		function(datas) {
			console.log(datas);
			var data = JSON.parse(datas);
			for (var i = 0; i < data.length; i++) {
				console.log(data[i].eduId);
				$("#edu").append("<option value="+ data[i].eduId +">"+data[i].eduName+"</option>");
			}
		});
	});

	function check() {// 检测用户名是否已注册
 		$.ajax({
 			url:"<%=basePath%>jsp/JsonAction!checkUsername",
 			data:{username:$("#username").val()},
 			type:"get",
			dataType:"text",
			success:function(data){
				console.log(data);
				if(data.indexOf("null") == -1) {
					$("#nameError").html("*用户名已存在");
					$("#username").focus();
				} else {
					$("#nameError").html("");
				}
			}
 		});
	}
	function checkRegister() {
		var username = document.getElementById("username").value;
		var psw = document.getElementById("userPsw").value;
		var confirmPsw = document.getElementById("confirmPsw").value;
		var edu = document.getElementById("edu").value;
		var occ = document.getElementById("occ").value;
		var telephone = document.getElementById("telephone").value;
		var email = document.getElementById("email").value;
		var regTelephone = /^[1][0-9]{10}$/;//手机号正则表达式
		var regNum = /^([1-9][0-9]*){1,3}$/;// 非零正整数，长度为1-3位
		var regCH = /[\u4e00-\u9fa5]{1}/g;// 中文
		var result = true;
		if(username=="") {
			document.getElementById("nameError").innerHTML="*用户名不能为空";
			result = false;
		} else if(username.indexOf(" ") != -1) {
			document.getElementById("nameError").innerHTML="*用户名不能有空格";
			result = false;
		} else if(username.length > 5) {
			document.getElementById("nameError").innerHTML="*用户名不超过5个字符";
			result = false;
		} else {
			document.getElementById("nameError").innerHTML="";
		}
		if(psw.length==0) {
			document.getElementById("pwdError").innerHTML="*密码不能为空";
			result = false;
		} else if(psw.indexOf(" ") != -1) {
			document.getElementById("pwdError").innerHTML="*密码不能有空格";
			result = false;
		} else if(psw.length > 10) {
			document.getElementById("pwdError").innerHTML="*密码不能超过10位";
			result = false;
		} else {
			document.getElementById("pwdError").innerHTML="";
		}
		if (confirmPsw.length==0){
			document.getElementById("confirmPswError").innerHTML="*确认密码不能为空";
			result = false;
		} else if(psw!=confirmPsw){
			document.getElementById("confirmPswError").innerHTML="*两次密码不一致";
			result = false;
		} else {
			document.getElementById("confirmPswError").innerHTML="";
		} 
		if(edu == "请选择") {
			document.getElementById("eduError").innerHTML="*学历不能为空";
			result = false;
		} else {
			document.getElementById("eduError").innerHTML="";
		}
		if(occ == "") {
			document.getElementById("occError").innerHTML="*职业不能为空";
			result = false;
		} else if(edu.length > 10) {
			document.getElementById("occError").innerHTML="*职业字数多长";
			result = false;
		} else {
			document.getElementById("occError").innerHTML="";
		}
		if(telephone=="") {
			document.getElementById("telephoneError").innerHTML="*手机号不能为空";
			result = false;
		} else if(!regTelephone.test(telephone)) {
			document.getElementById("telephoneError").innerHTML="*手机号错误";
			result = false;
		} else {
			document.getElementById("telephoneError").innerHTML="";
		}
		if(email.length == 0) {
			document.getElementById("emailError").innerHTML="*email不能为空";
			return false;
		} else if(email.length > 30) {
			document.getElementById("emailError").innerHTML="*email30个字符以内";
			return false;
		} else {
			document.getElementById("emailError").innerHTML="";
		}
		return result;
	}
</script>
</head>
<body background = "<%=basePath%>img/bg.jpg">
	<div class="snow-container">
		<div class="snow foreground"></div>
		<div class="snow foreground layered"></div>
		<div class="snow middleground"></div>
		<div class="snow middleground layered"></div>
		<div class="snow background"></div>
		<div class="snow background layered"></div>
	</div>
	<form action = "<%=basePath%>jsp/RegisterAction" method = "post" onsubmit="return checkRegister()">
		<table border = "0" class = "registerTable">
			<tr>
				<td>用户名：</td>
				<td><input type="text" id = "username" name="user.username" onblur="check()"/></td>
				<td><p id="nameError" class="error"></p></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id = "userPsw" name="user.psw"/></td>
				<td><p id="pwdError" class="error"></p></td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input type="password" id = "confirmPsw"/></td>
				<td><p id="confirmPswError" class="error"></p></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					<input type = "radio" name = "user.sex" checked = "checked" value="男"/>男
					<input type = "radio" name = "user.sex" value="女"/>女
				</td>
				<td><p class="error"></p></td>
			</tr>
			<tr>
				<td>学历：</td>
				<td>
					<select id="edu" name="user.eduId" style="width:180px;">
						<option>请选择</option>
					</select>
				</td>
				<td><p id="eduError" class="error"></p></td>
			</tr>
			<tr>
				<td>职业：</td>
				<td>
					<input type = "text" id="occ" name = "user.occ" />
				</td>
				<td><p id="occError" class="error"></p></td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td><input type="text" id = "telephone" name="user.tel"/></td>
				<td><p id="telephoneError" class="error"></p></td>
			</tr>
			<tr>
				<td>email：</td>
				<td>
					<input type="text" id = "email" name="user.email"/>
				</td>
				<td><p id="emailError" class="error" ></p></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
					<p align = "center">
						<input type="submit" name = "submit" value = "确定" style="margin-right: 80px;"/>
						<input type="reset" name = "reset" value = "重置"/>
					</p>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>