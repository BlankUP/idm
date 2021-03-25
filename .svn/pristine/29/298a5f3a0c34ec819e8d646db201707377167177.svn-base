/**
 * @author wengjiawei
 * @Date 2019-03-18
 * @js adb规则文件审批记录
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


//审批信息展示列表
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = $("#grid-pager");

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: 'auto',
		colNames:[ '版本名称','版本号','申请审批时间','申请理由','申请审批人','审批人','审批时间','审批意见','审批等级','审批结果'],
		colModel:[
					{
						sortable:false,
						name : 'versionName',
						index : 'versionName',
						width : 60
						
					}, {
						sortable:false,
						name : 'versionNo',
						index : 'versionNo',
						width : 60
						
					}, {
						sortable:false,
						name : 'applicationTime',
						index : 'applicationTime',
						width : 60
					},
					{
						sortable:false,
						name : 'applicationReason',
						index : 'applicationReason',
						width : 100
					},{
						sortable:false,
						name : 'applicationUser',
						index : 'applicationUser',
						width : 40
					},{
						sortable:false,
						name : 'approveUser',
						index : 'approveUser',
						width : 40
					},{
						sortable:true,
						name : 'approveTime',
						index : 'approveTime',
						width : 60
					},{
						sortable:true,
						name : 'approveAdvise',
						index : 'approveAdvise',
						width : 100
					},{
						sortable:false,
						name : 'approveLevel',
						index : 'approveLevel',						
						width : 40,
						formatter: function(cellvalue, options, rowObject){
							if(cellvalue==1){
								return "<span>一级审批</span>";
							}else if(cellvalue==2){
								return "<span>二级审批</span>";
							}
						}
					},{
						sortable:false,
						name : 'result',
						index : 'result',						
						width : 40,
						formatter: function(cellvalue, options, rowObject){
							if(cellvalue==0){
								return "<span>审批未通过</span>";
							}else if(cellvalue==1){
								return "<span>审批通过</span>";
							}
						}
					}
					],
	    //sortable : true,
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
		caption: "模型质检审批记录",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/mqi_approveRecord_search.do',
	    datatype : "json"
	}).trigger("reloadGrid");
});

var matchTool = [ 
    {
 	   text: '查看详情' , iconCls: 'fa fa-edit', handler: function () {
 		   var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
 		   if(ids.length==1){
 			   var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
 			   openModalWin('check',rowData);
 		   }else{
 			   alert("请选择一条记录！");
 		   }
 	   }
    }
];

//审批记录
function openModalWin(type,data){
		$('#approveRecordTitle').html("查看记录详情");
		
		$('#approveRecord_option').val("check");
		data.approveLevel  = approveLevelChange(data);
		data.result  = resultChange(data);
//		更新版本名称
		$("#versionName").val(data.versionName);
		$("#versionName").attr('readOnly','readOnly');
		$("#versionNo").val(data.versionNo);
		$("#versionNo").attr('readOnly','readOnly');
		$("#applicationTime").val(data.applicationTime);
		$("#applicationTime").attr('readOnly','readOnly');
		$("#applicationReason").val(data.applicationReason);
		$("#applicationReason").attr('readOnly','readOnly');
		$("#applicationUser").val(data.applicationUser);
		$("#applicationUser").attr('readOnly','readOnly');
		$("#approveUser").val(data.approveUser);
		$("#approveUser").attr('readOnly','readOnly');		
		$("#approveTime").val(data.approveTime);
		$("#approveTime").attr('readOnly','readOnly');
		$("#approveAdvise").val(data.approveAdvise);
		$("#approveAdvise").attr('readOnly','readOnly');
		$("#approveLevel").val(data.approveLevel);
		$("#approveLevel").attr('disabled',true);
		$("#result").val(data.result);
		$("#result").attr('disabled',true);
		$("#approveRecordModal").modal("show");
}

//将列表展示的值转换为状态描述
function approveLevelChange(data){
	if(data.approveLevel == '<span>一级审批</span>'){
		return "1";
    }else if(data.approveLevel == '<span>二级审批</span>'){
		return "2";
	}	 		
};

function resultChange(data){
	if(data.result == '<span>审批未通过</span>'){
		return "0";
    }else if(data.result == '<span>审批通过</span>'){
		return "1";
	}	 		
};

//根据版本号查询版本信息
function doSearch(){
	var versionNo = $("#searchVersionInfo").val();
	var versionNoStr = encodeURIComponent(versionNo);	
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/mqi_approveRecord_search.do?versionNo='+versionNoStr,
	    datatype : "json"
	}).trigger("reloadGrid");
}

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