/**
 * 验证注册
 * @returns 是否验证通过
 */
function checkRegister() {
	var username = document.getElementById("username").value;
	var psw = document.getElementById("userPsw").value;
	var confirmPsw = document.getElementById("confirmPsw").value;
	var age = document.getElementById("age").value;
	var telephone = document.getElementById("telephone").value;
	var address = document.getElementById("address").value;
	var regTelephone = /^[1][0-9]{10}$/;//手机号正则表达式
	var regNum = /^([1-9][0-9]*){1,3}$/;// 非零正整数，长度为1-3位
	var regCH = /[\u4e00-\u9fa5]{1}/g;// 中文
	var result = true;
	if(username=="") {
		document.getElementById("nameError").innerHTML="*用户名不能为空";
		result = false;
	} else if(username.indexOf(" ") != -1) {
		document.getElementById("nameError").innerHTML="*用户名不能有空格";
		result = false;
	} else if(username.length > 5) {
		document.getElementById("nameError").innerHTML="*用户名不超过5个字符";
		result = false;
	} else {
		document.getElementById("nameError").innerHTML="";
	}
	if(psw.length==0) {
		document.getElementById("pwdError").innerHTML="*密码不能为空";
		result = false;
	} else if(psw.indexOf(" ") != -1) {
		document.getElementById("pwdError").innerHTML="*密码不能有空格";
		result = false;
	} else if(psw.length > 10) {
		document.getElementById("pwdError").innerHTML="*密码不能超过10位";
		result = false;
	} else {
		document.getElementById("pwdError").innerHTML="";
	}
	if (confirmPsw.length==0){
		document.getElementById("confirmPswError").innerHTML="*确认密码不能为空";
		result = false;
	} else if(psw!=confirmPsw){
		document.getElementById("confirmPswError").innerHTML="*两次密码不一致";
		result = false;
	} else {
		document.getElementById("confirmPswError").innerHTML="";
	} 
	if(age == "") {
		document.getElementById("ageError").innerHTML="*年龄不能为空";
	} else if(!regNum.test(age)) {
		document.getElementById("ageError").innerHTML="*年龄错误";
		result = false;
	} else {
		document.getElementById("ageError").innerHTML="";
	}
	if(telephone=="") {
		document.getElementById("telephoneError").innerHTML="*手机号不能为空";
		result = false;
	} else if(!regTelephone.test(telephone)) {
		document.getElementById("telephoneError").innerHTML="*手机号错误";
		result = false;
	} else {
		document.getElementById("telephoneError").innerHTML="";
	}
	if(address.length == 0) {
		document.getElementById("addressError").innerHTML="*通讯地址不能为空";
		return false;
	} else if(address.length > 30) {
		document.getElementById("addressError").innerHTML="*通讯地址30个字符以内";
		return false;
	} else {
		document.getElementById("addressError").innerHTML="";
	}
	return result;
}
/**
 * 验证登陆
 * @returns 是否验证通过
 */
function checkLogin() {
	var username = document.getElementById("username").value;
	var psw = document.getElementById("psw").value;
	var result = true;
	if(username=="" || psw.length==0) {
		alert("用户名或密码不能为空！");
		result = false;
	}
	return result;
}
function checkAddAdmin() {
	var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$/;// 只能包含数字和字母且长度为6-10位
	var regNum = /^([1-9][0-9]*){1,5}$/;// 非零正整数，长度为1-5位
	var regCH = /[\u4e00-\u9fa5]{1}/g;// 中文
	var result = "";
	var adminAcc1 = document.getElementById("adminAcc1").value;
	var adminPsw1 = document.getElementById("adminPsw1").value;
	var adminName1 = document.getElementById("adminName1").value;
	var title1 = document.getElementById("title1").value;
	var graduateSchool1 = document.getElementById("graduateSchool1").value;
	var major1 = document.getElementById("major1").value;
	var appoCost1 = document.getElementById("appoCost1").value;
	var counselCost1 = document.getElementById("counselCost1").value;
	var intro1 = document.getElementById("intro1").value;
	if(!reg.test(adminAcc1)) {
		result += "账号只能由数字和字母组成且长度为6-10位\n";
	} 
	if(!reg.test(adminPsw1)) {
		result += "密码只能由数字和字母组成且长度为6-10位\n";
	}
	if(adminName1.length == 0) {
		result += "姓名不能为空\n";
	} else if((!regCH.test(adminName1)) && adminName1.length <= 10) {
		result += "姓名只能是中文且不能超过5个字\n";
	}
	if(title1.length == 0) {
		result += "职称不能为空\n";
	} else if((!regCH.test(title1)) && title1.length <= 20) {
		result += "职称只能是中文且不能超过10个字\n";
	}
	if(graduateSchool1.length == 0) {
		result += "毕业院校不能为空\n";
	} else if((!regCH.test(graduateSchool1)) && graduateSchool1.length <= 20) {
		result += "毕业院校只能是中文且不能超过10个字\n";
	}
	if(!regNum.test(appoCost1)) {
		result += "咨询费用必须为非零正整数且长度为1到5位\n";
	}
	if(!regNum.test(counselCost1)) {
		result += "预约费用必须为非零正整数且长度为1到5位\n";
	}
	if((!regCH.test(major1)) && major1.length >= 40 && major1.length <= 100) {
		result += "专业背景只能是中文且字数在10到50之间\n";
	}
	if((!regCH.test(intro1)) && intro1.length >= 40 && intro1.length <= 200) {
		result += "简介只能是中文且字数在20到100之间\n";
	} 
	if(result=="") {
		return true;
	} else {
		alert(result);
		return false;
	}
}
