$(document).ready(function() {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({

        datatype: "local",
        regional:'cn',
        height: "auto",
        colNames:[ '客户姓名', '证件类型', '证件号码', '产品名称', '产品编码', '模型名称','模型编码', '风险等级', '风险信息', '预警日期'],
        colModel:[
            {
                sortable:false,
                name : 'customName',
                index : 'customName',
                width : 120,
                align:'center'
            }, {
                sortable:false,
                name : 'paperType',
                index : 'paperType',
                width : 80,
                align:'center'
            }, {
                sortable:false,
                name : 'paperNo',
                index : 'paperNo',
                width : 150
            }, {
                sortable:false,
                name : 'productName',
                index : 'productName',
                width : 150
            }, {
                sortable:false,
                name : 'productCode',
                index : 'productCode',
                width : 100
            }, {
                sortable:false,
                name : 'modelName',
                index : 'modelName',
                width : 100
            }, {
                sortable:false,
                name : 'modelCode',
                index : 'modelCode',
                width : 100
            }, {
                sortable:false,
                name : 'riskLevel',
                index : 'riskLevel',
                width : 100
            }, {
                sortable:false,
                name : 'riskInfo',
                index : 'riskInfo',
                width : 100
            }, {
                sortable:false,
                name : 'warnDate',
                index : 'warnDate',
                width : 100
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

        caption: "客户维度",
        autowidth: true
    }).jqGrid('setGridParam', {
        page : 1,
        url:root+'/cust_dimension_service.do?modelName='+$("#modelName").val()+'&modelCode='+$("#modelCode").val()+'&productName='+$("#productName").val()+'&productCode='+$("#productCode").val()+'&beginDate='+$("#beginDate").val()+'&endDate='+$("#endDate").val()+'&sourceSystem='+$("#sourceSystem").val()+'&receiveSystem='+$("#receiveSystem").val()+'&customName='+$("#customName").val()+'&paperType='+$("#paperType").val()+'&paperNo='+$("#paperNo").val()+'&riskLevel='+$("#riskLevel").val(),
        datatype : "json"
    }).trigger("reloadGrid");
    //注释掉图表显示 charts();
});

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
        url:root+'/cust_dimension_service.do?modelName='+$("#modelName").val()+'&modelCode='+$("#modelCode").val()+'&productName='+$("#productName").val()+'&productCode='+$("#productCode").val()+'&beginDate='+$("#beginDate").val()+'&endDate='+$("#endDate").val()+'&sourceSystem='+$("#sourceSystem").val()+'&receiveSystem='+$("#receiveSystem").val()+'&customName='+$("#customName").val()+'&paperType='+$("#paperType").val()+'&paperNo='+$("#paperNo").val()+'&riskLevel='+$("#riskLevel").val(),
        datatype : "json"
    }).trigger("reloadGrid");
    charts();
}

var option={
    title : {
        text: '风险命中客户数统计',
        x:'center',

    },
    tooltip : {
        trigger: 'item',
        formatter: "{c}"
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'left',
                        max: 1548
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            type:'pie',
            radius : '75%',
            center: ['50%', '60%'],
            data:null
        }
    ]
};
var custdimensionChart= echarts.init(document.getElementById('custdimension'));
function charts() {

    $.ajax({
        type:"post",
        url: root+'/riskWarmSummary',
        data:{customName:$("#customName").val(),paperType:$("#paperType").val(),
            paperNo:$("#paperNo").val(), productName:$("#productName").val(),
            productCode:$("#productCode").val(), modelName:$("#modelName").val(),
            modelCode:$("#modelCode").val(),beginDate:$("#beginDate").val(),
            endDate:$("#endDate").val() },
        dataType:"json",
        success:function (data) {
            option.series[0].data=data.dataArray;
            custdimensionChart.setOption(option,true);
        },
        error: function () {
            alert("数据读取失败");
        }

    });
}
