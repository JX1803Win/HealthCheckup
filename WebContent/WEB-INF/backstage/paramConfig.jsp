<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>参数配置</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>css/x-admin.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/pag.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/AdminManagement.css" rel="stylesheet" type="text/css">
<link href="<%=path%>lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>bgjs/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>js/AdminManagement.js"></script>
<script type="text/javascript">
	var typeList;
	$(function() {
		$.getJSON("<%=path%>ParamAction/queryAllTypeName.action", 
		function(data) {
			console.log(data);
			typeList = data;
			//var data = JSON.parse(datas);
			for (var i = 0; i < data.length; i++) {
				console.log(data[i].parameterId);
				$("#typeName2").append("<option value="+ data[i].parameterId +">"+data[i].parameterName+"</option>");
				$("#typeName").append("<option>"+data[i].parameterName+"</option>");
			}
		});
	})
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
		myForm.action="<%=path%>ParamAction/query.action?currentPage="+pageNo;
		myForm.method="post";
		myForm.submit();
	}
	function add() {
		var parameterName = $("#parameterName").val();
		if(parameterName == "") {
			alert("参数名称不能为空");
			return;
		}
		var myForm=document.getElementById("myForm2");
		myForm.action="<%=path%>ParamAction/add.action";
		myForm.method="post";
		myForm.submit();
	}
	function alter(parameterId, typeName, paramterName, parameterValues) {
		//alert(parameterId);
		$("#parameterId1").val(parameterId);
		$("#typeName1").val(typeName);
		$("#parameterName1").val(paramterName);
		$("#parameterValues1").val(parameterValues);
	}
	function submitAlter() {
		console.log($("#parameterId1").val());
		var parameterName = $("#parameterName1").val();
		if(parameterName == "") {
			alert("参数名称不能为空");
			return;
		}
		var myForm=document.getElementById("myForm1");
		myForm.action="<%=path%>ParamAction/alter.action";
		myForm.method="post";
		myForm.submit();
	}
</script>
</head>
<body>
<div class="container">
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="main.jsp"><cite>首页</cite></a> <a><cite>细项配置</cite></a>
		</span>
	</div>
    <div class="page-header text-center">
		<h1>参数配置</h1>
	</div>
	<div class="text-center" id="div4">
		<form class="form-inline" role="form" id="myForm">
			<%-- <div class="form-group">
				<label for="name" class="m">参数名称:</label> <input type="text"
					class="form-control input-sm  m5" id="name" name="name"
					placeholder="请输入名称" value="${name}">
			</div> --%>
			<div class="form-group">
				<label for=stateId1 class="m">参数类型:</label> 
				<select class="selectpicker form-control input-sm m5" id="typeName" name="typeName">
					<option class="form-control" value="">请选择</option>
				</select>
			</div>
			<input type="button" class="btn btn-primary" onclick="search(1)" value="查询"/>
		</form>
	</div>

	<div class="clearfix"></div>

	<div class="tools">
		<button class="btn btn-primary x-right" data-toggle="modal" data-target="#add">新增</button>
        <span>共有数据：${total} 条&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span>共${totalPage}页&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span>当前页数：${currentPage}&nbsp;&nbsp;&nbsp;&nbsp;</span>
	</div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>序号</th>
				<th>参数类型</th>
				<th>参数名称</th>
				<th>参数值</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${paramList}" var="parameter" varStatus="vs">
				<tr>
					<td>${(currentPage-1)*5+vs.index+1}</td>
					<td>${parameter.typeName}</td>
					<td>${parameter.parameterName}</td>
					<td>${parameter.parameterValues}</td>
					<td class="text-center">
						<button class="btn btn-primary" data-toggle="modal" data-target="#alter" 
							onclick="alter('${parameter.parameterId}','${parameter.typeName}','${parameter.parameterName}','${parameter.parameterValues}')">修改</button>
						<a href="<%=path%>ParamAction/del.action?parameterId=${parameter.parameterId}" onclick="return del()">
							<button type="button" class="btn btn-primary">删除</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="page">
		<div class="pagelist text-center">
			<button class="btn btn-primary" onclick="search(${currentPage==1?0:1})">首页</button>&nbsp;&nbsp;
			<button class="btn btn-primary" onclick="search(${(currentPage-1)>0?currentPage-1:0})">上一页</button>&nbsp;&nbsp;
			<button class="btn btn-primary" onclick="search(${(currentPage+1)<=totalPage?currentPage+1:0})">下一页</button>&nbsp;&nbsp;
			<button class="btn btn-primary" onclick="search(${currentPage==totalPage?0:totalPage})">末页</button>
		</div>
	</div>
	<!-- 新增参数--模态框（Modal） -->
	<div class="modal fade" id="add" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增参数</h4>
				</div>

				<form id="myForm2" class="form-horizontal" role="form">
					<div class="modal-body">

						<div class="form-group">
							<label for="typeName" class="col-sm-2 control-label">参数类型</label>
							<div class="col-sm-10">
								<select class="selectpicker form-control" name="typeName2" id="typeName2">
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="parameterName" class="col-sm-2 control-label">参数名称</label>
							<div class="col-sm-10">
								<input name="parameterName" id="parameterName" type="text" 
									class="form-control" placeholder="请输入参数名称(必填)">
							</div>
						</div>

						<div class="form-group">
							<label for="parameterValues" class="col-sm-2 control-label">参数值</label>
							<div class="col-sm-10">
								<input name="parameterValues" id=parameterValues type="text"
									class="form-control" placeholder="请输入参数值(选填)">
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="add()">提交</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- 修改参数--模态框（Modal） -->
	<div class="modal fade" id="alter" tabindex="-2" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改参数</h4>
				</div>

				<form id="myForm1" class="form-horizontal" role="form">
					<div class="modal-body">

						<div class="form-group">
							<label for="typeName1" class="col-sm-2 control-label">参数类型</label>
							<div class="col-sm-10">
								<input name="parameterId1" id="parameterId1" type="hidden" 
									class="form-control">
								<input name="typeName1" id="typeName1" type="text" 
									class="form-control" disabled="disabled">
							</div>
						</div>

						<div class="form-group">
							<label for="parameterName1" class="col-sm-2 control-label">参数名称</label>
							<div class="col-sm-10">
								<input name="parameterName1" id="parameterName1" type="text" 
									class="form-control">
							</div>
						</div>

						<div class="form-group">
							<label for="parameterValues1" class="col-sm-2 control-label">参数值</label>
							<div class="col-sm-10">
								<input name="parameterValues1" id="parameterValues1" type="text"
									class="form-control">
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="submitAlter()">提交</button>
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