/**
 * 需要同步的全局变量数据
 */
var syncdata = null;

var tool = [ 
			 
		
		{ text: '规则信息' , iconCls: 'fa fa-edit', handler: function () {
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
		colNames:[ '贷款号','交易流水号','业务流水号','客户名称','证件类型','证件号','模型编码','请求日期','规则名称','规则结果'],
		colModel:[
						{
							sortable:false,
							name : 'jnlNo',
							index : 'jnlNo',
							width : 80
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
						
						
					},{
						sortable:false,
						name : 'cifName',
						index : 'cifName',
						width : 40
						
						
					},{
						hidden:true,
						sortable:false,
						name : 'idType',
						index : 'idType',
						width : 50
						
						
					},{
						sortable:false,
						name : 'idNo',
						index : 'idNo',
						width : 60
						
						
					},  {
						sortable:false,
						name : 'modelCode',
						index : 'modelcode',
						width : 60
						
					},{
						sortable:false,
						name : 'rkDate',
						index : 'rkDate',
						width : 50
					},{  
						sortable:false,
						name : 'ruleName',
						index : 'ruleName',
						width : 80
//		                formatter: function (cellvalue, options, rowObject) {
//		                	if(rowObject.businessNo!=""){
//		                var businessNo=	rowObject.businessNo;
//		                	var htmlObj = $.ajax({
//		                		url : "doRuleResult_query.do",
//
//		                		type : "post",
//		                		async : false,
//		                		data : {businessNo:businessNo}
//		                	});
//
//		                	var text = htmlObj.responseText;
//
//		                	var json = JSON.parse(text);
//
//		                	return json.ruleName;
//
//		                }
//		                }
					},{  
						sortable:false,
						name : 'rule',
						index : 'rule',
						width : 40,
						formatter: "select",
						editoptions:{value:"0:未命中;1:命中"},
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

		caption: "拒绝规则统计",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/mqi_reject_rule_Info_query.do',
	    datatype : "json"
	}).trigger("reloadGrid");
});


function ruleresult(businessNo){
	$.ajax({ 
        type:'post', 
        url:root+'/mqi_ruleresult.do', 
        data:{"businessNo":businessNo},
        success:function(data){
           if(data.retCode=='0'){
           	alert("业务重跑已成功发起");
           }else{
        	 alert(data.retMsg);
           }
           doSearch();
        },
        error:function(data){
        	alert("查询规则结果失败");
        }
   });
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
		})
}
function doSearch(){
	var jnlNo = $("#jnlNo").val();

	var businessNo = $("#businessNo").val();
	var modelCode = $("#modelCode").val();
	var cifName = $("#cifName").val();

	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{businessNo:businessNo,jnlNo:jnlNo,modelCode:modelCode,cifName:cifName},
	    url:root+'/mqi_reject_rule_Info_query.do',
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
	$("#ruleresultModal").modal('show');
	if(type=="view"){
		var businessNo = data.businessNo;
		var grid_selector = "#ruleresult-grid-table";
		var pager_selector = $("#ruleresult-grid-pager");
		

		jQuery(grid_selector).jqGrid({
			datatype: "local",
			regional:'cn',
			height: 'auto',
			colNames:[ '规则名称', '规则编码','字段','规则结果','请求日期' ],
			colModel:[
						{
							sortable:false,
							name : 'ruleName',
							index : 'ruleName',
							width : 300
						}, {
							sortable:false,
							name : 'ruleCode',
							index : 'ruleCode',
							width : 170
							
						}, {
							sortable:false,
							name : 'initializationValue',
							index : 'initializationValue',
							width : 129
						}, {
							sortable:false,
							name : 'ruleResult',
							index : 'ruleresult',
							width : 100
						}, {
							sortable:false,
							name : 'rkDate',
							index : 'rkDate',
							width : 100
						}
						],
			viewrecords : true,
			rowNum:10,
			pager : pager_selector,
			altRows: true,
	        loadComplete : function() {
	        	var table = this;
				setTimeout(function(){
					updatePagerIcons(table);
				}, 0);
			},
			caption: "拒绝规则详细信息",
			autowidth: true
		}).jqGrid('setGridParam', {
		    page : 1,
		    url:root+'/mqi_ruleResultSerch.do?businessNo=' + businessNo,
		    datatype : "json"
		}).trigger("reloadGrid");
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

function doRuleResult(businessNo){
	
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{businessNo:businessNo},
	    url:root+'/mqi_doRuleResult_query.do',
	    datatype : "json"
	}).trigger("reloadGrid");
}

