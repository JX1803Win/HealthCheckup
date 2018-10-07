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
<script type="text/javascript">

	var typeList;	
	function search(pageNo) {
		if(pageNo == 0) {
			return;
		}
		var myForm=document.getElementById("myForm");		
		myForm.action="<%=path%>doctor/userPhyRecordInf.action?pageNo="+pageNo;
		myForm.method="post";
		myForm.submit();
	}
	
	function alter1(setmealId, physicaiId) {
		 $.ajax({       	
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
        });
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
	function alters3(phyConad){
		$("#phyConad").html(phyConad);
		
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
					<th>套餐信息</th>
					<th>项目信息</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${uprbList}" var="user" varStatus="vs">
					<tr>
						<td>${(pageNoU-1)*5+vs.index+1}</td>
						<td>${user.userInfoBean.userName}</td>
						<td>${user.setmealName}</td>
						<td>${user.itemName}</td>
						<td class="text-center"><c:if test="${user.setmealId!=null}">
								<button class="btn btn-primary " data-toggle="modal"
									data-target="#myModal1"
									onclick="alter1('${user.setmealId}','${user.physicaiId}')">项目小结</button>
							</c:if> <c:if test="${user.setmealId==null}">
								<button class="btn btn-primary " data-toggle="modal"
									data-target="#myModal1"
									onclick="alter2('${user.projectId}','${user.physicaiId}')">项目小结</button>
							</c:if>

							<button class="btn btn-primary" data-toggle="modal"
								data-target="#myModal2" onclick="alters3('${user.phyConad}')">项目总结</button>
							<%-- <button class="btn btn-primary" data-toggle="modal"
								data-target="#myModal4" onclick="alter4('${user.phyConad}'')">体检报告</button> --%>

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
		<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">


					<form id="myForm2" class="form-horizontal" role="form">
						<div class="modal-body">

							<div class="form-group">
								<label for="roleNames" class="col-sm-2 control-label">项目小结:</label><br>
								<table width="100%" cellpadding="0" cellspacing="0" border="1"
									class="modal-body" id="datas">
								</table>
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
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<form id="myForm2" class="form-horizontal" role="form">
						<div class="modal-body">
							<div class="form-group">
								<label for="roleNames" class="col-sm-2 control-label">项目总结</label></br></br>
								<span id="phyConad"></span>
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
</body>
</html>