<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>细项配置</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>css/x-admin.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/pag.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/AdminManagement.css" rel="stylesheet" type="text/css">
<link href="<%=path%>lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<%=path%>bgjs/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>js/AdminManagement.js"></script>
<script type="text/javascript">
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
		myForm.action="<%=path%>backstage/query.action?currentPage="+pageNo;
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
		<form class="form-inline" role="form" id="myForm" method="post">
			<%-- <div class="form-group">
				<label for="name" class="m">参数名称:</label> <input type="text"
					class="form-control input-sm  m5" id="name" name="name"
					placeholder="请输入名称" value="${name}">
			</div> --%>
			<div class="form-group">
				<label for=stateId1 class="m">参数类型:</label> <select
					class="selectpicker form-control input-sm m5" id="stateId1"
					name="stateId1" title="请选择一项" data-size="5">
					<option class="form-control" value="0">--请选择--</option>
				</select>
			</div>
			<input type="button" class="btn btn-primary" onclick="search(1)" value="查询"/>
		</form>
	</div>

	<div class="clearfix"></div>

	<div class="tools">
		<button class="btn btn-primary x-right" data-toggle="modal"
			data-target="#myModal" id="increased">新增</button>
            <span>共有数据：${total} 条</span>
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
			<font color="white">共${totalPage}页&nbsp;&nbsp;当前页数：${currentPage}&nbsp;&nbsp;</font>
			<button class="btn btn-info" onclick="search(${currentPage==1?0:1})">首页</button>&nbsp;&nbsp;
			<button class="btn btn-info" onclick="search(${(currentPage-1)>0?currentPage-1:0})">上一页</button>&nbsp;&nbsp;
			<button class="btn btn-info" onclick="search(${(currentPage+1)<=totalPage?currentPage+1:0})">下一页</button>&nbsp;&nbsp;
			<button class="btn btn-info" onclick="search(${currentPage==totalPage?0:totalPage})">末页</button>
	
			<%-- <c:choose>
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
			</c:choose> --%>
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
								<input name="uName" id="uName" type="text" class="form-control"
									placeholder="请输入用户名">
							</div>
						</div>


						<div class="form-group">
							<label for="pwd" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input name="pwd" id="pwd" type="password" class="form-control"
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
								<input name="firstname" id="firstname" type="text"
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
							<label for="image" class="col-sm-2 control-label">头像选择</label>
							<div class="col-sm-10">
								<input name="image" id="image" type="file">
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