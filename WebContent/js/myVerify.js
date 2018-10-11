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
	function myCard(){
		var x;
		var r=confirm("确定要激活此卡吗？");
		if(r==true){
			return true;
		}else{
			return false;
		}
		
	}
	function chushihuaCard(){
		var x;
		var r=confirm("确定要初始化此卡吗？");
		if(r==true){
			return true;
		}else{
			return false;
		}
		
	}
	function jinyongCard(){
		var x;
		var r=confirm("确定要禁用此卡吗？");
		if(r==true){
			return true;
		}else{
			return false;
		}
		
	}
	function shanchuCard(){
		var x;
		var r=confirm("确定要删除此卡吗？");
		if(r==true){
			return true;
		}else{
			return false;
		}
		
	}
	function guashiCard(){
		var x;
		var r=confirm("确定要挂失此卡吗？");
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
		return true;
		}
	function isChineseName(obj){ 
		var reg=/^[\u0391-\uFFE5]+$/;
		if(obj==""){ 
			alert('姓名不能为空！');
			return false; 
			} 
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
		return true;
		}
	function yzsj(phoneNum){
	    var reg = /^1(3|4|5|7|8)\d{1}[-]?\d{4}[-]?\d{4}$/;
	if(phoneNum==""){ 
		alert('手机号码不能为空！');
		return false; 
		} 
	    if(!reg.test(phoneNum)){
	        alert("手机号码格式不正确");
	return false; 
	    }
	return true;
	}
	//验证注册账号 
	//验证只能为数字 
	function checkNumber(obj){ 
	var reg = /^[0-9]+$/; 
	if(obj==""){ 
		alert('注册账号不能为空'); 
		return false; 
		}
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
	return true;
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
		return true;
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
		return true;
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
	return true;
	} 
	
	function checkPhysicaiId(){ 
		var physicaiId = document.getElementById("physicaiId").value
		var reg = /^[0-9]+$/; 
		if(physicaiId==""){ 
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
		return true;
		} 
	
	function checkPhyCardId(){ 
		var phyCardId = document.getElementById("phyCardId").value
		var reg = /^[0-9]+$/; 
		if(phyCardId==""){ 
		alert('请输入查询卡 号！'); 
		return false; 
		} 
		if(!reg.test(phyCardId)){ 
			alert('请输入正确的账号！'); 
			return false; 
			} 
		if (phyCardId.length != 11 ) {
			alert("请输入11位卡号");
			return false;
		}
		return true;
		} 
	//验证充值金额
	function checkTopUp(){ 
		var money = document.getElementById("money").value
		var reg = /^[0-9]+$/; 
		if(money==""){ 
			alert('充值金额不能为空！'); 
			return false; 
			} 
		if(money!=""&&!money.test(obj)){ 
		alert('请输入正确充值金额'); 
		return false; 
		} 
		
		if (money.length > 5 ) {
			
			alert("单次充值金额不得高于十万");
			return false;
		}
		return true;
		} 
	//验证退款金额
	function checkRefund(){ 
		var money1 = document.getElementById("money1").value
		var reg = /^[0-9]+$/; 
		if(money1==""){ 
			alert('退款金额不能为空！'); 
			return false; 
			} 
		if(money1!=""&&!reg.test(money1)){ 
		alert('请输入正确退款金额'); 
		return false; 
		} 
		
		if (money1.length > 4 ) {
			
			alert("单次退款金额不得高于一万");
			return false;
		}
		return true;
		} 
	
	
	
	
	
	