<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编写体检总结</title>
<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
<link href="<%=path%>lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check() {
		var result = "";
		var phyConad = $("#phyConad").val();
		var guidance = $("#guidance").val();
		if(phyConad.length <= 0) {
			result += "体检总结及建议不能为空\n"
		}
		if(guidance.length <= 0) {
			result += "生活保健指导不能为空\n"
		}
		if(result != "") {
			alert(result);
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
<div class="container">
	<div class="page-header text-center">
		<h1>编写体检总结</h1>
	</div>
	<table class="table table-bordered">
			<tr>
				<td>体检人：${uprb.userName}</td>
			</tr>
			<tr>	
				<td>体检号：${uprb.physicaiId}</td>
			</tr>
			<tr>
				<td>体检时间：
					<c:if test="${uprb.appoTime != null}">${uprb.appoTime}</c:if>
					<c:if test="${uprb.appoTime == null}">${uprb.phyTime}</c:if>
				</td>
			</tr>
			<tr>
				<td>体检套餐/体检项目：${uprb.setmealName}${uprb.itemName}</td>
			</tr>
		<c:forEach items="${proResList}" var="proRes" varStatus="vs">
			<tr>
				<td>
					项目名称：${proRes.itemName}
				</td>
			</tr>
			<tr>
				<td>
					项目小结：${proRes.projectResult}
				</td>
			</tr>
			<tr>
				<td>
					小结医生：${proRes.managerName}
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="text-center">
		<form action="<%=path%>/PhySumAction/submit.action" method="post" onsubmit="return check()">
			<div class="form-group">
				<label for="name" class="m">体检总结及建议:</label> 
				<textarea class="form-control" rows="5" id="phyConad" name="phyConad">
				</textarea>
			</div>
			<div class="form-group">
				<label for="name" class="m">生活保健指导:</label> 
				<textarea class="form-control" rows="5" id="guidance" name="guidance">
				</textarea>
			</div>
			<input type="button" class="btn btn-primary" 
				onclick="location.href='<%=path%>/PhySumAction/query.action'" value="返回"/>&nbsp;&nbsp;
			<input type="submit" class="btn btn-primary"/>
		</form>
	</div>
</div>
</body>
</html>