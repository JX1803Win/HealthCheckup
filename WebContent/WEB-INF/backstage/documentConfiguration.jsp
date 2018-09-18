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
<title>文档配置</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link href="css/x-admin.css" rel="stylesheet" type="text/css" />

<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/public.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="lib/layui/layui.js"></script>
<script type="text/javascript" src="js/myPublic.js"></script>
</head>
<body>
	<div class="container">
		<div class="x-nav">
			<span class="layui-breadcrumb"> <a href="main.jsp"><cite>首页</cite></a>
				<a><cite>文档配置</cite></a>
			</span>
		</div>

		<div class="page-header text-center">
			<h1>文档配置</h1>
		</div>

		<div class="div8 text-center">
			<form action="#" role="form" name="upload" id="upload" method="post">
				<div class="form-group">
					<c:forEach items="${types}" var="type" varStatus="vs">
						<c:if test="${vs.index%3==0}">
							<br />
						</c:if>
						<label class="checkbox-inline m2"> <input type="checkbox"
							id="inlineCheckbox1" value="${type.typeId }"
							${type.stateId==0?"checked='checked'":''}> ${type.type}
						</label>
					</c:forEach>
				</div>
				<button type="submit" class="btn btn-primary m2">提交</button>
				<button type="button" class="btn btn-default m3">返回</button>
			</form>

		</div>

	</div>
</body>
</html>