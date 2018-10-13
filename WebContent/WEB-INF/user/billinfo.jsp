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
    <title>我的账户</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <link href="<%=path%>lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
	    function nextPage(page) {
	    	page++;
			location.href="<%=path%>user/gobillinfo.action?page="+page;
		}
	    function previousPage(page) {
	    	page--;
			if(page<=0){
				page=1;
			}
			location.href="<%=path%>user/gobillinfo.action?page="+page;
		}
    </script>
</head>
<body background="images/YuYue/yuyuebg.jpg">
<div class="container">
	 <div class="page-header text-center">
		<h1>我的账户</h1>
	</div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>发生时间</th>
				<th>发生事项</th>
				<th>金额</th>
				<th>余额</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accoutlist}" var="acc" varStatus="vs">
				<tr style="height:50px;">
					<td>${acc.getOccurTime()}</td>
					<td>${acc.getOccurMatter()}</td>
					<td>${acc.getMoney()}</td>
					<td>${acc.getBalance()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="page">
		<div class="pagelist text-center">
			<button class="btn btn-primary" onclick="nextPage(9999)">首页</button>&nbsp;&nbsp;
			<button class="btn btn-primary" onclick="previousPage(${sessionScope.page})">上一页</button>&nbsp;&nbsp;
			<button class="btn btn-primary" onclick="nextPage(${sessionScope.page})">下一页</button>&nbsp;&nbsp;
			<button class="btn btn-primary" onclick="nextPage(10000)">末页</button>
		</div>
	</div>
</div>
</body>
</html>