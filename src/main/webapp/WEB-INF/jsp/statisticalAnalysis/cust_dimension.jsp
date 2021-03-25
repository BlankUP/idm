<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>客户维度</title>
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
				<li class="active"><i class="fa fa-list-alt"></i> 客户维度</li>
	  </ul>
	  <div class="alert alert-info">
		  <form name="searchForm" class="form-horizontal">
			  <div class="control-group">
				  <label for="customName" class="control-label">客户姓名：</label>
				  <span class="span3">
						<input type="text" id="customName" placeholder="请输入客户姓名...">
				  </span>
				  <label for="paperType" class="control-label">证件类型：</label>
				  <span class="span3">
						<select id="paperType">
							 <option value=""></option>
						   <option value="01">身份证</option>
					   </select>
				  </span>
				  <label for="paperNo" class="control-label">证件号码：</label>
				  <span class="span3">
					 <input type="text" id="paperNo" placeholder="请输入证件号码...">
				  </span>
			  </div>
			  <div class="control-group">
				  <label for="riskLevel" class="control-label">风险等级：</label>
				  <span class="span3">
					 <select id="riskLevel">
						 <option value=""></option>
						 <option value="1">一级</option>
						 <option value="2">二级</option>
						 <option value="3">三级</option>
					 </select>
				  </span>
				  <label for="modelName" class="control-label">模型名称：</label>
				  <span class="span3">
					  <input type="text" id="modelName" placeholder="请输入模型名称...">
				  </span>
				  <label for="modelCode" class="control-label">模型编码：</label>
				  <span class="span3">
					  <input type="text" id="modelCode" placeholder="请输入模型编码...">
				  </span>
			  </div>
			  <div class="control-group">
				  <label for="productName" class="control-label">产品名称：</label>
				  <span class="span3">
					 <input type="text" id="productName" placeholder="请输入产品名称...">
				  </span>
				  <label for="productCode" class="control-label">产品编码：</label>
				  <span class="span3">
						<input type="text" id="productCode" placeholder="请输入产品编码...">
				  </span>
				  <label class="control-label">预警日期：</label>
				  <span class="span3" style="width:120px;">
					   <input type="text" class="datepicker" placeholder="请选择日期..." id="beginDate" value="" format="yyyy-MM-dd" level="D"/>
				  </span>
				  <span class="span3" style="width:20px;padding: 5px;">
					   至
				  </span>
				  <span class="span3" style="width:120px;">
					   <input type="text" class="datepicker" placeholder="请选择日期..." id="endDate" value="" format="yyyy-MM-dd" level="D"/>
				  </span>
			  </div>
			  <div class="control-group">
				  <label for="sourceSystem" class="control-label">来源系统：</label>
				  <span class="span3">
					 <input type="text" id="sourceSystem" placeholder="请输入来源系统...">
				  </span>
				  <label for="receiveSystem" class="control-label">接收系统：</label>
				  <span class="span3">
						<input type="text" id="receiveSystem" placeholder="请输入接收系统...">
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
  <div class="row-fluid" style="margin-top:20px">
	  <!--<center><img src="resources/images/target.png" /> </center>-->
	  <!-- <div style="height:500px;" class="span12" id="hourTrade">
      </div> -->
	  <div style="width:70%;float: left;">
		  <div style="height:700px;weight: 1500px;" id="custdimension"></div>
	  </div>
  </div>
<script type="text/javascript">
	var root='<%=request.getContextPath()%>';
	$(function(){
		$($("#navbar>li")[3]).addClass("active");
	});
</script>
</body>
	    <script src="resources/js/statisticalAnalysis/cust_dimension.js"></script>
	    <script src="resources/js/datepicker.js"></script>

</html>