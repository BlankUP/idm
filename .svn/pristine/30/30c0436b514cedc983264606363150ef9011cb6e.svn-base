<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>异常基础数据</title>

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
 			<li class="active"><i class="fa fa-list-alt"></i> 异常基础信息</li>
  </ul>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
            <div class="control-group">
				  <label for="searchErrCode" class="control-label">异常编号：</label> 
				  <span class="span3"> <input type="text" id="searchErrCode"  placeholder="请输入异常编号..."></span>
				  <label for="searchErrMsg" class="control-label">异常信息：</label> 
				  <span class="span3"> <input type="text" id="searchErrMsg"  placeholder="请输入异常信息..."></span>

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
		  <table cellpadding="2px">
		  <input type="hidden" id="c_option" name="option" value="">
		  <tr><td style="width: 150px; ">异常编号</td><td style="width: 300px; "><input id="c_errCode" type="text" name="errCode"  ></td></tr>
		  <tr><td>异常信息</td><td><textarea id="c_errMsg" rows="4"  name="errMsg" ></textarea></td></tr>
		  <tr><td>异常原因</td><td><textarea id="c_reasonMsg"  rows="4"  name="reasonMsg" ></textarea></td></tr>
		  <tr><td>解决方案</td><td><textarea id="c_solutionMsg" rows="4"  name="solutionMsg" ></textarea></td></tr>
		  </table>
		</form>
	  </div>
	  <div class="modal-footer">
	    <a href="javascript:void(0)" id="saveUpdateBtn" class="btn btn-info" onclick="saveOrUpdate()"><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	  </div>
	</div>
</div>
 <div id="slModalServiceMatch">	
			<div id="dataModalServiceMatch" class="modal hide fade" style="width: 60%;margin-left: -430px;top:20px">
				<div class="modal-body" >
					<table id="gridService-table"></table>
				</div>
				  <div class="modal-footer">
				   <a href="javascript:void(0)" id="syncData" class="btn btn-info" data-dismiss="modal" onclick="syncData();">同步</a>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/exceptionBase.js"></script>

</html>
