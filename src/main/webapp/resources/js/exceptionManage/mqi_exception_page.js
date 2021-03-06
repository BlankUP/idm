var tool = [
	{ text: '查看业务详细信息' , iconCls: 'fa fa-search', handler: function () {
		var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
		if(ids.length==1){
			var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
			openModalWin('view',rowData);
		}else{
			alert("请选择一条记录！");
		}
	   
	} 
		}/*,{ text: '批量重跑' , iconCls: 'fa fa-search', handler: function () {
			batchRet();
		   
			} 
		}*/
	];

$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '业务请求日期','请求流水号', '业务流水号','错误代码','错误信息','业务请求完整报文','异常堆栈信息','业务重跑日期','重跑操作员','重跑结果','请求系统编码','请求系统名称','响应系统编码','响应系统名称','异常业务重跑'],
		colModel:[
					{
						sortable:false,
						name : 'srcDate',
						index : 'srcDate',
						width : 50
					}, {
						sortable:false,
						name : 'serialNo',
						index : 'serialNo',
						width : 80
					}, {
						sortable:false,
						name : 'businessNo',
						index : 'businessNo',
						width : 120
					}, {
						sortable:false,
						name : 'errorCode',
						index : 'errorCode',
						width : 50
					}, {
						sortable:false,
						name : 'errorMsg',
						index : 'errorMsg',
						width : 100
					},
					{
						sortable:false,
						name :'requestPkg',
						index :'requestPkg',
						hidden: true,
						width : 50
					},
					{
						sortable:false,
						name : 'exStackTrace',
						index : 'exStackTrace',
						hidden: true,
						width : 50
					},
					{
						sortable:false,
						name : 'reBusinessDate',
						index : 'reBusinessDate',
						width : 50
					},
					/*{
						sortable:false,
						name : 'reBusinessNo',
						index : 'reBusinessNo',
						width : 100
					},*/
					{
						sortable:false,
						name : 'reBusinessOperator',
						index : 'reBusinessOperator',
						width : 50
					},
					{
						sortable:false,
						name : 'reBusinessResult',
						index: 'reBusinessResult',
						width: 50
					},
					{
						sortable:false,
						name : 'querySystemCode',
						index: 'querySystemCode',
						hidden: true,
						width: 50
					},
					{
						sortable:false,
						name : 'querySystemName',
						index: 'querySystemName',
						hidden: true,
						width: 100
					},
					{
						sortable:false,
						name : 'respSystemCode',
						index: 'respSystemCode',
						hidden: true,
						width: 50
					},
					{
						sortable:false,
						name : 'respSystemName',
						index: 'respSystemName',
						hidden: true,
						width: 100
					},
					 {
		                width : 50,
		                formatter: function (cellvalue, options, rowObject) {
		                	if("MOD_NB"==rowObject.errorCode.slice(0,6)|| "MOD_LC"==rowObject.errorCode.slice(0,6)){
		                		if("发起成功"==rowObject.reBusinessResult){
		                			return '<label><label>'
		                		}else{
		                			 return '<a href="javascript:void(0)" onclick="doReBusiness(\'' + rowObject.srcDate+ '\',' +
			                          '\''+rowObject.serialNo+'\',\''+rowObject.businessNo+'\')">执行</a>'
		                		}
		                	}else{
		                		 return '<label><label>'
		                		}
		                   
		                }
		            }
				],
				viewrecords : true,
				rowNum:10,
				rowList:[10,20,30,50,100],
				pager : pager_selector,
				altRows: true,
				multiselect: true,
		        multiboxonly: true,
		        toolbar: [ true, "top" ,tool],
		        loadComplete : function() {
		        var table = this;
			setTimeout(function(){
				updatePagerIcons(table);
			}, 0);
		},
		
		
		caption: "模型质检系统异常列表",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/mqi_exception_info',
	    datatype : "json"
	}).trigger("reloadGrid");
});

var businessNo2="";
var reqBlaze="";
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
	    postData:{"serialNo":$("#serialNo").val(),"srcDate":$("#srcDate").val()},
	    url:root+'/mqi_exception_info',
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

/**
* 根据类型打开模态框 
*  load模窗口的数据
* @param type
* @param rowdata
*/
function openModalWin(type, rowData){
	if(type=='view'){
		$("#busiDetailModal").modal('show');
    	$('#busiDetail').html("业务详细信息");
		$("#srcDate2").val(rowData.srcDate);
		$("#serialNo2").val(rowData.serialNo);
		$("#businessNo").val(rowData.businessNo);
		$("#errorCode").val(rowData.errorCode);
		$("#errorMsg").val(rowData.errorMsg);
		$('#requestPkg').val(rowData.requestPkg);
		$('#traceStack').val(rowData.exStackTrace);
		
	}
}

/**
 * 查询调用引擎的入参数据
 * @author sjf
 */
function queryInvokeBlazeData(businessNo){
	$.ajax({
		 type:'get',
	     url:root+'/mqi_invokeblazedata.do',
	     data:{businessNo:businessNo},
	     dataType:"json",
	     success:function(data){
	    	var retCode=data.retCode;
	    	if(retCode=='1'){
	    		alert(data.retMsg);
	    	}
	    	if(retCode=='0'){
	    		//$('#businessNo2').val(businessNo);
	    		businessNo2=businessNo;
	    		$("#invokeBlazeData").val(data.retMsg);
	    		$("#viewReqBlazeModal").modal('show');
	        	$('#viewReqBlaze').html("决策引擎的入参");
	    	}
	     },
	     error:function(msg){
	    	 alert("服务调用失败");
	        }
	});
}

/**
 * 业务重跑
 * @author pl
 */
function doReBusiness(srcDate,serialNo,businessNo){
	$.ajax({ 
		type:'post', 
        url:root+'/mqi_redobusiness.do', 
        data:{"srcDate":srcDate,"serialNo":serialNo,"businessNo":businessNo},
        success:function(data){
           if(data.retCode=='0'){
           	alert("业务重跑已成功发起");
           }else{
        	 alert(data.retMsg);
           }
           doSearch();
        },
        error:function(data){
        	alert("服务调用失败");
        }
   });
}
function batchRet(){
	$.ajax({ 
        type:'post', 
        url:root+'/mqi_batchredo.do', 
        success:function(data){
           doSearch();
        },
        error:function(data){
        	alert("重跑发起失败");
        }
   });
}
$(function(){
	$(window).resize(function(){  
	$("#grid-table").setGridWidth($(window).width());
	 });
	 });

