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
	function yzsj(phoneNum){
	    var reg = /^1(3|4|5|7|8)\d{1}[-]?\d{4}[-]?\d{4}$/;
	    if(!reg.test(phoneNum)){
	        alert("手机号码格式不正确");
	    }
	}
	
