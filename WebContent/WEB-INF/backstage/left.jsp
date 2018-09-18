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
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>

<link href="css/myPublic.css" rel="stylesheet" type="text/css" />
</head>

<body id="bg">
	<!-- 左边节点 -->
	<div class="container">

		<div class="leftsidebar_box">
			<dl class="system_log">
				<dt>
					<img class="icon1" /> <img class="icon2" />用户管理 <img
						class="icon3" src="images/coin19.png" /> <img class="icon4"
						src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /> <img
						class="coin22" src="images/coin222.png" /> <a
						href="backstage/user!select.action" target="main" class="cks">用户管理</a>
					<img class="icon5" src="images/coin21.png" />
				</dd>
			</dl>

			<dl class="system_log">
				<dt>
					<img class="icon1" /> <img class="icon2" />文档管理<img class="icon3"
						src="images/coin19.png" /> <img class="icon4"
						src="images/coin20.png" />
				</dt>
				<dd>
					<img class="coin11" src="images/coin111.png" /> <img
						class="coin22" src="images/coin222.png" /> <a
						href="backstage/user!select.action" target="main" class="cks">文档管理</a>
					<img class="icon5" src="images/coin21.png" />
				</dd>
				<dd>
					<img class="coin11" src="images/coin111.png" /> <img
						class="coin22" src="images/coin222.png" /> <a
						href="backstage/document!type.action" target="main" class="cks">文档配置</a>
					<img class="icon5" src="images/coin21.png" />
				</dd>
			</dl>
		</div>

	</div>
</body>
</html>