// JavaScript Document

function change1(url) {
	document.getElementById('method1').action = url;
}

function change2(url) {
	document.getElementById('method2').action = url;
}

function change3(url) {
	alert(url);
	document.getElementById('method3').action = url;
}

$(function() {
	$('#method1').submit(function() {
		var projectResult = $('#projectResult').val();

		if (projectResult == "") {
			alert('医师小结不能为空');
			return false;
		}

		return true;
	});
})
$(function() {
	$('#method2').submit(function() {
		var projectResult = $('#projectResult').val();

		if (projectResult == "") {
			alert('医师小结不能为空');
			return false;
		}

		return true;
	});
})
$(function() {
	$('#method3').submit(function() {
		var projectResult = $('#projectResult').val();

		if (projectResult == "") {
			alert('医师小结不能为空');
			return false;
		}

		return true;
	});
})
