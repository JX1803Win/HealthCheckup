<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>体检查询</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link href="<%=path%>css/x-admin.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/pag.css" rel="stylesheet" type="text/css">
<link href="<%=path%>css/AdminManagement.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>bgjs/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>lib/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path%>js/AdminManagement.js"></script>
<script src="<%=path%>laydate/laydate.js"></script>
<%-- <script src='<%=path%>js/ichart.latest.min.js'></script> --%>
<script type="text/javascript">

	var typeList;	
	function search(pageNo) {
		if(pageNo == 0) {
			return;
		}
		var myForm=document.getElementById("myForm");		
		myForm.action="<%=path%>doctor/medicalManInf.action?pageNo="+pageNo;
		myForm.method="post";
		myForm.submit();
	}
	function search2(pageNo) {
		if(pageNo == 0) {
			return;
		}
		var myForm=document.getElementById("myForm");		
		myForm.action="<%=path%>fileAction/exportExcell.action";
		myForm.method="post";
		myForm.submit();
	}
	
	function alter() {
		
		<%--  $.ajax({       	
        url:"<%=path%>doctor/projectResult.action",
        data:"setmealId="+setmealId+"&physicaiId="+physicaiId,	       
        dataType:"json",
		type:"POST",	
        success:function(redata){
        	var tb = document.getElementById('datas');
        	    var rowNum=tb.rows.length;
        	    for (i=0;i<rowNum;i++)
        	    {
        	        tb.deleteRow(i);
        	        rowNum=rowNum-1;
        	        i=i-1;
        	    } 
        	 $.each(redata, function(i) {    
        		 var tbBody = "";
        		  tbBody += "<tr id='template'><td id='projectName'>"+redata[i].projectName+"</td><td id='projectResult'>"+redata[i].projectResult+"</td></tr>";
        		  $("#datas").append(tbBody); 
                 
           });
        }
        }); --%>
	}
	function alter2(projectId, physicaiId) {
		 $.ajax({       	
       url:"<%=path%>doctor/projectResult.action",
       data:"projectId="+projectId+"&physicaiId="+physicaiId,	       
       dataType:"json",
		type:"POST",	
       success:function(redata){
    	   var tb = document.getElementById('datas');
       	    var rowNum=tb.rows.length;
       	    for (i=0;i<rowNum;i++)
       	    {
       	        tb.deleteRow(i);
       	        rowNum=rowNum-1;
       	        i=i-1;
       	    } 
       	 $.each(redata, function(i) {    
       		 var tbBody = "";
       		  tbBody += "<tr id='template'><td id='projectName'>"+redata[i].projectName+"</td><td id='projectResult'>"+redata[i].projectResult+"</td></tr>";
       		  $("#datas").append(tbBody); 
                
          });
       }
       });
	}
	function alert3(phyConad){
		$("#phyConad").val(phyConad);
		
	}
	
</script>

</head>
<body>
	<div class="container">
		<div class="x-nav">
			<span class="layui-breadcrumb"> <a href="main.jsp"><cite>体检查询</cite></a>
				<a><cite>体检报告信息</cite></a>
			</span>
		</div>
		<div class="page-header text-center">
			<h1>体检报告信息</h1>
		</div>
		
		<div class="text-center" id="div4">
			<form class="form-inline" role="form" id="myForm">
			
				<div class="form-group">
					<label for="name" class="m">用户名:</label> <input type="text"
						class="form-control input-sm  m5" id="userName" name="userName"
						placeholder="请输入名称" value="${roleName}"> <label for="name"
						class="m">电话号码:</label> <input type="text"
						class="form-control input-sm  m5" id="phone" name="phone"
						placeholder="请输入手机号" value="${phone}"> <label for="name"
						class="m">条码号:</label> <input type="text"
						class="form-control input-sm  m5" id="barCode" name="barCode"
						placeholder="请输入条码号" value="${barCode}">
					<div class="demo3">
						<ul class="inline">
							开始时间：
							<input type="text" class="inline laydate-icon" name="starDay"
								id="start" value="" style="width: 200px; margin-right: 10px;" />
							结束时间：
							<input type="text" class="inline laydate-icon" name="endDay"
								id="end" value="" style="width: 200px;" />
						</ul>
					</div>
				</div>
				<input type="button" class="btn btn-primary" onclick="search(1)"
					value="查询" />
					<br><button class="btn btn-primary x-left"  onclick="search2(1)">导出Excell</button>
					<button class="btn btn-primary " data-toggle="modal" data-target="#myModal1"
								onclick="">一周数据统计</button>
								
					<button class="btn btn-primary x-right" data-toggle="modal" data-target="#myModal1" 
							>修改</button> 			
								
								<button class="btn btn-primary " data-toggle="modal" data-target="#myModal2"
								onclick="alter('${menu.permissionsId}','${menu.menuName}','${menu.urlAddress}','${menu.preMenu}')">一月数据统计</button>
								<button class="btn btn-primary " data-toggle="modal" data-target="#myModal2"
								onclick="alter('${menu.permissionsId}','${menu.menuName}','${menu.urlAddress}','${menu.preMenu}')">三月数据统计</button>
			</form>
		</div>

		<div class="clearfix"></div>

		<div class="tools">		
			<span>共有数据：${sizeU} 条&nbsp;&nbsp;&nbsp;&nbsp;</span> <span>共${AllPageU}页&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span>当前页数：${pageNoU}&nbsp;&nbsp;&nbsp;&nbsp;</span>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>序号</th>
					<th>体检人</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机号</th>
					<th>体检/预约时间</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${uprbList}" var="user" varStatus="vs">
					<tr>
						<td>${(pageNoU-1)*5+vs.index+1}</td>
						<td>${user.userName}</td>
						<td>${user.sex}</td>
						<td>${user.age}</td>
						<td>${user.phone}</td>
						<td><c:if test="${user.userPhyRecordBean.phyTime!=null}">
								${user.userPhyRecordBean.phyTime}
							</c:if> <c:if test="${user.userPhyRecordBean.appoTime!=null}">
								${user.userPhyRecordBean.appoTime}
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page">
			<div class="pagelist text-center">
				<button class="btn btn-primary" onclick="search(${pageNoU==1?0:1})">首页</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary"
					onclick="search(${(pageNoU-1)>0?pageNoU-1:0})">上一页</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary"
					onclick="search(${(pageNoU+1)<=AllPageU?pageNoU+1:0})">下一页</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary"
					onclick="search(${pageNoU==AllPageU?0:AllPageU})">末页</button>
			</div>
		</div>
		<!-- 模态框（Modal） -->
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="myModalLabel">新增参数</h4>
				</div>

				<form id="myForm2" class="form-horizontal" role="form">
					<div class="modal-body">

						<div class="form-group">
							<label for="roleNames" class="col-sm-2 control-label">角色名称</label>
							<div class="col-sm-10">
								<input name="roleNames" id="roleNames" type="text" 
									class="form-control" placeholder="请输入角色名称(必填)">
							</div>
						</div>						

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="add()">提交</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form id="myForm2" class="form-horizontal" role="form">
						<div class="modal-body">
							<div class="form-group">
								<label for="roleNames" class="col-sm-2 control-label">项目总结</label>
								<div id='ichart-render'></div>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
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
	<script>
!function(){
laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
laydate({elem: '#demo'});//绑定元素
}();
//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
 /*    min: laydate.now(), //设定最小日期为当前日期 */
    max: '2099-06-16', //最大日期
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
    /* min: laydate.now(), */
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
    format: 'YYYY-MM-DD',
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
<!-- <script type='text/javascript'>
$(function(){
      var chart = iChart.create({
            render:"ichart-render",
            width:800,
            height:400,
            background_color:"#9edbd9",
            gradient:false,
            color_factor:0.2,
            border:{
                  color:"#0f3b59",
                  width:1
            },
            align:"center",
            offsetx:0,
            offsety:0,
            sub_option:{
                  border:{
                        color:"#bf9191",
                        width:1
                  },
                  label:{
                        fontweight:500,
                        fontsize:11,
                        color:"#4572a7",
                        sign:"square",
                        sign_size:12,
                        border:{
                              color:"#BCBCBC",
                              width:1
                        },
                        background_color:"#fefefe"
                  }
            },
            shadow:true,
            shadow_color:"#666666",
            shadow_blur:2,
            showpercent:false,
            column_width:"70%",
            bar_height:"70%",
            radius:"90%",
            title:{
                  text:"用户注册量统计表",
                  color:"#111111",
                  fontsize:20,
                  font:"微软雅黑",
                  textAlign:"center",
                  height:30,
                  offsetx:0,
                  offsety:0
            },
            subtitle:{
                  text:"本周统计",
                  color:"#111111",
                  fontsize:16,
                  font:"微软雅黑",
                  textAlign:"center",
                  height:20,
                  offsetx:0,
                  offsety:0
            },
            footnote:{
                  text:"数据来源：jx180319",
                  color:"#111111",
                  fontsize:12,
                  font:"微软雅黑",
                  textAlign:"right",
                  height:20,
                  offsetx:0,
                  offsety:0
            },
            legend:{
                  enable:true,
                  background_color:"#e8cccc",
                  color:"#333333",
                  fontsize:12,
                  border:{
                        color:"#BCBCBC",
                        width:1
                  },
                  column:1,
                  align:"right",
                  valign:"center",
                  offsetx:0,
                  offsety:0
            },
            coordinate:{
                  width:"80%",
                  height:"84%",
                  background_color:"#f0edf5",
                  axis:{
                        color:"#a5acb8",
                        width:[1,"",1,""]
                  },
                  grid_color:"#d9d9d9",
                  label:{
                        fontweight:500,
                        color:"#666666",
                        fontsize:11
                  }
            },
            label:{
                  fontweight:500,
                  color:"#666666",
                  fontsize:11
            },
            type:"column2d",
            data:[
                  {
                  name:"周一",
                  value:1,
                  color:"#4572a7"
            },{
                  name:"周二",
                  value:2,
                  color:"#aa4643"
            },{
                  name:"周三",
                  value:3,
                  color:"#89a54e"
            },{
                  name:"周四",
                  value:4,
                  color:"#9e9393"
            },{
                  name:"周五",
                  value:5,
                  color:"#246314"
            },{
                  name:"周六",
                  value:6,
                  color:"#258a8f"
            },{
                  name:"周天",
                  value:7,
                  color:"#141212"
            }
            ]
      });
      chart.draw();
});
</script> -->

</body>
</html>