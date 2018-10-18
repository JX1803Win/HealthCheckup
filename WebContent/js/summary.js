// JavaScript Document

function change(num) {
	$("#parameterId").val(num);
}

$(function() {
	$('#method').submit(function() {
		var projectResult = $('#projectResult').val();
		if (projectResult == "") {
			alert('医师小结不能为空');
			return false;
		}

		return true;
	});
})

$(function() {
	$('#method').submit(function() {
		var result = document.getElementsByName("result");
		var detailName = document.getElementsByName("detailName");
		for (var i = 0; i < result.length; i++) {
			// 获取元素的value值
			if (result[i].value == "") {
				alert(detailName[i].value + "不能为空")
				return false;
			}
		}
		return true;
	});
})
