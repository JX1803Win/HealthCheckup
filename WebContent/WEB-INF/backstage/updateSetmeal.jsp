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
<title>修改套餐</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/project.css" rel="stylesheet" type="text/css" />
<script type="text/jscript" src="js/setmeal.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>修改套餐</h1>
		</div>
		<div id="div8">

			<form role="form" action="backstage/affirmUpdateSetmeal.action"
				method="post">
				<input type="hidden" name="setmealId"
					value="${resultMap['setmeal'].setmealId}"> <input
					type="hidden" name="currentPage" value="${currentPage}"> <input
					type="hidden" name="name" value="${name}">
				<div class="form-group">
					<label for="itemName">套餐名称：</label> <input type="text"
						class="form-control" name="setmealName" id="setmealName"
						placeholder="请输入项目名称" value="${resultMap['setmeal'].setmealName}" />
				</div>


				<div class="text-center">
					<label for="projectId">已选项目：</label>
					<c:forEach items="${resultMap['setmeal'].items}" var="project"
						varStatus="vs">
						<c:if test="${vs.index%4==0}">
							<br />
						</c:if>
						<label class="checkbox-inline m2"> <input type="checkbox"
							name="projectId" value="${project.projectId}" checked="checked">
							${project.itemName}
						</label>
					</c:forEach>
				</div>
				<div class="text-center t2">
					<label for="projectId">未选项目：</label>
					<c:forEach items="${resultMap['projects']}" var="project"
						varStatus="vs">
						<c:if test="${vs.index%4==0}">
							<br />
						</c:if>
						<label class="checkbox-inline m2"> <input type="checkbox"
							name="projectId" value="${project.projectId}">
							${project.itemName}
						</label>
					</c:forEach>
				</div>
				<div class="text-center t2">
					<a
						href="backstage/querySetmeal.action?currentPage=${currentPage}&&name=${name}"><button
							type="button" class="btn btn-default m2">返回</button></a>
					<button type="submit" class="btn btn-primary m2" onclick="return uodate()">提交</button>
				</div>
			</form>

		</div>
	</div>
</body>
</html>
