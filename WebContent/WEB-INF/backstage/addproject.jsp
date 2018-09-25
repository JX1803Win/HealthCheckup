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
<title>增加项目</title>
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


</head>
<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>增加项目</h1>
		</div>
		<div id="div8">

			<form role="form" action="backstage/affirmAdd.action" method="post">
				<input type="hidden" name="currentPage" value="${currentPage}">
				<input type="hidden" name="name" value="${name}">
				<div class="form-group">
					<label for="itemName">项目名称：</label> <input type="text"
						class="form-control" name="itemName" id="itemName"
						placeholder="请输入项目名称" />
				</div>


				<div class="form-group">
					<label for="officeId">科室：</label> <select class=" form-control"
						name="officeId" id="officeId" title="请选择一项" data-size="5">
						<option class="form-control" value="0">请选择一项</option>
						<%-- <c:forEach items="${resultMap['parameters']}" var="parameter">
							<option class="form-control" value="${parameter.parameterId}">${parameter.parameterValues}</option>
						</c:forEach> --%>
					</select>
				</div>
				<div class="text-center">
					<label for="parameterId">请选择细项：</label> <br />
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
					<button type="submit" class="btn btn-primary m2">提交</button>
				</div>
			</form>

		</div>
	</div>
</body>
</html>
