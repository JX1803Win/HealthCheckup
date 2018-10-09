<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="java.util.*" import="java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=path%>">
    <title>体检总结</title>
    <script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
    <link href="<%=path%>lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
	    function search(pageNo) {
			if(pageNo == 0) {
				return;
			}
			var myForm=document.getElementById("myForm");
			myForm.action="<%=path%>PhySumAction/query.action?currentPage="+pageNo;
			myForm.method="post";
			myForm.submit();
		}
	    function cancel() {
	    	var msg = "是否确定取消此预约?";
			if(confirm(msg) == true) {
				return true;
			}
			return false;
	    }
	    $(function() {
			var msg = "${requestScope.get('cancel')}";
			console.log(msg);
			if(msg.length > 0) {
				alert(msg);
			}
		})
	    $(function() {
			var condition = "${requestScope.get('physicaiId')}";
			var msg = "${requestScope.get('uprbList')}";
			if(msg == "[]" && condition.length > 0) {
				alert("未查询到结果！");
			}
		})
    </script>
</head>
<body>
<div class="container">
	 <div class="page-header text-center">
		<h1>体检总结</h1>
	</div>
	
	<div class="text-center" id="div4">
		<form class="form-inline" role="form" id="myForm">
			<div class="form-group">
				<label for="name" class="m">体检号:</label> <input type="text"
					class="form-control input-sm  m5" id="physicaiId" name="physicaiId" value="${physicaiId}">
			</div>
			<input type="button" class="btn btn-primary" onclick="search(1)" value="查询"/>
		</form>
	</div>

	<br>
	<div class="clearfix"></div>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>序号</th>
				<th>体检号</th>
				<th>体检人</th>
				<th>体检时间</th>
				<th>体检套餐</th>
				<th>体检项目</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${uprbList}" var="uprb" varStatus="vs">
				<tr style="height:50px;">
					<td>${(currentPage-1)*5+vs.index+1}</td>
					<td>${uprb.physicaiId}</td>
					<td>${uprb.userName}</td>
					<td>
						<c:if test="${uprb.appoTime != null}">${uprb.appoTime}</c:if>
						<c:if test="${uprb.appoTime == null}">${uprb.phyTime}</c:if>
					</td>
					<td>${uprb.setmealName}</td>
					<td>${uprb.itemName}</td>
					<td>
						<c:if test="${uprb.sumTime != null}">已总结</c:if>
						<c:if test="${uprb.sumTime == null}">未总结</c:if>
					</td>
					<td class="text-center">
						<c:if test="${uprb.sumTime != null}">
							<a href="<%=path%>PhySumAction/look.action?physicaiId=${uprb.physicaiId}">
								<button class="btn btn-primary">查看</button>
							</a>
						</c:if>
						<c:if test="${uprb.sumTime == null}">
							<a href="<%=path%>PhySumAction/write.action?physicaiId=${uprb.physicaiId}">
								<button class="btn btn-primary">写总结</button>
							</a>
						</c:if>
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
</div>
</body>
</html>