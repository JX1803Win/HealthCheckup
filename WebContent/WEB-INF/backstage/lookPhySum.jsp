<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编写体检总结</title>
<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
<link href="<%=path%>lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
	<div class="page-header text-center">
		<h1>查看体检总结</h1>
	</div>
	<table class="table table-bordered">
			<tr>
				<td>体检人：${uprb.userName}</td>
			</tr>
			<tr>	
				<td>体检号：${uprb.physicaiId}</td>
			</tr>
			<tr>
				<td>体检时间：
					<c:if test="${uprb.appoTime != null}">${uprb.appoTime}</c:if>
					<c:if test="${uprb.appoTime == null}">${uprb.phyTime}</c:if>
				</td>
			</tr>
			<tr>
				<td>体检套餐/体检项目：${uprb.setmealName}${uprb.itemName}</td>
			</tr>
		<c:forEach items="${proResList}" var="proRes" varStatus="vs">
			<tr>
				<td>
					项目名称：${proRes.itemName}
				</td>
			</tr>
			<tr>
				<td>
					项目小结：${proRes.projectResult}
				</td>
			</tr>
			<tr>
				<td>
					小结医生：${proRes.managerName}
				</td>
			</tr>
		</c:forEach>
			<tr>
				<td>体检总结及建议：${uprb.phyConad}</td>
			</tr>
			<tr>
				<td>生活保健指导：${uprb.guidance}</td>
			</tr>
	</table>
	<button onclick="history.go(-1)">返回</button>
</div>
</body>
</html>