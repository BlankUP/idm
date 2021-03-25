

   var tool = [ 
			{ text: '添加数据' , iconCls: 'fa fa-plus', handler: function () {
					
					openModalWin('add');
				}
			}, '-', { text: '查看数据' , iconCls: 'fa fa-search', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('view',rowData);
				}else{
					alert("请选择一条记录！");
				}
			   
			}
		}, '-',{ text: '修改数据' , iconCls: 'fa fa-edit', handler: function () {
					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
					if(ids.length==1){
						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
						openModalWin('update',rowData);
					}else{
						alert("请选择一条记录！");
					}
			   
				}
			}, '-',  
			{ text: '删除数据' , iconCls: 'fa fa-remove', handler: function () {
					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
					var serverIds="";
					if(ids.length==0){
						alert("请选择一条或者多条记录！");
					}else{
						for(var i=0;i<ids.length;i++){
							var rowData = $("#grid-table").jqGrid('getRowData',ids[i]);
							serverIds += rowData.serverId+"$$";
						}
						if(confirm("是否确认删除选中数据？")){
							serverDelete(serverIds);
						}
					}
				}
			}, '-',  
			
			{ text: '同步缓存' , iconCls: 'fa fa-refresh', handler: function () {
				openCache();

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
		colNames:[ '','服务器名称','IP','端口','类型','F5服务地址','服务地址','描述' ,'状态','创建时间','创建人'],
		colModel:[
					{
						sortable:false,
						name : 'serverId',
						index : 'serverId',
						width : 120,
						hidden:true
					}, {
						sortable:false,
						name : 'name',
						index : 'name',
						width : 200
						
					}, {
						sortable:false,
						name : 'ip',
						index : 'ip',
						width : 200
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
						editoptions:{value:"1:风控系统服务器;2:模型质检服务器;"}
					}, {
						sortable:false,
						name : 'f5Url',
						index : 'f5Url',
						width : 240
					}, {
						sortable:false,
						name : 'serverUrl',
						index : 'serverUrl',
						width : 240
					}, {
						sortable:false,
						name : 'remark',
						index : 'remark',
						width : 200,
						hidden:true
					}, {
						sortable:false,
						name : 'status',
						index : 'status',
						width : 100,
						formatter: "select",
						editoptions:{value:"1:停用;0:启用"}
					},{
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 180
					}, {
						sortable:false,
						name : 'createUser',
						index : 'createUser',
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

		caption: "服务器配置",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/server_info_query.do',
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
	var serverIP = $("#searchServerId").val();
	var name = $("#searchName").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/server_info_query.do',
	    postData:{name:name,serverIP:serverIP},
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
	$('#t_createTime').hide();
	$('#t_createUser').hide();
	if(type=="view"){
		$('#c_option').val("view");
		$('#dataFrom input[type="text"]').attr('readonly','readonly');
		$('#c_serverId').val(data.serverId);
		$('#c_name').val(data.name);
		$('#c_ip').val(data.ip);
		$('#c_port').val(data.port);
		$('#c_type').val(data.type);
		$('#c_type').attr("readonly","readonly");
		$('#c_f5Url').val(data.f5Url);
		$('#c_serverUrl').val(data.serverUrl);
		$('#c_status').val(data.status);
		$('#c_status').attr("readonly","readonly");
		$('#c_createTime').val(data.createTime);
		$('#c_createUser').val(data.createUser);
		$('#c_remark').val(data.remark);
		$('#c_remark').attr("readonly","readonly");
		$('#dataTitle').html("查看数据");
		$('#t_createTime').show();
		$('#t_createUser').show();
	}else if(type=="update"){
		$('#c_option').val("update");
		$('#d_name').hide();	
		$('#c_serverId').val(data.serverId);
		$('#c_name').val(data.name).attr("readOnly",false);
		$('#c_ip').val(data.ip).attr("readOnly",false);
		$('#c_port').val(data.port).attr("readOnly",false);
		$('#c_type').val(data.type).attr("readOnly",false);
		$('#c_f5Url').val(data.f5Url).attr("readOnly",false);
		$('#c_serverUrl').val(data.serverUrl).attr("readOnly",false);
		$('#c_status').val(data.status).attr("readOnly",false);
		$('#c_remark').val(data.remark).attr("readOnly",false);
		$('#dataTitle').html("修改数据");
		$('#saveUpdateBtn').show();  
		iscleck=true;
	}else if(type=="add"){
		$('#c_option').val("add");
		$('#d_name').hide();
		$('#c_serverId').val("");
		$('#c_name').val("").attr("readOnly",false);
		$('#c_ip').val("").attr("readOnly",false);
		$('#c_port').val("").attr("readOnly",false);
		$('#c_type').val("21").attr("readOnly",false);
		$('#c_f5Url').val("").attr("readOnly",false);
		$('#c_serverUrl').val("").attr("readOnly",false);
		$('#c_status').val("0").attr("readOnly",false);
		$('#c_createTime').val("");
		$('#c_createUser').val("");
		$('#c_remark').val("").attr("readOnly",false);		
	 	$('#dataTitle').html("添加数据");
	 	$('#saveUpdateBtn').show(); 
	 	iscleck=true;
	} 
	
}


/**
 * 接收返回信息
 * @param el
 * @param method
 */
var iscleck=null;
function saveOrUpdate(){
	if($("#dataFrom").valid()&&iscleck){
		iscleck=false;
		
		var data = $('#dataFrom').serialize();
		$.ajax({ 
	         type:'post', 
	         url:root+'/server_info_update.do', 
	         data:data, 
	         async:false,
	         success:function(msg){
	            if(msg==''){
	                alert("保存成功！");        //弹出成功msg
	                //刷新表格数据
	                doSearch();
	                $('#dataModal').modal('hide');
	            }else{
	                alert("请求出现错误:"+msg);  //弹出失败msg
	            }
	         },
	         error:function(msg){       
	         }
	    });
	}
	}

function serverDelete(serverIds){
	$.ajax({ 
        type:'post', 
        url:root+'/server_info_update.do?option=delete&serverIds='+serverIds, 
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
var validator=null;
$(document).ready(function(){
	
	validator=$("#dataFrom").validate({
		rules: {
			name:{
				required:true,
				rangelength:[0,200]	
			},
			ip:{
				required:true,
				rangelength:[0,200],	
				ipstr:true
			},
			port:{
				required:true,
				rangelength:[0,20],	
				number: true
			},
			type:{
				required:true	
			},
			f5Url:{
				required:true,
				rangelength:[0,200],
				ipstr : true
			},
			serverUrl:{
				required:true,
				rangelength:[0,200],
				ipstr : true
			},
			status:{
				required:true	
			},
			remark:{
				rangelength:[0,400]	
			}
	    },focusCleanup:true
	});
});

var validator1=null;
$(document).ready(function(){
	validator1=$("#searchForm").validate({
		rules:{
			searchServerId:{
				rangelength:[0,200],	
				ipstr:true
			},
			
	    },focusCleanup:true
	});
});

/**
 * 清除检验输入内容长度判断
 */
function clearCheck(){
	validator.resetForm();
	$('input').removeClass("valid");
	$('select').removeClass("valid");
	$('textarea').removeClass("valid");
}

$(document).ready(function() {
	var grid_selector = "#gridStat-table";	
	var pager_selector = "#gridStat-pager";
	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '服务器ID', 'IP', '订阅状态','操作'],
		colModel:[
					{
						sortable:false,
						name : 'serverId',
						index : 'serverId',
						width : 120	,
						editable:true
					}, {
						sortable:false,
						name : 'ip',
						index : 'ip',
						width : 120,
						editable:true,
						editrules:{required:true}
					}, {
						sortable:false,
						name : 'stat',
						index : 'stat',
						width : 120	,
						align:'center',
						formatter:'select',
						edittype:'select',
						editoptions:{value:"true:中止;false:订阅"}
					}, {
						sortable:false,
						name : 'oprate',
						index : 'oprate',
						width : 200,
						align:'center'
					}
					], 
		viewrecords : true,
		pager : pager_selector,
		rowNum:10,
		altRows: true,
		multiselect: false,
        multiboxonly: false,
		gridComplete:function(){  //在此事件中循环为每一行添加编辑和删除链接

			var ids = jQuery("#gridStat-table").jqGrid('getDataIDs');
            for ( var i = 0; i < ids.length; i++) {
              var stat = $("#gridStat-table").getCell(ids[i],'stat');
              alert(stat);
      		  var serverId = $("#gridStat-table").getCell(ids[i],'serverId');
              var zt ="<a href='#' onclick='searchStat('"+ serverId + "');' class='' > 暂停定阅</a> ";   
              var jx ="<a href='#' onclick='searchStat('"+ serverId + "');' class='' > 继续定阅</a> ";
              jQuery("#gridStat-table").jqGrid('setRowData', ids[i],
                  {
            	  oprate :  "<li><c:if test='false'>"+jx+"</if></li><li><c:if test='true'>"+zt+"</if></li>"
                 
                  });
            }
        },
       
		caption: "服务器订阅状态查询",
		autowidth: true
	});
});

function searchStat(serverIds){
	//disabledButton(false);
	$('#dataModalStat').modal('show');
	$("#gridStat-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/server_info_update.do?option=seviceStat&type=queryStat&serverIds='+serverIds,
	    datatype : "json"
	    
	}).trigger("reloadGrid");
}

function cacheSynchronize() {
	if(!confirm("是否同步服务器？")){
		return;
	}
	var type = $("#ca_type").val();
	$.ajax({ 
         type:'post', 
         url:root+"/cache_synchronize",
         data:{"type":type},
         dataType:'text',
         success:function(data){
        	 var dataObj=eval("("+data+")");
        	 console.log(dataObj);
        	if(dataObj.success){
        		alert("同步缓存成功 \n"+dataObj.rel);
        	}else{
        		alert("同步缓存失败 \n"+dataObj.rel);
        	}
        	 $('#cacheSynchronize').modal('hide');
         },
         error:function(data){
        	 alert("同步缓存失败"); 
         }
    });
};

/**
 * 对table的大小随页面变化而变化
 */
$(function(){
    $(window).resize(function(){  
	 $("#grid-table").setGridWidth($(window).width());
	});
});


function openCache(){
	getServerName();
	$('#cacheSynchronize').modal('show');
}
function getServerName(){
	$("#server_name").empty();
	var html="";
	var type = $("#ca_type").val();
	$.ajax({ 
        type:'post', 
        url:root+"/select_servername",
        data:{"type":type}, 
        dataType:'text',
        success:function(data){
	     	if(data!=undefined&&data.length>0){
	    		$.each(JSON.parse(data),function(i,v){
	        		html+=v.name+"("+v.ip+")<br/>";
	        	});
				$("#server_name").html(html);
	    	}
        },
        error:function(data){
       	 	alert("服务器信息获取失败"); 
        }
   });
}
var isExist1 = true;
//校验服务器是否重复
function repeatServerName() {
        //触发onblur方法开始时，把falg的值设置为false
	$("#d_name").hide();   //先把上次显示提示清除
	var serverName = $('#c_name').val().trim();

	if(serverName != null){
		$.ajax({
			type : "post",
			url : root + '/repeatServerName.do',
			data : {
				"serverName" : serverName
			},
			async:false,
			dataType : "json",
			success : function(data) {
				if (data.success) {
					
					$("#d_name").show();
					$('#c_name').focus();
				
					
				}else{
					$("#d_name").hide();
				}
			
			},
			error : function() {
				alert("操作失败");
				
			}
		});
	}
}


