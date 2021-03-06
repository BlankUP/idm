/**
 * @author wengjiawei
 * @Date 2019-03-11
 * @js adb规则文件审批
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
		colNames:[ '版本名称','版本号','版本描述','申请审批时间','申请理由','申请审批人','审批状态'],
		colModel:[
				      {
							sortable:false,
							name : 'versionName',
							index : 'versionName',
							width : 60
							
					},
					{
						sortable:false,
						name : 'versionNo',
						index : 'versionNo',
						width : 60
						
					},{
						sortable:false,
						name : 'versionDesc',
						index : 'versionDesc',
						width : 100
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
						name : 'applicationUserId',
						index : 'applicationUserId',
						width : 40
					},
					{
						sortable:false,
						name : 'status',
						index : 'status',						
						width : 40,
						formatter: function(cellvalue, options, rowObject){
							if(cellvalue==0){
								return "<span>已审批通过</span>";
							}else if(cellvalue==1){
								return "<span>待一级审批</span>";
							}else if(cellvalue==2){
								return "<span>待二级审批</span>";
							}else if(cellvalue==3){
								return "<span>审批未通过</span>";
							}
						}
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
		caption: "模型质检adb文件审批",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/mqi_adbApprove_search.do',
	    datatype : "json"
	}).trigger("reloadGrid");
});

var matchTool = [ 
    {
 	   text: '审批文件' , iconCls: 'fa fa-edit', handler: function () {
 		   var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
 		   if(ids.length==1){
 			   var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
 			   openModalWin('update',rowData);
 		   }else{
 			   alert("请选择一条记录！");
 		   }
 	   }
    }
];

//将列表展示的值转换为状态描述
function statusChange(data){
	if(data.status == '<span>已审批通过</span>'){
		return "0";
	}else if(data.status == '<span>待一级审批</span>'){
		return "1";
	}else if(data.status == '<span>待二级审批</span>'){
		return "2";
	}else if(data.status == '<span>待审批未通过</span>'){
		return "3";
	} 	 		
};

//审批提醒
function openModalWin(type,data){
	if(type == 'update'){
		$('#adbApproveTitle').html("审批以下版本的adb文件");
		$('#adbApprove_option').val("update");
		data.status  =statusChange(data);
		$("#versionName").val(data.versionName);
		$("#versionName").attr('readOnly','readOnly');
		$("#versionNo").val(data.versionNo);
		$("#versionNo").attr('readOnly','readOnly');
		$("#versionDesc").val(data.versionDesc);
		$("#versionDesc").attr('readOnly','readOnly');
		$("#applicationTime").val(data.applicationTime);
		$("#applicationTime").attr('readOnly','readOnly');
		$("#applicationUserId").val(data.applicationUserId);
		$("#applicationUserId").attr('readOnly','readOnly');
		$("#applicationReason").val(data.applicationReason);
		$("#applicationReason").attr('readOnly','readOnly');		
		$("#status").val(data.status);
		$("#status").attr('disabled',true);
		$("#reason").val("");
		$("#adbApproveModal").modal("show");
	}
}

//根据版本号查询版本信息
function doSearch(){	
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/mqi_adbApprove_search.do',
	    datatype : "json"
	}).trigger("reloadGrid");
}


var validator = null;
$(document).ready(function() {
	validator = $("#dataFrom").validate({
		rules : {
			versionName : {
				required : true,		
				
			},
			versionNo : {
				required : true,
				rangelength : [ 0, 50 ]
			},
			versionDesc: {
				rangelength : [ 0, 200 ]
			},
			applicationTime : {
				required : true
			},
			applicationReason : {
				required : true
			},
			applicationUserId : {
				required : true
			},
			
			reason : {
				required : true,
				rangelength : [ 0, 200 ]
			}
		},
		focusCleanup : true
	});
});
//审批通过adb文件
function adbApprove(){	
	 /*var data = $("#dataFrom").serialize(); 
	 var approveAdvise = $("#reason").val();
	 if(approveAdvise != null && approveAdvise != ""){*/
	if($("#dataFrom").valid()){
		
		var data = $('#dataFrom').serialize();
		 $.ajax({
			 type: "post",
		     url: root+'/mqi_adbApprove_application.do',
		     data:data, 
		     dataType: "json",
		     success: function(data){
		    	
		    	 if($('#adbApprove_option').val()=="update"){
		    		 if(data.success == true) {
		    			 alert("该版本的adb文件审批通过！");
		    			 $("#adbApproveModal").modal("toggle");
		    			 doSearch();
		    		 }else if(data.success==false && data.msg!=undefined){
		    			 alert(data.msg);
		    		 }else{
		    			 alert("审批失败！");
		    		 }
		    	 }else{
		    		 if(data.success == true) {
		    			 alert("该版本的adb文件审批通过！");
		    			 doSearch();
		    		 }else alert("审批失败！");
		    	 }
		     },
		     error: function () {  
		         alert("操作失败！");  
		     }  
		 });
		 doSearch(); 
	 /*}else{
		 alert("审批意见不能为空！");
	 }*/
}
}

//拒绝通过该版本的adb文件
function adbReject(){	 
	 var data = $('#dataFrom').serialize(); 
	 var approveAdvise = $("#reason").val();
	 if(approveAdvise != null && approveAdvise != ""){
		 $.ajax({
			 type: "post",
		     url: root+'/mqi_adbReject_application.do',
		     data:data, 
		     dataType: "json",
		     success: function(data){
		    	 if($('#adbApprove_option').val()=="update"){
		    		 if(data.success == true) {
		    			 alert("该版本的adb文件审批为不通过！");
		    			 $("#adbApproveModal").modal("toggle");
		    			 doSearch();
		    		 }else if(data.success==false && data.msg!=undefined){
		    			 alert(data.msg);
		    		 }else{
		    			 alert("审批失败！");
		    		 }
		    	 }else{
		    		 if(data.success == true) {
		    			 alert("该版本的adb文件审批不通过！");
		    			 doSearch();
		    		 }else alert("审批失败！");
		    	 }
		     },
		     error: function () {  
		         alert("操作失败！");  
		     }  
		 });
		 doSearch();
	 }else{
		 alert("审批意见不能为空！");
	 }
	
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