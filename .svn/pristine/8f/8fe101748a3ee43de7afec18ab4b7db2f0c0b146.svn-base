<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>定时任务维护</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/jqgrid/css/ui.jqgrid.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/cgrid.min.css"/>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/datepicker.css"/>

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
<jsp:include page="./common/header.jsp" flush="true" />
<script type="text/javascript">
	var ruleId = ''
	//var matchType = ''
</script>  
</head>
<body>
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li>您当前位置：</li>
			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span
				class="divider">/</span></li>
			<li><i class="fa fa-globe"></i> 系统管理<span class="divider">/</span></li>
			<li class="active"><i class="fa fa-calendar"></i> 定时任务维护</li>
		</ul>
		
		<div class="alert alert-info">
			<form name="searchForm" class="form-horizontal">
				<div class="control-group">
					<label for="searchTaskName" class="control-label">任务名称：</label> 
						<span class="span3"> 
							<input type="text" id="searchTaskName" placeholder="请输入任务名称...">
						</span> 
					<label for="searchTaskGroup" class="control-label">任务组：</label> 
						<span class="span3"> 
							<input type="text" id="searchTaskGroup" placeholder="请输入任务组名称...">
					</span>
				</div>
				<div class="control-group">
					<label for="searchSubTopic" class="control-label">子系统：</label> 
					<span class="span3"> 
						<select id="searchSubSystem" style="width: 225px; height: 30px;">
							<option value="" selected="1">所有类型</option>
							<option value="EMS">营销子系统</option>							
							<option value="MSG">通知子系统</option>
						    <option value="TRANS">交易子系统</option>
						</select>
					</span> 
					<label for="searchState" class="control-label">任务状态：</label> 
					<span class="span3"> 
						<select id="searchState" style="width: 225px; height: 30px;">
							<option value="" selected="1">所有类型</option>
							<option value="0">关闭</option>							
							<option value="1">启用</option>
						</select>
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
					  <tr><td style="width: 160px; ">任务名称</td><td style="width: 300px; "><input id="taskName" type="text" name="base.taskName"></td></tr>
					  <tr><td>任务组名</td><td><input id="taskGroup" type="text" name="base.taskGroup"></td></tr>
					  <tr><td>任务实现类名</td><td><input id="taskClass" type="text" rows="4" name="base.taskClass"></input></td></tr>
					  <tr><td>任务触发时间频次</td><td><input id="triggerTime" type="text" rows="4" name="base.triggerTime"></input></td></tr>
					  <tr><td>所属子系统</td><td><select id="subSystem" name = "base.subSystem" style="width: 300px;">
									<option value="EMS">营销子系统</option>							
									<option value="MSG">通知子系统</option>
									<option value="TRANS">交易子系统</option>
								</select></td></tr>
					  <tr><td>状态</td><td><select id="state" name = "base.state" style="width: 300px;">
									<option value="0">关闭</option>							
									<option value="1">启动</option>
								</select></td></tr>
				      <tr><td>创建日期</td><td><input id="createDate" type="text" name="base.createDate" ></td></tr>
					  <tr><td>创建时间</td><td><input id="createDatetime" type="text" name="base.createDatetime" ></td></tr>
					</table>
					</form>
				  </div>
				  <div class="modal-footer">
				    <a href="javascript:void(0)" id="deleteBtn" class="btn btn-info" onclick="deleteData();"><i class="fa fa-close"></i> 删除</a>
				    <a href="javascript:void(0)" id="saveUpdateBtn" class="btn btn-info" onclick="saveOrUpdateTask();"><i class="fa fa-save"></i> 保存</a>
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
				   <a href="javascript:void(0)" id="syncData" class="btn btn-info" data-dismiss="modal" onclick="syncData();"><i class="fa fa-save"></i>同步</a>
				    <a href="javascript:void(0)" id="closeBtn" class="btn btn-info" data-dismiss="modal" onclick="closeBtn('dataModalServiceMatch');"><i class="fa fa-close"></i> 取 消</a>
				  </div>
			</div>
	</div>
	
	<script type="text/javascript">
		var root='<%=request.getContextPath()%>';
		$(function(){
		    	$($("#navbar>li")[7]).addClass("active");
		});
		
		
	</script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/taskTrigger.js"></script>
	
</body>
</html>