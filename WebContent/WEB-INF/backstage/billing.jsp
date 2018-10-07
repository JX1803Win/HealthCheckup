<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>体检开单</title>
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
	function show1() {
		$("#combo_div").show();
		$("#project_div").hide();
		$("#btn").show();
	}
	function show2() {
		$("#project_div").show();
		$("#combo_div").hide();
		$("#btn").show();
	}
	function check() {
		var result = "";
		var physicaiId = $("#physicaiId").val();
		var combo = $("#combo").val();
		var project = $("#project").val();
		if(physicaiId == "") {
			result += "体检卡号不能为空\n";
		}
		if(combo == "" && project == "") {
			result += "体检套餐/项目不能为空";
		}
		if(result == "") {
			return true;
		} else {
			alert(result);
			return false;
		}
	}
	$(function() {
		$.getJSON("<%=path%>PhyAction/queryAllSetmeal.action", 
		function(data) {
			console.log(data);
			typeList = data;
			//var data = JSON.parse(datas);
			for (var i = 0; i < data.length; i++) {
				console.log(data[i].parameterId);
				$("#combo").append("<option value="+ data[i].setmealId +">"+data[i].setmealName+"</option>");
			}
		});
	})
	$(function() {
		$.getJSON("<%=path%>PhyAction/queryAllProject.action", 
		function(data) {
			console.log(data);
			typeList = data;
			//var data = JSON.parse(datas);
			for (var i = 0; i < data.length; i++) {
				console.log(data[i].parameterId);
				$("#project").append("<option value="+ data[i].projectId +">"+data[i].itemName+"</option>");
			}
		});
	})
	$(function() {
		var msg = "${requestScope.get('physicaiId')}";
		console.log(msg);
		if(msg.length > 0) {
			alert("开单成功，您的体检号为:"+msg);
		}
	})
</script>
</head>
<body>
<div class="container">
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="main.jsp"><cite>首页</cite></a> <a><cite>体检开单</cite></a>
		</span>
	</div>
    <div class="page-header text-center">
		<h1>体检开单</h1>
	</div>
	<div class="text-center" id="div4">
		<form action="<%=path%>PhyAction/billing.action" method="post" class="form-horizontal" onsubmit="return check()">
			<div class="modal-body">
				<div class="form-group">
					<div class="col-sm-3"></div>
					<label for="physicaiId" class="col-sm-2 control-label">体检卡号：</label>
					<div class="col-sm-3">
						<input name="physicaiId" id="physicaiId" type="text"
							class="form-control" placeholder="请输入体检卡号">
					</div>
				</div>
				<br>
				<div class="form-group">
					<div class="col-sm-12">
						<input type="button" class="btn btn-primary" onclick="show1()" value="选择体检套餐" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" class="btn btn-primary" onclick="show2()" value="选择体检项目" />
					</div>
				</div>
				<br>
				<div class="form-group"  id="combo_div">
					<div class="col-sm-3"></div>
					<label for="combo" class="col-sm-2 control-label">体检套餐：</label>
					<div class="col-sm-3">
						<select class="selectpicker form-control input-sm m5" id="combo" name="combo">
							<option value="">请选择</option>
							<!-- <option value="1">入职体检套餐</option> -->
						</select>
					</div>
				</div>
				<div class="form-group"  id="project_div" style="display:none">
					<div class="col-sm-3"></div>
					<label for="project" class="col-sm-2 control-label">体检项目：</label>
					<div class="col-sm-3">
						<select class="selectpicker form-control input-sm m5" id="project" name="project">
							<option value="">请选择</option>
							<!-- <option value="1">身高体重</option> -->
						</select>
					</div>
				</div>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary"/>
			</div>
		</form>
	</div>
	<div class="clearfix"></div>
</div>
</body>
</html>