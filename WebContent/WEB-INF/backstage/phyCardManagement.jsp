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
<link rel="stylesheet" href="<%=path%>css/jHsDate.css" />

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../lib/laydate/laydate.js"></script>
<script type="text/javascript"
	src="../lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../lib/layui/layui.js"></script>
<script type="text/javascript" src="../js/myPublic.js"></script>
<script src="<%=path%>laydate/laydate.js"></script>
<script type="text/javascript" src="../js/myVerify.js"></script>
<%--  <script type="text/javascript" src="<%=path%>/js/myAjax.js"></script> --%>
<script type="text/javascript">
  $(function() {
$("#increased").click(
			function() {
				
				$.ajax({
					url : "<%=path %>ManageAction/selectPhyCard.action",//请求地址
					data : "page="
						+ $("#increased").val(),//发送至服务器的键值数据
					dataType :"json",//请求数据格式，如script,json,text等
					type : "post",//发送方式，get/post
					success : function(redata) {////定义各事件发生时回调的函数
						$("#phyCardId").find("option").remove();
						$("#phyCardId")
						.append(
								'<option value="0">请选择一项</option>');
						$.each(redata, function(i, item) {
							
							$("#phyCardId")
									.append(
											"<option value="+item.phyCardId+">"
													+ item.phyCardId
													+ "</option>");
						});
					}
				});
			});
}); 
 $(function() {
$("#increased").click(function() {
	var str=$("#increased").val();
	$("#userId").val(str);
	 alert(str); 
}); 
}); 
 $(function() {
	 $("#change").click(
	 			function() {
	 				
	 				$.ajax({
	 					url : "<%=path %>ManageAction/selectPhyCard.action",//请求地址
	 					data : "page="
	 						+ $("#increased").val(),//发送至服务器的键值数据
	 					dataType :"json",//请求数据格式，如script,json,text等
	 					type : "post",//发送方式，get/post
	 					success : function(redata) {////定义各事件发生时回调的函数
	 						$("#phyCard").find("option").remove();
	 						$("#phyCard")
	 						.append(
	 								'<option value="0">请选择一项</option>');
	 						$.each(redata, function(i, item) {
	 							
	 							$("#phyCard")
	 									.append(
	 											"<option value="+item.phyCardId+">"
	 													+ item.phyCardId
	 													+ "</option>");
	 						});
	 					}
	 				});
	 			});
	 }); 
	  $(function() {
	 $("#change").click(function() {
	 	var str=$("#change").val();
	 	$("#user").val(str);
	 	 alert(str); 
	 }); 
	 }); 
</script>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="../main.jsp"><cite>首页</cite></a>
			<a><cite>用户体检卡管理</cite></a>
		</span>
	</div>
	<div class="page-header text-center">
		<h1>用户体检卡管理</h1>
	</div>
	<div class="text-center" id="div4">
		<form name="selcet"
			action="<%=path%>ManageAction/phyCardManagement.action?page=1"
			class="form-inline" role="form" method="post">


			<div class="form-group">
				<label for="name" class="m">用户账号：</label> <input type="text"
					class="form-control input-sm  m4" id="userId1" name="userId1"onblur="checkNumber(this.value)"
					placeholder="请输入卡号" value="">
			</div>
			<div class="form-group">
				<label for="name" class="m">用户姓名：</label> <input type="text"
					class="form-control input-sm  m4" id="userName" name="userName"onblur="isChinese(this.value)"
					placeholder="请输入卡号" value="${userName}">
			</div>
           <div class="form-group">
				<label for="name" class="m">体检卡号：</label> <input type="text"
					class="form-control input-sm  m4" id="phyCardId1" name="phyCardId1"onblur="checkCardNumber(this.value)"
					placeholder="请输入卡号" value="">
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
		<%-- <a href="<%=path%>ManageAction/adminAdd.action">添加卡片</a> --%>

		<!-- </li> -->
	</ul>
	<!-- <div class="tools">
		<button class="btn btn-primary x-right" data-toggle="modal"
			data-target="#myModal" id="increased">新增</button>
	</div> -->
	<table class="tablelist">
		<thead>
			<tr>
				<th>用户账号</th>
				<th>姓名</th>
				<th>用户状态</th>
				<th>体检卡号</th>
				<th>体检卡状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="phyCard" varStatus="vs">
				<tr>
					<td>${phyCard.userId}</td>
					<td>${phyCard.userName}</td>
					<td>${phyCard.parameterBean1.paramName1}</td>
					<td>${phyCard.phyCardId}</td>
					<td>${phyCard.parameterBean2.paramName2}</td>
					<c:if test="${phyCard.parameterBean2.paramId2==16}">

						<td class="td-manage"> <a title="挂失"
							href="<%=path%>ManageAction/reportTheLossOf.action?page=${page}&&parameterId=18&&phyCardId=${phyCard.phyCardId}"
							onclick="return mydelete()" style="text-decoration: none"> <i
								class="layui-icon">&#xe640;</i>
						</a></td>
					</c:if>
					<c:if test="${phyCard.phyCardId==null}">
						<%-- <td class="td-manage"><a style="text-decoration: none"
							href="<%=path%>ManageAction/phyCardManagement.action?page=${page}&&userId=${phyCard.userId}&&parameterId=17"
							title="初始化" onclick="return mystar()"><i class="layui-icon">&#xe62f;</i></a>
							</td> --%>
						<td class="td-manage">
							<div class="tools">
								<button class="btn btn-primary x-right" data-toggle="modal"
									data-target="#myModal" id="increased" name="increased" value="${phyCard.userId}">办卡</button>
							</div>
						</td>
					</c:if>
					<c:if test="${phyCard.parameterBean2.paramId2==18}">
						<%-- <td class="td-manage"><a style="text-decoration: none"
							href="<%=path%>ManageAction/phyCardManagement.action?page=${page}&&userId=${phyCard.userId}&&parameterId=17"
							title="初始化" onclick="return mystar()"><i class="layui-icon">&#xe62f;</i></a>
							</td> --%>
						<td class="td-manage">
							<div class="tools">
								<button class="btn btn-primary x-right" data-toggle="modal"
									data-target="#myModal2" id="change" name="change" value="${phyCard.userId}">换卡</button>
							</div>
						</td>
					</c:if>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="page">
		<div class="pagelist text-center">
			<span class="jump"><a
				href="<%=path%>ManageAction/phyCardManagement.action?page=1&&userName=${userName}">首页</a></span>
			<c:choose>
				<c:when test="${page>1}">
					<span class="jump"><a
						href="<%=path%>ManageAction/phyCardManagement.action?page=${page-1}&&userName=${userName}">上一页</a></span>
				</c:when>
				<c:otherwise>
					<span class="jump">上一页</span>
				</c:otherwise>
			</c:choose>
			<span class="jump">${page}/${pageAll}</span>
			<c:choose>
				<c:when test="${page<pageAll}">
					<span class="jump"><a
						href="<%=path%>ManageAction/phyCardManagement.action?page=${page+1}&&userName=${userName}">下一页</a></span>
				</c:when>
				<c:otherwise>
					<span class="jump">下一页</span>
				</c:otherwise>
			</c:choose>
			<span class="jump"><a
				href="<%=path%>ManageAction/phyCardManagement.action?page=${pageAll}&&userName=${userName} ">末页</a></span>
		</div>
	</div>
	<!-- 模态框（Modal）1 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">选择体检卡号</h4>
				</div>


				<form action="<%=path%>ManageAction/changeCard.action" id="addAdmin" name="addAdmin"
					class="form-horizontal" role="form" method="post">
					<input type="hidden" id="userId" name="userId" value=""/>
						<input type="hidden" id="page" name="page" value="${page}"/>
						<input type="hidden" id="parameterId" name="parameterId" value="16"/>
					<div class="modal-body">
						<div class="form-group">
							<label for="role" class="col-sm-2 control-label">选择体检卡号</label>
							<div class="col-sm-10">
								<select class="selectpicker form-control" name="phyCardId" id="phyCardId"
									title="请选择一项" data-size="5">
									<option class="form-control" value=""
						>请选择一项</option>
								</select>
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
	<!-- 模态框（Modal）2 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">选择体检卡号</h4>
				</div>


				<form action="<%=path%>ManageAction/changeCard.action" id="addAdmin" name="addAdmin"
					class="form-horizontal" role="form" method="post">
					<input type="hidden" id="user" name="userId" value=""/>
						<input type="hidden" id="page" name="page" value="${page}"/>
						<input type="hidden" id="parameterId" name="parameterId" value="16"/>
					<div class="modal-body">
						<div class="form-group">
							<label for="role" class="col-sm-2 control-label">选择体检卡号</label>
							<div class="col-sm-10">
								<select class="selectpicker form-control" name="phyCardId" id="phyCard"
									title="请选择一项" data-size="5">
									<option class="form-control" value=""
						>请选择一项</option>
								</select>
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