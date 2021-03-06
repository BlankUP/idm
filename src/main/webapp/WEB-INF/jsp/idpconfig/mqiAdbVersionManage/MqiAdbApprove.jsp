<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>adb审批管理</title>
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

<jsp:include page="./../../common/header.jsp" flush="true"/>
</head>
<body>
<div class="container-fluid">
  <ul class="breadcrumb">
 			<li>您当前位置：</li>
 			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 			<li> <i class="fa fa-globe"></i>审批管理<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i> 模型质检adb文件审批管理</li>
  </ul>	
	<table id="grid-table"></table>
	<div id="grid-pager"></div>	
</div>

<div id="adbApproveModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h4 align="center"><span id="adbApproveTitle" ></span></h4>
	  </div>
	  <div class="modal-body">	    
		<form id="dataFrom" class="form-horizontal">
			<input type="hidden" id="adbApprove_option" name="adbApprove_option" value="" />
		  <table cellpadding="2px">	
		  <tr><td style="width: 100px; ">版本名称</td>
		  <td style="width: 300px; "><input id="versionName" type="text" name="versionName" ></td></tr>	  
		  <tr><td style="width: 100px; ">版本号</td>
		  <td style="width: 300px; "><input id="versionNo" type="text" name="versionNo" ></td></tr>
		  <tr><td>版本描述</td>
		  <td><textarea id="versionDesc" type="text" name="versionDesc" rows="3" ></textarea></td></tr>
		  <tr><td>申请审批时间</td>
		  <td><input id="applicationTime" type="text" name="applicationTime" ></td></tr>
		  <tr><td>申请理由</td>
		  <td><textarea id="applicationReason" type="text" name="applicationReason" rows="3" ></textarea></td></tr>
		  <tr><td>申请审批人</td>
		  <td><input id="applicationUserId" type="text" name="applicationUserId" ></td></tr>
		  <tr><td>审批状态</td>
		  <td><select id="status" name="status">
			  	<option value="0">已通过审批</option>
				<option value="1">待一级审批</option>
				<option value="2">待二级审批</option>
			  </select></td></tr>
		  <tr><td>审批意见</td>
		  <td><textarea id="reason" type="text" name="reason" rows="3" ></textarea></td></tr>
		  </table>
		</form>		
	</div>
	<div class="modal-footer">
	    <a href="javascript:void(0)" id="adbApprove" class="btn btn-info" onclick="adbApprove()"><i class="fa fa-check"></i>通过</a>
	    <a href="javascript:void(0)" id="adbReject" class="btn btn-info" onclick="adbReject()"><i class="fa fa-ban"></i>不通过</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	</div>
</div>

	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[3]).addClass("active");
	    });
	</script>
	<script src="resources/js/idpconfig/mqiAdbVersionManage/MqiAdbApprove.js"></script>
</body>
</html>