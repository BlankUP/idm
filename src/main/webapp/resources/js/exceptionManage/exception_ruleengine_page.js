
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '流水号','证件号码', '错误代码','错误类型', '错误信息', '错误日期'],
		colModel:[
					{
						sortable:false,
						name : 'queryseqno',
						index : 'queryseqno',
						width : 60
					}, {
						sortable:false,
						name : 'idnumber',
						index : 'idnumber',
						width : 60
					}, {
						sortable:false,
						name : 'errorcode',
						index : 'errorcode',
						width : 30
					}, {
						sortable:false,
						name : 'errortype',
						index : 'errortype',
						width : 50
					}, {
						sortable:false,
						name : 'errormessage',
						index : 'errormessage',
						width : 120
					},{
						sortable:false,
						name : 'createtime',
						index : 'createtime',
						width : 50
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
		
		
		caption: "规则引擎异常数据列表",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/exception_ruleengine_data',
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
	    url:root+'/exception_ruleengine_data?querySeqNo='+$("#querySeqNo").val(),
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