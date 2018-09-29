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
<title>菜单管理</title>
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
		myForm.action="<%=path%>role/menuManager.action?pageNo="+pageNo;
		myForm.method="post";
		myForm.submit();
	}
	function add() {
		var menuName = $("#menuNames").val();
		if(menuName == "") {
			alert("菜单名称不能为空");
			return;
		}
		var myForm=document.getElementById("myForm2");
		myForm.action="<%=path%>role/addFMenu.action";
		myForm.method="post";
		myForm.submit();
	}
	function alter(upmenuId, upmenuName) {
		//alert(parameterId);
		$("#upmenuId").val(upmenuId);
		$("#upmenuName").val(upmenuName);
		
	}
	function adds() {
		var roleName = $("#upmenuName").val();
		if(roleName == "") {
			alert("修改菜单不能为空");
			return;
		}
		var myForm=document.getElementById("myForm3");
		myForm.action="<%=path%>role/updateFMenu.action";
		myForm.method="post";
		myForm.submit();
	}
</script>
</head>
<body>
	<div class="container">
		<div class="x-nav">
			<span class="layui-breadcrumb"> <a href="main.jsp"><cite>系统管理</cite></a>
				<a><cite>菜单管理</cite></a>
			</span>
		</div>
		<div class="page-header text-center">
			<h1>菜单管理</h1><span>一级菜单</span>
		</div>
		<div class="text-center" id="div4">
			<form class="form-inline" role="form" id="myForm">
				<div class="form-group">
					<label for="name" class="m">菜单名称:</label> <input type="text"
						class="form-control input-sm  m5" id="menuName" name="menuName"
						placeholder="请输入名称" value="${menuName}">
				</div>

				<input type="button" class="btn btn-primary" onclick="search(1)" value="查询" />
			</form>
		</div>

		<div class="clearfix"></div>

		<div class="tools">
			<button class="btn btn-primary x-right" data-toggle="modal"
				data-target="#myModal" id="increased">新增</button>
			<br><span>共有数据：${sizeF} 条&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>共${AllPageF}页&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span>当前页数：${pageNoF}&nbsp;&nbsp;&nbsp;&nbsp;</span>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>序号</th>
					<th>菜单名</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rbListF}" var="menu" varStatus="vs">
					<tr>
						<td>${(pageNoF-1)*5+vs.index+1}</td>
						<td>${menu.menuName}</td>
						<td class="text-center">
							<a href="<%=path%>role/sonMenu.action?permissionsId=${menu.permissionsId}"
							     ><button type="button" class="btn btn-primary">子级菜单</button></a>
								<button class="btn btn-primary " data-toggle="modal" data-target="#myModal2"
								onclick="alter('${menu.permissionsId}','${menu.menuName}')">修改</button>
							<a href="<%=path%>role/delMenu.action?permissionsId=${menu.permissionsId}"
							     onclick="return del()"><button type="button" class="btn btn-primary">删除</button></a>
						</td>



					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page">
			<div class="pagelist text-center">
				<button class="btn btn-primary" onclick="search(${pageNoF==1?0:1})">首页</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary"
					onclick="search(${(pageNoF-1)>0?pageNoF-1:0})">上一页</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary"
					onclick="search(${(pageNoF+1)<=AllPageF?pageNoF+1:0})">下一页</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary"
					onclick="search(${pageNoF==AllPageF?0:AllPageF})">末页</button>
			</div>
		</div>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title" id="myModalLabel">新增参数</h4>
					</div>

					<form id="myForm2" class="form-horizontal" role="form">
						<div class="modal-body">

							<div class="form-group">
								<label for="roleNames" class="col-sm-2 control-label">菜单名称</label>
								<div class="col-sm-10">
									<input name="menuNames" id="menuNames" type="text"
										class="form-control" placeholder="请输入菜单名称(必填)">
								</div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary" onclick="add()">提交</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<!-- 修改模态框（Modal） -->
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改参数</h4>
					</div>

					<form id="myForm3" class="form-horizontal" role="form">
						<div class="modal-body">

							<div class="form-group">
								<label for="roleNames" class="col-sm-2 control-label">角色名称</label>
								<input name="upmenuId" id="upmenuId" type="hidden"
									class="form-control">
								<div class="col-sm-10">
									<input name="upmenuName" id="upmenuName" type="text"
										class="form-control">
								</div>
							</div>


						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary" onclick="adds()">提交</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
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