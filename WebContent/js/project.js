// JavaScript Document

function del() {
	question = confirm("是否要删除该项目")
	if (question != "0") {
		return true;
	}
	return false;
}
function uodate() {
	question = confirm("是否要更新该项目")
	if (question != "0") {
		return ckeck();
	}
	return false;

}

$(function() {
	$('#itemName').blur(function() {
		$("#check").val('true');
		if ($('#itemName').val() != $('#iName').val()) {
			$.ajax({
				url : "backstage/checkProject1.action",
				data : "itemName=" + $('#itemName').val(),
				type : "POST",
				dataType : "text",
				success : function(result) {
					if ('false' == result) {
						alert('该项目名称已被使用');
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
	$('#addProject').submit(function() {
		var patt = /^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$/;
		var itemName = $('#itemName').val();
		var charge = $('#charge').val();
		var officeId = $('#officeId').val();
		var parameterId = $('#parameterId').val();
		var subentryId = document.getElementsByName("subentryId");
		check_val = [];
		for (k in subentryId) {
			if (subentryId[k].checked)
				check_val.push(subentryId[k].value);
		}

		if (itemName == "") {
			alert('项目名称不能为空');
			return false;
		}

		if (charge == "") {
			alert('金额名称不能为空');
			return false;
		}

		if (charge.length > 8) {
			alert('金额不能大于8位');
			return false;
		}

		if (!patt.test(charge)) {
			alert('金额只能输入正浮点数');
			return false;
		}

		if (officeId == 0) {
			alert('请选择科室');
		}

		if (parameterId == 0) {
			alert('请选择小结方式');
		}

		if (check_val.length == 0) {
			alert('请选择细项');
			return false;
		}
		return true;
	});
})

$(function() {
	$('#updateProject').submit(function() {
		var patt = /^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$/;
		var itemName = $('#itemName').val();
		var charge = $('#charge').val();
		var officeId = $('#officeId').val();
		var parameterId = $('#parameterId').val();
		var subentryId = document.getElementsByName("subentryId");
		check_val = [];
		for (k in subentryId) {
			if (subentryId[k].checked)
				check_val.push(subentryId[k].value);
		}

		if (itemName == "") {
			alert('项目名称不能为空');
			return false;
		}

		if (charge == "") {
			alert('金额名称不能为空');
			return false;
		}

		if (charge.length > 8) {
			alert('金额不能大于8位');
			return false;
		}

		if (!patt.test(charge)) {
			alert('金额只能输入正浮点数');
			return false;
		}

		if (officeId == 0) {
			alert('请选择科室');
		}

		if (parameterId == 0) {
			alert('请选择小结方式');
		}

		if (check_val.length == 0) {
			alert('请选择细项');
			return false;
		}
		return true;
	});
})

function ckeck() {
	if ($("#check").val() == 'true') {
		return true;
	}
	alert('该项目名称已被使用');
	return false;
}
