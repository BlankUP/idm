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
<title>adb版本管理</title>
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
 			<li class="active"><i class="fa fa-list-alt"></i> adb版本管理</li>
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
		  <!--版本名称更新  -->
		  <!-- <tr><td style="width: 100px; ">版本名称</td>
		  <td style="width: 300px; "><input id="versionName" type="text" name="versionName" ></td></tr>	 -->
		  <tr><td>版本名称</td>
		  <td style="width: 300px; "><input id="versionName" type="text" name="versionName"></td></tr>

		  	  
		  <tr><td style="width: 100px; ">版本号</td>
		  <td style="width: 300px; "><input id="versionNo" type="text" name="versionNo" ></td></tr>
		  <!-- <tr><td>文件名</td>
		  <td><input id="fileName" type="text" name="fileName" ></td></tr> -->
		  <tr><td>版本描述</td>
		  <td><textarea id="versionDesc" type="text" name="versionDesc" rows="4" ></textarea></td></tr>
		  <tr><td>创建日期</td>
		  <td><input id="createTime" type="text" name="createTime" ></td></tr>
		  <tr><td>创建人</td>
		  <td><input id="createUser" type="text" name="createUser" ></td></tr>
		  <tr><td>修改日期</td>
		  <td><input id="updateTime" type="text" name="updateTime" ></td></tr>
		  <tr><td>修改人</td>
		  <td><input id="updateUser" type="text" name="updateUser" ></td></tr>
		  <tr><td>版本状态</td>
		  <td><select id="versionState" name="versionState">
			  	<option value="0">新版本</option>
				<option value="1">正在使用</option>
				<option value="2">审批通过，待发布</option>
				<option value="3">待一级审批</option>
				<option value="4">待二级审批</option>
				<option value="5">历史版本</option>
				<option value="6">审批未通过</option>
			  </select></td></tr>
		  <tr><td>有效状态</td>
		  <td><select id="isValid" name="isValid">
			  	<option value="1">有效</option>
				<option value="0">无效</option>
			  </select></td></tr>
		  </table>
		</form>		
	</div>
	<div class="modal-footer">
	    <a href="javascript:void(0)" id="modifySubmit" class="btn btn-info" onclick="modifySubmit()"><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	</div>
	</div>
	
	<!--查看详情  -->
	<div id="check_adbVersionModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="check_adbVersionTitle" ></span></h3>
	  </div>
	  <div class="modal-body">	    
		<form id="dataFrom" class="form-horizontal">
			<input type="hidden" id="check_adbVersion_option" name="check_adbVersion_option" value="" />
		  <table cellpadding="2px">
		  <!--版本名称更新  -->
		  <!-- <tr><td style="width: 100px; ">版本名称</td>
		  <td style="width: 300px; "><input id="check_versionName" type="text" name="check_versionName" ></td></tr>	 -->
		  <tr><td>版本名称</td>
		  <td style="width: 300px; "><input id="check_versionName" type="text" name="check_versionName" ></td></tr>
		  
		  	  
		  <tr><td style="width: 100px; ">版本号</td>
		  <td style="width: 300px; "><input id="check_versionNo" type="text" name="check_versionNo" ></td></tr>
		  <!-- <tr><td>文件名</td>
		  <td><input id="fileName" type="text" name="fileName" ></td></tr> -->
		  <tr><td>版本描述</td>
		  <td><textarea id="check_versionDesc" type="text" name="check_versionDesc" rows="4" ></textarea></td></tr>
		  <tr><td>创建日期</td>
		  <td><input id="check_createTime" type="text" name="check_createTime" ></td></tr>
		  <tr><td>创建人</td>
		  <td><input id="check_createUser" type="text" name="check_createUser" ></td></tr>
		  <tr><td>修改日期</td>
		  <td><input id="check_updateTime" type="text" name="check_updateTime" ></td></tr>
		  <tr><td>修改人</td>
		  <td><input id="check_updateUser" type="text" name="check_updateUser" ></td></tr>
		  <tr><td>版本状态</td>
		  <td><select id="check_versionState" name="check_versionState">
			  	<option value="0">新版本</option>
				<option value="1">正在使用</option>
				<option value="2">审批通过，待发布</option>
				<option value="3">待一级审批</option>
				<option value="4">待二级审批</option>
				<option value="5">历史版本</option>
				<option value="6">审批未通过</option>
			  </select></td></tr>
		  <tr><td>有效状态</td>
		  <td><select id="check_isValid" name="check_isValid">
			  	<option value="1">有效</option>
				<option value="0">无效</option>
			  </select></td></tr>
		  </table>
		</form>		
	</div>
	<div class="modal-footer">
	    <a href="javascript:void(0)" id="modifySubmit" class="btn btn-info" data-dismiss="modal"><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	</div>
	</div>
	<!-- <div id="uploadFileModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="uploadFileTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="adbDataFrom" class="form-horizontal" method="post" enctype="multipart/form-data">
		  <table cellpadding="2px">
		  <tr><td style="width: 100px; ">选择文件</td>
		  <td style="width: 300px; "><input id="adb_file" type="file" name="adb_file" ></td></tr>
		  <tr><td>版本描述</td>
		  <td><textarea id="versionDescNew" name="versionDescNew" rows="4" placeholder="请输入版本描述……"></textarea></td></tr>	
		  <tr><td>&nbsp;&nbsp;</td></tr> </table>
		</form>
	</div>
    <div class="modal-footer">
	    <a href="javascript:void(0)" id="uploadFileSubmit" class="btn btn-info" onclick="uploadFileSubmit()"><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
    </div> 
    </div> -->
    
    <div id="uploadFileModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="uploadFileTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="adbDataFrom" class="form-horizontal" method="post" enctype="multipart/form-data">
		  <table cellpadding="2px">
		  <!-- 新增版本名称 -->
		  <tr><td style="width: 100px; ">版本名称</td>
		  <td style="width: 300px; "><input id="c_versionName" type="text" name="c_versionName" onblur="repeatName()">
		  <label id="d_versionName" name="error" style="color: red;display: none;" >版本名称已存在</label>
		  </td></tr>	
		  <tr><td style="width: 100px; ">版本号</td>
		  <td style="width: 300px; "><input id="newVerNo" type="text" name="newVerNo" ></td></tr>
		  <tr><td>版本描述</td>
		  <td><textarea id="versionDesc_add" name="versionDesc" rows="4" placeholder="请输入版本描述……"></textarea></td></tr>	
		  <tr><td></td><td><i>注：新增版本时将自动获取最新的adb版本文件，并生成版本号</i></td></tr> </table>
		</form>
	</div>
    <div class="modal-footer">
	    <a href="javascript:void(0)" id="uploadFileSubmit" class="btn btn-info" onclick="uploadFileSubmit()"><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
    </div> 
    </div>


    
    
    <div id="publishModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="publishTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="publishFrom" class="form-horizontal">
		  <table cellpadding="2px">
		  
		  <tr><td style="width: 100px; ">版本名称</td>
		  <td style="width: 300px; "><input id="publishVersionName" type="text" name="publishVersionName" ></td></tr>
		  <tr><td style="width: 100px; ">申请发布版本号</td>
		  <td style="width: 300px; "><input id="publishVerNo" type="text" name="publishVerNo" ></td></tr>
		  <tr>
			  <td>申请发布理由</td>
			  <td>
				  <textarea id="applicationReason" name="applicationReason" rows="4" placeholder="请输入发布理由或者原因……"></textarea>
				  <input id="descForPublish" type="hidden" name="descForPublish"  />
			  </td>
		  </tr>	
		  </table>
		</form>
	</div>
    <div class="modal-footer">
	    <a href="javascript:void(0)" id="publishFile" class="btn btn-info" onclick="publishFile()" ><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
    </div> 
    </div>
	
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[2]).addClass("active");
	    });
	</script>
	<script src="resources/js/idpconfig/adbVersionManage/adbVersionManage.js"></script>
</body>
</html>