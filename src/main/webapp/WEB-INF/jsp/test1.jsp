<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="resources/js/test.js" ></script>
	</head>
	<style type="text/css">
		* {
			padding: 0;
			margin: 0;
		}

		.process-parent {
			position: absolute;
			width: 400px;
			border: 1px solid #ccc;
			height: 10px;
			border-radius: 3px;

		}

		.process-son {
			position: relative;
			background: #ff1510;
			height: 100%;
			font-size: 8px;
			text-align: center;
			color: #fff;
		}
	</style>
	<body>
		<div class="process-parent">
			<div class="process-son" id="bar" style="width: 0%;">
			</div>
		</div>
	</body>
	<script type="text/javascript">
		function run() {
			// var dataNow = (Math.floor(Math.random()*10))/();
// 			$.ajax({
// 				type:'post',
// 				url:url,
// //	         async:false,
// 				success:function(data){
// 					if(data.msg=='success'){
// 						dataNow = data;
// 					}else{
// 						alert(data.msg);  //弹出失败msg
// 					}
// 				},
// 				error:function(data){
// 					alert("访问服务器出错");
// 				}
// 			});
			var bar = document.getElementById("bar");
			bar.style.width = parseInt(bar.style.width) + 1 + "%";
			bar.innerText = bar.style.width;
			if (bar.style.width == "100%") {
				var div = document.getElementsByClassName("process-parent");
				// div.style.backgroundColor="#21da9a";
				clearTimeout(timeout);
				return;
			}
			var timeout = setTimeout('run()', 300);
		}
		window.onload = run();
	</script>
</html>
