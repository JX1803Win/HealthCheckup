<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort()
			+ request.getContextPath() + "/";
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>jquery.tree-multiselect</title>
    <link href="<%=path%>css/x-admin.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>css/pag.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>css/AdminManagement.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>css/background/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path %>css/background/jquery.tree-multiselect.min.css" rel="stylesheet" />
    <link href="<%=path %>css/background/style.min.css" rel="stylesheet" />    
    <link href="<%=path%>lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
    <link href="<%=path%>lib/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css" />
    
	<link rel="stylesheet" href="<%=path %>css/background/jquery-ui.css">

    <style>
        .rightSize {
            margin-right: 5px;
        }
		.therightSize{
			
		}
        body {
            padding: 20px;
        }
        #treeSelectTable {
            width: 80%;
        }
        #treeSelectTable tr th,#treeSelectTable tr td {
            text-align: center;
        }
    </style>
	<script type="text/javascript">
	var typeList;
	function permission() {
		var roleName=$("#AuthorityTitle").text();
		var menuName = $("#authorityBody option:selected").text();
		var myForm=document.getElementById("myForms");
		myForm.action="<%=path%>role/permission.action?menuName="+menuName+"&roleName="+roleName;
		myForm.method="post";
		myForm.submit();
	}
	
	function search(pageNo) {
		
		if(pageNo == 0) {
			return;
		}
		var myForm=document.getElementById("myForm");
		myForm.action="<%=path%>role/allRoles.action?pageNo="+pageNo;
		myForm.method="post";
		myForm.submit();
	}
	
	
	
</script>
</head>
<body class="gray-bg2">
    <div class="wrapper wrapper-content"  id="statisipDataArea">   
    
		<span > <a href="main.jsp"><cite>系统管理</cite></a><a><cite>&nbsp; &gt;&nbsp; </cite></a> <a><cite>权限管理</cite></a>
		</span>
	
	<div class="page-header text-center">
		<h1>角色管理</h1>
	</div>	
		<div class="text-center" id="div4">
		<form class="form-inline" role="form" id="myForm">
		   <div class="form-group">
				<label for="name" class="m">角色名称:</label> <input type="text"
					class="form-control input-sm  m5" id="roleName" name="roleName"
					placeholder="请输入名称" value="${roleName}">
			</div> 
			
			<input type="button" class="btn btn-primary" onclick="search(1)" value="查询"/>
		</form>
	</div>
        <div id="statisipArea" class="">
            
	<div class="tools">		
        <span>共有数据：${sizeL} 条&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span>共${AllPage}页&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <span>当前页数：${pageNo}&nbsp;&nbsp;&nbsp;&nbsp;</span>
	</div>
            <table id="treeSelectTable"  class="table table-striped table-bordered">
                <thead>
                    <tr><td>序号</td><td>角色名称</td><td>操作</td></tr>
                </thead> 
                <tbody id="treeSelectBody">
                <c:forEach var="role" items="${rbList}"  varStatus="num">
                 <tr>
            		<td>${num.index+1}</td>
           		 	<td>${role.roleName}</td>            		
            		<td>                 	
               		<button class="btn btn-primary btn-sm grantAuthorityBtn rightSize" type="button" data-id=${role.roleId} ><i class="fa fa-external-link"></i> 授权</button>					
            		</td>
        		</tr>
        		</c:forEach>
                </tbody>
            </table> 
        </div>
     <div class="page">
		 <div class="pagelist text-center">
			<button class="btn btn-primary" onclick="search(${pageNo==1?0:1})">首页</button>&nbsp;&nbsp;
			<button class="btn btn-primary" onclick="search(${(pageNo-1)>0?pageNo-1:0})">上一页</button>&nbsp;&nbsp;
			<button class="btn btn-primary" onclick="search(${(pageNo+1)<=AllPage?pageNo+1:0})">下一页</button>&nbsp;&nbsp;
			<button class="btn btn-primary" onclick="search(${pageNo==AllPage?0:AllPage})">末页</button>
		</div>
	</div>
 
    </div>
 
     <!--给用户分配角色modal-->
    <div class="modal inmodal fade" id="grantAuthorityModal" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static" data-keyboard="false" >
        <div class="modal-dialog">
        <form action="" id="myForms" >
            <div class="modal-content animated fadeIn">
                <div class="modal-header btn-primary">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
                    </button>
                    <h4 class="modal-title" id="AuthorityTitle"></h4>
                </div>
                <div class="modal-body" id="authorityBody">
				<!-- 用ajax传到后台获得选中 -->
                </div>                
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" >关闭</button>
                    <button type="button" class="btn btn-primary" id="" onclick="permission()">提交</button>
                </div>
            </div>
         </form>
        </div>
    </div>

    <script id="treeSelect-template" type="text/x-dot-template">

    </script>   
    <script src="<%=path %>js/background/jquery.min.js"></script>
    <script src="<%=path %>js/background/jquery-ui.min.js"></script>
    <script src="<%=path %>js/background/bootstrap.min.js"></script>
    <script src="<%=path %>js/background/jquery.tree-multiselect.min.js"></script>
    <script src="<%=path %>js/background/doT.js"></script>
    <!--bootstrap-table-->
    <!--<script src="~/Content/js/plugins/bootstrap-table/bootstrap-table.js"></script>
    <script src="~/Content/js/plugins/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    $1$layer#1#
    <script src="~/Content/js/plugins/layer/layer.min.js"></script>
    $1$封装的ajax数据接口#1#
    <script src="~/Content/js/plugins/doT/doT.js"></script>
    <script src="~/Content/js/commonjs.js"></script>
    <script src="~/Content/js/config.router.js"></script>-->
    <script src="<%=path %>js/background/index.js"></script>
</body>

</html>