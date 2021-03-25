
$(document).ready(function() {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({

        datatype: "local",
        regional:'cn',
        height: "auto",
        colNames:[ '产品编码', '产品名称', '当前客户总数', '当前通过客户数', '当前拒绝客户数', '当前逾期客户数','放款总金额', '逾期总金额', '当前总金额'],
        colModel:[
            {
                sortable:false,
                name : 'prodId',
                index : 'prodId',
                width : 120,
                align:'center'
            }, {
                sortable:false,
                name : 'prodName',
                index : 'prodName',
                width : 80,
                align:'center'
            }, {
                sortable:false,
                name : 'currentCustSum',
                index : 'currentCustSum',
                width : 150
            }, {
                sortable:false,
                name : 'currentPassNum',
                index : 'currentPassNum',
                width : 150
            }, {
                sortable:false,
                name : 'currentRefuseNum',
                index : 'currentRefuseNum',
                width : 100
            }, {
                sortable:false,
                name : 'currentOverdueNum',
                index : 'currentOverdueNum',
                width : 100
            }, {
                sortable:false,
                name : 'loanAmount',
                index : 'loanAmount',
                width : 100
            }, {
                sortable:false,
                name : 'overdueAmount',
                index : 'overdueAmount',
                width : 100
            }, {
                sortable:false,
                name : 'currentAmount',
                index : 'currentAmount',
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

        caption: "产品维度",
        autowidth: true
    }).jqGrid('setGridParam', {
        page : 1,
        url:root+'/prod_dimension_service.do?productName='+$("#productName").val()+'&prodId='+$("#prodId").val()+'&query_date='+$("#query_date").val(),
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
        url:root+'/prod_dimension_service.do?productName='+$("#productName").val()+'&prodId='+$("#prodId").val()+'&query_date='+$("#query_date").val(),
        datatype : "json"
    }).trigger("reloadGrid");
}

