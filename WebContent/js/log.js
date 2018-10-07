// JavaScript Document

$(function() {
	// 实现全选反选
	$("#all").on('click', function() {
		$("tbody input:checkbox").prop("checked", $(this).prop('checked'));
	})
	$("tbody input:checkbox")
			.on(
					'click',
					function() {
						// 当选中的长度等于checkbox的长度的时候,就让控制全选反选的checkbox设置为选中,否则就为未选中
						if ($("tbody input:checkbox").length === $("tbody input:checked").length) {
							$("#all").prop("checked", true);
						} else {
							$("#all").prop("checked", false);
						}
					})
})

function del() {
	question = confirm("是否要删除该日志")
	if (question != "0") {
		return true;
	}
	return false;
}

function del1() {
	question = confirm("是否要删除已选中日志")
	if (question != "0") {
		return true;
	}
	return false;
}