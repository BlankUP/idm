function requestService(url,reqData,callbackFn){
		$.ajax({ 
	         type:'post', 
	         url:url, 
	         data:reqData, 
//	         async:false,
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

var matchTool = [ 
     			{ text: '添加角色' , iconCls: 'fa fa-plus', handler: function () {
     					openModalWin('add');
     				}
     			},{
     				text: '修改角色' , iconCls: 'fa fa-edit', handler: function () {
     					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
     					if(ids.length==1){
     						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
     						openModalWin('modify',rowData);
     					}else{
     						alert("请选择一条记录！");
     					}
     				}
     			},{
     				text: '删除角色' , iconCls: 'fa fa-remove', handler: function () {
     					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
     					if(ids.length==1){
     						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
     						deleteRole(rowData.roleNo);
     					}else{
     						alert("请选择一条记录！");
     					}
     				}
     			},{
     				text: '授权' , iconCls: 'fa fa-edit', handler: function () {
     					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
     					if(ids.length==1){
     						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
     						openModalWin('authorize',rowData);
     					}else{
     						alert("请选择一条记录！");
     					}
     				}
     			},{
     				text: '用户查看' , iconCls: 'fa fa-search', handler: function () {
     					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
     					if(ids.length==1){
     						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
     						openModalWin('viewUsers',rowData);
     					}else{
     						alert("请选择一条记录！");
     					}
     				}
     			}
     		];

function init(obj){
}

function changeSelect(){
}

function doSearch(){
	var roleNo = $("#searchRoleNo").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData : {roleNo:roleNo},
	    url:root+'/role_service.do?',
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
		colNames:[ '角色ID', '角色名称','角色描述','状态','创建时间','角色权限','创建用户' ],
		colModel:[
					{
						sortable:false,
						name : 'roleNo',
						index : 'roleNo',
						width : 100
					}, {
						sortable:false,
						name : 'roleName',
						index : 'roleName',
						width : 100
						
					}, {
						sortable:false,
						name : 'roleDesc',
						index : 'roleDesc',
						width : 100
					}, {
						sortable:false,
						name : 'roleStatus',
						index : 'roleStatus',
						hidden : true,
						width : 100,
						formatter: function(cellvalue, options, rowObject){
							if(cellvalue==1){
								return "<span>有效</span>";
							}else if(cellvalue==0){
								return "<span>无效</span>";
							}
						}
					}, {
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 100
					},{
						sortable:false,
						name : 'roleRoot',
						index : 'roleRoot',
						width : 80,
						formatter: "select",
						editoptions:{value:"0:普通用户;1:一级审批人;2:二级审批人;3:管理员"}
					},
					{
						sortable:false,
						name : 'createUser',
						index : 'createUser',
						width : 100
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
		caption: "角色管理",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/role_service.do?init=false',
	    datatype : "json"
	}).trigger("reloadGrid");
});

//校验
function verify() {
	
	var str = true;
	if($('#role_option').val()== "add"){
		
		repeatRoleNo();
		repeatRoleName();
		$.each($('label[name=error]'), function() {
			if(!$(this).is(":hidden")) {
				str= false;
			}
		});
	}
	return str;
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
}

function openModalWin(type, data){
	if(type=='add') {
		$('#roleTitle').html("添加角色");
		$('#role_option').val("add");
		$("#roleNo").val('').prop("disabled",false);
		$('#roleNo1').attr("disabled","disabled");
		$("#roleName").val('').prop("disabled",false);
		$('#roleName1').attr("disabled","disabled");
		$("#roleDesc").val('').prop("disabled",false);
	    $("#roleRoot").val("0").attr('disabled',false);
	    $("#roleRoot1").attr("disabled","disabled");
		$('#spTr').hide();
		$("#roleModal").modal('show');
		iscleck=true;
	}else if(type=='modify'){
		$('#roleTitle').html("修改角色");
		$('#role_option').val("modify");
		$("#roleNo").val(data.roleNo).attr("disabled","disabled");
		$('#roleNo1').val(data.roleNo);
		$("#roleNo1").removeAttr('disabled');
		$("#roleName").val(data.roleName).attr("disabled","disabled");
		$('#roleName1').val(data.roleName);
		$("#roleName1").removeAttr('disabled');
		$("#roleDesc").val(data.roleDesc);
		$("#roleRoot").val(data.roleRoot).attr("disabled","disabled");
		$("#roleRoot1").val(data.roleRoot);
		$("#roleRoot1").removeAttr('disabled');
		$("#roleStatus").attr("value", data.roleStatus);
		$('#spTr').hide();
		$("#roleModal").modal('show');
		iscleck=true;

	}else if(type=='authorize'){
		$('#authTitle').html("角色授权");
		$('#authBody').data('roleno',data.roleNo);
		$.ajax({
	        type: "post",
	        url: root+'/role_menuTree.do',
	        success: function(data){
	    		$('#authBody').html(data);
	    		$('#authModal').modal('show');
	        }
	    });
	}else if(type=='viewUsers') {
//		$('#userTitle').html("角色用户查看");
		$('#userBody').data('roleNo',data.roleNo);
		$.ajax({
	        type: "post",
	        url: root+'/role_viewUsers.do',
	        success: function(data){
	    		$('#userBody').html(data);
	    		$('#userModal').modal('show');
	        }
	    });
	}
}

function deleteRole(roleNo){
	if(confirm("是否删除选中记录？")){
		$.ajax({
	        type: "post",
	        url: root+'/role_deleteRoleInfo.do',
	        data:{"roleNo":roleNo}, 
	        dataType: "json",
	        success: function(data){
	    		if(data.success == true) alert("删除成功");
	        	else alert("删除失败");
	        },
	        error: function () {  
	         alert("操作失败");  
	        }  
	    });
		doSearch();
	}
}

function roleSubmit(){
	if($("#dataFrom").valid()){
		if(!verify()){
			alert("请配置正确的参数");
			return
		}else{
    $("#roleModal").modal("toggle");
    var data = $('#dataFrom').serialize();
	$.ajax({
        type: "post",
        url: root+'/role_saveOrUpdate.do',
        data:data, 
        async:false,
        dataType: "json",
        success: function(data){
        	if($('#role_option').val()=="add"){
        		if(data.success == true) alert("添加成功");
            	else alert("添加失败");
        	}else{
        		if(data.success == true) alert("修改成功");
            	else alert("修改失败");
        	}
        	
        },
        error: function () {  
         alert("操作失败==================");  
        }  
    });
		}
		doSearch();
	}
	
}
var iscleck=null;
function authSubmit(){
	if($("#dataFrom").valid()&&iscleck){
	iscleck=false;
    $("#authModal").modal("toggle");
    var data = $('#dataFrom').serialize();
	$.ajax({
        type: "post",
        url: root+'/role_saveOrUpdate.do',
        data:data, 
        dataType: "json",
        async:false,
        success: function(data){
        	if($('#role_option').val()=="add"){
        		if(data.success == true) alert("添加成功");
            	else alert("添加失败");
        	}else{
        		if(data.success == true) alert("修改成功");
            	else alert("修改失败");
        	}
        	
        },
        error: function () {  
         alert("操作失败");  
        }  
    });
	doSearch();
	}
}
var validator = null;
$(document).ready(function() {
	validator = $("#dataFrom").validate({
		rules : {
			roleNo : {
				required : true,
				rangelength : [ 0, 100 ]
			},
			roleName : {
				required : true,
				rangelength : [ 0, 100 ]
			},
			userStatus : {
				required : true
			},
			roleDesc : {
				required : true,
				rangelength : [ 0, 100 ]
			}
			
		},
		focusCleanup : true
	});
});


//校验有角色Id是否重复
function repeatRoleNo() {
	var roleNo = $('#roleNo').val();
	if(roleNo != null){
		$.ajax({
			type : "post",
			url : root + '/role_service_selectRoleByRoleNo.do',
			data : {
				"roleNo" : roleNo
			},
			async:true, 
			dataType : "json",
			success : function(data) {
				if (data.success) {
					$("#c_roleNo").show();
					$('#roleNo').focus();
				}else{
					$("#c_roleNo").hide();
				}
			},
			error : function() {
				alert("操作失败");
			}
		});
	}
}

//角色名称
function repeatRoleName() {
	var roleName = $('#roleName').val();
	if(roleName != null){
		$.ajax({
			type : "post",
			url : root + '/role_service_selectRoleByRoleName.do',
			data : {
				"roleName" : roleName
			},
			async:true, 
			dataType : "json",
			success : function(data) {
				if (data.success) {
					$("#c_roleName").show();
					$('#roleName').focus();
				}else{
					$("#c_roleName").hide();
				}
			},
			error : function() {
				alert("操作失败");
			}
		});
	}
}
//添加角色权限验证
function addRoleRoot() {

	var roleRoot = $('#roleRoot').val();
	if($('#role_option').val()== "add"){
		$.ajax({
		type : "post",
		url : root + '/role_selectRoleRoot.do?roleRoot='+roleRoot,
		async:true,
		date:{
			roleRoot:roleRoot,
		},
		dataType : "json",
		success : function(data) {
			if (data.success == true ) {
				$('#c_roleRoot').show();
				$('#roleRoot').focus();
			}else{
				$("#c_roleRoot").hide();
			}
		},
		error : function() {
			alert("操作失败");
		}
	});
	}
}


