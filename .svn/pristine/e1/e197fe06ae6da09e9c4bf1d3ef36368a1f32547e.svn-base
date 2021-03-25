
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
        colNames:[ '流水号','客户号', '客户名称','证件号码', '审批结果','拒绝原因','信用评分','授信额度','日利率（万分之）','错误码','错误信息','api流水号','响应日期'],
		colModel:[
					{
						sortable:false,
						name : 'querySeqNo',
						index : 'querySeqNo',
						width : 80
					}, {
						sortable:false,
						name : 'custNo',
						index : 'custNo',
						width : 80						
					}, {
						sortable:false,
						name : 'userName',
						index : 'userName',
						width : 30
					}, {
						sortable:false,
						name : 'idNumber',
						index : 'idNumber',
						width : 80
					},{
						sortable:false,
						name : 'decisionResult',
						index : 'decisionResult',
						width : 30,
						formatter: function(cellvalue){
							return ("01"==cellvalue)?"通过":"拒绝";
						}
					},{
						sortable:false,
						name : 'rejectReson',
						index : 'rejectReson',
						width : 80
					},{
						sortable:false,
						name : 'creditMark',
						index : 'creditMark',
						width : 40
					},{
						sortable:false,
						name : 'creditMoney',
						index : 'creditMoney',
						width : 40
					},{
						sortable:false,
						name : 'dayRate',
						index : 'dayRate',
						width : 40
					},{
						sortable:false,
						name : 'errorCode',
						index : 'errorCode',
						width : 50
					},{
						sortable:false,
						name : 'errorMsg',
						index : 'errorMsg',
						width : 80
					},{
						sortable:false,
						name : 'localSeqNo',
						index : 'localSeqNo',
						width : 80
					},{
						sortable:false,
						name : 'createDateTime',
						index : 'createDateTime',
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
		
		
		caption: "网贷响应数据列表",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/ol_response_data',
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
	    url:root+'/ol_response_data?custName='+$("#custName").val()+'&certNum='+$("#certNum").val(),
	    datatype : "json"
	}).trigger("reloadGrid");
}

/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
	$('#'+modalId).hide();
}