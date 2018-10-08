<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>套餐</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>css/x-admin.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/pag.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/AdminManagement.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>bgjs/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>js/AdminManagement.js"></script>
<script type="text/javascript">
	var typeList;
	$(function() {
		$.getJSON("<%=path%>ParamAction/queryAllTypeName.action", 
		function(data) {
			console.log(data);
			typeList = data;
			//var data = JSON.parse(datas);
			for (var i = 0; i < data.length; i++) {
				console.log(data[i].parameterId);
				$("#typeName").append("<option value="+ data[i].parameterId +">"+data[i].parameterName+"</option>");
			}
		});
	})
	function turn() {
		var msg = "是否确定修改？";
		if(confirm(msg) == true) {
			return true;
		}
		return false;
	}
	function del(id) {
		var msg = "是否确定删除?";
		var page = ${pageNo==null?1:pageNo};
		if(confirm(msg) == true) {
			 $.ajax({
		    		url : "del.action",
		    		data : "officeid=" + id,
		    		dataType : "text",
		    		type : "post",
		    		success : function() {
		    			window.location.href = "<%=path%>backstage/office.action?page="+page;
		    		}
		    	});
		}
	}
	function search() {
		var myForm=document.getElementById("myForm");
		myForm.action="<%=path%>user/selectmeal.action";
		myForm.method="post";
		myForm.submit();
	}
	
	
	
	function nextPage(page) {
		page++;
		window.location.href='gosetmeal.action?page='+page;
		
	}
	function previousPage(page) {
		page--;
		if(page<=0){
			page=1;
		}
		window.location.href='gosetmeal.action?page='+page;
	}
	

	
	function add() {
		var roleName = $("#roleNames").val();
		alert($("#roleNames").val())
		if(roleName == "") {
			alert("科室名称不能为空");
			return;
		}
		var name = $("#roleNames").val();
		 $.ajax({
	    		url : "addoffice.action",
	    		data : "officename=" + name,
	    		dataType : "text",
	    		type : "post",
	    		success : function() {
	    			window.location.href = "<%=path%>backstage/office.action?page="+page;
	    		}
	    	});
	}

	function alter(roleId) {
		 $.ajax({
	    		url : "lookxi.action",
	    		data : "mid=" + roleId,
	    		dataType : "text",
	    		type : "post",
	    		success : function(data) {
	    			var json = eval("("+data+")"); // data的值是json字符串，这行把字符串转成object  
	    			var str=""; 
	    			$.each(json,function(index,item){
	    				str+=item.itemName+",";
  			      	})
  			      	str=str.substring(0,str.length-1);
	    			$("#uproleName").val(str);		
	    		}
	    	});
	
	}
	function adds() {
		var roleName = $("#uproleName").val();
		if(roleName == "") {
			alert("修改不能为空");
			return;
		}
		
		
		var id = $("#uproleId").val();
		var name = $("#uproleName").val();
		var page = ${pageNo==null?1:pageNo};
		
			 $.ajax({
		    		url : "change.action",
		    		data : "uproleId=" + id + "&uproleName="+name,
		    		dataType : "text",
		    		type : "post",
		    		success : function() {
		    			window.location.href = "<%=path%>backstage/office.action?page="+page;
		    		}
		    	});
	
	}
</script>
</head>
<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>查看套餐</h1>
		</div>
		<div class="text-center" id="div4">
			<form class="form-inline" role="form" id="myForm">
				<div class="form-group">
					<label for="name" class="m">套餐名称:</label> <input type="text"
						class="form-control input-sm  m5" id="name" name="name"
						placeholder="请输入名称" value="${name}">
				</div>

				<input type="button" class="btn btn-primary" onclick="search()"
					value="查询" />
			</form>
		</div>

		<div class="clearfix"></div>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>序号</th>
					<th>套餐名</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="menu" varStatus="vs">
					<tr>
						<td>${menu.getNum()}</td>
							<td style="color: gray">${menu.getSetmealName()}</td>
							<td class="text-center">
								<button class="btn btn-primary x-right" data-toggle="modal"
									data-target="#myModal2"
									onclick="alter('${menu.getSetmealId()}')">查看</button>
							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
				<div class="page">
			<div class="pagelist text-center">
				<button class="btn btn-primary"
					onclick="previousPage(${sessionScope.page})">上一页</button>
				<button class="btn btn-primary"
					onclick="nextPage(${sessionScope.page})">下一页</button>
			</div>
		</div>
		
		
		
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title" id="myModalLabel">新增参数</h4>
					</div>

					<form id="myForm2" class="form-horizontal" role="form">
						<div class="modal-body">

							<div class="form-group">
								<label for="roleNames" class="col-sm-2 control-label">科室名称</label>
								<div class="col-sm-10">
									<input name="roleNames" id="roleNames" type="text"
										class="form-control" placeholder="请输入科室名称(必填)">
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary" onclick="add()">提交</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<!-- 修改模态框（Modal） -->
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">查看</h4>
					</div>

					<form id="myForm3" class="form-horizontal" role="form">
						<div class="modal-body">

							<div class="form-group">
								<label for="roleNames" class="col-sm-2 control-label">细项名称</label>
								<input name="uproleId" id="uproleId" type="hidden"
									class="form-control">
								<div class="col-sm-10">
									<input name="uproleName" id="uproleName" type="text"
										class="form-control">
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
	</div>
	<br />
	<br />
	<br />
	<script src="<%=path%>lib/layui/layui.js" charset="utf-8"></script>
	<script>
		layui.use([ 'laydate', 'element', 'laypage', 'layer' ], function() {
			$ = layui.jquery;//jquery
			lement = layui.element();//面包导航

		});
	</script>
</body>
</html>