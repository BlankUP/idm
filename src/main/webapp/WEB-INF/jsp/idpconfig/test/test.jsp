<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>决策服务测试</title>
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
      			<li> <i class="fa fa-video-camera"></i> 决策服务配置<span class="divider">/</span></li>
      			<li class="active"><i class="fa fa-area-chart"></i> 决策服务测试</li>
    </ul>
	<div class="alert alert-info">
            <form name="searchForm" class="form-horizontal" id ="searchForm">
            	<input type="hidden" id ="op" name="op"/>
            	<table maxColumn='2' cellpadding="2px" width="1000" style="border: 1px solid #e0e0e0;color: #999; font-size: 14px; margin: 0; vertical-align: middle; box-sizing: border-box;  padding: 2px;  padding: 4px 5px; color: #666;">
					<tr>
						<td width="100">上游JSON:</td>
						<td >
							<textarea type="text" name = "queryjson" id="queryjson" label="上游JSON" rows="5"></textarea>
							<button type="button" onclick="doTest()" class="btn btn-info">执行</button>
						</td>
					</tr>
				</table>
				<table maxColumn='2' cellpadding="2px"  width="1000" style="border: 1px solid #e0e0e0;color: #999; font-size: 14px; margin: 0; vertical-align: middle; box-sizing: border-box;  padding: 2px;  padding: 4px 5px; color: #666;">
					<tr>
						<td width="100">返回JSON:</td>
						<td >
							<textarea type="text" name="execjson" id="execjson" label="返回JSON" rows="5"></textarea>
						</td>
					</tr>
				</table>
				
			</form>
	</div>
</div>	
</body>
	<script type="text/javascript">
	 var root='<%=request.getContextPath()%>';

    $(function(){
    	$($("#navbar>li")[2]).addClass("active");
    });

	
	function doTest() {
	//	var text = encodeURI(encodeURI($("#queryjson").val()));
	var text = $("#queryjson").val();
		$.ajax({ 
	         type:'post', 
	         url:root+"/test_json",
	         dataType:'json',
	         data:{text:text},
	         success:function(data){
	        	 $("#execjson").val(data);
	         },
	         error:function(data){
		            alert("访问服务器出错");  
	         }
	    });
	};
	
	</script>

</html>
