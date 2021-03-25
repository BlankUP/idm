(function(){
	var DateUtil = window.DateUtil = function(){}
	
	DateUtil.firstMonthDate=function(date){
		var d = new Date(date);
		d.setDate(1);
		return d;
	}

	//取得月末
	DateUtil.lastMonthDate=function(date){
		var lastDate = new Date(date);
		lastDate.setMonth(date.getMonth()+1);
		lastDate.setDate(0);
		return lastDate;
	};

	DateUtil.addMonth = function(date,num){
		var x = date.getMonth() + num;
		var result = new Date(date);
		var day = date.getDate();
		result.setDate(1);
		if(x<0){
			result.setFullYear(result.getFullYear()+(x - x%12)/12 - 1);
			result.setMonth(12+x%12);
		}else{
			result.setFullYear(result.getFullYear()+(x-x%12)/12);
			result.setMonth(x%12);
		}
		var lastDate = DateUtil.lastMonthDate(result);
		if(lastDate.getDate() < day){
			return lastDate;
		}
		result.setDate(day);
		return result;
	}

	DateUtil.addDate = function(date,num){
		var td = (date.getDate() + num);
		var result = new Date(date);
		if(num<0){
			if(td<0){
				result.setDate(0);
				result.setDate(result.getDate()+td);
			}else{
				result.setDate(result.getDate()+num);
			}
			
		}else{
			var d = DateUtil.lastMonthDate(date);
			if(td>d.getDate()){
				result.setMonth(result.getMonth()+1);
				result.setDate(td-d.getDate());
			}else{
				result.setDate(resultDate()+num);
			}
		}
		return result;
	}

	//小时
	DateUtil.addHour = function(date,num){
		var td = (date.getDate() + num);
		var result = new Date(date);
		if(num<0){
			if(td<0){
				result.setDate(0);
				result.setDate(result.getDate()+td);
			}else{
				result.setDate(result.getDate()+num);
			}
			
		}else{
			var d = DateUtil.lastMonthDate(date);
			if(td>d.getDate()){
				result.setMonth(result.getMonth()+1);
				result.setDate(td-d.getDate());
			}else{
				result.setDate(resultDate()+num);
			}
		}
		return result;
	}
	//分钟
	DateUtil.addMinutes = function(date,num){
		var td = (date.getDate() + num);
		var result = new Date(date);
		if(num<0){
			if(td<0){
				result.setDate(0);
				result.setDate(result.getDate()+td);
			}else{
				result.setDate(result.getDate()+num);
			}
			
		}else{
			var d = DateUtil.lastMonthDate(date);
			if(td>d.getDate()){
				result.setMonth(result.getMonth()+1);
				result.setDate(td-d.getDate());
			}else{
				result.setDate(resultDate()+num);
			}
		}
		return result;
	}

	var dateFormatSetting={
		match_queue:["yyyy","yy","y","MM","M","dd","d","HH","hh","mm","ss","S"],
		parser:{
			'yyyy':{format:function(date){
					return date.getFullYear()+"";
				},parse:function(date,val){
			 		date.setFullYear(parseInt(val,10));
					return date;
				},length:4},
			'yy':{format:function(date){
					return (date.getFullYear()+"").substring(2);
				},parse:function(date,val){
					date.setFullYear(parseInt("19"+val,10));
					return date;
				},length:2},
			'y':{format:function(date){
					return date.getFullYear() + "";
				},parse:function(date,val){
					date.setFullYear(parseInt(val,10));
					return date;
				},length:4},
			'dd':{format:function(date){
					return date.getDate()<10 ?"0"+date.getDate():date.getDate()+"";
				},parse:function(date,val){
					date.setDate(parseInt(val,10));
					return date;
				},length:2},
			'd':{format:function(date){
					return date.getDate() + "";
				},parse:function(date,val){
					date.setDate(parseInt(val,10));
					return date;
				}},
			'MM':{format:function(date){
					return (date.getMonth()+1)<10 ? "0"+(date.getMonth()+1):(date.getMonth()+1)+"";
				},parse:function(date,val){
					date.setMonth(parseInt(val,10)-1);
					return date;
				},length:2},
			'M':{format:function(date){
					return (date.getMonth()+1)+"";
				},parse:function(date,val){
					date.setMonth(parseInt(val,10)-1);
					return date;
				}},
			//时(24小时制)
			'HH':{format:function(date){
					return date.getHours()<10?"0"+date.getHours():""+date.getHours();
				},parse:function(date,val){
					date.setHours(parseInt(val,10));
					return date;
				},length:2},
			//时
			'hh':{format:function(date){
					var hours = date.getHours() % 12;
					if(hours){
						hours = 12;
					}
					return hours<10?"0"+hours:""+hours;
				},parse:function(date,val){
					date.setHours(parseInt(val,10));
					return date;
				},length:2},
			//分
			'mm':{format:function(date){
					return date.getMinutes()<10?"0"+date.getMinutes():date.getMinutes()+"";
				},parse:function(date,val){
					date.setMinutes(parseInt(val,10));
					return date;
				},length:2},
			//秒
			'ss':{format:function(date){
					return date.getSeconds()<10?"0"+date.getSeconds():date.getSeconds()+"";
				},parse:function(date,val){
					date.setSeconds(parseInt(val,10));
					return date;
				},length:2},
			//毫秒数
			'S':{format:function(date){
					return date.getMilliseconds()+"";
				},parse:function(date,val){
					date.setMilliseconds(parseInt(val,10));
					return date;
				}}
			
		}
	};

	DateUtil.format = function(date,format){
		//如果是字符串，则直接返回
		if(typeof(date) == 'string'){
			return date;
		}

		var result = format;
		var que = dateFormatSetting.match_queue;
		for(var i=0;i<que.length;i++){
			if(result.match(que[i])){
				var snap = dateFormatSetting.parser[que[i]].format(date);
				result = eval("result.replace(/"+que[i]+"/g,snap)");
			}
		}
		return result;
//		yyyy MM dd
	}

	DateUtil.parse = function(date,format){
		if(!format){
			if(date.length==8){
				return DateUtil.parse(date,"yyyyMMdd");
			}else if(date.length == 10){
				return DateUtil.parse(date,"yyyy-MM-dd");
			}
			return;
		}
		var _fmt = format;
		var result = new Date(0);
		var que = dateFormatSetting.match_queue;
		for(var i=0;i<que.length;i++){
			var idx = _fmt.indexOf(que[i])
			var parser = dateFormatSetting.parser[que[i]];
			if(idx!=-1 && parser.length){
				parser.parse(result,date.substring(idx,idx+parser.length));
				_fmt = _fmt.replace(que[i],fillBefore("0","0",parser.length));
			}
		}
		return result;
	}

	var fillBefore = function(str,chr,size){
		var offset = size - str.length;
		if(offset>0){
			var fills = [];
			for(var i=0;i<offset;i++){
				fills[i]=chr;
			}
			return fills.join("") + str;
		}
	}

})();

(function($){

	//分级模型
	var level_models = {
		"S":{
			//秒
			show:function(datepicker){
				$dom = datepicker.getdom();
				var current = datepicker.status.current;
				$dom.find(".datepicker-header > .title").html(DateUtil.format(current,"yyyy-MM-dd HH:mm"));
				var html = '<ul class="datepicker-minutes">'
				for(var i=0;i<=59;i++){
					html+= '<li class="optional '+(current.getSeconds()==i?"active":"")+'" seconds="'+i+'" title="'+i+" "+datepicker.i18n().Second+'">' + i + '</li>';
				}
				html+='</ul>';
				$content = $dom.find(".datepicker-content");
				$content.empty();
				$content.append($(html));

				$content.find(".optional").click(function(){
					if(datepicker.status.level == datepicker.setting.level){
						var result = new Date();
						result.setTime(current.getTime());
						result.setSeconds(parseInt($(this).attr("seconds"),10));
						datepicker.status.current = result;
						datepicker.onselect(result);
					}
				});
			},
			parent:function(datepicker){
				datepicker.status.level = 'MI';
				datepicker.status.get_level_model().show(datepicker);
			},
			next:function(datepicker){
				datepicker.status.current = DateUtil.addSecond(datepicker.status.current,1);
				this.show(datepicker);
			},
			prev:function(datepicker){
				datepicker.status.current = DateUtil.addSecond(datepicker.status.current,-1);
				this.show(datepicker);
			}
		},
		"MI":{
			//分
			show:function(datepicker){
				$dom = datepicker.getdom();
				var current = datepicker.status.current;
				$dom.find(".datepicker-header > .title").html(DateUtil.format(current,"yyyy-MM-dd HH"));
				var html = '<ul class="datepicker-minutes">'
				for(var i=0;i<=59;i++){
					html+= '<li class="optional '+(current.getMinutes()==i?"active":"")+'" minutes="'+i+'" title="'+i+" "+datepicker.i18n().Minute+'">' + i + '</li>';
				}
				html+='</ul>';
				$content = $dom.find(".datepicker-content");
				$content.empty();
				$content.append($(html));

				$content.find(".optional").click(function(){
					if(datepicker.status.level == datepicker.setting.level){
						var result = new Date();
						result.setTime(current.getTime());
						result.setMinutes(parseInt($(this).attr("minutes"),10));
						datepicker.status.current = result;
						datepicker.onselect(result);
					}else{
						datepicker.status.current.setMinutes(parseInt($(this).attr("minutes"),10));
						datepicker.status.level = 'S';
						datepicker.status.get_level_model().show(datepicker);
					}
				});
			},
			parent:function(datepicker){
				datepicker.status.level = 'H';
				datepicker.status.get_level_model().show(datepicker);
			},
			next:function(datepicker){
				datepicker.status.current = DateUtil.addDate(datepicker.status.current,1);
				this.show(datepicker);
			},
			prev:function(datepicker){
				datepicker.status.current = DateUtil.addDate(datepicker.status.current,-1);
				this.show(datepicker);
			}
		},
		"H":{
			//时
			show:function(datepicker){
				$dom = datepicker.getdom();
				var current = datepicker.status.current;
				$dom.find(".datepicker-header > .title").html(DateUtil.format(current,"yyyy-MM-dd"));
				var html = '<ul class="datepicker-hours">'
				for(var i=0;i<12;i++){
					html+= '<li class="optional '+(current.getHours()==i?"active":"")+'" hours="'+i+'" title="'+i+" "+datepicker.i18n().Hours+'">' + i + '</li>';
				}
				for(var i=1;i<=12;i++){
					html+= '<li class="optional '+((current.getHours()-11)==i?"active":"")+'" hours="'+(i+11)+'" title="'+(i+11)+" "+datepicker.i18n().Hours+'">' + (i+11) + '</li>';
				}
				html+='</ul>';
				$content = $dom.find(".datepicker-content");
				$content.empty();
				$content.append($(html));

				$content.find(".optional").click(function(){
					if(datepicker.status.level == datepicker.setting.level){
						var result = new Date();
						result.setTime(current.getTime());
						result.setHours(parseInt($(this).attr("hours"),10));
						datepicker.status.current = result;
						datepicker.onselect(result);
					}else{
						datepicker.status.current.setHours(parseInt($(this).attr("hours"),10));
						datepicker.status.level = 'MI';
						datepicker.status.get_level_model().show(datepicker);
					}
				});
			},
			parent:function(datepicker){
				datepicker.status.level = 'D';
				datepicker.status.get_level_model().show(datepicker);
			},
			next:function(datepicker){
				datepicker.status.current = DateUtil.addDate(datepicker.status.current,1);
				this.show(datepicker);
			},
			prev:function(datepicker){
				datepicker.status.current = DateUtil.addDate(datepicker.status.current,-1);
				this.show(datepicker);
			}
		},
		"D":{
			//日
			show:function(datepicker){

				var current = datepicker.status.current;
				
				var wk_html = '<ul class="datepicker-week">'
				for(var i=0;i<datepicker.i18n().WeekNameMin.length;i++){
					wk_html+= '<li title="'+datepicker.i18n().WeekName[i]+'">' + datepicker.i18n().WeekNameMin[i] + '</li>';
				}
				wk_html+='</ul>';
				wk_html+='<ul class="datepicker-days">';
				var dates = days(current);
				for(var i=0;i<dates.length;i++){
					wk_html += '<li year="'+current.getFullYear()+'" month="'+dates[i].getMonth()+'" date="'+dates[i].getDate()+'" class="'+(dates[i].getMonth() == current.getMonth()?(dates[i].getDate()==current.getDate()?'optional active':'optional'):"")+'" title="'+DateUtil.format(dates[i],datepicker.setting.format)+'">'+dates[i].getDate()+'</li>';
				}
				wk_html+='</ul>';

				$dom = datepicker.getdom();
				$dom.find(".datepicker-header > .title").html(DateUtil.format(datepicker.status.current,"yyyy-MM"));
				$content = $dom.find(".datepicker-content");
				$content.empty();
				$content.append($(wk_html));
				$this = this;
				$content.find(".optional").click(function(){
					if(datepicker.status.level == datepicker.setting.level){
						var result = new Date();
						result.setTime(0);
						result.setFullYear(parseInt($(this).attr("year"),10));
						result.setMonth(parseInt($(this).attr("month"),10));
						result.setDate(parseInt($(this).attr("date"),10));
						datepicker.status.current = result;
						datepicker.onselect(result);
						return;
					}
					datepicker.status.current.setDate(parseInt($(this).attr("date"),10));
					datepicker.status.level = 'H';
					datepicker.status.get_level_model().show(datepicker);
				});
			},
			parent:function(datepicker){
				datepicker.status.level = 'M';
				datepicker.status.get_level_model().show(datepicker);
			},
			next:function(datepicker){
				datepicker.status.current = DateUtil.addMonth(datepicker.status.current,1);
				this.show(datepicker);
			},
			prev:function(datepicker){
				datepicker.status.current = DateUtil.addMonth(datepicker.status.current,-1);
				this.show(datepicker);
			}
		},
		"M":{
			//月
			show:function(datepicker){
				$dom = datepicker.getdom();
				var current = datepicker.status.current;
				$dom.find(".datepicker-header > .title").html(current.getFullYear());
				var html = '<ul class="datepicker-months">'
				for(var i=0;i<datepicker.i18n().MonthName.length;i++){
					html+= '<li class="optional '+(current.getMonth()==i?"active":"")+'" year="'+current.getFullYear()+'" month="'+i+'" title="'+datepicker.i18n().MonthName[i]+'">' + datepicker.i18n().MonthName[i] + '</li>';
				}
				html+='</ul>';
				$content = $dom.find(".datepicker-content");
				$content.empty();
				$content.append($(html));

				$content.find(".optional").click(function(){
					if(datepicker.status.level == datepicker.setting.level){
						var result = new Date();
						result.setTime(0);
						result.setFullYear(parseInt($(this).attr("year"),10));
						result.setMonth(parseInt($(this).attr("month"),10));
						datepicker.status.current = result;
						datepicker.onselect(result);
					}else{
						datepicker.status.current.setMonth(parseInt($(this).attr("month"),10));
						datepicker.status.level = 'D';
						datepicker.status.get_level_model().show(datepicker);
					}
				});
			},
			next:function(datepicker){
				datepicker.status.current.setFullYear(datepicker.status.current.getFullYear()+1);
				this.show(datepicker);
			},
			prev:function(datepicker){
				datepicker.status.current.setFullYear(datepicker.status.current.getFullYear()-1);
				this.show(datepicker);
			},
			parent:function(datepicker){
				datepicker.status.level='Y';
				datepicker.status.yearRange = null;
				datepicker.status.get_level_model().show(datepicker);
			}
		},
		"Y":{
			//年
			show:function(datepicker){
				$dom = datepicker.getdom();
				var current = datepicker.status.current;
				if(!datepicker.status.yearRange){
					datepicker.status.yearRange = [current.getFullYear() - 4,current.getFullYear() + 5];
				}
				
				$dom.find(".datepicker-header > .title").html(datepicker.status.yearRange.join("-"));
				var html = '<ul class="datepicker-years">';

				var minYear = datepicker.status.yearRange[0]-1;
				var maxYear = datepicker.status.yearRange[1]+1;
				for(var i=minYear;i<=maxYear;i++){
					html+= '<li class="'+(minYear==i||i==maxYear?"":"optional")+' '+(i==current.getFullYear()?"active":"")+'" year="'+i+'" title="'+i+'">' + i + '</li>';
				}
				html+='</ul>';
				$content = $dom.find(".datepicker-content");
				$content.empty();
				$content.append($(html));

				$content.find(".optional").click(function(){
					if(datepicker.status.level == datepicker.setting.level){
						var result = new Date();
						result.setTime(0);
						result.setFullYear(parseInt($(this).attr("year"),10));
						datepicker.status.current = result;
						datepicker.onselect(result);
					}else{
						datepicker.status.current.setFullYear(parseInt($(this).attr("year"),10));
						datepicker.status.level = 'M';
						datepicker.status.get_level_model().show(datepicker);
					}
				});
			},
			next:function(datepicker){
				datepicker.status.yearRange[0]=datepicker.status.yearRange[0]+10;
				datepicker.status.yearRange[1]=datepicker.status.yearRange[1]+10;
				this.show(datepicker);
			},
			prev:function(datepicker){
				datepicker.status.yearRange[0]=datepicker.status.yearRange[0]-10;
				datepicker.status.yearRange[1]=datepicker.status.yearRange[1]-10;
				this.show(datepicker);
			},
			parent:function(datepicker){
				datepicker.status.level='T';
				datepicker.status.yearRange = null;
				datepicker.status.get_level_model().show(datepicker);
			}
		},
		"T":{
			//十年
			show:function(datepicker){
				$dom = datepicker.getdom();
				var current = datepicker.status.current;
				if(!datepicker.status.yearRange){
					datepicker.status.yearRange = [current.getFullYear() - 44,current.getFullYear() + 55];
				}
				var minYear = datepicker.status.yearRange[0]-10;
				var maxYear = datepicker.status.yearRange[1]+10;

				$dom.find(".datepicker-header > .title").html(datepicker.status.yearRange.join("-"));
				var html = '<ul class="datepicker-years">';
				for(var i=minYear;i<=maxYear;i=i+10){
					html+= '<li class="'+(minYear==i||i+9==maxYear?"":"optional")+' '+(current && current.getFullYear()>=i && current.getFullYear()<=i+9?"active":"")+'" min="'+i+'" max="'+(i+9)+'" title="'+i +"-"+ (i+9)+'">' + i +"-"+ (i+9) + '</li>';
				}
				html+='</ul>';
				$content = $dom.find(".datepicker-content");
				$content.empty();
				$content.append($(html));

				$content.find(".optional").click(function(){
					var range = [parseInt(this.getAttribute("min"),10),parseInt(this.getAttribute("max"),10)];

					if(datepicker.status.level == datepicker.setting.level){
						datepicker.status.current = null;
						datepicker.onselect(range[0]+"-"+range[1]);
						return;
					}
					datepicker.status.yearRange = range;
					datepicker.status.level = 'Y';
					datepicker.status.get_level_model().show(datepicker);
				});
			},
			next:function(datepicker){
				datepicker.status.yearRange[0]=datepicker.status.yearRange[0]+100;
				datepicker.status.yearRange[1]=datepicker.status.yearRange[1]+100;
				this.show(datepicker);
			},
			prev:function(datepicker){
				datepicker.status.yearRange[0]=datepicker.status.yearRange[0]-100;
				datepicker.status.yearRange[1]=datepicker.status.yearRange[1]-100;
				this.show(datepicker);
			},
			parent:function(datepicker){
			}
		}
	};

	

	var Datepicker = function(setting){
		var _this = this;
		this.setting={}
		$.extend(this.setting,{
				i18n:{
					zh_CN:{
						WeekNameMin:["日","一","二","三","四","五","六"],
						WeekName:["周日","周一","周二","周三","周四","周五","周六"],
						MonthName:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
						Month:"月",
						Year:"年",
						Hours:"时",
						Minute:"分",
						Second:"秒"
					}
				},

				location:"zh_CN",
				format:"yyyy-MM-dd",
				initDate:new Date(),
				maxDate:null,
				minDate:null,
				level:'D',//选择级别、精度（T、Y、M、D、H、MI、S）
				initLevel:null,//初始级别(初始化显示时的级别)
				className:null
			},setting);
		if(!this.setting.initLevel){
			var ilvl = this.setting.level;
			if(ilvl == 'M' || ilvl == 'Y' || ilvl == 'T'){
				this.setting.initLevel = ilvl;
			}else{
				this.setting.initLevel = 'D';
			}
		}
		//初始化事件堆栈
		this.event_stack = {select:[],show:[]}
		//状态初始化
		this.status = {
			//原始日期
			original:new Date(),
			//当前日期
			current:new Date(),
			level:_this.setting.initLevel,//显示级别 T(十年) Y(年) M(月) D(日) H(时) MI(分) S(秒)
			//显示级别的模型
			level_model:level_models[_this.setting.initLevel],
			get_level_model:function(level){return level_models[level||this.level];}
		};

		this.status.original = this.setting.initDate || new Date();
		this.status.current = this.setting.initDate || new Date();
		this.create();
	}

	//要显示的日期列表
	var days = function(dt){
		date = new Date(dt);
		var dates = [];
		//设置为月初
		date.setDate(1);
		var week = date.getDay();
		//如果不是周日，则取上月的补全
		if(week){
			var prev_month = new Date(date);
			prev_month.setDate(0);
			for(var i=week;i>0;i--){
				var d = new Date(prev_month);
				d.setDate(d.getDate()-(i-1));
				dates[dates.length] = d;
			}
		}
		var lastDate = DateUtil.lastMonthDate(date);
		for(var i=1;i<=lastDate.getDate();i++){
			dates[dates.length] = new Date(date.getFullYear(),date.getMonth(),i);
		}

		var week = lastDate.getDay();
		if(week != 6){
			var next_month = DateUtil.addMonth(date,1);
			for(var i=0;i<6-week;i++){
				dates[dates.length] = new Date(next_month.getFullYear(),next_month.getMonth(),i+1);
			}
		}
		return dates;
	};


	var fn = Datepicker.prototype;
	var zIndex = 10000000;
	
	//取dom节点
	fn.getdom = function(){
		return this.dom;
	};

	//设置指定日期
	fn.setDate = function(date){
		this.status.current = date;
		this.status.current = date;
	}

	//创建dom
	fn.create = function(){
		var html = 	'<div id="datepicker-#ID#" class="#CLASS# hide" style="z-index:'+(--zIndex)+'">'
				+	'	<div class="datepicker-header">'
				+	'		<a class="prev" title="prev" >&lt;&lt;</a>'
				+	'		<span class="title">#TITLE#</span>'
				+	'		<a class="next" title="next" >&gt;&gt;</a>'
				+	'	</div>'
				+	'	<div class="datepicker-content"></div>'
				+	'</div>';
		html = html.replace(/#ID#/g,this.id || 'default').replace(/#CLASS#/g,this.setting.className||"datepicker-view");
		this.dom = $(html);
		//追加到body上，如果是drop-wrap，则加上view上，需要考虑和dropbox的接口
		this.dom.appendTo($(document.body));
		var $this = this;
		this.dom.click(function(e){
			e.stopPropagation();
		});
		this.dom.find(".prev").click(function(){
			$this.status.get_level_model().prev($this);
		});

		this.dom.find(".next").click(function(){
			$this.status.get_level_model().next($this);
		});
		this.dom.find(".title").click(function(){
			$this.status.get_level_model().parent($this);
		});
		return this.dom;
	}

	fn.show = function(param){
		if(param && typeof(param) == "function"){
			this.event_stack.show[this.event_stack.show.length] = param;
		}else{
			for(var i=0;i<this.event_stack.show.length;i++){
				if(this.event_stack.show[i] && typeof(this.event_stack.show[i])=='function'){
					this.event_stack.show[i](param,this);
				}
			}

			if(window.webframe && window.webframe.nextZIndex){
				this.getdom().css({zIndex:webframe.nextZIndex()});
			}
			
			this.getdom().show();
			this.status.get_level_model().show(this);
		}
	}

	fn.hide = function(){
		this.getdom().hide();
	}

	//获取日期
	fn.getDate = function(){
		return this.status.current;
	}

	//选择事件
	fn.onselect = function(param){
		if(param && typeof(param) == "function"){
			this.event_stack.select[this.event_stack.select.length] = param;
		}else{
			for(var i=0;i<this.event_stack.select.length;i++){
				if(this.event_stack.select[i] && typeof(this.event_stack.select[i])=='function'){
					this.event_stack.select[i](param,this);
				}
			}
		}
	}

	fn.moveTo = function(offset){
		this.getdom().css(offset);
	}

	fn.i18n = function(){
		return this.setting.i18n[this.setting.location];
	}
	
	fn.format = function(date){
		return DateUtil.format(date,this.setting.format);
	}

	$.fn.datepicker=function(setting){
		if(this.length==0) return;
		if(this.length == 1){
			var $this = $(this);
			var datepicker = new Datepicker(setting);
			datepicker.onselect(function(date){
				$this.val(datepicker.format(date));
				datepicker.hide();
				$this.blur();
				$this.change();
			});
			datepicker.show(function(){
				datepicker.moveTo({top:$this.offset().top+$this.outerHeight(true),left:$this.offset().left});
			});
			$this.click(function(e){
				datepicker.show();
				e.stopPropagation();
			});
			$(document).click(function(){
				datepicker.hide();
			});
			return datepicker;
		}else{
			this.each(function(){
				$(this).datepicker();
			});
			return;
		}
		
	};

	window.Datepicker = Datepicker;

	$(function(){
		//$(".datepicker").attr("readonly",true);
		$(".datepicker").css("background-color","#ffffff");
		
		$(".datepicker").each(function(){
			var $this = $(this);
			var setting = {};
			if($this.attr("format")){
				setting.format = $this.attr("format");
			}
			if($this.attr("level")){
				setting.level = $this.attr("level");
			}
			if($this.attr("initlevel")){
				setting.initLevel = $this.attr("initlevel");
			}
			if($this.val()){
				var date = DateUtil.parse($this.val(),setting.format);
				setting.initDate = date;
			}

			$this.datepicker(setting);
		});
	});
})(jQuery);