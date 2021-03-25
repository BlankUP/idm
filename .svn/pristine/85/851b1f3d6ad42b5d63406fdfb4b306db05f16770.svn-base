$(document).ready(function() {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({

        datatype: "local",
        regional:'cn',
        height: "auto",
        colNames:[ '业务流水号', '客户名称', '证件类型', '证件号码', '产品名称','模型名称','授信评分','授信额度','基础额度','资产额度','工资额度','额度调整','执行利率(万分之)', '授信日期','操作'],
        colModel:[
            {
                sortable:false,
                name : 'querySeqNo',
                index : 'querySeqNo',
                width : 100
            }, {
                sortable:false,
                name : 'custName',
                index : 'custName',
                width : 40
            }, {
                sortable:false,
                name : 'certType',
                index : 'certType',
                width : 40,
                align:'center',
                formatter : function(cellvalue){
                    return "身份证";
                }
            }, {
                sortable:false,
                name : 'certNum',
                index : 'certNum',
                width : 100
            }, {
                sortable:false,
                name : 'prodName',
                index : 'prodName',
                width : 80,
                align:'center'
            }, {
                sortable:false,
                name : 'modelName',
                index : 'modelName',
                width : 80
            },  {
                sortable:false,
                name : 'creditScore',
                index : 'creditScore',
                width : 50
            }
            ,  {
                sortable:false,
                name : 'creditMoney',
                index : 'creditMoney',
                width : 50
            },  {
                sortable:false,
                name : 'baseLine',
                index : 'baseLine',
                width : 50
            },  {
                sortable:false,
                name : 'amountAssets',
                index : 'amountAssets',
                width : 50
            },  {
                sortable:false,
                name : 'salaryAmount',
                index : 'salaryAmount',
                width : 50
            },  {
                sortable:false,
                name : 'quotaAdjustment',
                index : 'quotaAdjustment',
                width : 50
            },  {
                sortable:false,
                name : 'dayRate',
                index : 'dayRate',
                width : 50
            }
            , {
                sortable:false,
                name : 'dateTime',
                index : 'dateTime',
                width : 90
            },  {
                sortable:false,
                name : 'querySeqNo',
                index : 'querySeqNo',
                width : 60,
                formatter: function(cellvalue, options, rowObject){
                    return '<a href="javascript:void(0)" onclick="dolike(\''+rowObject.querySeqNo+'\',\''+rowObject.custName+'\')">查看评分明细</a>';
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

        caption: "评分模型数据统计表",
        autowidth: true
    }).jqGrid('setGridParam', {
        page : 1,
        url:root+'/score_model_data',
        datatype : "json"
    }).trigger("reloadGrid");
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
        url:root+'/score_model_data',
        datatype : "json",
        postData : {querySeqNo:$("#querySeqNo").val(),custName:$("#custName").val(),prodId:$("#prodId").val(),modleName:$("#modleName").val(), certNum:$("#certNum").val()}
    }).trigger("reloadGrid");
}

/**
 * 导出excel
 */
function doExport(){
    window.open("score_model_data_export?querySeqNo="+$("#querySeqNo").val()+"&custName="+$("#custName").val()+"&certNum="+$("#certNum").val());
}

function dolike(querySeqNo,custName){
    $.ajax({
        type: "GET",
        url: root+'/score_model_detail?querySeqNo='+querySeqNo,
        dataType: "json",
        success: function(data){
            var list = data;
            var str="<tr><th>客户名称</th><th>模型名称</th><th>指标名称</th><th>指标评分</th><th>指标比重</th></tr>";
            for(i in list){
                str += "<tr>" +
                    //"<td>" + list[i].querySeqNo + "</td>" +
                    "<td>" + trim(custName) + "</td>" +
                    "<td>" + trim(list[i].modelName) + "</td>" +
                    "<td>" + trim(list[i].indexName) + "</td>" +
                    "<td>" + trim(list[i].indexScore) + "</td>" +
                    "<td>" + trim(list[i].indexPercent) + "</td>" +
                    //"<td>" + trim(list[i].prodId) + "</td>" +
                    //"<td>" + trim(list[i].prodName) + "</td>" +
                    "</tr>";
            }
            $("#detail").html(str);
        },
        error: function () {
            alert("查询失败");
        }
    });
    //$("#du_username").html(name);
    $("#duModal").modal({
        keyboard : false
    });

}

function trim(obj){
    if(typeof obj !="undefined"){
        return obj;
    }else{
        return "-";
    }
}

function duSubmit(){
    $("#duModal").modal("toggle");
}
/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
    $('#'+modalId).hide();
}