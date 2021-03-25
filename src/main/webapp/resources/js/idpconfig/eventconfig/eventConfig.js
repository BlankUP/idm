/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * 决策请求配置表
 */
var tool = [ {
	text : '添加数据',
	iconCls : 'fa fa-plus',
	handler : function() {

		openModalWin('add');
	}
}, '-',{
	text : '查看数据',
	iconCls : 'fa fa-search',
	handler : function() {
		var ids = $('#grid-table').jqGrid('getGridParam', 'selarrrow');
		if (ids.length == 1) {
			var rowData = $("#grid-table").jqGrid('getRowData', ids[0]);
			openModalWin('view', rowData);
		} else {
			alert("请选择一条记录！");
		}
	}
}, '-', {
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
}
];

$(document).ready(
		function() {
			var grid_selector = "#grid-table";
			var pager_selector = "#grid-pager";
			jQuery(grid_selector).jqGrid(
					{

						datatype : "local",
						regional : 'cn',
						height : "auto",
						colNames : [ '决策点名称','决策系统编码', '决策系统',   '模型编码','模型名称', '数据源', '有效性',
								'编号' ],
						colModel : [ {
							sortable : false,
							name : 'eventName',
							index : 'eventName',
							width : 80
						}, {
							hidden : true,
							sortable : false,
							name : 'respSystemCode',
							index : 'respSystemCode',
							width : 80

						}, {
							sortable : false,
							name : 'respSystemName',
							index : 'respSystemName',
							width : 80

						}, {
							hidden : true,
							sortable : false,
							name : 'modelId',
							index : 'modelId',
							width : 80
						}, {
							sortable : false,
							name : 'modelName',
							index : 'modelName',
							width : 80
						},{
							hidden : true,
							sortable : false,
							name : 'interfaceCode',
							index : 'interfaceCode',
							width : 80
						}, {
							sortable : false,
							name : 'status',
							index : 'status',
							formatter: "select",
							editoptions:{value:"0:有效;1:无效"},
							width : 80
						}, {
							hidden : true,
							sortable : false,
							name : 'eventId',
							index : 'eventId',
							width : 80
						}
						/*
						 * , { sortable:false, name : 'state', index : 'state',
						 * width : 80, formatter: "select",
						 * editoptions:{value:"0:无效;1:有效;2:无效"} }
						 */
						],
						viewrecords : true,
						rowNum : 10,
						rowList : [ 10, 20, 30, 50, 100 ],
						pager : pager_selector,
						altRows : true,
						toolbar : [ true, "top", tool ],
						multiselect : true,
						multiboxonly : true,

						loadComplete : function() {
							var table = this;
							setTimeout(function() {
								updatePagerIcons(table);
							}, 0);
						},

						caption : "",
						autowidth : true,
					}).jqGrid('setGridParam', {
				page : 1,
				url : root + '/event_query.do',
				datatype : "json"
			}).trigger("reloadGrid");
		});

// 调整分页图标
function updatePagerIcons(table) {
	var replacement = {
		'ui-icon-seek-first' : 'fa fa-angle-double-left',
		'ui-icon-seek-prev' : 'fa fa-angle-left',
		'ui-icon-seek-next' : 'fa fa-angle-right',
		'ui-icon-seek-end' : 'fa fa-angle-double-right'
	};
	$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
			.each(function() {
				var icon = $(this);
				var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
				if ($class in replacement)
					icon.attr('class', 'ui-icon ' + replacement[$class]);
			})
}
function doSearch() {
	var eventName = $("#eventName").val();
	var modelName = $("#modelName").val();
	$("#grid-table").jqGrid(
			'setGridParam',
			{
				page : 1,
				postData:{'eventName':eventName,'modelName':modelName},
				url : root + '/event_query.do',
				datatype : "json"
			}).trigger("reloadGrid");
}

/**
 * 根据类型打开模态框 load模窗口的数据
 * 
 * @param type
 * @param rowdata
 */
function openModalWin(type, data) {
	$("label.error").remove();//清除验证标签
	$("input.error").removeClass("error");//清除验证标签
	
	$('#dataModal').modal('show');
	$('#saveUpdateBtn').hide();
	$.each($('label[name=error]'), function() {
		$(this).hide();
	});
	if (type == "view") {
		$('#c_option').val("update");
		$('#c_eventId').val(data.eventId);
		$('#c_eventName').val(data.eventName);
		$('#c_respSystemCode').val(data.respSystemCode);
		$('#v_respSystemCode').val(data.respSystemName);
//		$('#c_orgNo').val(data.orgNo);
//		$('#c_productId').val(data.productId);
		getModel(data.modelId);
		$('#c_status').val(data.status);
		$('#c_interfaceCode').val(data.interfaceCode);
		interfaceCodeUnChecked();
		interfaceCodeChecked(data.interfaceCode);
		$("input[name='iCode']").prop("disabled", "disabled");
		$('#dataTitle').html("查看数据【" + data.eventName + "】");
		disableopen();
	} else if (type == "update") {
		$('#c_option').val("update");
		$('#c_eventId').val(data.eventId);
		$('#c_eventName').val(data.eventName);
		$('#c_respSystemCode').val(data.respSystemCode);
		$('#v_respSystemCode').val(data.respSystemName);
//		$('#c_orgNo').val(data.orgNo);
//		$('#c_productId').val(data.productId);
		getModel(data.modelId);
		$('#c_status').val(data.status);
		interfaceCodeUnChecked();
		interfaceCodeChecked(data.interfaceCode);
		$("input[name='iCode']").prop("disabled", false);
		$('#dataTitle').html("修改数据【" + data.eventName + "】");
		$('#saveUpdateBtn').show();
		disableopen();
		iscleck=true;
	} else if (type == "add") {
		disableclose();
		$('#c_eventId').val('');
		$('#c_eventName').val('');
		$('#c_respSystemCode option:first').prop('selected', 'selected');
		$('#v_respSystemCode').val('');
//		$('#c_orgNo option:first').prop('selected', 'selected');
//		$('#v_orgNo').val('');
//		$('#c_productId option:first').prop('selected', 'selected');
		getModel();
		$('#c_status').val('');
		$('#c_interfaceCode').val('');
		interfaceCodeUnChecked();
		$('#c_respSystemCode').change();
		$('#c_orgNo').change();
		$("input[name='iCode']").prop("disabled", false);
		$('#c_option').val("add");
		$('#dataTitle').html("添加数据");
		$('#saveUpdateBtn').show();
		iscleck=true;
	}
}

/**
 * 提交新增和修改信息
 * 
 * @param el
 * @param method
 */
var iscleck=null;
function saveOrUpdate() {
	if($("#dataFrom").valid()&&iscleck){
		if(!verify()){
			alert("请配置正确的参数");
			return
		}else{
			iscleck=false;
			disableclose();
			var data = $('#dataFrom').serialize();
			disableopen();
			$.ajax({
				type : 'post',
				url : root + '/event_save.do',
				data : data,
				async:false,
				success : function(msg) {
					if (msg == '') {
						alert("保存成功！"); // 弹出成功msg
						// 刷新表格数据
						doSearch();
						parent.$('#dataModal').modal('hide');
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
}

// 给数据源赋值
function interfaceCodeChecked(interfaceCode) {
	if (interfaceCode != null && interfaceCode != "") {
		var Code = interfaceCode.split(",");
		$.each(Code, function(i, item) {
			$("input[name='iCode'][value=" + item + "]").prop("checked", true);
		});
	}
}
// 去除数据源的值
function interfaceCodeUnChecked() {
	$.each($('input[name=iCode]:checked'), function() {
		$(this).prop("checked", false);
	});
}
// 提交去除disable
function disableclose() {
	$('#c_eventName').prop("disabled", false);
	$('#c_orgNo').prop("disabled", false);
	$('#v_orgNo').prop("disabled", false);
	$('#c_productId').prop("disabled", false);
	$('#c_modelId').prop("disabled", false);
	$('#c_status').prop("disabled", false);
 	$('#c_respSystemCode').attr("disabled",false);
 	$('#v_respSystemCode').attr("disabled",false);
}

// 提交去除disable
function disableopen() {
	$('#c_eventName').prop("disabled", true);
	$('#c_orgNo').prop("disabled", true);
	$('#v_orgNo').prop("disabled", true);
	$('#c_productId').prop("disabled", true);
	$('#c_modelId').prop("disabled", true);
	$('#c_status').prop("disabled", true);
 	$('#c_respSystemCode').attr("disabled",true);
 	$('#v_respSystemCode').attr("disabled",true);
}
// 校验
function verify() {
	
	var str = true
	if($('#c_option').val()== "add"){
		
		repeatEventName();
		repeatModel();
		 
		$.each($('label[name=error]'), function() {
			if(!$(this).is(":hidden")) {
				str= false;
			}
		});
	}
	return str;
}
function queryProductInfo() {
	var html = "";
	$.ajax({
		type : "post",
		url : root + '/query_event_product.do',
		success : function(data) {
			$.each(data, function(i, v) {
				html += "<option value='" + v.productid + "'>" + v.productname + "（"+v.productcode+"）"
						+ "</option>"
			})
			$("#c_productId").html(html);
		}
	});

}

function queryInterfaceInfo() {
	var html = "";
	$.ajax({
				type : "post",
				url : root + '/query_event_interface.do',
				success : function(data) {
					var a = 3;
					$.each(data,function(i, v) {
										if (a % 3 == 0) {
											html += "<tr>";
										}
										html += "<td>";
										html += "<input type='checkbox' name='iCode' style='vertical-align: top;' onclick='getInterfaceCode()' value='"
												+ v.interfaceCode
												+ "'>"
												+ v.interfaceName
												+ "&nbsp;&nbsp;&nbsp;&nbsp;"
										html += "</td>";
										if (a % 3 == 2) {
											html += "</tr>";
										}
										a++;
									})
					$("#c_iCode").append(html);
				}
			});

}

$(document).ready(function() {

	// 加载产品
	queryProductInfo();
	// 加载数据源
	queryInterfaceInfo()
	//加载法人行
	//queryOrgInfo();

});
/**
 * 关闭
 * 
 * @param modalId
 */
function closeBtn(modalId) {
	$('#' + modalId).hide();
}
function getInterfaceCode() {
	var interfaceCode = "";
	$.each($('input[name=iCode]:checked'), function() {
		interfaceCode += $(this).val() + ",";
	});
	if (interfaceCode.length > 0) {
		interfaceCode = interfaceCode.substring(0, interfaceCode.length - 1);
	}
	$("#c_interfaceCode").val(interfaceCode);
}

var validator = null;
$(document).ready(function() {
	validator = $("#dataFrom").validate({
		rules : {
			eventName : {
				required : true,
				rangelength : [ 0, 50 ]
			},
			respSystemCode : {
				required : true
			},
			modelId : {
				required : true
			}
		},
		focusCleanup : true
	});
});

// 校验决策点名称是否重复
function repeatEventName() {
	var eventName = $('#c_eventName').val();
	if(eventName != null){
		$.ajax({
			type : "post",
			url : root + '/repeat_event_name.do',
			data : {
				"eventName" : eventName
			},
			dataType : "json",
			async:false, 
			success : function(data) {
				if (data.success) {
					//alert("决策点名称已存在，请重新输入！");
					$("#d_eventName").show();
					$('#c_eventName').focus();
				}else{
					$("#d_eventName").hide();
				}
			},
			error : function() {
				alert("操作失败");
			}
		});
	}
}
	// 校验模型是否重复
	function repeatModel() {
		var modelId = $('#c_modelId').val();
		if(modelId != null){
			$.ajax({
				type : "post",
				url : root + '/repeat_model.do',
				data : {
					"modelId" : modelId
				},
				dataType : "json",
				async:false, 
				success : function(data) {
					if (data.success) {
						//alert("决策点名称已存在，请重新输入！");
						$("#d_modelId").show();
						$('#c_modelId').focus();
					}else{
						$("#d_modelId").hide();
					}
				},
				error : function() {
					alert("操作失败");
				}
			});
		}
		
}

function getModel(modelId){
	 var respSystemCode = $("#c_respSystemCode").find("option:selected").val();
	var html='';
	$.ajax({
        type: "post",				
        data : {
			"respSystemCode" : respSystemCode
		},
        url: root+'/query_event_model.do',
        success: function(data){
        	$.each(data,function(i,v){
        		html+="<option value='"+v.modelid+"'>"+v.modelname  + "（"+v.modelcode+"）"+"</option>"
			})
			$("#c_modelId").html(html);
        	if(modelId==null){
        		$('#c_modelId option:first').prop('selected', 'selected');
        		$('#c_modelId').change();
        	}else{
        		$('#c_modelId').val(modelId);
        	}
        	
        }
    });
}

function queryOrgInfo() {
	var html = "";
	$.ajax({
		type : "post",
		url : root + '/query_event_org.do',
		success : function(data) {
			$.each(data, function(i, v) {
				html += "<option value='" + v.orgNo + "'>" + v.orgName + "</option>"
			})
			$("#c_orgNo").html(html);
		}
	});

	

}