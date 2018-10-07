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
<script type="text/javascript" src="js/summary.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>${projectResult.projectBean.itemName}检查</h1>
		</div>
		<div id="div8">
			<c:if test="${projectResult.projectBean.parameterId==26}">
				<form action="" id="method1" method="post">
					<input type="hidden" name="proresId"
						value="${projectResult.proresId}" />
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
							<c:forEach items="${projectResult.subentrys}" var="subentry"
								varStatus="vs">
								<tr>
									<td>${vs.index+1}</td>
									<td>${subentry.detail.detailName}</td>
									<td>${subentry.result}</td>
									<td>${subentry.detail.parameterBean.parameterName}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="form-group">
						<label for="projectResult">医师小结:</label>
						<textarea class="form-control" name="projectResult" rows="3">${projectResult.projectResult}</textarea>
					</div>

					<div class="text-center t2">
						<a href="doctor/projectInf.action">
							<button type="button" class="btn btn-default m2">返回</button>
						</a>
						<button type="submit" class="btn btn-primary m2"
							onclick="change1('backstage/generalSummary.action?parameterId=12')">保存</button>
						<button type="submit" class="btn btn-primary m2"
							onclick="change1('backstage/generalSummary.action?parameterId=13')">提交</button>
					</div>
				</form>
			</c:if>
			<c:if test="${projectResult.projectBean.parameterId==27}">
				<form action="" id="method2" method="post">
					<input type="hidden" name="proresId"
						value="${projectResult.proresId}" />
					<table class="table">
						<thead>
							<c:forEach items="${projectResult.subentrys}" var="subentry"
								varStatus="vs">
								<tr>
									<td>${subentry.detail.detailName}</td>
									<td><img src="${subentry.result}" class="img-responsive"
										alt="Cinque Terre" width="304" height="236"></td>
								</tr>
							</c:forEach>
						</thead>
						<tbody>
							<tr>
								<th>医师小结</th>
								<td><textarea class="form-control" rows="3"></textarea></td>
							</tr>
						</tbody>
					</table>
					<div class="text-center t2">
						<a href="doctor/projectInf.action">
							<button type="button" class="btn btn-default m2">返回</button>
						</a>
						<button type="submit" class="btn btn-primary m2"
							onclick="change2('backstage/projectSummary.action?parameterId=12')">保存</button>
						<button type="submit" class="btn btn-primary m2"
							onclick="change2('backstage/projectSummary.action?parameterId=13')">提交</button>
					</div>
				</form>
			</c:if>
			<c:if test="${projectResult.projectBean.parameterId==28}">
				<form action="" id="method3" method="post">
					<input type="hidden" name="proresId"
						value="${projectResult.proresId}" />
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>序号</th>
								<th>项目</th>
								<th>结果</th>
								<th>单位</th>
								<th>参考值</th>
								<th>提示</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${projectResult.subentrys}" var="subentry"
								varStatus="vs">
								<tr>
									<td>${vs.index+1}</td>
									<td>${subentry.detail.detailName}</td>
									<td>${subentry.result}</td>
									<td>${subentry.detail.parameterBean.parameterName}</td>
									<td>${subentry.detail.lowerLimit}~${subentry.detail.upperLimit}</td>
									<td>${subentry.hint}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="form-group">
						<label for="name">医师小结:</label>
						<textarea class="form-control" rows="3"></textarea>
					</div>

					<div class="text-center t2">
						<a href="doctor/projectInf.action">
							<button type="button" class="btn btn-default m2">返回</button>
						</a>
						<button type="submit" class="btn btn-primary m2"
							onclick="change3('backstage/projectSummary.action?parameterId=12')">保存</button>
						<button type="submit" class="btn btn-primary m2"
							onclick="change3('backstage/projectSummary.action?parameterId=13')">提交</button>
					</div>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>

