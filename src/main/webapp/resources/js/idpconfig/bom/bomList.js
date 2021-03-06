function requestService(url,reqData,callbackFn){
	$.ajax({ 
         type:'post', 
         url:url, 
         data:reqData, 
         success:function(data){
            callbackFn(data); 
         },
         error:function(data){
	        alert("访问服务器出错");  
         }
    });
}
function init(obj){
	var orgs=obj.orgs;
	var select="<option value='' selected='1' >--</option>";
	console.log(obj.myOrg);
	for(var i=0;i<orgs.length;i++){
		if(obj.myOrg!=undefined && obj.myOrg == orgs[i].ORG_NO){
			select+="<option value='"+orgs[i].ORG_NO+"' selected='selected'>"+orgs[i].ORG_NAME+"</option>";
		}else {
			select+="<option value='"+orgs[i].ORG_NO+"' >"+orgs[i].ORG_NAME+"</option>";
		}
		
	}
	$("#orgSelect").html(select);
	
	var roles=obj.roles;
	var radio = "";
	var myroles=obj.myRoles;
	console.log(myroles);
	for(var j=0;j<roles.length;j++){
		if(myroles!=undefined && myroles.indexOf(roles[j].ROLE_NO)!=-1){
			radio+="<input type='checkbox' checked='checked' name='roles' value='"+roles[j].ROLE_NO+"'/>"+roles[j].ROLE_NAME +"         ";
		}else {
			radio+="<input type='checkbox' name='roles' value='"+roles[j].ROLE_NO+"'/>"+roles[j].ROLE_NAME +"         ";
		}
		
	}
	$("#roleCheckbox").html(radio);
}
var matchTool = [ 
     			{ text: '生成新版本' , iconCls: 'fa fa-plus', handler: function () {
     					openModalWin('add');
     				}
     			}
     			,{
     				text: '修改版本信息' , iconCls: 'fa fa-edit', handler: function () {
     					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
     					if(ids.length==1){
     						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
     						openModalWin('update',rowData);
     					}else{
     						alert("请选择一条记录！");
     					}
     				}
     			}
     			,{ text: '下载BOM' , iconCls: 'fa fa-plus', handler: function () {
     				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
 					if(ids.length==1){
 						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
 						if(confirm("是否下载"+rowData.bomVersionNo+"版本？")){
 		   					 //执行同步方法
 		    					download(rowData);
 		    			}
 					}else{
 						alert("请选择一条记录！");
 					}
	    				
 					}
     			}
     		];
function doSearch(){
	var bomVersionNo = $("#bomVersionNo").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{bomVersionNo:bomVersionNo},
	    url:root+'/bominfo_query.do',
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
		colNames:[ '版本号', '版本名称','版本描述','创建时间','创建人','状态','文件编号','编号' ],
		colModel:[
					{
						sortable:false,
						name : 'bomVersionNo',
						index : 'bomVersionNo',
						width : 100
					}, {
						sortable:false,
						name : 'versionName',
						index : 'versionName',
						width : 100
						
					}, {
						sortable:false,
						name : 'versionDepiction',
						index : 'versionDepiction',
						width : 100
						
					}, {
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 100
						
					}, {
						sortable:false,
						name : 'createUser',
						index : 'createUser',
						width : 100
					}, {
						sortable:false,
						name : 'status',
						index : 'status',
						width : 100,
						formatter: "select",
						editoptions:{value:"0:最近下载版本;1:历史版本;2:未下载版本"}
//						formatter: function(cellvalue, options, rowObject){
//							if(cellvalue==0){
//								return "<span>正在使用</span>";
//							}else if(cellvalue==1){
//								return "<span>历史版本</span>";
//							}
//						}
					},{
						hidden:true,
						sortable:false,
						name : 'fileId',
						index : 'fileId',
						width : 100
					},{
						hidden:true,
						sortable:false,
						name : 'bomId',
						index : 'bomId',
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
		caption: "BOM版本管理",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/bominfo_query.do',
	    datatype : "json"
	}).trigger("reloadGrid");
});
//
var validator = null;
$(document).ready(function() {
	validator = $("#dataFrom").validate({
		rules : {
			bomVersionName : {
				required : true,
				stringCheck : true,
				rangelength : [ 0, 100 ]
			}
		},
		focusCleanup : true
	});
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
	if(type=='add') {
		$('#bomTitle').html("一键生成BOM文件");
		$('#option').val("add");
		$('#bomMtable').attr("style","display:none;");
		$("#versionDepiction").val('');
		$("#bomVersionName").removeAttr("readOnly");
		$("#bomVersionName").val('');
		$("#bomModal").modal('show');
	}else if(type=='update'){
		$('#bomTitle').html("修改信息");
		$('#option').val("update");
		$('#bomMtable').removeAttr("style");
		$("#bomId").val(data.bomId);
		$("#bomVersionName").val(data.versionName);
		$("#bomVersionName").attr('readOnly','readOnly');
		$("#bomVersion").val(data.bomVersionNo);
		$("#bomVersion").attr('readOnly','readOnly');
		$("#versionDepiction").val(data.versionDepiction);
		$("#bomModal").modal('show');
	}
};
//生成BOM
function bomSubmit(){
    $("#bomModal").modal("toggle");
    var data = $('#dataFrom').serialize();
	$.ajax({
        type: "post",
        url: root+'/bom_create.do',
        data:data, 
        dataType: "json",
        success: function(data){
        	if($('#option').val()=="add"){
        		if(data.success){
        			alert("生成BOM文件成功");
        		}else {
            		alert("生成BOM文件失败");
            	}
        	}else if($('#option').val()=="update"){
        		if(data.success){
        			alert("修改信息成功");
        		}else {
            		alert("修改信息失败");
            	}
        	}
        	doSearch();
        },
        error: function () {  
        	alert("操作失败");  
        }
    });
};
//下载BOM
function download(data){
	var fileId=data.fileId;
	var bomId=data.bomId;
	var url=root+"/bom_download.do?fileId="+fileId+"&bomId="+bomId;
	$.ajax({
        url: root+"/bom_download.do?fileId="+fileId+"&bomId="+bomId,
        success: function(data){
        if(data){
        	window.open(url);
        	doSearch();
        }else{
        	alert("下载失败");
        }
        },
        error: function () {  
        	alert("操作失败");  
        }
    });
	/*if(window.open(url)){
//		alert("下载成功");
		doSearch();
	}else{
		alert("下载失败");
	}*/
//	setTimeout(doSearch(),1000);  
}

//格式化日期函数
Date.prototype.format = function(format)
{
	 var o = {
	 "M+" : this.getMonth()+1, //month
	 "d+" : this.getDate(),    //day
	 "h+" : this.getHours(),   //hour
	 "m+" : this.getMinutes(), //minute
	 "s+" : this.getSeconds(), //second
	 "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
	 "S" : this.getMilliseconds() //millisecond
	 };
	 if(/(y+)/.test(format)) format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
	 for(var k in o)
		 if(new RegExp("("+ k +")").test(format))
			 format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] :("00"+ o[k]).substr((""+ o[k]).length));
	 return format;
};


