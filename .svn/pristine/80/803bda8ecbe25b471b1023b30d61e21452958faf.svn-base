<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>adb规则部署</title>
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
 			<li> <i class="fa fa-globe"></i>决策引擎配置<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i> 模型质检adb规则部署</li>
  </ul>
	<div class="alert alert-info">
           <form name="searchForm" class="form-horizontal">
           <div class="control-group">
           	 <label for="searchVersionInfo" class="control-label">版本号：</label> 
			 <span class="span3">
			  	<input type="text" id="searchVersionInfo" maxlength="100" placeholder="请输入版本号...">
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
	
	<div id="adbVersionModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="adbVersionTitle" ></span></h3>
	  </div>
	  <div class="modal-body">	    
		<form id="dataFrom" class="form-horizontal">
			<input type="hidden" id="adbVersion_option" name="adbVersion_option" value="" />
		  <table cellpadding="2px">		  
		  <tr><td style="width: 100px; ">版本号</td>
		  <td style="width: 300px; "><input id="versionNo" type="text" name="versionNo" ></td></tr>
		  <tr><td>版本描述</td>
		  <td><textarea id="versionDesc" name="versionDesc" rows="4" ></textarea></td></tr>
		  <tr><td>版本创建日期</td>
		  <td><input id="createTime" type="text" name="createTime" ></td></tr>
		  <tr><td>版本创建人</td>
		  <td><input id="createUser" type="text" name="createUser" ></td></tr>
		  <tr><td>部署日期</td>
		  <td><input id="deployTime" type="text" name="deployTime" ></td></tr>
		  <tr><td>部署人</td>
		  <td><input id="deployer" type="text" name="deployer" ></td></tr>
		  <tr><td>版本状态</td>
		  <td><select id="versionState" name="versionState">
			  	<option value="0">新版本</option>
				<option value="1">正在使用</option>
				<option value="2">审批通过，待发布</option>
				<option value="5">历史版本</option>
				<option value="3">待一级审批</option>
				<option value="4">待二级审批</option>
				<option value="6">审批未通过</option>
			  </select></td></tr>
		  </table>
		</form>		
	</div>
	<div class="modal-footer">
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	</div>
	</div>
	
	<div id="uploadFileModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="uploadFileTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="adbDataFrom" class="form-horizontal" method="post" enctype="multipart/form-data">
		  <input type="hidden" id="c_adbId" type="text" name="adbId" />
		  <input type="hidden" id="c_adbIdBack" type="text" name="adbIdBack" />
		  <table cellpadding="2px">
			  <tr hidden="hidden"><td style="width: 150px; ">正在使用的版本号</td>
				  <td><input style="width: 300px;" id="c_versionNoBack" type="text" name="versionNoBack" /></td>
			  </tr>
			  <tr><td>&nbsp;&nbsp;</td></tr>
			  <tr hidden="hidden"><td style="width: 150px; ">正在使用的版本文件名</td>
				  <td style="width: 300px; "><input id="adb_fileBack" type="text" name="fileNameBack" ></td>
			  </tr>
			  
			  <tr><td style="width: 150px; ">待部署版本号</td>
				  <td><input style="width: 300px;" id="c_versionNo" type="text" name="versionNo" /></td>
			  </tr>
			  <tr><td>&nbsp;&nbsp;</td></tr>
			  <tr id="tr_adbfile"><td style="width: 150px;">待部署版本文件</td>
				  <td style="width: 300px; "><input id="adb_file" type="text" name="fileName" ></td>
			  </tr>
			  <tr><td>&nbsp;&nbsp;</td></tr>
			  <tr>
				<td style="width: 150px;">待部署服务器</td>
				<td style="width: 400px;">
					<input type="hidden" name="serversAddress"  id="c_serversAddress"/>
					<div style="width: 400px;height: 60px;overflow: auto;">
					<table id="c_iCode" style="width: 100%">
					</table>
					</div>
				</td>
			  </tr>
			  <tr id="tr_bz"><td style="width: 100px;" ></td><td style="width: 300px; ">注：如待部署版本号为空，表示当前无有效的待发布的adb规则，请先完成版本管理！</td></tr>
			  <tr><td>&nbsp;&nbsp;</td></tr>
		  </table>
		</form>
	</div>
    <div class="modal-footer">
	    <a href="javascript:void(0)" id="uploadFileSubmit" class="btn btn-info" onclick="uploadFileSubmit()"><i class="fa fa-save"></i> 发布</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
    </div> 
    </div>
	
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[2]).addClass("active");
	    });
	</script>
	<script src="resources/js/idpconfig/mqiAdbRuleHotDeploy/MqiAdbRuleDeploy.js"></script>
</body>
</html>