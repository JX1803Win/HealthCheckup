// JavaScript Document
$(function() {
	$('#addAdmin').submit(function() {
		var $un = $('#uName').val();
		var $pwd = $('#pwd').val();
		var $pwd1 = $('#pwd1').val();
		var $firstname = $('#firstname').val();
		var $consultingfee = $('#consultingfee').val();
		var $Bookingfee = $('#Bookingfee').val();
		var $professional = $('#professional').val();
		var $intro = $('#intro').val();
		if ($un == "") {
			alert('用户名不能为空');
			return false;
		}

		if ($un.length < 5 || $un.length > 10) {
			alert('用户名长度只能为5-10位');
			return false;
		}

		if ($pwd == "") {
			alert('密码不能为空');
			return false;
		}

		if ($pwd.length < 5 || $un.length > 10) {
			alert('密码长度只能为5-10位');
			return false;
		}

		if ($pwd1 == "") {
			alert('确认密码不能为空');
			return false;
		}

		if ($pwd != $pwd1) {
			alert('两次密码不一致');
			return false;
		}

		if ($firstname == "") {
			alert('真实姓名不能为空');
			return false;
		}

		if ($firstname.length > 5) {
			alert('真实姓名不能超过5个字符');
			return false;
		}

		if ($consultingfee == "") {
			alert('咨询费用不能为空');
			return false;
		}

		if ($consultingfee.length > 5 || $consultingfee < 0) {
			alert('咨询费用只能为正数，且长度不能超过5位');
			return false;
		}

		if ($Bookingfee == "") {
			alert('预约费用不能为空');
			return false;
		}

		if ($Bookingfee.length > 5 || $Bookingfee < 0) {
			alert('预约费用只能为正数，且长度不能超过5位');
			return false;
		}

		if ($professional == "") {
			alert('职称不能为空');
			return false;
		}

		if ($intro == "") {
			alert('简介不能为空');
			return false;
		}

		if ($intro.length > 200) {
			alert('简介不能超过200个字符');
			return false;
		}
	});
});

function del() {
	question = confirm("是否要删除该用户")
	if (question != "0") {
		return true;
	}
	return false;
}

function start() {
	question = confirm("是否要启用该用户")
	if (question != "0") {
		return true;
	}
	return false;
}

function forbidden() {
	question = confirm("是否要禁用该用户")
	if (question != "0") {
		return true;
	}
	return false;
}

function reset() {
	question = confirm("是否要重置该用户密码")
	if (question != "0") {
		return true;
	}
	return false;
}

$(function() {
	$('#uName').blur(function() {
		$.ajax({
			url : "CheckAdminServlet",
			data : "name=" + $('#uName').val(),
			type : "POST",
			dataType : "text",
			success : function(result) {
				alert(result);
			},
			error : function() {
				alert("异常！");
			}
		});
	});
});