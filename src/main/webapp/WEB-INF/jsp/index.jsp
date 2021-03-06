<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>中银富登智能决策管理平台</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css"> 
	<link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />

    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">
   
    <script src="<%=request.getContextPath()%>/public/echarts/js/echarts.js"></script>
  
<jsp:include page="./common/header.jsp" flush="true"/>
  </head>

  <body>
      <div class="container-fluid">
		     <!-- 	<div class="row-fluid">
			      	<div class="span1">
					</div>
					<div style="height:300px; width:1100px; " class="span11" id="memory">
					</div>		
				</div>
				<div class="row-fluid">
					<div class="span1">
					</div>
					<div style="height:300px; width:1100px; " class="span11" id="cpu">
					</div>
				</div> -->
				
				<div class="hero-unit">
				<h3 align="center"  class="biaoti-1">欢迎光临，中银富登智能决策管理平台</h3>
				<p align="center" class="biaoti-2" >感谢访问中银富登智能决策管理平台管理系统</p>	
				
				<p><center><img src="<%=request.getContextPath()%>/resources/images/login/fengmian.png" /> </center>  </p>
				</div>


	</div> 
    <script src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
 
   <!--  <script src="resources/js/index.js"></script> -->
    <script type="text/javascript">
    $(function(){
    	$($("#navbar>li")[0]).addClass("active");
    });
    
    </script>
  </body>
</html>
