//JS 工具集
//author huangdecai
//since 2012-03-29 
//update 2012-03-31
/**
 * 表单验证正则表达式
 */
var reg = {};
reg.emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
reg.phoneReg = /^0?(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$/;
reg.telephoneReg = /^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}/;
reg.userNameReg = /^[a-zA-Z0-9_\u4e00-\u9fa5]{2,20}$/;// 2-20位中英文字符、数字或下划线组成
reg.passwordReg = /^[a-z0-9_-]{6,18}$/;
reg.urlReg = /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/;
reg.ipReg = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
reg.htmlReg = /^<([a-z]+)([^<]+)*(?:>(.*)<\/\1>|\s+\/>)$/;
reg.intReg = /^-?\d+$/;
reg.cardIDReg =  /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
reg.realNameReg = /^[\u4e00-\u9fa5]+$/;
/**
 * 功能：获取浏览器类型
 * 
 * @return {string}
 */
function browertype() {
	var OsObject = "";
	if (navigator.userAgent.indexOf("MSIE") > 0) {
		return "MSIE";
	}
	if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
		return "Firefox";
	}
	if (isSafari = navigator.userAgent.indexOf("Safari") > 0) {
		return "Safari";
	}
	if (isCamino = navigator.userAgent.indexOf("Camino") > 0) {
		return "Camino";
	}
	if (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {
		return "Gecko";
	}
}

/**
 * 功能：通过节点ID获取节点对象
 * 
 * @param {String}
 *            ID
 * @return {object} DOM对象
 */
function $$(id) {
	var object = document.getElementById(id);
	if (object == null) {
		alert("节点ID-" + id + "未找到");
	}
	return object;
}
/**
 * 功能：通过父节点ID获取tag类型的节点 兼容ie ff
 * 
 * @param {String}
 *            pid
 * @param {String}
 *            nodeName
 * @return {Array} nodes
 */
function findChildnodes(pid, nodeName) {
	return document.getElementById(pid).getElementsByTagName(nodeName);
}

/**
 * 功能：数组给table赋值，table第一行（TR>TD[id]）为头，标明了赋值对象属性
 * 
 * @param {array}
 *            adata 必填
 * @param {string}
 *            tableNodeID("tableid") 必填
 * @param {string}
 *            elementName("INPUT") 可选
 * @return {boolean} true/false author huangdc since 2012-03-31 14:00
 */
function adata2table(adata,tableNodeID,elementName){
	var atr = findChildnodes(tableNodeID,"TR");
	if(atr.length ==0)return false;
	var atd = atr[0].getElementsByTagName("TD");
	for (var i = 0;i < adata.length;i++){
		var otr = document.createElement("TR");
		otr.id = i;
		for (var j = 0;j < atd.length;j++){
			var otd = document.createElement("TD");
			var prop = atd[j].id;
			if(!elementName){
				if(adata[i].hasOwnProperty(prop)){
					otd.innerHTML = adata[i][prop];
				}
			}else{
				var oinput = document.createElement(elementName);
				// debugger;
				if(adata[i].hasOwnProperty(prop)){
					oinput.value = adata[i][prop];
				}
				otd.appendChild(oinput);
			}
			otr.appendChild(otd);
		}
		$$(tableNodeID).appendChild(otr);
	}
	return true;
}

/**
 * 功能：各种表单验证器
 * 
 * @param {String}
 *            string 必填
 * @param {String}
 *            type(email,phone,telephone,int,idcard,chinese etc.) 必填
 * @return {boolean} true/false
 */
function check(string, type) {
	if(reg[type + "Reg"])
		return reg[type + "Reg"].test(string);
	return false;
}


/**
 * 根据〖中华人民共和国国家标准 GB
 * 11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
 * 地址码表示编码对象常住户口所在县(市、旗、区)的行政区划代码。 出生日期码表示编码对象出生的年、月、日，其中年份用四位数字表示，年、月、日之间不用分隔符。
 * 顺序码表示同一地址码所标识的区域范围内，对同年、月、日出生的人员编定的顺序号。顺序码的奇数分给男性，偶数分给女性。
 * 校验码是根据前面十七位数字码，按照ISO 7064:1983.MOD 11-2校验码计算出来的检验码。
 * 
 * 出生日期计算方法。 位的身份证编码首先把出生年扩展为4位，简单的就是增加一个19或18,这样就包含了所有1800-1999年出生的人;
 * 年后出生的肯定都是18位的了没有这个烦恼，至于1800年前出生的,那啥那时应该还没身份证号这个东东，⊙﹏⊙b汗... 下面是正则表达式:
 * 出生日期1800-2099 (18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01]) 身份证正则表达式
 * /^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i
 * 位校验规则 6位地址编码+6位出生日期+3位顺序号 位校验规则 6位地址编码+8位出生日期+3位顺序号+1位校验位
 * 
 * 校验位规则 公式:∑(ai×Wi)(mod 11)……………………………………(1) 公式(1)中：
 * i----表示号码字符从由至左包括校验码在内的位置序号； ai----表示第i位置上的号码字符值；
 * Wi----示第i位置上的加权因子，其数值依据公式Wi=2^(n-1）(mod 11)计算得出。 i 18 17 16 15 14 13 12 11 10
 * 9 8 7 6 5 4 3 2 1 Wi 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2 1
 * 
 */
//身份证号合法性验证
//支持15位和18位身份证号
//支持地址编码、出生日期、校验位验证
function IdentityCodeValid(code) { 
	var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
	var tip = "";
	var pass= true;

	if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
		tip = "身份证号格式错误";
		pass = false;
	}

	else if(!city[code.substr(0,2)]){
		tip = "地址编码错误";
		pass = false;
	}
	else{
		// 18位身份证需要验证最后一位校验位
		if(code.length == 18){
			code = code.split('');
			// ∑(ai×Wi)(mod 11)
			// 加权因子
			var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
			// 校验位
			var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
			var sum = 0;
			var ai = 0;
			var wi = 0;
			for (var i = 0; i < 17; i++)
			{
				ai = code[i];
				wi = factor[i];
				sum += ai * wi;
			}
			var last = parity[sum % 11];
			if(parity[sum % 11] != code[17]){
				tip = "校验位错误";
				pass =false;
			}
		}
	}
	//if(!pass) alert(tip);
	return pass;
}
//var c = '130981199312253466';
//var res= IdentityCodeValid(c);
//alert(res);
