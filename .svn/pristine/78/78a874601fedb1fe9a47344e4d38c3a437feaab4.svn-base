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
     			{ text: '添加部门' , iconCls: 'fa fa-plus', handler: function () {
     					openModalWin('add');
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
     			},{
     				text: '删除部门' , iconCls: 'fa fa-remove', handler: function () {
     					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
     					if(ids.length==1){
     						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
     						deleteDep(rowData.depNo);
     					}else{
     						alert("请选择一条记录！");
     					}
     				}
     			}
     		];

function init(obj){
}

function changeSelect(){
	var depNo = $("#searchDepNo").val();
	var depName = $("#searchDepName").val();
	requestService("dataStat_service.do",{depName:depName,depNo:depNo,init:'true'},init);
}
function doSearch(){
	var depNo = $("#searchDepNo").val();
	var depName = $("#searchDepName").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData : {depName:depName,depNo:depNo},
	    url:root+'/dep_service.do?',
	    datatype : "json"
	}).trigger("reloadGrid");
}

$(document).ready(function() {
//	requestService("dataStat_service.do",{type:type,originsys:originsys,init:'true'},init);
	var grid_selector = "#grid-table";
	var pager_selector = $("#grid-pager");

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: 'auto',
		colNames:[ '部门编号', '部门名称','描述','状态','上级部门','更新时间' ],
		colModel:[
					{
						sortable:false,
						name : 'depNo',
						index : 'depNo',
						width : 100
					}, {
						sortable:false,
						name : 'depName',
						index : 'depName',
						width : 100
						
					}, {
						sortable:false,
						name : 'depDesc',
						index : 'depDesc',
						width : 100
					}, {
						sortable:false,
						name : 'depStatus',
						index : 'depStatus',
						width : 100,
						hidden : true,
						formatter: function(cellvalue, options, rowObject){
							if(cellvalue==0){
								return "<span>有效</span>";
							}else if(cellvalue==1){
								return "<span>无效</span>";
							}
						}
					}, {
						hidden : true,
						sortable:false,
						name : 'parentDepNo',
						index : 'parentDepNo',
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
		caption: "部门管理",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/dep_service.do?init=false',
	    datatype : "json"
	}).trigger("reloadGrid");
});


//校验
function verify() {
	
	var str = true
	if($('#dep_option').val()== "add"){
		
		repeatDepNo();
		repeatDepName();
		 
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
	$("#depModal").modal('show');
	if(type=='add') {
		$('#depTitle').html("添加部门");
		$('#dep_option').val("add");
		$("#depNo").val('').attr("readOnly",false);
		$("#depName").val('').attr("readOnly",false);
		$('#spTr').hide();
		$('#depDesc').val('');
		iscleck=true;
	}else if(type=='modify'){
		$('#depTitle').html("修改信息");
		$('#dep_option').val("modify");
		$("#depNo").val(data.depNo).attr("readOnly",true);
		$("#depName").val(data.depName).attr("readOnly",true);
		$("#depDesc").val(data.depDesc);
		$('#spTr').hide();
		$("#depStatus").attr("value", data.depStatus);
		iscleck=true;
	}
}

function deleteDep(depNo){
	if(confirm("是否删除选中记录？")){
		$.ajax({
	        type: "post",
	        url: root+'/dep_deleteDepInfo.do',
	        data:{"depNo":depNo}, 
	        dataType: "json",
	        success: function(data){
	    		if(data.success == true) {
	    			alert("删除成功");
	    			location.href = location.href;
	    		}else {
	        		alert("删除失败");
	        	}
	        },
	        error: function () {  
	         alert("操作失败");  
	        }  
	    });
		
	}
}
var iscleck=null;
function depSubmit(){
	if($("#dataFrom").valid()&&iscleck){
		if(!verify()){
			alert("请配置正确的参数");
			return
		}else{
			iscleck=false;
    $("#depModal").modal("toggle");
    var data = $('#dataFrom').serialize();
	$.ajax({
        type: "post",
        async:false,
        url: root+'/dep_saveOrUpdate.do',
        data:data, 
        dataType: "json",
        success: function(data){
        	if($('#dep_option').val()=="add"){
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
}

var validator = null;
$(document).ready(function() {
	validator = $("#dataFrom").validate({
		rules : {
			depNo : {
				required : true,
				rangelength : [ 0, 50 ],
			},
			depName : {
				required : true,
				rangelength : [ 0, 100 ]
			},
			depStatus : {
				required : true
			},
			parentDepNo : {
				required : true
			},
			depDesc : {
				required : true,
				rangelength : [ 0, 100 ]
			}
		},
		focusCleanup : true
	});
});

function repeatDepNo() {
	var depNo = $('#depNo').val();
	if(depNo != null){
		$.ajax({
			type : "post",
			url : root + '/dep_service_selectDepInfoBydepNo.do',
			data : {
				"depNo" : depNo
			},
			dataType : "json",
			success : function(data) {
				if (data.success) {
					$("#c_depNo").show();
					$('#depNo').focus();
				}else{
					$("#c_depNo").hide();
				}
			},
			error : function() {
				alert("操作失败");
			}
		});
	}
}

function repeatDepName() {
	var depName = $('#depName').val();
	if(depName != null){
		$.ajax({
			type : "post",
			url : root + '/dep_service_selectDepInfoBydepName.do',
			data : {
				"depName" : depName
			},
			dataType : "json",
			success : function(data) {
				if (data.success) {
					$("#c_depName").show();
					$('#depName').focus();
				}else{
					$("#c_depName").hide();
				}
			},
			error : function() {
				alert("操作失败");
			}
		});
	}
}

