
$(document).ready(function() {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({

        datatype: "local",
        regional:'cn',
        height: "auto",
        colNames:[ '流水号', '客户姓名', '证件号', '客户号', '产品名称', '模型名称', '规则名称','指标名称', '指标入参名','指标入参值','指标状态','时间'],
        colModel:[
            {
                sortable:false,
                name : 'querySeqNo',
                index : 'querySeqNo',
                width : 50,
                align:'center'
            }, {
                sortable:false,
                name : 'custName',
                index : 'custName',
                width : 35,
                align:'center'
            }, {
                sortable:false,
                name : 'certNum',
                index : 'certNum',
                width : 60
            }, {
                sortable:false,
                name : 'custNo',
                index : 'custNo',
                width : 70
            }, {
                sortable:false,
                name : 'prodName',
                index : 'prodName',
                width : 40
            }, {
                sortable:false,
                name : 'modelName',
                index : 'modelName',
                width : 40
            }, {
                sortable:false,
                name : 'ruleName',
                index : 'ruleName',
                width : 100
            }, {
                sortable:false,
                name : 'indexName',
                index : 'indexName',
                width : 100
            }, {
                sortable:false,
                name : 'fieldName',
                index : 'fieldName',
                width : 100
            }, {
                sortable:false,
                name : 'fieldValue',
                index : 'fieldValue',
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
                name : 'dataTime',
                index : 'dataTime',
                width : 40
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

        caption: "客户指标情况表",
        autowidth: true
    }).jqGrid('setGridParam', {
        page : 1,
        url:root+'/index_service',
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
        url:root+'/index_service',
        datatype : "json",
        postData : {querySeqNo:$("#querySeqNo").val(),custName:$("#custName").val(),certNum:$("#certNum").val(),custNo:$("#custNo").val()}
    }).trigger("reloadGrid");
}
