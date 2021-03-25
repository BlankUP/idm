var cnmsg = {
		required: "必需填写项",  
		remote: "请修正该字段", 
		email: "请输入正确格式的电子邮件", 
		url: "请输入合法的网址",  
		date: "请输入合法的日期",  
		dateISO: "请输入合法的日期 (ISO).", 
		number: "请输入合法的数字",  
		digits: "只能输入整数",   
		creditcard: "请输入合法的信用卡号",   
		equalTo: "请再次输入相同的值",   
		accept: "请输入拥有合法后缀名的文件", 
		maxlength: jQuery.format("请输入一个长度最多是 {0} 的字符串"), 
		minlength: jQuery.format("请输入一个长度最少是 {0} 的字符串"),  
		rangelength: jQuery.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),  
		range: jQuery.format("请输入一个介于 {0} 和 {1} 之间的值"), 
		max: jQuery.format("请输入一个最大为 {0} 的值"), 
		min: jQuery.format("请输入一个最小为 {0} 的值"),   
		//自定义验证方法的提示信息   
		stringCheck: "用户名只能包括中文字、英文字母、数字和下划线",  
		ipstr:"IP必须符合规范",
};
jQuery.extend(jQuery.validator.messages, cnmsg); 
//字符验证 
jQuery.validator.addMethod("stringCheck", function(value, element) { 
	return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);   
	}, "只能包括中文字、英文字母、数字和下划线"); 

var ipstr="^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
jQuery.validator.addMethod("ipstr", function(value, element) { 
	return value.match(ipstr);   
	}, "IP必须符合规范"); 

var codestr="^[a-zA-Z0-9\d_]*$";
jQuery.validator.addMethod("codestr", function(value, element) { 
	return value.match(codestr);   
	}, "只能输入数字、字母、下划线"); 
