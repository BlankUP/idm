<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>接口调用监控</title>
<link rel="icon" href="../../favicon.ico">

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">
    
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/jqgrid/css/ui.jqgrid.css" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/cgrid.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
<%--<script type="text/javascript" src="<%=request.getContextPath()%>/public/datepicker/WdatePicker.js"></script>--%>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.v1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.message_cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/i18n/grid.locale-cn.js"></script>

<jsp:include page="./../common/header.jsp" flush="true"/>
</head>
<body>
	<div class="container-fluid">
 	 <ul class="breadcrumb">
 		<li>您当前位置：</li>
 		<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 		<li> <i class="fa fa-globe"></i>系统性能监控<span class="divider">/</span></li>
 		<li class="active"><i class="fa fa-list-alt"></i> 接口调用监控</li>
 	 </ul>
		<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
            <div class="control-group">
				<label for="searchImpl" class="control-label">接口名称 : </label> 
				 <span class="span3">
				  	<input type="text" id="searchImpl" maxlength="100" placeholder="请输入接口名称...">
				 </span>
				<label for="searchStatus" class="control-label">统计周期 : </label>
				<span class="span3">
			  		<select id="searchStatus" >
						<option value="0" selected="1">日</option>
						<option value="1">月</option>
						<option value="2">年</option>
					</select> 
			   	 </span>
				 <span class="span2">
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			  	 </span>			  
			  </div>
			  <div class="control-group">
				  <label for="startDate" class="control-label">开始日期: </label>
			  	 <span class="span3">
			  	 	<input type="text" class="Wdate" id
							="startDate" onfocus="WdatePicker({lang:'zh-cn'})"
			  	 		placeholder="请选择开始日期..." name="startDate" />
<%--					 <input type="text" id="d242" onclick="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm:ss',lang:'zh-cn'})" class="Wdate"/>--%>
			  	 </span>
			  	 <label for="endDate" class="control-label">结束日期: </label>
			  	 <span class="span3">
			  	 	<input type="text" class="Wdate" id="endDate" onfocus="WdatePicker({lang:'zh-cn'})"
			  	 		placeholder="请选择结束日期..." name="endDate" />
			  	 </span>
			  </div>
			</form>
		</div>				
	</div>
	<table id="grid-table"></table>
	<div id="grid-pager"></div>
	
	<div id="implSearch" class="modal hide fade" style="width: 790px;;margin-left: -23%;top:20px">
		<div class="modal-body" >
			<table id="implSearch-table"></table>
			<div id="implSearch-pager"></div>
		</div>
		<div class="modal-footer">
		    <a href="javascript:void(0)" id="closeBtn" class="btn btn-info" data-dismiss="modal" onclick="closeBtn('dataModalServiceMatch');"><i class="fa fa-close"></i> 取 消</a>
  	    </div>
	</div>
</body>
	<script type="text/javascript">
		 var root='<%=request.getContextPath()%>';
		 $(function(){
		   	$($("#navbar>li")[4]).addClass("active");
		 });
		</script>
    <script src="resources/js/control/implTransfer.js"></script>
</html>