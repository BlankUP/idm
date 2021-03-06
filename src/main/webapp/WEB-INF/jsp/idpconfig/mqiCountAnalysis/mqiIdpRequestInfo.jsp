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
<title>客户申请信息</title>
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
 			<li> <i class="fa fa-globe"></i> 统计分析<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-cog"></i>客户申请信息</li>
  </ul>
	<div class="alert alert-info" >
            <form id="searchForm" name="searchForm" class="form-horizontal">
            <div class="control-group">
				  <label for="JnlNo" class="control-label-6">贷款号：</label> 
				  <span class="span3"> <input type="text" id="JnlNo" maxlength="100" placeholder="贷款号..."></span>
				 <!--  <label for="businessNo" class="control-label-9">业务流水号：</label> 
				  <span class="span3"> <input type="text" id="businessNo" maxlength="100" placeholder="业务流水号..."></span> -->
				 <label for="cifName" class="control-label-4" >客户名称：</label> 
				 <span class="span3"> <input type="text" id="cifName" maxlength="100" placeholder="客户名称..."></span>
				 <label for="idNo" class="control-label-4">证件号码：</label> 
				 <span class="span3"> <input type="text" id="idNo" maxlength="100" placeholder="证件号码..."></span>
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			 </div>
			</form>
	</div>
	
	
		
	<table id="grid-table"></table>
	<div id="grid-pager"></div>
	
<div id="slModal">	
	<div id="dataModal" class="modal hide fade" style=""  >
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="dataTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		           <form id="dataFrom" class="form-horizontal">
					  <table cellpadding="2px">
	
						   <tr><td></td> 
						  <td><textarea id="messAge" type="text" name="messAge" rows="20" style="width: 500px;height: 300px"  ></textarea></td></tr>

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
			    <h3><span >请求数据信息</span></h3>
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
	    	$($("#navbar>li")[7]).addClass("active");
	    });
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/idpconfig/mqiCountAnalysis/mqiIdpRequestInfo.js"></script>

</html>