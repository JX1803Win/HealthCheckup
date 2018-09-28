<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<title>项目详情</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="css/pag.css" rel="stylesheet" type="text/css">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/detail.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>${project.itemName}</h1>
		</div>
		<table class="table table-bordered" id="table1">
			<thead>
				<tr>
					<th>序号</th>
					<th>细项名称</th>
					<th>计量单位</th>
					<th>默认值</th>
					<th>上限值</th>
					<th>下限值</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${project.details}" var="detail" varStatus="vs">
					<tr>
						<td>${vs.index+1}</td>
						<td>${detail.detailName}</td>
						<td>${detail.parameterBean.parameterValues}</td>
						<td>${detail.initValue}</td>
						<td>${detail.upperLimit}</td>
						<td>${detail.lowerLimit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<a
				href="backstage/queryProject.action?currentPage=${currentPage}&&name=${name}"><button
					type="button" class="btn btn-default">返回</button> </a>
		</div>
	</div>
</body>
</html>
