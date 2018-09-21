<%@ page contentType="text/html;charset=UTF-8"%>
<%-- <%@ include file="/views/back/include/taglib.jsp"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>jquery.tree-multiselect</title>
    <link href="../plugins/bootstrap/bootstrap.min.css" rel="stylesheet" />    
    <link href="../plugins/tree-multiselect/jquery.tree-multiselect.min.css" rel="stylesheet" />
     <link href="../css/style.min.css" rel="stylesheet" />
    <style>
        .rightSize {
            margin-right: 5px;
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
</head>
<body class="gray-bg2">
    <div class="wrapper wrapper-content"  id="statisipDataArea">
        <div id="statisipArea" class="">
            <h3>角色管理</h3>
            <table id="treeSelectTable" class="table table-striped table-bordered">
                <thead>
                    <tr><td>序号</td><td>角色名称</td><td>操作</td></tr>
                    
                </thead> 
                <tbody id="treeSelectBody">
                   <c:forEach items="${rbList }" var="rb">
                    <tr><td>${rb.roleId }</td><td>${rb.roleName }</td>
                    <td>
                        <button class="btn btn-primary btn-sm grantAuthorityBtn rightSize" type="button" onClick="window.location.href='role/blackuserLogin.action?roleId=${rb.roleId }'" >增加</button>
                        <button class="btn btn-info btn-sm  modifyRoleBtn rightSize" type="button" data-id=${rb.roleId } > 删除</button>
                        <button class="btn btn-primary btn-sm grantAuthorityBtn rightSize" type="button" data-id=${rb.roleId } > 修改</button> 
                    </td></tr>                   
                    </c:forEach>
                </tbody>
            </table> 
        </div>
     
 
    </div>
   
    <script src="../plugins/jquery/jquery.min.js"></script>
    <script src="../plugins/jquery/jquery-ui.min.js"></script>
    <script src="../plugins/bootstrap/bootstrap.min.js"></script>
    <script src="../plugins/tree-multiselect/jquery.tree-multiselect.min.js"></script>
    <script src="../plugins/doT/doT.js"></script>
    <!--bootstrap-table-->
    <script src="~/Content/js/plugins/bootstrap-table/bootstrap-table.js"></script>
    <script src="~/Content/js/plugins/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    
    <script src="~/Content/js/plugins/layer/layer.min.js"></script>
    
    <script src="~/Content/js/plugins/doT/doT.js"></script>
    <script src="~/Content/js/commonjs.js"></script>
    <script src="~/Content/js/config.router.js"></script>
    
   
</body>

</html>
