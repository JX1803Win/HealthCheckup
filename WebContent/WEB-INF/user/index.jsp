<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,org.xmgreat.bean.UserInfoBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <base href="<%=basePath%>">
    <meta name="MobileOptimized" content="240" />
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <title>健康体检散检</title>
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="css/index.css" />
    <link href="css/myPublic.css" rel="stylesheet" type="text/css" />
</head>

<script>
function check(user) {
	if(user==null){
		alert("请先登入");
  		return false;
	}
}
</script>


<script>
function back() {
	$.ajax({
		url : "user/backlog.action",
		dataType : "text",
		type : "post",
		success : function(redata) {
			
				window.location.href = "UserLoginAndReg.jsp"
		}
	}); 
}
</script>



<body aria-atomic="False" style="background: #ededed;">
    <!--幻灯片 开始-->
    <script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.flexslider').flexslider({
                controlNav: true,
                directionNav: false,
                animation: "slide"
            });
        });
    </script>
    
    <div class="headse">
		<div class="headL">
			<h1 id="headL">健康体检散检</h1>
		</div>
		
		<c:if test="${user.userName==null}">
		
		<div class="headR">
			<a href="UserLoginAndReg.jsp" target="_parent">【登入】</a>
		</div>
		</c:if>
		
		<c:if test="${user.userName!=null}">
		
		<div class="user">
		<span>${user.userName}</span>
		<a href="" onclick="return back()" target="_parent">【退出】</a>
		</div>
		
		</c:if>
		
	</div>
    
    <div id="banner" class="flexslider">
        <ul class="slides">
            <li>
                <img src="img/banner1.jpg" /></li>
            <li>
                <img src="img/banner1.jpg" /></li>
            <li>
                <img src="img/banner1.jpg" /></li>
        </ul>
    </div>
    <!--幻灯片 结束-->
        <dl class="ind_TuBiao">
            <dd><a href="user/gosetmeal.action" onclick="return check(${user.userName})">
                <img src="img/ind_02.png" /><p>服务项目</p>
            </a></dd>
            <dd><a href="user/gotoappo.action"  onclick="return check(${user.userName})">
                <img src="img/ind_07.png" /><p>体检预约</p>
            </a></dd>
            <dd><a href="PhyAction/queryAppo.action" onclick="return check(${user.userName})">
                <img src="img/ind_06.png" /><p>我的预约</p>
            </a></dd>
            <dd><a href="user/gopersonal.action"  onclick="return check(${user.userName})">
                <img src="img/ind_05.png" /><p>我的资料</p>
            </a></dd>
            
        </dl> 
</body>
</html>