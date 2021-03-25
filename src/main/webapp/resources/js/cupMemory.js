var myChartCpu = echarts.init(document.getElementById('cpu'));
var myChartMemory = echarts.init(document.getElementById('memory'));
var cpuOption = {
	title : {
		text : "CPU监控走势图",
		subtext : "",
		x : "center",
		textStyle : {
			color : '#FA8B3A',
			fontSize : 15
		}
	},
	tooltip : {
		trigger : "axis",
		formatter : '{b}\n{c}%'
	},
	legend : {
		data : [ "节点机" ],
		y : "center",
		x : "left",
		orient : "vertical"
	},
	toolbox : {
		show : true,
		feature : {
			dataView : {
				readOnly : true
			},
			magicType : {
				show : false,
				type : [ "line" ]
			},
			saveAsImage : {
				show : true
			}
		}
	},
	calculable : true,
	xAxis : [ {
		type : "category",
		boundaryGap : false,
		data : [ "00:00:00", "00:00:00", "00:00:00", "00:00:00", "00:00:00",
				"00:00:00", "00:00:00" ],
		nameTextStyle : {
			fontSize : 12
		}
	} ],
	yAxis : [ {
		type : "value",
		max : 100,
        axisLabel : {
            formatter: '{value}%'
        }
	} ],
	series : [ {
		name : "节点机",
		type : "line",
		smooth : true,
		itemStyle : {
			normal : {
				lineStyle : {
					width : 2
				},
				areaStyle : {
					type : "default"
				},
                label: {
                    show: true,
                    formatter: '{b}\n{c}%'
                }
			}
		},
		data : [ 0, 0, 0, 0, 0, 0, 0 ],
		smooth : true
	} ],
	grid : {
		x : 127,
		y : 65
	},
	backgroundColor : "rgb(248, 248, 248)"
};
var memoryOption = {
	backgroundColor: '#1b1b1b',
	tooltip: {
		formatter: '{a} <br/>{c} {b}'
	},
	toolbox: {
		show: true,
		feature: {
			mark: {show: true},
			restore: {show: true},
			saveAsImage: {show: true}
		}
	},
	series: [
		{
			name: '速度',
			type: 'gauge',
			min: 0,
			max: 220,
			splitNumber: 11,
			radius: '50%',
			axisLine: {            // 坐标轴线
				lineStyle: {       // 属性lineStyle控制线条样式
					color: [[0.09, 'lime'], [0.82, '#1e90ff'], [1, '#ff4500']],
					width: 3,
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			axisLabel: {            // 坐标轴小标记
				fontWeight: 'bolder',
				color: '#fff',
				shadowColor: '#fff', //默认透明
				shadowBlur: 10
			},
			axisTick: {            // 坐标轴小标记
				length: 15,        // 属性length控制线长
				lineStyle: {       // 属性lineStyle控制线条样式
					color: 'auto',
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			splitLine: {           // 分隔线
				length: 25,         // 属性length控制线长
				lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
					width: 3,
					color: '#fff',
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			pointer: {           // 分隔线
				shadowColor: '#fff', //默认透明
				shadowBlur: 5
			},
			title: {
				textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
					fontWeight: 'bolder',
					fontSize: 20,
					fontStyle: 'italic',
					color: '#fff',
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			detail: {
				backgroundColor: 'rgba(30,144,255,0.8)',
				borderWidth: 1,
				borderColor: '#fff',
				shadowColor: '#fff', //默认透明
				shadowBlur: 5,
				offsetCenter: [0, '50%'],       // x, y，单位px
				textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
					fontWeight: 'bolder',
					color: '#fff'
				}
			},
			data: [{value: 40, name: 'km/h'}]
		},
		{
			name: '转速',
			type: 'gauge',
			center: ['25%', '55%'],    // 默认全局居中
			radius: '30%',
			min: 0,
			max: 7,
			endAngle: 45,
			splitNumber: 7,
			axisLine: {            // 坐标轴线
				lineStyle: {       // 属性lineStyle控制线条样式
					color: [[0.29, 'lime'], [0.86, '#1e90ff'], [1, '#ff4500']],
					width: 2,
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			axisLabel: {            // 坐标轴小标记
				fontWeight: 'bolder',
				color: '#fff',
				shadowColor: '#fff', //默认透明
				shadowBlur: 10
			},
			axisTick: {            // 坐标轴小标记
				length: 12,        // 属性length控制线长
				lineStyle: {       // 属性lineStyle控制线条样式
					color: 'auto',
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			splitLine: {           // 分隔线
				length: 20,         // 属性length控制线长
				lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
					width: 3,
					color: '#fff',
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			pointer: {
				width: 5,
				shadowColor: '#fff', //默认透明
				shadowBlur: 5
			},
			title: {
				offsetCenter: [0, '-30%'],       // x, y，单位px
				textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
					fontWeight: 'bolder',
					fontStyle: 'italic',
					color: '#fff',
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			detail: {
				//backgroundColor: 'rgba(30,144,255,0.8)',
				// borderWidth: 1,
				borderColor: '#fff',
				shadowColor: '#fff', //默认透明
				shadowBlur: 5,
				width: 80,
				height: 30,
				offsetCenter: [25, '20%'],       // x, y，单位px
				textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
					fontWeight: 'bolder',
					color: '#fff'
				}
			},
			data: [{value: 1.5, name: 'x1000 r/min'}]
		},
		{
			name: '油表',
			type: 'gauge',
			center: ['75%', '50%'],    // 默认全局居中
			radius: '30%',
			min: 0,
			max: 2,
			startAngle: 135,
			endAngle: 45,
			splitNumber: 2,
			axisLine: {            // 坐标轴线
				lineStyle: {       // 属性lineStyle控制线条样式
					color: [[0.2, 'lime'], [0.8, '#1e90ff'], [1, '#ff4500']],
					width: 2,
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			axisTick: {            // 坐标轴小标记
				length: 12,        // 属性length控制线长
				lineStyle: {       // 属性lineStyle控制线条样式
					color: 'auto',
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			axisLabel: {
				fontWeight: 'bolder',
				color: '#fff',
				shadowColor: '#fff', //默认透明
				shadowBlur: 10,
				formatter: function (v){
					switch (v + '') {
						case '0': return 'E';
						case '1': return 'Gas';
						case '2': return 'F';
					}
				}
			},
			splitLine: {           // 分隔线
				length:15,         // 属性length控制线长
				lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
					width:3,
					color: '#fff',
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			pointer: {
				width:2,
				shadowColor: '#fff', //默认透明
				shadowBlur: 5
			},
			title: {
				show: false
			},
			detail: {
				show: false
			},
			data: [{value: 0.5, name: 'gas'}]
		},
		{
			name: '水表',
			type: 'gauge',
			center: ['75%', '50%'],    // 默认全局居中
			radius: '30%',
			min: 0,
			max: 2,
			startAngle: 315,
			endAngle: 225,
			splitNumber: 2,
			axisLine: {            // 坐标轴线
				lineStyle: {       // 属性lineStyle控制线条样式
					color: [[0.2, 'lime'], [0.8, '#1e90ff'], [1, '#ff4500']],
					width: 2,
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			axisTick: {            // 坐标轴小标记
				show: false
			},
			axisLabel: {
				fontWeight: 'bolder',
				color: '#fff',
				shadowColor: '#fff', //默认透明
				shadowBlur: 10,
				formatter: function(v){
					switch (v + '') {
						case '0': return 'H';
						case '1': return 'Water';
						case '2': return 'C';
					}
				}
			},
			splitLine: {           // 分隔线
				length: 15,         // 属性length控制线长
				lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
					width: 3,
					color: '#fff',
					shadowColor: '#fff', //默认透明
					shadowBlur: 10
				}
			},
			pointer: {
				width: 2,
				shadowColor: '#fff', //默认透明
				shadowBlur: 5
			},
			title: {
				show: false
			},
			detail: {
				show: false
			},
			data:[{value: 0.5, name: 'gas'}]
		}
	]
};

/*function cpuMemroyCallback(obj) {
	var data = obj.data;
	if (data.msg != undefined && data.msg != "") {
		clearInterval(timeTicket);
		return false;
	}
	//内存	
	memoryOption.series[0].data[0].value = data.memory;
	myChartMemory.setOption(memoryOption, true);
	//cpu
	var axisData = 15;//RTAUtil.format2HHMMSS(new Date());

	// 动态数据接口 addData
	myChartCpu.addData([ [ 0, // 系列索引
	12, // 新增数据
	false, // 新增数据是否从队列头部插入
	false, // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
	axisData // 坐标轴标签
	] ]);

}*/

$(function(){
    myChartCpu.setOption(cpuOption);
    loadData();
    var monitor = self.setInterval("loadData()",5000);
});

function loadData(){
    var cpuUsing1 = 0;
    var cputiming1 = 0;
    var memorytiming1 = 0;
    $.ajax({
        url : root + "/rta_service.do",
        type : 'post',
        dataType : 'json',
        async : false,
        error : function() {
            console.log("get error!!!")
        },
        success : function(data) {
            cpuUsing1 = data.cpuUsing;
            cputiming1 = data.cputime;
            memorytiming1 = data.memoryUsing;
        }
    });
    memoryOption.series[0].data[0].value = memorytiming1;
	memoryOption.series[1].data[0].value = (Math.random()*7).toFixed(2) - 0;
	memoryOption.series[2].data[0].value = (Math.random()*2).toFixed(2) - 0;
	memoryOption.series[3].data[0].value = (Math.random()*2).toFixed(2) - 0;
    myChartMemory.setOption(memoryOption, true);
    myChartCpu.addData([ [ 0, // 系列索引
        cpuUsing1, // 新增数据
        false, // 新增数据是否从队列头部插入
        false, // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
        cputiming1 // 坐标轴标签
    ] ]);
}

