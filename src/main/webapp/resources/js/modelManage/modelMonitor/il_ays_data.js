
$(document).ready(function() {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({

        datatype: "local",
        regional:'cn',
        height: "auto",
        colNames:[ '产品编号','产品名称', '模型名称', '入摸客户总数', '命中指标名称','该指标命中个数'],
        colModel:[
            {
                sortable:false,
                name : 'prodId',
                index : 'prodId',
                width : 100,
                align:'center'
            },{
                sortable:false,
                name : 'prodName',
                index : 'prodName',
                width : 100,
                align:'center'
            }, {
                sortable:false,
                name : 'modelName',
                index : 'modelName',
                width : 150,
                align:'center'
            }, {
                sortable:false,
                name : 'inCount',
                index : 'inCount',
                width : 100,
                align:'center'
            }, {
                sortable:false,
                name : 'ruleName',
                index : 'ruleName',
                width : 200
            }, {
                sortable:false,
                name : 'hitCount',
                index : 'hitCount',
                align:'center',
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

        caption: "贷中预警模型分析数据统计表",
        autowidth: true
    }).jqGrid('setGridParam', {
        page : 1,
        url:root+'/il_ays_data',
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
        url:root+'/il_ays_data',
        datatype : "json",
        postData : {ruleName:$("#ruleName").val(),modleName:$("#modleName").val(),productNo:$("#productNo").val()}
    }).trigger("reloadGrid");
}