/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * PMML配置表
 */
var tool = [ 
			 
		
		{ text: '查看请求数据' , iconCls: 'fa fa-edit', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('view',rowData);
				}else{
					alert("请选择一条记录！");
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
		colNames:[ '贷款号','交易流水号','业务流水号','客户名称','证件类型','证件号码','模型编码','产品编码','请求日期','1'],
		colModel:[
					{
						sortable:false,
						name : 'jnlNo',
						index : 'jnlNo',
						width : 80,
					},
					 {
						sortable:false,
						name : 'serialNo',
						index : 'serialNo',
						width : 80,
						hidden : true
					},
					
					{
						sortable:false,
						name : 'businessNo',
						index : 'businessNo',
						width : 80
						
						
					}
					
					,{
						sortable:false,
						name : 'cifName',
						index : 'cifName',
						width : 80
						
						
					},{
						
						sortable:false,
						name : 'idType',
						index : 'idType',
						width : 80
						
						
					},{
						sortable:false,
						name : 'idNo',
						index : 'idNo',
						width : 80
						
						
					},  {
						sortable:false,
						name : 'modelCode',
						index : 'modelCode',
						width : 80
						
					}, {
						sortable:false,
						name : 'productId',
						index : 'productId',
						width : 80
					},  {
						
						sortable:false,
						name : 'rkDate',
						index : 'rkDate',
						width : 120
					},{
						
                        hidden : true,
						sortable:false,
						name : 'message',
						index : 'message',
						width : 120
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

		caption: "客户请求信息",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/mqi_Idp_Request_Info_query.do',
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
	var JnlNo = $("#JnlNo").val();
	var businessNo = $("#businessNo").val();
	var cifName = $("#cifName").val();
	var idNo = $("#idNo").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{JnlNo:JnlNo,businessNo:businessNo,cifName:cifName,idNo:idNo},
	    url:root+'/mqi_Idp_Request_Info_query.do',
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
	$("label.error").remove();//清除验证标签
	$("input.error").removeClass("error");//清除验证标签
	
	$.each($('label[name=error]'), function() {
		$(this).hide();
	});
	$('#dataModal').modal('show');
	$('#saveUpdateBtn').hide();
	
	if(type=="view"){

		$('#messAge').val(data.message).prop("disabled",true);
		
		
		
		$('#dataTitle').html("请求数据信息");
	}
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

