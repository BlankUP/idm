<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>批量任务参数配置</title>
<link rel="icon" href="../../favicon.ico">

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">
    
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/jqgrid/css/ui.jqgrid.css" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/cgrid.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.v1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.message_cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/i18n/grid.locale-cn.js"></script>

<jsp:include page="./../common/header.jsp" flush="true"/>
</head>
<body>
  <div class="container-fluid">
  <ul class="breadcrumb">
 			<li>您当前位置：</li>
 			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 			<li> <i class="fa fa-globe"></i>系统管理<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i> 批量任务参数配置</li>
  </ul>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
            		<div class="control-group">
					<label for="searchParamCode" class="control-label">参数编号：</label> 
						<span class="span3"> 
							<input type="text" id="searchParamCode" maxlength="100" placeholder="请输入参数编号...">
						</span> 
					<label for="searchParamName" class="control-label">参数名称：</label> 
						<span class="span3"> 
							<input type="text" id="searchParamName" maxlength="100" placeholder="请输入参数名称...">
					</span>
				</div>
				<div class="control-group">
					<label for="searchParamType" class="control-label">参数类型：</label> 
					<span class="span3"> 
						<select id="searchParamType" style="width: 225px; height: 30px;">
							<option value="" selected="1">所有类型</option>
							<option value="1">内置参数</option>
							<option value="0">自定义参数</option>
						</select>
					</span> 
					<label for="searchstatus" class="control-label">参数状态：</label> 
					<span class="span3"> 
						<select id="searchstatus" style="width: 225px; height: 30px;">
							<option value="" selected="1">所有状态</option>
							<option value="1">有效</option>
							<option value="0">无效</option>
						</select>
					</span>
					<span class="span2">
						<button type="button" class="btn btn-info" onclick="doSearch()">
							<i class="fa fa-search"></i> 查 询
						</button>
					</span>
				</div>	
            <!-- <div class="control-group">
            <label for="searchVersionNo" class="control-label">参数编码：</label> 
				 <span class="span3">
				  	<input type="text" id="searchParamCode" placeholder="请输入参数编码...">
				 </span>
				 
				 <span class="span2">
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			  	 </span>
			  	 <span class="span2" id="msg_span" style="float:right;width:250px">
			  	 </span>				  
			  </div> -->

			</form>
	</div>	
				
	</div> 
 	<table id="grid-table"></table>
	<div id="grid-pager"></div>
	
	<div id="paramConfigModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="paramConfigTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="dataFrom" class="form-horizontal">
			<input type="hidden" id="param_config_option" name="option" value="" />
		  	<table cellpadding="2px">
			  	<tr>
				  	<td style="width: 100px; ">参数编码</td>
				  	<td style="width: 300px; "><input id="paramCode" type="text" onblur="checkCodeIsExists()" name="paramCode"  >	  	
				  	<label id="e_paramCode" name="error" style="color: red;display: none;" >参数编码已存在</label></td>
		  		</tr>
			  	<tr>
			  		<td>参数名称</td>
			  		<td><input id="paramName" type="text" onblur="checkNameIsExists()" name="paramName"  >
			  		<label id="e_paramName" name="error" style="color: red;display: none;" >参数名称已存在</label></td>
			  	</tr>
			  	<tr>
			  		<td>参数类型</td>
			  		<td>
					  <select id="paramType" name="paramType">
					  	<option value="1" selected>内置参数</option>
					  	<option value="0">自定义参数</option>
					  </select>
				  	</td>
			  	</tr>
			  	<tr><td>参数值</td><td><input id="paramValue" type="text" name="paramValue"  ></td></tr>
			  	<tr><td>参数描述</td><td><input id="paramDesc" type="text" name="paramDesc"  ></td></tr>
			  	<tr>
			  		<td>参数状态</td>
			  		<td>
			  			<select id="status" name="status">
					  	<option value="1" selected>有效</option>
					  	<option value="0">无效</option>
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
</body>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[6]).addClass("active");
	    });
	</script>
	    <script src="resources/js/fd/paramsConfigInfo.js"></script>
</html>