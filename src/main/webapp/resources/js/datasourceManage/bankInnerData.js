
$(document).ready(function() {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '客户号', '客户名称','证件号码', '代发工资客户标志', '房贷客户标志', '有存款标志','有理财标志','贷款逾期客户标志','操作','uuid'],
		colModel:[
					{
						sortable:false,
						name : 'custId',
						index : 'custId',
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
						width : 100
					}, {
						sortable:false,
						name : 'wagesPayCustInd',
						index : 'wagesPayCustInd',
						width : 80,
						formatter: function(cellvalue){
							return ("1"==cellvalue)?"是":"否";
						}
					}, {
						sortable:false,
						name : 'houseMortgLoanCustInd',
						index : 'houseMortgLoanCustInd',
						width : 80,
						formatter: function(cellvalue){
							return ("1"==cellvalue)?"是":"否";
						}
					},{
						sortable:false,
						name : 'dpsitCustInd',
						index : 'dpsitCustInd',
						width : 80,
						formatter: function(cellvalue){
							return ("1"==cellvalue)?"是":"否";
						}
					},{
						sortable:false,
						name : 'chremCustInd',
						index : 'chremCustInd',
						width : 80,
						formatter: function(cellvalue){
							return ("1"==cellvalue)?"是":"否";
						}
					},{
						sortable:false,
						name : 'loanOvdueInd',
						index : 'loanOvdueInd',
						width : 80,
						formatter: function(cellvalue){
							return ("1"==cellvalue)?"是":"否";
						}
					},  {
						sortable:false,
						name : 'querySeqNo',
						index : 'querySeqNo',
						width : 60,
						formatter: function(cellvalue, options, rowObject){
							return '<a href="javascript:void(0)" onclick="dolike(\''+rowObject.uuid+'\')">查看明细</a>';
						}
					},{
                        name : 'uuid',
                        index : 'uuid',
                        hidden : true
                    }
				],
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
		
		
		caption: "行内数据列表",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/inner_data',
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
	    url:root+'/inner_data?custName='+$("#custName").val()+'&certNum='+$("#certNum").val(),
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

function dolike(uuid){
    $.ajax({
        type: "GET",
        url: root+'/get_data_by_uuid?uuid='+uuid,
        async : false,
        dataType: "json",
        success: function(data){
            var str="";
            console.log(data.length);
            console.log(data[0]);
            for(var i=0;i<data.length;){
                str +=
					"<tr>" +
                    "<td style='width: 30%;text-align: left;'>" + (i<data.length?trim(data[i].column_comments):"") + "</td>" +
                    "<td style='width: 20%;text-align: center;'>" + (i<data.length?trim(data[i].column_value):"") + "</td>" +
                    "<td style='width: 30%;text-align: left;'>" + ((i+1)<data.length?trim(data[i+1].column_comments):"") + "</td>" +
                    "<td style='width: 20%;text-align: center;'>" + ((i+1)<data.length?trim(data[i+1].column_value):"") + "</td>" +
                    "</tr>";
                i+=2;
            }
            $("#detail").html(str);
        },
        error: function () {
            alert("查询失败");
        }
    });
    //$("#du_username").html(name);
    $("#duModal").modal({
        keyboard : false
    });

}

function trim(obj){
    if(typeof obj !="undefined"){
        return obj;
    }else{
        return "-";
    }
}