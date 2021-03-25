$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = $("#grid-pager");

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: 'auto',
		colNames:[ '序号', '业务发生时间', '数据源接口名称', '调用笔数', '调用成功笔数', '调用成功率', '平均响应时间', '最大响应时间' ],
		colModel:[
			{
				sortable:false,
				name : 'implID',
				index : 'implID',
				width : 100,
			}, {
				sortable:false,
				name : 'implTime',
				index : 'implTime',
				width : 100		
			}, {
				sortable:false,
				name : 'implName',
				index : 'implName',
				width : 100
			}, {
				sortable:false,
				name : 'allUse',
				index : 'allUse',
				width : 100
			}, {
				sortable:false,
				name : 'sucUse',
				index : 'sucUse',
				width : 100
			}, {
				sortable:false,
				name : 'sucRate',
				index : 'sucRate',
				width : 100
			}, {
				sortable:false,
				name : 'avgTime',
				index : 'avgTime',
				width : 100,
			}, {
				sortable:false,
				name : 'maxTime',
				index : 'maxTime',
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
			caption: "接口调用监控",
			autowidth: true
	}).jqGrid('setGridParam', {
		page : 1,
		url:root+'/implTransfer_service.do',
		datatype : "json"
	}).trigger("reloadGrid");
});


//查看接口详情
$(document).ready(function() {
	var grid_selector = "#implSearch-table";
	var pager_selector = $("#implSearch-pager");
	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '接口名称','是否成功','开始时间','结束时间','接口耗时','错误码','错误消息'],
		colModel:[
			{
				sortable:false,
				name : 'interfaceName',
				index : 'interfaceName',
				width : 100
			}, {
				sortable:false,
				name : 'isSuccess',
				index : 'isSuccess',
				width : 100
			}, {
				sortable:false,
				name : 'startTime',
				index : 'startTime',
				width : 100
			}, {
				sortable:false,
				name : 'endTime',
				index : 'endTime',
				width : 100,
			}, {
				sortable:false,
				name : 'elapsedTime',
				index : 'elapsedTime',
				width : 100
			}, {
				sortable:false,
				name : 'errorCode',
				index : 'errorCode',
				width : 100
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
			caption: "接口调用详情查看",
			autowidth: true
	}).jqGrid('setGridParam', {
		page : 1,
		url:root+'/implTransfer_info_service.do',
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
			viewImpl(rowData);
		}else{
			alert("请选择一条记录！");
		}
	}
}, '-',{
	text : '重置',
	iconCls : 'fa fa-edit',
	handler : function() {
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
		var implName = $("#searchImpl").val();
		var searchStatus = $("#searchStatus").val();
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		var url = root+"/implTransferExcel.do?implName="+implName+"&searchStatus="+searchStatus+"&startDate="+startDate+"&endDate="+endDate;
		$.ajax({ 
			type:'post', 
			url: root+"/implTransferExcel.do?implName="+implName+"&searchStatus="+searchStatus+"&startDate="+startDate+"&endDate="+endDate, 
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
	var implName = $("#searchImpl").val();
	var searchStatus = $("#searchStatus").val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	$("#grid-table").jqGrid('setGridParam', {
		page : 1,
		url:root+'/implTransfer_service.do',
		postData : {implName:implName, searchStatus:searchStatus,
			startDate:startDate, endDate:endDate},
		datatype : "json"
	}).trigger("reloadGrid");
}

function viewImpl(data){
	var implTime = data.implTime;
	var implName = data.implName;
	$("#implSearch-table").jqGrid('setGridParam', {
		page : 1,
	    url:root+'/implTransfer_info_service.do',
	    postData : {implTime:implTime, implName:implName},
	    datatype : "json"
	}).trigger("reloadGrid");
	$('#implSearch').modal('show');
}

/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
	$('#'+modalId).hide();
}