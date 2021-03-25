var myChartCpu = echarts.init(document.getElementById('cpu'));

var cpuOption = {
		 title: {
		        text: '线程池实时监控折线图'
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['目前缓冲池任务数量','目前线程数量']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    toolbox: {
		    	 show : true,

		    	 feature : {
		            
		             saveAsImage : {show: true}
		         }

		    },
		    xAxis: [ {
		    	name : '时间',
				type : "category",
				boundaryGap : false,
				data : [ "00:00:00", "00:00:00", "00:00:00", "00:00:00", "00:00:00",
						"00:00:00", "00:00:00" ],
				nameTextStyle : {
					fontSize : 12
				}
			} ],
		    yAxis:[{
		    	name : '任务数量',
		        type: 'value'
		    }
		    ] ,
		    series: [
		        {
		            name:'目前缓冲池任务数量',
		            type:'line',
		            stack: '总量',
		            data:[0, 0, 0, 0, 0, 0, 0]
		        },{
		            name:'目前线程数量',
		            type:'line',
		            
		            data:[0, 0, 0, 0, 0, 0, 0]
		        }
	
		    ]
};


$(function(){
    myChartCpu.setOption(cpuOption);
    serverSelect();
    var monitor = self.setInterval("serverSelect()",5000);
});

function serverSelect(){
    var cpuUsing1 = 0;
    var cpuUsing2 = 0;
    var cputiming1 = 0;
    var memorytiming1 = 0;
    var id=$("#searchServer").val();
    $.ajax({
        url : root + "/thread.do",
        type : 'post',
        data:{id:id},
        dataType : 'json',
        async : false,
        error : function() {
            console.log("get error!!!")
        },
        success : function(data) {
            cpuUsing1 = data.ActiveCount;
            cpuUsing2 = data.QueueSize;
            //option.series[0].data =$.parseJSON(arr[1]);
            cputiming1 = data.cputime;
           
        }
    });
  
    myChartCpu.addData([ [ 0, // 系列索引
        cpuUsing1, // 新增数据
        false, // 新增数据是否从队列头部插入
        false, // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
        cputiming1,
    ]
    ,
    [ 1, // 系列索引
        cpuUsing2, // 新增数据
        false, // 新增数据是否从队列头部插入
        false, // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
        cputiming1,
    ]
    
    
    
    ]);
}

