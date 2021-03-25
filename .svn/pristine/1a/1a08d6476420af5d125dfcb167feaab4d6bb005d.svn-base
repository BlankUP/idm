<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<title>功能选择</title>
	    <link href="<%=request.getContextPath()%>/public/ztree/css/zTree/ztree.css" rel="stylesheet" type="text/css" />
	    <script type="text/javascript" src="<%=request.getContextPath()%>/public/ztree/js/jquery.ztree.all-3.5.min.js"></script>
	    <style>
	    	#zui-left-tree{
	    		margin-top:10px;
	    		margin-left:20px;
	    	}
	    </style>
    </head>
	<body>
		<script type="text/javascript">
		var zTree;
		$(function(){
			var roleNo = $("#zui-left-tree").parent().data("roleno");
			//选择模式
			var selectmode = "checkbox";
			//已选的
			var selected = "<%=request.getAttribute("selected")%>";
			
			var setting = {
					view: {
						selectedMulti: false,
						showLine:false,
						fontCss : {color:"black"},
						showIcon:false
					},
					check: {
						enable: selectmode == 'checkbox' || selectmode == 'radio',
						chkStyle:selectmode,
						chkboxType:{ "Y" : "ps", "N" : "s"},
						radioType:"all"
					},
					data: {
						key: {
							title:"name"
						},
						simpleData: {
							idKey:"code",
							pIdKey:"parentCode",
							enable: true
						}
					},
					callback: {
						beforeRightClick:function(id,node){
							if(node){
								zTree.selectNode(node);
								if(selectmode && selectmode=='checkbox'){
									zTree.checkNode(node,!node.checked,true);
								}else if(selectmode && selectmode=='radio'){
									zTree.checkNode(node,true,false);
								}
							}else{
								zTree.cancelSelectedNode();
								if(selectmode && selectmode=='radio'){
									var s = zTree.getCheckedNodes();
									for(var x = 0;x<s.length;x++){
										zTree.checkNode(s[x],false,false);
									}
								}
							}
						},
						onMouseDown:function(e,id,node){
							if(selectmode && selectmode=='radio' && !node && (e.srcElement.nodeName != 'BUTTON')){
								zTree.cancelSelectedNode();
								
								var s = zTree.getCheckedNodes();
								for(var x = 0;x<s.length;x++){
									zTree.checkNode(s[x],false,false);
								}
							}
						},
						beforeClick:function(id,node,flag){
							if(selectmode && selectmode=='checkbox'){
								zTree.checkNode(node,!node.checked,true);
							}else if(selectmode && selectmode=='radio'){
								zTree.checkNode(node,true,false);
							}
							return true;
						}
					}
				};
			
			$.get('<%=request.getContextPath()%>/role_menuTree_data.do?roleNo='+roleNo,function(data){
				
				zTree = toTree(data);
				
// 				if(selected){
// 					var ids = selected.split(",");
// 					for(var x = 0;x<ids.length;x++){
// 						var node = zTree.getNodeByParam("code",ids[x]);
// 						if(node){
// 							zTree.checkNode(node,true,false);
// 							var pnode = node.getParentNode();
// 							//认为不会超过100层
// 							for(var i=0;i<100&&pnode;i++){
// 								zTree.checkNode(pnode,true,false);
// 								pnode = pnode.getParentNode();
// 							}
// 						}
// 					}
// 				}
				zTree.expandAll(true);
			});
			
			function toTree(_data){
				if(!_data || _data.length==0){
					return;
				}
				
				return $.fn.zTree.init($("#zui-left-tree"), setting, _data);
			}
			
			$("#btn-ok").click(function(){
				var result = null;
				if(zTree.setting.check.enable){
					result = (zTree.getCheckedNodes());
				}else{
					result = (zTree.getSelectedNodes());
				}
				ok(roleNo, result);
			});
			$("#btn-cancel").click(function(){
				close();
			});
		});
		function ok(roleNo, result){
			var ids = '';
			for(var i=0; i<result.length; i++){
				ids = ids + ';' +  result[i].id;
			}
			ids = ids.substring(1);
			$.ajax({
		        type: "post",
		        url: root+'/role_menuTree_saveOrUpdate.do',
		        data: {'roleNo':roleNo,'ids':ids},
		        dataType: 'json',
		        success: function(data){
		        	if(data.success == true) alert("授权成功");
	            	else alert("授权失败");
		        	close();
		        }
		    });
		};
		function close(){
			$("#zui-left-tree").parent().parent().modal('toggle');
		}
		</script>
		<div style="background:#fff;width:100%;">
			<button type="button" class="btn btn-mini" id="btn-ok">确定</button>
			<button type="button" class="btn btn-mini" id="btn-cancel">取消</button>
		</div>
		<div id="zui-left-tree" class="ztree" >
		</div>
	</body>
</html>