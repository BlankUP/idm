var tool = [
	{ text: '查看数据详情' , iconCls: 'fa fa-search', handler: function () {
		var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
		if(ids.length==1){
			var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
			openModalWin('view',rowData);
		}else{
			alert("请选择一条记录！");
		}} 
	}
 ];
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	
	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '唯一标识','业务流水号','表名', 'SQL语句','数据','创建时间','是否操作','操作状态','操作人','操作时间','操作详细'],
		colModel:[
					{
						sortable:false,
						name : 'asyStoredId',
						index : 'asyStoredId',
						width : 10,
						hidden : true
					},{
						sortable:false,
						name : 'businessNo',
						index : 'businessNo',
						width : 20
					}, {
						sortable:false,
						name : 'tableName',
						index : 'tableName',
						width : 20
					}, {
						sortable:false,
						name : 'executeSql',
						index : 'executeSql',
						width : 30,
						hidden : true
					}, {
						sortable:false,
						name : 'data',
						index : 'data',
						width : 30,
						hidden : true
					},{
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 25
					},{
						sortable:false,
						name : 'status',
						index : 'status',
						width : 15,
						formatter: "select",
						editoptions:{value:"0:未操作;1:已操作"}
					},{
						sortable:false,
						name : 'operateStatus',
						index : 'operateStatus',
						width : 15,
						formatter: "select",
						editoptions:{value:"0:未操作;1:操作成功;2:操作失败"}
					},{
						sortable:false,
						name : 'operateUser',
						index : 'operateUser',
						width : 15
					},{
						sortable:false,
						name : 'operateTime',
						index : 'operateTime',
						width : 25
					},{
						sortable:false,
		                width : 15,
		                formatter: function(cellvalue, options, rowObject){
		                	//当状态为0且操作状态为（0或2）且sql不能为空时，显示“重新插入”
		                	var status = rowObject.status;
		                	var operateStatus = rowObject.operateStatus;
		                	var executeSql = rowObject.executeSql;
		                	if(executeSql!=null&&executeSql!=""&&executeSql!="undefined")
		                		executeSql = executeSql.replace(/'/g,'"');
		                	var asyStoredId = rowObject.asyStoredId;
		                	if((status=='0'||status=='1')&&(operateStatus=='0'||operateStatus=='2')&&executeSql!=null&&executeSql!=""&&executeSql!="undefined")
		                		return '<a href="javascript:void(0)" onclick="reinsert(\''+asyStoredId+'\');">重新插入</a>';
		                	else
		                		return '<label><label>';
		                }
		            }
				],
			viewrecords : true,
			rowNum:10,
			rowList:[10,20,30,50,100],
			pager : pager_selector,
			toolbar: [ true, "top" ,tool],
			altRows: true,
			multiselect: true,
		    multiboxonly: true,

			loadComplete : function() {
				var table = this;
				setTimeout(function(){
					updatePagerIcons(table);
				}, 0);
			},

			caption: "异步存储异常信息列表",
			autowidth: true
		}).jqGrid('setGridParam', {
			page : 1,
			url:root+'/idp_asyStorageException_info.do',
			datatype : "json"
		}).trigger("reloadGrid");

	}); 

/**
 * 调整分页图标
 */
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

/**
 * 查询
 */
function doSearch(){
	var businessNo = encodeURIComponent(encodeURIComponent($("#businessNo").val()));
	var createTime = encodeURIComponent(encodeURIComponent($("#createTime").val()));
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{businessNo:businessNo,createTime:createTime},
	    url:root+'/idp_asyStorageException_info',
	    datatype : "json"
	}).trigger("reloadGrid");
}

/**
* 根据类型打开模态框 
*  load模窗口的数据
* @param type
* @param rowdata
*/
function openModalWin(type, rowData){
	if(type=='view'){
		$("#busiDetailModal").modal('show');
    	$('#busiDetail').html("查看数据信息和sql内容详情");
		$("#businessNo2").val(rowData.businessNo);
		$("#sqlDetail").val(rowData.executeSql);
		$("#dataContent").val(rowData.data);
		
	}
}

/**
 * 重新插入数据
 * @param asyStoredId
 * @param executeSql
 */
function reinsert(asyStoredId){
	$.ajax({ 
        type:'post',
        url:root+'/'+"idp_asyStorageException_reinsert.do", 
        data:{"asyStoredId":asyStoredId}, 
        dataType: "json",
        success:function(msg){
           if(msg.isPass==true){
               alert("操作成功！");             //弹出成功msg
           }else{
               alert("操作失败！");            //弹出失败msg
           }
           doSearch();                       //刷新表格数据
        },
        error:function(msg){
           alert("访问服务器出错");        
        }
   });
}

/**
 * 对table的大小随页面变化而变化
 */
$(function(){
    $(window).resize(function(){  
	 $("#grid-table").setGridWidth($(window).width());
	});
});