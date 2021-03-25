$(document).ready(function() {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({

        datatype: "local",
        regional:'cn',
        height: "auto",
        colNames:[ '模型编码', '模型名称', '风险指标名称', '风险等级', '入模客户总数', '该指标空值客户数','该指标客户命中数', '对应产品代码', '对应产品名称'],
        colModel:[
            {
                sortable:false,
                name : 'modelCode',
                index : 'modelCode',
                width : 120,
                align:'center'
            }, {
                sortable:false,
                name : 'modelName',
                index : 'modelName',
                width : 150,
                align:'center'
            }, {
                sortable:false,
                name : 'riskIndex',
                index : 'riskIndex',
                width : 150
            }, {
                sortable:false,
                name : 'riskLevel',
                index : 'riskLevel',
                width : 150
            }, {
                sortable:false,
                name : 'modelcustomCt',
                index : 'modelcustomCt',
                width : 100
            }, {
                sortable:false,
                name : 'indexNullCustomCt',
                index : 'indexNullCustomCt',
                width : 100
            }, {
                sortable:false,
                name : 'indexHitCt',
                index : 'indexHitCt',
                width : 100
            }, {
                sortable:false,
                name : 'productCode',
                index : 'productCode',
                width : 100
            }, {
                sortable:false,
                name : 'productName',
                index : 'productName',
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

        caption: "模型维度",
        autowidth: true
    }).jqGrid('setGridParam', {
        page : 1,
        url:root+'/model_dimension_service.do?modleName='+$("#modleName").val()+'&modelId='+$("#modelId").val()+'&productName='+$("#productName").val()+'&prodId='+$("#prodId").val()+'&query_date='+$("#query_date").val(),
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
        url:root+'/model_dimension_service.do?modleName='+$("#modleName").val()+'&modelId='+$("#modelId").val()+'&productName='+$("#productName").val()+'&prodId='+$("#prodId").val()+'&query_date='+$("#query_date").val(),
        datatype : "json"
    }).trigger("reloadGrid");
}
var option={
    title : {
        text: '模型规则命中客户数',
        x:'center',

    },
    tooltip : {
        trigger: 'item',
        formatter: "{c}"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:null
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
            radius : '55%',
            center: ['50%', '60%'],
            data:null
        }
    ]
};
var modeldimensionChart = echarts.init(document.getElementById('modeldimension'));
function charts() {

    $.ajax({
        type:"post",
        url: root+'/getModeldimensionData',
        data:{modleName:$("#modleName").val(),modelId:$("#modelId").val(),
            productName:$("#productName").val(), prodId:$("#prodId").val(),
            query_date:$("#query_date").val() },
        dataType:"json",
        success:function (data) {
            option.legend.data=data.modelArray;
            option.series[0].data=data.dataArray;
            modeldimensionChart.setOption(option,true);
        },
        error: function () {
            alert("模型数据读取失败");
        }

    });
}
