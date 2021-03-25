<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>上游参数管理</title>

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
 			<li> <i class="fa fa-globe"></i> 上游对接配置<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i> 上游参数管理</li>
  </ul>
  </div>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
            <div class="control-group">
				  <label for="searchParaEn" class="control-label">参数字段：</label> 
				  <span class="span3"> <input type="text" id="searchParaEn" maxlength="100" placeholder="请输入参数字段..."></span>
				  <label for="searchParaCh" class="control-label-6">参数名称中文：</label> 
				  <span class="span3"> <input type="text" id="searchParaCh" maxlength="100" placeholder="请输入参数名称中文..."></span>
				  <span class="span2">
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			  	  </span>
			  </div>
			  <div class="shangyoucanshupeizhi"><font class="shangyoucanshupeizhi-font">上游参数配置</font></div>
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
			 
			  <div style="width: 350px; font-size:14px;color:red;">
			  		<p>&nbsp;&nbsp;&nbsp;&nbsp;1、请先下载Excel模板（字段信息模板.xlsx）；</p> 
			  		<p>&nbsp;&nbsp;&nbsp;&nbsp;2、然后在字段信息模板.xlsx文件上填写数据；</p>
			  		<p>&nbsp;&nbsp;&nbsp;&nbsp;3、最后导入字段信息模板.xlsx文件。</p> 
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
			  	<td><input style="width: 220px;" type="text" id="c_fieldid" type="text" name="fieldid" /></td>
			  </tr>
			  <tr>
			  	<td style="width: 150px;">参数字段</td>
			  	<td><input style="width: 220px;" type="text" onblur="checkIsEnExists()"  id="c_parameterfields"  name="parameterfields" />
			  	<label id="d_parameterfields" name="error" style="color: red;display: none;" >参数字段已存在</label>
			  	</td>
			  </tr>
			  <tr>
			  	<td>参数名称-中文</td>
			  	<td><input style="width: 220px;" type="text" onblur="checkIsChExists()" id="c_parameternamech" name="parameternamech" />
			  	<label id="d_parameternamech" name="error" style="color: red;display: none;" >参数名称-中文已存在</label>
			  	</td>
			  </tr>	  
	 		  <tr>
	 		  	<td>参数类型</td>
	  		  	<td>
					<select id="c_parametertype" name = "parametertype" style="width: 235px;">
						<option value="int">整数型</option>
						<option value="double">小数型</option>
						<option value="string">字符型</option>
						<option value="date">日期（时间）型</option>
					</select>
				</td>
			  </tr>
			  <tr id="tr_createuser">
			  	<td>创建人</td>
			  	<td><input style="width: 220px;"type="text"  id="c_createuser"  name="createuser" /></td>
			  </tr>
	  		  <tr id="tr_createtime">
	  		  	<td>创建时间</td>
	  		  	<td><input style="width: 220px;" type="text"  id="c_createtime"  name="createtime" /></td>
	  		  </tr>
	  		  <tr id="tr_updateuser">
	  		  	<td >修改人</td>
	  		  	<td><input  style="width: 220px;" type="text"  id="c_updateuser"  name="updateuser" /></td>
	  		  </tr>
	  		  <tr id="tr_updatetime">
	  		  	<td>修改时间</td>
	  		  	<td><input style="width: 220px;" type="text"  id="c_updatetime"  name="updatetime" /></td>
	  		  </tr>
	  		  <tr>
	  		  	<td>状态</td>
	  		  	<td>
					<select onchange="checkIsUsed()" id="c_status" name = "status" style="width: 235px;">
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
	    	$($("#navbar>li")[1]).addClass("active");
	    });
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/idpconfig/proModelParaConfig/paraInfoConfig.js"></script>

</html>
