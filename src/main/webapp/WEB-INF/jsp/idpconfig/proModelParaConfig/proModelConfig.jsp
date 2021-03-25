<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>模型信息管理</title>

<link rel="icon" href="../../favicon.ico">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css"> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/jqgrid/css/ui.jqgrid.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/cgrid.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.v1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.message_cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/i18n/grid.locale-cn.js"></script>

<jsp:include page="../../common/header.jsp" flush="true"/>
</head>
<body>
  <div class="container-fluid" >	
  <ul class="breadcrumb">
 			<li>您当前位置：</li>
 			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 			<li> <i class="fa fa-globe"></i> 基础参数配置<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i> 模型信息管理</li>
  </ul>
  </div>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
            	<div class="control-group">
			<!-- 		  <label for="searchOrgNo" class="control-label">机构代码：</label> 
					  <span class="span3"> <input type="text" id="searchOrgNo"  placeholder="请输入机构编码..."></span> 
					  <label for="searchProductCode" class="control-label">产品编码：</label> 
					  <span class="span3"> <input type="text" id="searchProductCode"  placeholder="请输入产品编码..."></span>-->
					  <label for="searchModelName" class="control-label">模型名称：</label> 
					<span class="span3"> <input type="text" id="searchModelName" maxlength="100" placeholder="请输入模型名称..."></span>
					  <label for="searchModelCode" class="control-label">模型编码：</label> 
					  <span class="span3"> <input type="text" id="searchModelCode" maxlength="100" placeholder="请输入模型编码..."></span>
					  <span class="span2">
				      		<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
				  	  </span> 
				</div>
                <!-- <div class="control-group">
	            	<label for="searchOrgname" class="control-label">机构名称：</label> 
					<span class="span3"> <input type="text" id="searchOrgName"  placeholder="请输入机构名称..."></span>
					<label for="searchProductName" class="control-label">产品名称：</label> 
					<span class="span3"> <input type="text" id="searchProductName"  placeholder="请输入产品名称..."></span>
					<label for="searchModelName" class="control-label">模型名称：</label> 
					<span class="span3"> <input type="text" id="searchModelName"  placeholder="请输入模型名称..."></span>
			    </div> -->
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
		  <input type="hidden" id="c_option" name="option" value=""/>
		  <input type="hidden" id="c_modelid" name="modelid" value=""/>
		  <table cellpadding="2px">
<!-- 			  <tr>
				<td style="width: 150px;">机构名称</td>
				<td>
					<select style="width: 230px;" id="c_orgname"  name="orgname"  onchange="getProductInfoByorgNo();"></select>
					<input id="v_orgname"  name="orgno" value="" type="hidden"/>
				</td>
			  </tr> 
			  <tr>
				<td style="width: 150px;">产品名称</td>
				<td>
					<select style="width: 230px;" name="productCode" id="c_productCode"></select>
					<input id="v_productCode" name="productName" type="hidden"/>
				</td>
			  </tr>-->
			  <tr>
			  	<td style="width: 150px;">模型编码</td><td>
			  		<input style="width: 215px;" type="text" onblur="checkModelCodeIsExists()" id="c_modelcode"  name="modelcode" />
			  		<!-- <input style="width: 215px;" type="text" id="c_modelcode"  name="modelcode" /> -->
			  		<label id="d_modelcode" name="error" style="color: red;display: none;" >模型编码已存在</label>
			  	</td>
			  </tr>
			  <tr>
			  	<td>模型名称</td>
			  	<td>
			  		<input style="width: 215px;" type="text" onblur="checkModelNameIsExists()" id="c_modelname"  name="modelname" />
			  		<label id="d_modelname" name="error" style="color: red;display: none;" >模型名称已存在</label>
			  	</td>
			  </tr>
			  <tr>
				<td>决策系统</td>
				<td>
					<select name="respSystemCode" id="c_respSystemCode" style="width: 404px;">
						<option value="1">风控系统</option>
						<option value="2">模型质检</option>
					</select>
					<input id="v_respSystemCode" type="hidden" name="respSystemName" />
				</td>
			</tr>
			  <tr><td>模型类型</td>
	  		  	<td>
					<select onchange="changeType()" id="c_modelType" name = "modelType" style="width: 230px;">
						<option value="1">决策模型</option>
						<option value="2">PMML模型</option>
					</select>
				</td>
			  </tr>
			  <tr hidden="hidden" id="tr_pmml">
				<td style="width: 150px;">PMML名称</td>
				<td>
					<select style="width: 230px;" id="c_pmmlCode" name="pmmlCode" onchange="pmmlCodeInspect()">
					</select>
					<label id="d_pmmlCode" name="error" style="color: red;display: none;" >无PMML可关联，请先在PMML界面完成PMML新增或修改！</label>
					<input id="v_pmmlCode" type="hidden" name="pmmlName" />
				</td>
			  </tr>
			  <tr id="tr_createuser"><td>创建人</td><td><input style="width: 215px;" type="text"  id="c_createuser" name="createuser"></input></td></tr>
			  <tr id="tr_createtime"><td>创建时间</td><td><input style="width: 215px;" type="text"  id="c_createtime" name="createtime"></input></td></tr>
			  <tr id="tr_updateuser"><td>修改人</td><td><input style="width: 215px;" type="text" id="c_updateuser"  name="updateuser"></input></td></tr>
	  		  <tr id="tr_updatetime"><td>修改时间</td><td><input style="width: 215px;" type="text" id="c_updatetime" name="updatetime"></input></td></tr>  		  
	  		  <tr><td>状态</td>
	  		  	<td>
					<select id="c_status" name = "status" style="width: 230px;">
						<option value="0">有效</option>
						<option value="1">无效</option>
					</select>
				</td>
			  </tr>
		  </table>
		</form>
	  </div>
	  <div class="modal-footer">
	    <a href="javascript:void(0)" id="saveUpdateBtn" class="btn btn-info" onclick="saveOrUpdate()"><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	  </div>
	</div>
</div>
 
</body>
	<script type="text/javascript">
	 	var root='<%=request.getContextPath()%>';
	 	$(function(){
	    	$($("#navbar>li")[1]).addClass("active");
	  	});
	 	
	 	
		//监听下拉框事件
		$('select').change(function() {
			var id = "v_"+$(this).attr("name");
			var text = $(this).find("option:selected").text();
			$("#"+id).val(text)
			
		});
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/idpconfig/proModelParaConfig/proModelConfig.js"></script>

</html>
