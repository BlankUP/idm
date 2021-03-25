<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>模型质检模型规则配置</title>

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
 			<li> <i class="fa fa-globe"></i> 决策引擎配置<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i>模型质检模型规则配置</li>
  </ul>
  </div>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
            <div class="control-group">
				  <label for="searchParaEn" class="control-label">模型编码：</label> 
				  <span class="span3"> <input type="text" id="searchParaEn" maxlength="100" placeholder="请输入模型编码..."></span>
				  <label for="searchParaCh" class="control-label-6">模型名称：</label> 
				  <span class="span3"> <input type="text" id="searchParaCh" maxlength="100" placeholder="请输入模型名称..."></span>
				  <span class="span2">
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			  	  </span>
			  </div>
			  <div class="shangyoucanshupeizhi"><font class="shangyoucanshupeizhi-font">模型质检模型规则配置</font></div>
			</form>
	</div>	
	<table id="grid-table"></table>
	<div id="grid-pager"></div>
    
    <div id="uploadFileModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="uploadFileTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="excelDataFrom" action="UpdFile" enctype="multipart/form-data" method="post">
			 <div >
				 <table cellpadding="2px">
					<tr>
						<td style="width: 100px;">选择文件</td><td style="width: 300px;">
							&nbsp;&nbsp;<input id="file" type="file" name="file">
						</td>
					</tr>
				</table>
			  	<br/>
			  	<p style="font-size:20px;color:red;" >注意事项：</p>
			 </div>
			 
			  <div style="width: 500px; font-size:14px;color:red;">
			  		<p>&nbsp;&nbsp;&nbsp;&nbsp;1、请先下载Excel模板（ruleModel.xlsx）；</p> 
			  		<p>&nbsp;&nbsp;&nbsp;&nbsp;2、然后在模型规则模板.xlsx文件上填写信息（每条数据5列信息都必填）；</p>
			  		<p>&nbsp;&nbsp;&nbsp;&nbsp;3、最后导入模型规则模板.xlsx文件。</p> 
			  		<p>&nbsp;&nbsp;&nbsp;&nbsp;特别注意：请将每个模型按照引擎上配置模型规则顺序排列。</p> 
			 </div>
		</form>
	  </div>
	   <div class="modal-footer">
	    <a href="javascript:void(0)" id="doExportSubmit" class="btn btn-info" onclick="doExportSubmit();"><i class="fa fa-save"></i> 导出Excel模板</a>
	    <a href="javascript:void(0)" id="doExcelImportData" class="btn btn-info" onclick="doExcelImportData();"><i class="fa fa-save"></i> 导入</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	   </div> 
   </div>
   <!-- 导入excel后，页面展示信息 -->
	<div id="importExcelDataResultDetail" class="modal hide fade">
		<div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="importExcelDataResultDetailTitle" ></span></h3>
	    <div id="importExcelDataResultContent" class="modal-body"></div>
	  </div>
    </div>
    
	<div id="dataModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="dataTitle"></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="dataFrom" class="form-horizontal">
		  <input type="hidden" id="c_option" name="option" value=""/>
		  <table cellpadding="2px">
			  <tr hidden="true">
			  	<td style="width: 150px; ">唯一标识ID</td>
			  	<td><input style="width: 220px;" type="text" id="c_mtrid" type="text" name="mtrid" /></td>
			  </tr>
			  <tr>
			  	<td style="width: 150px;">规则序号</td>
			  	<td><input style="width: 220px;" type="text" id="c_seqno"  name="seqno" />
			  	</td>
			  </tr>
			  <tr>
			  	<td>模板编码</td>
			  	<td><input style="width: 220px;" type="text" id="c_modelcode" name="modelcode" />
			  	</td>
			  </tr>	  
			  <tr>
			  	<td>模板名称</td>
			  	<td><input style="width: 220px;" type="text" id="c_modelname" name="modelname" />
			  	</td>
			  </tr>	  
			  <tr>
			  	<td>规则编码</td>
			  	<td><input style="width: 220px;" type="text" id="c_rulecode" name="rulecode" />
			  	</td>
			  </tr>	  
			  <tr>
			  	<td>规则名称</td>
			  	<td><input style="width: 220px;" type="text" id="c_rulename" name="rulename" />
			  	</td>
			  </tr>	  
	 		  <tr>
	 		  	<td>规则类型</td>
	  		  	<td>
					<select id="c_ruletype" name = "ruletype" style="width: 235px;">
						<option value="1">拒绝规则类型</option>
						<option value="2">评分规则类型</option>
					</select>
				</td>
			  </tr>
	  		  <tr id="tr_createtime">
	  		  	<td>创建时间</td>
	  		  	<td><input style="width: 220px;" type="text"  id="c_createtime"  name="createtime" /></td>
	  		  </tr>
			  <tr id="tr_createuser">
			  	<td>创建人</td>
			  	<td><input style="width: 220px;"type="text"  id="c_createuser"  name="createuser" /></td>
			  </tr>
	  		  <tr>
	  		  	<td>状态</td>
	  		  	<td>
					<select  id="c_status" name = "status" style="width: 235px;">
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


</body>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[2]).addClass("active");
	    });
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/idpconfig/mqiModelRule/mqiModelRule.js"></script>

</html>
