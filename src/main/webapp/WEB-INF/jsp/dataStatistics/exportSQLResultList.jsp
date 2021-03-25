<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>手动数据查询</title>
<link rel="icon" href="../../favicon.ico">

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">
    
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/public/jqgrid/css/ui.jqgrid.css" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/cgrid.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/jquery.jqGrid.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/public/jqgrid/js/i18n/grid.locale-cn.js"></script>

	<jsp:include page="/WEB-INF/jsp/common/header.jsp" flush="true"/>
</head>
<body>
  <div class="container-fluid">	
    <ul class="breadcrumb">
 			<li>您当前位置：</li>
      			<li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
      			<li> <i class="fa fa-video-camera"></i> 数据统计<span class="divider">/</span></li>
      			<li class="active"><i class="fa fa-area-chart"></i> 手动数据查询</li>
    </ul>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal" id ="searchForm">
            	<!-- 
            	<select name = "dataSource">
            		<option value="ds1">数据源1</option>
            		<option value="ds2">数据源2</option>
            		<option value="ds3">数据源3</option>
            	</select>
            	 -->
            	<input type="hidden" id ="op" name="op"/>
            	<table maxColumn='2' cellpadding="2px" width="1000" style="border: 1px solid #e0e0e0;color: #999; font-size: 14px; margin: 0; vertical-align: middle; box-sizing: border-box;  padding: 2px;  padding: 4px 5px; color: #666;">
					<tr>
						<td width="100">查询SQL:</td>
						<td >
							<textarea type="text" name = "querysql" id="querysql" label="查询SQL" rows="5"></textarea>
							<button type="button" onclick="doExportQuery()" id="exportQuery" class="btn btn-info">查询导出</button>
						</td>
					</tr>
				</table>
				<table maxColumn='2' cellpadding="2px"  width="1000" style="border: 1px solid #e0e0e0;color: #999; font-size: 14px; margin: 0; vertical-align: middle; box-sizing: border-box;  padding: 2px;  padding: 4px 5px; color: #666;">
					<tr>
						<td width="100">执行SQL:</td>
						<td >
							<textarea type="text" name="execsql" id="execsql" label="执行SQL" rows="5"></textarea>
							<button type="button" onclick="doExecSql()" class="btn btn-info">执行</button>
						</td>
					</tr>
				</table>
				
				<table maxColumn='2' cellpadding="2px"  width="1000" style="border: 1px solid #e0e0e0;color: #999; font-size: 14px; margin: 0; vertical-align: middle; box-sizing: border-box;  padding: 2px;  padding: 4px 5px; color: #666;">
					<tr >
						<td width="100">导出表:</td>
						<td>
							<textarea type="text" name="dmptable" id="dmptable" label="导出表" rows="5"></textarea>
							file=<input type="text" name="dmpfilename" id="dmpfilename" label="导出文件名" style="width:300px" />
							<button type="button" onclick="doExportDmp()" class="btn btn-info">执行</button>
						</td>
					</tr>
				</table>
			</form>
	</div>
		
	<table id="grid-table"></table>
	<div id="grid-pager"></div>
	



</div>	
</body>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';

    $(function(){
    	$($("#navbar>li")[2]).addClass("active");
    });

    function doExportQuery() {
		var url = root+"/exportSQLResultList";
        window.open(url+"?op=query&querysql="+$("#querysql").val());
	};
	
	function doExecSql() {
		$.ajax({ 
	         type:'post', 
	         url:root+"/exportSQLResultList",
	         data:{op:"exec",execsql:$("#execsql").val()},
	         success:function(data){
	            alert(data.msg);
	         },
	         error:function(data){
		            alert("访问服务器出错");  
	         }
	    });
	};
	
	function doExportDmp() {
        var url = root+"/exportSQLResultList";
        window.open(url+"?op=dmp&dmptable="+$("#dmptable").val()+"&dmpfilename="+$("#dmpfilename").val());
	};
	
	</script>

</html>
