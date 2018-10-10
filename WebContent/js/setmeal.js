// JavaScript Document

function del() {
	question = confirm("是否要删除该套餐")
	if (question != "0") {
		return true;
	}
	return false;
}
function update() {
	question = confirm("是否要更新该套餐")
	if (question != "0") {
		return ckeck();
	}
	return false;
}

$(function() {
	$('#setmealName').blur(function() {
		$("#check").val('true');
		if ($('#setmealName').val() != $('#sName').val()) {
			$.ajax({
				url : "backstage/checkSetmealName.action",
				data : "setmealName=" + $('#setmealName').val(),
				type : "POST",
				dataType : "text",
				success : function(result) {
					if ('false' == result) {
						alert('该套餐名称已被使用');
					}
					$("#check").val(result);
				},
				error : function() {
					alert("异常！");
				}
			});
		}
	});
});

$(function() {
	$('#addSetmeal').submit(function() {
		var setmealName = $('#setmealName').val();
		var projectId = document.getElementsByName("projectId");
		check_val = [];
		for (k in projectId) {
			if (projectId[k].checked)
				check_val.push(projectId[k].value);
		}

		if (setmealName == "") {
			alert('套餐名称不能为空');
			return false;
		}

		if (check_val.length == 0) {
			alert('请选择项目');
			return false;
		}
		return true;
	});
})

$(function() {
	$("#updateSetmeal").submit(function() {
		var setmealName = $('#setmealName').val();
		var projectId = document.getElementsByName("projectId");
		check_val = [];
		for (k in projectId) {
			if (projectId[k].checked)
				check_val.push(projectId[k].value);
		}

		if (setmealName == "") {
			alert('套餐名称不能为空');
			return false;
		}

		if (check_val.length == 0) {
			alert('请选择项目');
			return false;
		}
		return true;
	});
})

function ckeck() {
	if ($("#check").val() == 'true') {
		return true;
	}
	alert('该套餐名称已被使用');
	return false;
}
