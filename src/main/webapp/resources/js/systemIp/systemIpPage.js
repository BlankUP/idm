function doSearch(){
	var systemCode = $("#searchSystemCode").val();
	var systemName = $("#searchSystemName").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/systemIp_service.do',
	    postData : {systemCode:systemCode, systemName:systemName},
	    datatype : "json"
	}).trigger("reloadGrid");
}

var tool = [ {
	text : '添加数据',
	iconCls : 'fa fa-plus',
	handler : function() {

		openModalWin('add');
	}
}, '-',{
	text : '修改数据',
	iconCls : 'fa fa-edit',
	handler : function() {
		var ids = $('#grid-table').jqGrid('getGridParam', 'selarrrow');
		if (ids.length == 1) {
			var rowData = $("#grid-table").jqGrid('getRowData', ids[0]);
			openModalWin('update', rowData);
		} else {
			alert("请选择一条记录！");
		}
	}
}, '-', {
	text : '删除数据',
	iconCls : 'fa fa-remove',
	handler : function() {
		var ids = $('#grid-table').jqGrid('getGridParam', 'selarrrow');
		if (ids.length == 1) {
			var rowData = $("#grid-table").jqGrid('getRowData', ids[0]);
			deleteSystem(rowData.systemIpID);
		} else {
			alert("请选择一条记录！");
		}

	}
}
];

function deleteSystem(systemIpID){
	if(confirm("是否删除选中服务器地址？")){
		$.ajax({
	        type: "post",
	        url: root+'/systemIp_delete.do',
	        data:{"systemIpID":systemIpID}, 
	        dataType: "json",
	        success: function(data){
	    		if(data.success==true) {
	    			alert("删除成功");
	    			doSearch();
	    		}
	        	else{
	        		if(data.msg!=undefined) alert(data.msg);
	        		else alert("删除失败");	
	        	}
	        },
	        error: function () {
	         alert("操作失败");
	        }
	    });
	}
};

function openModalWin(type, data){
	$("label.error").remove();//清除验证标签
	$("input.error").removeClass("error");//清除验证标签
	if(type=='add') {
		disabledclose();
		$('#systemIpTitle').html("添加系统IP地址");
		$('#systemIp_option').val("add");
		$("#systemIpModel").modal('show');
		$('#ipAddress').val('');
		$('#ipPort').val('');
		$('#method').val('');
		$('#systemCode').val('');
		$('#systemName').val('');
		$("#systemCode").removeAttr('readOnly');
		$("#systemName").removeAttr('readOnly');
		iscleck=true;
	
	}else if(type=='update'){
		disabledclose();
		$('#systemIpTitle').html("修改系统IP地址");
		$('#systemIp_option').val("update");
		$("#systemIpModel").modal('show');
		$('#ipAddress').val(data.ipAddress);
		$('#ipPort').val(data.ipPort);
		$('#method').val(data.method);
		$('#systemCode').val(data.systemCode);
		$('#systemName').val(data.systemName);
		$("#systemCode").attr('readOnly','readOnly');
		$("#systemName").attr('readOnly','readOnly');
		$('#createUser').val(data.createUser);
		$('#createTime').val(data.createTime);
		$('#systemIpID').val(data.systemIpID);
		iscleck=true;
	}
};

var iscleck=null;
function saveOrUpdate() {
	if($("#dataFrom").valid()&&iscleck){
		disabledclose();
		iscleck=false;
		var data = $('#dataFrom').serialize();
		disabledopen();
		$.ajax({
			type : 'post',
			url : root + '/systemIp_save.do',
			data : data,
			async:false,
			success : function(msg) {
				if (msg == '') {
					alert("保存成功！"); // 弹出成功msg
					// 刷新表格数据
					doSearch();
					parent.$('#systemIpModel').modal('hide');
				} else {
					alert("接口请求出现错误:" + msg); // 弹出失败msg
				}
			},
			error : function(msg) {
				alert("访问服务器出错");
			}
		});
	}
}

var validator = null;
$(document).ready(function() {
	validator = $("#dataFrom").validate({
		rules : {
			ipAddress : {
				ipstr : true,
				required : true
			},
			ipPort : {
				required : true,
				number : true
			},
			method : {
				required : true,
				rangelength : [ 0, 30 ]
			},
			systemCode : {
				required : true,
				rangelength : [ 0, 30 ]
			},
			systemName : {
				required : true,
				rangelength : [ 0, 30 ]
			}
		},
		focusCleanup : true
	});
});

$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = $("#grid-pager");

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: 'auto',
		colNames:[ 'IPID', 'IP地址', 'IP端口', '方法名', '系统编码', '系统名', '创建者', '修改者', '创建时间', '修改时间' ],
		colModel:[
					{
						sortable:false,
						name : 'systemIpID',
						index : 'systemIpID',
						width : 100,
						hidden : true
					}, {
						sortable:false,
						name : 'ipAddress',
						index : 'ipAddress',
						width : 100
					}, {
						sortable:false,
						name : 'ipPort',
						index : 'ipPort',
						width : 100
						
					}, {
						sortable:false,
						name : 'method',
						index : 'method',
						width : 100
					}, {
						sortable:false,
						name : 'systemCode',
						index : 'systemCode',
						width : 100
					}, {
						sortable:false,
						name : 'systemName',
						index : 'systemName',
						width : 100
					}, {
						sortable:false,
						name : 'createUser',
						index : 'createUser',
						width : 100
					}, {
						sortable:false,
						name : 'updateUser',
						index : 'updateUser',
						width : 100,
						hidden : true
					}, {
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 100
					}, {
						sortable:false,
						name : 'updateTime',
						index : 'updateTime',
						width : 100,
						hidden : true
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
		caption: "服务系统IP管理",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/systemIp_service.do',
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

function disabledclose(){
	$('#ipAddress').attr("disabled",false);
 	$('#ipPort').attr("disabled",false);
 	$('#method').attr("disabled",false);
 	$('#systemCode').attr("disabled",false);
 	$('#systemName').attr("disabled",false);
}
function disabledopen(){
	$('#ipAddress').attr("disabled",true);
 	$('#ipPort').attr("disabled",true);
 	$('#method').attr("disabled",true);
 	$('#systemCode').attr("disabled",true);
 	$('#systemName').attr("disabled",true);
}

$(function(){
    $(window).resize(function(){
       $("#grid-table").setGridWidth($(window).width());
    });
 });