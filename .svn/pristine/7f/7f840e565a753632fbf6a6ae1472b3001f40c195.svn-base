<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>指标统计</title>
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

<script src="<%=request.getContextPath()%>/public/echarts/js/echarts.js"></script>

   <jsp:include page="/WEB-INF/jsp/common/header.jsp" flush="true"/>
</head>
<body>
  <div class="container-fluid">	
	  <ul class="breadcrumb">
				<li>您当前位置：</li>
				<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
				<li> <i class="fa fa-globe"></i> 模型管理<span class="divider">/</span></li>
				<li class="active"><i class="fa fa-list-alt"></i> 指标监控</li>
	  </ul>
	  <div class="alert alert-info">
		  <form name="searchForm" class="form-horizontal">
			  <div class="control-group">
				  <label for="ruleNo" class="control-label">规则编号：</label>
				  <span class="span3">
								<input type="text" id="ruleNo" placeholder="请输入规则编号...">
							</span>
				  <label for="modleName" class="control-label">模型名称：</label>
				  <span class="span3">
								<input type="text" id="modleName" placeholder="请输入模型编号...">
						</span>
				  <label for="productNo" class="control-label">产品编号：</label>
				  <span class="span3">
								<input type="text" id="productNo" placeholder="请输入产品编号...">
						</span>
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
<div class="row-fluid" style="margin-top:10px">
	<!--<center><img src="resources/images/target.png" /> </center>-->
        <!-- <div style="height:500px;" class="span12" id="hourTrade">
        </div> -->
	<div style="width:100%;float: left;">
		<div style="height:600px;" id="main1"></div>
	</div>
	<div style="width:100%;float: left;">
		<div style="height:600px;" id="main2"></div>
	</div>
</div>
<script type="text/javascript">
	var root='<%=request.getContextPath()%>';
	$(function(){
		$($("#navbar>li")[4]).addClass("active");
	});
</script>
</body>
	    <script src="<%=request.getContextPath()%>/resources/js/modelManage/indexMonitor/indexManage.js"></script>
	    <script src="<%=request.getContextPath()%>/resources/js/datepicker.js"></script>

</html>