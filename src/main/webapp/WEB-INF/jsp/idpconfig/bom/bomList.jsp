<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>BOM版本管理</title>
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

<jsp:include page="./../../common/header.jsp" flush="true"/>
</head>
<body>
  <div class="container-fluid">
  <ul class="breadcrumb">
 			<li>您当前位置：</li>
 			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 			<li> <i class="fa fa-globe"></i>决策引擎配置<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i> BOM版本管理</li>
  </ul>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
            <div class="control-group">
            <label for="bomVersionNo" class="control-label">版本号：</label> 
				 <span class="span3">
				  	<input type="text" id="bomVersionNo" maxlength="100" placeholder="请输入版本号...">
				 </span>
				 
				 <span class="span2">
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			  	 </span>
			  	 <span class="span2" id="msg_span" style="float:right;width:250px">
			  	 </span>				  
			  </div>

			</form>
	</div>	
				
	</div> 
 	<table id="grid-table"></table>
	<div id="grid-pager"></div>
	
	<div id="bomModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id=bomTitle ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="dataFrom" class="form-horizontal">
		<input type="hidden" id="option" name="option" value="" />
		<input type="hidden" id="bomId" name="bomId" value="" />
		<table cellpadding="2px">
			<tr id="bomMtable" >
				<td>版本号</td>
			  	<td>
			  		<input id="bomVersion" type="text" name="bomVersion">
			  	</td>
			</tr>
			<tr>
				<td>版本名称</td>
			  	<td>
			  		<input id="bomVersionName" type="text" name="bomVersionName">
			  	</td>
			</tr>
			<tr>
				<td>版本描述</td>
				<td>
					<textarea id="versionDepiction" rows="4" cols="50" name="versionDepiction" ></textarea>
				</td>
			</tr>
				</table>

		</form>
	  </div>
	  <div class="modal-footer">
	    <a href="javascript:void(0)" id=bomSubmit class="btn btn-info" onclick="bomSubmit()"><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	  </div>
	</div>
	
</body>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[3]).addClass("active");
	    });
	</script>
	    <script src="resources/js/idpconfig/bom/bomList.js"></script>
	    <script src="resources/js/datepicker.js"></script>
</html>