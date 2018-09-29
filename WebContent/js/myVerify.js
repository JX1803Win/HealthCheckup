function mydelete(){
		var x;
		var r=confirm("确定要删除用户吗？");
		if(r==true){
			return true;
		}else{
			return false;
		}
		
	}
	function myforbidden(){
		var x;
		var r=confirm("确定要禁用此用户吗？");
		if(r==true){
			return true;
		}else{
			return false;
		}
		
	}
	function mystar(){
		var x;
		var r=confirm("确定要启用此用户吗？");
		if(r==true){
			return true;
		}else{
			return false;
		}
		
	}
	function myreset(){
		var x;
		var r=confirm("确定要重置密码吗？");
		if(r==true){
			return true;
		}else{
			return false;
		}
		
	}
	function isChinese(obj){ 
		var reg=/^[\u0391-\uFFE5]+$/; 
		if(obj!=""&&!reg.test(obj)){ 
		alert('必须输入中文！');
		return false; 
		} 
		}
	function isChineseName(obj){ 
		var reg=/^[\u0391-\uFFE5]+$/; 
		if(obj!=""&&!reg.test(obj)){ 
		alert('必须输入汉字！');
		return false; 
		} 
		if (obj.length > 6 ) {
			alert("姓名不超过6个汉字");
			return false;
		}
		if (obj.length < 2 ) {
		
			alert("姓名不得低于2个汉字");
			return false;
		}
	
		}
	function yzsj(phoneNum){
	    var reg = /^1(3|4|5|7|8)\d{1}[-]?\d{4}[-]?\d{4}$/;
	    if(!reg.test(phoneNum)){
	        alert("手机号码格式不正确");
	return false; 
	    }
	}
	//验证注册账号 
	//验证只能为数字 
	function checkNumber(obj){ 
	var reg = /^[0-9]+$/; 
	if(obj!=""&&!reg.test(obj)){ 
	alert('只能输入数字！'); 
	return false; 
	} 
	if (obj.length < 4 ) {
		alert("账户ID不得低于4位数字");
		return false;
	}
	if (obj.length > 8 ) {
		
		alert("账户ID不超过8位数字");
		return false;
	}
	} 
	//验证密码
	function checkPwd(obj){ 
		
		if (obj.length < 6 ) {
			alert("密码不得低于6位");
			return false;
		}
		if (obj.length > 16 ) {
			
			alert("密码不超过16位数字");
			return false;
		}
		} 
	
	function checkage(obj){ 
		var reg = /^[0-9]+$/; 
		if(obj!=""&&!reg.test(obj)){ 
		alert('年龄只能输入数字！'); 
		return false; 
		} 
		
		if (obj.length > 2 ) {
			
			alert("年龄不超过100岁");
			return false;
		}
		} 
	//验证只能为数字 
	function checkCardNumber(obj){ 
	var reg = /^[0-9]+$/; 
	if(obj!=""&&!reg.test(obj)){ 
	alert('请输入正确11位卡号！'); 
	return false; 
	} 
	if (obj.length != 11 ) {
		alert("请输入正确11位卡号！");
		return false;
	}
	} 
	
	function checkPhysicaiId(){ 
		var physicaiId = document.getElementById("physicaiId").value
		var reg = /^[0-9]+$/; 
		if(physicaiId==""&&!reg.test(obj)){ 
		alert('请输入查询体检号！'); 
		return false; 
		} 
		if(!reg.test(physicaiId)){ 
			alert('请输入正确的体检号！'); 
			return false; 
			} 
		if (physicaiId.length < 6 ) {
			alert("体检号不得低于6位");
			return false;
		}
		if (physicaiId.length > 8 ) {
			
			alert("体检号不超过8位数字");
			return false;
		}
		} 
	
	function checkUserId(){ 
		var userId = document.getElementById("userId").value
		var reg = /^[0-9]+$/; 
		if(physicaiId==""&&!reg.test(obj)){ 
		alert('请输入查询用户账号！'); 
		return false; 
		} 
		if(!reg.test(physicaiId)){ 
			alert('请输入正确的账号！'); 
			return false; 
			} 
		if (physicaiId.length < 6 ) {
			alert("账号不得低于6位");
			return false;
		}
		if (physicaiId.length > 8 ) {
			
			alert("账号不超过8位数字");
			return false;
		}
		} 
	
	
	
	
	
	
	