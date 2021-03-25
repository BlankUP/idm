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

<title>模型质检线程池参数配置</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/jqgrid/css/ui.jqgrid.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/cgrid.min.css"/>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.v1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.validate.message_cn.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/i18n/grid.locale-cn.js"></script>

<jsp:include page="./common/header.jsp" flush="true" />
</head>

<body>
	<div class="container-fluid">
		<ul class="breadcrumb">
			<li>您当前位置：</li>
			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span
				class="divider">/</span></li>
			<li><i class="fa fa-globe"></i> 系统管理<span class="divider">/</span></li>
			<li class="active"><i class="fa fa-list-alt"></i> 模型质检线程池参数配置</li>
		</ul>

		<div class="alert alert-info">
			<form name="searchForm" class="form-horizontal">
				<div class="control-group">
					<label for="searchDataCode" class="control-label">参数编号：</label> 
						<span class="span3"> 
							<input type="text" id="searchDataCode" maxlength="100" placeholder="请输入参数编号...">
						</span> 
					<label for="searchParamName" class="control-label">参数名称：</label> 
						<span class="span3"> 
							<input type="text" id="searchParamName" maxlength="100" placeholder="请输入参数名称...">
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
		<div id="grid-pager"></div>

		<div id="slModal">
			<div id="dataModal" class="modal hide fade">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3>
						<span id="dataTitle"></span>
					</h3>
				</div>
				<div class="modal-body">
					<form id="dataFrom" class="form-horizontal">
						<input type="hidden" id="c_option" name="option" value="">
						<table id="p">
							 <tr>
								<td style="width: 150px; height: 30px;">参数类型</td>
								<td style="width: 300px; height: 30px;"><input id="type" type="text" name="base.type" value=""></td>
							</tr>
							<tr>
								<td>参数名称</td>
								<td>
									<input id="paramName" type="text" name="paramName" value="" onblur="repeatparamName()" />
		  							<label id="c_paramName" name="error" style="color: red;display: none;" >参数名称已存在</label>
		  						</td>
							</tr>			
							<tr>
								<td>参数编号</td>
								<td><input id="paramCode" type="text" name="base.paramCode"
									value=""></td>
							</tr>
							<tr>
								<td>参数值</td>
								<td><input id="paramValue" type="text" name="base.paramValue"
									value="" ></td>
							</tr>
							<tr>
								<td>参数描述</td>
								<td><textarea id="paramDesc"  rows="4" name="paramDesc" ></textarea></td>
							</tr>
							 <tr id="spTr">
								<td>创建时间</td>
								<td><input id="createTime" type="text" 
									name="base.createTime" /></td>
							</tr>
							<tr id="spTr1">
								<td>创建人</td>
								<td><input id="createUser" type="text" 
								name="base.createUser"/></td>
							</tr>
							<tr id="spTr2">
								<td>修改时间</td>
								<td><input id="updateTime" type="text" 
									name="base.updateTime" /></td>
							</tr>
							<tr id="spTr3">
								<td>修改人</td>
								<td><input id="updateUser" type="text" 
								name="base.updateUser"/></td>
							</tr> 
							<tr>
								<td>参数状态</td>							
								<td>
								<select id="status" name = "base.status" style="width: 248px; height: 30px;">
									<option value="0">有效</option>
								</select>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<a href="javascript:void(0)" id="saveUpdateBtn"
						class="btn btn-info" onclick="saveOrUpdate()"><i
						class="fa fa-save"></i> 确 定</a> <a href="javascript:void(0)"
						id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i
						class="fa fa-close"></i> 取 消</a>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[5]).addClass("active");
	    });
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/mqibasicDataConfig.js"></script>
   	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/RTAUtil.js"></script>
	
    
</body>
</html>