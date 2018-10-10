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
