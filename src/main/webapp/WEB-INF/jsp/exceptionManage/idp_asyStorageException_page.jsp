<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>决策服务系统异步存储数据异常信息</title>
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
<script type="text/javascript" src="<%=request.getContextPath()%>/public/datepicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.v1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.message_cn.js"></script>
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
		<li> <i class="fa fa-globe"></i> 决策服务系统异常信息管理<span class="divider">/</span></li>
 		<li class="active"><i class="fa fa-list-alt"></i>决策服务系统异步存储数据异常信息</li>
	</ul>
	 <div class="tab-content">
		 <div class="tab-pane active">
			 <div class="alert alert-info">
				 <form name="searchForm" class="form-horizontal">
					 <div class="control-group-yewu">
					 	<label for="businessNo" class="control-label-5">业务流水号：</label>
						<span class="span3">
							<input type="text" id="businessNo" placeholder="请输入业务流水号...">
						</span>
						<label for="createTime" class="control-label-4">创建时间：</label>
						<span class="span3">
							<input type="text" class="Wdate" id="createTime" onfocus="new WdatePicker(this)" name="out.startDate" />
						</span>
						<span class="span2">
							<button type="button" class="btn btn-info" onclick="doSearch();">
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
	  
	 <div id="busiDetailModal" class="modal hide fade">
		 <div class="modal-header">
		 	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		 	<h3><span id="busiDetail" ></span></h3>
		 </div>
		 <div class="modal-body">
		 	<form id="dataFrom" class="form-horizontal">
		 		<table cellpadding="5px">
				  <tr><td>业务流水号</td><td><textarea style="width: 380px;height: 20px;" id="businessNo2" readonly="readonly" name="businessNo2"></textarea></td></tr>
				  <tr><td>sql详情</td><td><textarea style="width: 380px;height: 120px;"  id="sqlDetail"  name="sqlDetail"></textarea></tr>
				  <tr><td>数据内容</td><td><textarea style="width: 380px;height: 120px;"  id="dataContent"  name="dataContent"></textarea></td></tr>
			    </table>
			</form>
		</div>
		<div class="modal-footer">
			<a href="javascript:void(0)" id="closeBtn" class="btn btn-info" data-dismiss="modal" onclick="closeBtn('dataModalServiceMatch');">关闭</a> 
		</div>
	</div>
 </div>
 <script type="text/javascript">
 	var root='<%=request.getContextPath()%>';
 	$(function(){
		$($("#navbar>li")[5]).addClass("active");
	});
 </script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/datepicker.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/exceptionManage/idp_asyStorageException_page.js"></script>
</body>
</html>