<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://idm.com/authorize" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>中银富登智能决策管理平台</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/templatemo-style.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/public/fontAwesome/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/public/common/navbar.css">


<jsp:include page="./common/header2.jsp" flush="true" />
</head>
<body style="width: 100%; height: 100%">
<div id='login-body' class="body-login" style="">
	<!-- Portfolio section -->
	<section id="tmPortfolio">
		
			
				<div class="col-12">
				<div class="yuan"> 
			  <p class="f">智能决策平台</p>
				</div>
				<div class="tm-portfolio-item-pt">
						<div class="tm-portfolio-name-red"
							onclick="to_url('0','index.do')"><div class="tm-portfolio-st"><font class="tm-portfolio-st-font">平台管理</font></div></div>
						<div class="tm-portfolio-description-pt">
							<div class="tm-portfolio-description-pt-d">快速入口</div>
							<h3 class="tm-text-orange-red">
								<c:authority check="upstream">
									<c:authority check="upstream:productConfig">
										<a class="aa"
											onclick="to_url('0','product_Config.do')">产品信息管理</a>
									</c:authority>
									<c:authority check="upstream:proModelConfig">
										<a class="aa"
											onclick="to_url('0','proModel_Config.do')">模型信息管理</a>
									</c:authority>
									
								</c:authority>
								<c:authority check="idpConfig">
									<c:authority check="idpConfig:eventConfig">
										<a class="aa"
											onclick="to_url('0','event_config.do')">决策请求配置</a>
									</c:authority>
									<c:authority check="idpConfig:pmmlConfig">
										<a class="aa"
											onclick="to_url('0','pmml_config.do')">PMML模型配置</a>
									</c:authority>
									
								</c:authority>
								<c:authority check="engineManager">
									<c:authority check="engineManager:bomManage">
										<a class="aa"
											onclick="to_url('0','bom_info.do')">BOM版本管理</a>
									</c:authority>
										<br />
								</c:authority>
							</h3>
						</div>
					</div>
				
				
					<div class="tm-portfolio-item-fk">
						<div class="tm-portfolio-name-red"
							onclick="to_url('1','index.do')"><div class="tm-portfolio-st"><font class="tm-portfolio-st-font">风控系统</font></div></div>
						<div class="tm-portfolio-description-pt">
							<div class="tm-portfolio-description-pt-d">
							快速入口
							</div>
							<h3 class="tm-text-orange-red">
								<c:authority check="upstream">
									<c:authority check="upstream:paraInfoConfig">
										<a class="aa"
											onclick="to_url('1','paraInfo_Config.do')">上游参数管理</a>
									</c:authority>
									<c:authority check="upstream:proModelParaConfig">
										<a class="aa"
											onclick="to_url('1','proModelPara_Config.do')">参数校验配置</a>
									</c:authority>
									
								</c:authority>
								<c:authority check="engineManager">
									<c:authority check="engineManager:adbVerManage">
										<a class="aa"
											onclick="to_url('1','adb_ver_manage.do')">adb版本管理</a>
									</c:authority>
									 <c:authority check="engineManager:adbRuleHotDeploy">
										<a class="aa"
											onclick="to_url('1','adb_rule_deploy.do')">adb规则热部署</a>
									</c:authority> 
										
								</c:authority>
						 	 <c:authority check="examinationManager">
									<c:authority check="examinationManager:adbApprove">
										<a class="aa"
											onclick="to_url('1','adb_approve.do')">adb版本审批</a>
									</c:authority>
									<%-- <c:authority check="examinationManager:adbApproveRecord">
										<a class="aa"
											onclick="to_url('1','adb_approve_record.do')">审批记录查询</a> 
									</c:authority> --%>
								</c:authority>

						<%-- 			<c:authority check="systemControl">
									<c:authority check="systemControl:implTransfer">
										<a class="aa"
											onclick="to_url('1','implTransfer.do')">接口调用监控</a>
									</c:authority>
									<c:authority check="examinationManager:adbApproveRecord">
										<a class="aa"
											onclick="to_url('1','exceptionTransfer.do')"> 异常信息监控</a> 
									</c:authority>
									<c:authority check="examinationManager:adbApproveRecord">
										<a class="aa"
											onclick="to_url('1','threadMonitor.do')"> 线程监控</a> 
									</c:authority>
									
								</c:authority> --%>
								
									<c:authority check="examinationManager">
									<%-- <c:authority check="ExceptionControl:idpExceptionPage">
										<a class="aa"
											onclick="to_url('1','idp_exception_page.do')">决策服务系统异常信息</a>
									</c:authority> --%>
								<%-- 	<c:authority check="ExceptionControl:idpAsyStorageExceptionPage">
										<a class="aa"
											onclick="to_url('1','idp_asyStorageException_page.do')">决策服务系统异步存储异常信息</a> 
									</c:authority> --%>
								</c:authority>
								
							</h3>
						</div>
					</div>

					<div class="tm-portfolio-item-mx">
						<div class="tm-portfolio-name-red"
							onclick="to_url('2','index.do')"><div class="tm-portfolio-st"><font class="tm-portfolio-st-font">模型质检</font></div></div>
						<div class="tm-portfolio-description-pt">
							<div class="tm-portfolio-description-pt-d">
								快速入口
							</div>
							<h3 class="tm-text-orange-red">
								<c:authority check="modelQParaInfo">
									<%-- <c:authority check="modelQParaInfo:modelQParaInfoConfig">
										<a class="aa"
											onclick="to_url('2','modelQParaInfo_Config.do')">模型质检参数管理</a> 
									</c:authority> --%>
									<c:authority check="modelQParaInfo:flowInfo">
										<a class="aa"
											onclick="to_url('2','flow_info.do')">模型质检流程配置</a> 
									</c:authority>
									
								</c:authority>
								<c:authority check="engineManager">
									<c:authority check="engineManager:mqiadbVerManage">
										<a class="aa"
											onclick="to_url('2','mqi_adb_ver_manage.do')">模型质检adb版本管理</a> 
									</c:authority>
									<c:authority check="engineManager:mqiadbRuleHotDeploy">
										<a class="aa"
											onclick="to_url('2','mqi_adb_rule_deploy.do')">模型质检adb规则热部署</a> 
									</c:authority> 
										
								</c:authority>
							<c:authority check="examinationManager">
									<c:authority check="examinationManager:mqiadbApprove">
										<a class="aa"
											onclick="to_url('2','mqi_adb_approve.do')">模型质检adb版本审批</a>
									</c:authority>
									<%-- <c:authority check="examinationManager:mqiadbApproveRecord">
										<a class="aa"
											onclick="to_url('2','mqi_adb_approve_record.do')">模型质检审批记录查询</a> 
									</c:authority> --%>
								</c:authority> 
							</h3>

						</div>
					</div>
				</div>
			
		
	</section>
 </div>
	<script src="<%=request.getContextPath()%>/public/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.min.js"></script>
		
	<!-- End portfolio section -->
	
	    <script type="text/javascript">
    $(function(){
    	$($("#navbar>li")[0]).addClass("active");
    });
    function to_url(system,url){
    	$.ajax({
            type: "post",
            data:{
				"system" : system
			},
            url: root+'/system.do',
            success: function(data){
            	window.location.href=url;
            }
        });
    }
    </script>
   <script type="text/javascript">
var ss;
var ff
window.onload=function()
{
var w=document.documentElement.clientWidth ;//可见区域宽度
var h=document.documentElement.clientHeight;//可见区域高度
ss=document.getElementById('login-body');
//alert(w);

ss.style.height=h+"px";
}
/* window.onload=function()
{
	var w=document.documentElement.clientWidth ;//可见区域宽度
	var h=document.documentElement.clientHeight;//可见区域高度
   ff=document.getElementById('ddd');
   alert(h);
   ff.style.height=h+"px";
} */
</script>
</body>
</html>