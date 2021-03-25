$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = $("#grid-pager");

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: 'auto',
		colNames:[ '序号', '产品名称', '业务发生时间', '数据源接口名称', '异常笔数'],
		colModel:[
			{
				sortable:false,
				name : 'exceptionID',
				index : 'exceptionID',
				width : 100,
			}, {
				sortable:false,
				name : 'productName',
				index : 'productName',
				width : 100		
			}, {
				sortable:false,
				name : 'exceptionTime',
				index : 'exceptionTime',
				width : 100
			}, {
				sortable:false,
				name : 'implName',
				index : 'implName',
				width : 100
			}, {
				sortable:false,
				name : 'exceptionCount',
				index : 'exceptionCount',
				width : 100
			}
			],
			viewrecords : true,
			rowNum:10,
			rowList : [ 10, 20, 30, 50, 100 ],
			pager : pager_selector,
			altRows: true,
			multiselect: true,
			multiboxonly: true,
			width: '100%',
			shrinkToFit: true,
			toolbar: [ true, "top" ,tool],
			loadComplete : function() {
				var table = this;
				setTimeout(function(){
					updatePagerIcons(table);
				}, 0);
			},
			caption: "异常信息监控",
			autowidth: true
	}).jqGrid('setGridParam', {
		page : 1,
		url:root+'/exceptionTransfer_service.do',
		datatype : "json"
	}).trigger("reloadGrid");
});

//查看异常信息
$(document).ready(function() {
	var grid_selector = "#exceptionSearch-table";
	var pager_selector = $("#exceptionSearch-pager");
	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '产品名称','异常发生时间','数据源接口名称','错误码','错误消息'],
		colModel:[
			{
				sortable:false,
				name : 'productName',
				index : 'productName',
				width : 100	
			}, {
				sortable:false,
				name : 'exceptionTime',
				index : 'exceptionTime',
				width : 100
			}, {
				sortable:false,
				name : 'implName',
				index : 'implName',
				width : 100
			}, {
				sortable:false,
				name : 'errorCode',
				index : 'errorCode',
				width : 100,
			}, {
				sortable:false,
				name : 'errorMsg',
				index : 'errorMsg',
				width : 100
			}
			],
			viewrecords : true,
			rowNum:10,
			rowList : [ 10, 20, 30, 50, 100 ],
			pager : pager_selector,
			altRows: true,
			multiselect: true,
			multiboxonly: true,
			width: '100%',
			shrinkToFit: true,
			loadComplete : function() {
				var table = this;
				setTimeout(function(){
					updatePagerIcons(table);
				}, 0);
			},
			caption: "异常信息详情查看",
			autowidth: true
	}).jqGrid('setGridParam', {
		page : 1,
		url:root+'/exceptionTransfer_info_service.do',
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
};

var tool = [ {
	text : '查看',
	iconCls : 'fa fa-search',
	handler : function() {
		var ids = $('#grid-table').jqGrid('getGridParam', 'selarrrow');
		if(ids.length==1){
			var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
			viewException(rowData);
		}else{
			alert("请选择一条记录！");
		}
	}
}, '-',{
	text : '重置',
	iconCls : 'fa fa-edit',
	handler : function() {
		$("#searchProduct").val("");
		$("#searchImpl").val("");
		$("#searchStatus").val(0);
		$("#startDate").val("");
		$("#endDate").val("");
		doSearch()
	}
}, '-', {
	text : '导出',
	iconCls : 'fa fa-plus',
	handler : function() {
		var productName = $("#searchProduct").val();
		var implName = $("#searchImpl").val();
		var searchStatus = $("#searchStatus").val();
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		var url = root+"/exceptionTransferExcel.do?implName="+implName+"&searchStatus="+searchStatus+"&startDate="+startDate+"&endDate="+endDate+"&productName="+productName;
		$.ajax({ 
			type:'post', 
			url: root+"/exceptionTransferExcel.do?implName="+implName+"&searchStatus="+searchStatus+"&startDate="+startDate+"&endDate="+endDate+"&productName="+productName, 
			async:false,
			dataType : "text",
			success:function(data){
					window.open(url);
					doSearch();				
			},
			error:function(){
				alert("访问服务器出错");        
			}
		});
	} 
}
];

function doSearch(){
	var productName = $("#searchProduct").val();
	var implName = $("#searchImpl").val();
	var searchStatus = $("#searchStatus").val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	$("#grid-table").jqGrid('setGridParam', {
		page : 1,
		url:root+'/exceptionTransfer_service.do',
		postData : {productName:productName, implName:implName, searchStatus:searchStatus,
			startDate:startDate, endDate:endDate},
		datatype : "json"
	}).trigger("reloadGrid");
}

function viewException(data){
	var implName = data.implName;
	var productName = data.productName;
	var exceptionTime = data.exceptionTime;
	$("#exceptionSearch-table").jqGrid('setGridParam', {
		page : 1,
	    url:root+'/exceptionTransfer_info_service.do',
	    postData : {implName:implName, productName:productName, exceptionTime:exceptionTime},
	    datatype : "json"
	}).trigger("reloadGrid");
	$('#exceptionSearch').modal('show');
}

/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
	$('#'+modalId).hide();
}
