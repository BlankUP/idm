/**
 * @author caiwenjian
 * @Date 2019-03-11
 * @js adb规则版本部署管理
 */
//根据版本号查询版本信息
function doSearch(){
	var versionNo = $("#searchVersionInfo").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{versionNo:versionNo},
	    //url:root+'/adbRule_search.do?versionNo='+versionNo,
	    url:root+'/adbRule_search.do',
	    datatype : "json"
	}).trigger("reloadGrid");
}

//详情查看、修改版本信息
function openModalWin(type,data){
	clearCheck();
	if(type == 'check'){
		$('#adbVersionTitle').html("版本信息详情");
		$('#adbVersion_option').val("check");
		data.versionState  =versionStateChange(data);
		$("#versionNo").val(data.versionNo);
		$("#versionNo").attr('readOnly','readOnly');
		$("#fileName").val(data.fileName);
		$("#fileName").attr('readOnly','readOnly');
		$("#versionDesc").val(data.versionDesc);
		$("#versionDesc").attr('readOnly','readOnly');
		$("#createTime").val(data.createTime);
		$("#createTime").attr('readOnly','readOnly');
		$("#createUser").val(data.createUser);
		$("#createUser").attr('readOnly','readOnly');
		$("#deployTime").val(data.deployTime);
		$("#deployTime").attr('readOnly','readOnly');
		$("#deployer").val(data.deployer);
		$("#deployer").attr('readOnly','readOnly');
		$("#versionState").val(data.versionState);
		$("#versionState").attr('disabled',true);
		$("#adbVersionModal").modal('show');
	}else if(type == 'add'){
		$('#uploadFileTitle').html("部署规则");
		$("#tr_adbfile").attr('hidden',true);
		$("#c_versionNo").attr('readOnly','readOnly');
		$("#uploadFileModal").modal('show');
		iscleck=true;
	}	
}

function clearCheck(){
	validator.resetForm();
	$('input').removeClass("valid");
	$('select').removeClass("valid");
	$('textarea').removeClass("valid");
};

//加载服务器源
function queryInterfaceInfo(){
	var html="";
	$.ajax({
        type: "post",
        url: root+'/query_adbDeploy_service.do',
        success: function(data){
        	var a = 2;
        	var interfaceCode = "";
        	$.each(data,function(i,v){

        		if(a%2==0){
        			html+="<tr>";
        		}
        		html+="<td>";
        		html+="<input type='checkbox' checked='checked' name='iCode' style='vertical-align: top;' value='http://"+v.ip+":"+v.port+"'>"+v.name+"&nbsp;&nbsp;&nbsp;&nbsp;";
        		html+="</td>";
        		if(a%2==1){
        			html+="</tr>";
        		}
        		a++;
        	});
			$("#c_iCode").append(html);
			$.each($('input[name=iCode]:checked'), function() {
				interfaceCode += $(this).val() + ",";
			});
			if (interfaceCode.length > 0) {
				interfaceCode = interfaceCode.substring(0, interfaceCode.length - 1);
			}
			$("#c_serversAddress").val(interfaceCode);
			$('input[name=iCode]:checked').attr("disabled",true);
        }
    });
}

//加载adb待部署文件
function queryAdbfiele(){
	$.ajax({
        type: "post",
        url: root+'/queryAdbfileNameAndVerNo.do',
        datatype: "json",
        success: function(data){
        	if(data!=null&&data!=undefined&&data.versionNo!=undefined){
        		$("#adb_file").val(data.fileName);
        		$("#c_versionNo").val(data.versionNo);
        		$("#c_adbId").val(data.adbId);
        		$("#adb_fileBack").val(data.fileNameBack);
        		$("#c_versionNoBack").val(data.versionNoBack);
        		$("#c_adbIdBack").val(data.adbIdBack);
        	}
        	/*else if(data!=null&&data!=undefined&&data.success!=null&&data.success!=undefined){
        		
        	}*/
        },
        error: function () {  
        	alert("获取待发布的规则失败！");
        }
    });
}
var iscleck=null;
//部署最新版本
function uploadFileSubmit(){
	//在模型与字段页面操作
	if($("#adbDataFrom").valid()&&iscleck){
		//文件名，服务器地址
	    var adbDataFrom = $('#adbDataFrom').serialize();
	    iscleck=false;
	    $.ajax({
	        type: "post",
	        url: root+'/get_adbVersion_forDeploy.do',
	        data:adbDataFrom, 
	        dataType: "json",
	        success: function(data){
	        	if(data.success == true) {
	        		$.ajax({ 
	        	        type:'post', 
	        	        url:root+'/add_adbDeploy_record.do', 
	        	        data:adbDataFrom,
	        	        datatype:'json',
	        			success:function(data){
	        				if(data.success == true){
	        		            alert("规则上传成功，新增部署记录成功！");       //弹出成功
	        		            parent.$('#uploadFileModal').modal('hide');
	        		            $("#c_versionNo").val("");
	        		            doSearch();
	        		        }else if(data.success=='rest'){
	        		        	alert("新版本部署失败，版本原使用版本恢复成功！");
	        		        	doSearch();
	        		        	parent.$('#uploadFileModal').modal('hide');
	        		        } else{
	        		        	alert("新版本部署失败，版本原使用版本恢复失败！");
	        		        	doSearch();
	        		        	parent.$('#uploadFileModal').modal('hide');
	        		        }
	        		    },
	        		    error:function(data){
	        		        alert("规则上传成功，新增部署记录错误！");  
	        		        doSearch();
	        		    }
	        	   });
	        	}else if(data.success==false&&data.msg!="undefined"&&data.msg!=""){ 
	        		alert("规则上传失败，确保要部署的版本文件存在，然后重新部署");
	        	}else{
	        		alert("操作失败！");
	        	}
	        },
	        error: function () {  
	        	alert("操作失败！！");  
	        }  
	    });
	}
}

$(document).ready(function() {
	//加载待发布adb规则
	queryAdbfiele();
	//加载服务器源
	queryInterfaceInfo();
});


//版本信息展示列表
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = $("#grid-pager");

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: 'auto',
		colNames:[ '部署系列号','版本号','版本描述','部署人','部署时间','创建人','创建日期','修改人','修改日期','版本状态','发布状态'],
		colModel:[
					{
						sortable:false,
						name : 'adbruleid',
						index : 'adbruleid',
						width : 100,
						hidden: true
						
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
					},{
						sortable:false,
						name : 'deployer',
						index : 'deployer',
						width : 100
					}, {
						sortable:false,
						name : 'deployTime',
						index : 'deployTime',
						width : 100
					}, {
						sortable:false,
						name : 'createUser',
						index : 'createUser',
						width : 100,
						hidden: true
					}, {
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 100,
						hidden: true
					},
					{
						sortable:false,
						name : 'updateUser',
						index : 'updateUser',
						width : 100,
						hidden: true
					},
					{
						sortable:false,
						name : 'updateTime',
						index : 'updateTime',
						width : 100,
						hidden: true
					},
					{
						sortable:false,
						name : 'versionState',
						index : 'versionState',						
						width : 100,
						formatter: function(cellvalue, options, rowObject){
							if(cellvalue==1){
								return "<span>正在使用</span>";
							}else {
								return "<span>历史版本</span>";
							}
						}
					},{
						sortable:false,
						name : 'status',
						index : 'status',
						width : 100,
						formatter: "select",
						editoptions:{value:"0:发布成功;1:发布失败"}
					}
					],
		viewrecords : true,
		rowNum:10,
		rowList:[10,20,30,50,100],
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
		caption: "adb规则热部署",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/adbRule_search.do',
	    datatype : "json"
	}).trigger("reloadGrid");
});

var matchTool = [ 
	       {text: '部署新规则' , iconCls: 'fa fa-plus', handler: function () {
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
	       }
	   ];


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
	}
	else if(data.versionState == '<span>审批未通过</span>'){
		return "6";
	}
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

var validator=null;
$(document).ready(function(){
	validator=$("#adbDataFrom").validate({
		rules: {
			versionNo:{
				required:true,
				rangelength:[0,100]
			},
			serversAddress:{
				required:true,
				rangelength:[0,100]
			}
	    },focusCleanup:true
	});
});
$(function(){
	$(window).resize(function(){  
	$("#grid-table").setGridWidth($(window).width());
	 });
	 });