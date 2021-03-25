<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>用户管理</title>
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

<jsp:include page="./../common/header.jsp" flush="true"/>
</head>
<body>
  <div class="container-fluid">
  <ul class="breadcrumb">
 			<li>您当前位置：</li>
 			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
 			<li> <i class="fa fa-globe"></i>系统管理<span class="divider">/</span></li>
 			<li class="active"><i class="fa fa-list-alt"></i> 用户管理</li>
  </ul>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal">
            <div class="control-group">
            <label for="searchUserName" class="control-label">用户名称：</label> 
				 <span class="span3">
				  	<input type="text" id="searchUserName" name="searchUserName" maxlength="100" placeholder="请输用户名称...">
				 </span>
				 
				 <span class="span2">
			      	<button type="button" class="btn btn-info" onclick="doSearch()"><i class="fa fa-search"></i> 查 询</button>
			  	 </span>
			  	 <span class="span2" id="msg_span" style="float:right;width:250px">
			  	 </span>				  
			  </div>

			</form>
	</div>	
				
	</div> 
 	<table id="grid-table"></table>
	<div id="grid-pager"></div>
	
	<div id="userModal" class="modal hide fade">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	    <h3><span id="userTitle" ></span></h3>
	  </div>
	  <div class="modal-body">
		<form id="dataFrom" class="form-horizontal">
			<input type="hidden" id="user_option" name="user_option" value="" />
			 <input id="userId1" type="hidden" name="userId" value="">
		  <table cellpadding="2px">
		  <tr><td style="width: 100px; ">登陆名</td>
		  <td style="width: 300px; "><input id="userId" type="text" name="userId" onblur="repeatUserId()" >
		  <label id="c_usertId" name="error" style="color: red;display: none;" >用户ID已存在</label>
		  </td></tr>
		  <tr>
		  	<td>用户名称</td>
		  	<td>
		  	<input id="userName" type="text" name="userName" onblur="repeatUserName()">
			<label id="c_usertName" name="error" style="color: red;display: none;" >用户名称已存在</label>
		  	</td>
		  </tr>
		   <tr id="spTr"><td>有效状态</td><td>
		  <select id="userStatus" name="userStatus">
		  <option value="1" selected>有效</option>
		  <option value="0">无效</option>
		  </select></td></tr>
		  <tr><td>所属部门</td><td>
		  <select id="depSelect" name="depNo"></select></td></tr>
		  <tr><td>角色</td><td><div id="roleCheckbox" style="padding:10px 0;"></div></td></tr>
		  </table>
		</form>
	  </div>
	  <div class="modal-footer">
	    <a href="javascript:void(0)" id="userSubmit" class="btn btn-info" onclick="userSubmit()"><i class="fa fa-save"></i> 确 定</a>
	    <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
	  </div>
	</div>
	
</body>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';
	 $(function(){
	    	$($("#navbar>li")[5]).addClass("active");
	    });
	</script>
	    <script src="resources/js/user/userPage.js"></script>
</html>