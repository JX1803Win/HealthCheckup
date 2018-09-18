// JavaScript Document
$(function() {
	$('#img').click(
			function() {
				var $img = $('#img').attr('src',
						'user/validateCode.action?' + Math.random());
			});
});

function click1() {
	var $img = $('#img').attr('src',
			'user/validateCode.action?' + Math.random());
}

$(function() {
	$('#login').click(
			function() {
				if ($("#uname").val() == "") {
					alert('用户名不能为空');
					return false;
				}
				if ($("#pwd").val() == "") {
					alert("密码不能为空");
					return false;
				}
				if ($("#verification").val() == "") {
					alert("验证码不能为空");
					return false;
				}
				$.ajax({
					url : "dome/userLogin.action",
					data : $("#loginForm").serialize(),
					type : "POST",
					dataType : "json",
					success : function(result) {
						if (result == "用户名或者密码错误" || result == "该用户已被删除"
								|| result == "账户被锁定" || result == "验证码错误") {
							alert(result);
						} else {
							alert('登录成功');
							window.location.href = result;
						}
					},
					error : function() {
						alert("异常！");
					}
				});
			});
});
