<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户登录注册界面</title>
<link rel="stylesheet" type="text/css" href="css/logstyles.css">
<link rel="stylesheet" href="css/jigsaw.css">
<link rel="stylesheet" type="text/css" href="css/fastyle.css">
<style>
#msg {
	width: 100%;
	line-height: 40px;
	font-size: 17px;
	text-align: center;
	color: #FF0000;
}

#mag {
	width: 100%;
	line-height: 0px;
	font-size: 17px;
	text-align: center;
	color: #FF0000;
}
</style>


<style type="text/css">
.checkCode {
	cursor: pointer;
	border: 0px solid black;
	text-align: center;
	line-height: 26px;
	border-radius: 25px;
	background: #1161ee;
	width: 100px;
	height: 27px;
	color:#fff;
}
</style>
<script type="text/javascript">
    var sleep = 30, interval = null;
   
   
    window.onload = function ()
    {
        var btn = document.getElementById ('btn');
        
        btn.onclick = function ()
        {
        	var phonenb = document.getElementById('phonenb').value;
        	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phonenb))){
        		alert(1);
        		document.getElementById('mag').innerHTML = '请输入正确的手机号'
        		return
        	}
        	
        	
        	if((/^1[3|4|5|8][0-9]\d{4,8}$/.test(phonenb))){
				$.ajax({
					url : "user/checkphone.action",
					data : "phone=" + phonenb,
					dataType : "text",
					type : "post",
					success : function(redata) {
						if(redata=="\"否\""){
						document.getElementById('mag').innerHTML = '手机号已被注册'
						return
						}else{

				        	if (!interval)
				            {
				        		btn.style.backgroundColor = 'rgb(200, 182, 182)';
				            	btn.disabled = "disabled";
				            	btn.style.cursor = "wait";
				            	btn.value = "重新发送 (" + sleep-- + ")";
				                interval = setInterval (function ()
				                {
				                    if (sleep == 0)
				                    {
				                        if (!!interval)
				                        {
				                            clearInterval (interval);
				                            interval = null;
				                            sleep = 30;
				                            btn.style.cursor = "pointer";
				                            btn.removeAttribute ('disabled');
				                            btn.value = "获取验证码";
				                            btn.style.backgroundColor = '';
				                        }
				                        return false;
				                    }
				                    btn.value = "重新发送 (" + sleep-- + ")";
				                }, 1000);
				            }
						}
					}
				});	
			}
        	
        } 
    }
</script>




</head>
<body>
	<div id="particles-js">
		<div class="login">
			<div class="login-wrap">
				<div class="login-html">
					<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
						for="tab-1" class="tab">登录</label> <input id="tab-2" type="radio"
						name="tab" class="sign-up"><label for="tab-2" class="tab">注册</label>
					<div class="login-form">
						<form>
							<div class="sign-in-htm">
								<div class="group">
									<label for="user" class="label">手机号</label> <input id="phone"
										name="phone" type="text" class="input">
								</div>
								<div class="group">
									<label for="pass" class="label">密码</label> <input id="password"
										type="password" class="input" data-type="password">
								</div>
								<div class="group">
									<div class="container">
										<div id="captcha" style="position: relative"
											data-type="password"></div>
										<div id="msg"></div>
									</div>
								</div>
								<div class="group">
									<input id="check" type="checkbox" class="check" checked>
									<label for="check"><span class="icon"></span> 保持登录</label>
								</div>
								<div class="group">
									<input type="button" class="button" value="登录" onClick="sub()">
								</div>
								<div class="hr"></div>
								<div class="foot-lnk">
									<a href="ForGot1.jsp">忘记密码?</a>
								</div>
							</div>
						</form>
						<form id="form2" name="form2">
							<div class="sign-up-htm">
								<div class="group">
									<label for="user" class="label">用户名</label> <input
										id="usersname" name="usersname" type="text" class="input">
								</div>
								<div class="group">
									<label for="pass" class="label">密码</label> <input id="pass"
										name="pass" type="password" class="input" data-type="password">
								</div>
								<div class="group">
									<label for="pass" class="label">重复密码</label> <input id="repass"
										name="repass" type="password" class="input"
										data-type="password">
								</div>
								<div class="group">
									<label for="pass" class="label">手机号 
									<input
										class="checkCode" type="button" id="btn" value="获取验证码" /></label> <input
										id="phonenb" name="phonenb" type="text" class="input" />
								</div>
								<div class="group">
									<label for="pass" class="label">验证码</label> <input id="code"
										name="code" type="text" class="input">
								</div>
								<div class="group">
									<input type="button" class="button" value="注册" onClick="reg()">
								</div>
								<div class="hr"></div>
								<div id="mag"></div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script>
		function reg() {
			var flag = false;
			var usersname = document.getElementById('usersname').value;
			var pass = document.getElementById('pass').value;
			var repass = document.getElementById('repass').value;
			var phonenb = document.getElementById('phonenb').value;
			var code = document.getElementById('code').value;

			if (!(/[^\x00-\x80]/.test(usersname))) {
				var flag = false;
				document.getElementById('mag').innerHTML = '请输入正确的用户名'
				return;
			}
			if (pass == "" || pass == "null" || pass == null || pass != repass) {
				var flag = false;
				document.getElementById('mag').innerHTML = '两次密码不一致'
				return;
			}
			
			$.ajax({
				url : "user/reg.action",
				data : "usersname="+usersname+"&pass="+pass+"&phone=" + phonenb + "&code="+code,
				dataType : "text",
				type : "post",
				success : function(redata) {
					if(redata=="\"验证码错误\""){
					document.getElementById('mag').innerHTML = '验证码错误'
					return
					}else{
					document.getElementById('mag').innerHTML = '注册成功'
					}
				}
			});	
			
		}
	</script>


	<script src="js/jigsaw.js"></script>
	<script>
		var flag = false;
		var flag1 = false;
		jigsaw.init(document.getElementById('captcha'), function() {
			flag1 = true;
			document.getElementById('msg').innerHTML = '验证成功!'
		})

		function sub() {
			var phone = document.getElementById('phone').value;
			var pass = document.getElementById('password').value;

			if (!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))) {
				flag = false;
				document.getElementById('msg').innerHTML = '请输入正确的手机号'
				return;
			}
			if (pass == null || pass == "" || pass == "null") {
				flag = false;
				document.getElementById('msg').innerHTML = '请输入密码'
				return;
			}
			if (flag1 == false) {
				document.getElementById('msg').innerHTML = '请滑动验证码!'
				return;
			}
			$.ajax({
				url : "user/login.action",
				data : "phone="+phone+"&psw="+pass,
				dataType : "text",
				type : "post",
				success : function(redata) {
					if(redata=="\"否\""){
					document.getElementById('msg').innerHTML = '登入失败'
					return
					}else{
	    				window.location.href = "user/loginsuccess.action"
	    			}
				}
			});
		}
	</script>
	<script src="js/particles.min.js"></script>
	<script src="js/app.js"></script>
</body>
</html>