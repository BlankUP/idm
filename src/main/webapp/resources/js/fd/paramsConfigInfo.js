
var matchTool = [ 
	{ text: '添加参数' , iconCls: 'fa fa-plus', handler: function () {
		openModalWin('add');
	}
	},{
		text: '修改参数' , iconCls: 'fa fa-edit', handler: function () {
			var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
			if(ids.length==1){
				var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
				openModalWin('modify',rowData);
			}else{
				alert("请选择一条记录！");
			}
		}
	},{
		text: '删除' , iconCls: 'fa fa-remove', handler: function () {
			var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
			if(ids.length==1){
				var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
				deleteParamConfig(rowData.paramCode,rowData.paramType);
			}else{
				alert("请选择一条记录！");
			}
		}
	}
	];
function doSearch(){
	var paramCode = $("#searchParamCode").val();
	var paramName = $("#searchParamName").val();
//	var paramName = encodeURI(encodeURI($("#searchParamName").val()));
	var paramType = $("#searchParamType").val();
	var status = $("#searchstatus").val();

	$("#grid-table").jqGrid('setGridParam', {
		page : 1,
		url:root+'/fd_params_config_info_service.do',
		postData : {paramCode:paramCode, paramName:paramName, paramType:paramType, status:status},
		datatype : "json"
	}).trigger("reloadGrid");
}

$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = $("#grid-pager");

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: 'auto',
		colNames:[ '参数编码', '参数名称','参数类型','参数值','参数描述','参数状态','创建用户','修改用户','创建时间','修改时间' ],
		colModel:[
			{
				sortable:false,
				name : 'paramCode',
				index : 'paramCode',
				width : 100
			}, {
				sortable:false,
				name : 'paramName',
				index : 'paramName',
				width : 100

			}, {
				sortable:false,
				name : 'paramType',
				index : 'paramType',
				width : 100,
				formatter: "select",
				editoptions:{value:"0:自定义参数;1:内置参数"}
			}, {
				sortable:false,
				name : 'paramValue',
				index : 'paramValue',
				width : 100
			}, {
				sortable:false,
				name : 'paramDesc',
				index : 'paramDesc',
				width : 100
			}, {
				sortable:false,
				name : 'status',
				index : 'status',
				width : 100,
				formatter: "select",
				editoptions:{value:"1:有效;0:无效"}
			}, {
				sortable:false,
				name : 'createUser',
				index : 'createUser',
				width : 100
			}, {
				sortable:false,
				name : 'updateUser',
				index : 'updateUser',
				width : 100
			}, {
				sortable:false,
				name : 'createTime',
				index : 'createTime',
				width : 100
			}, {
				sortable:false,
				name : 'updateTime',
				index : 'updateTime',
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
			caption: "批量任务参数配置",
			autowidth: true
	}).jqGrid('setGridParam', {
		page : 1,
		url:root+'/fd_params_config_info_service.do',
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

function openModalWin(type, data){
	
	$("label.error").remove();//清除验证标签
	$("input.error").removeClass("error");//清除验证标签
	
	console.log(type,data)
	if(type=='add') {
		$('#paramConfigTitle').html("添加参数");
		$('#param_config_option').val("add");

		$('#paramCode').val("");
		$('#paramCode').removeAttr("readonly");
		$('#paramName').val("");
		$('#paramType').val("");
		$('#paramType').removeAttr("readonly");
		$('#paramValue').val("");
		$('#paramDesc').val("");
		$('#status').val("");
		console.log("-----",$("#paramConfigModal"))
		$("#paramConfigModal").modal('show');
	}else if(type=='modify'){
		$('#paramConfigTitle').html("修改参数 ：" + data.paramName);
		$('#param_config_option').val("modify");

		$("#paramCode").val(data.paramCode);
		$("#paramCode").attr('readOnly','readOnly');
		$("#paramName").val(data.paramName);
		$("#paramType").val(data.paramType);
		$("#paramType").attr('readOnly','readOnly');
		$("#paramValue").val(data.paramValue);
		$("#paramDesc").val(data.paramDesc);
		$("#status").val(data.status);

		$("#paramConfigModal").modal('show');
	}
};

/**
 * 保存数据
 */
function saveOrUpdate(){
	if($("#dataFrom").valid()){
		if(!verify()){
			alert("请配置正确的参数");
			return
		}else{
			var data = parent.$('#dataFrom').serialize();

			$.ajax({ 
				type:'post', 
				url:root+'/fd_params_config_info_save.do', 
				data:data, 
				async:false,
				success:function(msg){
					if(msg==''){
						alert("保存成功！");        //弹出成功msg
						//刷新表格数据
						doSearch();
						parent.$('#paramConfigModal').modal('hide');
					}else{
						alert("接口请求出现错误:"+msg);  //弹出失败msg
					}
				},
				error:function(msg){
					alert("访问服务器出错");        
				}
			});
		}
	}
}

//校验参数编码是否重复
function checkCodeIsExists() {
	var paramCode = $('#paramCode').val();
	if(paramCode != null){
		$.ajax({
			type : "post",
			url : root + '/checkParamCode.do',
			data : {
				"paramCode" : paramCode
			},
			dataType : "json",
			async:false, 
			success : function(data) {
				if (data.success) {
					//alert("决策点名称已存在，请重新输入！");
					$("#e_paramCode").show();
					$('#paramCode').focus();
				}else{
					$("#e_paramCode").hide();
				}
			},
			error : function() {
				alert("操作失败");
			}
		});
	}
}

//校验参数名称是否重复
function checkNameIsExists() {
	var paramName = $('#paramName').val();
	if(paramName != null){
		$.ajax({
			type : "post",
			url : root + '/checkParamName.do',
			data : {
				"paramName" : paramName
			},
			dataType : "json",
			async:false, 
			success : function(data) {
				if (data.success) {
					//alert("决策点名称已存在，请重新输入！");
					$("#e_paramName").show();
					$('#paramName').focus();
				}else{
					$("#e_paramName").hide();
				}
			},
			error : function() {
				alert("操作失败");
			}
		});
	}
}

//校验
function verify() {

	var str = true;

	checkCodeIsExists();
	checkNameIsExists();

	$.each($('label[name=error]'), function() {
		if(!$(this).is(":hidden")) {
			str= false;
		}
	});

	return str;
}

var validator = null;
$(document).ready(function() {
	validator = $("#dataFrom").validate({
		rules : {
			paramCode : {
				required : true,
				rangelength : [ 0, 30 ]
			},
			paramName : {
				required : true,
				rangelength : [ 0, 30 ]
			},
			paramType : {
				required : true,
				rangelength : [ 0, 30 ]
			},
			paramValue : {
				required : true,
				rangelength : [ 0, 30 ]
			},
			paramDesc : {
				required : true,
				rangelength : [ 0, 30 ]
			},
			status : {
				required : true,
				rangelength : [ 0, 30 ]
			}
		},
		focusCleanup : true
	});
});
/**
 * 删除数据
 * @param paramCode
 */
function deleteParamConfig(paramCode,paramType){
	if(confirm("是否删除选中参数数据？")){
		$.ajax({
			type: "post",
			url: root+'/fd_params_config_info_delete.do',
			data:{"paramCode":paramCode,"paramType":paramType}, 
			dataType: "json",
			success: function(data){
				if(data.success==true){
					alert("删除成功");
					doSearch();
				}else if (data.success==false){
					alert("内置参数不允许删除！");
				}else{
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