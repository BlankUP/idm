
/**
* 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * PMML配置表
 */
var tool = [ 
			 
		
		{ text: '查看评分卡明细' , iconCls: 'fa fa-edit', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('view',rowData);
				}else{
					alert("请选择一条记录！");
				}
		   
			}
		} ,'-', {
			text : '导出',
			iconCls : 'fa fa-plus',
			handler : function() {
				var serialNo = $("#serialNo").val();
				var cifName = $("#cifName").val();
				var startDate = $("#startDate").val();
				var endDate = $("#endDate").val();
				var url = root+"/scoreCardExcel.do?serialNo="+serialNo+"&cifName="+cifName+"&startDate="+startDate+"&endDate="+endDate;
				if(startDate=='' || endDate==''){
					alert("请输入开始日期及结束日期，再导出！")
				}else{
					window.open(url);
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
		colNames:[ '交易流水号','业务流水号','客户名称','证件类型','身份证号','机构编码','机构名称','产品编码','产品名称','模型编码','模型名称','总分','接受请求日期','接受请求时间'],
		colModel:[
					 {
						sortable:false,
						name : 'serialNo',
						index : 'serialNo',
						width : 100
					},{
						sortable:false,
						name : 'businessNo',
						index : 'businessNo',
						width : 100,
						hidden:true
					}, {
						sortable:false,
						name : 'cifName',
						index : 'cifName',
						width : 100
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
						width : 100
					},{
						sortable:false,
						name : 'deptId',
						index : 'deptId',
						width : 100
					},{
						sortable:false,
						name : 'deptName',
						index : 'deptName',
						width : 100
					},{
						sortable:false,
						name : 'productId',
						index : 'productId',
						width : 100
					},{
						sortable:false,
						name : 'productName',
						index : 'productName',
						width : 100
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
						width : 100
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

		caption: "评分卡总分信息",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/scoreCard_TotalScore_Info_query.do',
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
	var serialNo = $("#serialNo").val();
	var businessNO =$("#businessNO").val();
	var modelCode =$("#modelCode").val();
	var cifName =$("#cifName").val();
	var idNo =$("#idNo").val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{"serialNo":serialNo,"businessNO":businessNO,"modelCode":modelCode,"cifName":cifName,"idNo":idNo,"startDate":startDate,"endDate":endDate},
	    url:root+'/scoreCard_TotalScore_Info_query.do',
	    datatype : "json"
	}).trigger("reloadGrid");
}


function openModalWin(type,data){
	var businessNo = data.businessNo; //业务流水号
	var modelCode = data.modelCode;   // 模型编码
	$('#dataModal').modal('show');
	if(type=="view"){
		$('#dataTitle').html("交易节点流水号【"+data.serialNo+"】的评分详情");
		var grid_selector1 = "#grid-table1";
		var pager_selector1 = "#grid-pager1";
		jQuery(grid_selector1).jqGrid({

			datatype: "local",
			regional:'cn',
			height: "auto",
			colNames:[ '交易节点流水号','业务流水号','姓名','证件类型','身份证号','机构编码','机构名称','产品编码','产品名称','模型编码','模型名称','字段','字段中文','字段初始值','命中区间','得分'],
			colModel:[
						 {
							sortable:false,
							name : 'queryseqNo',
							index : 'queryseqNo',
							width : 100,
							hidden:true
						},{
							sortable:false,
							name : 'businessNo',
							index : 'businessNo',
							width : 100,
							hidden:true
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
							width : 100
						},{
							sortable:false,
							name : 'deptId',
							index : 'deptId',
							width : 100
						},{
							sortable:false,
							name : 'deptName',
							index : 'deptName',
							width : 100
						},{
							sortable:false,
							name : 'productId',
							index : 'productId',
							width : 100
						},{
							sortable:false,
							name : 'productName',
							index : 'productName',
							width : 100
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
							name : 'filed',
							index : 'filed',
							width : 100
						},{
							sortable:false,
							name : 'filedName',
							index : 'filedName',
							width : 100
						},{
							sortable:false,
							name : 'filedValue',
							index : 'filedValue',
							width : 100
						},{
							sortable:false,
							name : 'hitRange',
							index : 'hitRange',
							width : 100
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
			caption: "评分明细",
			autowidth: true
		}).jqGrid('setGridParam', {
		    page : 1,
		    postData:{'businessNo':businessNo,'modelCode':modelCode},
		    url:root+'/scoreCard_detail_Info_query.do',
		    datatype : "json"
		}).trigger("reloadGrid");
	}
}

