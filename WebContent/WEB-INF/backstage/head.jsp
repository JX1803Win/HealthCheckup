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
<title>文档分享后台管理</title>



<link href="css/myPublic.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<!-- 头部 -->
	<div class="head">
		<div class="headL">
			<h1 id="headL">文档分享后台管理</h1>
		</div>
		<div class="headR">
			<a href="AdminServlet?action=exit" target="_parent">【退出】</a>
		</div>
	</div>
	<div class="user">
		<span>${admin.adminName}</span>
	</div>

</body>

</html>