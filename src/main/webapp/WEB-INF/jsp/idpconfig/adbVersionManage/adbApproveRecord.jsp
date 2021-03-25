<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>adb审批记录</title>
<link rel="icon" href="../../favicon.ico">

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">
    
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/jqgrid/css/ui.jqgrid.css" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/cgrid.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/i18n/grid.locale-cn.js"></script>

<jsp:include page="./../../common/header.jsp" flush="true"/>
</head>
<body>
<div class="container-fluid">
  <ul class="breadcrumb">
 			<li>您当前位置：</li>
 			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 			<li> <i class="fa fa-globe"></i>审批管理<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i> 审批记录查询</li>
  </ul>	
  <div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
            <div class="control-group">
            <label for="searchOperator" class="control-label">版本号：</label> 
				 <span class="span3">
				  	<input type="text" id="searchVersionInfo" maxlength="100" placeholder="请输入版本号...">
				 </span> 
				 <span class="span2">
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			  	 </span>			  
			  </div>
			</form>
	</div>
	<div id="approveRecordModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="approveRecordTitle" ></span></h3>
	  </div>
	  <div class="modal-body">	    
		<form id="approveRecordForm" class="form-horizontal">
			<input type="hidden" id="approveRecord_option" name="approveRecord_option" value="" />
		  <table cellpadding="2px">	
		  <tr><td style="width: 100px; ">版本名称</td>
		  <td style="width: 300px; "><input id="versionName" type="text" name="versionName" ></td></tr>	  
		  <tr><td style="width: 100px; ">版本号</td>
		  <td style="width: 300px; "><input id="versionNo" type="text" name="versionNo" ></td></tr>		  
		  <tr><td>申请审批时间</td>
		  <td><input id="applicationTime" type="text" name="applicationTime" ></td></tr>
		  <tr><td>申请理由</td>
		  <td><textarea id="applicationReason" type="text" name="applicationReason" rows="3" ></textarea></td></tr>
		  <tr><td>申请审批人</td>
		  <td><input id="applicationUser" type="text" name="applicationUser" ></td></tr>
		  <tr><td>审批人</td>
		  <td><input id="approveUser" type="text" name="approveUser" ></td></tr>
		  <tr><td>审批时间</td>
		  <td><input id="approveTime" type="text" name="approveTime" ></td></tr>
		  <tr><td>审批意见</td>
		  <td><textarea id="approveAdvise" type="text" name="approveAdvise" rows="3" ></textarea></td></tr> 
          <tr><td>审批等级</td>
		  <td><select id="approveLevel" name="approveLevel">
				<option value="1">一级审批</option>
				<option value="2">二级审批</option>
			  </select></td></tr>
		  <tr><td>审批结果</td>
		  <td><select id="result" name="result">
				<option value="0">审批未通过</option>
				<option value="1">审批通过</option>
			  </select></td></tr>
		  </table>
		</form>		
	</div>
	<div class="modal-footer">
	    <a href="javascript:void(0)" id="approveRecord" class="btn btn-info"  data-dismiss="modal"><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	</div>
</div>
	
	<table id="grid-table"></table>
	<div id="grid-pager"></div>	
</div>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[3]).addClass("active");
	    });
	</script>
	<script src="resources/js/idpconfig/adbVersionManage/adbApproveRecord.js"></script>
</body>
</html>