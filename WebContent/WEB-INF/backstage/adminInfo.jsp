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
<script type="text/javascript" src="../js/myVerify.js"></script>
 
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
		<form name="selcet"action="<%=path%>ManageAction/showAdmin.action?page=${1}" class="form-inline" 
			role="form" method="post">
			<div class="form-group">
				<label for="name" class="m">姓名:</label> <input type="text"
					class="form-control input-sm  m4" id="mangerName" name="mangerName"onblur="isChinese(this.value)"
					placeholder="请输入名称" value="${mangerName}">
			</div>
			<div class="form-group">
				<label for="name" class="m">手机号：</label> <input type="text"
					class="form-control input-sm  m4" id="phoneNum" name="phoneNum1"onblur="yzsj(this.value)"
					placeholder="请输入卡号" value="${phoneNum1}">
			</div>
			<div class="form-group">
				<label for=stateId class="m2">状态:</label> <select
					class="selectpicker form-control input-sm m4" id="paramterId1"
					name="paramterId1" title="请选择一项" data-size="5">
					<option class="form-control" value=""
						>请选择一项</option>
					<option class="form-control" value="1"
						${paramterId1==1?"selected='selected'":''}>启用</option>
					<option class="form-control" value="2"
						${paramterId1==2?"selected='selected'":''}>禁用</option>
				</select>
			</div>
			<div class="form-group">
				<label for="start" class="m"></label> 职务：<select
					class="selectpicker form-control input-sm m4" id="roleId1"
					name="roleId1" title="请选择一项" data-size="5">
					<option class="form-control" value=""
						>请选择一项</option>
						<c:forEach items="${listRole}" var="role" varStatus="vs">
					<option class="form-control" value="${role.roleId}">${role.roleName}</option>
					</c:forEach>
				</select>科室：<select
					class="selectpicker form-control input-sm m4" id="officeId1"
					name="officeId1" title="请选择一项" data-size="5">
					
					<option class="form-control" value=""
						>请选择一项</option>
						<c:forEach items="${listOffice}" var="office" varStatus="vs">
					<option class="form-control" value="${office.officeId}">${office.officeName}</option>
					</c:forEach>
				</select>
					
			</div>
			<button type="submit" class="btn btn-primary">查询</button>
		</form>
	</div>

	<div class="clearfix"></div>

	<%-- <div class="tools">
		<span class="x-right" style="line-height: 25px">共有数据：${1}条</span>
	</div> --%>
	
	<!-- <li onclick="user_management_add('添加用户','user_management_add.html','600','500')"> -->
	<ul class="toolbar">
	<img src="<%=path%>images/t01.png" />
	<a href="<%=path%>ManageAction/adminAdd.action">添加用户</a>
	
	<!-- </li> -->
	</ul> 
	<!-- <div class="tools">
		<button class="btn btn-primary x-right" data-toggle="modal"
			data-target="#myModal" id="increased">新增</button>
	</div> -->
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
							href="<%=path%>ManageAction/updateAdminState.action?page=${page}&&adminId=${admin.adminId}&&paramterId=2"
							title="禁用" onclick="return myforbidden()"> <i
								class="layui-icon">&#xe601;</i>
						</a> <a style="text-decoration: none"
							href="<%=path%>ManageAction/updateAdminPwd.action?page=${page}&&adminId=${admin.adminId}&&pwd=${000000}"
							title="重置密码" onclick="return myreset()"> <i class="layui-icon">&#xe631;</i>
						</a> <a title="删除"
							href="<%=path%>ManageAction/updateAdminState.action?page=${page}&&adminId=${admin.adminId}&&paramterId=0"
							onclick="return mydelete()" style="text-decoration: none"> <i
								class="layui-icon">&#xe640;</i>
						</a></td>
					</c:if>
					<c:if test="${admin.paramterId==2}">
						<td class="td-manage"><a style="text-decoration: none"
							href="<%=path%>ManageAction/updateAdminState.action?page=${page}&&adminId=${admin.adminId}&&paramterId=1"
							title="启用" onclick="return mystar()"><i class="layui-icon">&#xe62f;</i></a>
							<a style="text-decoration: none"
							href="<%=path%>ManageAction/updateAdminPwd.action?page=${page}&&adminId=${admin.adminId}&&pwd=${000000}"
							title="重置密码" onclick="return myreset()"> <i class="layui-icon">&#xe631;</i>
						</a> <a title="删除"
							href="<%=path%>ManageAction/updateAdminState.action?page=${page}&&adminId=${admin.adminId}&&paramterId=0"
							onclick="return mydelete()" style="text-decoration: none"> <i
								class="layui-icon">&#xe640;</i>
						</a></td>
					</c:if>

				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="page">
		<div class="pagelist text-center">
		<span class="jump"><a
					href="<%=path%>ManageAction/showAdmin.action?page=${page-1}&&mangerName=${mangerName}&&phoneNum1=${phoneNum1}&&paramterId1=${paramterId1}&&roleName1=${roleName}&&officeName1=${officeName}">首页</a></span>
			<c:choose>
				<c:when test="${page>1}">
					<span class="jump"><a
					href="<%=path%>ManageAction/showAdmin.action?page=${page-1}&&mangerName=${mangerName}&&phoneNum1=${phoneNum1}&&paramterId1=${paramterId1}&&roleName1=${roleName}&&officeName1=${officeName}">上一页</a></span>
				</c:when>
				<c:otherwise>
					<span class="jump">上一页</span>
				</c:otherwise>
			</c:choose>
			<span class="jump">${page}/${pageAll}</span>
			<c:choose>
				<c:when test="${page<pageAll}">
					<span class="jump"><a
						href="<%=path%>ManageAction/showAdmin.action?page=${page+1}&&mangerName=${mangerName}&&phoneNum1=${phoneNum1}&&paramterId1=${paramterId1}&&roleName1=${roleName}&&officeName1=${officeName}">下一页</a></span>
				</c:when>
				<c:otherwise>
					<span class="jump">下一页</span>
				</c:otherwise>
			</c:choose>
			<span class="jump"><a
					href="<%=path%>ManageAction/showAdmin.action?page=${pageAll}&&mangerName=${mangerName}&&phoneNum1=${phoneNum1}&&paramterId1=${paramterId1}&&roleName1=${roleName}&&officeName1=${officeName}">末页</a></span>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增后台用户</h4>
				</div>


				<form action="AdminServlet?action=add" id="addAdmin" name="addAdmin"
					class="form-horizontal" role="form" method="post">
					<div class="modal-body">


						<div class="form-group">
							<label for="uName" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input name="adminId" id="adminId" type="text" class="form-control"
									placeholder="请输入用户名">
							</div>
						</div>


						<div class="form-group">
							<label for="pwd" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input name="password" id="password" type="password" class="form-control"
									placeholder="请输入参密码">
							</div>
						</div>


						<div class="form-group">
							<label for="pwd1" class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10">
								<input name="pwd1" id="pwd1" type="password"
									class="form-control" placeholder="请输入参确认密码">
							</div>
						</div>


						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">真实姓名</label>
							<div class="col-sm-10">
								<input name="mangerName" id="mangerName" type="text"
									class="form-control" placeholder="请输入真实姓名">
							</div>
						</div>


						<div class="form-group">
							<label for="sex" class="col-sm-2 control-label">性别</label>
							<div class="radio">
								<label class="radio-inline"> <input type="radio"
									name="sex" id="optionsRadios1" value="男" checked> 男
								</label> <label class="radio-inline"> <input type="radio"
									name="sex" id="optionsRadios2" value="女"> 女
								</label>
							</div>
						</div>

				
                         <div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">年龄</label>
							<div class="col-sm-10">
								<input name="age" id="age" type="text"
									class="form-control" placeholder="请输入真年龄">
							</div>
						</div>
						
						<div class="form-group">
							<label for="firstname" class="col-sm-2 control-label">年龄</label>
							<div class="col-sm-10">
								<input name="age" id="age" type="text"
									class="form-control" placeholder="请输入真年龄">
							</div>
						</div>

						<div class="form-group">
							<label for="role" class="col-sm-2 control-label">角色</label>
							<div class="col-sm-10">
								<select class="selectpicker form-control" name="role" id="role"
									title="请选择一项" data-size="5">
									<c:forEach items="${roles}" var="roles">
										<option class="form-control" value="${roles.roleId}"
											${roles.roleId==21?"selected='selected'":''}>${roles.roleName}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="school" class="col-sm-2 control-label">毕业院校</label>
							<div class="col-sm-10">
								<input id="school" name="school" type="text"
									class="form-control" placeholder="请输入职称">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">擅长领域</label>
							<div class="col-sm-10 radio">
								<c:forEach items="${territorys}" var="t">
									<label class="checkbox-inline"> <input type="checkbox"
										name="territory" value="${t.territoryId}">
										${t.territoryName}
									</label>
								</c:forEach>

							</div>
						</div>


						<div class="form-group">
							<label for="consultingfee" class="col-sm-2 control-label">咨询费用</label>
							<div class="col-sm-10">
								<input id="consultingfee" name="consultingfee" type="text"
									class="form-control" placeholder="请输入咨询费用">
							</div>
						</div>


						<div class="form-group">
							<label for="bookingfee" class="col-sm-2 control-label">预约费用</label>
							<div class="col-sm-10">
								<input id="bookingfee" name="bookingfee" type="text"
									class="form-control" placeholder="请输入预约费用">
							</div>
						</div>

						<div class="form-group">
							<label for="professional1" class="col-sm-2 control-label">职称</label>
							<div class="col-sm-10">
								<input id="professional1" name="professional1" type="text"
									class="form-control" placeholder="请输入职称">
							</div>
						</div>

						<div class="form-group">
							<label for="specialty" class="col-sm-2 control-label">专业背景</label>
							<div class="col-sm-10">
								<textarea id="specialty" name="specialty" class="form-control"
									rows="3" placeholder="请输入简介"></textarea>
							</div>
						</div>

						<div class="form-group">
							<label for="intro" class="col-sm-2 control-label">简介</label>
							<div class="col-sm-10">
								<textarea id="intro" name="intro" class="form-control" rows="3"
									placeholder="请输入简介"></textarea>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>