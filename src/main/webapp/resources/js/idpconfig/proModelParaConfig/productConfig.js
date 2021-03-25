var isExist1 = true;
var isExist2 = true;

/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
   var tool = [   
//			{ text: '添加数据' , iconCls: 'fa fa-plus', handler: function () {
//					
//					openModalWin('add');
//				}
//			}, '-',
			{ text: '查看数据' , iconCls: 'fa fa-search', handler: function () {
				var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
				if(ids.length==1){
					var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
					openModalWin('view',rowData);
				}else{
					alert("请选择一条记录！");
					
				}
			   
				}
			}
//			, '-',
//			{ text: '修改数据' , iconCls: 'fa fa-edit', handler: function () {
//					var ids=$('#grid-table').jqGrid('getGridParam','selarrrow');
//					if(ids.length==1){
//						var rowData = $("#grid-table").jqGrid('getRowData',ids[0]);
//						openModalWin('update',rowData);
//					}else{
//						alert("请选择一条记录！");
//					}
//			   
//				}
//			}
			];
			


$(document).ready(function() {
	var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

	jQuery(grid_selector).jqGrid({
		datatype: "local",
		regional:'cn',
		height: "auto",
		colNames:[ '产品ID','产品名称','产品编码','产品详细信息','创建人','创建时间','修改人','修改时间','状态' ],
		colModel:[
			
					{
						sortable:false,
						name : 'productid',
						index : 'productid',
						width : 200,
						hidden: true
					},{
						sortable:false,
						name : 'productname',
						index : 'productname',
						width : 200
					},{
						sortable:false,
						name : 'productcode',
						index : 'productcode',
						width : 200
					},{
						sortable:false,
						name : 'productdes',
						index : 'productdes',
						width : 200
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
					},{
						sortable:false,
						name : 'updateuser',
						index : 'updateuser',
						width : 200
					},{
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
						editoptions:{value:"0:锁定;1:使用;2:停用"}
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

		caption: "产品信息管理",
		autowidth: true
	}).jqGrid('setGridParam', {
	    page : 1,
	    url:root+'/product_Config_query.do',
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
//	var orgNo = $("#searchOrgNo").val().trim();
//	var orgName = $("#searchOrgName").val().trim();
	var productCode = $("#searchProductCode").val().trim();
	var productName = $("#searchProductName").val().trim();
	$("#grid-table").jqGrid('setGridParam', {
	    page : 1,
	    postData:{productCode:productCode,productName:productName},
	    url:root+'/product_Config_query.do',
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
//	if(data!=undefined){
//		queryCorporste(data.productcode);
//	}else{
//		$("#org_name").empty();
//		$("#org_id").val('');
//	}
	$('#dataModal').modal('show');
	$('#saveUpdateBtn').hide();	
	$("#d_productcode").hide();
	$("#d_productname").hide();
	$('#tr_createuser').attr("hidden","true");
 	$('#tr_updateuser').attr("hidden","true");
 	$('#tr_createtime').attr("hidden","true");
 	$('#tr_updatetime').attr("hidden","true");
 	$('#tr_productid').attr("hidden","true");
	if(type=="view"){
		$('#c_option').val("view");
		$('#c_productid').val(data.productid).attr("disabled","disabled");
		$('#v_orgname').val(data.orgno);
//		$('#c_orgname').html("<option value='"+data.orgno+"'>"+data.orgname+"</option>").attr("disabled","disabled");
		$('#c_productcode').val(data.productcode).attr("disabled","disabled");
		$('#c_productname').val(data.productname).attr("disabled","disabled");
	 	$('#c_productdes').val(data.productdes).attr("disabled","disabled");
	 	$('#c_createuser').val(data.createuser).attr("disabled","disabled");
	 	$('#c_updateuser').val(data.updateuser).attr("disabled","disabled");
	 	$('#c_createtime').val(data.createtime).attr("disabled","disabled");
	 	$('#c_updatetime').val(data.updatetime).attr("disabled","disabled");
	 	$('#c_status').val(data.status).attr("disabled","disabled");
	 	$('#tr_createuser').removeAttr("hidden");
	 	$('#tr_updateuser').removeAttr("hidden");
	 	$('#tr_createtime').removeAttr("hidden");
	 	$('#tr_updatetime').removeAttr("hidden");
		$('#dataTitle').html("查看数据【"+data.productname+"】");
	}else if(type=="update"){
		$('#c_option').val("update");
		$('#c_productid').val(data.productid).attr("disabled","disabled");
		$('#v_orgname').val(data.orgno);
//		$('#c_orgname').html("<option value='"+data.orgno+"'>"+data.orgname+"</option>").attr("disabled","disabled");
	 	$('#c_productcode').val(data.productcode).attr("disabled","disabled");
	 	$('#c_productname').val(data.productname).attr("disabled","disabled");
	 	$('#c_productdes').val(data.productdes).attr("disabled",false);
	 	$('#c_createuser').val(data.createuser).attr("disabled","disabled");
	 	$('#c_updateuser').val(data.updateuser).attr("disabled","disabled");
	 	$('#c_createtime').val(data.createtime).attr("disabled","disabled");
	 	$('#c_updatetime').val(data.updatetime).attr("disabled","disabled");
	 	$('#c_status').val(data.status).attr("disabled",false);
	 	$('#tr_productid').attr("hidden","true");
		$('#dataTitle').html("修改数据【"+data.productname+"】");
		$('#saveUpdateBtn').show();
		
		iscleck=true;
		//validator.resetForm();
	}else if(type=="add"){
		$('#c_option').val("add");
		$('#c_productid').val("");
		$('#c_productname').val("");
		$('#c_productdes').val("");
		$('#c_status').val("0");
		$('#tr_productid').attr("hidden","true");
		$('#dataTitle').html("添加数据");
		$('#saveUpdateBtn').show();
		disabledclose();
//		queryOrgInfo();      //从机构表中获取机构信息
//		$('#c_orgname option:first').prop('selected', 'selected');
		makeProductCode();   //生成产品编码
		isExist1 = false;    //自动生成的产品编码一定不为空，并设置值为false
		iscleck=true;   //控制重复提交
	}      
}

//加载机构信息
//queryOrgInfo();	
function queryOrgInfo(){
	var html="";
	$.ajax({
        type: "post",
        url: root+'/query_allorganization.do',
        async: false,
        dataType:"json",
        success: function(data){
        	if(data!=undefined&&data.length>0){
        		$.each(data,function(i,v){
            		html+="<li><span id='"+v.orgNo+"'>"+v.orgName+"</span></li>";
            	});
    			$("#c_orgname").html(html);
        	}
        },
        error: function () {  
        	alert("操作失败");  
        }
    });
	
//	var html="";
//	$.ajax({
//        type: "post",
//        url: root+'/query_organization.do',
//        async: false,
//        dataType:"json",
//        success: function(data){
//        	if(data!=undefined&&data.length>0){
//        		$.each(data,function(i,v){
//            		html+="<option value='"+v.orgNo+"'>"+v.orgName+"</option>";
//            	});
//    			$("#c_orgname").html(html);
//        	}
//        },
//        error: function () {  
//        	alert("操作失败");  
//        }
//    });
	
}

function queryCorporste(productCode){
	var orgNo="";
	var orgName="";
	$("#org_name").empty();
//	$("#org_name").val('');
	$("#org_id").val('');
	$.ajax({
        type: "post",
        url: root+'/query_organization.do',
        data:{"productCode":productCode}, 
        async: false,
        dataType:"json",
        success: function(data){
        	if(data!=undefined&&data.length>0){
        		$.each(data,function(i,v){
        			orgNo+=v.orgNo+",";
        			orgName+=v.orgName+",";
            	});
        		orgName=orgName.substring(0,orgName.length-1);
        		orgNo=orgNo.substring(0,orgNo.length-1);
    			$("#org_name").html(orgName);
    			$("#org_id").val(orgNo);
        	}
        },
        error: function () {  
        	alert("操作失败");  
        }
    });
}
//自动生成产品编码，并放到产品编码文本框里
function makeProductCode(){
	$.ajax({
        type: "post",
        url: root+'/make_productCode.do',
        dataType:"json",
        success: function(data){
        	if(data.result=="success"){
        		var productCode = data.productCode;
        		$('#c_productcode').val(productCode);
        	}else{
        		alert("操作失败!");
        	}
        },
        error: function () {  
        	alert("操作失败!");  
        }
    });
}

//校验编码是否重复
function checkCodeIsExists() {
	$("#d_productcode").hide();   //先把上次显示提示清除
	var productcode = $('#c_productcode').val().trim();
	$.ajax({
        type: "post",
        url: root+'/checkProduct_isExist.do',
        data:{"productcode":productcode}, 
        dataType: "json",
        success: function(data){
        	if(data.isPass==false){
        		//alert("产品编码已存在，请重新输入！");
        		isExist1 = true;
        		$("#d_productcode").show();
        		$('#c_productcode').focus();
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

//校验产品名称是否重复
function checkNameIsExists() {
	$("#d_productname").hide();  //先把上次显示提示清除
	var productname = $('#c_productname').val().trim();
	$.ajax({
        type: "post",
        url: root+'/checkProduct_isExist.do',
        data:{"productname":productname}, 
        dataType: "json",
        success: function(data){
        	if(data.isPass==false){
        		//alert("产品名称已存在，请重新输入！");
        		isExist2 =true;
        		$("#d_productname").show();
        		$('#c_productname').focus();
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

/**
 * 接收返回信息
 * @param el
 * @param method
 */


iscleck=null;
function saveOrUpdate(){
	
	if($("#dataFrom").valid()&&iscleck){
		iscleck=false;
		var option = $('#c_option').val();
		if(option=="add"&&(isExist1||isExist2)){
			alert("产品编码或名称已存在，请重新输入！");
			return false;
		}
		disabledclose();
//		var orgNo = $('#c_orgname option:selected').val(); //根据已选中的机构，获取机构编码
//		$('#v_orgname').val(orgNo);
		var data = $('#dataFrom').serialize();
		disabledopen();
		$.ajax({ 
	         type:'post', 
	         url:root+'/product_Config_save.do', 
	         data:data, 
	         async:false,
	         success:function(msg){
	            if(msg==''){
	                alert("保存成功！");        //弹出成功msg
	                //刷新表格数据
	                doSearch();
	                $('#dataModal').modal('hide');
	            }else{
	                alert("接口请求出现错误:"+msg);  //弹出失败msg
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
			//productCode为自动生成，不需要加codestr校验
			productcode:{
				required:true,
				rangelength:[0,50]
			},
			productname:{
				required:true,				
				rangelength:[0,100]
			},
			productdes:{
				required:true,				
				rangelength:[0,400]
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

//对不可操作文本框变成可操作
function disabledclose(){
	$('#c_productid').attr("disabled",false);
//	$('#c_orgname').attr("disabled",false);
 	$('#c_productcode').attr("disabled",false);
 	$('#c_productname').attr("disabled",false);
 	$('#c_productdes').attr("disabled",false);
 	$('#c_createuser').attr("disabled",false);
 	$('#c_updateuser').attr("disabled",false);
 	$('#c_createtime').attr("disabled",false);
 	$('#c_updatetime').attr("disabled",false);
 	$('#c_status').attr("disabled",false);
 	
}

//对部分文本框变成不可操作
function disabledopen(){
	$('#c_productid').attr("disabled",true);
//	$('#c_orgname').attr("disabled",true);
 	$('#c_productcode').attr("disabled",true);
 	$('#c_productname').attr("disabled",true);
 	$('#c_productdes').attr("disabled",true);
 	$('#c_createuser').attr("disabled",true);
 	$('#c_updateuser').attr("disabled",true);
 	$('#c_createtime').attr("disabled",true);
 	$('#c_updatetime').attr("disabled",true);
 	$('#c_status').attr("disabled",true);
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


//法人


function addorg() {
	list_del();
	var orgArray = $('#org_id').val().split(',');
	for(var i in orgArray){
		var orgid = orgArray[i];
		$("#"+orgid).addClass('hover');
		 $message_peo = $("#"+orgid).parent().html();
		$("#"+orgid).parents('.select_peo_con').find('.right ul.send_to').append("<li>"+$message_peo +"</li>");
	}
	$('#addorg_query').modal('show');

}
function addorg_save() {
	
	var orgid='' ;
	var orgname='' ;
	var text='';
	$.each($('.send_to li span'), function() {
		orgname += $(this).html()+",";
		orgid += $(this).attr("id")+",";
	})
	orgname=orgname.substring(0,orgname.length-1);
	orgid=orgid.substring(0,orgid.length-1);
	$("#org_name").html(orgname);
	$("#org_id").val(orgid);
	
	$('#addorg_query').modal('hide');
	list_del();

}
function addorg_close() {
	$('#addorg_query').modal('hide');
	list_del();
}




$('.detail_layer').find('.areas_list li').click(function(){
    //对勾切换效果
    if(!$(this).find('span').hasClass('hover')){
        $(this).find('span').addClass('hover');
    }else{
        $(this).find('span').removeClass('hover');
    }
    //获取选中元素html
    var val_prev = $(this).find('span').attr('id');
    $message_peo = $(this).html();
    
    //获取添加后的数组
    var attrid =$(this).parents('.select_peo_con').find('.right ul.send_to li').map(function(){
        return $(this).find('span').attr('id');
    });
    //判断数字是否存在数组里
    if( jQuery.inArray(val_prev, attrid) ==-1){
        $(this).parents('.select_peo_con').find('.right ul.send_to').append("<li>"+$message_peo +"</li>");
    }else{
        // alert('已存在列表中');
        while ($(this).parents('.select_peo_con').find('.right ul.send_to').find("#" + val_prev).length > 0)  
        {  
           $(this).parents('.select_peo_con').find('.right ul.send_to').find("#" + val_prev).parent().remove();  
        }  
    }

});

function list_add() {
	$.each($('.detail_layer .areas_list li'), function() {
		
	    if(!$(this).find('span').hasClass('hover')){
	        $(this).find('span').addClass('hover');
	    }
	    
	    var val_prev = $(this).find('span').attr('id');
	    $message_peo = $(this).html();
	    
	    var attrid =$(this).parents('.select_peo_con').find('.right ul.send_to li').map(function(){
	        return $(this).find('span').attr('id');
	    });
	    if( jQuery.inArray(val_prev, attrid) ==-1){
	        $(this).parents('.select_peo_con').find('.right ul.send_to').append("<li>"+$message_peo +"</li>");
	    }
	})
}

function list_del() {
	$.each($('.detail_layer .areas_list li'), function() {
		
	    $(this).find('span').removeClass('hover');
	    
	    var val_prev = $(this).find('span').attr('id');
	    $message_peo = $(this).html();
	    
	    var attrid =$(this).parents('.select_peo_con').find('.right ul.send_to li').map(function(){
	        return $(this).find('span').attr('id');
	    });
	    
	    while ($(this).parents('.select_peo_con').find('.right ul.send_to').find("#" + val_prev).length > 0)  
	    {  
	       $(this).parents('.select_peo_con').find('.right ul.send_to').find("#" + val_prev).parent().remove();  
	    } 
	})
}
