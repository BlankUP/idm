<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://idm.com/authorize" prefix="c"%>
					
					
					<ul id="navbar" class="nav">
						<li><a href="<%=request.getContextPath()%>/home"><i
								class="fa fa-home"></i> 首页</a></li>
						<c:authority check="upstream">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 决策服务配置 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="upstream:paraInfoConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="paraInfo_Config.do"><i class="fa fa-list-alt"></i>
												上游参数管理</a></li>
									</c:authority>
									<c:authority check="upstream:proModelParaConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="proModelPara_Config.do"><i class="fa fa-list-alt"></i>
												参数校验配置</a></li>
									</c:authority>

								</ul></li>
						</c:authority>
						<c:authority check="engineManager">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 决策引擎配置 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="engineManager:adbVerManage">
										<li role="presentation"><a tabindex="-1"
											href="adb_ver_manage.do"><i class="fa fa-list-alt"></i>
												adb版本管理</a></li>
									</c:authority>
									<c:authority check="engineManager:adbRuleHotDeploy">
										<li role="presentation"><a tabindex="-1"
											href="adb_rule_deploy.do"><i class="fa fa-list-alt"></i>
												adb规则热部署</a></li>
									</c:authority>
									<c:authority check="engineManager:modelAndRule">
										<li role="presentation"><a tabindex="-1"
											href="modelrule.do"><i class="fa fa-list-alt"></i>
												模型规则配置</a></li>
									</c:authority>
								</ul></li>
						</c:authority>
						<c:authority check="examinationManager">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 审批管理 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="examinationManager:adbApprove">
										<li><a tabindex="-1" href="adb_approve.do"><i
												class="fa fa-list-alt"></i> adb文件审批</a></li>
									</c:authority>
									<c:authority check="examinationManager:adbApproveRecord">
										<li><a tabindex="-1" href="adb_approve_record.do"><i
												class="fa fa-list-alt"></i> 审批记录查询</a></li>
									</c:authority>
								</ul></li>
						</c:authority>
						
							<c:authority check="systemControl">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 性能监控 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="systemControl:implTransfer">
										<li><a tabindex="-1" href="implTransfer.do"><i
												class="fa fa-list-alt"></i> 接口调用监控</a></li>
									</c:authority>
								<%-- 	<c:authority check="systemControl:threadMonitor">
										<li><a tabindex="-1" href="threadMonitor.do"><i
												class="fa fa-list-alt"></i> 线程监控</a></li>
									</c:authority> --%>
									<%-- <c:authority check="systemControl:exceptionTransfer">
										<li><a tabindex="-1" href="exceptionTransfer.do"><i
												class="fa fa-list-alt"></i> 异常信息监控</a></li>
									</c:authority> --%>
								</ul></li>
						</c:authority>
						
						
							<c:authority check="ExceptionControl">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 异常信息管理<b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="ExceptionControl:idpExceptionPage">
										<li><a tabindex="-1" href="idp_exception_page.do"><i
												class="fa fa-list-alt"></i>决策服务系统异常信息</a></li>
									</c:authority>
									<c:authority
										check="ExceptionControl:idpAsyStorageExceptionPage">
										<li><a tabindex="-1"
											href="idp_asyStorageException_page.do"><i
												class="fa fa-list-alt"></i>决策服务系统异步存储异常信息</a></li>
									</c:authority>
								</ul></li>
						</c:authority>
						<c:authority check="fk_sys_manage">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-globe"></i> 系统管理 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="fk_sys_manage:basicDataConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="basic_data_config.do"><i class="fa fa-list-alt"></i>
												线程池参数配置</a></li>
									</c:authority>
								</ul></li>
						</c:authority>
						
						<c:authority check="DataSourceControl">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 统计分析<b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									
									
								 	<c:authority
										check="DataSourceControl:cust_request_info">
										<li><a tabindex="-1"
											href="cust_request_info.do"><i
												class="fa fa-list-alt"></i>客户申请信息</a></li>
									</c:authority>
									<c:authority
										check="DataSourceControl:cust_requestResult_info">
										<li><a tabindex="-1"
											href="cust_requestResult_info.do"><i
												class="fa fa-list-alt"></i>客户申请结果信息</a></li>
									</c:authority>
									
									
									<c:authority check="DataSourceControl:refuse_Rule_info">
										<li><a tabindex="-1" href="reject_rule_model.do"><i
												class="fa fa-list-alt"></i>拒绝规则模型</a></li>
									</c:authority> 
									
									<c:authority
										check="DataSourceControl:score_rule_info">
										<li><a tabindex="-1"
											href="score_rule_model.do"><i
												class="fa fa-list-alt"></i>评分规则模型</a></li>
									</c:authority>
									
									<c:authority
										check="DataSourceControl:score_card_info">
										<li><a tabindex="-1"
											href="score_card_model.do"><i
												class="fa fa-list-alt"></i>评分卡模型</a></li>
									</c:authority>
									
									
								</ul></li>
						</c:authority>
					</ul>
			