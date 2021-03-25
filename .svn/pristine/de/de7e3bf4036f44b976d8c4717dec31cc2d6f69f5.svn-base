<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>产品维度</title>
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
				<li> <i class="fa fa-globe"></i> 统计分析<span class="divider">/</span></li>
				<li class="active"><i class="fa fa-list-alt"></i> 产品维度</li>
	  </ul>
	  <div class="alert alert-info">
		  <form name="searchForm" class="form-horizontal">
			  <div class="control-group">
				  <label for="productName" class="control-label">产品名称：</label>
				  <span class="span3">
					 <input type="text" id="productName" placeholder="请输入产品名称...">
				  </span>
				  <label for="prodId" class="control-label">产品编码：</label>
				  <span class="span3">
						<input type="text" id="prodId" placeholder="请输入产品编码...">
				  </span>
				  <label class="control-label">查询截止日期：</label>
				  <span class="span3">
					   <input type="text" class="datepicker" placeholder="请选择日期..." id="query_date" value="" name="query_date" format="yyyy-MM-dd" level="D"/>
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
	<%--<div style="width:48%;float: left;">
		<div style="height:250px;height: 350px;" id="main1"></div>
	</div>
	<div style="width:48%;float: left;">
		<div style="height:250px;height: 350px;" id="main2"></div>
	</div>--%>
</div>
<script type="text/javascript">
	var root='<%=request.getContextPath()%>';
	$(function(){
		$($("#navbar>li")[3]).addClass("active");
	});
</script>
</body>
	    <script src="resources/js/statisticalAnalysis/prod_dimension.js"></script>
	    <script src="resources/js/datepicker.js"></script>

</html>