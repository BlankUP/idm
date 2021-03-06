/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * PMML配置表
 */
var tool = [ 
			 
			{ text: '添加数据' , iconCls: 'fa fa-plus', handler: function () {
				
				openModalWin('add');
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
		}  , '-',  
		{ text: '上传文件' , iconCls: 'fa fa-edit', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openUpload(rowData);
				}else{
					alert("请选择一条记录！");
				}
	   
			}
		}, '-',  
		{ text: '文件版本管理' , iconCls: 'fa fa-edit', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					showFile(rowData);
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
		colNames:[ 'PMML模型编码','PMML模型名称','PMML模型描述','文件数量','创建人','创建时间','编号','状态','数据源'],
		colModel:[
					 {
						sortable:false,
						name : 'pmmlCode',
						index : 'pmmlCode',
						width : 80
					}, {
						sortable:false,
						name : 'pmmlName',
						index : 'pmmlName',
						width : 80
						
					}, {
						sortable:false,
						name : 'pmmlDesc',
						index : 'pmmlDesc',
						width : 80
						
					}, {
						sortable:false,
						name : 'fileNum',
						index : 'fileNum',
						width : 80
						
					}, {
						sortable:false,
						name : 'createUser',
						index : 'createUser',
						width : 80
					}, {
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 80
					},  {
						hidden:true,
						sortable:false,
						name : 'pmmlId',
						index : 'pmmlId',
						width : 120
					}, {
						sortable:false,
						name : 'status',
						index : 'status',
						formatter: "select",
						editoptions:{value:"0:有效;1:无效"},
						width : 80
					}, {
						hidden:true,
						sortable:false,
						name : 'interfaceCode',
						index : 'interfaceCode',
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

		caption: "",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/pmml_query.do',
	    datatype : "json"
	}).trigger("reloadGrid");
});
//文件管理
$(document).ready(function() {
	var grid_selector = "#pmmlFile-table";
	jQuery(grid_selector).jqGrid({

		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '版本号','版本描述','创建人','创建时间','状态','编号'],
		colModel:[
					{
						sortable:false,
						name : 'version',
						index : 'version',
						width : 160
					}, {
						sortable:false,
						name : 'versionDesc',
						index : 'versionDesc',
						width : 160
						
					},{
						sortable:false,
						name : 'createUser',
						index : 'createUser',
						width : 80
						
					}, {
						sortable:false,
						name : 'createTime',
						index : 'createTime',
						width : 160
						
					}, {
						sortable:false,
						name : 'status',
						index : 'status',
						width : 80,
						formatter: "select",
						editoptions:{value:"0:未发布;1:已发布"}
						
					}, {
						hidden:true,
						sortable:false,
						name : 'pmmlFileId',
						index : 'pmmlFileId',
						width : 80
					}
					], 
		viewrecords : true,
		altRows: true,
		multiselect: true,
        multiboxonly: true,
		caption: "PMML模型文件信息表",
		autowidth: true
	}).jqGrid('setGridParam', {
	    url:root+'/pmml_file_query.do',
	    datatype : "json"
	}).trigger("reloadGrid");
	
});
function showFile(data) {
	var pmmlId = data.pmmlId;
	$("#pmmlFile-table").jqGrid('setGridParam', {
	    url:root+'/pmml_file_query.do?pmmlId='+pmmlId,
	    datatype : "json"
	}).trigger("reloadGrid");
	$('#pmmlFile').modal('show');
};
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
	var pmmlName = $("#pmmlName").val();
	var pmmlCode =$("#pmmlCode").val();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{pmmlCode:pmmlCode,pmmlName:pmmlName},
	    url:root+'/pmml_query.do',
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
		$('#c_pmmlId').val('');
		$('#c_pmmlCode').val(data.pmmlCode).prop("disabled",true);
		$('#c_pmmlName').val(data.pmmlName).prop("disabled",true);
		$('#c_pmmlDesc').val(data.pmmlDesc);
		interfaceCodeUnChecked();
		interfaceCodeChecked(data.interfaceCode);
		$('#dataTitle').html("查看数据【"+data.pmmlName+"】");
	}else if(type=="update"){
		iscleck=true;
		$('#c_option').val("update");
		$('#c_pmmlId').val(data.pmmlId);
		$('#c_pmmlCode').val(data.pmmlCode).prop("disabled",true);
		$('#c_pmmlName').val(data.pmmlName).prop("disabled",true);
		$('#c_pmmlDesc').val(data.pmmlDesc);
		interfaceCodeUnChecked();
		interfaceCodeChecked(data.interfaceCode);
		$('#dataTitle').html("修改数据【"+data.pmmlName+"】");
		$('#saveUpdateBtn').show();        	
	}else if(type=="add"){
		iscleck=true;
		$('#c_option').val("add");
		$('#c_pmmlId').val('');
		$('#c_pmmlCode').val('').prop("disabled",false);
		$('#c_pmmlName').val('').prop("disabled",false);
		$('#c_pmmlDesc').val('');
		interfaceCodeUnChecked();
	 	$('#dataTitle').html("添加数据");
	 	$('#saveUpdateBtn').show(); 
	}	
}


/**
 * 上传文件界面
 */
function openUpload(data){
	$('#pmmlUpload').modal('show');
	$('#c_pmmlid').val(data.pmmlId);
	
	//清空file数据
	var file = $("#file") 
	file.after(file.clone().val("")); 
	file.remove(); 
	$('#c_versionDesc').val('');
}
/**
 * 上传PMML文件
 * @returns
 */

function upload(){
	if($("#pmmlDataFrom").valid()){
		var formData = new FormData($('#pmmlDataFrom')[0]); 
		$.ajax({ 
	        type:'post', 
	        url:root+'/pmml_upload.do', 
	        data:formData,
	        contentType: false, //不设置内容类型
	        async: false,  
			cache: false, 
			processData: false, 
			success:function(data){
				if(data.success == true){
		            alert("上传成功！");       //弹出成功
		            parent.$('#pmmlUpload').modal('hide');
		        }else{
		        	if(data.status == 0){
		        		alert("上传被拒绝：文件内容为空！");  		//弹出失败
		        	}else{
		        		alert("上传失败！");  		//弹出失败
		        	}
		        }
		    },
		         error:function(data){
		            alert("上传失败!");        
		    }
	   });
		doSearch();
	}
}
/**
 * 提交新增和修改信息
 * @param el
 * @param method
 */
var iscleck=null;
function saveOrUpdate(){
	if($("#dataFrom").valid()&&iscleck){
		if(!verify()){
			return;
		}else{
			iscleck=false;
			var data = $('#dataFrom').serialize();
			$.ajax({ 
		         type:'post', 
		         url:root+'/pmml_save.do', 
		         data:data, 
		         async:false,
		         success:function(msg){
		            if(msg==''){
		                alert("保存成功！");        //弹出成功msg
		                //刷新表格数据
		                doSearch();
		                parent.$('#dataModal').modal('hide');
		            }else{
		                alert("接口请求出现错误:"+msg);  //弹出失败msg
		            }
		         },
		         error:function(msg){
		            alert("访问服务器出错");        
		         }
		    });
			doSearch();
		}
	}
}

/**
 * 发布PMML文件
 * @returns
 */
function release(){
	var ids=$('#pmmlFile-table').jqGrid('getGridParam','selarrrow');
	if(ids.length==0){
		alert("请选择需要发布的文件！");
	}else if(ids.length==1){
		var rowData = $("#pmmlFile-table").jqGrid('getRowData',ids[0]);
		var pmmlFileId = rowData.pmmlFileId;
		$.ajax({ 
	        type:'post', 
	        url:root+'/pmml_file_update.do', 
	        data:{pmmlFileId:pmmlFileId},
			success:function(data){
				if(data.success == true){
		            alert("发布成功！");       //弹出成功
		        }else{
		        	alert("发布失败！");  		//弹出失败
		        }
		    },
		         error:function(data){
		        	alert("发布失败！");  		//弹出失败        
		    }
	   });
	    parent.$('#pmmlFile').modal('hide');
	}else{
		alert("只能发布一个文件！");
	}

}


function queryInterfaceInfo() {
	var html = "";
	$.ajax({
				type : "post",
				url : root + '/query_event_interface.do',
				success : function(data) {
					var a = 3;
					$.each(data,function(i, v) {
										if (a % 3 == 0) {
											html += "<tr>";
										}
										html += "<td>";
										html += "<input type='checkbox' name='iCode' style='vertical-align: top;' onclick='getInterfaceCode()' value='"
												+ v.interfaceCode
												+ "'>"
												+ v.interfaceName
												+ "&nbsp;&nbsp;&nbsp;&nbsp;"
										html += "</td>";
										if (a % 3 == 2) {
											html += "</tr>";
										}
										a++;
									})
					$("#c_iCode").append(html);
				}
			});

}
$(document).ready(function() {

	// 加载数据源
	queryInterfaceInfo()

});

//给数据源赋值
function interfaceCodeChecked(interfaceCode) {
	if (interfaceCode != null && interfaceCode != "") {
		var Code = interfaceCode.split(",");
		$.each(Code, function(i, item) {
			$("input[name='iCode'][value=" + item + "]").prop("checked", true);
		});
	}
}
// 去除数据源的值
function interfaceCodeUnChecked() {
	$.each($('input[name=iCode]:checked'), function() {
		$(this).prop("checked", false);
	});
}

function getInterfaceCode() {
	var interfaceCode = "";
	$.each($('input[name=iCode]:checked'), function() {
		interfaceCode += $(this).val() + ",";
	});
	if (interfaceCode.length > 0) {
		interfaceCode = interfaceCode.substring(0, interfaceCode.length - 1);
	}
	$("#c_interfaceCode").val(interfaceCode);
}
/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
	$('#'+modalId).hide();
}
var validator = null;
$(document).ready(function() {
	validator = $("#dataFrom").validate({
		rules : {
			pmmlCode : {
				required : true,
				codestr : true,
				rangelength : [ 0, 32 ]
			},
			pmmlName : {
				required : true,
				rangelength : [ 0, 50 ]
			},
			pmmlDesc: {
				rangelength : [ 0, 200 ]
			},
			status : {
				required : true
			}
		},
		focusCleanup : true
	});
});

var validator2 = null;
$(document).ready(function() {
	validator2 = $("#pmmlDataFrom").validate({
		rules : {
			file : {
				required : true,
				accept : "pmml"
			}
		},
		focusCleanup : true
	});
});

//校验PMML编码是否重复
function repeatPmmlCode() {
	var pmmlCode = $('#c_pmmlCode').val();
	if(pmmlCode != null){
		$.ajax({
			type : "post",
			url : root + '/repeat_pmml_code.do',
			data : {
				"pmmlCode" : pmmlCode
			},
			async:false,
			dataType : "json",
			success : function(data) {
				if (data.success) {
					//alert("决策点名称已存在，请重新输入！");
					$("#d_pmmlCode").show();
					$('#c_pmmlCode').focus();
				}else{
					$("#d_pmmlCode").hide();
				}
			},
			error : function() {
				alert("操作失败");
			}
		});
	}
}

//校验PMML是否重复
function repeatPmmlName () {
	var pmmlName = $('#c_pmmlName').val();
	if(pmmlName != null){
		$.ajax({
			type : "post",
			url : root + '/repeat_pmml_name.do',
			data : {
				"pmmlName" : pmmlName
			},
			dataType : "json",
			async:false, 
			success : function(data) {
				if (data.success) {
					//alert("决策点名称已存在，请重新输入！");
					$("#d_pmmlName").show();
					$('#c_pmmlName').focus();
				}else{
					$("#d_pmmlName").hide();
				}
			},
			error : function() {
				alert("操作失败");
			}
		});
	}
}

//校验
function verify() {
	
	var str = true
	if($('#c_option').val()== "add"){
		repeatPmmlName();
		repeatPmmlCode();
		 
		$.each($('label[name=error]'), function() {
			if(!$(this).is(":hidden")) {
				str= false;
			}
		});
	}
	return str;
}
