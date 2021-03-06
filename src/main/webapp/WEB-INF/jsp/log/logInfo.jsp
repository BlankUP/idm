<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>日志信息</title>
<link rel="icon" href="../../favicon.ico">

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">
    
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/jqgrid/css/ui.jqgrid.css" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/cgrid.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/datepicker/WdatePicker.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/i18n/grid.locale-cn.js"></script>

<jsp:include page="./../common/header.jsp" flush="true"/>
</head>
<body>
<div class="container-fluid">
  <ul class="breadcrumb">
 			<li>您当前位置：</li>
 			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 			<li> <i class="fa fa-globe"></i>日志管理<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i> 日志信息</li>
  </ul>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
            <div class="control-group">
            <label for="searchOperator" class="control-label">操作用户：</label> 
				 <span class="span2">
				  	<input type="text" id="searchOperator" maxlength="100" placeholder="请输入操作用户名称...">
				 </span>
			 <label for="searchOperatTime" class="control-label">操作时间：</label> 
				 <span class="span2">
				  	<input type="text" id="searchOperatTime" class="Wdate" onfocus="new WdatePicker(this)"  placeholder="请输入操作时间...">
				 </span>
		      <label for="searchOperatType" class="control-label">操作类型：</label> 
				 <span class="span2">
				  	<input type="text" id="searchOperatType" maxlength="100" placeholder="请输入操作类型...">
				 </span>	 
				 <span class="span2">
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			  	 </span>			  
			  </div>

			</form>
	</div>
	
	<table id="grid-table"></table>
	<div id="grid-pager"></div>	
</div>
	
	<div id="logInfoModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="logInfoTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="dataFrom" class="form-horizontal">
			<input type="hidden" id="logInfo_option" name="logInfo_option" value="" />
		  <table cellpadding="2px">
		  <tr><td style="width: 100px; ">操作用户</td>
		  <td style="width: 300px; "><input id="userId" type="text" name="userId" ></td></tr>
		  <tr><td>操作时间</td>
		  <td><input id="operatTime" type="text" name="operatTime" ></td></tr>
		  <tr><td>操作模块</td>
		  <td><input id="operatModule" type="text" name="operatModule" ></td></tr>
		  <tr><td>操作类型</td>
		  <td><input id="operatType" type="text" name="operatType" ></td></tr>
		<!--   <tr><td>操作详情</td>
		  <td><textarea id="operatData" type="text" name="operatData" rows="4" ></textarea></td></tr> -->
		  <tr><td>创建时间</td>
		  <td><input id="createTime" type="text" name="createTime" ></td></tr>
		  </table>
		</form>
	  </div>
	</div>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[4]).addClass("active");
	    });
	</script>
	<script src="resources/js/log/logInfo.js"></script>
</body>
</html>