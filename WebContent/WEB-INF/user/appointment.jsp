<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=path%>">
    <title>体检预约</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <!-- 时间选择器js -->
    <script src="laydate/laydate.js"></script>
	<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		function show1() {
			$("#combo_div").show();
			$("#project_div").hide();
			$("#btn").show();
		}
		function show2() {
			$("#project_div").show();
			$("#combo_div").hide();
			$("#btn").show();
		}
		function check() {
			var result = "";
			var time = $("#time").val();
			var combo = $("#combo").val();
			var project = $("#project").val();
			if(time == "") {
				result += "预约时间不能为空\n";
			}
			if(combo == "" && project == "") {
				result += "体检套餐/项目不能为空";
			}
			if(result == "") {
				return true;
			} else {
				alert(result);
				return false;
			}
		}
		$(function() {
			$.getJSON("<%=path%>PhyAction/queryAllSetmeal.action", 
			function(data) {
				for (var i = 0; i < data.length; i++) {
					$("#combo").append("<option value="+ data[i].setmealId +">"+data[i].setmealName+"</option>");
				}
			});
		})
		$(function() {
			$.getJSON("<%=path%>PhyAction/queryAllProject.action", 
			function(data) {
				for (var i = 0; i < data.length; i++) {
					$("#project").append("<option value="+ data[i].projectId +">"+data[i].itemName+"</option>");
				}
			});
		})
		$(function() {
			var msg = "${requestScope.get('msg')}";
			console.log(msg);
			if(msg.length > 0) {
				alert(msg);
			}
		})
	</script>
</head>
<body background = "images/YuYue/yuyuebg.jpg">
<form action="<%=path%>PhyAction/addPhy.action" method="post" onsubmit="return check()">
<table style="margin:auto;width:500px;">
	<tr>
		<td style="text-align:center;vertical-align:top;padding-top:20px;font-size:20px;">
			<div>
				<div style="color:blue;font-size:30px;">体检预约</div>
				<div class="form-inline"><br/>
					<label for="time" class="control-label">预约时间：</label>
					<input class="form-control" type="text" id="time" name="time"/>
				</div>
				<div><br/>
					<input type="button" class="btn btn-primary" onclick="show1()" value="选择体检套餐" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" class="btn btn-primary" onclick="show2()" value="选择体检项目" />
				</div>
				<div class="form-inline" id="combo_div" style="display: none"><br/>
					<label for="combo" class="control-label">体检套餐：</label>
					<select class="selectpicker form-control input-sm m5" style="width:200px;" id="combo" name="combo">
						<option value="">请选择</option>
						<!-- <option value="1">入职体检套餐</option> -->
					</select>
				</div>
				<div class="form-inline" id="project_div" style="display: none"><br/>
					<label for="project" class="control-label">体检项目：</label>
					<select class="selectpicker form-control input-sm m5" style="width:200px;" id="project" name="project">
						<option value="">请选择</option>
						<!-- <option value="1">血常规</option> -->
					</select>
				</div>
				<div id="btn" style="display: none"><br/>
					<input type="button" class="btn btn-primary"  value="详情"/>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" class="btn btn-primary" value="提交"/>
				</div>
			</div>
		</td>
	</tr>
</table>
</form>
</body>
<script type="text/javascript">
	laydate({
	    elem: '#time',
	    min: laydate.now(+1), //-1代表昨天，-2代表前天，以此类推
	});
</script>
</html>
