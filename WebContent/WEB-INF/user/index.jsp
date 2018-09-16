<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<style type="text/css">
	body,a{
		color:white;
	}
	
</style>
<script type="text/javascript">
	function search(pageNo) {
		if(pageNo == 0) {
			return;
		}
		var myForm=document.getElementById("myForm");
		myForm.action="<%=basePath%>jsp/DownloadAction!query?currentPage="+pageNo;
		myForm.method="post";
		myForm.submit();
	}
</script>
</head>
<body background="<%=basePath%>img/bg.jpg">
<center>
	<c:choose>
		<c:when test="${user == null}">
			<a href="<%=basePath%>jsp/login.jsp"><input type = "button" value = "登陆"/></a>&nbsp;&nbsp;
			<a href="<%=basePath%>jsp/register.jsp"><input type = "button" value = "注册"/></a>
			<hr/>
		</c:when>
		<c:otherwise>
			欢迎您：${user.username}&nbsp;&nbsp;
			当前积分：${user.integral}&nbsp;&nbsp;
			<a href="<%=basePath%>jsp/userInfo.jsp">个人中心</a>&nbsp;&nbsp;
			<a href="<%=basePath%>jsp/uploadDoc.jsp">我要上传</a>&nbsp;&nbsp;
			<a href="<%=basePath%>jsp/">我要下载</a>
			<hr/>
		</c:otherwise>
	</c:choose>
	<form id="myForm">
		<input type="text" style="width:400px"/>
		<input type="button" onclick="search(1)" class="btn btn-info" value="搜索文档"/>
	</form>
	<c:if test="${user != null}">
		<table  class="table table-bordered">
			<tr>
				<th>编号</th><th>文档标题</th><th>上传人</th><th>上传时间</th><th>下载积分</th><th>文档类型</th>
			</tr>
			<c:forEach items="${docList}" var="doc" varStatus="status">
			<tr>
				<td>${(currentPage-1)*5+status.index+1}</td>
				<td><a href='<%=basePath%>jsp/Download?docId=${doc.db.docId}'>${doc.db.docTopic}</a></td>
				<td>${doc.username}</td>
				<td>${doc.uploadTime}</td>
				<td>${doc.db.docInte}</td>
				<td>${doc.db.docType}</td>
			</tr>
			</c:forEach>
		</table>
		<p align = "center">
			<font color="white">共${totalPage}页&nbsp;&nbsp;当前页数：${currentPage}&nbsp;&nbsp;</font>
			<button class="btn btn-info" onclick="search(${currentPage==1?0:1})">首页</button>&nbsp;&nbsp;
			<button class="btn btn-info" onclick="search(${(currentPage-1)>0?currentPage-1:0})">上一页</button>&nbsp;&nbsp;
			<button class="btn btn-info" onclick="search(${(currentPage+1)<=totalPage?currentPage+1:0})">下一页</button>&nbsp;&nbsp;
			<button class="btn btn-info" onclick="search(${currentPage==totalPage?0:totalPage})">末页</button>
		</p>
	</c:if>
</center>
</body>
</html>