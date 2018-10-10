<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>健康体检散检后台管理</title>
<link href="css/myPublic.css" rel="stylesheet" type="text/css" />
</head>


<body>
	<!-- 头部 -->
	<div class="head">
		<div class="headL">
			<h1 id="headL">健康体检散检后台管理</h1>
		</div>
		<div class="headR">
			<a href="backstage/indexs.action" target="_parent">【退出】</a>
		</div>
	</div>
	<div class="user">
		<span>${admin.mangerName}</span>
	</div>

</body>

</html>