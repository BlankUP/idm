/**
 * 用户操作日志查看
 */

function requestService(url,reqData,callbackFn){
		$.ajax({ 
	         type:'post', 
	         url:url, 
	         data:reqData, 
	         success:function(data){
	            if(data.msg=='success'){
	            	callbackFn(data);  
	            }else{
	            	alert(data.msg);  //弹出失败msg
	            }
	         },
	         error:function(data){
		        alert("访问服务器出错");  
	         }
	    });
}

//日志内容查询
function doSearch(){
	var userId = $("#searchOperator").val();
	var operatTime = $("#searchOperatTime").val();
	var operatType = $("#searchOperatType").val();
	var userIdStr = encodeURIComponent(userId);
	var operatTimeStr = encodeURIComponent(operatTime);
	var operatTypeStr = encodeURIComponent(operatType);	
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/log_search.do?userId='+userIdStr+'&operatTime='+operatTimeStr+'&operatType='+operatTypeStr,
	    datatype : "json"
	}).trigger("reloadGrid");
}

//详情查看
function openModalWin(type, data){
	$('#logInfoTitle').html("日志详情");
	$('#logInfo_option').val("check");
	$("#userId").val(data.userName);
	$("#userId").attr('readOnly','readOnly');
	$("#operatTime").val(data.operatTime);
	$("#operatTime").attr('readOnly','readOnly');
	$("#operatModule").val(data.operatModule);
	$("#operatModule").attr('readOnly','readOnly');
	$("#operatType").val(data.operatType);
	$("#operatType").attr('readOnly','readOnly');
	$("#operatData").val(data.operatData);
	$("#operatData").attr('readOnly','readOnly');
	$("#createTime").val(data.createTime);
	$("#createTime").attr('readOnly','readOnly');
	$("#logInfoModal").modal('show');
}

//日志展示列表
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = $("#grid-pager");

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: 'auto',
		colNames:[ '编号', '操作用户','操作时间','操作模块','操作类型','创建时间' ],
		colModel:[
					{
						sortable:false,
						name : 'id',
						index : 'id',
						width : 100
					}, {
						sortable:false,
						name : 'userName',
						index : 'userName',
						width : 100
						
					}, {
						sortable:false,
						name : 'operatTime',
						index : 'operatTime',
						width : 100
					},{
						sortable:false,
						name : 'operatModule',
						index : 'operatModule',
						width : 100
					}, {
						sortable:false,
						name : 'operatType',
						index : 'operatType',
						width : 100
					},{
						sortable:false,
						name : 'createTime',
						index : 'createTime',
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
        toolbar: [ true, "top" ,matchTool],
        loadComplete : function() {
        	var table = this;
			setTimeout(function(){
				updatePagerIcons(table);
			}, 0);
		},
		caption: "日志信息",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/log_search.do',
	    datatype : "json"
	}).trigger("reloadGrid");
});

var matchTool = [ 
	    {
			text: '查看详情' , iconCls: 'fa fa-search', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('viewLogInfo',rowData);
				}else{
					alert("请选择一条记录！");
				}
			}
		}
	];

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
