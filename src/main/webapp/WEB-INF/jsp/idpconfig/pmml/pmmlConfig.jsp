<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>PMML模型配置</title>
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
  <div class="container-fluid">	
  <ul class="breadcrumb">
 			<li>您当前位置：</li>
 			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 			<li> <i class="fa fa-globe"></i> 决策服务配置<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-cog"></i> PMML模型配置</li>
  </ul>
	<div class="alert alert-info">
            <form id="searchForm" name="searchForm" class="form-horizontal">
            <div class="control-group">
				  <label for="searchServerId" class="control-label-8">PMML模型名称：</label> 
				  <span class="span3"> <input type="text" id="pmmlName" maxlength="100" placeholder="PMML模型名称..."></span>
				  <label for="searchName" class="control-label-8">PMML模型编号：</label> 
				  <span class="span3"> <input type="text" id="pmmlCode" maxlength="100" placeholder="PMML模型编号..."></span>

				  <span class="span2">
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			  	  </span>
			  </div>
			<div class="pmml"><font class="pmml-font">PMML模型配置</font></div>

			</form>
	</div>	
		
	<table id="grid-table"></table>
	<div id="grid-pager"></div>
	
<div id="slModal">	
	<div id="dataModal" class="modal hide fade" style="width:660px;"  >
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="dataTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="dataFrom" class="form-horizontal">
						<table cellpadding="2px">
							<input type="hidden" id="c_pmmlId" name="pmmlId" value=""/>
							<input type="hidden" id="c_option" name="option" value="">
							<tr>
								<td>PMML模型编号</td>
								<td>
									<input id="c_pmmlCode" type="text" name="pmmlCode" onblur="repeatPmmlCode()">
									<label id="d_pmmlCode" name="error" style="color: red;display: none;" >PMML模型编号已存在</label>
								</td>
							</tr>
							<tr>
								<td>PMML模型名称</td>
								<td>
									<input id="c_pmmlName" type="text" name="pmmlName" onblur="repeatPmmlName()">
									<label id="d_pmmlName" name="error" style="color: red;display: none;" >PMML模型名称已存在</label>
								</td>
							</tr>
							<tr>
								<td>PMML模型描述</td>
								<td>
									<textarea rows="3" id="c_pmmlDesc" name="pmmlDesc" ></textarea>
								</td>
							</tr>
							<tr>
								<td>有效性</td>
								<td>
									<select name="status" id="c_status"  >
										<option value="0">有效</option>
										<option value="1">无效</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>数据源</td>
								<td>
									<input type="hidden" name="interfaceCode"  id="c_interfaceCode"/>
									<div style="width: 520px;height: 130px;overflow: auto;">
										<table id="c_iCode" style="width: 100%">
										</table>
									</div>
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

		<div id="pmmlUpload" class="modal hide fade" style="width: 680px;margin-left: -430px;">
			<div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			    <h3><span >上传PMML文件</span></h3>
			</div>
				<form id="pmmlDataFrom" class="form-horizontal" method="post" enctype="multipart/form-data">
					<div class="modal-body">
					<input type="hidden" id="c_pmmlid" name="pmmlId" value=""/>
						<table cellpadding="2px">
							<tr>
								<td style="width: 100px;">选择文件</td>
								<td style="width: 300px;">
									<input id="file" type="file"name="file">
								</td>
							</tr>
							<tr>
								<td>版本描述</td>
								<td>
									<textarea id="c_versionDesc" name="versionDesc" rows="4" placeholder="请输入版本描述……"></textarea>
								</td>
							</tr>
						</table>
					</div>
				</form>
				<div class="modal-footer">
			  	<a href="javascript:void(0)"  class="btn btn-info" onclick="upload()"><i class="fa fa-save"></i> 确 定</a>
			    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
			</div>
		</div>
		
			<div id="pmmlFile" class="modal hide fade" style="width: 725px;;margin-left: -23%;top:20px">
				<div class="modal-body" >
					<table id="pmmlFile-table"></table>
				</div>
				  <div class="modal-footer">
				   <a href="javascript:void(0)" id="syncData" class="btn btn-info" data-dismiss="modal" onclick="release();">发布</a>
				    <a href="javascript:void(0)" id="closeBtn" class="btn btn-info" data-dismiss="modal" onclick="closeBtn('dataModalServiceMatch');"><i class="fa fa-close"></i> 取 消</a>
				  </div>
			</div>
	
	</div>

</body>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[2]).addClass("active");
	    });
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/idpconfig/pmml/pmmlConfig.js"></script>

</html>