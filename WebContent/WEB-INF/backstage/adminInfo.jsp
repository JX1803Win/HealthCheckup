<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link href="../css/x-admin.css" rel="stylesheet" type="text/css" />
<link href="../css/pag.css" rel="stylesheet" type="text/css" />
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
	<link rel="stylesheet" href="<%=path %>css/jHsDate.css" />
<link href="../css/public.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../lib/laydate/laydate.js"></script>
<script type="text/javascript" src="../lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../lib/layui/layui.js"></script>
<script type="text/javascript" src="../js/myPublic.js"></script>
<script src="<%=path %>laydate/laydate.js"></script>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="../main.jsp"><cite>首页</cite></a>
			<a><cite>用户管理</cite></a>
		</span>
	</div>
	<div class="page-header text-center">
		<h1>用户管理</h1>
	</div>
		<div class="text-center" id="div4">
		<form action="<%=path%>ManageAction/showUser.action?page=${1}" class="form-inline"
			role="form" method="post">
			<div class="form-group">
				<label for="name" class="m">姓名:</label> <input type="text"
					class="form-control input-sm  m4" id="mangerName" name="mangerName"
					placeholder="请输入名称" value="${mangerName}">
			</div>
			<div class="form-group">
				<label for="name" class="m">手机号：</label> <input type="text"
					class="form-control input-sm  m4" id="phoneNum" name="phoneNum1"
					placeholder="请输入卡号" value="${phoneNum1}">
			</div>
			<div class="form-group">
				<label for=stateId class="m2">状态:</label> <select
					class="selectpicker form-control input-sm m4" id="parameterID1"
					name="parameterID1" title="请选择一项" data-size="5">
					<option class="form-control" value=""
						>请选择一项</option>
					<option class="form-control" value="1"
						${parameterID1==1?"selected='selected'":''}>启用</option>
					<option class="form-control" value="2"
						${parameterID1==2?"selected='selected'":''}>禁用</option>
				</select>
			</div>
			<div class="form-group">
				<label for="start" class="m"></label> 岗位：<input type="text"class="form-control input-sm  m4" name="roleName1" id="start"value="${admin.ruleBean.roleName}"
						style="width: 150px" />科室：<input type="text"class="form-control input-sm  m4" name="officeName1" id="end"value="${admin.officeBean.officeName}"
						style="width: 150px" />
					
			</div>
			<button type="submit" class="btn btn-primary">查询</button>
		</form>
	</div>

	<div class="clearfix"></div>

	<%-- <div class="tools">
		<span class="x-right" style="line-height: 25px">共有数据：${1}条</span>
	</div> --%>
	<table class="tablelist">
		<thead>
			<tr>
				<th>管理员账号</th>
				<th>用户名</th>
				<th>年龄</th>
				<th>联系电话</th>
				<th>住址</th>
				<th>职务</th>
				<th>科室</th>
				<th>用户状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="admin" varStatus="vs">
				<tr>
					<td>${admin.adminId}</td>
					<td>${admin.mangerName}</td>
					<td>${admin.age}</td>
					<td>${admin.phoneNum}</td>
					<td>${admin.address}</td>
					<td>${admin.roleBean.roleName}</td>
					<td>${admin.officeBean.officeName}</td>
					<td>${admin.parameterBean.parameterName}</td>
					<c:if test="${admin.paramterId==1}">
						
						<td class="td-manage"><a style="text-decoration: none"
							href="backstage/user!update.action?adminId=${admin.adminId}&&stateId=2"
							title="禁用" onclick="return forbidden()"> <i
								class="layui-icon">&#xe601;</i>
						</a> <a style="text-decoration: none"
							href="backstage/user!select.action?Pwd&&adminId=${admin.adminId}"
							title="重置密码" onclick="return reset()"> <i class="layui-icon">&#xe631;</i>
						</a> <a title="删除"
							href="backstage/user!select.action?adminId=${admin.adminId}&&stateId=0"
							onclick="return del()" style="text-decoration: none"> <i
								class="layui-icon">&#xe640;</i>
						</a></td>
					</c:if>
					<c:if test="${admin.paramterId==2}">
						<td class="td-manage"><a style="text-decoration: none"
							href="backstage/user!update.action?action=update&&adminId=${admin.adminId}&&stateId=1"
							title="启用" onclick="return start()"><i class="layui-icon">&#xe62f;</i></a>
							<a style="text-decoration: none"
							href="backstage/user!select.action?action=updatePwd&&adminId=${admin.adminId}"
							title="重置密码" onclick="return reset()"> <i class="layui-icon">&#xe631;</i>
						</a> <a title="删除"
							href="backstage/user!select.action?action=update&&adminId=${admin.adminId}&&stateId=0"
							onclick="return del()" style="text-decoration: none"> <i
								class="layui-icon">&#xe640;</i>
						</a></td>
					</c:if>

				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="page">
		<div class="pagelist text-center">
			<c:choose>
				<c:when test="${page>1}">
					<span class="jump"><a
						href="backstage/user!select.action?page=${page-1}&&name=${name}&&stateId1=${stateId1}&&start=${start}&&end=${end}">上一页</a></span>
				</c:when>
				<c:otherwise>
					<span class="jump">上一页</span>
				</c:otherwise>
			</c:choose>
			<span class="jump">${page}/${totalPage}</span>
			<c:choose>
				<c:when test="${page<totalPage}">
					<span class="jump"><a
						href="backstage/user!select.action?page=${page+1}&&name=${name}&&stateId1=${stateId1}&&start=${start}&&end=${end}">下一页</a></span>
				</c:when>
				<c:otherwise>
					<span class="jump">下一页</span>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>