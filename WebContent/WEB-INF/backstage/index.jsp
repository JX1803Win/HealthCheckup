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
<title>心理咨询后台管理</title>
</head>
<frameset rows="100,*" cols="*" scrolling="No" framespacing="0"
	frameborder="no" border="0">
	<frame src="backstage/head.action" name="headmenu" id="mainFrame"
		title="mainFrame">
	<!-- 引用头部 -->
	<!-- 引用左边和主体部分 -->
	<frameset rows="100*" cols="220,*" scrolling="No" framespacing="0"
		frameborder="no" border="0">
		<frame src="backstage/left.action" name="leftmenu" id="mainFrame"
			title="mainFrame">
		<frame src="backstage/main.action" name="main" scrolling="yes"
			noresize="noresize" id="rightFrame" title="rightFrame">
	</frameset>
</frameset>
</html>