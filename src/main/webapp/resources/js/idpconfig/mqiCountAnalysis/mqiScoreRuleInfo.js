/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * PMML配置表
 */
var tool = [ 
			 
		
		{ text: '查看评分规则明细' , iconCls: 'fa fa-edit', handler: function () {
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
		colNames:[ '贷款号','交易流水号','业务流水号','客户名称','证件类型','身份证号','机构编码','机构名称','产品编码','产品名称','模型编码','模型名称','总分','接受请求日期','接受请求时间'],
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
					},{
						sortable:false,
						name : 'businessNo',
						index : 'businessNo',
						width : 100,

					}, {
						sortable:false,
						name : 'cifName',
						index : 'cifName',
						width : 80
					},{
						sortable:false,
						name : 'idType',
						index : 'idType',
						width : 80,
						hidden:true
					},{
						sortable:false,
						name : 'idNo',
						index : 'idNo',
						width : 80
					},{
						sortable:false,
						name : 'deptId',
						index : 'deptId',
						width : 100,
						hidden:true
					},{
						sortable:false,
						name : 'deptName',
						index : 'deptName',
						width : 100,
						hidden:true
					},{
						sortable:false,
						name : 'productId',
						index : 'productId',
						width : 100,
						hidden:true
					},{
						sortable:false,
						name : 'productName',
						index : 'productName',
						width : 100,
						hidden:true
					},{
						sortable:false,
						name : 'modelCode',
						index : 'modelCode',
						width : 100
					},{
						sortable:false,
						name : 'modelName',
						index : 'modelName',
						width : 100
					},{
						sortable:false,
						name : 'totalScore',
						index : 'totalScore',
						width : 80
					},{
						sortable:false,
						name : 'rkDate',
						index : 'rkDate',
						width : 80
					},{
						sortable:false,
						name : 'rkTime',
						index : 'rkTime',
						width : 80
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

		caption: "评分规则总分信息",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/mqi_scoreRule_TotalScore_Info_query.do',
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
		});
};

function doSearch(){
	var jnlNo = $("#jnlNo").val();
	var businessNo =$("#businessNo").val();
	var modelCode =$("#modelCode").val();
	var cifName =$("#cifName").val();
	var idNo =$("#idNo").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{"jnlNo":jnlNo,"businessNo":businessNo,"modelCode":modelCode,"cifName":cifName,"idNo":idNo},
	    url:root+'/mqi_scoreRule_TotalScore_Info_query.do',
	    datatype : "json"
	}).trigger("reloadGrid");
}


function openModalWin(type,data){
	var businessNo = data.businessNo; //业务流水号
	var modelCode = data.modelCode;   // 模型编码
	$('#dataModal').modal('show');
	if(type=="view"){
		$('#dataTitle').html("总流程编码【"+data.serialNo+"】的评分规则详情");
		var grid_selector1 = "#grid-table1";
		var pager_selector1 = "#grid-pager1";
		jQuery(grid_selector1).jqGrid({

			datatype: "local",
			regional:'cn',
			height: "auto",
			colNames:[ '交易流水号','业务流水号','规则编码','规则名称','字段初始值','字段严重程度','规则结果','规则得分'],
			colModel:[
						 {
							sortable:false,
							name : 'serialNo',
							index : 'serialNo',
							width : 100,
							hidden:true
						},{
							sortable:false,
							name : 'businessNo',
							index : 'businessNo',
							width : 100,
							
						},{
							sortable:false,
							name : 'ruleCode',
							index : 'ruleCode',
							width : 100
						},{
							sortable:false,
							name : 'ruleName',
							index : 'ruleName',
							width : 100
						},{
							sortable:false,
							name : 'initializationValue',
							index : 'initializationValue',
							width : 100
						},{
							
							sortable:false,
							name : 'ruleSeverityLevel',
							index : 'ruleSeverityLevel',
							width : 100
							
						}
						
						,{
							sortable:false,
							name : 'ruleResult',
							index : 'ruleResult',
							width : 80
						},{
							sortable:false,
							name : 'score',
							index : 'score',
							width : 80
						}
						], 
			viewrecords : true,
			rowNum:10,
			rowList:[10,20,30,50,100],
			pager : pager_selector1,
			altRows: true,
			multiselect: true,
	        multiboxonly: true,

			loadComplete : function() {
				var table = this;
				setTimeout(function(){
					updatePagerIcons(table);
				}, 0);
			},
			caption: "评分规则明细",
			autowidth: true
		}).jqGrid('setGridParam', {
		    page : 1,
		    postData:{'businessNo':businessNo,'modelCode':modelCode},
		    url:root+'/mqi_scoreRule_detail_Info_query.do',
		    datatype : "json"
		}).trigger("reloadGrid");
	}
}

