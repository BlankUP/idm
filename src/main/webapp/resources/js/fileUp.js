/**
 * 需要同步的全局变量数据
 */
var syncdata = null;
/**
 * 决策请求配置表
 */
var tool = [ {
    text : '添加数据',
    iconCls : 'fa fa-plus',
    handler : function() {

        openModalWin('add');
    }
}, '-',{
    text : '查看数据',
    iconCls : 'fa fa-search',
    handler : function() {
        var ids = $('#grid-table').jqGrid('getGridParam', 'selarrrow');
        if (ids.length == 1) {
            var rowData = $("#grid-table").jqGrid('getRowData', ids[0]);
            openModalWin('view', rowData);
        } else {
            alert("请选择一条记录！");
        }
    }
}, '-', {
    text : '修改数据',
    iconCls : 'fa fa-edit',
    handler : function() {
        var ids = $('#grid-table').jqGrid('getGridParam', 'selarrrow');
        if (ids.length == 1) {
            var rowData = $("#grid-table").jqGrid('getRowData', ids[0]);
            openModalWin('update', rowData);
        } else {
            alert("请选择一条记录！");
        }

    }
}, '-',{
    text: 'Excel导入新增' , iconCls: 'fa fa-plus', handler: function () {
        openModalEexcel('excelInsert',"");
    }
}
];

$(document).ready(
    function() {
        var grid_selector = "#grid-table";
        var pager_selector = "#grid-pager";
        jQuery(grid_selector).jqGrid(
            {

                datatype : "local",
                regional : 'cn',
                height : "auto",
                colNames : [ '场景名称', '场景编码','开始节点', '开始节点编码', '下一节点', '下一节点编码',
                    '结果字段', '枚举值', '创建时间', '创建人', '修改时间', '修改人','流程ID', '状态'],
                colModel : [ {
                    sortable : false,
                    name : 'flowName',
                    index : 'flowName',
                    width : 80
                }, {
                    sortable : false,
                    name : 'flowCode',
                    index : 'flowCode',
                    width : 80

                }, {
                    sortable : false,
                    name : 'startModelName',
                    index : 'startModelName',
                    width : 80

                }, {

                    sortable : false,
                    name : 'startModel',
                    index : 'startModel',
                    width : 80
                }, {

                    sortable : false,
                    name : 'nextModelName',
                    index : 'nextModelName',
                    width : 80
                }, {
                    sortable : false,
                    name : 'nextModel',
                    index : 'nextModel',
                    width : 120
                }, {

                    sortable : false,
                    name : 'key',
                    index : 'key',
                    width : 120
                }, {
                    sortable : false,
                    name : 'value',
                    index : 'value',
                    width : 80
                }, {

                    sortable : false,
                    name : 'createTime',
                    index : 'createTime',
                    width : 80
                }, {

                    sortable : false,
                    name : 'createUser',
                    index : 'createUser',
                    width : 80
                }, {
                    hidden : true,
                    sortable : false,
                    name : 'updateTime',
                    index : 'updateTime',
                    width : 80
                }, {
                    hidden : true,
                    sortable : false,
                    name : 'updateUser',
                    index : 'updateUser',
                    width : 80
                }, {
                    hidden : true,
                    sortable : false,
                    name : 'flowId',
                    index : 'flowId',
                    width : 80
                },{
                    sortable:false,
                    name : 'status',
                    index : 'status',
                    width : 80,
                    formatter: "select",
                    editoptions:{value:"0:有效;1:无效"}
                }],
                viewrecords : true,
                rowNum : 10,
                rowList : [ 10, 20, 30, 50, 100 ],
                pager : pager_selector,
                altRows : true,
                toolbar : [ true, "top", tool ],
                multiselect : true,
                multiboxonly : true,

                loadComplete : function() {
                    var table = this;
                    setTimeout(function() {
                        updatePagerIcons(table);
                    }, 0);
                },

                caption : "模型质检流程配置",
                autowidth : true,
            }).jqGrid('setGridParam', {
            page : 1,
            url : root + '/flow_query.do',
            datatype : "json"
        }).trigger("reloadGrid");
    });

// 调整分页图标
function updatePagerIcons(table) {
    var replacement = {
        'ui-icon-seek-first' : 'fa fa-angle-double-left',
        'ui-icon-seek-prev' : 'fa fa-angle-left',
        'ui-icon-seek-next' : 'fa fa-angle-right',
        'ui-icon-seek-end' : 'fa fa-angle-double-right'
    };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
        .each(function() {
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
            if ($class in replacement)
                icon.attr('class', 'ui-icon ' + replacement[$class]);
        })
}
function doSearch() {
    var flowCode = $("#flowCode").val();
    var flowName = $("#flowName").val();
    $("#grid-table").jqGrid(
        'setGridParam',
        {
            page : 1,
            postData:{'flowCode':flowCode,'flowName':flowName},
            url : root + '/flow_query.do',
            datatype : "json"
        }).trigger("reloadGrid");
}

/**
 * 根据类型打开模态框 load模窗口的数据
 *
 * @param type
 * @param rowdata
 */
function openModalWin(type, data) {

    $("label.error").remove();//清除验证标签
    $("input.error").removeClass("error");//清除验证标签
    getFlowName();

    $('#dataModal').modal('show');
    $('#saveUpdateBtn').hide();
    $.each($('label[name=error]'), function() {
        $(this).hide();
    });
    getMogel();
    if (type == "view") {
        $('#c_option').val("view");
        $('#c_flowName').val(data.flowName).attr("disabled","disabled");
        $('#c_flowCode').val(data.flowCode).attr("disabled","disabled");
        $('#c_key').val(data.key).attr("disabled","disabled");
        $('#c_value').val(data.value).attr("disabled","disabled");
        $('#c_startModel').val(data.startModel).attr("disabled","disabled");
        $('#c_nextModel').val(data.nextModel).attr("disabled","disabled");
        $('#c_status').val(data.status).attr("disabled","disabled");
        $('#dataTitle').html("查看数据【" + data.startModelName + "】");
    } else if (type == "update") {
        $('#c_option').val("update");
        $('#c_flowId').val(data.flowId);
        $('#c_flowName').val(data.flowName).attr("disabled","disabled");
        $('#c_flowCode').val(data.flowCode).attr("disabled","disabled");
        $('#c_key').val(data.key).attr("disabled","disabled");
        $('#c_value').val(data.value).attr("disabled","disabled");
        $('#c_startModel').val(data.startModel).attr("disabled","disabled");
        $('#c_nextModel').val(data.nextModel).attr("disabled","disabled");
        $('#c_status').val(data.status).attr("disabled",false);

        $('#dataTitle').html("修改数据【" + data.startModelName + "】");
        $('#saveUpdateBtn').show();
        iscleck=true;
    } else if (type == "add") {
        $('#c_option').val("add");
        $('#c_flowId').val("");
        $('#c_flowName').val("").prop("disabled",false);
        $('#c_flowCode').val("").prop("disabled",false);
        $('#c_key').val("").prop("disabled",false);
        $('#c_value').val("").prop("disabled",false);
        $('#c_startModel').val("").prop("disabled",false);
        $('#c_nextModel').val("").prop("disabled",false);
        $('#c_status').val("0").prop("disabled",false);
        $('#dataTitle').html("添加数据");
        $('#saveUpdateBtn').show();
        iscleck=true;
    }
}

/**
 * 提交新增和修改信息
 *
 * @param el
 * @param method
 */
var iscleck=null;
function saveOrUpdate() {
    if($("#dataFrom").valid()&&iscleck){
        if($("#c_nextModel").val() == $("#c_startModel").val()){
            alert("开始节点与下一节点不能相同");
            return;
        }
        if(!verify()){
            alert("请配置正确的参数");
            return
        }else{
            iscleck=false;
            var data = $('#dataFrom').serialize();
            debugger;
            $.ajax({
                type : 'post',
                url : root + '/flow_save.do',
                data : data,
                async:false,
                success : function(msg) {
                    if (msg == '') {
                        alert("保存成功！"); // 弹出成功msg
                        // 刷新表格数据
                        doSearch();
                        parent.$('#dataModal').modal('hide');
                    } else {
                        alert("接口请求出现错误:" + msg); // 弹出失败msg
                    }
                },
                error : function(msg) {
                    alert("访问服务器出错");
                }
            });
        }
    }
}

// 校验
function verify() {

    var str = true
    repeatModel();

    $.each($('label[name=error]'), function() {
        if(!$(this).is(":hidden")) {
            str= false;
        }
    });
    return str;
}


/**
 * 关闭
 *
 * @param modalId
 */
function closeBtn(modalId) {
    $('#' + modalId).hide();
}

var validator = null;
$(document).ready(function() {
    validator = $("#dataFrom").validate({
        rules : {
            startModel : {
                required : true
            },
            nextModel : {
                required : true
            },
            status : {
                required : true
            }
        },
        focusCleanup : true
    });
});

function repeatModel(){
    var start = $("#c_startModel").val()
    var next = $("#c_nextModel").val()
    if(start==next){
        $("#d_modelId").show();
    }else{
        $("#d_modelId").hide();
    }
}

function getMogel(){
    var productId = $('#c_productCode').find("option:selected").attr("pro");
    var start = "<option value='start'>开始节点</option>"
    var end = "<option value='end'>结束节点</option>"
    var html='';
    $.ajax({
        type: "post",
        url: root+'/query_event_model.do?productId='+productId,
        async:false,
        success: function(data){
            $.each(data,function(i,v){
                html+="<option value='"+v.modelcode+"'>"+v.modelname  + "（"+v.modelcode+"）"+"</option>"
            })
            start += html;
            end += html;
            $("#c_startModel").html(start);
            $("#c_nextModel").html(end);

        }
    });
}

function openModalEexcel(type,data){
    if(type=="excelInsert"){
        $('#uploadFileModal').modal('show');
        $('#uploadFileSubmit').show();
        $('#uploadFileTitle').html("Excel批量导入参数");
    }

}

/**
 * 导出excel
 */
function doExportSubmit(){
    window.open("flow_excel_export");
}

/**
 * 导入
 * @returns
 */
function doExcelImportData(){

    //首先验证文件格式
    var fileName = $('#file').val();
    if (fileName === '') {
        alert('请选择文件');
        return false;
    }
    var fileType = (fileName.substring(fileName
        .lastIndexOf(".") + 1, fileName.length))
        .toLowerCase();
    if (fileType !== 'xls' && fileType !== 'xlsx') {
        alert('文件格式不正确，excel文件！');
        return false;
    }

    var formData = new FormData($('#excelDataFrom')[0]);
    $.ajax({
        type:'post',
        url:root+'/up_fileArray_import.do',
        data:formData,
        contentType: false, //不设置内容类型
        async: false,
        cache: false,
        processData: false,
        beforeSend:function(){
            console.log("正在进行，请稍候");
        },
        success:function(data){
            var divDiv =  "<p style='font-size:14px;'>"+data.message+"</p>";
            if(data.result == "success"){  //导入成功
                parent.$('#uploadFileModal').modal('hide');   //对导入页面进行关闭
                doSearch();                 //刷新页面
            }
            $('#importExcelDataResultDetail').modal('show');
            $("#importExcelDataResultContent").html(divDiv);
            $('#importExcelDataResultDetailTitle').html("Excel批量导入结果");
        },
        error:function(data){
            alert("导入失败!");
        }
    });
}

/**
 * 场景名称赋值
 */
function getFlowName(){
    var text =  $("#c_flowCode").find("option:selected").text();
    $("#c_flowName").val(text)

}

