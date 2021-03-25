<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="resources/js/test.js" ></script>
	</head>
	<body>
		<button onclick="">保存为txt格式</button>
	</body>
	<script>
		window.onload = function(){
			var blob = new Blob(['123'], {type: "text/plain;charset=utf-8"});
			saveAs(blob, "文件导出测试.txt")
		}
	</script>
</html>
