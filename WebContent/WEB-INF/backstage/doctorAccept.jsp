<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>二级菜单管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>css/x-admin.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/pag.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/AdminManagement.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>bgjs/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>js/AdminManagement.js"></script>
<script type="text/javascript">
	var typeList;
	
	function turn() {
		var msg = "是否确定修改？";
		if(confirm(msg) == true) {
			return true;
		}
		return false;
	}
	function del() {
		var msg = "是否确定删除？";
		if(confirm(msg) == true) {
			return true;
		}
		return false;
	}
	function search(pageNo) {
		if(pageNo == 0) {
			return;
		}
		var myForm=document.getElementById("myForm");		
		myForm.action="<%=path%>doctor/projectInf.action?pageNo="+pageNo;
		myForm.method="post";
		myForm.submit();
	}




</script>
</head>
<body>
	<div class="container">
		<div class="x-nav">
			<span class="layui-breadcrumb"> <a href="main.jsp"><cite>医生工作</cite></a>
				<a><cite>查看体检人</cite></a>
			</span>
		</div>
		<div class="page-header text-center">
			<h1>查看体检人</h1>
		</div>
		<div class="text-center" id="div4">
			<form class="form-inline" role="form" id="myForm">
				<div class="form-group">
					<label for="name" class="m">菜单名称:</label> <input type="text"
						class="form-control input-sm  m5" id="physicaiId" name="physicaiId"
						placeholder="请输入名称" value="${physicaiId}">
				</div>

				<input type="button" class="btn btn-primary" onclick="search(1)" value="查询" />
			</form>
		</div>

		<div class="clearfix"></div>

		<div class="tools">		
			<br><span>共有数据：${sizeD} 条&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>共${AllPageD}页&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span>当前页数：${pageNoD}&nbsp;&nbsp;&nbsp;&nbsp;</span>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>序号</th>
					<th>用户名</th>
					<th>项目名</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${uprbList}" var="menu" varStatus="vs">
					<tr>
						<td>${(pageNoD-1)*5+vs.index+1}</td>
						<%-- <td>${menu.physicaiId}</td> --%>
						<td>${menu.userName}</td>
						<td>${menu.projectName}</td>				
					  <c:if test="${menu.parameterName=='可编辑'}">
						<td>可编辑</td>
						<td><a onclick="return sureable()"
							href="BlackAppointTableServlet?action=answer&physicaiId=
						${menu.physicaiId}"><button type="button" class="btn btn-primary">小结</button></a></td>
					</c:if>
					<c:if test="${menu.parameterName=='已提交'}">
						<td>已提交</td>
						<td><a 
							href="BlackAppointTableServlet?action=info&physicaiId=
						${menu.physicaiId}"><button type="button" class="btn btn-primary">查看详情</button></a></td>
					</c:if>
						



					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page">
			<div class="pagelist text-center">
				<button class="btn btn-primary" onclick="search('${pageNoD==1?0:1}')">首页</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary"
					onclick="search('${(pageNoD-1)>0?pageNoD-1:0}')">上一页</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary"
					onclick="search('${(pageNoD+1)<=AllPageD?pageNoD+1:0}')">下一页</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary"
					onclick="search('${pageNoD==AllPageD?0:AllPageD}')">末页</button>
			</div>
		</div>



	</div>
	<br />
	<br />
	<br />
	<script src="<%=path%>lib/layui/layui.js" charset="utf-8"></script>
	<script>
		layui.use([ 'laydate', 'element', 'laypage', 'layer' ], function() {
			$ = layui.jquery;//jquery
			lement = layui.element();//面包导航

		});
	</script>
</body>
</html>