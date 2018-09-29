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
		<span class="layui-breadcrumb" > <a href="../main.jsp"><cite>首页</cite></a>
			<a><cite>收费工作</cite></a>
		</span>
	</div>
		<div class="text-center" id="div4">
		<form name="selcet"action="<%=path%>ManageAction/selectProject.action" class="form-inline" 
			role="form" method="post">
			<div class="form-group">
				<label for="name" class="m">体检号：</label> <input type="text"
					class="form-control input-sm  m4" id="physicaiId" name="physicaiId"
					placeholder="请输入卡号" value="">
			</div>
			<button type="submit" class="btn btn-primary" onclick="return checkPhysicaiId()">查询</button>
		</form>
	</div>
	<div class="clearfix"></div>

	<%-- <div class="tools">
		<span class="x-right" style="line-height: 25px">共有数据：${1}条</span>
	</div> --%>
	
	<!-- <li onclick="user_management_add('添加用户','user_management_add.html','600','500')"> -->
	<!-- <ul class="toolbar"> -->
	<%-- <img src="<%=path%>images/t01.png" /> --%>
	<%-- <a href="<%=path%>ManageAction/adminAdd.action">添加卡片</a> --%>
	
	<!-- </li> -->
    <!--  <div class="tools">
		<button class="btn btn-primary x-right" data-toggle="modal"
			data-target="#myModal" id="increased">新增</button>
	</div>  -->
	<c:forEach items="${lisUserPhy}" var="user" varStatus="vs">
		<input type="hidden" id="parameterId" name="parameterId" value="${user.parameterId}"/>
	<c:if test="${user.parameterId==22}">
	<button type="button" id="settleAccount" class="btn btn-primary">结算</button>
	</c:if>
	<c:if test="${user.userInfoBean.userId!=null}">
	<table class="tablelist">
		<thead>
			<tr>
				<th></th>
				<th>用户信息</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${lisUserPhy}" var="user" varStatus="vs">
			<input type="hidden" id="physicaiId1" name="physicaiId1" value="${user.physicaiId}"/>
			<input type="hidden" id="userId" name="userId" value="${user.userInfoBean.userId}"/>
		<tr>
		<td>账户:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.userInfoBean.userId}</td>
		<td>名字:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.userInfoBean.userName}</td>
		<td>年龄:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.userInfoBean.age}</td>
		<td>性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.userInfoBean.sex}</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
	 <c:forEach items="${lisUserPhy}" var="user" varStatus="vs">
			<c:if test="${user.projectId==null}">
			<c:forEach items="${list}" var="project" varStatus="vs">
			<table class="tablelist">
			<thead>
			<tr>
				<th>体检套餐：</th>
				<th>${project.setmealName}</th>
			</tr>
		</thead>
		</table>
		</c:forEach>
			</c:if>
			</c:forEach>
	<table class="tablelist">
		<thead>
			<tr>
				<th>项目号</th>
				<th>项目</th>
				<th>费用</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${lisUserPhy}" var="user" varStatus="vs">
	
			<c:if test="${user.projectId==null}">
						<c:forEach items="${list}" var="setmeal" varStatus="vs">
					<c:forEach items="${setmeal.items}" var="project" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${project.itemName}</td>
					<td>${project.charge}</td>
				</tr>
					</c:forEach>
				</c:forEach>
				 <tr>
					<td></td>
					<td align="right">合计：</td>
					<td>${charge}</td>
				    </tr>
				    <input type="hidden" id="charge" name="charge" value="${charge}"/>
					</c:if>
					
			</c:forEach>
			
			<c:forEach items="${lisUserPhy}" var="user" varStatus="vs">
	
			<c:if test="${user.setmealId==null}">
						<c:forEach items="${list}" var="project" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${project.itemName}</td>
					<td>${project.charge}</td>
				</tr>
					 <tr>
					<td></td>
					<td align="right">合计：</td>
					<td>${project.charge}</td>
				    </tr>
				    <input type="hidden" id="charge" name="charge" value="${project.charge}"/>
				</c:forEach>
					</c:if>
					
			</c:forEach>
                    
		</tbody>
	</table>
	</c:if>
	
	</c:forEach>
	
</body>
<script type="text/javascript" >
$(function() {
	$("#settleAccount").click(
			function() {
				$.ajax({
					url : "<%=path%>ManageAction/settleAccount.action",//请求地址
					data : "charge="
						+ $("#charge").val()+"&"+"userId="
						+ $("#userId").val()+"&"+"physicaiId="
						+ $("#physicaiId1").val(),//发送至服务器的键值数据
					dataType : "json",//请求数据格式，如script,json,text等
					type : "post",//发送方式，get/post
					success : function(redata) {////定义各事件发生时回调的函数
                    $.each(redata, function(i, item) {
							alert(item.cityName)
							if(item.cityId==21){
								$("#settleAccount").attr("disabled",true);
							}
						});
					}
				});
			});
});
</script>
</html>