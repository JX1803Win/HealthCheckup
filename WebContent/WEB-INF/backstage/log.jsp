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
<title>查看日志</title>
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
			<h1>查看日志</h1>
		</div>
		<div class="text-center" id="div4">
			<form action="backstage/queryLog.action" class="form-inline"
				role="form" method="post">
				<div class="form-group">
					<label for="adminName" class="m">管理员：</label> <input type="text"
						class="form-control input-sm  m5" id="adminName" name="adminName"
						placeholder="请输入管理员名称" value="${adminName}">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">查询</button>
				</div>
			</form>
		</div>
		<div class="tools">
			<form action="backstage/delLogs.action" class="form-inline"
				role="form" method="post">
				<input type="hidden" name="adminName" value="${adminName}">
				<input type="hidden" name="currentPage"
					value="${resultMap[currentPage]}">
				<table class="table table-bordered" id="table1">
					<caption>共有数据：${resultMap['total']} 条</caption>
					<thead>
						<tr>
							<th><input type="checkbox" id="all">序号</th>
							<th>管理员</th>
							<th>执行的模块</th>
							<th>执行的方法</th>
							<th>响应时间</th>
							<th>IP地址</th>
							<th>执行时间</th>
							<th>执行描述</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${resultMap['logs']}" var="log" varStatus="vs">
							<tr>
								<td><input type="checkbox" name="logId"
									value="${log.logId}">${(resultMap['currentPage']-1)*5+vs.index+1}</td>
								<td>${log.managerBean.mangerName}</td>
								<td>${log.module}</td>
								<td>${log.method}</td>
								<td>${log.rsponseDate}</td>
								<td>${log.ip}</td>
								<td>${log.executionDate}</td>
								<td>${log.commite}</td>
								<td class="text-center"><a
									href="backstage/delLog.action?logId=${log.logId}&&adminName=${adminName}&&currentPage=${resultMap[currentPage]}"
									onclick="return del()"><button type="button"
											class="btn btn-primary">删除</button></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="page">
					<div class="pagelist text-center">
						<c:choose>
							<c:when test="${resultMap['currentPage']>1}">
								<span class="jump"><a
									href="backstage/queryLog.action?currentPage=${resultMap['currentPage-1']}&&adminName=${adminName}">上一页</a></span>
							</c:when>
							<c:otherwise>
								<span class="jump">上一页</span>
							</c:otherwise>
						</c:choose>
						<span class="jump">${resultMap['currentPage']}/${resultMap['totalPage']}</span>
						<c:choose>
							<c:when test="${resultMap['currentPage']<resultMap['totalPage']}">
								<span class="jump"><a
									href="backstage/queryLog.action?currentPage=${resultMap['currentPage']+1}&&adminName=${adminName}">下一页</a></span>
							</c:when>
							<c:otherwise>
								<span class="jump">下一页</span>
							</c:otherwise>
						</c:choose>
						<span id="right"><button type="button"
								class="btn btn-primary m2">导出Excel</button>
							<button type="submit" class="btn btn-primary">批量删除</button></span>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>