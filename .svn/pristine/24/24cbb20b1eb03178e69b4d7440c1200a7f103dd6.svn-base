
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '业务流水号', '客户名称','证件号码', '接口名称', '接口编码', '响应码','请求时间','uuid','tableName','操作'],
		colModel:[
					{
						sortable:false,
						name : 'querySeqNo',
						index : 'querySeqNo',
						width : 120
					}, {
						sortable:false,
						name : 'custName',
						index : 'custName',
						width : 80						
					}, {
						sortable:false,
						name : 'certNum',
						index : 'certNum',
						width : 150
					}, {
						sortable:false,
						name : 'serviceName',
						index : 'serviceName',
						width : 100
					}, {
						sortable:false,
						name : 'serviceId',
						index : 'serviceId',
						width : 100
					},{
						sortable:false,
						name : 'responseCode',
						index : 'responseCode',
						width : 80
					},{
						sortable:false,
						name : 'dataTime',
						index : 'dataTime',
						width : 150
					},{
						sortable:false,
						name : 'uuid',
						index : 'uuid',
						width : 50,
                		hidden : true
					},{
						sortable:false,
						name : 'tableName',
						index : 'tableName',
						width : 50,
						hidden : true
					},  {
						sortable:false,
						name : 'querySeqNo',
						index : 'querySeqNo',
						width : 60,
						formatter: function(cellvalue, options, rowObject){
							return '<a href="javascript:void(0)" onclick="dolike(\''+rowObject.uuid+'\',\''+rowObject.tableName+'\')">查看明细</a>';
						}
					}
				], 
		/*onCellSelect : function(rowid,iCol,cellcontent,e) {
			var rowData = $("#grid-table").jqGrid('getRowData',rowid);
            $.ajax({
                type: "GET",
                url: root+'/external_data_clob?uuid='+rowData.uuid+"&tableName="+rowData.tableName,
                dataType: "json",
                success: function(data){
                    $("#responsecontextInfo").text("响应报文： \n" + data);
                },
                error: function () {
                    alert("查询失败");
                }
            });
			//$("#requestcontextInfo").text("请求报文：" + rowData.requestcontext);
			//$("#responsecontextInfo").text("响应报文：" + rowData.responsecontext);
			$("#duModal").modal({
				keyboard : false
			});
		},*/
		viewrecords : true,
		rowNum:10,
		rowList:[10,20,30,50,100],
		pager : pager_selector,
		altRows: true,
		multiselect: false,
        multiboxonly: true,
        
		loadComplete : function() {
			var table = this;
			setTimeout(function(){
				updatePagerIcons(table);
			}, 0);
		},
		
		
		caption: "外部数据源数据列表",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/external_data',
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
}
function doSearch(){
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/external_data?querySeqNo='+$("#querySeqNo").val()+'&custName='+$("#custName").val()+'&certNum='+$("#certNum").val()+'&serviceId='+$("#serviceId").val()+'&serviceName='+$("#serviceName").val(),
	    datatype : "json"
	}).trigger("reloadGrid");
}

/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
	$('#'+modalId).hide();
}

function dolike(uuid,tableName){
    $.ajax({
        type: "GET",
        url: root+'/external_data_clob?uuid='+uuid+"&tableName="+tableName,
        dataType: "json",
        success: function(data){
            $("#responsecontextInfo").text("响应报文： \n" + data);
        },
        error: function () {
            alert("查询失败");
        }
    });
    //$("#requestcontextInfo").text("请求报文：" + rowData.requestcontext);
    //$("#responsecontextInfo").text("响应报文：" + rowData.responsecontext);
    $("#duModal").modal({
        keyboard : false
    });
}