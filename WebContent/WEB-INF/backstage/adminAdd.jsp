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
<title>数据备份</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="<%=basePath %>/css/x-admin.css" media="all">
<script type="text/javascript" src="<%=basePath %>bgjs/jquery.min.js">
</script>
<script type="text/javascript">
layui.use('form', function(){
	  var form = layui.form; 
	  form.render();
	 });
</script>
</head>
<body>
  <div class="layui-tab-item layui-show">
   <div class="layui-tab-content" >
                <div class="layui-tab-item layui-show">
                    <form class="layui-form layui-form-pane" action="">
                       
                       <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>用户ID</label>
                    <div class="layui-input-inline">
                        <input type="text" id="adminId" name="adminId" 
                         class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>用户名称</label>
                    <div class="layui-input-inline">
                        <input type="text"  id="mangerName"name="mangerName" 
                         class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>密码</label>
                    <div class="layui-input-inline">
                        <input type="text"  id="password"name="password" 
                         class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>确认密码</label>
                    <div class="layui-input-inline">
                        <input type="text"  name="name" 
                         class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>性别</label>
                    <div class="layui-input-inline">
                        <input type="text"  id="sex"name="sex" 
                         class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>年龄</label>
                    <div class="layui-input-inline">
                        <input type="text"  id="age"name="age" 
                         class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>出生日期</label>
                    <div class="layui-input-inline">
                        <input type="text"  id="birthDate"name="birthDate" 
                         class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>手机号</label>
                    <div class="layui-input-inline">
                        <input type="text" id="phoneNum" name="phoneNum" 
                         class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                 <div class="layui-form-item">
                    <label for="link" class="layui-form-label">
                        <span class="x-red">*</span>省份
                    </label>
                    <div class="layui-input-inline">
                        <select lay-verify="required" id="provinceId"name="provinceName">
                                <option>
                                </option>
                               <c:forEach items="${listProvince}" var="province" varStatus="vs">
					<option class="form-control" value="${province.provinceId}">${province.provinceName}</option>
					</c:forEach>
                            </select>
                    </div>
                </div>
                 <div class="layui-form-item">
                    <label for="link" class="layui-form-label">
                        <span class="x-red">*</span>城市
                    </label>
                    <div class="layui-input-inline">
                        <select lay-verify="required" id="cityId"name="cityName">
                                <option>
                                </option>
                           
                            </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="L_email" class="layui-form-label">
                        <span class="x-red">*</span>详细住址</label>
                    <div class="layui-input-inline">
                        <input type="text"  id="address"name="address" 
                         class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux">
                        <span class="x-red">*</span>必填
                    </div>
                </div>
                 <div class="layui-form-item">
                    <label for="link" class="layui-form-label">
                        <span class="x-red">*</span>角色
                    </label>
                    <div class="layui-input-inline">
                        <select lay-verify="required" id="roleId"
					name="roleId">
                                <option>
                                </option>
                               <c:forEach items="${listRole}" var="role" varStatus="vs">
					<option class="form-control" value="${role.roleId}">${role.roleName}</option>
					</c:forEach>
                            </select>
                    </div>
                </div>
                 <div class="layui-form-item">
                    <label for="link" class="layui-form-label">
                        <span class="x-red">*</span>科室
                    </label>
                    <div class="layui-input-inline">
                        <select lay-verify="required"  id="officeId"
					name="officeId" >
                                <option>
                                </option>
                                <c:forEach items="${listOffice}" var="office" varStatus="vs">
					<option class="form-control" value="${office.officeId}">${office.officeName}</option>
					</c:forEach>
                            </select>
                    </div>
                    <input type="hidden" id="paramterId"name="paramterId" value="1"> 
                </div>
                            <button>
                                备份数据库
                            </button>
                    </form>
                    <div style="height:100px;"></div>
                </div>
  </div>
</div>
<br />
<br />
<br />
            <script type="text/javascript">
$(function() {//获取城市名
	$("#provinceId").change(

			function() {
				alert('进入AJAX！')
				$.ajax({
					url : "<%=basePath %>ManageAction/selectCity.action",//请求地址
					data : "provinceId="
							+ $("#provinceId").val(),//发送至服务器的键值数据
					dataType : "json",//请求数据格式，如script,json,text等
					type : "post",//发送方式，get/post
					success : function(redata) {////定义各事件发生时回调的函数
						$("#doc").find("option").remove();
						$("#doc")
						.append(
								'<option value="0">--请选择--</option>');
						$.each(redata, function(i, item) {
							
							$("#provinceId")
									.append(
											"<option value="+item.provinceId+">"
													+ item.cityName
													+ "</option>");
						});
					}
				});
			});

});
</script>
</body>
</html>