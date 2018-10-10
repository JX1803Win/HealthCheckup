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
<title>修改项目</title>
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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/jscript" src="js/project.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>修改项目</h1>
		</div>
		<div id="div8">

			<form role="form" id="updateProject"
				action="backstage/affirmUpdate.action" method="post">
				<input type="hidden" id="check" value="true"> <input
					type="hidden" name="projectId"
					value="${resultMap['project'].projectId}"> <input
					type="hidden" name="currentPage" value="${currentPage}"> <input
					type="hidden" name="name" value="${name}"> <input
					type="hidden" id="iName" value="${resultMap['project'].itemName}">
				<div class="form-group">
					<label for="itemName">项目名称：</label> <input type="text"
						class="form-control" name="itemName" id="itemName"
						placeholder="请输入项目名称" value="${resultMap['project'].itemName}" />
				</div>

				<div class="form-group">
					<label for="charge">金额：</label> <input name="charge" id="charge"
						type="text" class="form-control" placeholder="请输入单价"
						value="${resultMap['project'].charge}">
				</div>

				<div class="form-group">
					<label for="officeId">科室：</label> <select class=" form-control"
						name="officeId" id="officeId" title="请选择一项" data-size="5">
						<option class="form-control" value="0">请选择一项</option>
						<c:forEach items="${resultMap['offices']}" var="office">
							<option class="form-control" value="${office.officeId}"
								${office.officeId==resultMap['project'].officeId?"selected='selected'":''}>${office.officeName}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="parameterId">小结类型：</label> <select
						class=" form-control" name="parameterId" id="parameterId"
						title="请选择一项" data-size="5">
						<option class="form-control" value="0">请选择一项</option>
						<c:forEach items="${resultMap['parameters']}" var="parameter">
							<option class="form-control" value="${parameter.parameterId}"
								${parameter.parameterId==resultMap['project'].parameterId?"selected='selected'":''}>${parameter.parameterName}</option>
						</c:forEach>
					</select>
				</div>

				<div class="text-center">
					<label for="subentryId">已选细项：</label>
					<c:forEach items="${resultMap['project'].details}" var="detail"
						varStatus="vs">
						<c:if test="${vs.index%4==0}">
							<br />
						</c:if>
						<label class="checkbox-inline m2"> <input type="checkbox"
							name="subentryId" value="${detail.subentryId}" checked="checked">
							${detail.detailName}
						</label>
					</c:forEach>
				</div>
				<div class="text-center t2">
					<label for="subentryId">未选细项：</label>
					<c:forEach items="${resultMap['details']}" var="detail"
						varStatus="vs">
						<c:if test="${vs.index%4==0}">
							<br />
						</c:if>
						<label class="checkbox-inline m2"> <input type="checkbox"
							name="subentryId" value="${detail.subentryId}">
							${detail.detailName}
						</label>
					</c:forEach>
				</div>
				<div class="text-center t2">
					<a
						href="backstage/queryProject.action?currentPage=${currentPage}&&name=${name}"><button
							type="button" class="btn btn-default m2">返回</button></a>
					<button type="submit" class="btn btn-primary m2"
						onclick="return uodate()">提交</button>
				</div>
			</form>

		</div>
	</div>
</body>
</html>
