<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>忘记密码</title>
<link rel="shortcut icon" href="images/favicon.ico" />
<link type="text/css" href="css/css.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.3-min.js"></script>
<script type="text/javascript">
 //导航定位
 $(function(){
	// $(".nav li:eq(2) a:first").addClass("navCur")
	 //验证手机 邮箱 
	 $(".selyz").change(function(){
	   var selval=$(this).find("option:selected").val();
		 if(selval=="0"){
			 $(".sel-yzsj").show()
			 $(".sel-yzyx").hide()
			 }
		 else if(selval=="1"){
			 $(".sel-yzsj").hide()
			 $(".sel-yzyx").show()
			 }
		 })
	 })
</script>


<script type="text/javascript">
    var sleep = 30, interval = null;
   
    window.onload = function ()
    {
        var btn = document.getElementById ('btn');
        
        btn.onclick = function ()
        {
        	var phone = document.getElementById('phone').value;
        	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
        		alert(请输入正确的手机号);
        		return
        	}
        	
        	
        	if((/^1[3|4|5|8][0-9]\d{4,8}$/.test(phonenb))){
				$.ajax({
					url : "user/checkphone.action",
					data : "phone=" + phonenb,
					dataType : "text",
					type : "post",
					success : function(redata) {
						if(redata=="\"否\""){
						document.getElementById('mag').innerHTML = '手机号已被注册'
						return
						}
					}
				});	
			}
        
            if (!interval)
            {
            	this.style.backgroundColor = 'rgb(200, 182, 182)';
                this.disabled = "disabled";
                this.style.cursor = "wait";
                this.value = "重新发送 (" + sleep-- + ")";
                interval = setInterval (function ()
                {
                    if (sleep == 0)
                    {
                        if (!!interval)
                        {
                            clearInterval (interval);
                            interval = null;
                            sleep = 30;
                            btn.style.cursor = "pointer";
                            btn.removeAttribute ('disabled');
                            btn.value = "获取验证码";
                            btn.style.backgroundColor = '';
                        }
                        return false;
                    }
                    btn.value = "重新发送 (" + sleep-- + ")";
                }, 1000);
            }
        } 
    }
</script>


<script>
function check() {
	var phone = document.getElementById('phone').value;
      	if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
			alert("请输入正确的手机号");
      		return false;
      	}
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
     <form action="ForGot2.jsp" method="get" onsubmit="return check()" class="forget-pwd">
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
        <dd><input type="text" /> <button>获取短信验证码</button></dd>
        <div class="clears"></div>
       </dl>
       <div class="subtijiao"><input type="submit" value="提交" /></div> 
      </form><!--forget-pwd/-->
   </div><!--web-width/-->
  </div><!--content/-->
  
</body>
</html>
