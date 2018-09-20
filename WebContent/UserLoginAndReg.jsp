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
	color:#FF0000;
}
</style>
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
						<form id="form1" name="form1">
							<div class="sign-in-htm">
								<div class="group">
									<label for="user" class="label">手机号</label> <input
										id="phone" name="phone" type="text"
										class="input">
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
									<a href="#forgot">忘记密码?</a>
								</div>
							</div>
						</form>
						<form>
							<div class="sign-up-htm">
								<div class="group">
									<label for="user" class="label">用户名</label> <input id="users"
										type="text" class="input">
								</div>
								<div class="group">
									<label for="pass" class="label">密码</label> <input id="passs"
										type="password" class="input" data-type="password">
								</div>
								<div class="group">
									<label for="pass" class="label">重复密码</label> <input id="passs"
										type="password" class="input" data-type="password">
								</div>
								<div class="group">
									<label for="pass" class="label">手机号</label> <input id="pass"
										type="text" class="input">
								</div>
								<div class="group">
									<label for="pass" class="label">验证码</label> <input id="pass"
										type="text" class="input">
								</div>
								<div class="group">
									<a href="register.html"><input type="submit" class="button"
										value="注册"></a>
								</div>
								<div class="hr"></div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="sk-rotating-plane"></div>
	</div>
	<script src="js/jigsaw.js"></script>
	
	<script>
	
		var flag = false;
		jigsaw.init(document.getElementById('captcha'), function() {
			flag = true;
			document.getElementById('msg').innerHTML = '验证成功!'
		})

		function sub() {
			var phone = document.getElementById('phone').value;
			var pass = document.getElementById('password').value;
			if (flag == true) {
				window.location.href = "user/login.action?phone=" + phone
						+ "&psw=" + pass;
			}else{
				document.getElementById('msg').innerHTML = '请滑动验证码!'
			}
		}
	</script>
	
	
	<script src="js/particles.min.js"></script>
	<script src="js/app.js"></script>
</body>
</html>