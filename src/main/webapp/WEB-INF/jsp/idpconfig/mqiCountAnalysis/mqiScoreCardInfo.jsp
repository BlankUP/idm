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
<title>评分卡信息</title>
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
 			<li class="active"><i class="fa fa-cog"></i> 模型质检评分卡模型</li>
  </ul>
	<div class="alert alert-info" style="height: 40px" >
            <form id="searchForm" name="searchForm" class="form-horizontal">
            <div class="control-group">
				  <label for="jnlNo" class="control-label-4">贷款号：</label> 
				  <span class="span3"> <input type="text" id="jnlNo" maxlength="100" placeholder="贷款号..."></span>
				   <label for="modelCode" class="control-label-4">模型编码：</label> 
				  <span class="span3"> <input type="text" id="modelCode" maxlength="100" placeholder="模型编码..."></span>
				 <label for="cifName" class="control-label-4">客户名称：</label> 
				 <span class="span3"> <input type="text" id="cifName" maxlength="100" placeholder="客户名称..."></span>
				 <label for="idNo" class="control-label-4">证件号码：</label> 
				 <span class="span3"> <input type="text" id="idNo" maxlength="100" placeholder="证件号码..."></span>
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			 </div>
			</form>
	</div>	
		
	<table id="grid-table"></table>
	<div id="grid-pager"></div>
	</div>
	<div id="slModal">	
	<div id="dataModal" class="modal hide fade" style="width:530px;padding: 10px;">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="dataTitle" ></span></h3>
	  </div>
	  <table id="grid-table1"></table>
	  <div id="grid-pager1"></div>
	</div>
	</div>

</body>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[7]).addClass("active");
	    });
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/idpconfig/mqiCountAnalysis/mqiScoreCardInfo.js"></script>

</html>