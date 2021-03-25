/**
 * @author wengjiawei
 * @Date 2019-03-04
 * @js adb规则文件版本管理
 */

//根据版本号查询版本信息
function doSearch(){
	var versionNo = $("#searchVersionInfo").val();
	console.info("versionNo",versionNo);
	var str = encodeURIComponent(versionNo);
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/adbVersion_search.do?versionNo='+str,
	    datatype : "json"
	}).trigger("reloadGrid");
}

var descForPublish = "";
//详情查看、修改版本信息
function openModalWin(type,data){
	if(type == 'check'){
		$('#check_adbVersionTitle').html("版本信息详情");
		$('#check_adbVersion_option').val("check");
		data.versionState  =versionStateChange(data);		
		data.isValid = isValidChange(data);
		//版本名称更新
		$("#check_versionName").val(data.versionName);
		$("#check_versionName").attr('readOnly','readOnly');
		
		$("#check_versionNo").val(data.versionNo);
		$("#check_versionNo").attr('readOnly','readOnly');
		$("#check_fileName").val(data.fileName);
		$("#check_fileName").attr('readOnly','readOnly');
		$("#check_versionDesc").val(data.versionDesc);
		$("#check_versionDesc").attr('readOnly','readOnly');
		$("#check_createTime").val(data.createTime);
		$("#check_createTime").attr('readOnly','readOnly');
		$("#check_createUser").val(data.createUser);
		$("#check_createUser").attr('readOnly','readOnly');
		$("#check_updateTime").val(data.updateTime);
		$("#check_updateTime").attr('readOnly','readOnly');
		$("#check_updateUser").val(data.updateUser);
		$("#check_updateUser").attr('readOnly','readOnly');
		$("#check_versionState").val(data.versionState);
		$("#check_versionState").attr('disabled',true);
		$("#check_isValid").val(data.isValid);
		$("#check_isValid").attr('disabled',true);
		$("#check_adbVersionModal").modal('show');
	}else if(type == 'modify'){
		$('#adbVersionTitle').html("修改信息");
		$('#adbVersion_option').val("modify");
		data.versionState  =versionStateChange(data);		
		data.isValid = isValidChange(data);
		//版本名称
		$("#versionName").val(data.versionName);
		$("#versionName").attr('readOnly','readOnly');
		
		$("#versionNo").val(data.versionNo);
		$("#versionNo").attr('readOnly','readOnly');
		$("#fileName").val(data.fileName);
		$("#fileName").attr('readOnly','readOnly');
		//版本描述
		$("#versionDesc").val(data.versionDesc);
		$("#versionDesc").removeAttr('readOnly');
		$("#createTime").val(data.createTime);
		$("#createTime").attr('readOnly','readOnly');
		$("#createUser").val(data.createUser);
		$("#createUser").attr('readOnly','readOnly');
		$("#updateTime").val(data.updateTime);
		$("#updateTime").attr('readOnly','readOnly');
		$("#updateUser").val(data.updateUser);
		$("#updateUser").attr('readOnly','readOnly');
		$("#versionState").val(data.versionState);
		$("#versionState").attr('disabled',true);
		//有效状态
		$("#isValid").val(data.isValid);
		$("#isValid").attr('disabled',false);
		$("#adbVersionModal").modal('show');
	}else if(type == 'add'){
		$('#d_versionName').hide();
		
		$('#uploadFileTitle').html("新增adb版本");
		$("#c_versionName").val('');
		$("#c_versionName").removeAttr('readOnly');
		getVersionNo(data);
		$("#newVerNo").val(getVersionNo(data));
		$("#versionDesc_add").val('');
		$("#versionDesc_add").attr('placeholder','请输入版本描述……');
		$("#versionDesc_add").removeAttr('readOnly');
		/*$("#newVerNo").val(versionNo);
		$("#newVerNo").attr('readOnly','readOnly');*/
		iscleck=true;
		$("#uploadFileModal").modal('show');		
	}else if(type == 'publish'){
		$('#publishTitle').html("申请发布");
		//版本名称增加
		$("#publishVersionName").val(data.versionName);
		$("#publishVersionName").attr('readOnly','readOnly');
		console.info("data.versionName---",data.versionName);
		$("#publishVerNo").val(data.versionNo);
		$("#publishVerNo").attr('readOnly','readOnly');
		$("#applicationReason").val("");
		
		$("#descForPublish").val(data.versionDesc);
		console.info("data.versionDesc---",data.versionDesc);
		$("#descForPublish").attr('readOnly','readOnly');
		
		$("#publishModal").modal('show');
	}	
}

//版本信息展示列表
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = $("#grid-pager");

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: 'auto',
		colNames:[ '版本名称','版本号','版本描述','创建人','创建日期','修改人','修改日期','状态','是否有效' ],
		colModel:[
					{
						sortable:false,
						name : 'versionName',
						index : 'versionName',
						width : 100
						
					},{
						sortable:false,
						name : 'versionNo',
						index : 'versionNo',
						width : 100
						
					},{
						sortable:false,
						name : 'versionDesc',
						index : 'versionDesc',
						width : 100
					}, {
						sortable:false,
						name : 'createUser',
						index : 'createUser',
						width : 100
					}, {
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 100
					},
					{
						sortable:false,
						name : 'updateUser',
						index : 'updateUser',
						width : 100
					},
					{
						sortable:false,
						name : 'updateTime',
						index : 'updateTime',
						width : 100						
					},
					{
						sortable:false,
						name : 'versionState',
						index : 'versionState',						
						width : 100,
						formatter: function(cellvalue, options, rowObject){
							if(cellvalue==0){
								return "<span>新版本</span>";
							}else if(cellvalue==1){
								return "<span>正在使用</span>";
							}else if(cellvalue==2){
								return "<span>审批通过，待发布</span>";
							}else if(cellvalue==3){
								return "<span>待一级审批</span>";
							}else if(cellvalue==4){
								return "<span>待二级审批</span>";
							}else if(cellvalue==5){
								return "<span>历史版本</span>";
							}else if(cellvalue==6){
								return "<span>审批未通过</span>";
							}
						}
					},
					{
						sortable:false,
						name : 'isValid',
						index : 'isValid',						
						width : 100,
						formatter: function(cellvalue, options, rowObject){
							if(cellvalue==0){
								return "<span>无效</span>";
							}else if(cellvalue==1){
								return "<span>有效</span>";
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
		caption: "adb版本管理",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/adbVersion_search.do',
	    datatype : "json"
	}).trigger("reloadGrid");
});

var matchTool = [ 
	       {text: '新增版本' , iconCls: 'fa fa-plus', handler: function () {
					openModalWin('add');
				}
	       },{
	    	   text: '查看详情' , iconCls: 'fa fa-search', handler: function () {
	    		   var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
	    		   if(ids.length==1){
	    			   var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
	    			   openModalWin('check',rowData);
	    		   }else{
	    			   alert("请选择一条记录！");
	    		   }
	    	   }
	       },{
	    	   text: '修改信息' , iconCls: 'fa fa-edit', handler: function () {
	    		   var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
	    		   if(ids.length==1){
	    			   var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
	    			   openModalWin('modify',rowData);
	    		   }else{
	    			   alert("请选择一条记录！");
	    		   }
	    	   }
	       },
	       //屏蔽删除按钮
	       /*{
	    	   text: '删除版本' , iconCls: 'fa fa-remove', handler: function () {
	    		   var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
	    		   if(ids.length==1){
						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
						deleteVersion(rowData.versionNo);
					}else{
						alert("请选择一条记录！");
					}
	    	   }
	       },*/{
	    	   text: '申请发布' , iconCls: 'fa fa-edit', handler: function () {
	    		   var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
	    		   if(ids.length==1){
						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
						checkStatus(rowData);											
						//useThisVersion(rowData);
					}else{
						alert("请选择一条记录！");
					}
	    	   }
	       }
	];

//删除版本信息
function deleteVersion(versionNo){
	if(confirm("是否删除选中记录？")){
		$.ajax({
	        type: "post",
	        url: root+'/delete_adbVersion.do',
	        data:{"versionNo":versionNo}, 
	        dataType: "json",
	        success: function(data){
	    		if(data.success == true) {
	    			alert("删除成功");
	    			doSearch();
	    		}else if(data.success == false && data.msg != undefined){
	    			alert(data.msg);
	    		}else{
	    			alert("删除失败");
	    		}
	        },
	        error: function () {  
	         alert("操作失败");  
	        }  
	    });		
	}
}

//发布
var validator = null;
$(document).ready(function() {
	validator = $("#publishFrom").validate({
		rules : {
			publishVersionName : {
				required : true
				
			},
			publishVerNo : {
				required : true,
				
			},
			applicationReason : {
				required : true,
				rangelength : [ 0, 100 ]
			},
			descForPublish : {
				required : true,
				
			}
		},
		focusCleanup : true
	});
});
//发布或恢复版本
function publishFile(){
	//var applicationReason = $("#publishReason").val();
	//var versionName = $("#publishVersionName").val();
	//var versionNo = $("#publishVerNo").val();
	//console.info("descForPublish",descForPublish);
	//if(applicationReason != null && applicationReason != ""){
	 if($("#publishFrom").valid()){
		
	 var data = $('#publishFrom').serialize();
		if(confirm("是否发布/恢复该版本？")){
			$.ajax({
		        type: "post",
		        url: root+'/publishOrRecover_adbVersion.do',
		        //data:{"versionNo":versionNo,"applicationReason":applicationReason,"versionDesc":descForPublish,"versionName":versionName}, 
		        data:data,
		        dataType: "json",
		        success: function(data){
		    		if(data.success == true) {
		    			alert("发布/恢复该版本成功");
		    			parent.$('#publishModal').modal('hide');
		    			doSearch();
		    		}else if(data.success == false && data.msg != undefined) {
		    			alert(data.msg);
		    		}else {
		    			alert("发布/恢复该版本失败");
		    		}
		        },
		        error: function () {  
		         alert("操作失败");  
		        }  
		    });
			doSearch();
		}
	//}else{
		//alert("申请发布理由不能为空！请重新输入！");
	//}
	 }
}
//修改
var validator = null;
$(document).ready(function() {
	validator = $("#dataFrom").validate({
		rules : {
			versionName : {
				required : true,
				rangelength : [ 0, 50 ]
			},
			versionNo : {
				required : true,
				rangelength : [ 0, 100 ]
			},
			versionDesc : {
				required : true,
				rangelength : [ 0, 200 ]
			},
			createTime : {
				required : true,
				rangelength : [ 0, 100 ]
			},
			createUser : {
				required : true,
				rangelength : [ 0, 100 ]
			},
			/*updateTime : {
				required : false,
				
			},
			updateUser : {
				required : true,
				
			},*/
			versionState : {
				required : true,
				rangelength : [ 0, 100 ]
			},
			isValid : {
				required : true,
				rangelength : [ 0, 100 ]
			}
		},
		focusCleanup : true
	});
});

//修改版本信息
function modifySubmit(){
	
	 if($("#dataFrom").valid()){
//		 if(!verify1()){
//				return;
//			}else{
	 $("#adbVersionModal").modal("toggle");
	 var data = $('#dataFrom').serialize();
	 $.ajax({
	        type: "post",
	        url: root+'/update_adbVersion.do',
	        data:data, 
	        dataType: "json",
	        success: function(data){
	        	if($('#adbVersion_option').val()=="modify"){
	        		if(data.success == true) {
	        			alert("修改成功");
	        			doSearch();
	        		}else if(data.success==false && data.msg!=undefined){
	            		alert(data.msg);
	            	}else{
	            		alert("修改失败");
	            	}
	        	}else{
	        		if(data.success == true) {
	        			alert("修改成功");
	        			doSearch();
	        		}
	            	else alert("修改失败");
	        	}
	        	
	        },
	        error: function () {  
	         alert("操作失败");  
	        }  
	  });
	  doSearch();
	 }
//	 }
}
var validator = null;
$(document).ready(function() {
	validator = $("#adbDataFrom").validate({
		rules : {
			c_versionName : {
				required : true
				
			},
			c_versionDesc : {
				required : true,
				rangelength : [ 0, 100 ]
			}
		},
		focusCleanup : true
	});
});

var iscleck=null;
//提交新版本文件
function uploadFileSubmit(){
	if($("#adbDataFrom").valid()&&iscleck){
		if(!verify()){
			return
		}else{
		iscleck=false;
	var data = $('#adbDataFrom').serialize();
    $.ajax({
        type: "post",
        url: root+'/save_adbVersion.do',
        data:data,
        dataType: "json",
        success: function(data){
        	if(data.success == true) {
        		alert("新增版本成功！");       //弹出成功	
        		parent.$('#uploadFileModal').modal('hide');
        	    doSearch();
        	}else if(data.success == false && data.msg != undefined){
        		alert(data.msg);
        		parent.$('#uploadFileModal').modal('hide');
        	}else{
        		alert("新增版本失败");
        		parent.$('#uploadFileModal').modal('hide');
        	}
        },
        error: function () {  
         alert("操作失败");  
        }  
    });    
	doSearch();
	}
}

}

//获取版本号
function getVersionNo(data){
	var versionNo = "";
	$.ajax({
        type: "post",
        url: root+'/get_versionNo.do',
        data:data, 
        dataType: "json",
        success: function(data){
        	if(data.success == true) {
        		versionNo = data.value;
        		$("#newVerNo").val(versionNo);
        		$("#newVerNo").attr('readOnly','readOnly');
        	}
        },
        error: function () { 
        	alert("操作失败！");
        }  
    });
}

//检查申请发布版本的有效性
function checkStatus(rowdata){
	$.ajax({
        type: "post",
        url: root+'/check_status.do',
        data:rowdata, 
        dataType: "json",
        success: function(data){
        	if(data.success == true) {
        		if(data.value == "1"){
        			openModalWin('publish',rowdata);        			
        		}else{
        			alert("该版本为无效版本！");
        		}      		
        	}
        },
        error:function () {
        	alert("操作失败！");
        }  
    });
}
/*function uploadFileSubmit(){
	var formData = new FormData($("#adbDataFrom")[0]);
	var versionDesc = $('#versionDescNew').val();
    var filePath = $('#adb_file').val();
    var fileSplit = filePath.split("\\");
    var fileName = fileSplit[fileSplit.length-1];	
    
    $.ajax({
        type: "post",
        url: root+'/save_adbVersion.do',
        data:{"versionDesc":versionDesc,"fileName":fileName}, 
        dataType: "json",
        success: function(data){
        	if(data.success == true) {
        		$.ajax({ 
        	        type:'post', 
        	        url:root+'/upload_adb.do', 
        	        data:formData,
        	        contentType: false,
        	        async: false,  
        			cache: false, 
        			processData: false, 
        			success:function(data){
        				if(data.success == true){
        		            alert("上传成功！");       //弹出成功
        		            parent.$('#uploadFileModal').modal('hide');
        		            doSearch();
        		        }else{
        		        	alert("上传失败！");
        		        	doSearch();//弹出失败
        		        }
        		    },
        		    error:function(data){
        		        alert("上传失败!");  
        		        doSearch();
        		    }
        	   });
        	   doSearch();
        	}else alert("添加失败");
        },
        error: function () {  
         alert("操作失败");  
        }  
    });
    
	doSearch();
}*/

//将列表展示的值转换为状态描述
function versionStateChange(data){
	if(data.versionState == '<span>新版本</span>'){
		return "0";
	}else if(data.versionState == '<span>正在使用</span>'){
		return "1";
	}
	else if(data.versionState == '<span>审批通过，待发布</span>'){
		return "2";
	}
	else if(data.versionState == '<span>待一级审批</span>'){
		return "3";
	}
	else if(data.versionState == '<span>待二级审批</span>'){
		return "4";
	}
	else if(data.versionState == '<span>历史版本</span>'){
		return "5";
	}else if(data.versionState == '<sspan>审批未通过</span>'){
		return "6";
	}
};

//将列表展示的值转换为状态描述
function isValidChange(data){
	if(data.isValid == '<span>无效</span>'){
		return "0";
	}else if(data.isValid == '<span>有效</span>')
		return "1";
};

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

function closeBtn(){

	parent.$('#publishModal').remove();
	
}

//校验版本名称是否重复
function repeatName () {
	var versionName = $('#c_versionName').val();
	if(versionName != null){
		$.ajax({
			type : "post",
			url : root + '/repeatversionName.do',
			data : {
				"versionName" : versionName
			},
			dataType : "json",
			async:false, 
			success : function(data) {
				if (data.success) {
					//alert("决策点名称已存在，请重新输入！");
					$("#d_versionName").show();
					$('#c_versionName').focus();
				}else{
					$("#d_versionName").hide();
				}
			},
			error : function() {
				alert("操作失败");
			}
		});
	}
}

//function  repeatName1(){
//	var versionName = $('#versionName').val();
//	if(versionName != null){
//		$.ajax({
//			type : "post",
//			url : root + '/repeatversionName.do',
//			data : {
//				"versionName" : versionName
//			},
//			dataType : "json",
//			async:false, 
//			success : function(data) {
//				if (data.success) {
////					alert("决策点名称已存在，请重新输入！");
//					$('#dk_versionName').show();
//					$('#versionName').focus();
//				}else{
//					$('#dk_versionName').hide();
//				}
//			},
//			error : function() {
//				alert("操作失败");
//			}
//		});
//	}
//}
//校验
function verify() {
	
	var str = true;
	
		repeatName();
		
		$.each($('label[name=error]'), function() {
			if(!$(this).is(":hidden")) {
				str= false;
			}
		});
	return str;
}
//修改校验
//function verify1() {
//	
//	var str = true;
//	
//	repeatName1();
//	
//	$.each($('label[name=error]'), function() {
//		if(!$(this).is(":hidden")) {
//			str= false;
//		}
//	});
//	return str;
//}