<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://idm.com/authorize" prefix="c"%>
					
					<ul id="navbar" class="nav">
						<li><a href="<%=request.getContextPath()%>/home"><i
								class="fa fa-home"></i> 首页</a></li>
						<c:authority check="modelQParaInfo">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 批量信息配置 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="modelQParaInfo:modelQParaInfoConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="modelQParaInfo_Config.do"><i class="fa fa-list-alt"></i>
												模型质检参数管理</a></li>
									</c:authority>
									<c:authority check="modelQParaInfo:flowInfo">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="flow_info.do"><i class="fa fa-list-alt"></i>
												模型质检流程配置</a></li>
									</c:authority>
								</ul></li>
						</c:authority>
						<c:authority check="engineManager">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 决策引擎配置 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="engineManager:mqiadbVerManage">
										<li role="presentation"><a tabindex="-1"
											href="mqi_adb_ver_manage.do"><i class="fa fa-list-alt"></i>
												模型质检adb版本管理</a></li>
									</c:authority>
									<c:authority check="engineManager:mqiadbRuleHotDeploy">
										<li role="presentation"><a tabindex="-1"
											href="mqi_adb_rule_deploy.do"><i class="fa fa-list-alt"></i>
												模型质检adb规则热部署</a></li>
									</c:authority>
									<c:authority check="engineManager:mqimodelAndRule">
										<li role="presentation"><a tabindex="-1"
											href="mqi_modelrule.do"><i class="fa fa-list-alt"></i>
												模型质检模型规则配置</a></li>
									</c:authority>
								</ul></li>
						</c:authority>
						<c:authority check="examinationManager">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 审批管理 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="examinationManager:mqiadbApprove">
										<li><a tabindex="-1" href="mqi_adb_approve.do"><i
												class="fa fa-list-alt"></i> 模型质检adb文件审批</a></li>
									</c:authority>
									<c:authority check="examinationManager:mqiadbApproveRecord">
										<li><a tabindex="-1" href="mqi_adb_approve_record.do"><i
												class="fa fa-list-alt"></i> 模型质检审批记录查询</a></li>
									</c:authority>
								</ul></li>
						</c:authority>
						<c:authority check="mqi_ExceptionControl">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-user-md"></i> 异常信息管理 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="mqi_ExceptionControl:mqiExceptionPage">
										<li><a tabindex="-1" href="mqi_exception_page.do"><i
												class="fa fa-list-alt"></i>模型质检系统异常信息</a></li>
									</c:authority>
								</ul></li>
						</c:authority>
						<c:authority check="mqi_sys_manage">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-globe"></i> 系统管理 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="mqi_sys_manage:mqibasicDataConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="mqi_basic_data_config.do"><i class="fa fa-list-alt"></i>
												模型质检线程池参数配置</a></li>
									</c:authority>
								</ul></li>
						</c:authority>
						<c:authority check="mqi_DataSourceControl">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 统计分析<b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu" aria-labelledby="sysMgrMenu">
								 	<c:authority
										check="mqi_DataSourceControl:mqi_cust_request_info">
										<li><a tabindex="-1"
											href="mqi_cust_request_info.do"><i
												class="fa fa-list-alt"></i>模型质检客户申请信息</a></li>
									</c:authority>
									<c:authority
										check="mqi_DataSourceControl:mqi_cust_requestResult_info">
										<li><a tabindex="-1"
											href="mqi_cust_requestResult_info.do"><i
												class="fa fa-list-alt"></i>模型质检客户申请结果信息</a></li>
									</c:authority>
									
									
									<c:authority check="mqi_DataSourceControl:mqi_refuse_Rule_info">
										<li><a tabindex="-1" href="mqi_reject_rule_model.do"><i
												class="fa fa-list-alt"></i>模型质检拒绝规则模型</a></li>
									</c:authority> 
									
									<c:authority
										check="mqi_DataSourceControl:mqi_score_rule_info">
										<li><a tabindex="-1"
											href="mqi_score_rule_model.do"><i
												class="fa fa-list-alt"></i>模型质检评分规则模型</a></li>
									</c:authority>
									
									<c:authority
										check="mqi_DataSourceControl:mqi_score_card_info">
										<li><a tabindex="-1"
											href="mqi_score_card_model.do"><i
												class="fa fa-list-alt"></i>模型质检评分卡模型</a></li>
									</c:authority>
									
									
								</ul></li>
						</c:authority>
					</ul>