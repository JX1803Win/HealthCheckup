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
			<c:forEach items="${pibList}" var="entry">
				<dl class="system_log">
					<c:if test="${entry.preMenu==0}">
						<dt>
							<img class="icon1" /> <img class="icon2" />${entry.menuName} <img
								class="icon3" src="images/coin19.png" /> <img class="icon4"
								src="images/coin20.png" />
						</dt>
						<c:forEach items="${pibList}" var="entry2">
							<c:if test="${entry2.preMenu==entry.permissionsId}">
								<dd>
									<img class="coin11" src="images/coin111.png" /> <img
										class="coin22" src="images/coin222.png" /> <a
										href="${entry2.urlAddress} " target="main" class="cks">${entry2.menuName}</a>
									<img class="icon5" src="images/coin21.png" />
								</dd>
							</c:if>
						</c:forEach>
					</c:if>

				</dl>
			</c:forEach>


		</div>


	</div>
</body>
</html>