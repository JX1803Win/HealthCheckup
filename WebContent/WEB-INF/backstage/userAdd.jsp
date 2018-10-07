<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>用户体检信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="<%=basePath %>/css/x-admin.css" media="all">
<link href="../css/pag.css" rel="stylesheet" type="text/css" />
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="<%=basePath %>css/jHsDate.css" />
<script type="text/javascript" src="<%=basePath %>bgjs/jquery.min.js">
</script>
<script type="text/javascript" src="../lib/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath %>laydate/laydate.js"></script>
<script type="text/javascript" src="../js/myVerify.js"></script>
<!-- <script type="text/javascript">
layui.use('form', function(){
	  var form = layui.form; 
	  form.render();
	 });
</script> -->
</head>
<body>
<div class="text-center" id="div4">
		<form name="regAdmin"action="<%=basePath %>ManageAction/regUser.action" class="form-inline" 
			role="form" method="post">
			<br>
			<div class="form-group">
				<label for="name" class="m">账号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text"
					class="form-control input-sm  m4" id="userId" name="userId"onblur="checkNumber(this.value)"
					placeholder="请输入名称" /><spen id="tiShi"></spen>
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="name" class="m">姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text"
					class="form-control input-sm  m4" id="userName" name="userName"onblur="isChineseName(this.value)"
					placeholder="请输入姓名:" >
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="name" class="m">密码:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="password"
					class="form-control input-sm  m4" id="pwd" name="pwd"onblur="checkPwd(this.value)"
					placeholder="请输入密码" >
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="name" class="m">确认密码:</label> <input type="password"onblur="checkPwd(this.value)"
					class="form-control input-sm  m4" id="pwd1" name="pwd1"
					placeholder="请输入确认密码" >
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="name" class="m">手机号：&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text"
					class="form-control input-sm  m4" id="phone" name="phone"onblur="yzsj(this.value)"
					placeholder="请输入手机" >
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="name" class="m">性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <label class="radio-inline"> <input type="radio"
									name="sex" id="sex" value="男" checked> 男
								</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label class="radio-inline"> <input type="radio"
									name="sex" id="sex" value="女"> 女
								</label>
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for=stateId class="m2">血型:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <select
					class="selectpicker form-control input-sm m4" id="bloodType"
					name="bloodType" title="请选择一项" data-size="5">
					<option class="form-control" value=""
						>请选择一项</option>
					<option class="form-control" value="A">A</option>
					<option class="form-control" value="B">B</option>
					<option class="form-control" value="O">O</option>
					<option class="form-control" value="AB">AB</option>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="name" class="m">年龄：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text"
					class="form-control input-sm  m4" id="age" name="age"onblur="checkage(this.value)"
					placeholder="请输入手机" >
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="name" class="m">出生日期：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text"
					class="form-control input-sm  m4" name="birth" id="start"
					placeholder="请选择出生日期" >
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for=stateId class="m2">省份:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <select
					class="selectpicker form-control input-sm m4" id="provinceId"
					name="provinceId" title="请选择一项" data-size="5">
					<option class="form-control" value=""
						>请选择一项</option>
					 <c:forEach items="${listProvince}" var="province" varStatus="vs">
					<option class="form-control" value="${province.provinceId}">${province.provinceName}</option>
					</c:forEach>
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for=stateId class="m2">城市：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <select
					class="selectpicker form-control input-sm m4" id="cityId"
					name="cityId" title="请选择一项" data-size="5">
					<option class="form-control" value=""
						>请选择一项</option>
					
				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="name" class="m">详细地址：</label> <input type="text"
					class="form-control input-sm  m4" id="useradd" name="useradd"
					placeholder="输入详细地址" >
			</div>
			  <input type="hidden" id="parameterID"name="parameterID" value="1"> 
			<br>
			<br>
			<button type="submit" class="btn btn-primary">增加</button>
		</form>
	</div>

 f
<br />
<br />
<br />
            <script type="text/javascript">
$(function() {//获取城市名
	$("#provinceId").change(

			function() {
				$.ajax({
					url : "<%=basePath %>ManageAction/selectCity.action",//请求地址
					data : "provinceId="
							+ $("#provinceId").val(),//发送至服务器的键值数据
					dataType : "json",//请求数据格式，如script,json,text等
					type : "post",//发送方式，get/post
					success : function(redata) {////定义各事件发生时回调的函数
						$("#cityId").find("option").remove();
						$("#cityId").append('<option value="0">请选择一项</option>');
						$.each(redata, function(i, item) {
							$("#cityId").append("<option value="+item.cityId+">"+ item.cityName+ "</option>");
						});
					}
				});
			});

});
 $(function() {
	$("#userId").blur(
			function() {
				$.ajax({
					url : "<%=basePath %>ManageAction/selectUser.action",//请求地址
					data : "userId="
						+ $("#userId").val(),//发送至服务器的键值数据
					dataType : "json",//请求数据格式，如script,json,text等
					type : "post",//发送方式，get/post
					success : function(redata) {////定义各事件发生时回调的函数
						$.each(redata, function(i, item) {
						$("#tiShi").html(item.userName)
						});
						 
					}
				});
			});

});
</script>
<script>
!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#demo'});//绑定元素
	}();
	//日期范围限制
	var start = {
	    elem: '#start',
	    format: 'YYYY-MM-DD',
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
	    format: 'YYYY-MM-DD',
	    min: '1918-06-16',
	    max: '2099-06-16',
	    istime: true,
	    istoday: false,
	    choose: function(datas){
	        start.max = datas; //结束日选好后，充值开始日的最大日期
	    }
	};
	laydate(start);
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