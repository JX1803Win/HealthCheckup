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
			<a><cite>体检卡管理</cite></a>
		</span>
	</div>
	<div class="page-header text-center">
		<h1>体检卡管理</h1>
	</div>
		<div class="text-center" id="div4">
		<form name="selcet"action="<%=path%>ManageAction/showPhyCardInfo.action?page=1" class="form-inline" 
			role="form" method="post">
			
			
			<div class="form-group">
				<label for="name" class="m">体检卡号：</label> <input type="text"
					class="form-control input-sm  m4" id="phyCardId1" name="phyCardId1"onblur="checkCardNumber(this.value)"
					placeholder="请输入卡号" value="${phyCardId1}">
			</div>
			<div class="form-group">
				<label for=stateId class="m2">状态:</label> <select
					class="selectpicker form-control input-sm m4" id="parameterId1"
					name="parameterId1" title="请选择一项" data-size="5">
					<option class="form-control" value=""
						>请选择一项</option>
					<option class="form-control" value="17"
						${parameterId1==17?"selected='selected'":''}>未激活</option>
					<option class="form-control" value="18"
						${parameterId1==18?"selected='selected'":''}>挂失</option>
						<option class="form-control" value="19"
						${parameterId1==19?"selected='selected'":''}>已激活(未用)</option>
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
	<%-- <img src="<%=path%>images/t01.png" /> --%>
	<%-- <a href="<%=path%>ManageAction/adminAdd.action">添加卡片</a> --%>
	
	<!-- </li> -->
     <div class="tools">
		<button class="btn btn-primary x-right" data-toggle="modal"
			data-target="#myModal" id="increased">新增</button>
	</div> 
	</ul> 
	<table class="tablelist">
		<thead>
			<tr>
				<th>体检卡号</th>
				<th>体检卡状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="phyCard" varStatus="vs">
				<tr>
					<td>${phyCard.phyCardId}</td>
					<td>${phyCard.parameterBean.parameterName}</td>
					<c:if test="${phyCard.parameterId==17}">
						
						<td class="td-manage"><a style="text-decoration: none"
							href="<%=path%>ManageAction/updatePhyCardState.action?page=${page}&&phyCardId=${phyCard.phyCardId}&&parameterId=19"
							title="激活 " onclick="return myforbidden()"> <i
								class="layui-icon">&#xe601;</i>
						</a>  <a title="删除"
							href="<%=path%>ManageAction/updatePhyCardState.action?page=${page}&&phyCardId=${phyCard.phyCardId}&&parameterId=0"
							onclick="return mydelete()" style="text-decoration: none"> <i
								class="layui-icon">&#xe640;</i>
						</a></td>
					</c:if>
					<c:if test="${phyCard.parameterId==18}">
						<td class="td-manage"><a style="text-decoration: none"
							href="<%=path%>ManageAction/updatePhyCardState.action?page=${page}&&phyCardId=${phyCard.phyCardId}&&parameterId=17"
							title="初始化" onclick="return mystar()"><i class="layui-icon">&#xe62f;</i></a>
							<a title="删除"
							href="<%=path%>ManageAction/updatePhyCardState.action?page=${page}&&phyCardId=${phyCard.phyCardId}&&parameterId=0"
							onclick="return mydelete()" style="text-decoration: none"> <i
								class="layui-icon">&#xe640;</i>
						</a></td>
					</c:if>
					<c:if test="${phyCard.parameterId==19}">
						<td class="td-manage"><a style="text-decoration: none"
							href="<%=path%>ManageAction/updatePhyCardState.action?page=${page}&&phyCardId=${phyCard.phyCardId}&&parameterId=18"
							title="禁用" onclick="return mystar()"><i class="layui-icon">&#xe62f;</i></a>
							 <a title="删除"
							href="<%=path%>ManageAction/updatePhyCardState.action?page=${page}&&phyCardId=${phyCard.phyCardId}&&parameterId=0"
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
					href="<%=path%>ManageAction/showPhyCardInfo.action?page=1&&phyCardId=${phyCardId}&&paramterId=${paramterId}">首页</a></span>
			<c:choose>
				<c:when test="${page>1}">
					<span class="jump"><a
					href="<%=path%>ManageAction/showPhyCardInfo.action?page=${page-1}&&phyCardId=${phyCardId}&&paramterId=${paramterId}">上一页</a></span>
				</c:when>
				<c:otherwise>
					<span class="jump">上一页</span>
				</c:otherwise>
			</c:choose>
			<span class="jump">${page}/${pageAll}</span>
			<c:choose>
				<c:when test="${page<pageAll}">
					<span class="jump"><a
						href="<%=path%>ManageAction/showPhyCardInfo.action?page=${page+1}&&phyCardId=${phyCardId}&&paramterId=${paramterId}">下一页</a></span>
				</c:when>
				<c:otherwise>
					<span class="jump">下一页</span>
				</c:otherwise>
			</c:choose>
			<span class="jump"><a
					href="<%=path%>ManageAction/showPhyCardInfo.action?page=${pageAll}&&phyCardId=${phyCardId}&&paramterId=${paramterId}">末页</a></span>
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">选择体检卡号</h4>
				</div>


				<form action="<%=path%>ManageAction/upFile.action" id="addAdmin" name="addAdmin" enctype="multipart/form-data"
					class="form-horizontal" role="form" method="post">

					<div class="modal-body">
						<div class="form-group">
							<label for="role" class="col-sm-2 control-label">请选择文件</label>
							<div class="col-sm-10">
									请选择文件:<input type="file" name="fileact">
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