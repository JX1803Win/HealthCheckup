<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	import="java.util.*" import="java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<fmt:formatDate var="nowDate" value="<%=new Date()%>" pattern="yyyy-MM-dd "/>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=path%>">
    <title>我的预约</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <link href="<%=path%>lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
	    function search(pageNo) {
			if(pageNo == 0) {
				return;
			}
			location.href="<%=path%>PhyAction/queryAppo.action?currentPage="+pageNo;
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
    </script>
</head>
<body background="images/YuYue/yuyuebg.jpg">
<div class="container">
	 <div class="page-header text-center">
		<h1>我的预约</h1>
	</div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>序号</th>
				<th>体检号</th>
				<th>预约时间</th>
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
					<td>${uprb.appoTime}</td>
					<td>${uprb.setmealName}</td>
					<td>${uprb.itemName}</td>
					<td>${uprb.parameterName}</td>
					<td class="text-center">
						<c:if test="${uprb.appoTime > nowDate && uprb.parameterId == 10}">
							<a href="<%=path%>PhyAction/cancel.action?physicaiId=${uprb.physicaiId}" 
								onclick="return cancel()"><button class="btn btn-primary">取消预约</button></a>
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