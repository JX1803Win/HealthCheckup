<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>账户管理</title>
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
			<a><cite>账户管理</cite></a>
		</span>
	</div>
		<div class="text-center" id="div4">
		<form name="selcet"action="<%=path%>ManageAction/selectAccount.action" class="form-inline" 
			role="form" method="post">
			<div class="form-group">
				<label for="name" class="m">用户账号：</label> <input type="text"
					class="form-control input-sm  m4" id="userId" name="userId"
					placeholder="请输入账号" value="">
			</div>
			<input type="hidden" id="page" name="page" value="1"/>
			<button type="submit" class="btn btn-primary" onclick="return checkUserId()">查询</button>
		</form>
	</div>
	<div class="clearfix"></div>


	<c:if test="${userId!=null}"> 
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
		<tr>
		<td>账户:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${userId}</td>
		<td>名字:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${userName}</td>
		<td>年龄:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${userAge}</td>
		<td>性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${userSex}</td>
		</tr>
		
		</tbody>
		</table>
	 <div class="tools">
			<button class="btn btn-primary x-right" data-toggle="modal"
				data-target="#myModal" id="increased">充值</button>
				<button class="btn btn-primary x-right" data-toggle="modal"
				data-target="#myModal1" id="increased1">退款</button>
			<div class="clearfix"></div>
		</div>
	<table class="tablelist">
		<thead>
			<tr>
			     <th>余额：</th>
				<th>${balance}</th>
				<th></th>
				<th></th>
				
			</tr>
		</thead>
		<thead>
			<tr>
			     <th>序号</th>
				<th>时间</th>
				<th>事项</th>
				<th>费用</th>
				
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="user" varStatus="vs">
		<tr>
		<td>${vs.count }</td>
		<td>${user.occurTime}</td>
		<td>${user.occurMatter}</td>
		<td>${user.money}</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
		<div class="page">
		<div class="pagelist text-center">
		<span class="jump"><a
					href="<%=path%>ManageAction/selectAccount.action?page=1&&userId=${userId}">首页</a></span>
			<c:choose>
				<c:when test="${page>1}">
					<span class="jump"><a
					href="<%=path%>ManageAction/selectAccount.action?page=${page-1}&&userId=${userId}">上一页</a></span>
				</c:when>
				<c:otherwise>
					<span class="jump">上一页</span>
				</c:otherwise>
			</c:choose>
			<span class="jump">${page}/${pageAll}</span>
			<c:choose>
				<c:when test="${page<pageAll}">
					<span class="jump"><a
						href="<%=path%>ManageAction/selectAccount.action?page=${page+1}&&userId=${userId}">下一页</a></span>
				</c:when>
				<c:otherwise>
					<span class="jump">下一页</span>
				</c:otherwise>
			</c:choose>
			<span class="jump"><a
					href="<%=path%>ManageAction/selectAccount.action?page=${pageAll}&&userId=${userId}">末页</a></span>
		</div>
	</div>
	</c:if> 
		
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">充值中心</h4>
				</div>


				<form action="<%=path%>ManageAction/topUp.action"  enctype="multipart/form-data"
					class="form-horizontal" role="form" method="post">
                     <input type="hidden" id="userId" name="userId" value="${userId}"/>
					<div class="form-group">
							<label for="pwd" class="col-sm-2 control-label">金额</label>
							<div class="col-sm-10">
								<input name="money" id="money" type="text" class="form-control" 
									placeholder="请输入金额">
							</div>
						</div>
						<div class="modal-footer">
						<button type="button" class="btn btn-primary"id="button1" value="100">100</button>
						<button type="button" class="btn btn-primary"id="button2" value="200">200</button>
						<button type="button" class="btn btn-primary"id="button3" value="300">300</button>
						<button type="button" class="btn btn-primary"id="button4" value="500">500</button>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" id="colse">关闭</button>
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">退款</h4>
				</div>
				<form action="" enctype="multipart/form-data"
					class="form-horizontal" role="form" method="post">
                     <input type="hidden" id="userId1" name="userId1" value="${userId}"/>
					<div class="form-group">
							<label for="pwd" class="col-sm-2 control-label">金额</label>
							<div class="col-sm-10">
								<input name="money1" id="money1" type="text" class="form-control"value="${balance}"
									placeholder="请输入金额">
							</div>
						</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="refund">提交</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	
</body>
			<script type="text/javascript">
$(document).ready(function(){

	$("#button1").click(function(){
		var str = $("#button1").val();
		 $("#money").val(str);
});
	$("#button2").click(function(){
		var str = $("#button2").val();
		 $("#money").val(str);
});
	$("#button3").click(function(){
		var str = $("#button3").val();
		 $("#money").val(str);
});
	$("#button4").click(function(){
		var str = $("#button4").val();
		 $("#money").val(str);
});
});
$(function() {
	$("#refund").click(
			function() {
				$.ajax({
					url : "<%=path%>ManageAction/refund.action",//请求地址
					data : "money="
						+ $("#money1").val()+"&"+"userId="
						+ $("#userId1").val(),//发送至服务器的键值数据
					dataType : "json",//请求数据格式，如script,json,text等
					type : "post",//发送方式，get/post
					success : function(redata) {////定义各事件发生时回调的函数
                    $.each(redata, function(i, item) {
							alert(item.userName);
							location.href="<%=path%>ManageAction/selectAccount.action?money="
								+ $("#money1").val()+"&userId="
								+ $("#userId1").val()+"&page=1";
							
						});
					}
				});
			});
});
$(function() {
	$("#colse").click(
			function(){
				$.ajax({
					url : "<%=path%>ManageAction/selectAccount.action",//请求地址
					data : "userId="
						+ $("#userId1").val(),//发送至服务器的键值数据
					dataType : "json",//请求数据格式，如script,json,text等
					type : "post",//发送方式，get/post
					success : function(redata) {//定义各事件发生时回调的函数
                   
					}
				});
			});
});
</script>
</html>