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
<title>套餐详情</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/detail.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>${setmeal.setmealName}</h1>
		</div>
		<div id="div8">
			<c:forEach items="${setmeal.items}" var="project">
				<h4>项目名称:${project.itemName}&emsp;&emsp;
					所属科室：${project.officeBean.officeName}&emsp;&emsp;
					金额：${project.charge}
					&emsp;&emsp;小结类型：${project.parameterBean.parameterName}</h4>
				<hr />
				<table class="table">
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
			</c:forEach>
		</div>
		<div class="text-center">
			<a
				href="backstage/querySetmeal.action?currentPage=${currentPage}&&name=${name}"><button
					type="button" class="btn btn-default">返回</button></a>
		</div>
	</div>
</body>
</html>

