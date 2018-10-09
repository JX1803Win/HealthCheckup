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
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>体检小结</title>
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
<link href="css/log.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/log.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>体检小结</h1>
		</div>
		<div class="text-center" id="div4">
			<form action="backstage/querySummary.action" class="form-inline"
				role="form" method="post">
				<div class="form-group">
					<label for="parameterId" class="m">小结状态：</label><select
						class="selectpicker form-control" name="parameterId"
						id="parameterId" title="请选择一项" data-size="5">
						<option class="form-control" value="0">请选择一项</option>
						<option class="form-control" value="12"
							${parameterId==12?"selected='selected'":''}>待提交</option>
						<option class="form-control" value="13"
							${parameterId==13?"selected='selected'":''}>已提交</option>
					</select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">查询</button>
				</div>
			</form>
		</div>

		<table class="table table-bordered">
			<caption>共有数据：${resultMap['total']} 条</caption>
			<thead>
				<tr>
					<th>序号</th>
					<th>体检号</th>
					<th>用户名</th>
					<th>项目名称</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap['projectResults']}"
					var="projectResult" varStatus="vs">
					<tr>
						<td>${(resultMap['currentPage']-1)*5+vs.index+1}</td>
						<td>${projectResult.physicaiId}</td>
						<td>${projectResult.userName}</td>
						<td>${projectResult.projectBean.itemName}</td>
						<td>${projectResult.parameterName}</td>
						<td class="text-center"><c:if
								test="${projectResult.parameterId==12}">
								<a
									href="backstage/skipSummary.action?proresId=${projectResult.proresId}"><button
										type="button" class="btn btn-primary">小结</button></a>
							</c:if> <c:if test="${projectResult.parameterId==13}">
								<a
									href="backstage/particular.action?proresId=${projectResult.proresId}&&currentPage=${resultMap['currentPage']}&&parameterId=${parameterId}"><button
										type="button" class="btn btn-primary">查看详情</button></a>
							</c:if></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="page">
			<div class="pagelist text-center">
				<c:choose>
					<c:when test="${resultMap['currentPage']>1}">
						<span class="jump"><a
							href="backstage/querySummary.action?parameterId=${parameterId}">首页</a></span>
						<span class="jump"><a
							href="backstage/querySummary.action?currentPage=${resultMap['currentPage']-1}&&parameterId=${parameterId}">上一页</a></span>
					</c:when>
					<c:otherwise>
						<span class="jump">首页</span>
						<span class="jump">上一页</span>
					</c:otherwise>
				</c:choose>
				<span class="jump">${resultMap['currentPage']}/${resultMap['totalPage']}</span>
				<c:choose>
					<c:when test="${resultMap['currentPage']<resultMap['totalPage']}">
						<span class="jump"><a
							href="backstage/querySummary.action?currentPage=${resultMap['currentPage']+1}&&parameterId=${parameterId}">下一页</a></span>
						<span class="jump"><a
							href="backstage/querySummary.action?currentPage=${resultMap['totalPage']}&&parameterId=${parameterId}">末页</a></span>
					</c:when>
					<c:otherwise>
						<span class="jump">下一页</span>
						<span class="jump">末页</span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

	</div>
</body>
</html>
