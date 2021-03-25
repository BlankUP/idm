<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2020/9/21
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>流程配置</title>
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

    <jsp:include page="common/header.jsp" flush="true"/>
</head>
<body>
<div id="uploadFileModal" class="modal hide fade">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h3><span id="uploadFileTitle" ></span></h3>
    </div>
    <div class="modal-body">
        <form id="excelDataFrom" action="UpdFile" enctype="multipart/form-data" method="post">
            <div >
                <table cellpadding="2px">
                    <tr>
                        <td style="width: 100px;">选择文件</td><td style="width: 300px;">
                        &nbsp;&nbsp;<input id="file" type="file" name="file">
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 100px;">选择文件</td><td style="width: 300px;">
                        &nbsp;&nbsp;<input id="file1" type="file" name="file">
                        </td>
                    </tr>
                </table>
                <br/>
                <p style="font-size:20px;color:red;" >注意事项：</p>
            </div>

            <div style="width: 350px; font-size:14px;color:red;">
                <p>&nbsp;&nbsp;&nbsp;&nbsp;1、请先下载Excel模板（字段信息模板.xlsx）；</p>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;2、然后在字段信息模板.xlsx文件上填写数据；</p>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;3、请确保填写数据的准确并与原有数据无逻辑冲突；</p>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;4、最后导入字段信息模板.xlsx文件。</p>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <a href="javascript:void(0)" id="doExportSubmit" class="btn btn-info" onclick="doExportSubmit();"><i class="fa fa-save"></i> 导出Excel模板</a>
        <a href="javascript:void(0)" id="doExcelImportData" class="btn btn-info" onclick="doExcelImportData();"><i class="fa fa-save"></i> 导入</a>
        <a href="javascript:void(0)" id="cancelBtn" class="btn btn-info" data-dismiss="modal"><i class="fa fa-close"></i> 取 消</a>
    </div>
</div>
</body>
<script type="text/javascript">
    var root='<%=request.getContextPath()%>';
    $(function(){
        $($("#navbar>li")[1]).addClass("active");
    });


    //监听下拉框事件
    $('select').change(function() {
        var id = "v_"+$(this).attr("name");
        var text = $(this).find("option:selected").text();
        $("#"+id).val(text)

    });

    $('#c_productId').change(function() {
        var productId = $(this).val();
        var html='';
        $.ajax({
            type: "post",
            url: root+'/query_event_model.do?productId='+productId,
            success: function(data){
                $.each(data,function(i,v){
                    html+="<option value='"+v.modelid+"'>"+v.modelname  + "（"+v.modelcode+"）"+"</option>"
                })
                $("#c_modelId").html(html);
                $('#c_modelId').change();
            }
        });

    });

</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/idpconfig/flowInfo/flowInfo.js"></script>
</html>
