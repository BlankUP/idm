<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>线程监控</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/exceptionShow.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/common/navbar.css">

    <script src="<%=request.getContextPath()%>/public/echarts/js/echarts.js"></script>

    <jsp:include page="./../common/header.jsp" flush="true"/>
</head>

<body>

<div class="container-fluid">

    <ul class="breadcrumb">
        <li>您当前位置：</li>
        <li><a href="index.do"><i class="fa fa-home"></i> 首页</a><span class="divider">/</span></li>
        <li> <i class="fa fa-globe"></i> 系统监控<span class="divider">/</span></li>
        <li class="active"><i class="fa fa-laptop"></i> 服务器监控</li>
    </ul>
    <div class="alert">
        <span>服务器：</span>
        <select id="searchServer" onchange="serverSelect()">
            <c:forEach items="${servers}" var="item" varStatus="id">
                <option value="${item.serverId}" >${item.name}</option>
            </c:forEach>
            <!-- <option value="trade1" selected="1">服务器1</option>
            <option value="trade2" >服务器2</option> -->
        </select>

    </div>
    <div class="row-fluid">
        <!-- <div class="span4">
            <div style="height:500px;" class="memoryCharts" id="memory"></div>
        </div> -->
        <div class="span8-T">
            <div style="height:500px;" class="cpucharts" id="cpu"></div>
        </div>
    </div>

</div>
<script src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>


<script type="text/javascript">
    var root='<%=request.getContextPath()%>';
    $(function(){
        $($("#navbar>li")[4]).addClass("active");
    });
</script>

<script src="<%=request.getContextPath()%>/resources/js/threadMonitor/threadMonitor.js"></script>
</body>
</html>
