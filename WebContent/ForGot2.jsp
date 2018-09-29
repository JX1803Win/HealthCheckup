<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>忘记密码</title>
<link rel="shortcut icon" href="images/favicon.ico" />
<link type="text/css" href="css/css.css" rel="stylesheet" />
<script src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
</head>



<script>
function check() {
	var pass = document.getElementById('pass').value;
	var repass = document.getElementById('repass').value;
	if(pass == null || pass == "" || pass == "null"){
		alert("请输入密码");
  		return false;
	}if(pass!=repass){
		alert("两次密码不一致");
  		return false;
	}
	
}
</script>


<body>

  <div class="content">
   <div class="web-width">
     <div class="for-liucheng">
      <div class="liulist for-cur"></div>
      <div class="liulist for-cur"></div>
      <div class="liulist for-cur"></div>
      <div class="liulist"></div>
      <div class="liutextbox">
       <div class="liutext for-cur"><em>1</em><br /><strong>验证身份</strong></div>
       <div class="liutext for-cur"><em>2</em><br /><strong>设置新密码</strong></div>
       <div class="liutext"><em>3</em><br /><strong>完成</strong></div>
      </div>
     </div><!--for-liucheng/-->
     <form action="user/forgot.action" method="get" onsubmit="return check()" class="forget-pwd">
       <dl>
        <dt>新密码：</dt>
        <dd><input type="password" id="pass" name="pass"/></dd>
        <div class="clears"></div>
       </dl> 
       <dl>
        <dt>确认密码：</dt>
        <dd><input type="password" id="repass" name="repass"/></dd>
        <div class="clears"></div>
       </dl> 
       <div class="subtijiao"><input type="submit" value="提交" /></div> 
      </form><!--forget-pwd/-->
   </div><!--web-width/-->
  </div><!--content/-->
  
</body>
</html>
