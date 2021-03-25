/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * 规则配置维护
 */
var tool = [ 
			{ text: '添加定时任务' , iconCls: 'fa fa-plus', handler: function () {
				
				openModalWin('add');
			}
		    }, '-',  
		    { text: '修改定时任务' , iconCls: 'fa fa-edit', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('update',rowData);
				}else{
					alert("请选择一条记录！");
				}		   
			  }
		    }, '-',  
		   { text: '同步任务' , iconCls: 'fa fa-refresh', handler: function () {
					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
					if(ids.length>1){
						alert('请选择一条记录');
						return;
					}
					if(ids.length==1){
						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
						syncdata = rowData;
						 //打开同步服务器选择界面
						$('#dataModalServiceMatch').modal('show');
						//加载服务器
						$('#gridService-table').jqGrid('setGridParam', {
						    page : 1,
						    url:root+'/server_info_query.do?stat=Y',
						    datatype : "json"
						}).trigger("reloadGrid");
					}else{
						if(confirm("是否重新加载所有定时任务？")){
							syncdata = 'all';
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
		   }
		];

$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '任务名称', '任务组名', '任务实现类', '定时时间', '任务所属系统', '任务状态','创建日期','创建时间'],
		colModel:[
					{
						sortable:false,
						name : 'taskName',
						index : 'taskName',
						width : 120
					}, {
						sortable:false,
						name : 'taskGroup',
						index : 'taskGroup',
						width : 150						
					}, {
						sortable:false,
						name : 'taskClass',
						index : 'taskClass',
						width : 300
					}, {
						sortable:false,
						name : 'triggerTime',
						index : 'triggerTime',
						width : 150
					}, {
						sortable:false,
						name : 'subSystem',
						index : 'subSystem',
						width : 100,
						formatter: "select",
						editoptions:{value:"EMS:营销子系统;MSG:通知子系统;TRANS:交易子系统"}
					}, {
						sortable:false,
						name : 'state',
						index : 'state',
						width : 100,
						formatter: "select",
						editoptions:{value:"0:关闭;1:启用"}
					}, {
						sortable:false,
						name : 'createDate',
						index : 'createDate',
						width : 100,					
					}, {
						sortable:false,
						name : 'createDatetime',
						index : 'createDatetime',
						width : 100,
					}], 
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
		
		caption: "定时任务信息表",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/task_trigger_query.do',
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
	var searchTaskName = encodeURI(encodeURI($("#searchTaskName").val()));
	var searchTaskGroup = encodeURI(encodeURI($("#searchTaskGroup").val()));
	var searchSubSystem = $("#searchSubSystem").val();
	var searchState = $("#searchState").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/task_trigger_query.do?searchTaskName='+searchTaskName+'&searchTaskGroup='+searchTaskGroup+'&searchSubSystem='+searchSubSystem+'&searchState='+searchState,
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
	$('#saveUpdateBtn').hide();
	$('#createDate').attr("readonly","readonly");
	$('#createDatetime').attr("readonly","readonly");
    if(type=="update"){
		$('#c_option').val("update");
		$('#taskName').val(data.taskName);
		$('#taskName').attr("readonly","readonly");
		$('#taskGroup').val(data.taskGroup);
		$('#taskGroup').attr("readonly","readonly");
		$('#taskClass').val(data.taskClass);
		$('#triggerTime').val(data.triggerTime);
		$('#subSystem').val(data.subSystem);
		$('#state').val(data.state);
		$('#createDate').val(data.createDate);
		$('#createDatetime').val(data.createDatetime);
	 	$('#dataTitle').html("修改数据");
	 	$('#dataModal').modal('show');
	 	$('#deleteBtn').show();
	 	$('#saveUpdateBtn').show(); 
	 }else if(type=="add"){
		$('#c_option').val("add");
		$('#taskName').removeAttr("readonly");
		$('#taskGroup').removeAttr("readonly");
		$('#taskName').val("");
		$('#taskGroup').val("");;
		$('#taskClass').val("");
		$('#triggerTime').val("");
		$('#subSystem').val("EMS");
		$('#state').val("0");
	 	$('#dataTitle').html("添加数据");
	 	$('#dataModal').modal('show');
	 	$('#deleteBtn').hide();
	 	$('#saveUpdateBtn').show(); 
	 }
}
/**
 * 接收返回信息
 * @param el
 * @param method
 */
function saveOrUpdateTask(){
	var data = parent.$('#dataFrom').serialize();
	$.ajax({ 
         type:'post', 
         url:root+'/task_trigger_update.do', 
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
/**
 * 删除信息转发配置的信息
 */
function deleteData(){
	if(confirm("是否确认删除此信息转发数据")){
		var taskName = $('#taskName').val();
		var taskGroup = $('#taskGroup').val();
		$.ajax({ 
	        type:'post', 
	        url:root+'/task_trigger_update.do?option=delete&taskName='+encodeURI(encodeURI(taskName))+'&taskGroup='+encodeURI(encodeURI(taskGroup)), 
	        success:function(msg){
	           if(msg==''){
	               alert("删除成功！"); 
	               doSearch();
	               parent.$('#dataModal').modal('hide');
	           }else{
	        	   alert("请求出现错误:"+msg);  //弹出失败msg
	           }
	        },
	        error:function(msg){       
	        }
	   });
	}
}


/**
 * 删除数据
 * @param serverIds
 */
function serverDelete(ruleIds){
	$.ajax({ 
        type:'post', 
        url:root+'/rule_info_update.do?option=delete&ruleIds='+ruleIds, 
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
        forceFit:true,
		caption: "同步服务器选择界面",
		autowidth: true,
		autoScroll:false,
		shrinkToFit:false
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
function syncBaseMap(syncdata,serverIds){
	var urlParama = '';
    if(syncdata == 'all'){
    	urlParama = 'type=task_trigger_info&serverIds='+serverIds;
    }else{
    	urlParama = 'type=task_trigger_info|'+syncdata.taskName+'|'+syncdata.taskGroup+'&serverIds='+serverIds;
    }
	$.ajax({ //同步规则配置信息
        type:'post', 
        url:root+'/data_sync.do?'+urlParama, 
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
/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
	$('#'+modalId).hide();
}