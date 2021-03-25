
$(document).ready(function() {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({

        datatype: "local",
        regional:'cn',
        height: "auto",
        colNames:[ '业务流水号','客户名称', '证件类型', '证件号码', '产品名称','模型名称','规则名称','指标名称', '指标入参名','指标入参值','指标状态','规则结果','时间'],
        colModel:[
            {
                sortable:false,
                name : 'querySeqNo',
                index : 'querySeqNo',
                width : 90,
                align:'center'
            },{
                sortable:false,
                name : 'custName',
                index : 'custName',
                width : 50,
                align:'center'
            }, {
                sortable:false,
                name : 'certType',
                index : 'certType',
                width : 30,
                align:'center',
                formatter : function(cellvalue){
                    return "身份证";
                }
            }, {
                sortable:false,
                name : 'certNum',
                index : 'certNum',
                width : 90,
                align:'center'
            }, {
                sortable:false,
                name : 'prodName',
                index : 'prodName',
                width : 50,
                align:'center'
            }, {
                sortable:false,
                name : 'modelName',
                index : 'modelName',
                align:'center',
                width : 50
            }, {
                sortable:false,
                name : 'ruleName',
                index : 'ruleName',
                align:'center',
                width : 100
            }
            , {
                sortable:false,
                name : 'indexName',
                index : 'indexName',
                align:'center',
                width : 100
            }, {
                sortable:false,
                name : 'fieldName',
                index : 'fieldName',
                align:'center',
                width : 100
            }, {
                sortable:false,
                name : 'fieldValue',
                index : 'fieldValue',
                align:'center',
                width : 50
            }, {
                sortable:false,
                name : 'ruleResult',
                index : 'ruleResult',
                width : 30,
                formatter : function(cellvalue){
                    return ('01'==cellvalue) ? '命中' : '不命中';
                }
            }, {
                sortable:false,
                name : 'ruleResult',
                index : 'ruleResult',
                align:'center',
                width : 50,
                formatter : function(cellvalue){
                    return ("01"==cellvalue)?"拒绝":"通过";
                }
            }, {
                sortable:false,
                name : 'dataTime',
                index : 'dataTime',
                align:'center',
                width : 80
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

        caption: "支用准入模型数据统计表",
        autowidth: true
    }).jqGrid('setGridParam', {
        page : 1,
        url:root+'/dm_data',
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
        url:root+'/dm_data',
        datatype : "json",
        postData : {querySeqNo:$("#querySeqNo").val(),custName:$("#custName").val(),prodId:$("#prodId").val(),modleName:$("#modleName").val(),certNum:$("#certNum").val()}
    }).trigger("reloadGrid");
}