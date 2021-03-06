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
			  
			{ text: '添加数据' , iconCls: 'fa fa-plus', handler: function () {
					openModalWin('add',"");
				}
			}, '-',
			{ text: '查看数据' , iconCls: 'fa fa-search', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('view',rowData);
				}else{
					alert("请选择一条记录！");
				}
			   
				}
			}, '-',
			{ text: '修改数据' , iconCls: 'fa fa-edit', handler: function () {
					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
					if(ids.length==1){
						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
						openModalWin('update',rowData);
					}else{
						alert("请选择一条记录！");
					}
			   
				}
			}, '-',
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
		colNames:[ '唯一标识ID','参数字段', '参数名称-中文','参数类型','创建人','创建时间','修改人','修改时间','状态' ],
		colModel:[
					{
						sortable:false,
						name : 'fieldid',
						index : 'fieldid',
						width : 100,
						hidden :true
						
					}, {
						sortable:false,
						name : 'parameterfields',
						index : 'parameterfields',
						width : 200
						
					}, {
						sortable:false,
						name : 'parameternamech',
						index : 'parameternamech',
						width : 200
					},{
						sortable:false,
						name : 'parametertype',
						index : 'parametertype',
						width : 200,
						formatter: "select",
						editoptions:{value:"int:整数型;double:小数型;string:字符型;date:日期时间型"}
					},{
						sortable:false,
						name : 'createuser',
						index : 'createuser',
						width : 200
					},{
						sortable:false,
						name : 'createtime',
						index : 'createtime',
						width : 200
					}, {
						sortable:false,
						name : 'updateuser',
						index : 'updateuser',
						width : 200
					}, {
						sortable:false,
						name : 'updatetime',
						index : 'updatetime',
						width : 200
					}, {
						sortable:false,
						name : 'status',
						index : 'status',
						width : 200,
						formatter: "select",
						editoptions:{value:"0:有效;1:无效;2:有效"}
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
	    url:root+'/modelQParaInfo_Config_query.do',
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
	var paraEn = $("#searchParaEn").val().trim();
	var paraCh = $("#searchParaCh").val().trim();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{paraEn:paraEn,paraCh:paraCh},
	    //url:root+'/modelQParaInfo_Config_query.do?paraEn='+paraEn+'&paraCh='+paraCh,
	    url:root+'/modelQParaInfo_Config_query.do',
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
		$('#c_fieldid').val(data.fieldid).attr("disabled","disabled");
		$('#c_parameterfields').val(data.parameterfields).attr("disabled","disabled");
	 	$('#c_parameternamech').val(data.parameternamech).attr("disabled","disabled");
	 	$('#c_parametertype').val(data.parametertype).attr("disabled","disabled");
	 	$('#c_createuser').val(data.createuser).attr("disabled","disabled");
	 	$('#c_updateuser').val(data.updateuser).attr("disabled","disabled");
	 	$('#c_createtime').val(data.createtime).attr("disabled","disabled");
	 	$('#c_updatetime').val(data.updatetime).attr("disabled","disabled");
	 	$('#c_status').val(data.status).attr("disabled","disabled");
		$('#tr_createuser').removeAttr("hidden");
	 	$('#tr_updateuser').removeAttr("hidden");
	 	$('#tr_createtime').removeAttr("hidden");
	 	$('#tr_updatetime').removeAttr("hidden");
		//validator.resetForm();
	 	$('#dataTitle').html("查看数据【"+data.parameterfields+"】");
	 	
	}else if(type=="update"){
		$('#c_option').val("update");
		$('#c_fieldid').val(data.fieldid).attr("disabled","disabled");
		$('#c_parameterfields').val(data.parameterfields).attr("disabled","disabled");
	 	$('#c_parameternamech').val(data.parameternamech).attr("disabled","disabled");
	 	$('#c_parametertype').val(data.parametertype).attr("disabled","disabled");
	 	$('#c_createuser').val(data.createuser).attr("disabled","disabled");
	 	$('#c_updateuser').val(data.updateuser).attr("disabled","disabled");
	 	$('#c_createtime').val(data.createtime).attr("disabled","disabled");
	 	$('#c_updatetime').val(data.updatetime).attr("disabled","disabled");

	 	$('#c_status').val(data.status).attr("disabled",false);
		$('#tr_createuser').attr("hidden","true");
	 	$('#tr_updateuser').attr("hidden","true");
	 	$('#tr_createtime').attr("hidden","true");
	 	$('#tr_updatetime').attr("hidden","true");
		//validator.resetForm();
		$('#saveUpdateBtn').show();
		$('#dataTitle').html("修改数据【"+data.parameterfields+"】");
		iscleck=true;
	}else if(type=="add"){
		$('#c_option').val("add");
	    $('#c_fieldid').val("");
		$('#c_parameterfields').val("");
	 	$('#c_parameternamech').val("");
	 	$('#c_parametertype').val("");
	 	$('#c_status').val("0");
	 	$('#c_parameterfields');
	 	$('#c_parameternamech');
	 	disabledclose();
	 	$('#tr_createuser').attr("hidden","true");
	 	$('#tr_updateuser').attr("hidden","true");
	 	$('#tr_createtime').attr("hidden","true");
	 	$('#tr_updatetime').attr("hidden","true");
	 	$('#saveUpdateBtn').show();
	 	$('#dataTitle').html("添加数据");
	 	iscleck=true;
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
    window.open("modelQfield_excel_export");
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
        url:root+'/modelQfield_excel_import.do', 
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
				var fieldExist = data.fieldExist;
				var tableDiv = "";
	            if(fieldExist != ""){
	            	tableDiv = "<p style='font-size:16px;font-weight:bold;'>Excel数据在数据库中已存在的数据如下:</p>";
	            	tableDiv = tableDiv + "<table style='font-size:14px;'><tr><td>序号</td><td>参数字段</td><td>参数名中文</td><td>参数类型</td></tr>";
	            	var index = fieldExist.indexOf(';');
	            	if(index==-1){
	            		var strs = fieldExist.split(",");
	            		tableDiv = tableDiv+"<tr><td>"+strs[0]+"</td><td>"+strs[1]+"</td><td>"+strs[2]+"</td><td>"+strs[3]+"</td></tr>";
	            		tableDiv = tableDiv+"</table>";
	            	}
	            	if(index>-1){
	            		var fieldExists = fieldExist.split(";");
	            		for(var i=0;i<fieldExists.length;i++){
	            			var str = fieldExists[i];
	            			var strs = str.split(",");
	            			tableDiv = tableDiv+"<tr><td>"+strs[0]+"</td><td>"+strs[1]+"</td><td>"+strs[2]+"</td><td>"+strs[3]+"</td></tr>";
	            		}
	            		tableDiv = tableDiv+"</table>";
	            	}
	            		
	            }
	            divDiv = divDiv+tableDiv;
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


//校验参数字段
function checkIsEnExists() {
	//focusPass = false;     //重新初始化focusPass的值
	$('#d_parameterfields').hide();    //先把上次显示提示清除
	var parameterfields = $('#c_parameterfields').val().trim();
	$.ajax({
        type: "post",
        url: root+'/modelQcheckParaName_isExist.do',
        data:{"parameterfields":parameterfields}, 
        dataType: "json",
        success: function(data){
        	if(data.isPass==false){
        		//alert("参数字段已存在，请重新输入！");
        		isExist1 = true;
        		$('#d_parameterfields').show();
        		$('#c_parameterfields').focus();
        	}
        	if(data.isPass==true){
        		isExist1 = false;
        	}
        },
        error: function () { 
        	alert("操作失败"); 
        }
    });
}

//校验参数名称中文
function checkIsChExists() {
	//focusPass = false;     //重新初始化focusPass的值
	$('#d_parameternamech').hide();  //先把上次显示提示清除
	var parameternamech = $('#c_parameternamech').val().trim();
	$.ajax({
        type: "post",
        url: root+'/modelQcheckParaName_isExist.do',
        data:{"parameternamech":parameternamech}, 
        dataType: "json",
        success: function(data){
        	if(data.isPass==false){
        		//alert("参数名称-中文已存在，请重新输入！");
        		isExist2 =true;
        		$('#d_parameternamech').show();
        		$('#c_parameternamech').focus();
        	}
        	if(data.isPass==true){
        		isExist2 = false;
        	}
        },
        error: function () {  
        	alert("操作失败");  
        }
    });
}

function checkIsUsed(){
	//focusPass = false;     //重新初始化focusPass的值
	var statusValue = $("#c_status option:selected").val();
	var fieldid = $('#c_fieldid').val();
	var parameterfields = $('#c_parameterfields').val().trim();
	var option = $('#c_option').val();
	if(statusValue =="1"&&option=="update"){
		 $.ajax({
		        type: "post",
		        url: root+'/modelQcheck_field_isUsed.do',
		        data:{"parameterfields":parameterfields,"fieldid":fieldid}, 
		        datatype: "json",
		        success: function(data){
		        	if(data.isPass==false){
		        		alert("该参数已被模型配置，不能改为无效！");
		        		isExist3 =true;
		        		$('#saveUpdateBtn').hide();	
		        	}
		        	if(data.isPass==true){
		        		isExist3 = false;
		        	}
		        },
		        error: function () { 
		        	alert("操作失败");  
		        }
		    });
	 }
	 if(statusValue =="0"&&option=="update"){
		 isExist3 =false;
		 $('#saveUpdateBtn').show();	
	 }
}

/**
 * 接收返回信息
 * @param el
 * @param method
 */

var iscleck=null;
function saveOrUpdate(){
	/*do{
		setInterval(Date.parse(new Date()),"1000"); //每隔1秒执行一次
	}while (!focusPas) //当文本框中数据校验执行完跳出
		
	alert("focusPas="+focusPas);*/
	if($("#dataFrom").valid()&&iscleck){
		var option = $('#c_option').val();
		iscleck=false;
		if(option=="add"&&(isExist1||isExist2)){
			alert("参数字段或参数名中文已存在，请重新输入！");
			return false;
		}
		disabledclose();
		var data = $('#dataFrom').serialize();
		disabledopen();
		$.ajax({ 
	         type:'post', 
	         url:root+'/modelQparaInfo_Config_save.do', 
	         data:data, 
	         async:false,
	         success:function(msg){
	            if(msg==''){
	                alert("保存成功！");        //弹出成功msg
	                //刷新表格数据
	                doSearch();
	                $('#dataModal').modal('hide');
	            }else{
	            	alert("保存失败:"+msg);  //弹出失败msg
	            }
	         },
	         error:function(msg){       
	         }
	    });
	}
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
