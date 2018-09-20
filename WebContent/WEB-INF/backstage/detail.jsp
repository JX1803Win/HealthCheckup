<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>细项配置</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="css/x-admin.css" rel="stylesheet" type="text/css">
<link href="css/pag.css" rel="stylesheet" type="text/css">

<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/detail.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/jscript" src="js/detail.js"></script>
</head>
<body>
	<div class="container">
		<div class="x-nav">
			<span class="layui-breadcrumb"> <a href="main.jsp"><cite>首页</cite></a>
				<a><cite>细项配置</cite></a>
			</span>
		</div>
		<div class="page-header text-center">
			<h1>细项配置</h1>
		</div>
		<div class="text-center" id="div4">
			<form action="AdminServlet" class="form-inline" role="form"
				method="post">
				<div class="form-group">
					<label for="name" class="m">细项名称：</label> <input type="text"
						class="form-control input-sm  m5" id="name" name="name"
						placeholder="请输入名称" value="${name}">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">查询</button>
				</div>
			</form>
		</div>


		<div class="tools">
			<button class="btn btn-primary x-right" data-toggle="modal"
				data-target="#myModal" id="increased">新增</button>
			<div class="clearfix"></div>
		</div>
		<table class="table table-bordered">
			<caption>共有数据：${total} 条</caption>
			<thead>
				<tr>
					<th>序号</th>
					<th>细项名称</th>
					<th>计量单位</th>
					<th>默认值</th>
					<th>上限值</th>
					<th>下限值</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${parameters}" var="parameter" varStatus="vs">
					<tr>
						<td>${(page-1)*5+vs.index+1}</td>
						<td>${parameter.parameterName}</td>
						<td>${parameter.typeName}</td>
						<td></td>
						<td>${parameter.val}</td>
						<td></td>
						<td class="text-center"><a
							href="ParameterServlet?action=update&&parameterId=${parameter.parameterId}"><button
									type="button" class="btn btn-primary">修改</button></a>&nbsp;&nbsp; <a
							href="ParameterServlet?action=del&&parameterId=${parameter.parameterId}"
							onclick="return del()"><button type="button"
									class="btn btn-primary">删除</button></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="page">
			<div class="pagelist text-center">
				<c:choose>
					<c:when test="${page>1}">
						<span class="jump"><a
							href="AdminServlet?page=${page-1}&&name=${name}&&stateId1=${stateId1}&&professional=${professional}&&territory=${territory}">上一页</a></span>
					</c:when>
					<c:otherwise>
						<span class="jump">上一页</span>
					</c:otherwise>
				</c:choose>
				<span class="jump">${page}/${totalPage}</span>
				<c:choose>
					<c:when test="${page<totalPage}">
						<span class="jump"><a
							href="AdminServlet?page=${page+1}&&name=${name}&&stateId1=${stateId1}&&professional=${professional}&&territory=${territory}">下一页</a></span>
					</c:when>
					<c:otherwise>
						<span class="jump">下一页</span>
					</c:otherwise>
				</c:choose>
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
						<h4 class="modal-title" id="myModalLabel">新增细项</h4>
					</div>


					<form action="" id="addDetail" name="addDetail"
						class="form-horizontal" role="form" method="post">
						<div class="modal-body">


							<div class="form-group">
								<label for="detailName" class="col-sm-2 control-label">细项名称：</label>
								<div class="col-sm-10">
									<input name="detailName" id="detailName" type="text"
										class="form-control" placeholder="请输入细项名称">
								</div>
							</div>
							<div class="form-group">
								<label for="parameterId" class="col-sm-2 control-label">计量单位：</label>
								<div class="col-sm-10">
									<select class="selectpicker form-control" name="parameterId"
										id="parameterId" title="请选择一项" data-size="5">
										<option class="form-control" value="0">请选择一项</option>
										<c:forEach items="${roles}" var="roles">
											<option class="form-control" value="${roles.roleId}">${roles.roleName}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="upperLimit" class="col-sm-2 control-label">上限值：</label>
								<div class="col-sm-10">
									<input name="upperLimit" id="upperLimit" type="text"
										class="form-control" placeholder="请输入上限值">
								</div>
							</div>


							<div class="form-group">
								<label for="pwd1" class="col-sm-2 control-label">下限值：</label>
								<div class="col-sm-10">
									<input name="lowerLimit" id="lowerLimit" type="text"
										class="form-control" placeholder="请输入参确认密码">
								</div>
							</div>


							<div class="form-group">
								<label for="initValue" class="col-sm-2 control-label">默认值：</label>
								<div class="col-sm-10">
									<input name="initValue" id="initValue" type="text"
										class="form-control" placeholder="请输入默认值">
								</div>
							</div>



						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">提交</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
	</div>

	<script src="lib/layui/layui.js" charset="utf-8"></script>
	<script type="text/jscript" src="js/myPublic.js"></script>
</body>
</html>