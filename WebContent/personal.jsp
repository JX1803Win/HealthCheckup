<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*,org.xmgreat.bean.UserAccoutBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心</title>
<link href="../css/percss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.8.3-min.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/birthday.js"></script>
<script>
	function setTab(name, cursel) {
		cursel_0 = cursel;
		for (var i = 1; i <= links_len; i++) {
			var menu = document.getElementById(name + i);
			var menudiv = document.getElementById("con_" + name + "_" + i);
			if (i == cursel) {
				menu.className = "off";
				menudiv.style.display = "block";
			} else {
				menu.className = "";
				menudiv.style.display = "none";
			}
		}
	}
	function Next() {
		cursel_0++;
		if (cursel_0 > links_len)
			cursel_0 = 1
		setTab(name_0, cursel_0);
	}
	var name_0 = 'one';
	var cursel_0 = 1;
	//循环周期，可任意更改（毫秒）
	var links_len, iIntervalId;
	onload = function() {
		var links = document.getElementById("tab1").getElementsByTagName('li')
		links_len = links.length;
		for (var i = 0; i < links_len; i++) {
			links[i].onmouseover = function() {
				clearInterval(iIntervalId);
				this.onmouseout = function() {

				}
			}
		}
		document.getElementById("con_" + name_0 + "_" + links_len).parentNode.onmouseover = function() {
			clearInterval(iIntervalId);
			this.onmouseout = function() {

			}
		}
		setTab(name_0, cursel_0);

	}
</script>
<script language="javascript" type="text/javascript">
	//定义 城市 数据数组
	cityArray = new Array();
	cityArray[0] = new Array("北京市",
			"东城区|西城区|朝阳区|海淀区|丰台区|石景山区|房山区|通州区|顺义区|大兴区|昌平区|平谷区|怀柔区|门头沟区|密云县|延庆县");
	cityArray[1] = new Array("上海市",
			" 黄浦区|卢湾区|徐汇区|长宁区|静安区|普陀区|闸北区|虹口区|杨浦区|宝山区|闵行区|嘉定区|浦东新区|松江区|金山区|青浦区|南汇区|奉贤区");
	cityArray[2] = new Array("天津市",
			"和平区|河西区|河东区|河北区|南开区|红桥区|东丽区|西青区|北辰区|津南区|塘沽区|大港区|汉沽区");
	cityArray[3] = new Array(
			"重庆市",
			"渝中区|大渡口区|江北区|沙坪坝区|九龙坡区|南岸区|北碚区|綦江区|双桥区|渝北区|巴南区|万州区|涪陵区|黔江区|长寿区|江津区|合川区|永川区|南川区");
	cityArray[4] = new Array("河北省", "石家庄|唐山|秦皇岛|邯郸|邢台|保定|张家口|承德|沧州|廊坊|衡水");
	cityArray[5] = new Array("山西省", "太原|大同|阳泉|长治|晋城|朔州|晋中|运城|忻州|临汾|吕梁");
	cityArray[6] = new Array("内蒙古",
			"呼和浩特|包头|乌海|赤峰|通辽|鄂尔多斯|呼伦贝尔|巴彦淖尔|乌兰察布|兴安|锡林郭勒|阿拉善");
	cityArray[7] = new Array("辽宁省",
			"沈阳|大连|鞍山|抚顺|本溪|丹东|锦州|营口|阜新|辽阳|盘锦|铁岭|朝阳|葫芦岛");
	cityArray[8] = new Array("吉林省", "长春|吉林|四平|辽源|通化|白山|松原|白城|延边");
	cityArray[9] = new Array("黑龙江",
			"哈尔滨|齐齐哈尔|鸡西|鹤岗|双鸭山|大庆|伊春|佳木斯|七台河|牡丹江|黑河|绥化|大兴安岭");
	cityArray[10] = new Array("江苏省", "南京|无锡|徐州|常州|苏州|南通|连云港|淮安|盐城|扬州|镇江|泰州|宿迁");
	cityArray[11] = new Array("浙江省", "杭州|宁波|温州|嘉兴|湖州|绍兴|金华|衢州|舟山|台州|丽水");
	cityArray[12] = new Array("安徽省",
			"合肥|芜湖|蚌埠|淮南|马鞍山|淮北|铜陵|安庆|黄山|滁州|阜阳|宿州|巢湖|六安|亳州|池州|宣城");
	cityArray[13] = new Array("福建省", "福州|厦门|莆田|三明|泉州|漳州|南平|龙岩|宁德");
	cityArray[14] = new Array("江西省", "南昌|景德镇|萍乡|九江|新余|鹰潭|赣州|吉安|宜春|抚州|上饶");
	cityArray[15] = new Array("山东省",
			"济南|青岛|淄博|枣庄|东营|烟台|潍坊|威海|济宁|泰安|日照|莱芜|临沂|德州|聊城|滨州|菏泽");
	cityArray[16] = new Array("河南省",
			"郑州|开封|洛阳|平顶山|安阳|鹤壁|新乡|焦作|濮阳|许昌|漯河|三门峡|南阳|商丘|信阳|周口|驻马店|济源");
	cityArray[17] = new Array("湖北省", "武汉|黄石|襄樊|十堰|荆州|宜昌|荆门|鄂州|孝感|黄冈|咸宁|随州|恩施");
	cityArray[18] = new Array("湖南省",
			"长沙|株洲|湘潭|衡阳|邵阳|岳阳|常德|张家界|益阳|郴州|永州|怀化|娄底|湘西");
	cityArray[19] = new Array("广东省",
			"广州|深圳|珠海|汕头|韶关|佛山|江门|湛江|茂名|肇庆|惠州|梅州|汕尾|河源|阳江|清远|东莞|中山|潮州|揭阳云浮");
	cityArray[20] = new Array("广西省",
			"南宁|柳州|桂林|梧州|北海|防城港|钦州|贵港|玉林|百色|贺州|河池|来宾|崇左");
	cityArray[21] = new Array("海南省", "海口|三亚");
	cityArray[22] = new Array("四川省",
			"成都|自贡|攀枝花|泸州|德阳|绵阳|广元|遂宁|内江|乐山|南充|宜宾|广安|达州|眉山|雅安|巴中|资阳|阿坝|甘孜凉山");
	cityArray[23] = new Array("贵州省", "贵阳|六盘水|遵义|安顺|铜仁|毕节|黔西南|黔东南|黔南");
	cityArray[24] = new Array("陕西省", "西安|铜川|宝鸡|咸阳|渭南|延安|汉中|榆林|安康|商洛");
	cityArray[25] = new Array("甘肃省", "兰州|嘉峪关|金昌|白银|天水|武威|张掖|平凉");
	cityArray[26] = new Array("云南省",
			"昆明市|大理市|曲靖市|玉溪市|昭通市|楚雄市|红河市|文山市|思茅市|西双版纳市|保山市|德宏市|丽江市|怒江市|迪庆市|临沧市");
	cityArray[27] = new Array("其它", "其它");

	function getCity(currProvince) {
		//当前 所选择 的 省
		var currProvince = currProvince;
		var i, j, k;
		//清空 城市 下拉选单
		document.all.selCity.length = 0;
		for (i = 0; i < cityArray.length; i++) {
			//得到 当前省 在 城市数组中的位置
			if (cityArray[i][0] == currProvince) {
				//得到 当前省 所辖制的 地市
				tmpcityArray = cityArray[i][1].split("|")
				for (j = 0; j < tmpcityArray.length; j++) {
					//填充 城市 下拉选单
					document.all.selCity.options[document.all.selCity.length] = new Option(
							tmpcityArray[j], tmpcityArray[j]);
				}
			}
		}
	}
</script>



<script>
	//获得request对象		
		
	function nextPage(page) {
		page++;
		$.ajax({
			url : "nextpage.action",
			data : "page=" + 0,
			dataType : "text",
			type : "post",
			success : function(redata) {
			}
		});
	}
</script>



<script>
	function checkpwd() {
		var initpass = document.getElementById('initpass').value;
		var newpass = document.getElementById('newpass').value;
		var repass = document.getElementById('repass').value;
		if (initpass == null || initpass == "" || initpass == "null") {
			alert("请输入密码");
			return false;
		}
		if (newpass == null || newpass == "" || newpass == "null") {
			alert("请输入密码");
			return false;
		}
		if (newpass != repass) {
			alert("两次密码不一致");
			return false;
		}
		$.ajax({
			url : "chengepsw.action",
			data : "initpass=" + initpass + "&newpass=" + newpass,
			dataType : "text",
			type : "post",
			success : function(redata) {
				if (redata == "\"否\"") {
					alert("原密码错误");
					return false;
				} else {
					alert("修改成功");
				}
			}
		});

	}
</script>


<script>
	function chengeinfo() {
		var phone = document.getElementById('phone').value;
		var sex = $('input[name="sex"]:checked').val();
		var blood = document.getElementById('blood').value;
		var dizhi = document.getElementById('dizhi').value;
		var selYear = document.getElementById('selYear').value;
		var selMonth = document.getElementById('selMonth').value;
		var selDay = document.getElementById('selDay').value;
		$.ajax({
			url : "chengeinfo.action",
			data : "sex=" + sex + "&phone=" + phone + "&blood=" + blood
					+ "&dizhi=" + dizhi + "&selYear=" + selYear + "&selMonth="
					+ selMonth + "&selDay=" + selDay,
			dataType : "text",
			type : "post",
			success : function(redata) {

				alert("修改成功");

			}
		});
	}
</script>


</head>


<body>

	<div id="content">
		<div class="tab1" id="tab1">
			<div class="menu">
				<ul>
					<li id="one1" onclick="setTab('one',1)">资料更改</li>
					<li id="one2" onclick="setTab('one',2)">密码更改</li>
					<li id="one3" onclick="setTab('one',3)">我的账户</li>
					<li id="one4" onclick="setTab('one',4)">QAQ</li>
				</ul>
			</div>
			<div class="menudiv">
				<div id="con_one_1">
					<div id="1">
						<table width="500" border="0" cellpadding="0" cellspacing="0"
							align="center">
							<tr>
								<td style="white-space: nowrap;" width="142" align="right">用户名：</td>
								<td width="352"><input type="text" disabled="disabled"
									style="width: 200; height: 40"
									value="${sessionScope.user.userName}" size="30" /></td>
							</tr>

							<tr>
								<td style="white-space: nowrap;" height="30" align="right">手机号：</td>
								<td><input type="text" name="phone" id="phone"
									disabled="disabled" value="${sessionScope.user.phone}"
									size="30" /></td>
							</tr>
							<tr>
								<td style="white-space: nowrap;" height="30" align="right">性别：</td>
								<td><label> <input type="radio" name="sex"
										value="男" id="sex" checked="true" /> 男
								</label> <label> <input type="radio" name="sex" value="女"
										id="sex1" /> 女
								</label></td>
							</tr>
							<tr>
								<td style="white-space: nowrap;" align="right">血型:</td>
								<td><select name="blood" id="blood" style='width: 173px;'>
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="O">O</option>
										<option value="AB">AB</option>
								</select></td>
								</p>
								</td>
							</tr>
							<tr>
								<td style="white-space: nowrap;" align="right">出生日期:</td>
								<td><select id="selYear"></select>年 <select id="selMonth"></select>月
									<select id="selDay"></select>日 <script type="text/javascript">
										var selYear = window.document
												.getElementById("selYear");
										var selMonth = window.document
												.getElementById("selMonth");
										var selDay = window.document
												.getElementById("selDay");
										// 新建一个DateSelector类的实例，将三个select对象传进去
										new DateSelector(selYear, selMonth,
												selDay, 1994, 3, 25);
									</script></td>

							</tr>
							<tr>
								<td style="white-space: nowrap;" height="28" align="right">所在地：</td>
								<td><select id="selProvince"
									onChange="getCity(this.options[this.selectedIndex].value)">
										<option value="">-请选择-</option>
										<option value="北京市">北京市</option>
										<option value="上海市">上海市</option>
										<option value="天津市">天津市</option>
										<option value="重庆市">重庆市</option>
										<option value="河北省">河北省</option>
										<option value="内蒙古">内蒙古</option>
										<option value="吉林省">吉林省</option>
										<option value="辽宁省">辽宁省</option>
										<option value="黑龙江">黑龙江</option>
										<option value="江苏省">江苏省</option>
										<option value="浙江省">浙江省</option>
										<option value="安徽省">安徽省</option>
										<option value="福建省">福建省</option>
										<option value="江西省">江西省</option>
										<option value="山东省">山东省</option>
										<option value="河南省">河南省</option>
										<option value="湖北省">湖北省</option>
										<option value="湖南省">湖南省</option>
										<option value="广东省">广东省</option>
										<option value="广西省">广西省</option>
										<option value="海南省">海南省</option>
										<option value="四川省">四川省</option>
										<option value="贵州省">贵州省</option>
										<option value="陕西省">陕西省</option>
										<option value="甘肃省">甘肃省</option>
										<option value="云南省">云南省</option>
										<option value="其它">其它</option>
								</select> <select id="selCity">
										<option>-城市-</option>
								</select></td>
							</tr>
							<tr>
								<td style="white-space: nowrap;" height="30" align="right">地址：</td>
								<td><input type="text" name="dizhi" id="dizhi" size="30"
									value="${sessionScope.user.useradd}" /></td>
							</tr>



						</table>
					</div>
					<div style="text-align: center; margin-top: 50px;"
						class="subtijiao">
						<input type="button" onClick="chengeinfo()" value="提交" />
					</div>
					<div id="bc01"></div>
				</div>
				<div id="con_one_2" style="display: none;">
					<div id="1" style="margin-top: 100px;">
						<table width="500" border="0" cellpadding="0" cellspacing="0"
							align="center">
							<tr>
								<td width="142" align="right">初始密码：</td>
								<td width="352"><input type="password" id="initpass"
									name="initpass" style="width: 200; height: 40" value=""
									size="30" /></td>
							</tr>
							<td height="30" align="right">新密码：</td>
							<td><input type="password" id="newpass" name="newpass"
								size="30" /></td>
							</tr>
							<td height="30" align="right">确认密码：</td>
							<td><input type="password" id="repass" name="repass"
								size="30" /></td>
							</tr>
						</table>
					</div>
					<div style="text-align: center; margin-top: 50px;"
						class="subtijiao">
						<input type="button" onClick="checkpwd()" value="提交" />
					</div>
					<div id="bc01"></div>
				</div>


				<div id="con_one_3" style="display: none;">

					<c:if test="${not empty accoutlist}">

						<table width="500xp" align="center" high="200xp" border="1"
							style="margin-top: 20px" cellspacing="0">
							<tr>
								<th align="center">发生时间</th>
								<th align="center">发生事项</th>
								<th align="center">金&emsp;&emsp;额</th>
								<th align="center">余&emsp;&emsp;额</th>
							</tr>
							<c:forEach items="${accoutlist}" var="acc">
								<tr align="center">
									<td>${acc.getOccurTime()}</td>
									<td>${acc.getOccurMatter()}</td>
									<td>${acc.getMoney()}</td>
									<td>${acc.getBalance()}</td>
								</tr>

							</c:forEach>

						</table>	
						<div style="text-align: center; margin-top: 50px;"
						class="subtijiao">
						<tr>
						<td>&emsp;&emsp;
						<button type="button" onClick="">上一页</button>
						&emsp;&emsp;
						<button type="button" onClick="nextPage(${sessionScope.page})">下一页</button>
						</td>
						</tr>
						</div>
					</c:if>
					
					<c:if test="${empty accoutlist}">
						<h3 align="center">暂无账户记录</h3>
					</c:if>
				</div>

				<div id="con_one_4" style="display: none;">QAQ</div>
			</div>
		</div>
	</div>
</body>
</html>