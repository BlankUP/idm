var isExist1 = true;
var isExist2 = true;

var falg = 0;  //定义一个开关，确保每次触发onblur方法后能执行完，在执行saveOrUpdate方法（保存）
/**
 * 需要同步的全局变量数据
 */
var syncdata = null;

/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
   var tool = [
			{ text: '添加模型' , iconCls: 'fa fa-plus', handler: function () {
					openModalWin('add');
				}
			}, '-',
			{ text: '查看模型' , iconCls: 'fa fa-search', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('view',rowData);
				}else{
					alert("请选择一条记录！");
				}
			   
				}
			}, '-',
			{ text: '修改模型' , iconCls: 'fa fa-edit', handler: function () {
					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
					if(ids.length==1){
						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
						openModalWin('update',rowData);
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
		colNames:[ '模型表ID','模型名称','模型编码','决策系统编码', '决策系统','模型类型','PMML编码','PMML名称','创建人','创建时间','修改人','修改时间','状态' ],
		colModel:[
					{
						sortable:false,
						name : 'modelid',
						index : 'modelid',
						width : 200,
						hidden :true
					},{
						sortable:false,
						name : 'modelname',
						index : 'modelname',
						width : 200
					},{
						sortable:false,
						name : 'modelcode',
						index : 'modelcode',
						width : 200
					},{
						hidden : true,
						sortable : false,
						name : 'respSystemCode',
						index : 'respSystemCode',
						width : 80

					}, {
						sortable : false,
						name : 'respSystemName',
						index : 'respSystemName',
						width : 80

					},{
						sortable:false,
						name : 'modeltype',
						index : 'modeltype',
						width : 150,
						formatter: "select",
						editoptions:{value:"1:决策模型;2:PMML模型"}
					},{
						sortable:false,
						name : 'pmmlcode',
						index : 'pmmlcode',
						width : 200,
						hidden: true
					},{
						sortable:false,
						name : 'pmmlname',
						index : 'pmmlname',
						width : 200,
						hidden: true
					},{
						sortable:false,
						name : 'createuser',
						index : 'createuser',
						width : 200,
						hidden:true
					},{
						sortable:false,
						name : 'createtime',
						index : 'createtime',
						width : 200
					},{
						sortable:false,
						name : 'updateuser',
						index : 'updateuser',
						width : 200,
						hidden:true
					},{
						sortable:false,
						name : 'updatetime',
						index : 'updatetime',
						width : 200
					},{
						sortable:false,
						name : 'status',
						index : 'status',
						width : 100,
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

		caption: "模型信息管理",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/proModel_Config_query.do',
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

//“查询”按钮
function doSearch(){
//	var orgNo = $("#searchOrgNo").val().trim();
//	var orgName = $("#searchOrgName").val().trim();
//	var productCode = $("#searchProductCode").val().trim();
//	var productName = $("#searchProductName").val().trim();
	var modelCode = $("#searchModelCode").val().trim();
	var modelName = $("#searchModelName").val().trim();
	
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/proModel_Config_query.do?modelCode='+modelCode+'&modelName='+modelName,
	    postData:{modelCode:modelCode,modelName:modelName},
	    datatype : "json"
	}).trigger("reloadGrid");
};

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
	$("#d_modelcode").hide();
	$("#d_modelname").hide();
	$('#tr_createuser').attr("hidden",true);
 	$('#tr_updateuser').attr("hidden",true);
 	$('#tr_createtime').attr("hidden",true);
 	$('#tr_updatetime').attr("hidden",true);
	if(type=="view"){
		$('#c_option').val("view");
		$('#c_modelid').val(data.modelid);
//		$("#c_orgname").html("<option value='"+data.orgno+"'>"+data.orgname+"</option>").attr("disabled","disabled");//给机构名称赋值
//		$('#v_orgname').val(data.orgno);
//		$('#c_productid').val(data.productid);
//		setProductInfo(data.productcode,data.productname);                        //给产品名称赋值
//		$('#c_productCode').attr("disabled","disabled");
//		$('#v_productCode').val(data.productname);
		$('#c_respSystemCode').val(data.respSystemCode);
		$('#v_respSystemCode').val(data.respSystemName);
		$('#c_modelcode').val(data.modelcode).attr("disabled","disabled");
	 	$('#c_modelname').val(data.modelname).attr("disabled","disabled");
		$('#c_modelType').val(data.modeltype).attr("disabled","disabled");
		setPmmlCode(data.pmmlcode,data.pmmlname);
		if(data.modeltype!=undefined&&data.modeltype=='2'){
			$('#tr_pmml').attr("hidden",false);
		}
		if(data.modeltype!=undefined&&data.modeltype=='1'){
			$('#tr_pmml').attr("hidden",true);
		}
		$('#c_pmmlCode').attr("disabled","disabled");
		$('#c_createuser').val(data.createuser).attr("disabled","disabled");
	 	$('#c_updateuser').val(data.updateuser).attr("disabled","disabled");
	 	$('#c_createtime').val(data.createtime).attr("disabled","disabled");
	 	$('#c_updatetime').val(data.updatetime).attr("disabled","disabled");
		$('#c_respSystemCode').val(data.modeltype).attr("disabled","disabled");
		$('#v_respSystemCode').val(data.modeltype).attr("disabled","disabled");
	 	$('#tr_createuser').removeAttr("hidden");
	 	$('#tr_updateuser').removeAttr("hidden");
	 	$('#tr_createtime').removeAttr("hidden");
	 	$('#tr_updatetime').removeAttr("hidden");
	 	$('#c_status').val(data.status).attr("disabled","disabled");
		$('#dataTitle').html("查看模型【"+data.modelname+"】");
	}else if(type=="update"){
		$('#c_option').val("update");
		$('#c_modelid').val(data.modelid);
//		$("#c_orgname").html("<option value='"+data.orgno+"'>"+data.orgname+"</option>").attr("disabled","disabled");//给机构名称赋值
//		$('#v_orgname').val(data.orgno);
//		setProductInfo(data.productcode,data.productname);                       //给产品名称赋值
//		$('#c_productid').val(data.productid);
//	 	$('#c_productCode').attr("disabled","disabled");
//	 	$('#v_productCode').val(data.productname);
		$('#c_respSystemCode').val(data.respSystemCode);
		$('#v_respSystemCode').val(data.respSystemName);
		$('#c_respSystemCode').val(data.modeltype).attr("disabled","disabled");
		$('#v_respSystemCode').val(data.modeltype).attr("disabled","disabled");
	 	$('#c_modelcode').val(data.modelcode).attr("disabled","disabled");
	 	$('#c_modelname').val(data.modelname).attr("disabled","disabled");
		$('#c_modelType').val(data.modeltype).attr("disabled","disabled");
		$('#c_pmmlCode').val(data.pmmlcode).attr("disabled",true);
		$('#v_pmmlCode').val(data.pmmlname).attr("disabled",true);
		setPmmlCode(data.pmmlcode,data.pmmlname);
		if(data.modeltype!=undefined&&data.modeltype=='2'){
			$('#tr_pmml').attr("hidden",false);
		}
		if(data.modeltype!=undefined&&data.modeltype=='1'){
			$('#tr_pmml').attr("hidden",true);
		}
	 	$('#c_createuser').val(data.createuser);
	 	$('#c_createtime').val(data.createtime);
	 	$('#c_status').val(data.status).attr("disabled",false);
		$('#dataTitle').html("修改模型【"+data.modelname+"】");
		$('#saveUpdateBtn').show();  
		iscleck=true;
	}else if(type=="add"){
		$('#c_option').val("add");
		$('#c_modelid').val("");
//		$('#c_productid').val("");
//		$('#v_productCode').val("");
		$('#c_modelname').val("");
		$('#c_modelType').val("1").attr("disabled",false);
		$('#v_modelType').val("");
		$('#v_pmmlCode').val("");
		$('#c_pmmlCode').attr('disabled',false);
		$('#tr_pmml').attr("hidden",true);
		$('#c_productCode').removeAttr("readOnly");
		$('#v_productCode').removeAttr("readOnly");
		$('#c_modelCode').removeAttr("readOnly");
		$('#v_modelCode').removeAttr("readOnly");
		$('#c_status').val("0").attr('disabled',false);
		$('#c_respSystemCode option:first').prop('selected', 'selected');
		$('#c_respSystemCode').change();
		
		disabledclose();
		$('#dataTitle').html("新增模型");
		$('#saveUpdateBtn').show();
//		queryOrgNoInfo();        //加载机构信息
//		$('#c_orgname option:first').prop('selected', 'selected');
//		getProductInfoByorgNo(); //加载产品信息
//		$('#c_productCode option:first').prop('selected', 'selected');
		makeModelCode();       //生成模型编码
//		$('#c_modelcode').attr("disabled","disabled");   //设置模型编码文本框处于不可操作状态
		queryPmmlModel();        //加载Pmml模板信息
		$('#c_pmmlCode option:first').prop('selected', 'selected');
		isExist1 = true; //自动生成的模型编码一定不会重复，所以设置isExist1值为false
	    iscleck=true;   //控制重复提交
	} 
}

//自动产生模型编码，并放到模型编码文本框里
function makeModelCode(){
	$.ajax({
        type: "post",
        url: root+'/proModel_make_modelCode.do',
        dataType:"json",
        success: function(data){
        	if(data.result=="success"){
        		var modelCode = data.modelCode;
        		$('#c_modelcode').val(modelCode);
        	}else{
        		alert("操作失败!");
        	}
        },
        error: function () {  
        	alert("操作失败!");  
        }
    });
}

//对不可操作文本框变成可操作
function disabledclose(){
	$('#c_modelid').attr("disabled",false);
//	$('#c_orgname').attr("disabled",false);
//	$('#c_productCode').attr("disabled",false);
// 	$('#v_productCode').attr("disabled",false);
 	$('#c_modelcode').attr("disabled",false);
 	$('#c_modelname').attr("disabled",false);
 	$('#c_respSystemCode').attr("disabled",false);
 	$('#v_respSystemCode').attr("disabled",false);
 	//$('#c_templateCode').attr("disabled",false);
 	//$('#v_templateName').attr("disabled",false);
 	$('#c_status').attr("disabled",false);
 	$('#c_createuser').attr("disabled",false);
 	$('#c_updateuser').attr("disabled",false);
 	$('#c_createtime').attr("disabled",false);
 	$('#c_updatetime').attr("disabled",false);
}

//对部分文本框变成不可操作
function disabledopen(){
	$('#c_modelid').attr("disabled",true);
//	$('#c_orgname').attr("disabled",true);
//	$('#c_productCode').attr("disabled",true);
//	$('#v_productCode').attr("disabled",true);
 	$('#c_modelcode').attr("disabled",true);
 	$('#c_modelname').attr("disabled",true);
 	$('#c_respSystemCode').attr("disabled",true);
 	$('#v_respSystemCode').attr("disabled",true);
 	//$('#c_templateCode').attr("disabled",true);
 	//$('#v_templateName').attr("disabled",true);
 	//$('#c_productCode').change();
 	$('#c_status').attr("disabled",true);
 	$('#c_createuser').attr("disabled",true );
 	$('#c_updateuser').attr("disabled",true);
 	$('#c_createtime').attr("disabled",true);
 	$('#c_updatetime').attr("disabled",true);
}

//当机构名称选定后，获取机构代码
function getProductInfoByorgNo() {
	var orgno = $('#c_orgname').find("option:selected").val();
	$("#v_orgname").val(orgno);
	loadProductInfo(orgno);
}

//查询产品信息，并在产品下拉框中加载数据
function loadProductInfo(orgno){
	var html='';
	$.ajax({
        type: "post",
        url: root+'/promodel_query_product.do',
        data:{"orgNo":orgno}, 
        dataType: "json",
        success: function(data){
        	if(data!=undefined){
        		$.each(data,function(i,v){
            		html+="<option value='"+v.productcode+"'>"+v.productname+"</option>";
            	});
    			$("#c_productCode").html(html);
    			$("#c_productCode").change();
        	}
        },
        error: function () {  
        	alert("操作失败");  
        }
    });
}

//校验
function verify() {
	
	var str = true;
	if($('#c_option').val()== "add"){
		checkModelCodeIsExists();
		checkModelNameIsExists();
		pmmlCodeInspect();
		$.each($('label[name=error]'), function() {
			if(!$(this).is(":hidden")) {
				str= false;
			}
		});
	}
	return str;
}

//校验模型编码是否重复
function checkModelCodeIsExists() {
	falg = false;              //触发onblur方法开始时，把falg的值设置为false
	$("#d_modelcode").hide();   //先把上次显示提示清除
	var modelcode = $('#c_modelcode').val().trim();
	$.ajax({
        type: "post",
        url: root+'/checkModel_isExist.do',
        data:{"modelcode":modelcode}, 
        dataType: "json",
        success: function(data){
        	if(data.isPass==false){
        		//alert("模型编码已存在，请重新输入！");
        		isExist1 = true;
        		$("#d_modelcode").show();
        		$('#c_modelcode').focus();
        	}
        	if(data.isPass==true){
        		isExist1 = false;
        	}
        	falg = true;       //触发onblur方法结束时，把falg的值设置为true
        },
        error: function () { 
        	falg = true;       //触发onblur方法结束时，把falg的值设置为true
        	alert("操作失败");  
        }
    });
}

//校验模型名称是否重复
function checkModelNameIsExists() {
	falg = 1;              //触发onblur方法开始时，把falg的值设置为1
	$("#d_modelname").hide();   //先把上次显示提示清除
	var modelname = $('#c_modelname').val().trim();
//	var orgno = $('#c_orgname option:selected').val();
	$.ajax({
        type: "post",
        url: root+'/checkModel_isExist.do',
        data:{"modelname":modelname}, 
        dataType: "json",
        success: function(data){
        	if(data.isPass==false){
        		//alert("模型名称已存在，请重新输入！");
        		$("#d_modelname").show();
        		$('#c_modelname').focus();
        		isExist2 =true;
        		falg = 0;       //触发onblur方法结束时，把falg的值设置为0
        	}
        	if(data.isPass==true){
        		$("#d_modelname").hide();
        		isExist2 = false;
        		falg = 0;       //触发onblur方法结束时，把falg的值设置为0
        	}
        },
        error: function () {  
        	alert("操作失败");  
        }
    });
};

//获取产品下的pmml模型
function changeType(){
	var modelType = $("#c_modelType  option:selected").val();
	if("2" == modelType){
		$("#tr_pmml").attr("hidden",false);
	}
	if("1" == modelType){
		$("#tr_pmml").attr("hidden",true);
	}
};

function sleep(numberMillis){
	var now = new Date();    
	var exitTime = now.getTime() + numberMillis;   
	while (true) { 
		now = new Date();       
		if (now.getTime() > exitTime) 
		return;    
	}
}
iscleck=null;
//进行保存或修改操作
function saveOrUpdate(){
//	while (falg != 0){//等待falg的值为0时，执行下面保存或修改操作
//		sleep(1000);
//	}
//	alert("falg="+falg);
//	if($("#dataFrom").valid()&&iscleck){
//		iscleck=false;
//		var option = $('#c_option').val();
//		if(option=="add"&&(isExist1||isExist2)){
//			alert("模型编码或名称已存在，请重新输入！");
//			return false;
//		}
//		var pmmlcode = $('#c_pmmlCode').val();
//		var modeltype = $('#c_modelType').val();
//		if(modeltype!=undefined&&modeltype=='2'&&(pmmlcode==undefined||pmmlcode==null||pmmlcode=="")){
//			alert("无PMML可关联，请先在PMML界面完成PMML新增或修改！");
//			$('#c_pmmlCode').focus();
//			return false;
//		}
		if(!verify()){
			return;
		}else{
			disabledclose();
			var data = $('#dataFrom').serialize();
			disabledopen();
			$.ajax({ 
		         type:'post', 
		         url:root+'/proModel_Config_save.do', 
		         data:data, 
		         async:false,
		         success:function(msg){
		            if(msg==''){
		                alert("保存成功！");        //弹出成功msg
		                doSearch();                //刷新表格数据
		                $('#dataModal').modal('hide');
		            }else{
		                alert("保存失败:"+msg);     //弹出失败msg
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
			//modelcode为自动生成，不需要加codestr校验
			modelcode:{
				required:true,
				rangelength:[0,50],
				codestr:true           
			},
			modelname:{
				required:true,
				rangelength:[0,100]
			},
			respSystemCode : {
				required : true
			},
			modelType:{
				required:true,
				rangelength:[0,2]
			}
	    },focusCleanup:true
	});
});

//去除文本框中长度限制提示
function clearCheck(){
	validator.resetForm();
	$('input').removeClass("valid");
	$('select').removeClass("valid");
	$('textarea').removeClass("valid");
}

//加载机构-查询机构信息
function queryOrgNoInfo(){
	var html="";
	$.ajax({
        type: "post",
        url: root+'/query_organization.do',
        async: false,
        success: function(data){
        	if(data!=undefined&&data.length>0){
        		$.each(data,function(i,v){
            		html+="<option value='"+v.orgNo+"'>"+v.orgName+"</option>";
            	});
    			$("#c_orgname").html(html);
        	}
        },
        error: function () {  
        	alert("操作失败");  
        }
    });
}

//根据productcode(产品编码),productname(产品名称)信息，加载到产品名称下拉框里
function setProductInfo(productcode,productname){
    html="<option value='"+productcode+"'>"+productname+"</option>";
	$("#c_productCode").html(html);
}

//根据pmmlcode(pmml编码),pmmlname(pmml名称)信息，加载到pmml名称下拉框里
function setPmmlCode(pmmlcode,pmmlname){
    html="<option value='"+pmmlcode+"'>"+pmmlname+"</option>";
	$("#c_pmmlCode").html(html);
}

function queryPmmlModel(){
	var html="";
	$.ajax({
        type: "post",
        url: root+'/query_pmml_model.do',
        success: function(data){
        	if(data!=null&&data!=""){
        		$.each(data,function(i,v){
            		html+="<option value='"+v.pmmlCode+"'>"+v.pmmlName+'</option>';
    			});
    			$("#c_pmmlCode").html(html);
            	$("#c_pmmlCode").change();
        	}if(data==null||data==""){
        		$("#c_pmmlCode").html(html);
        	}
        }, error: function () {  
        	alert("操作失败");  
        }
    });
}

/**
 * 关闭
 * @param modalId
 */
function closeBtn(modalId){
	$('#'+modalId).hide();
}

/**
 * 对table的大小随页面变化而变化
 */
$(function(){
    $(window).resize(function(){  
	 $("#grid-table").setGridWidth($(window).width());
	});
});



function pmmlCodeInspect(){
	var pmmlcode = $('#c_pmmlCode').val();
	var modeltype = $('#c_modelType').val();
	if(modeltype!=undefined&&modeltype=='2'&&(pmmlcode==undefined||pmmlcode==null||pmmlcode=="")){
		$("#d_pmmlCode").show();
		$('#c_pmmlCode').focus();
	}else{
		$("#d_pmmlCode").hide();
	}
}