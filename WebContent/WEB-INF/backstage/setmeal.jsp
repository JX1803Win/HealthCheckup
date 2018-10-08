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
<title>菜单配置</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="css/pag.css" rel="stylesheet" type="text/css">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/project.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/setmeal.js"></script>
</head>
<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>菜单配置</h1>
		</div>
		<div class="text-center" id="div4">
			<form action="backstage/querySetmeal.action" class="form-inline"
				role="form" method="post">
				<div class="form-group">
					<label for="name" class="m">菜单名称：</label> <input type="text"
						class="form-control input-sm  m5" id="name" name="name"
						placeholder="请输入名称" value="${name}">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">查询</button>
				</div>
			</form>
		</div>



		<div class="tools">
			<a
				href="backstage/addSetmeal.action?currentPage=${resultMap['currentPage']}&&name=${name}"><button
					class="btn btn-primary" id="increased">新增</button></a>
			<div class="clearfix"></div>
		</div>
		<table class="table table-bordered">
			<caption>共有数据：${resultMap['total']} 条</caption>
			<thead>
				<tr>
					<th width="70">序号</th>
					<th width="120">菜单名称</th>
					<th>项目名称</th>
					<th width="250">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultMap['setmeals']}" var="setmeal"
					varStatus="vs">
					<tr>
						<td>${(resultMap['currentPage']-1)*5+vs.index+1}</td>
						<td>${setmeal.setmealName}</td>
						<td><c:forEach items="${setmeal.items}" var="item">
						${item.itemName}、
						</c:forEach></td>
						<td class="text-center"><a
							href="backstage/checkSetmeal.action?setmealId=${setmeal.setmealId}&&currentPage=${resultMap['currentPage']}&&name=${name}"><button
									type="button" class="btn btn-primary">查看详情</button> </a>&nbsp;&nbsp;
							<a
							href="backstage/updateSetmeal.action?setmealId=${setmeal.setmealId}&&currentPage=${resultMap['currentPage']}&&name=${name}"><button
									type="button" class="btn btn-primary">修改</button></a>&nbsp;&nbsp; <a
							href="backstage/delSetmeal.action?setmealId=${setmeal.setmealId}&&currentPage=${resultMap['currentPage']}&&name=${name}"
							onclick="return del()"><button type="button"
									class="btn btn-primary">删除</button></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="page">
			<div class="pagelist text-center">
				<c:choose>
					<c:when test="${resultMap['currentPage']>1}">
						<span class="jump"><a
							href="backstage/querySetmeal.action?name=${name}">首页</a></span>
						<span class="jump"><a
							href="backstage/querySetmeal.action?currentPage=${resultMap['currentPage']-1}&&name=${name}">上一页</a></span>
					</c:when>
					<c:otherwise>
						<span class="jump">首页</span>
						<span class="jump">上一页</span>
					</c:otherwise>
				</c:choose>
				<span class="jump">${resultMap['currentPage']}/${resultMap['totalPage']}</span>
				<c:choose>
					<c:when test="${resultMap['currentPage']<resultMap['totalPage']}">
						<span class="jump"><a
							href="backstage/querySetmeal.action?currentPage=${resultMap['currentPage']+1}&&name=${name}">下一页</a></span>
						<span class="jump"><a
							href="backstage/querySetmeal.action?currentPage=${resultMap['totalPage']}&&name=${name}">末页</a></span>
					</c:when>
					<c:otherwise>
						<span class="jump">下一页</span>
						<span class="jump">末页</span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

	</div>
</body>
</html>