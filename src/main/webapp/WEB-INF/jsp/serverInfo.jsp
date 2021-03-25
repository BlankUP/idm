<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>服务器配置</title>
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

   <jsp:include page="./common/header.jsp" flush="true"/>
</head>
<body>
  <div class="container-fluid">	
  <ul class="breadcrumb">
 			<li>您当前位置：</li>
 			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 			<li> <i class="fa fa-globe"></i> 系统管理<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-cog"></i> 服务器配置</li>
  </ul>
	<div class="alert alert-info">
            <form id ="searchForm" name="searchForm" class="form-horizontal">
            <div class="control-group">
				  <label for="searchServerId" class="control-label">服务器IP：</label> 
				  <span class="span3"> <input type="text" id="searchServerId" name="searchServerId" maxlength="100"  placeholder="请输入服务器IP..."></span>
				  <label for="searchName" class="control-label-5">服务器名称：</label> 
				  <span class="span3"> <input type="text" id="searchName" maxlength="100"  placeholder="请输入服务器名称..." ></span>

				  <span class="span2">
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			  	  </span>
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
						<input id="c_serverId" type="hidden" name="serverId" value="">
						<table cellpadding="2px">
							<tr>
								<td>服务器名称</td>
								<td><input id="c_name"   type="text" name="name"  onblur="repeatServerName()"/>
								<label id="d_name" name="error" style="color: red;display: none;" >服务器名称重复</label></td>
							</tr>
							<tr>
								<td>IP</td>
								<td><input   id="c_ip" type="text" name="ip" /></td>
							</tr>
							<tr>
								<td>端口</td>
								<td><input   id="c_port" type="text" name="port" /></td>
							</tr>
							<tr>
								<td>类型</td>
								<td><select id="c_type"  name="type">
										<option value="1">风控系统服务器</option>
										<option value="2">模型质检服务器</option>
								</select></td>
							</tr>
							<tr>
								<td>F5服务地址</td>
								<td><input id="c_f5Url"  type="text" name="f5Url" /></td>
							</tr>
							<tr>
								<td>服务地址</td>
								<td><input id="c_serverUrl"  type="text" name="serverUrl" /></td>
							</tr>
							<tr>
								<td>状态</td>
								<td><select id="c_status" name="status">
										<option value="0">启用</option>
										<option value="1">停用</option>
								</select></td>
							</tr>
							<tr id="t_createTime">
								<td>创建时间</td>
								<td><input id="c_createTime"  type="text" name="createTime" /></td>
							</tr>
							<tr id="t_createUser">
								<td>创建人</td>
								<td><input id="c_createUser"   type="text" name="createUser"/></td>
							</tr>
							<tr>
								<td>描述</td>
								<td><textarea id="c_remark"   rows="4" name="remark"></textarea></td>
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

<div id="cacheSynchronize" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="uploadFileTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="excelDataFrom" action="UpdFile" enctype="multipart/form-data" method="post">
			 <div >
				 <table cellpadding="2px">
					<tr>
						<td>选择系统</td>
						<td >
							<select id="ca_type" style="width: 315px;" name="type" onchange="getServerName()">
										<option value="1">风控系统服务器</option>
										<option value="2">模型质检服务器</option>
							</select>
						</td>
					</tr>
					<tr>
						<td >选择服务器</td>
						<td >
							<div  style="height: 100px;overflow-y:auto;width: 309px;border-radius: 4px;border: 1px solid #ccc;padding-left: 5px;">
								<span id="server_name" ></span>
							</div>
				 		</td>
					</tr>
				</table>
			 </div>
		</form>
	  </div>
	   <div class="modal-footer">
	    <a href="javascript:void(0)" id="doExcelImportData" class="btn btn-info" onclick="cacheSynchronize();"><i class="fa fa-save"></i>确定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	   </div> 
   </div>

</div>	
</body>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[5]).addClass("active");
	    });
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/serverInfo.js"></script>

</html>