package com.idm.app.system.auth.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.system.auth.model.Role;
import com.idm.app.system.auth.model.UserInfo;
import com.idm.app.system.auth.service.AuthManager;
import com.idm.app.system.auth.service.AuthUserService;
import com.idm.app.system.auth.service.MenuTreeService;
import com.idm.app.system.auth.service.RoleService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

/**
 * 
 *<p>Title: RoleController</p>  
 * @Description: 角色管理
 * @author HDQ
 * @date 2019年2月27日
 * @version  1.0
 *
 */
@Controller
public class RoleController {
	static final Logger logger = Logger.getLogger(RoleController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuTreeService menuTreeService;
	
	@Autowired
	private AuthUserService authUserService;
	
	@Autowired
	private AuthManager amanager;

	@RequestMapping("/role")
    public String department(){

        return "role/rolePage";
    }

	
    /**
     * 
     * @Description: 查询
     * @param request
     * @return
     */
	@RequestMapping("/role_service")
	@ResponseBody
	@SysLog(operate="查询",module="角色管理")
    public Object roleView(HttpServletRequest request){
		ResByPageVo resByPageVo = null;
		String roleNo = request.getParameter("roleNo");
		try {
			int page =Integer.parseInt(request.getParameter("page"));
			int size = Integer.parseInt(request.getParameter("rows"));
			resByPageVo = new ResByPageVo(size, page,roleService.selectCountByAll(roleNo));
			resByPageVo.setRows(roleService.selectByAll(size, page, roleNo));
		} catch (Exception e) {
			logger.error("RoleController:组装返回数据失败！", e);
		}
		return JSONObject.fromObject(resByPageVo);
    }
	
	
    /**
     * 
     * @Description: 增加和修改
     * @param request
     * @return
     */
	@SameUrlData
	@RequestMapping("/role_saveOrUpdate")
	@ResponseBody
	@SysLog(operate="增加或修改",module="角色管理")
    public synchronized Object roleSaveOrUpdate(HttpServletRequest request, Role role){
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		Integer result = 0;
		String roleRoot = request.getParameter("roleRoot");
		logger.info("角色权限："+roleRoot+"");
		role.setCreateUser(user.getUserId());
		role.setCreateTime(sdf.format(new Date()));
		role.setUpdateUser(user.getUserId());
		role.setUpdateTime(sdf.format(new Date()));
		role.setRoleStatus("1");
		role.setRoleRoot(roleRoot);
		String option = request.getParameter("role_option");
		if("add".equals(option)) {
			result = roleService.saveRoleInfo(role);
		}else if("modify".equals(option)) {
			result = roleService.updateRoleInfo(role);
		}
		
		if(result > 0){
			return JSONObject.fromObject("{\"success\":true}");
		}else {
			return JSONObject.fromObject("{\"success\":false}");
		}
    }
	
	
	 /**
     * 
     * @Description: 删除
     * @param request
     * @return
     */
	@RequestMapping("/role_deleteRoleInfo")
	@ResponseBody
	@SysLog(operate="删除",module="角色管理")
    public Object roleDeleteRoleInfo(HttpServletRequest request){
		Integer result = 0;
		
		String roleNo = request.getParameter("roleNo");
		result = roleService.deleteRoleInfo(roleNo);
		if(result > 0){
			return JSONObject.fromObject("{\"success\":true}");
		}else {
			return JSONObject.fromObject("{\"success\":false}");
		}
    }
	
	@RequestMapping("/role_menuTree")
    public String menuTree(){

        return "role/menuTree";
    }
	
	@RequestMapping("/role_menuTree_data")
	@ResponseBody
    public Object roleMenuTreeData(String roleNo){
		return JSONArray.fromObject(menuTreeService.queryMenuTreeData(roleNo));
    }
	
	
	 /**
     * 
     * @Description: 授权
     * @param request
     * @return
     */
	@RequestMapping("/role_menuTree_saveOrUpdate")
	@ResponseBody
	@SysLog(operate="授权",module="角色授权")
    public Object roleMenuTreeSave(HttpServletRequest request, String roleNo, String ids){
		Integer result = 0;
		result = menuTreeService.saveMenuTreeData(roleNo, ids);
		if(result > 0){
			amanager.updateAuthByUserId(amanager.getUserId());
			return JSONObject.fromObject("{\"success\":true}");
		}else {
			return JSONObject.fromObject("{\"success\":false}");
		}
    }
	
	@RequestMapping("/role_viewUsers")
    public String viewUsers(){

        return "role/userPage";
    }

	@RequestMapping("/role_viewUsers_data")
	@ResponseBody
	@SysLog(operate="用户查看",module="角色管理")
    public Object roleViewUsersData(HttpServletRequest request){
		ResByPageVo resByPageVo = null;
		String roleNo = request.getParameter("roleNo");
		try {
			int page =Integer.parseInt(request.getParameter("page"));
			int size = Integer.parseInt(request.getParameter("rows"));
			resByPageVo = new ResByPageVo(size, page,authUserService.selectCountByRoleNo(roleNo));
			resByPageVo.setRows(authUserService.selectByRoleNo(size, page, roleNo));
		} catch (Exception e) {
			logger.error("RoleCntroller:组装返回数据失败！", e);
		}
		return JSONObject.fromObject(resByPageVo);
    }
	
	
	 /**
     * 
     * @Description: 角色ID重复校验
     * @param request
     * @return
     */
	@RequestMapping("/role_service_selectRoleByRoleNo")
	@ResponseBody
    public Object selectRoleInfoByRoleNo(HttpServletRequest request){
		String roleNo = request.getParameter("roleNo");
		Role r= roleService.selectRoleInfoByRoleNo(roleNo);
		if(r!=null){
			return JSONObject.fromObject("{\"success\":true}");
		}
		return JSONObject.fromObject("{\"success\":false}");
    } 
	
	 /**
     * 
     * @Description: 角色名称重复校验
     * @param request
     * @return
     */
	@RequestMapping("/role_service_selectRoleByRoleName")
	@ResponseBody
    public Object selectRoleInfoByRoleName(HttpServletRequest request){
		String roleName = request.getParameter("roleName");
		Role r= roleService.selectRoleInfoByRoleName(roleName);
		if(r!=null){
			return JSONObject.fromObject("{\"success\":true}");
		}
		return JSONObject.fromObject("{\"success\":false}");
    } 
	/**
	 * 
	 * @Description:权限检验
	 * @param request
	 * @return
	 */
//	@RequestMapping("/role_selectRoleRoot")
//	@ResponseBody
//	public Object selectRoleRoot(HttpServletRequest request){
//		
//		String roleRoot = request.getParameter("roleRoot");
//		logger.info("string --------"+roleRoot);
//		if ("1".equals(roleRoot) || "2".equals(roleRoot)) {
//			int r= roleService.selectRoleRoot(roleRoot);
//			logger.info("数量 --------"+r);
//			if (r != 0) {
//				return JSONObject.fromObject("{\"success\":true}");
//			}
//		}
//		return JSONObject.fromObject("{\"success\":false}");
//	} 
}
