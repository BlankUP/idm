/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
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
			{ text: '添加数据' , iconCls: 'fa fa-plus', handler: function () {
					
					openModalWin('add');
				}
			}, '-',  
			{ text: '修改数据' , iconCls: 'fa fa-edit', handler: function () {
					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
					if(ids.length==1){
						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
						openModalWin('update',rowData);
					}else{
						alert("请选择一条记录！");
					}
			   
				}
			}, '-',  
			{ text: '同步' , iconCls: 'fa fa-refresh', handler: function () {
					if(confirm("是否同步服务器？")){
						 //打开同步服务器选择界面
						$('#dataModalServiceMatch').modal('show');
						//加载服务器
						$('#gridService-table').jqGrid('setGridParam', {
						    page : 1,
						    url:root+'/server_info_query.do?stat=Y',
						    datatype : "json"
						}).trigger("reloadGrid");
					}
				}
			}
			];
			
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '异常编号', '异常信息','异常原因','解决方案' ],
		colModel:[
					{
						sortable:false,
						name : 'errCode',
						index : 'errCode',
						width : 50
					}, {
						sortable:false,
						name : 'errMsg',
						index : 'errMsg',
						width : 200
						
					}, {
						sortable:false,
						name : 'reasonMsg',
						index : 'reasonMsg',
						width : 200
					}, {
						sortable:false,
						name : 'solutionMsg',
						index : 'solutionMsg',
						width : 200
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

		caption: "异常基础信息表",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/exception_base_query.do',
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
	var errCode = $("#searchErrCode").val();
	var errMsg = encodeURI(encodeURI($("#searchErrMsg").val()));
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/exception_base_query.do?errCode='+errCode+'&errMsg='+errMsg,
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
	textareaDeal();
	if(type=="view"){
		$('#c_option').val("view");
		$('#c_errCode').val(data.errCode);
//		 readonly="readonly"
		$('#c_errCode').attr("readonly","readonly");
	 	$('#c_errMsg').html(data.errMsg);
	 	$('#c_reasonMsg').html(data.reasonMsg);
	 	$('#c_solutionMsg').html(data.solutionMsg);
		$('#dataTitle').html("修改数据【"+data.errCode+"】");
//		validator.resetForm();
	}else if(type=="update"){
		$('#c_option').val("update");
		$('#c_errCode').val(data.errCode);	
		$('#c_errCode').attr("readonly","readonly");
	 	$('#c_errMsg').html(data.errMsg);
	 	$('#c_reasonMsg').html(data.reasonMsg);
	 	$('#c_solutionMsg').html(data.solutionMsg);
		$('#dataTitle').html("修改数据【"+data.errCode+"】");
		$('#saveUpdateBtn').show();        		
	}else if(type=="add"){
		$('#c_option').val("add");
		$('#c_errCode').val("");
		$('#c_errCode').removeAttr("readonly");
	 	$('#c_errMsg').html("");
	 	$('#c_reasonMsg').html("");
	 	$('#c_solutionMsg').html("");
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
		var data = $('#dataFrom').serialize();
		$.ajax({ 
	         type:'post', 
	         url:root+'/exception_base_save.do', 
	         data:data, 
	         success:function(msg){
	            if(msg==''){
	                alert("保存成功！");        //弹出成功msg
	                //刷新表格数据
	                doSearch();
	                $('#dataModal').modal('hide');
	            }else{
	                alert("接口请求出现错误:"+msg);  //弹出失败msg
	            }
	         },
	         error:function(msg){       
	         }
	    });
	}
}
function syncBaseMap(syncdata,serverIds){
	$.ajax({ 
        type:'post', 
        url:root+'/data_sync.do?type=error_base_map&serverIds='+serverIds, 
        success:function(msg){
           if(msg==''){
               alert("同步成功！");        //弹出成功msg
           }else{
               alert("接口请求出现错误，请再次同步，异常信息如下:\n"+msg);  //弹出失败msg
           }
        },
        error:function(msg){       
        }
   });
}
function textareaDeal(){
	var parent=$('#c_errMsg').parent();
	parent.empty($('#c_errMsg'));
	parent.append("<textarea id='c_errMsg' rows='4'  name='errMsg' ></textarea>");
	
	parent=$('#c_reasonMsg').parent();
	parent.empty($('#c_reasonMsg'));
	parent.append("<textarea id='c_reasonMsg' rows='4'  name='reasonMsg' ></textarea>");

	parent=$('#c_solutionMsg').parent();
	parent.empty($('#c_solutionMsg'));
	parent.append("<textarea id='c_solutionMsg' rows='4'  name='solutionMsg' ></textarea>");
	
}
var validator=null;
$(document).ready(function(){
	validator=$("#dataFrom").validate({
		rules: {
			errCode:{
				required:true,
				rangelength:[0,5]
			},
			errMsg:{
				required:true,
				rangelength:[0,500]
			},
			reasonMsg:{
				required:true,
				rangelength:[0,500]
			},
			solutionMsg:{
				required:true,
				rangelength:[0,500]
			}	   
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
 * 加载服务器信息
 */
$(document).ready(function() {
	var grid_selector = "#gridService-table";
	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '服务器ID', '服务器名称','IP','端口','类型','状态'],
		colModel:[
					{
						sortable:false,
						name : 'serverId',
						index : 'serverId',
						width : 120
					}, {
						sortable:false,
						name : 'name',
						index : 'name',
						width : 120
						
					}, {
						sortable:false,
						name : 'ip',
						index : 'ip',
						width : 120
					}, {
						sortable:false,
						name : 'port',
						index : 'port',
						width : 100
					}, {
						sortable:false,
						name : 'type',
						index : 'type',
						width : 220,
						formatter: "select",
						editoptions:{value:"11:BLAZE交易服务器;12:BLAZE营销服务器;13:BLAZE通知服务器;21:交易Java服务器;22:营销Java服务器;23:通知Java服务器;"}
					},{
						sortable:false,
						name : 'status',
						index : 'status',
						width : 100,
						formatter: "select",
						editoptions:{value:"0:停用;1:启用"}
					}
					], 
		viewrecords : true,
		altRows: true,
		multiselect: true,
        multiboxonly: true,
		caption: "同步服务器选择界面",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/server_info_query.do?stat=Y',
	    datatype : "json"
	}).trigger("reloadGrid");
	

});

/**
 * 同步
 * data 为全局数据
 */
function syncData(){
	$('#dataModalServiceMatch').hide();
	var ids=$('#gridService-table').jqGrid('getGridParam','selarrrow');
	var serverIds="";
	if(ids.length==0){
		alert("请选择同步更新服务器！");
	}else{
		for(var i=0;i<ids.length;i++){
			var rowData = $("#gridService-table").jqGrid('getRowData',ids[i]);
			serverIds += rowData.serverId+"$$";
		}
		if(confirm("是否确认同步更新？")){
			syncBaseMap(syncdata,serverIds);
		}
		//清空数据
		syncdata = null;
	}
}
/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
	$('#'+modalId).hide();
}

