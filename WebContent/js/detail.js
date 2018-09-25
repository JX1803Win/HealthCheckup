// JavaScript Document
$(function() {
	$('#addAdmin').submit(function() {
		var $detailName = $('#detailName').val();
		var $upperLimit = $('#upperLimit').val();
		var $lowerLimit = $('#lowerLimit').val();
		var $initValue = $('#initValue').val();
		if ($detailName == "") {
			alert('细项名称不能为空');
			return false;
		}

		if ($detailName.length > 15) {
			alert('用户名长度不能大于15位');
			return false;
		}

		if ($upperLimit == "") {
			alert('上限值不能为空');
			return false;
		}

		if ($upperLimit > 999999) {
			alert('上限值不能大于10W');
			return false;
		}

		if ($lowerLimit == "") {
			alert('下限值不能为空');
			return false;
		}

		if ($lowerLimit > $upperLimit) {
			alert('下限值不能大于上现在');
			return false;
		}

		if ($initValue == "") {
			alert('默认值不能为空');
			return false;
		}

		if ($initValue > $upperLimit) {
			alert('默认值不能超过上限值');
			return false;
		}

		if ($initValue < $lowerLimit) {
			alert('默认值不能小于下限值');
			return false;
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
	return false;
}

function alter(subentryId, detailName, parameterId, upperLimit, lowerLimit,
		initValue, price) {
	$("#subentryId").val(subentryId);
	$("#dName").val(detailName);
	$("#pId").val(parameterId);
	$("#uLimit").val(upperLimit);
	$("#lLimit").val(lowerLimit);
	$("#iValue").val(initValue);
	$("#money").val(price);
}
