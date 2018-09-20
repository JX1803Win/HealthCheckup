<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户管理</title>
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
<link href="../css/public.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../lib/laydate/laydate.js"></script>
<script type="text/javascript" src="../lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../lib/layui/layui.js"></script>
<script type="text/javascript" src="../js/myPublic.js"></script>
<script src="<%=path %>laydate/laydate.js"></script>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="../main.jsp"><cite>首页</cite></a>
			<a><cite>用户管理</cite></a>
		</span>
	</div>
	<div class="page-header text-center">
		<h1>用户管理</h1>
	</div>
	<div class="text-center" id="div4">
		<form action="<%=path%>ManageAction/showUser.action?page=${1}" class="form-inline"
			role="form" method="post">
			<div class="form-group">
				<label for="name" class="m">姓名:</label> <input type="text"
					class="form-control input-sm  m4" id="name" name="userName"
					placeholder="请输入名称" value="${userName}">
			</div>
			<div class="form-group">
				<label for="name" class="m">体检卡号：</label> <input type="text"
					class="form-control input-sm  m4" id="phyCardId1" name="phyCardId1"
					placeholder="请输入卡号" value="${phyCardId1}">
			</div>
			<div class="form-group">
				<label for=stateId class="m2">状态:</label> <select
					class="selectpicker form-control input-sm m4" id="parameterID1"
					name="parameterID1" title="请选择一项" data-size="5">
					<!-- <option class="form-control" value="0">请选择一项</option> -->
					<option class="form-control" value=""
						>请选择一项</option>
					<option class="form-control" value="1"
						${parameterID1==1?"selected='selected'":''}>启用</option>
					<option class="form-control" value="2"
						${parameterID1==2?"selected='selected'":''}>禁用</option>
				</select>
			</div>
			<div class="form-group">
				<label for="start" class="m">注册时间:</label> 注册日期：<input type="text"class="inline laydate-icon" name="regTimeA" id="start"value="${regTimeA}"
						style="width: 150px" />至<input type="text"class="inline laydate-icon" name="regTimeB" id="end"value="${regTimeB}"
						style="width: 150px" />
					
			</div>
			<button type="submit" class="btn btn-primary">查询</button>
		</form>
	</div>

	<div class="clearfix"></div>

	<%-- <div class="tools">
		<span class="x-right" style="line-height: 25px">共有数据：${1}条</span>
	</div> --%>
	<table class="tablelist">
		<thead>
			<tr>
				<th>用户账号</th>
				<th>用户名</th>
				<th>年龄</th>
				<th>联系电话</th>
				<th>住址</th>
				<th>体检卡ID</th>
				<th>注册时间</th>
				<th>用户状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="user" varStatus="vs">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.age}</td>
					<td>${user.phone}</td>
					<td>${user.useradd}</td>
					<td>${user.phyCardId}</td>
					<td>${user.regTime}</td>
					<td>${user.parameterBean.parameterName}</td>
					<c:if test="${user.parameterID==1}">
						<td class="td-manage"><a style="text-decoration: none"
							href="<%=path%>ManageAction/updateUserState.action?page=${1}&&userId=${user.userId}&&parameterID=2"
							title="禁用" onclick="return forbidden()"> <i
								class="layui-icon">&#xe601;</i>
						</a> <a style="text-decoration: none"
							href="<%=path%>ManageAction/updateUserPwd.action?page=${1}&&userId=${user.userId}&&pwd=${000000}"
							title="重置密码" onclick="return reset()"> <i class="layui-icon">&#xe631;</i>
						</a> <a title="删除"
							href="<%=path%>ManageAction/updateUserState.action?page=${1}&&userId=${user.userId}&&parameterID=0"
							onclick="return del()" style="text-decoration: none"> <i
								class="layui-icon">&#xe640;</i>
						</a></td>
					</c:if>
					<c:if test="${user.parameterID==2}">
						<td class="td-manage"><a style="text-decoration: none"
							href="<%=path%>ManageAction/updateUserState.action?page=${1}&&userId=${user.userId}&&parameterID=1"
							title="启用" onclick="return start()"><i class="layui-icon">&#xe62f;</i></a>
							<a style="text-decoration: none"
							href="<%=path%>ManageAction/updateUserPwd.action?page=${1}&&userId=${user.userId}&&pwd=${000000}"
							title="重置密码" onclick="return reset()"> <i class="layui-icon">&#xe631;</i>
						</a> <a title="删除"
							href="<%=path%>ManageAction/updateUserState.action?page=${1}&&userId=${user.userId}&&parameterID=0"
							onclick="return del()" style="text-decoration: none"> <i
								class="layui-icon">&#xe640;</i>
						</a></td>
					</c:if>

				</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="page">
		<div class="pagelist text-center">
			
					<span class="jump"><a
						href="<%=path%>ManageAction/showUser.action?page=${page-1}&&userName=${userName}&&phyCardId1=${phyCardId1}&&parameterID1=${parameterID1}&&regTimeA=${regTimeA}&&regTimeB=${regTimeB}">上一页</a></span>
			<span class="jump">${page}/${pageAll}</span>
			
					<span class="jump"><a
						href="<%=path%>ManageAction/showUser.action?page=${page+1}&&userName=${userName}&&phyCardId1=${phyCardId1}&&parameterID1=${parameterID1}&&regTimeA=${regTimeA}&&regTimeB=${regTimeB}">下一页</a></span>
				
					
				
			
		</div>
	</div>
<script>
!function(){
laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
laydate({elem: '#demo'});//绑定元素
}();
//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD hh:mm:ss',
   // min: laydate.now(), //设定最小日期为当前日期
    max: laydate.now(), //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#end',
    format: 'YYYY-MM-DD hh:mm:ss',
    min: '1980-06-16',
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，充值开始日的最大日期
    }
};
laydate(start);
laydate(end);
//自定义日期格式
laydate({
    elem: '#test1',
    format: 'YYYY年MM月DD日 hh:mm:ss',
    festival: true, //显示节日
    choose: function(datas){ //选择日期完毕的回调
        alert('得到：'+datas);
    }
});
//日期范围限定在昨天到明天
laydate({
    elem: '#hello3',
    min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
    max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
});
</script>
</body>
</html>