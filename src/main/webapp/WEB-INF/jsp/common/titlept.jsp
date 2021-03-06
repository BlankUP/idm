<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://idm.com/authorize" prefix="c"%>
					
					
					<ul id="navbar" class="nav">
						<li><a href="<%=request.getContextPath()%>/home"><i
								class="fa fa-home"></i> 首页</a></li>
						<c:authority check="baseupstream">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 基础参数配置 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="baseupstream:productConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="product_Config.do"><i class="fa fa-list-alt"></i>
												产品信息管理</a></li>
									</c:authority>
									<c:authority check="baseupstream:proModelConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="proModel_Config.do"><i class="fa fa-list-alt"></i>
												模型信息管理</a></li>
									</c:authority>
									<c:authority check="baseupstream:proModelConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
																   href="cpu_memory.do"><i class="fa fa-list-alt"></i>
											系统监控图表</a></li>
									</c:authority>
									<c:authority check="baseupstream:proModelConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="decision_test.do"><i class="fa fa-list-alt"></i>
												测试方法入口</a></li>
									</c:authority>

								</ul></li>
						</c:authority>
						<c:authority check="idpConfig">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 决策服务配置 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<%-- <c:authority check="idpConfig:test">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="decision_test.do"><i class="fa fa-list-alt"></i>
												决策服务测试</a></li>
									</c:authority> --%>
									<c:authority check="idpConfig:eventConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="event_config.do"><i class="fa fa-list-alt"></i>
												决策请求配置</a></li>
									</c:authority>
									<c:authority check="idpConfig:pmmlConfig">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="pmml_config.do"><i class="fa fa-list-alt"></i>
												PMML模型配置</a></li>
									</c:authority>
								</ul></li>
						</c:authority>

						<c:authority check="engineManager">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-cog"></i> 决策引擎配置 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="engineManager:bomManage">
										<li role="presentation"><a tabindex="-1"
											href="bom_info.do"><i class="fa fa-list-alt"></i> BOM版本管理</a>
										</li>
									</c:authority>
								</ul></li>
						</c:authority>
						<c:authority check="datasource_manage">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-user-md"></i> 日志管理 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="datasource_manage:logInfo">
										<li><a tabindex="-1" href="logInfo.do"><i
												class="fa fa-list-alt"></i> 日志信息</a></li>
									</c:authority>
									
								</ul></li>
						</c:authority>
						<c:authority check="sys_manage">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="javascript:void(0)"> <i
									class="fa fa-globe"></i> 系统管理 <b class="caret"></b></a>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="sysMgrMenu">
									<c:authority check="sys_manage:serverInfo">
										<li role="presentation"><a role="menuitem" tabindex="-1"
											href="server_info.do"><i class="fa fa-cog"></i> 服务器配置</a></li>
									</c:authority>

									<c:authority check="sys_manage:department">
										<li><a tabindex="-1" href="department.do"><i
												class="fa fa-list-alt"></i> 部门管理</a></li>
									</c:authority>
									<c:authority check="sys_manage:roleInfo">
										<li><a tabindex="-1" href="role.do"><i
												class="fa fa-user"></i> 角色管理</a></li>
									</c:authority>
									<c:authority check="sys_manage:userInfo">
										<li><a tabindex="-1" href="user.do"><i
												class="fa fa-user"></i> 用户管理</a></li>
									</c:authority>
									<c:authority check="sys_manage:systemIp">
										<li><a tabindex="-1" href="systemIp.do"><i
												class="fa fa-list-alt"></i> 服务系统IP管理</a></li>
									</c:authority>
								</ul></li>
						</c:authority>
					
					</ul>
			