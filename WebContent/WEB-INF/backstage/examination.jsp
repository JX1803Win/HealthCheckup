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
<title>检查</title>
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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript" src="js/summary.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>${project.itemName}检查</h1>
		</div>
		<div id="div8">
			<c:if test="${project.parameterId==26}">
				<form action="doctor/generalSummary.action?parameterId=12"
					id="method" method="post">
					<input type="hidden" name="proresId" value="${proresId}" />
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>序号</th>
								<th>名称</th>
								<th>数值</th>
								<th>单位</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${project.details}" var="detail" varStatus="vs">
								<tr>
									<td>${vs.index+1}<input type="hidden" name="subentryId"
										value="${detail.subentryId}" /></td>
									<td>${detail.detailName}<input type="hidden"
										name="detailName" value="${detail.detailName}" /></td>
									<td><input type="text" class="form-control" name="result"
										placeholder="请输入数值" /></td>
									<td>${detail.parameterBean.parameterName}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

					<div class="text-center t2">
						<a href="doctor/projectInf.action">
							<button type="button" class="btn btn-default m2">返回</button>
						</a>
						<button type="submit" class="btn btn-primary m2">保存</button>
					</div>
				</form>
			</c:if>
			<c:if test="${project.parameterId==27}">
				<form action="doctor/imageSummary.action?parameterId=12"
					id="method2" method="post" enctype="multipart/form-data">
					<input type="hidden" name="proresId" value="${proresId}" />
					<table class="table">
						<thead>
							<c:forEach items="${project.details}" var="detail" varStatus="vs">
								<tr>
									<th>${detail.detailName}<input type="hidden"
										name="subentryId" value="${detail.subentryId}" /></th>
									<td><input type="file" name="${detail.detailName}"
										id="inputfile" /></td>
								</tr>
							</c:forEach>
						</thead>
					</table>
					<div class="text-center t2">
						<a href="doctor/projectInf.action">
							<button type="button" class="btn btn-default m2">返回</button>
						</a>
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</form>
			</c:if>
			<c:if test="${project.parameterId==28}">
				<form action="doctor/projectSummary.action?parameterId=12"
					id="method" method="post">
					<input type="hidden" name="proresId" value="${proresId}" />
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>序号</th>
								<th>项目</th>
								<th>结果</th>
								<th>单位</th>
								<th>参考值</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${project.details}" var="detail" varStatus="vs">
								<tr>
									<td>${vs.index+1}<input type="hidden" name="subentryId"
										value="${detail.subentryId}" /></td>
									<td>${detail.detailName}<input type="hidden"
										name="detailName" value="${detail.detailName}" /></td>
									<td><input type="text" class="form-control" name="result"
										placeholder="请输入数值" value="${detail.initValue}" /></td>
									<td>${detail.parameterBean.parameterName}</td>
									<td>${detail.lowerLimit}~${detail.upperLimit}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="text-center t2">
						<a href="doctor/projectInf.action">
							<button type="button" class="btn btn-default m2">返回</button>
						</a>
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>

