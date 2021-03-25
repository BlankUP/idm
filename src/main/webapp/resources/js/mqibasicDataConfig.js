/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * 线程数据配置表
 */
var tool = [ 
			{ text: '查看数据' , iconCls: 'fa fa-search', handler: function () {
					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
					if(ids.length==1){
						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
						openModalWin('view',rowData);
					}else{
						alert("请选择一条记录！");
					}			   
				}
			}, '-',  
//			{ text: '添加数据' , iconCls: 'fa fa-plus', handler: function () {
//				
//				openModalWin('add');
//			}
//		}, '-',  
		{ text: '修改数据' , iconCls: 'fa fa-edit', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('update',rowData);
				}else{
					alert("请选择一条记录！");
				}
		   
			}
		}, 
		];

$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:['参数类型','参数名称','参数编码', '参数值', '参数描述','创建时间','创建人','修改时间','修改人','状态'],
		colModel:[
					{
						sortable:false,
						name : 'paramType',
						index : 'paramType',
						width : 80
					},{
						sortable:false,
						name : 'paramName',
						index : 'paramName',
						width : 80
						
					},{
						sortable:false,
						name : 'paramCode',
						index : 'paramCode',
//						hidden : true,
						width : 80
						
					}, {
						sortable:false,
						name : 'paramValue',
						index : 'paramValue',
						width : 80
					}, {
						sortable:false,
						name : 'paramDesc',
						index : 'paramDesc',
						width : 80
					}, {
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 80
					},{
						sortable:false,
						name : 'createUser',
						index : 'createUser',
						width : 80
					},{
						sortable:false,
						name : 'updateTime',
						index : 'updateTime',
						width : 80
					},{
						sortable:false,
						name : 'updateUser',
						index : 'updateUser',
						width : 80
					},{
						sortable:false,
						name : 'status',
						index : 'status',
						width : 80,
						formatter: "select",
						editoptions:{value:"0:有效"}
					}
					], 
		viewrecords : true,
		rowNum:10,
		rowList:[10,20,30,50,100],
		pager : pager_selector,
		altRows: true,
		toolbar: [ true, "top" ,tool],
		multiselect: true,
        multiboxonly: true,

		loadComplete : function() {
			var table = this;
			setTimeout(function(){
				updatePagerIcons(table);
			}, 0);
		},

		caption: "线程池参数配置",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/mqi_basic_data_query.do',
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
	})
}
function doSearch(){
	var dataCode = $("#searchDataCode").val();
	//var paramName = encodeURI(encodeURI($("#searchParamName").val()));
	var paramName = $("#searchParamName").val();
	var type = $("#searchDataType").val();
	var status = $("#searchstate").val();
	
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData : {dataCode:dataCode,paramName:paramName},
	    url:root+'/mqi_basic_data_query.do',
	    datatype : "json"
	}).trigger("reloadGrid");
}

/**
 * 根据类型打开模态框 
 *  load模窗口的数据
 * @param type
 * @param rowdata
 */
function openModalWin(type,data){
	clearCheck();
	$('#dataModal').modal('show');
	$('#saveUpdateBtn').hide();
	if(type=="view"){
		$('#c_option').val("view");
		$('#paramCode').val(data.paramCode);
		$('#paramCode').attr("readonly","readonly");
		$('#paramName').val(data.paramName);
		$('#paramName').attr("readonly","readonly");
		$('#type').val(data.paramType);
	 	$('#type').attr("readonly","readonly");
	 	$('#paramValue').val(data.paramValue);
	 	$('#paramValue').attr("readonly","readonly");
		$('#paramDesc').text("");
	 	$('#paramDesc').text(data.paramDesc).attr("readonly","readonly");
	 	$('#status').val(data.status).attr("disabled","disabled"); 	
//		$('#status').attr("readonly","readonly");
		$('#spTr').show();
		$('#createUser').val(data.createUser);
		$('#createUser').attr("readonly","readonly");
		$('#spTr1').show();
		$('#createTime').val(data.createTime);
		$('#createTime').attr("readonly","readonly");
		$('#spTr3').show();
		$('#updateUser').val(data.updateUser);
		$('#updateUser').attr("readonly","readonly");
		$('#spTr2').show();
		$('#updateTime').val(data.updateTime);
		$('#updateTime').prop("disabled",true);
		$('#dataTitle').html("查看数据");

	}else if(type=="update"){
		$('#c_option').val("update");
		$('#paramCode').val(data.paramCode);
		$('#paramCode').attr("readonly","readonly");
		$('#paramName').val(data.paramName).attr("readOnly",false);
		$('#type').val(data.paramType);
	 	$('#type').attr("readonly","readonly");
	 	$('#paramValue').val(data.paramValue).attr("readOnly",false);
	 	$('#paramDesc').text("");
	 	$('#paramDesc').text(data.paramDesc).attr("readOnly",false);	 	
	 	$('#status').val("0");
	 	$('#status').attr("readonly","readonly");
	 	$('#spTr').hide();
	 	$('#spTr1').hide();
	 	$('#spTr2').hide();
	 	$('#spTr3').hide();
		$('#dataTitle').html("修改数据");
		$('#saveUpdateBtn').show();        		
	}else if(type=="add"){
		$('#c_option').val("add");
	 	$('#paramCode').val("");	
		$('#paramName').val("");
		$('#type').val("");
	 	$('#type').removeAttr("readonly");
	 	$('#paramValue').val("");
	 	$('#paramDesc').text("");
	 	$('#status').val("0");
	 	$('#spTr').hide();
	 	$('#spTr1').hide();
	 	$('#spTr2').hide();
	 	$('#spTr3').hide();
	 	$('#dataTitle').html("添加数据");
	 	$('#saveUpdateBtn').show(); 
	}	
}

/**
 * 接收返回信息
 * @param el
 * @param method
 */
function saveOrUpdate(){
	if($("#dataFrom").valid()){
		var data = parent.$('#dataFrom').serialize();
		$.ajax({ 
	         type:'post', 
	         url:root+'/mqi_basic_data_save.do', 
	         data:data, 
	         async:false,
	         success:function(msg){
	            if(msg==''){
	                alert("保存成功！");        //弹出成功msg
	                //刷新表格数据
	                doSearch();
	                parent.$('#dataModal').modal('hide');
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

/**
 * 删除数据
 * @param serverIds
 */
function serverDelete(paramCodes){
	$.ajax({ 
        type:'post', 
        url:root+'/mqi_basic_data_save.do?option=delete&paramCodes='+paramCodes, 
        success:function(msg){
           if(msg==''){
               alert("删除成功！"); 
               doSearch();
           }else{
        	   alert("请求出现错误:"+msg);  //弹出失败msg
           }
        },
        error:function(msg){       
        }
   });
}


/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
	$('#'+modalId).hide();
 }

var validator = null;
$(document).ready(function(){
	validator=$("#dataFrom").validate({
		rules: {
			paramName:{
				required:true,
				rangelength:[0,50]
			},
			"base.paramValue":{
				required : true,
				number : true
			},
			paramDesc:{
				required:true,
				rangelength:[0,100]
			},
	    },focusCleanup:true
	    
	});
});


function clearCheck(){
	validator.resetForm();
	$('input').removeClass("valid");
	$('select').removeClass("valid");
	$('textarea').removeClass("valid");
}
 
/**
 * 对table的大小随页面变化而变化
 */
$(function(){
    $(window).resize(function(){  
	 $("#grid-table").setGridWidth($(window).width());
	});
});
