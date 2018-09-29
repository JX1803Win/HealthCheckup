<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>忘记密码</title>
<link type="text/css" href="css/css.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.3-min.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>


<style type="text/css">
.checkCode {
	cursor: pointer;
	border: 0px solid black;
	text-align: center;
	line-height: 26px;
	border-radius: 25px;
	background: #1161ee;
	width: 100px;
	height: 27px;
	color:#fff;
}
</style>

<script type="text/javascript">
    var sleep = 30, interval = null,flag=false;
   
    window.onload = function ()
    {
        var btn = document.getElementById ('btn');
        
        btn.onclick = function ()
        {
        	var phone = document.getElementById('phone').value;
        	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
        		alert("请输入正确的手机号");
        		return
        	}
        	
        	if((/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
				$.ajax({
					url : "user/fgcheckphone.action",
					data : "phone=" + phone,
					dataType : "text",
					type : "post",
					success : function(redata) {
						if(redata=="\"否\""){
							alert("手机号未注册");
							return
						}else{
							time();
						}
					}
				});	
			}
        } 
    }
    function time(){
    	 if (!interval)
    	    {
    		 document.getElementById ('btn').style.backgroundColor = 'rgb(200, 182, 182)';
    		 document.getElementById ('btn').disabled = "disabled";
    		 document.getElementById ('btn').style.cursor = "wait";

    	    	interval = setInterval (function ()
    	                {
    	                    if (sleep == 0)
    	                    {
    	                        if (!!interval)
    	                        {
    	                            clearInterval (interval);
    	                            interval = null;
    	                            sleep = 30;
    	                            document.getElementById ('btn').style.cursor = "pointer";
    	                            document.getElementById ('btn').removeAttribute ('disabled');
    	                            document.getElementById ('btn').value = "获取验证码";
    	                            document.getElementById ('btn').style.backgroundColor = '';
    	                        }
    	                        return false;
    	                    }
    	                    document.getElementById ('btn').innerHTML ="重新发送 (" + sleep-- + ")";
    	                }, 1000);
    	    }
    }
   
</script>

<script>
function check() {
	var phone = document.getElementById('phone').value;
	var code = document.getElementById('code').value;
      	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
			alert("请输入正确的手机号");
      		return false;
      	}
      	if(code == null || code == "" || code == "null"){
      		alert("请输入验证码");
      		return false;
      	}
    	 $.ajax({
    		url : "user/checkcode.action",
    		data : "phone=" + phone + "&code="+code,
    		dataType : "text",
    		type : "post",
    		success : function(redata) {
    			if(redata=="\"验证码错误\""){
    				alert("验证码错误");
    				return false;
    			}else{
    				window.location.href = "ForGot2.jsp"
    			}
    		}
    	}); 
}
</script>

</head>

<body>

  <div class="content">
   <div class="web-width">
     <div class="for-liucheng">
      <div class="liulist for-cur"></div>
      <div class="liulist for-cur"></div>
      <div class="liulist"></div>
      <div class="liulist"></div>
      <div class="liutextbox">
       <div class="liutext for-cur"><em>1</em><br /><strong>验证身份</strong></div>
       <div class="liutext"><em>2</em><br /><strong>设置新密码</strong></div>
       <div class="liutext"><em>3</em><br /><strong>完成</strong></div>
      </div>
     </div><!--for-liucheng/-->
     <form action="" method="get" class="forget-pwd">
       <dl>
        <div class="clears"></div>
       </dl>
       <dl class="sel-yzsj">
        <dt>手机号：</dt>
        <dd><input id="phone" name="phone" type="text"/></dd>
        <div class="clears"></div>
       </dl>
       <dl>
        <dt>手机验证码：</dt>
        <dd><input id="code" name="code" type="text" /> <button type="button" class="checkCode" id="btn">获取验证码</button></dd>
        <div class="clears"></div>
       </dl>
       <div class="subtijiao"><input type="button" onClick="check()" value="提交" /></div> 
      </form><!--forget-pwd/-->
   </div><!--web-width/-->
  </div><!--content/-->
  
</body>
</html>
