var isExist1 = true;
var isExist2 = true;
var isExist3 = true;
var focusPass = true;      //确保(checkIsEnExists(),checkIsChExists(),checkIsUsed())运行完

/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
   var tool = [ 
			  
/*			{ text: '添加数据' , iconCls: 'fa fa-plus', handler: function () {
					openModalWin('add',"");
				}
			}, '-',*/
			{ text: '查看数据' , iconCls: 'fa fa-search', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('view',rowData);
				}else{
					alert("请选择一条记录！");
				}
			   
				}
			},  '-',
			{ text: 'Excel导入新增' , iconCls: 'fa fa-plus', handler: function () {
					openModalEexcel('excelInsert',"");
			  }
			}
			/*,'-',
			{ text: 'Excel模板导出' , iconCls: 'fa fa-plus', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalEexcel('excelExport',rowData);
				}else{
					alert("请选择一条记录！");
				}
				
			  }
			}*/
			];
			
$(document).ready(function() {
	var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '唯一标识ID','规则序号', '模型编码','模型名称','规则编码','规则名称','规则类型','创建时间','创建人','状态' ],
		colModel:[
					{
						sortable:false,
						name : 'mtrid',
						index : 'mtrid',
						width : 100,
						hidden :true
						
					}, {
						sortable:false,
						name : 'seqno',
						index : 'seqno',
						width : 100
						
					}, {
						sortable:false,
						name : 'modelcode',
						index : 'modelcode',
						width : 250
					}, {
						sortable:false,
						name : 'modelname',
						index : 'modelname',
						width : 250
					}, {
						sortable:false,
						name : 'rulecode',
						index : 'rulecode',
						width : 250
					}, {
						sortable:false,
						name : 'rulename',
						index : 'rulename',
						width : 250
					},
					{
						sortable:false,
						name : 'ruletype',
						index : 'ruletype',
						width : 150,
						formatter: "select",
						editoptions:{value:"1:拒绝规则类型;2:评分规则类型"}
					},{
						sortable:false,
						name : 'createtime',
						index : 'createtime',
						width : 150
					},{
						sortable:false,
						name : 'createuser',
						index : 'createuser',
						width : 150
					}, {
						sortable:false,
						name : 'status',
						index : 'status',
						width : 150,
						formatter: "select",
						editoptions:{value:"0:有效;1:无效"}
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

		caption: "",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/modelrule_query.do',
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
	var modelcode = $("#searchParaEn").val().trim();
	var modelname = $("#searchParaCh").val().trim();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{"modelcode":modelcode,"modelname":modelname},
	    //url:root+'/paraInfo_Config_query.do?paraEn='+paraEn+'&paraCh='+paraCh,
	    url:root+'/modelrule_query.do',
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
	$('#d_parameterfields').hide();
	$('#d_parameternamech').hide();
	//textareaDeal();
	$('#tr_createuser').attr("hidden","true");
 	$('#tr_updateuser').attr("hidden","true");
 	$('#tr_createtime').attr("hidden","true");
 	$('#tr_updatetime').attr("hidden","true");
	if(type=="view"){
		$('#c_option').val("view");
		$('#c_mtrid').val(data.mtrid).attr("disabled","disabled");
		$('#c_seqno').val(data.seqno).attr("disabled","disabled");
	 	$('#c_modelcode').val(data.modelcode).attr("disabled","disabled");
	 	$('#c_modelname').val(data.modelname).attr("disabled","disabled");
	 	$('#c_rulecode').val(data.rulecode).attr("disabled","disabled");
	 	$('#c_rulename').val(data.rulename).attr("disabled","disabled");
	 	$('#c_ruletype').val(data.ruletype).attr("disabled","disabled");
	 	$('#c_createuser').val(data.createuser).attr("disabled","disabled");
	 	$('#c_createtime').val(data.createtime).attr("disabled","disabled");
	 	$('#c_status').val(data.status).attr("disabled","disabled");
		$('#tr_createuser').removeAttr("hidden");
	 	$('#tr_createtime').removeAttr("hidden");
		//validator.resetForm();
	 	$('#dataTitle').html("查看数据【"+data.modelname+"】");
	} 
}

/**
 * 根据类型打开模态框 
 *  load模窗口的数据
 * @param type
 * @param rowdata
 */
function openModalEexcel(type,data){
	if(type=="excelInsert"){
		$('#uploadFileModal').modal('show');
		$('#uploadFileSubmit').show();
		$('#uploadFileTitle').html("Excel批量导入参数");
	}
	
}

/**
 * 导出excel
 */
function doExportSubmit(){
    window.open("modelrule_export");
}

/*导入Excel数据*/
function doExcelImportData(){
	
	//首先验证文件格式
    var fileName = $('#file').val();
    if (fileName === '') {
        alert('请选择文件');
        return false;
    }
    var fileType = (fileName.substring(fileName
            .lastIndexOf(".") + 1, fileName.length))
            .toLowerCase();
    if (fileType !== 'xls' && fileType !== 'xlsx') {
        alert('文件格式不正确，excel文件！');
        return false;
    }
    
    var formData = new FormData($('#excelDataFrom')[0]); 
	$.ajax({ 
        type:'post', 
        url:root+'/modelrule_import.do', 
        data:formData,
        contentType: false, //不设置内容类型
        async: false,  
		cache: false, 
		processData: false,
        beforeSend:function(){
            console.log("正在进行，请稍候");
        },
		success:function(data){
			var divDiv =  "<p style='font-size:14px;'>"+data.message+"</p>";
			if(data.result == "success"){  //导入成功
				parent.$('#uploadFileModal').modal('hide');   //对导入页面进行关闭
	            doSearch();                 //刷新页面
	        }
			$('#importExcelDataResultDetail').modal('show');
			$("#importExcelDataResultContent").html(divDiv);
			$('#importExcelDataResultDetailTitle').html("Excel批量导入结果");
	    },
	    error:function(data){
	    	alert("导入失败!");        
	    }
   });
}

var validator=null;
$(document).ready(function(){
	validator=$("#dataFrom").validate({
		rules: {
			parameterfields:{
				required:true,
				codestr:true,
				rangelength:[0,50]
			},
			parameternamech:{
				required:true,
				rangelength:[0,50]
			},
			parametertype:{
				required:true,
				rangelength:[0,20]
			},
			status:{
				required:true,				
				rangelength:[0,2]
			}	   
	    },focusCleanup:true
	});
});

function clearCheck(){
	validator.resetForm();
	$('input').removeClass("valid");
	$('select').removeClass("valid");
	$('textarea').removeClass("valid");
}

/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
	$('#'+modalId).hide();
}

function disabledclose(){
    $('#c_fieldid').attr("disabled",false);
	$('#c_parameterfields').attr("disabled",false);
 	$('#c_parameternamech').attr("disabled",false);
 	$('#c_parametertype').attr("disabled",false);
 	$('#c_status').attr("disabled",false);
 	$('#c_parameterfields').attr("disabled",false);
 	$('#c_parameternamech').attr("disabled",false);
}

function disabledopen(){
    $('#c_fieldid').attr("disabled",true);
	$('#c_parameterfields').attr("disabled",true);
 	$('#c_parameternamech').attr("disabled",true);
 	$('#c_parametertype').attr("disabled",true);
 	$('#c_status').attr("disabled",true);
 	$('#c_parameterfields').attr("disabled",true);

}

/**
 * 对table的大小随页面变化而变化
 */
$(function(){
    $(window).resize(function(){  
	 $("#grid-table").setGridWidth($(window).width());
	});
}); 
