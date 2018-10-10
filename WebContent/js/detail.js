// JavaScript Document
$(function() {
	$('#addDetail').submit(function() {
		var $detailName = $('#detailName').val();
		var $upperLimit = $('#upperLimit').val();
		var $lowerLimit = $('#lowerLimit').val();
		var $initValue = $('#initValue').val();
		var patt = /^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$/;
		if ($detailName == "") {
			alert('细项名称不能为空');
			return false;
		}

		if ($detailName.length > 15) {
			alert('细项名称不能大于15位');
			return false;
		}
		if ($upperLimit != "") {
			if (!patt.test($upperLimit)) {
				alert('上限值只能输入正浮点数');
				return false;
			}

			if ($upperLimit.length > 8) {
				alert('上限值不能大于8位');
				return false;
			}

			if ($initValue > $upperLimit) {
				alert('默认值不能超过上限值');
				return false;
			}

			if ($lowerLimit != "") {
				if ($upperLimit < $lowerLimit) {
					alert('上限值不能小于下限值');
					return false;
				}
			}

		}

		if ($lowerLimit != "") {

			if (!patt.test($lowerLimit)) {
				alert('下限值只能输入正浮点数');
				return false;
			}

			if ($lowerLimit.length > 8) {
				alert('下限值不能大于8位');
				return false;
			}
			if ($initValue != "") {
				if ($initValue < $lowerLimit) {
					alert('默认值不能小于下限值');
					return false;
				}
			}
		}
	});
});

function ckeck1() {
	if ($("#check").val() == 'true') {
		return true;
	}
	alert('该细项名称已被使用');
	return false;
}

function checkDetailName() {
	$.ajax({
		url : "backstage/checkDetail.action",
		data : "detailName=" + $('#detailName').val(),
		type : "POST",
		dataType : "text",
		success : function(result) {
			if ('false' == result) {
				alert('该细项名称已被使用');
			}
			$("#check").val(result);
		},
		error : function() {
			alert("异常！");
		}
	});
}

function checkDetailName1() {
	$.ajax({
		url : "backstage/checkDetail.action",
		data : "detailName=" + $('#dName').val(),
		type : "POST",
		dataType : "text",
		success : function(result) {
			if ('false' == result) {
				alert('该细项名称已被使用');
			}
			$("#check").val(result);
		},
		error : function() {
			alert("异常！");
		}
	});
}

$(function() {
	$('#detailName').blur(function() {
		checkDetailName();
	});
});

$(function() {
	$('#dName').blur(function() {
		if ($('#dName').val() != $('#deName').val()) {
			checkDetailName1();
		}
	});
});

$(function() {
	$('#updateDetail').submit(function() {
		var $detailName = $('#dName').val();
		var $upperLimit = $('#uLimit').val();
		var $lowerLimit = $('#lLimit').val();
		var $initValue = $('#iValue').val();
		var patt = /^[1-9]\d*\.\d*|0\.\d*[1-9]\d*$/;
		if ($detailName == "") {
			alert('细项名称不能为空');
			return false;
		}

		if ($detailName.length > 15) {
			alert('细项名称不能大于15位');
			return false;
		}
		if ($upperLimit != "") {
			if (!patt.test($upperLimit)) {
				alert('上限值只能输入正浮点数');
				return false;
			}

			if ($upperLimit.length > 8) {
				alert('上限值不能大于8位');
				return false;
			}

			if ($initValue > $upperLimit) {
				alert('默认值不能超过上限值');
				return false;
			}

			if ($lowerLimit != "") {
				if ($upperLimit < $lowerLimit) {
					alert('上限值不能小于下限值');
					return false;
				}
			}

		}

		if ($lowerLimit != "") {

			if (!patt.test($lowerLimit)) {
				alert('下限值只能输入正浮点数');
				return false;
			}

			if ($lowerLimit.length > 8) {
				alert('下限值不能大于8位');
				return false;
			}
			if ($initValue != "") {
				if ($initValue < $lowerLimit) {
					alert('默认值不能小于下限值');
					return false;
				}
			}
		}
	});
});

function del() {
	question = confirm("是否要删除该细项")
	if (question != "0") {
		return true;
	}
	return false;
}

function update() {
	question = confirm("是否要修改该细项")
	if (question != "0") {
		return true;
	}
	ckeck1()
	return false;
}

function alter(subentryId, detailName, parameterId, upperLimit, lowerLimit,
		initValue) {
	$("#subentryId").val(subentryId);
	$("#dName").val(detailName);
	$('#deName').val(detailName);
	$("#pId").val(parameterId);
	$("#uLimit").val(upperLimit);
	$("#lLimit").val(lowerLimit);
	$("#iValue").val(initValue);
}
