<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>产品信息管理</title>

<link rel="icon" href="../../favicon.ico">

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">
    
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/jqgrid/css/ui.jqgrid.css" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/cgrid.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/select.css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.v1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.message_cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/i18n/grid.locale-cn.js"></script>

<jsp:include page="../../common/header.jsp" flush="true"/>
</head>
<body>
  <div class="container-fluid">	
  <ul class="breadcrumb">
 			<li>您当前位置：</li>
 			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 			<li> <i class="fa fa-globe"></i>基础参数配置<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i> 产品信息管理</li>
  </ul>
  </div>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
	            <div class="control-group">
					<!--  <label for="searchOrgNo" class="control-label">机构代码：</label> 
					 <span class="span3"> <input type="text" id="searchOrgNo"  placeholder="请输入机构编码..."></span> -->
					 <label for="searchProductCode" class="control-label">产品编码：</label> 
					 <span class="span3"> <input type="text" id="searchProductCode" maxlength="100"  placeholder="请输入产品编码..."></span>
					 <label for="searchProductName" class="control-label">产品名称：</label> 
					<span class="span3"> <input type="text" id="searchProductName" maxlength="100"  placeholder="请输入产品名称..."></span>
					 <span class="span2">
				      <button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
				  	 </span>
				  </div>
	            <div class="control-group">
	            	<!-- <label for="searchOrgname" class="control-label">机构名称：</label> 
					<span class="span3"> <input type="text" id="searchOrgName"  placeholder="请输入机构名称..."></span> -->				
				</div>
			</form>
	</div>	
	<table id="grid-table"></table>
	<div id="grid-pager"></div>
	
<div id="slModal">	
	<div id="dataModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="dataTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="dataFrom" class="form-horizontal">
		  <input type="hidden" id="c_option" name="option" value="">
		  <table cellpadding="2px">
		  <tr id="tr_productid"><td style="width: 150px;">产品ID</td><td><input style="width: 300px;" type="text" id="c_productid" name="productid"></input></td></tr>
		   
		  <tr>
			  <td style="width: 150px;">产品编码</td>
			  <td>
			  	<input style="width: 215px;" type="text" onblur="checkCodeIsExists()" id="c_productcode"  name="productcode" />
			  	<label id="d_productcode" name="error" style="color: red;display: none;" >产品编码已存在</label>
			  </td>
		  </tr>
		  <tr>
		  	<td style="width: 150px;">产品名称</td>
		  	<td>
		  		<input style="width: 215px;" type="text" onblur="checkNameIsExists()" id="c_productname"  name="productname" />
		  		<label id="d_productname" name="error" style="color: red;display: none;" >产品名称已存在</label>
		  	</td>
		  </tr>
<!-- 		  <tr>
			 <td style="width: 150px;">法人行</td>
				<td>
				<a href="javascript:void(0)" style="float: right;vertical-align: middle;" class="btn btn-info" onclick="addorg()" > 法人行</a>
				<div  style="height: 60px;overflow-y:auto;width: 222px;border-radius: 4px;border: 1px solid #ccc;padding-left: 5px;">
					<span id="org_name" ></span>
				</div> 
				<input type="hidden" id="org_id" name="orgno" />
					<select style="width: 230px;" id="c_orgname"  name="orgname"  >
					</select>
					<input id="v_orgname"  name="orgno" value="" type="hidden"/>
				</td>
		  </tr> -->
		  <tr><td>产品详细信息</td><td><textarea style="width: 215px;height: 50px;" rows="4" id="c_productdes"  name="productdes"></textarea></td></tr>
		  <tr id="tr_createuser"><td>创建人</td><td><input style="width: 215px;" type="text" id="c_createuser" name="createuser"></input></td></tr>
  		  <tr id="tr_createtime"><td>创建时间</td><td><input style="width: 215px;" type="text" id="c_createtime" name="createtime"></input></td></tr>
  		  <tr id="tr_updateuser"><td >修改人</td><td><input style="width: 215px;" type="text" id="c_updateuser" name="updateuser"></input></td></tr>
  		  <tr id="tr_updatetime"><td>修改时间</td><td><input style="width: 215px;" type="text" id="c_updatetime" name="updatetime"></input></td></tr>
  		  <tr><td>状态</td> 
  		  	<td>
				<select id="c_status" name = "status" style="width: 230px;">
					<option value="0">锁定</option>
					<option value="1">使用</option>
					<option value="2">停用</option>
				</select>
			</td>
		  </tr>
		  </table>
		</form>
	  </div>
	  <div class="modal-footer">
	    <a href="javascript:void(0)" id="saveUpdateBtn" 
	    	class="btn btn-info" onclick="saveOrUpdate()">
	    	<i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" 
	    	class="btn btn-info" data-dismiss="modal">
	    	<i class="fa fa-close"></i> 取 消</a>
	  </div>
	</div>
</div>


<div id="addorg_query" class="modal hide fade detail_layer"  style="height: 490px;">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="dataTitle" >法人行</span></h3>
	  </div>
	  <div class="modal-body">
	<div class="select_peo_con" >
		<div class="left">
			<div class="areas_list" >
					<ul style="list-style-type:none;" id="c_orgname">
					</ul>
			</div>
		</div>
		<div class="center">
			<a id="list_add" onclick="list_add()"><img src="../../../../resources/images/addicon.jpg"></a>
			<a id="list_del" onclick="list_del()"><img src="../../../../resources/images/addicon.jpg"></a>
		</div>
		<div class="right">
			<ul class="send_to" style="list-style-type:none;padding-inline-start:0px;">
			</ul>
		</div>
		<div class="clear"></div>
	</div>
	</div>
	<div class="modal-footer">
	    <a href="javascript:void(0)"  class="btn btn-info" onclick="addorg_save()"><i class="fa fa-save"></i> 确 定</a>
		<a href="javascript:void(0)"  class="btn btn-info" onclick="addorg_close()"><i class="fa fa-close"></i> 取 消</a>
	  </div>
</div>
 
</body>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[1]).addClass("active");
	    });
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/idpconfig/proModelParaConfig/productConfig.js"></script>

</html>
