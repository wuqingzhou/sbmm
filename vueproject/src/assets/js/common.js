/**
 * 作者：wuqingzhou1989@yeah.net
 * Array扩展
 * 		wqzExists：		判断指定值是否存在数组中
 * 		wqzIndexOf：		判断指定值在数组中的索引
 * 		wqzRemove：		移除数组中的某个元素
 * Date扩展
 * 		Format：		将 Date 转化为指定格式的String
 * Number扩展
 * 		toLower：	将数字转为汉字小写输出
 * 		toUpper：	将数字转为汉字大写输出
 * jQuery扩展
 * 		serializeJson：	序列化表单数据为json数据
 * getWinSearchJson		获取url中?后面的参数，结果以json数据返回，例如：www.baidu.com?a=1&b=2，返回{a:1,b:2}
 * mergeJson			将一条json数据插入一个json数组中
 * showTopLoading		在最外层window上显示loading效果
 * hideTopLoading		隐藏最外层的所有loading效果（由showTopLoading函数生成的loading效果）	
 * isArray				判断是否是数组
 * mult					两个数相乘
 * getStrByteLen        计算字符串所占字节数（不是字符串长度）
 * 
 */

/*====================================== Array 扩展 开始 =================================================*/
/*	
 * 功能：	判断指定值是否存在数组中
 * 参数：	字符串、数字、布尔值
 * 返回值：	存在则返回true，不存在则返回false
 * 扩展：	记录在数组中出现的次数
 */
Array.prototype.wqzExists?console.error("方法冲突！Array.prototype.wqzExists方法被重复定义!"):
Array.prototype.wqzExists = function(v) {
	var b = false;
	for(var i = 0; i < this.length; i++) {
		if(this[i] === v) {
			b = true;
			break;
		}
	}
	return b;
};

/*	
 * 功能：	判断指定值在数组中的索引
 * 参数：	字符串、数字、布尔值
 * 返回值：	存在则此元素在数组中的索引，不存在则返回-1，如果指定值在数组中出现过多次，则返回第一次出现的索引
 * 扩展：	如果指定值在数组中出现多次，则使用一个新数组来记录每次出现的索引
 */
Array.prototype.wqzIndexOf?console.error("方法冲突！Array.prototype.wqzIndexOf方法被重复定义!"):
Array.prototype.wqzIndexOf = function(v,startIndex) {
	for(var i = 0; i < this.length; i++) {
		if(this[i] === v){
			return i;
		} 
	}
	return -1;
};

/**
 * 功能：	移除数组中值为指定值的某个元素
 * 参数：	字符串、数字、布尔值
 * 返回值：	无返回值
 * 扩展：	支持移除数组中值为指定值的所有元素
 */
Array.prototype.wqzRemove?console.error("方法冲突！Array.prototype.wqzRemove方法被重复定义!"):
Array.prototype.wqzRemove = function(v) {
	var index = this.indexOf(v);
	if(index > -1) {
		this.splice(index, 1)
	}
};

/*====================================== Array 扩展 结束 =================================================*/
/*====================================== Date 扩展 开始 =================================================*/

/*
 * 对Date的扩展，将 Date转化为指定格式的String
 * 说明：
 * 	1. 占位符含义：年(y)、月(M)、日(d)、小时(H)、分(m)、秒(s)、季度(q)、毫秒(S)
 * 	2. 占位符分类：
 * 		（1）年(y)可能显示部分，不会填充0
 * 		（2）月(M)、日(d)、小时(H)、分(m)、秒(s)、季度(q)可能会填充0
 * 		（3）毫秒(S)总是显示实际值
 *	3. 如果占位符比年份的实际长度要长，则显示完整年份。例如：yyyyyy对应2017；MMM对应03
 * 	4. 占位符可以在多个地方出现，每处的占位符都会被匹配替换掉
 *	5. 示例： 
 * 		(new Date()).Format("yyyy-MM-dd HH:mm:ss.S q季度") ==> 2017-07-12 08:29:04.423 3季度
 * 		(new Date()).Format("yyyy-M-d H:m:s.S")      ==> 2017-7-12 8:29:4.423
 * 		(new Date()).Format("yy年M月d日 yyyy-MM-dd")  ==> 17年7月12日 2017-07-12
 */
Date.prototype.wqzFormat?console.error("方法冲突！Date.prototype.wqzFormat方法被重复定义!"):
Date.prototype.wqzFormat = function(fmt) {
	var year = this.getFullYear();
	var ms = this.getMilliseconds();
	var nstr;	// 新字符串，用来替换旧字符串
	var tv;		// 临时变量，记录o中的某个值
	var arr;	// match匹配结果
	var o = {
		"M+": this.getMonth() + 1,
		"d+": this.getDate(),
		"H+": this.getHours(),
		"m+": this.getMinutes(),
		"s+": this.getSeconds(),
		"q+": Math.floor((this.getMonth() + 3) / 3)
	};
	
	// 处理年
	arr = fmt.match(new RegExp("y+","gm"));
	tv = year.toString();
	for(var k in arr){
		nstr = "";
		nstr = tv.substring(tv.length-arr[k].length);
		fmt = fmt.replace(arr[k],nstr);
	}
	
	
	// 处理月、日、时、分、秒、季度
	for(var k in o){
		arr = fmt.match(new RegExp(k,"gm"));
		tv = o[k];
		for(var ki in arr){
			nstr = "";
			if(tv.toString().length==2){
				nstr = tv.toString();
			}else{
				nstr = (arr[ki].length>1?"0":"") + tv.toString();
			}
			fmt = fmt.replace(arr[ki],nstr);
		}
	}
	
	// 处理毫秒
	fmt = fmt.replace(new RegExp("S+","gm"),this.getMilliseconds().toString());
	
	return fmt
}

/*====================================== Date 扩展 结束 =================================================*/
/*====================================== Number 扩展 开始 =================================================*/

/**
 * 功能：	将数字转化为小写汉字
 * 参数：	普通数值，不接受指数等形式的数字
 * 例如：	123转为一百二十三
 * 			12.3转为十二点三
 * 			12345678912.3转为
 */
Number.prototype.toLowerCase?console.error("方法冲突！Number.prototype.toLowerCase方法被重复定义!"):
Number.prototype.toLowerCase = function(){
	var nArr = "1234567890.";												// 数字字符集合
	var hlArr = ["一","二","三","四","五","六","七","八","九","零","点"];		// 小写数字字符集合
	var hljwArr =["","十","百","千","万","十","百","千","亿"];				// 小写数字进位字符集合
	var LEN = hljwArr.length;												// 进位字符的个数
	
	var ns = parseFloat(this).toString();	// 将数字转为字符串。例如：.3转成"0.3"
	var dns = ns.split(".")[1];				// 数字的小数部分（字符串）
	ns = ns.split(".")[0];					// 数字的整数部分（字符串）
	
	var rs = new Array();					// 中间变量。存放结果的整数部分。例如：123-->一百二十三
	var dnsh1 = new Array();				// 中间变量。存放结果的小数部分。例如：1.23-->二三
	
	var len = ns.length;
	for(var i=0; i<len; i++){				// 123转为一二三
		var index = nArr.indexOf(ns[i]);
		rs.push(hlArr[index]);
	}
	
	var len = rs.length;
	for(var i=0; i<len; i++){				// 一二三转为一百二十三
		var index = len - i%len -1;
		if(index>=LEN){
			index = (index+1)%LEN;
		}
		rs[i] = rs[i] + hljwArr[index];
	}
	
	var cleanZero = rs.join("").replace(/(零(十|百|千|万|亿|零))+/g,"零");	// 一千零百零十零转为一千
	cleanZero = cleanZero.replace(/零+$/g,"");								// 去掉末尾的多个零
	cleanZero = cleanZero.replace(/^一十/g,"十");
	if(dns != undefined){					// 转换小数部分
		var len = dns.length;
		for(var i=0; i<len; i++){
			var index = nArr.indexOf(dns[i]);
			dnsh1.push(hlArr[index]);
		}
		return cleanZero + "点" + dnsh1.join("");
	}
	
	return cleanZero;
}

Number.prototype.toUpperCase?console.error("方法冲突！Number.prototype.toUpperCase方法被重复定义!"):
Number.prototype.toUpperCase = function(){
	var nArr = "1234567890.";												// 数字字符集合
	var hlArr = ["壹","貳","叄","肆","伍","陸","柒","捌","玖","零","點"];		// 大写数字字符集合
	var hljwArr =["","拾","佰","仟","萬","拾","佰","仟","万"];				// 大写数字进位字符集合
	var LEN = hljwArr.length;												// 进位字符的个数
	
	var ns = parseFloat(this).toString();	// 将数字转为字符串。例如：.3转成"0.3"
	var dns = ns.split(".")[1];				// 数字的小数部分（字符串）
	ns = ns.split(".")[0];					// 数字的整数部分（字符串）
	
	var rs = new Array();					// 中间变量。存放结果的整数部分。例如：123-->一百二十三
	var dnsh1 = new Array();				// 中间变量。存放结果的小数部分。例如：1.23-->二三
	
	var len = ns.length;
	for(var i=0; i<len; i++){				// 123转为一二三
		var index = nArr.indexOf(ns[i]);
		rs.push(hlArr[index]);
	}
	
	var len = rs.length;
	for(var i=0; i<len; i++){				// 一二三转为一百二十三
		var index = len - i%len -1;
		if(index>=LEN){
			index = (index+1)%LEN;
		}
		rs[i] = rs[i] + hljwArr[index];
	}
	
	var cleanZero = rs.join("").replace(/(零(拾|佰|仟|万|亿|零))+/g,"零");	// 一千零百零十零转为一千
	cleanZero = cleanZero.replace(/零+$/g,"");								// 去掉末尾的多个零
	cleanZero = cleanZero.replace(/^一拾/g,"十");
	if(dns != undefined){					// 转换小数部分
		var len = dns.length;
		for(var i=0; i<len; i++){
			var index = nArr.indexOf(dns[i]);
			dnsh1.push(hlArr[index]);
		}
		return cleanZero + "点" + dnsh1.join("");
	}
	
	return cleanZero;	
}

/*====================================== Number 扩展 结束 =================================================*/

/*====================================== jquery 扩展 开始 =================================================*/

/* 
 * 扩展jquery，序列化表单数据为json数据
 */
if($ != undefined){
	$.fn.serializeJson = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [o[this.name]];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
}

/*
 * 功能：	获取url中?后面的参数，结果以json数据返回，例如：www.baidu.com?a=1&b=2，返回{a:1,b:2}
 * 参数：	$window,一个window对象
 * 返回：	一个json格式的数据
 */
if($ != undefined){
	function getWinSearchJson($window){
		var typeJson = {};
		var type = $window.location.search.split("?")[1].split("&");
		$.each(type, function(i,v) {
			typeJson[v.split("=")[0]] = v.split("=")[1];
		});
		return typeJson;
	}
}

/*
 * 将一条json数据插入一个json数组中
 * arrayJson：一个json数组
 * formJson：一条json数据
 * 备注：
 * 1. 请确保formJson是一条json数据；
 * 2. 请确保arrayJson是一条json数据或者是一个json数组
 */
function mergeJson(arrayJson,formJson){
	var rst = [];
	var existRepeat = false;
	if(isArray(arrayJson)){
		rst = arrayJson;
	}else{
		rst.push(arrayJson);
	}
	
	$.each(rst, function(i,v) {
		if(v.fileName==formJson.fileName){
			rst[i] = formJson;
			existRepeat = true;
			return false;
		}
	});
	if(!existRepeat){
		rst.push(formJson);
	}
	return rst;
}

/*在最外层window上显示loading效果*/
if($ != undefined){
	function showTopLoading(imgPath){
		if(imgPath==undefined){
			imgPath = $base + '/resources/common/images/loading.gif';
		}
		var $target = $(window.top.document.body);
		var $loadingBox = $("<div></div>").css({
			position:	"fixed",
			width:		"100%",
			height:		"100%",
			left:		0,
			top:		0
		}).attr("data-wqzLoading","1");
		var $loadingBoxBg = $("<div></div>").css({
			position:	"absolute",
			width:		"100%",
			height:		"100%",
			left:		0,
			top:		0,
			background:	"#fff",
			opacity:	0.5,
			filter:		"alpha(opacity=50)",
			"z-index":	-1
		});
		$loadingContent = $("<img />").css({
			position:	"relative",
			display:	"block",
			width:		"32px",
			height:		"32px",
			margin:		"-16px auto 0",
			top:		"50%",
			"z-index":	1
		}).attr({
			src:	imgPath
		});
		$loadingBox.append($loadingBoxBg).append($loadingContent);
		$target.append($loadingBox);
	}
}

/*隐藏最外层的所有loading效果（由showTopLoading函数生成的loading效果）	*/
if($ != undefined){
	function hideTopLoading(){
		var $target = $(window.top.document.body);
		$target.children("div[data-wqzLoading=1]").remove();
	}
}

/*判断是否是数组*/
function isArray(object){
    return  object && typeof object==='object' &&    
            typeof object.length==='number' &&  
            typeof object.splice==='function' &&    
             //判断length属性是否是可枚举的 对于数组将得到false  
            !(object.propertyIsEnumerable('length'));
}

/**
 * 两个数字相乘
 * 功能：
 * 	解决js中四则运算时的精度问题（部分解决）
 * 	目前建议参数中全部使用普通表示法来表示的数字，不要使用指数记数法等表示，例如：1e1（1e1就是10）。
 * 例如：
 * 	0.1 * 0.2 = 0.020000000000000004
 * 	0.3 - 0.2 = 0.09999999999999998
 * 	0.1 + 0.2 = 0.30000000000000004
 * 	0.3/0.2 = 1.4999999999999998
 * @param {Object} m1
 * @param {Object} m2
 */
function mult(m1,m2){
	var strm1 = m1.toString().replace(".","");
	var strm2 = m2.toString().replace(".","");
	var s1 = parseInt(strm1);
	var s2 = parseInt(strm2);
	
	var cd1 = m1.toString().split(".")[1];
	var cd2 = m2.toString().split(".")[1];
	var len1 = cd1==undefined?0:cd1.length;
	var len2 = cd2==undefined?0:cd2.length;
	var div1 = Math.pow(10,len1);
	var div2 = Math.pow(10,len2);
	
	var rst = s1*s2/(div1*div2);
	return rst;
}

/*
 * 计算字符串所占字节数（不是字符串长度）
 * 例如：
 * 	如果参数str不是字符串（str为undefined、null、函数等），则返回结果为0
 * 	"abc"，字符串长度为3，所占字节数为3
 * 	"中国",字符串长度为2,所占字节数为4（因为“中国”是汉字，一个汉字占两个字节）
 * 	"abc，d,e"，字符串长度为7，所占字节数为8（因为中文逗号占了两个字节）
 */
function getStrByteLen(str){
	if(typeof str !== "string"){
		console.error("计算字符串所占字节数时，字符串参数错误！");
		return 0;
	}
	var szjArr = str.match(/[^\x00-\xff]/g);
	var szjLen = 0;
	if(szjArr!=null){
		szjLen = szjArr.length;
	}
	return str.length + szjLen;
}

/************************************************************************************/