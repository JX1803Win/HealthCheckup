$(function() {
$("#increased").click(
			function() {
				
				$.ajax({
					url : "<%=path %>ManageAction/selectPhyCard.action",//请求地址
					data : "page="
						+ $("#increased").val(),//发送至服务器的键值数据
					dataType :"json",//请求数据格式，如script,json,text等
					type : "post",//发送方式，get/post
					success : function(redata) {////定义各事件发生时回调的函数
						$("#phyCardId").find("option").remove();
						$("#phyCardId")
						.append(
								'<option value="0">请选择一项</option>');
						$.each(redata, function(i, item) {
							
							$("#phyCardId")
									.append(
											"<option value="+item.phyCardId+">"
													+ item.phyCardId
													+ "</option>");
						});
					}
				});
			});
}); 
 $(function() {
$("#increased").click(function() {
	var str=$("#increased").val();
	$("#userId").val(str);
	 alert(str); 
}); 
}); 
 $(function() {
	 $("#change").click(
	 			function() {
	 				
	 				$.ajax({
	 					url : "<%=path %>ManageAction/selectPhyCard.action",//请求地址
	 					data : "page="
	 						+ $("#increased").val(),//发送至服务器的键值数据
	 					dataType :"json",//请求数据格式，如script,json,text等
	 					type : "post",//发送方式，get/post
	 					success : function(redata) {////定义各事件发生时回调的函数
	 						$("#phyCardId").find("option").remove();
	 						$("#phyCardId")
	 						.append(
	 								'<option value="0">请选择一项</option>');
	 						$.each(redata, function(i, item) {
	 							
	 							$("#phyCardId")
	 									.append(
	 											"<option value="+item.phyCardId+">"
	 													+ item.phyCardId
	 													+ "</option>");
	 						});
	 					}
	 				});
	 			});
	 }); 
	  $(function() {
	 $("#change").click(function() {
	 	var str=$("#change").val();
	 	$("#userId1").val(str);
	 	 alert(str); 
	 }); 
	 }); 