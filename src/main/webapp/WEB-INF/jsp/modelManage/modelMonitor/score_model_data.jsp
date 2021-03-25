<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>评分模型数据监控</title>
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
	<style>
		th.ui-th-column div{
			white-space:normal !important;
			height:auto !important;
		}
		/*.ui-jqgrid-btable td {
			white-space:normal !important;
			height:auto !important;
		}*/
	</style>
   <jsp:include page="/WEB-INF/jsp/common/header.jsp" flush="true"/>
</head>
<body>
  <div class="container-fluid">	
	  <ul class="breadcrumb">
				<li>您当前位置：</li>
				<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
				<li> <i class="fa fa-globe"></i> 模型管理<span class="divider">/</span></li>
		  		<li> <i class="fa fa-globe"></i> 模型监控<span class="divider">/</span></li>
				<li class="active"><i class="fa fa-list-alt"></i> 评分模型数据监控</li>
	  </ul>
	  <div class="alert alert-info">
		  <form name="searchForm" class="form-horizontal">
			  <div class="control-group">
				  <label for="querySeqNo" class="control-label">业务流水号：</label>
				  <span class="span3">
					  <input type="text" id="querySeqNo" placeholder="请输入业务流水号...">
				  </span>
				  <label for="custName" class="control-label">客户姓名：</label>
				  <span class="span3">
					  <input type="text" id="custName" placeholder="请输入客户姓名...">
				  </span>
				  <%--<label for="prodId" class="control-label">产品编号：</label>
				  <span class="span3">
					  <input type="text" id="prodId" placeholder="请输入产品编号...">
				  </span>--%>
				  <%--<label for="modleName" class="control-label">模型名称：</label>
				  <span class="span3">
						<input type="text" id="modleName" placeholder="请输入模型名称...">
				  </span>--%>
				  <label for="certNum" class="control-label">证件号：</label>
				  <span class="span3">
						<input type="text" id="certNum" placeholder="请输入证件号...">
				  </span>
				  <span class="span2">
						<button type="button" class="btn btn-info" onclick="doSearch()">
							<i class="fa fa-search"></i> 查 询
						</button>
				  </span>
			  </div>
			  <div class="control-group">
				  <label class="control-label"></label>
				  <span class="span3">
						<%--<input type="text" id="modleName" placeholder="请输入模型名称...">--%>
				  </span>
				  <label class="control-label"></label>
				  <span class="span3">

				  </span>
				  <label class="control-label"></label>
				  <span class="span3">

				  </span>
				  <span class="span2">
						<button type="button" class="btn btn-info" onclick="doExport()">
							<i class="fa fa-file-excel-o"></i> 导 出
					    </button>
				  </span>
			  </div>
		  </form>
	  </div>
	  <table id="grid-table"></table>
	  <table id="grid-pager"></table>
  </div>
  <div id="duModal" class="modal hide fade" role="dialog" style="width:650px;">
	  <div class="modal-dialog" role="document">
		  <div class="modal-content">
			  <div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal"
						  aria-hidden="true">&times;</button>
				  <h4 class="modal-title">
					  <span id="dataTitle">查看评分明细</span>
				  </h4>
			  </div>
			  <div class="modal-body">
				  <table id="detail" border="1" style="text-align:center;width: 100%;">
				  </table>
			  </div>

			  <div class="modal-footer">
				  <a href="javascript:void(0)" id="du_submit" class="btn btn-info"
					 onclick="duSubmit()"><i class="fa fa-save"></i> 确 定</a>
				  <a href="javascript:void(0)" id="du_cancel" class="btn btn-info"
					 data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
			  </div>
		  </div>
	  </div>
  </div>
<script type="text/javascript">
	var root='<%=request.getContextPath()%>';
	$(function(){
		$($("#navbar>li")[4]).addClass("active");
	});
</script>
</body>
	    <script src="<%=request.getContextPath()%>/resources/js/modelManage/modelMonitor/score_model_data.js"></script>
	    <script src="<%=request.getContextPath()%>/resources/js/datepicker.js"></script>

</html>