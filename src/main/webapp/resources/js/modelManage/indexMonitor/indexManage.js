
$(document).ready(function() {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({

        datatype: "local",
        regional:'cn',
        height: "auto",
        colNames:[ '产品编号', '产品名称', '模型编号', '模型名称', '规则编号', '规则名称','客户指标名称', '规则状态'],
        colModel:[
            {
                sortable:false,
                name : 'prodId',
                index : 'prodId',
                width : 100,
                align:'center'
            }, {
                sortable:false,
                name : 'prodName',
                index : 'prodName',
                width : 100,
                align:'center'
            }, {
                sortable:false,
                name : 'modelId',
                index : 'modelId',
                width : 100
            }, {
                sortable:false,
                name : 'modelName',
                index : 'modelName',
                width : 100
            }, {
                sortable:false,
                name : 'ruleId',
                index : 'ruleId',
                width : 100
            }, {
                sortable:false,
                name : 'ruleName',
                index : 'ruleName',
                width : 200
            }, {
                sortable:false,
                name : 'indexName',
                index : 'indexName',
                width : 200
            }, {
                sortable:false,
                name : 'ruleResult',
                index : 'ruleResult',
                width : 50,
                formatter : function(cellvalue){
                    return ('01'==cellvalue) ? '命中' : '不命中';
                }
            }
        ],
        viewrecords : true,
        rowNum:10,
        rowList:[10,20,30,50,100],
        pager : pager_selector,
        altRows: true,
        multiselect: false,
        multiboxonly: true,

        loadComplete : function() {
            var table = this;
            setTimeout(function(){
                updatePagerIcons(table);
            }, 0);
        },

        onCellSelect : function(rowid,iCol,cellcontent,e) {

        },

        caption: "指标统计表",
        autowidth: true
    }).jqGrid('setGridParam', {
        page : 1,
        url:root+'/index_service',
        datatype : "json"
    }).trigger("reloadGrid");

    chartLoad();
});

/**
 * 加载图表
 */
function chartLoad() {
    chars("use");//使用率
    chars("hit");//命中率
}

//调整分页图标
function updatePagerIcons(table) {
    var replacement =
        {
            'ui-icon-seek-first' : 'fa fa-angle-double-left',
            'ui-icon-seek-prev' : 'fa fa-angle-left',
            'ui-icon-seek-next' : 'fa fa-angle-right',
            'ui-icon-seek-end' : 'fa fa-angle-double-right'
        };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
        if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
    });
}
function doSearch(){
    $("#grid-table").jqGrid('setGridParam', {
        page : 1,
        url:root+'/index_service',
        datatype : "json",
        postData : {ruleNo:$("#ruleNo").val(),modleName:$("#modleName").val(),productNo:$("#productNo").val()}
    }).trigger("reloadGrid");
    chartLoad();
}

/*option1 = {
    title : {
        text: '指标变量使用率分析',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
		y : 35,
        icon: "rect",
        itemWidth : 20,
        itemHeight : 15,
        data:null
    },
    calculable : true,
    series : [
        {
            name:'使用次数',
            type:'pie',
            radius : '55%',
            center: ['50%', '30%'],
            data:null,
            //标签
            itemStyle : {
                normal : {
                    label:{
                        show : false,
                        position : 'outer',
                        formatter: '{d}%',
                        distance : 0.7, //这项是标识距离中心点的距离
                        textStyle : {
                            align : 'center',
                            baseline : 'middle',
                            fontFamily : '微软雅黑',
                            fontSize : 12,
                            fontWeight : 'bolder'
                        }
                    },
                    labelLine:{
                        show : false
                    }
                }
            }
        }
    ]
};

option2 = {
    title : {
        text: '变量命中率分析',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        icon: "rect",
        data:null
    },
    calculable : true,
    series : [
        {
            name:'命中次数',
            type:'pie',
            radius : '55%',
            center: ['70%', '60%'],
            data:null,
            //标签
            itemStyle : {
                normal : {
                    label:{
                        show : false,
                        position : 'outer',
                        formatter: '{d}%',
                        distance : 0.7, //这项是标识距离中心点的距离
                        textStyle : {
                            align : 'center',
                            baseline : 'middle',
                            fontFamily : '微软雅黑',
                            fontSize : 12,
                            fontWeight : 'bolder'
                        }
                    },
                    labelLine:{
                        show : false
                    }
                }
            }
        }
    ]
};*/

option3 = {
    title: {
        x: 'center',
        text: '指标变量使用率分析'
    },
    tooltip: {
        trigger: 'item',
        formatter:function(param){
            //console.log(param);
            return param.data.name+":"+param.data.value;
        }
    },
    calculable: true,
    grid: {
        borderWidth: 0,
        y: 40,
        y2: 350
    },
    xAxis: [
        {
            type: 'category',
            show: true,
            axisLabel:{
                interval : 0 ,
                rotate:70,
                formatter : function (param) {
                    return param.name;
                }
            },
            data: null
        }
    ],
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    series: [
        {
            name: '指标变量使用率分析',
            type: 'bar',
            itemStyle: {
                normal: {
                    color: function(params) {
                        var colorList = [
                            '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#0000FF','#009900','#0099FF','#00CC99','#CC6600','#9999FF','#CC0066','#FF6600','#66CC33','#9900CC','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#0000FF','#009900','#0099FF','#00CC99','#CC6600','#9999FF','#CC0066','#FF6600','#66CC33','#9900CC','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                    },
                    label: {
                        show: true,
                        position: 'top',
                        formatter: function(param){
                            //console.log(param);
                            //return param.data.value
                            return "";
                        }
                    }
                }
            },
            data: null
        }
    ]
};

option4 = {
    title: {
        x: 'center',
        text: '指标变量命中率分析'
    },
    tooltip: {
        trigger: 'item',
        formatter:function(param){
            //console.log(param);
            return param.data.name+":"+param.data.value;
        }
    },
    calculable: true,
    grid: {
        borderWidth: 0,
        y: 40,
        y2: 350
    },
    xAxis: [
        {
            type: 'category',
            show: true,
            axisLabel:{
                interval : 0 ,
                rotate:70,
                formatter : function (param) {
                    return param.name;
                }
            },
            data: null
        }
    ],
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    series: [
        {
            name: '指标变量命中率分析',
            type: 'bar',
            itemStyle: {
                normal: {
                    color: function(params) {
                        var colorList = [
                            '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#0000FF','#009900','#0099FF','#00CC99','#CC6600','#9999FF','#CC0066','#FF6600','#66CC33','#9900CC','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#0000FF','#009900','#0099FF','#00CC99','#CC6600','#9999FF','#CC0066','#FF6600','#66CC33','#9900CC','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#C1232B','#B5C334','#FCCE10','#E87C25','#27727B','#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD','#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                    },
                    label: {
                        show: true,
                        position: 'top',
                        formatter: function(param){
                            //console.log(param);
                            //return param.data.value
                            return "";
                        }
                    }
                }
            },
            data: null
        }
    ]
};

var myChart1 = echarts.init(document.getElementById('main1'));
//myChart1.setOption(option1);
var myChart2 = echarts.init(document.getElementById('main2'));
//myChart2.setOption(option2);

function chars(type){
    if(type=="use"){
        $.ajax({
            type: "post",
            url: root+'/index_line_service',
            data:{type:type, ruleNo:$("#ruleNo").val(),modleName:$("#modleName").val(),productNo:$("#productNo").val()},
            dataType: "json",
            success: function(data){
                //option1.legend.data=data.array;
                //option1.series[0].data=data.data;
                option3.xAxis[0].data=data.array;
                option3.series[0].data=data.data;
                myChart1.hideLoading();
                myChart1.setOption(option3,true);
            },
            error: function () {
                alert("使用率数据读取失败");
            }
        });
    }else{
        $.ajax({
            type: "post",
            url: root+'/index_line_service',
            data:{type:type, ruleNo:$("#ruleNo").val(),modleName:$("#modleName").val(),productNo:$("#productNo").val()},
            dataType: "json",
            success: function(data){
                option4.xAxis[0].data=data.array;
                option4.series[0].data=data.data;
                myChart2.hideLoading();
                myChart2.setOption(option4,true);
            },
            error: function () {
                alert("命中率数据读取失败");
            }
        });
    }

}
