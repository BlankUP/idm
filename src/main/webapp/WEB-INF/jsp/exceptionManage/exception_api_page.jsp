<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>API异常数据</title>
<link rel="icon" href="../../favicon.ico">

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">
    
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/jqgrid/css/ui.jqgrid.css" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/cgrid.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/datepicker.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/datalist.css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/i18n/grid.locale-cn.js"></script>
 <style>
  	#icons {
		margin: 0;
		padding: 0;
	}
	#icons li {
		margin: 2px;
		position: relative;
		padding: 4px 0;
		cursor: pointer;
		float: left;
		list-style: none;
	}
	#icons span.ui-icon {
		float: left;
		margin: 0 4px;
	}
  </style>
	<style>
		th.ui-th-column div{
			white-space:normal !important;
			height:auto !important;
		}
		.ui-jqgrid-btable td {
			white-space:normal !important;
			height:auto !important;
		}
	</style>
   <jsp:include page="/WEB-INF/jsp/common/header.jsp" flush="true"/>
</head>
<body>
 <div class="container-fluid">
 	<ul class="breadcrumb">
		<li>您当前位置：</li>
		<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span
			class="divider">/</span></li>
		<li class="active"><i class="fa fa-list-ol"></i> 异常管理</li>
	</ul>
	 <ul class="nav nav-tabs" id="tab-menu">
		 <li><a href="#" class="active">API异常数据</a></li>
		 <li><a href="#" onclick="gopage();">决策异常数据</a></li>
	 </ul>
	 <div class="tab-content">
		 <div class="tab-pane active">
			 <div class="alert alert-info">
				 <form name="searchForm" class="form-horizontal">
					 <div class="control-group">
						 <label for="querySeqNo" class="control-label">流水号：</label>
						 <span class="span3">
							<input type="text" id="querySeqNo" placeholder="请输入流水号...">
						</span>
						 <%--<label for="certNum" class="control-label">证件号：</label>
						 <span class="span3">
							<input type="text" id="certNum" placeholder="请输入证件号...">
						</span>--%>
						 <span class="span2">
							<button type="button" class="btn btn-info" onclick="doSearch()">
								<i class="fa fa-search"></i> 查 询
							</button>
						</span>
					 </div>
				 </form>
			 </div>
			 <table id="grid-table"></table>
			 <table id="grid-pager"></table>
		 </div>
	 </div>
 </div>
 <script type="text/javascript">
		var root='<%=request.getContextPath()%>';
		$(function(){
		    	 $($("#navbar>li")[6]).addClass("active");
		});

        $('#tab-menu a:first').tab('show');

        function gopage() {
			location.href="<%=request.getContextPath()%>/exception_ruleengine_page";
        }
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/datepicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/exceptionManage/exception_api_page.js"></script>
</body>
</html>