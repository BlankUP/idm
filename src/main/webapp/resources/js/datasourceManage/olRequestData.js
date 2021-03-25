
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '流水号','客户号', '客户名称','证件号码', '手机号码', '产品名称', '征信授权书编号','api流水号','请求日期'],
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
					}, {
						sortable:false,
						name : 'phoneNo',
						index : 'phoneNo',
						width : 50
					},{
						sortable:false,
						name : 'productName',
						index : 'productName',
						width : 80
					},{
						sortable:false,
						name : 'authorizationCode',
						index : 'authorizationCode',
						width : 80
					},{
						sortable:false,
						name : 'localSeqNo',
						index : 'localSeqNo',
						width : 80
					},{
						sortable:false,
						name : 'createTime',
						index : 'createTime',
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
		
		
		caption: "网贷请求数据列表",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/ol_request_data',
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
	    url:root+'/ol_request_data?custName='+$("#custName").val()+'&certNum='+$("#certNum").val(),
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