<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下载体检报告</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>css/x-admin.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/pag.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/AdminManagement.css" rel="stylesheet" type="text/css">
<link href="<%=path%>lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>bgjs/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>js/AdminManagement.js"></script>
<script type="text/javascript">
	function search() {
		if($("#physicaiId").val() == "") {
			alert("体检号不能为空！");
			return;
		}
		var myForm=document.getElementById("myForm");
		myForm.action="<%=path%>ReportAction/query.action";
		myForm.method="post";
		myForm.submit();
	}
	$(function() {
		var result = "${uprb}";
		var condition = "${physicaiId}";
		if(result == "" && condition.length > 0) {
			alert("未找到，请重新输入！");
		}
	})
</script>
</head>
<body>
<div class="container">
	 <div class="page-header text-center">
		<h1>下载体检报告</h1>
	</div>
	<div class="text-center" id="div4">
		<form class="form-inline" id="myForm">
			<div class="form-group">
				<label for="physicaiId" class="m">体检号:</label> <input type="text"
					class="form-control input-sm  m5" id="physicaiId" name="physicaiId" value="${physicaiId}">
			</div>
			<input type="button" class="btn btn-primary" onclick="search()" value="查询"/>
		</form>
	</div><c:if test="${uprb != null}">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th style="text-align:center">体检号</th>
				<th style="text-align:center">体检人姓名</th>
				<th style="text-align:center">体检时间</th>
				<th style="text-align:center">体检套餐</th>
				<th style="text-align:center">体检项目</th>
				<th style="text-align:center">操作</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${uprb.physicaiId}</td>
				<td>${uprb.userName}</td>
				<td>
					<c:if test="${uprb.appoTime != null}">${uprb.appoTime}</c:if>
					<c:if test="${uprb.appoTime == null}">${uprb.phyTime}</c:if>
				</td>
				<td>${uprb.setmealName}</td>
				<td>${uprb.itemName}</td>
				<td class="text-center">
					<a target="_blank" href="<%=path%>ReportAction/preview.action?physicaiId=${uprb.physicaiId}">
						<button class="btn btn-primary">预览</button>
					</a>
					<a href="<%=path%>ReportAction/download.action?physicaiId=${uprb.physicaiId}">
						<button class="btn btn-primary">下载</button>
					</a>
				</td>
			</tr>
		</tbody>
	</table></c:if>
</div>
</body>
</html>