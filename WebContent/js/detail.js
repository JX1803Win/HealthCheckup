// JavaScript Document
$(function() {
	alert("1111111");
	$('#addDetail')
			.submit(
					function() {
						var $detailName = $('#detailName').val();
						var $upperLimit = $('#upperLimit').val();
						var $lowerLimit = $('#lowerLimit').val();
						var $initValue = $('#initValue').val();
						var patt = /^((0-9)+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
						if ($detailName == "") {
							alert('细项名称不能为空');
							return false;
						}

						if ($detailName.length > 15) {
							alert('细项名称不能大于15位');
							return false;
						}
						alert("1111111");

						if ($upperLimit.test(patt)) {
							alert('上限值只能输入正浮点数');
							return false;
						}

						if ($lowerLimit.test(patt)) {
							alert('下限值只能输入正浮点数');
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
		initValue) {
	$("#subentryId").val(subentryId);
	$("#dName").val(detailName);
	$("#pId").val(parameterId);
	$("#uLimit").val(upperLimit);
	$("#lLimit").val(lowerLimit);
	$("#iValue").val(initValue);
}
