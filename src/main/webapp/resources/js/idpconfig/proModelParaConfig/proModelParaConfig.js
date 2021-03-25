/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
   var tool = [ 
			{ text: '新增参数配置' , iconCls: 'fa fa-plus', handler: function () {
					openModalWin('add');
				}
			}, '-',
			{ text: '查看参数配置' , iconCls: 'fa fa-search', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('view',rowData);
				}else{
					alert("请选择一条记录！");
				}
			   
				}
			},'-',
			{ text: '修改参数配置' , iconCls: 'fa fa-edit', handler: function () {
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
		colNames:[ '唯一标识ID','模型表ID','字段表ID','模型名称','模型编码','参数字段','参数名称中文','参数类型','是否校验','校验方法','创建人','创建时间','修改人','修改时间','状态' ],
		colModel:[
					{
						sortable:false,
						name : 'id',
						index : 'id',
						width : 100,
						hidden : true
					},{
						sortable:false,
						name : 'modelid',
						index : 'modelid',
						width : 100,
						hidden: true
					},{
						sortable:false,
						name : 'fieldid',
						index : 'fieldid',
						width : 100,
						hidden: true
					},{
						sortable:false,
						name : 'modelname',
						index : 'modelname',
						width : 120
					},{
						sortable:false,
						name : 'modelcode',
						index : 'modelcode',
						width : 120
					}, {
						sortable:false,
						name : 'parameterfields',
						index : 'parameterfields',
						width : 180
					},{
						sortable:false,
						name : 'parameternamech',
						index : 'parameternamech',
						width : 180
					},{
						sortable:false,
						name : 'parametertype',
						index : 'parametertype',
						width : 100,
						hidden: true
					},{
						sortable:false,
						name : 'ischeckout',
						index : 'ischeckout',
						width : 100,
						hidden: true,
						formatter: "select",
						editoptions:{value:"0:是;1:否"}
					}, {
						sortable:false,
						name : 'checkoutway',
						index : 'checkoutway',
						width : 150,
						hidden: true
					}, 
					{
						sortable:false,
						name : 'createuser',
						index : 'createuser',
						width : 100,
						hidden: true
					},{
						sortable:false,
						name : 'createtime',
						index : 'createtime',
						width : 160,
					},{
						sortable:false,
						name : 'updateuser',
						index : 'updateuser',
						width : 100
					},{
						sortable:false,
						name : 'updatetime',
						index : 'updatetime',
						width : 160
					},{
						sortable:false,
						name : 'status',
						index : 'status',
						width : 100,
						formatter: "select",
						editoptions:{value:"0:有效;1:无效;"}
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

		caption: "参数校验配置",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/proModelPara_Config_query.do',
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
//	var productCode = $("#searchProductCode").val();
//	var productName = $("#searchProductName").val();
	var modelCode = $("#searchModelCode").val();
	var modelName = $("#searchModelName").val();
	
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
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
	//textareaDeal();
	$('#tr_createuser').attr("hidden","true");
 	$('#tr_updateuser').attr("hidden","true");
 	$('#tr_createtime').attr("hidden","true");
 	$('#tr_updatetime').attr("hidden","true");
	if(type=="view"){
		$('#c_option').val("view");
		$('#c_id').val(data.id).attr("readOnly","readOnly");
		$('#c_modelid').val(data.modelid);
//		$("#c_orgname").html("<option value='"+data.orgno+"'>"+data.orgname+"</option>").attr("disabled","disabled");//给机构名称赋值
//		$('#v_orgname').val(data.orgno);
//		$('#c_productid').val(data.productid);
//		$('#c_productCode').val(data.productcode).attr("readOnly","readOnly");
//		$('#v_productCode').val(data.productname).attr("readOnly","readOnly");
		$('#c_modelCode').val(data.modelcode).attr("readOnly","readOnly");
	 	$('#v_modelCode').val(data.modelname).attr("readOnly","readOnly");
	 	$('#c_createuser').val(data.createuser).attr("readOnly","readOnly");
	 	$('#c_updateuser').val(data.updateuser).attr("readOnly","readOnly");
	 	$('#c_createtime').val(data.createtime).attr("readOnly","readOnly");
	 	$('#c_updatetime').val(data.updatetime).attr("readOnly","readOnly");
	 	$('#tr_createtime').removeAttr("hidden");
	 	$('#tr_createuser').removeAttr("hidden");
	 	$('#c_status').val(data.status).attr("disabled","disabled");
	 	$("#selectAll").attr("disabled",true);
		$('#dataTitle').html("查看模型【"+data.modelname+"】的参数校验");
		queryDataByModelId(data.modelid,type);
	}else if(type=="update"){
		$('#c_option').val("update");
		$('#c_id').val(data.id).attr("readOnly","readOnly");
		$('#c_modelid').val(data.modelid);
//		$("#c_orgname").html("<option value='"+data.orgno+"'>"+data.orgname+"</option>").attr("disabled","disabled");//给机构名称赋值
//		$('#v_orgname').val(data.orgno);
//		$('#c_productid').val(data.productid);
//	 	$('#c_productCode').val(data.productcode).attr("readOnly","readOnly");
//	 	$('#v_productCode').val(data.productname).attr("readOnly","readOnly");
	 	$('#c_modelCode').val(data.modelcode).attr("readOnly","readOnly");
	 	$('#v_modelCode').val(data.modelname).attr("readOnly","readOnly");
	 	$('#c_createuser').val(data.createuser).attr("readOnly","readOnly");
	 	$('#c_updateuser').val(data.updateuser).attr("readOnly","readOnly");
	 	$('#c_createtime').val(data.createtime).attr("readOnly","readOnly");
	 	$('#c_updatetime').val(data.updatetime).attr("readOnly","readOnly");
	 	$('#c_status').val(data.status).attr("disabled",false);
	 	$("#selectAll").attr("disabled",false);
		$('#dataTitle').html("修改模型【"+data.modelname+"】的参数校验配置");
		queryDataByModelId(data.modelid,type);    //查询选中模型下已配置的字段id
		$('#saveUpdateBtn').show();
		iscleck=true;   //控制重复提交
	}else if(type=="add"){
		$('#c_option').val("add");
		$('#c_id').val("");
		$('#c_modelid').val("");
//		$('#c_productid').val("");
		$('#c_field').val("");
//		$('#v_productCode').val("");
		$('#v_modelCode').val('');
//		$('#c_productCode').removeAttr("readOnly");
//		$('#v_productCode').removeAttr("readOnly");
		$('#c_modelCode').removeAttr("readOnly");
		$('#v_modelCode').removeAttr("readOnly");
		$("#selectAll").attr("disabled",false);
		$('#c_status').val("0").attr("disabled",false);
		disabledclose();
		$('#dataTitle').html("参数校验配置新增");  
		$('#saveUpdateBtn').show(); 
//		queryOrgNoInfo();        //加载机构信息
//		$('#c_orgname option:first').prop('selected', 'selected');
//		getProductInfoByorgNo(); //加载产品信息
//		$('#c_productCode option:first').prop('selected', 'selected');
		loadModelInfo(); //加载模型信息
		$('#c_modelCode option:first').prop('selected', 'selected');
		queryInterfaceInfo(type);
		iscleck=true;   //控制重复提交
	}  
}

//不可操作关闭
function disabledclose(){
//	$('#c_id').attr("disabled",false);
//	$('#c_modelid').attr("disabled",false);
//	$('#c_field').attr("disabled",false);
//	$('#c_orgname').attr("disabled",false);
//	$('#c_productCode').attr("disabled",false);
// 	$('#v_productCode').attr("disabled",false);
 	$('#c_modelCode').attr("disabled",false);
 	$('#v_modelCode').attr("disabled",false);
 	$('#c_status').attr("disabled",false);
 	$('#c_createuser').attr("disabled",false);
 	$('#c_updateuser').attr("disabled",false);
 	$('#c_createtime').attr("disabled",false);
 	$('#c_updatetime').attr("disabled",false);
}

//不可操作开启
function disabledopen(){
//	$('#c_id').attr("disabled",true);
//	$('#c_modelid').attr("disabled",true);
//	$('#c_field').attr("disabled",true);
//	$('#c_orgname').attr("disabled",true);
//	$('#c_productCode').attr("disabled",true);
// 	$('#v_productCode').attr("disabled",true);
 	$('#c_modelCode').attr("disabled",true);
 	$('#v_modelCode').attr("disabled",true);
 	$('#c_status').attr("disabled",true);
 	$('#c_createuser').attr("disabled",true);
 	$('#c_updateuser').attr("disabled",true);
 	$('#c_createtime').attr("disabled",true);
 	$('#c_updatetime').attr("disabled",true);
}

/**
 * 接收返回信息
 * @param el
 * @param method
 */

var iscleck=null;   //控制重复提交
function saveOrUpdate(){
	
	//在模型与字段页面操作
	if($("#dataFrom").valid()&&iscleck){
		iscleck=false;
		var type = $("#c_option").val();
		var str = "";
		var falg = true;
		var isChecked = false;
		if(type == "add"){            //新增模型字段信息
			//1、获取所有字段的复选框
			var params = document.getElementsByName("modelToPram");
			//2、哪些字段的复选框处于选中状态
			for(var i = 0;i < params.length;i++){
				var strT = "";
				if(params[i].checked==true){
					isChecked = true;
					//3、获取字段信息，并组装
					var fieldid = $("#c_fieldid"+i).val();        					        //字段id
					var ischeckout = $("#c_ischeckout"+i+" option:selected").val();         //是否校验 0-是，1-否
					var checkoutMothed = $("#c_checkoutway"+i+" option:selected").val();    //校验方法
					var checkoutWay = $("#c_checkoutway"+i+" option:selected").text();     	//校验方式（中文）
					if(ischeckout!="undefined"&&ischeckout=='0'&&(checkoutWay==null||checkoutWay=="undefined"||""==checkoutWay)){
						alert("是否校验='是',校验方法不能为空！");
						return false;
					}
					if(falg)
						strT = '"fieldid":"'+fieldid+'","ischeckout":"'+ischeckout+'","checkoutMothed":"'+checkoutMothed+'","checkoutWay":"'+checkoutWay+'"';
					if(!falg)
						strT = '#"fieldid":"'+fieldid+'","ischeckout":"'+ischeckout+'","checkoutMothed":"'+checkoutMothed+'","checkoutWay":"'+checkoutWay+'"';
					falg = false;
				}
				str = str+strT;
			}
			if(!isChecked)
				alert("请至少选中一个字段参数，再点击确定！");
			if(isChecked){
				//var modelid = $("#c_modelid").val();           //获取模型id
//				var productCode = $("#c_productCode").val();	 //获取产品Code
				var modelCode = $("#c_modelCode").val();
				var id = $("#c_id").val();
				var status = $("#c_status").val();
				$.ajax({ 
			         type:'post',
			         url:root+'/'+"proModelPara_Config_add.do", 
			         data:{"option":type,"modelCode":modelCode,"id":id,'status':status,"data":str}, 
			         dataType: "json",
			         async:false,
			         success:function(msg){
			            if(msg.isPass==true){
			                alert("保存成功！");        //弹出成功msg
			                //刷新表格数据
			                parent.$('#dataModal').modal('hide');
			                doSearch();
			            }else if(msg.isExist=="YES"){
			            	alert("该产品模型已配置参数，请重新选择模型！");
			            }else{
			                alert("保存失败:"+msg);  //弹出失败msg
			            }
			         },
			         error:function(msg){
			            alert("访问服务器出错");        
			         }
			    });
			}
		}else if(type == "update"){   //修改模型自段信息
			//1、获取所有字段的复选框
			var params = document.getElementsByName("modelToPram");
			//2、哪些字段的复选框处于选中状态
			for(var i = 0;i < params.length;i++){
				var strT = "";
				if(params[i].checked==true){
					//3、获取字段信息，并组装
					var fieldid = $("#c_fieldid"+i).val();        					        //字段id
					var ischeckout = $("#c_ischeckout"+i+" option:selected").val();         //是否校验 0-是，1-否
					var checkoutMothed = $("#c_checkoutway"+i+" option:selected").val();    //校验方法
					var checkoutWay = $("#c_checkoutway"+i+" option:selected").text();     	//校验方式（中文）
					if(ischeckout!="undefined"&&ischeckout=='0'&&(checkoutWay==null||checkoutWay=="undefined"||""==checkoutWay)){
						alert("是否校验='是',校验方法不能为空！！");
						return false;
					}
					if(falg)
						strT = '"fieldid":"'+fieldid+'","ischeckout":"'+ischeckout+'","checkoutMothed":"'+checkoutMothed+'","checkoutWay":"'+checkoutWay+'"';
					if(!falg)
						strT = '#"fieldid":"'+fieldid+'","ischeckout":"'+ischeckout+'","checkoutMothed":"'+checkoutMothed+'","checkoutWay":"'+checkoutWay+'"';
					falg = false;
				}
				str = str+strT;
			}
			var modelid = $("#c_modelid").val();           //获取模型id
//			var productCode = $("#c_productCode").val();	 //获取产品Code
			var modelCode = $("#c_modelCode").val();
			var id = $("#c_id").val();
			var status = $("#c_status").val();
			var createuser =$('#c_createuser').val();
			var createtime =$('#c_createtime').val();

			$.ajax({ 
		         type:'post',
		         url:root+'/'+"proModelPara_Config_update.do", 
		         data:{"option":type,"modelCode":modelCode,"id":id,'modelid':modelid,'status':status,'createuser':createuser,'createtime':createtime,"data":str,"fieldIdStr":fieldIdStr.toString()}, 
		         dataType: "json",
		         async:false,
		         success:function(msg){
		            if(msg.isPass==true){
		                alert("保存成功！");        //弹出成功msg
		                //刷新表格数据
		                doSearch();
		                parent.$('#dataModal').modal('hide');
		            }else{
		                alert("保存失败:"+msg);  //弹出失败msg
		            }
		         },
		         error:function(msg){
		            alert("访问服务器出错");        
		         }
		    });
		}
	}
	
}

var validator=null;
$(document).ready(function(){
	validator=$("#dataFrom").validate({
		rules: {
			modelCode:{
				required:true,
				rangelength:[0,50]
			}	   
	    },focusCleanup:true
	});
});

function clearCheck(){
	validator.resetForm();
	$('input').removeClass("valid");
	$('select').removeClass("valid");
	$('textarea').removeClass("valid");
};

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
        async: false,
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

//当产品名称选定后，获取模型编码
function getModelInfoByProductCode() {
//	var orgno = $('#c_orgname').find("option:selected").val();
//	if(orgno==null||orgno==""){
//		alert("请先选中机构，在选中产品");
//	}else{
		var productCode = $('#c_productCode').find("option:selected").val();
		loadModelInfo(productCode);
//	}
}

//查询模型信息，并在模型下拉框中加载数据
function loadModelInfo(){
	var html='';
	$.ajax({
        type: "post",
        url: root+'/query_promodel_model.do',
        async: false,
        dataType: "json",
        success: function(data){
        	$.each(data,function(i,v){
        		html+="<option value='"+v.modelcode+"'>"+v.modelname+'</option>';
			});
			$("#c_modelCode").html(html);
        	$("#c_modelCode").change();
        },
        error: function () {  
        	alert("操作失败");  
        }
    });
}

//根据模型id获取模型下的字段信息
var fieldidExisitFieldList = new Array();     //字段id
var isCheckoutList = new Array();             //是否校验
var checkoutmothedList = new Array();         //校验方式
var fieldIdStr =new Array();                  //拼接fieldid

function queryDataByModelId(model,typeOption){
	fieldidExisitFieldList=[];
	isCheckoutList=[];
	checkoutmothedList=[];
	fieldIdStr=[];
	var modelid = model;
	$.ajax({
        type: "post",
        url: root+'/query_paraByModelId_para.do',
        data:{"modelid":modelid},
        success: function(data){
        	if(data.msg=="fail"){
        		alert("模型加载失败:"+data.msg);  //弹出失败msg
            }else{
            	//循环模型已经配置的字段
            	var fieldid=null;
            	var ischeckout =null;
        		var checkoutmothed =null;
//        		var productcode = null;
//        		var productname = null;
        		var modelcode = null;
        		var modelname = null;
        		var html =null;
        		var htmlModel =null;
            	$.each(data,function(i,v){
            		fieldid = v.fieldid;
            		ischeckout = v.ischeckout;
            		checkoutmothed = v.checkoutmothed;
            		fieldidExisitFieldList.push(fieldid);
            		isCheckoutList.push(ischeckout);
            		if(checkoutmothed==null||"undefined"==checkoutmothed||""==checkoutmothed){
            			checkoutmothed ="non";
            		}
            		checkoutmothedList.push(checkoutmothed);
//            		productcode = v.productcode;
//            		productname = v.productname;
            		modelcode = v.modelcode;
            		modelname = v.modelname;
            		fieldIdStr.push(v.fieldid);
            		
            	});
            	//给产品和模型下拉框赋值
//            	html+="<option selected='selected' value='"+productcode+"'>"+productname+'</option>';
            	htmlModel+="<option selected='selected' value='"+modelcode+"'>"+modelname+'</option>';
//            	$("#c_productCode").html(html);
            	$("#c_modelCode").html(htmlModel);
            	
            	//加载参数表所有参数一一匹配以展示
            	queryInterfaceInfo(typeOption);
            }
        }
    });
}

//加载新增参数来源
function queryInterfaceInfo(type){
	var html="";
	$.ajax({
        type: "post",
        url: root+'/query_promodelpara_para.do',
        success: function(data){
        	$.each(data,function(i,v){
        		//根据模型下的fieldid来确定下拉框和复选框的状态
        		html+="<tr id='tr_box"+i+"'><td style='text-align:center;width:35px;'>"+"<input role='checkbox' type='checkbox' id='modelToPram"+i+"' name='modelToPram' value = '"+i+"' class='cbox checkbox'></td>"
    			+"<td style='display:none'>"+"<input readOnly=readOnly id='c_fieldid"+i+"' style='width: 35px; height: 30px;' name='fieldid' value='"+v.fieldid+"'/>"+"</td>"
    			+"<td>"+"<input readOnly=readOnly id='c_parameterfields"+i+"' style='width: 70px; height: 30px;' name='parameterfields' value='"+v.parameterfields+"'/>"+"</td>"
    			+"<td>"+"<input readOnly=readOnly id='c_parameternamech"+i+"' style='width: 70px; height: 30px;' name='parameternamech' value='"+v.parameternamech+"'/>"+"</td>"
    			+"<td><select id='c_ischeckout"+i+"' name = 'ischeckout' onchange = 'isCheck("+i+");' style='width: 60px; height: 30px;'>"+
    			"<option value='1'>否</option>"+
    			"<option value='0'>是</option></select></td>"
    			+"<td><select id='c_checkoutway"+i+"' name = 'checkoutway' style='width: 120px; height: 30px;' disabled='disabled'>"+
    			"<option value=''></option>"+
    			"<option value='checkoutIsEmpty'>非空校验</option>"+
    			"<option value='checkoutIdNumber'>身份证号合法校验</option>"+
    			"<option value='checkoutTelNumber'>通信号码合法校验</option>"
    			+"</tr>";
        	});
        	$("#tbody").html(html);
        	modelHasHitField(type);
        }
    });
}

//获取模型下的已配字段信息
function modelHasHitField(type){
	if((type == "update")||(type =='view')){
		var checkoutways = document.getElementsByName("fieldid");//获取下拉框中的所有option
		for(var i=0;i<checkoutways.length;i++){
			if(type =='view'){
				$("#tr_box"+i).attr("hidden",true);
				$("#c_ischeckout"+i).attr("disabled",true);
				$("#modelToPram"+i).attr("disabled",true);
			}
			var val = checkoutways[i].value;    //获取当前元素value
			//var id = checkoutways[i].id.substr(9);    //获取当前元素id的系号
			var fieldList = new Array();
			fieldList = fieldidExisitFieldList.toLocaleString().split(",");
			for(var j=0;j<fieldList.length;j++){
				var fieldid = fieldList[j];
				var isCheckout = isCheckoutList.toLocaleString().split(",")[j];
				var checkoutmothed = checkoutmothedList.toLocaleString().split(",")[j];
				if(val == fieldid){
					//根据id找元素
					document.getElementById("modelToPram"+i).setAttribute("checked","true");
					$("#c_ischeckout"+i+" option").each(function(k){
						if(isCheckout == this.value)
							this.setAttribute("selected","true");
					});
					$("#c_checkoutway"+i+" option").each(function(k){
						if(checkoutmothed == this.value){
							this.setAttribute("selected","true");
						}	
					});
					if(type =='update'&&isCheckout=='0'){
						$("#c_checkoutway"+i).attr("disabled",false);
					}
					if(type =='view'){
						$("#tr_box"+i).attr("hidden",false);
					}
					break;
				}
			}
		}
		
	}
}

//在是否校验点击"否"时，校验方法下拉框中的值为空
function isCheck(a){
	var ischeckoutId = "c_ischeckout"+a;      //是否校验下拉框的id
	var ischeckoutValue = $("#"+ischeckoutId+" option:selected").val();
	if("1" == ischeckoutValue){
		var chekoutwayId = "c_checkoutway"+a;	  //校验方式下拉框的id
		var checkoutways = document.getElementById(chekoutwayId);   //获取下拉框中的所有option
		//找到已选中状态option
		$("#"+chekoutwayId+" option:selected").removeAttr("selected"); //获取选中的项,并删除option的选中状态
		checkoutways.options[0].setAttribute("selected","true");
		$("#"+chekoutwayId).attr("disabled","disabled").css("background-color","#EEEEEE;");
	}
	
	if("0" == ischeckoutValue){
		var chekoutwayId = "c_checkoutway"+a;	  //校验方式下拉框的id
		$("#"+chekoutwayId).attr("disabled",false).css("background-color","#EEEEEE;");
		if(undefined==$("#"+chekoutwayId).val()||""==$("#"+chekoutwayId).val()){
			$("#"+chekoutwayId).focus();
		}
	}
}

$(document).ready(function() {
    $("#selectAll").change(function() {
        var checkboxs = $("#tbody").find("input[type='checkbox']");
        var isChecked = $(this).is(":checked");
        //严禁使用foreach，jq对象的遍历会使浏览器崩溃
        for(var i = 0; i < checkboxs.length; i++) {
            //临时变量，必须，否则只能选中最后一条记录
            var temp = i;
            $(checkboxs[temp]).prop("checked",isChecked);
       }
    });
    
});

/**
 * 
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
