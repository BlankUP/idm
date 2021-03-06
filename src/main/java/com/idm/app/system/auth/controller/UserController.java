package com.idm.app.system.auth.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.system.auth.model.UserInfo;
import com.idm.app.system.auth.service.UserInfoService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;

/**
 * 
 *<p>Title: UserController</p>  
 * @Description: 用户管理
 * @author HDQ
 * @date 2019年3月12日
 * @version  1.0
 *
 */
@Controller
public class UserController {
	
	static Logger logger = Logger.getLogger(UserController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/user")
    public String userInfo(){

        return "user/userPage";
    }


	@RequestMapping("/user_service")
	@ResponseBody
	@SysLog(operate="首页展示",module="用户管理")
    public Object userInfoView(HttpServletRequest request){
		ResByPageVo resByPageVo = null;
		String userName = request.getParameter("userName");
		try {
			int page =Integer.parseInt(request.getParameter("page"));
			int size = Integer.parseInt(request.getParameter("rows"));
			resByPageVo = new ResByPageVo(size, page,userInfoService.selectCountByAll(userName));
			resByPageVo.setRows(userInfoService.selectByAll(size, page, userName));
		} catch (Exception e) {
			logger.error("RoleController:组装返回数据失败！", e);
		}
		return JSONObject.fromObject(resByPageVo);
    }
	
	 /**
     * 
     * @Description: 查询基础方法
     * @param request
     * @return
     */
	@RequestMapping("/user_service_select")
	@ResponseBody
	@SysLog(operate="查询",module="用户管理")
    public Object userServiceSelect(String userId){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("deps", userInfoService.selectDepList());
		result.put("roles", userInfoService.selectRoleList());
		//System.out.println("userId=" + userId);
		if(userId !=null && !"".equals(userId)){ 
			result.put("myDep", userInfoService.selectDepByUserId(userId));
			result.put("myRoles", userInfoService.selectRoleListByUserId(userId).toString());
		}
		return JSONObject.fromObject(result);
    }
	
	 /**
     * 
     * @Description: 增加和修改
     * @param request
     * @return
     */
	@RequestMapping("/user_service_saveOrUpdate")
	@ResponseBody
	@SysLog(operate="新增或修改",module="用户管理")
    public synchronized Object userServiceSaveOrUpdate(HttpServletRequest request, UserInfo user, String roles){
		UserInfo u = userInfoService.selectUserInfoByUserId(user.getUserId());
		IDMUser user1 = (IDMUser)request.getSession().getAttribute("user");
		Date date = new Date();
		if(u == null) {
			user.setUserPwd(DigestUtils.md5Hex("123456"));
			
			user.setCreateTime(sdf.format(date));
			user.setCreateUser(user1.getUserId());
			user.setUpdateTime(sdf.format(date));
			user.setUpdateUser(user1.getUserId());
			Integer result = userInfoService.saveUserInfo(user, roles);
			if(result > 0){
				return JSONObject.fromObject("{\"success\":true}");
			}
		}else {
			
			String userId = request.getParameter("userId");
			user.setUpdateTime(sdf.format(date));
			user.setUpdateUser(user.getUserId());
			Integer result = userInfoService.updateUserInfo(user, roles);
			if(result > 0){
				return JSONObject.fromObject("{\"success\":true}");
			}
		}
		return JSONObject.fromObject("{\"success\":false}");
    }
	
	 /**
     * 
     * @Description: 删除
     * @param request
     * @return
     */
	@RequestMapping("/user_service_deleteUser")
	@ResponseBody
	@SysLog(operate="删除",module="用户管理")
    public Object userServiceDeleteUser(HttpServletRequest request, String userId){
			Integer result = userInfoService.deleteUserByUserId(userId);
			if(result > 0){
				return JSONObject.fromObject("{\"success\":true}");
			}
			return JSONObject.fromObject("{\"success\":true,\"msg\":\"用户不存在\"}");
    }

	 /**
     * 
     * @Description: 校验用户名称是否重复
     * @param request
     * @return
     */
	@RequestMapping("/user_service_selectUserByUserName")
	@ResponseBody
    public Object selectUserByUserName(HttpServletRequest request){
		String userName = request.getParameter("userName");
		UserInfo u = userInfoService.selectUserInfoByUserName(userName);
		if(u!=null){
			return JSONObject.fromObject("{\"success\":true}");
		}
		return JSONObject.fromObject("{\"success\":false}");
    } 
	
	 /**
     * 
     * @Description: 校验用户ID是否重复
     * @param request
     * @return
     */
	@RequestMapping("/user_service_selectUserByUserId")
	@ResponseBody
    public Object selectUserByUserId(HttpServletRequest request){
		String userId = request.getParameter("userId");
		UserInfo u = userInfoService.selectUserInfoByUserId(userId);
		if(u!=null){
			return JSONObject.fromObject("{\"success\":true}");
		}
		return JSONObject.fromObject("{\"success\":false}");
    } 
	

	
	@RequestMapping("/user_update_password")
	@ResponseBody
	@SysLog(operate="修改密码",module="用户管理")
    public Object userUpdatePassword(HttpServletRequest request, String roles){
        IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		UserInfo u = userInfoService.selectUserInfoByUserId(user.getUserId());
		Date date = new Date();
		String password = request.getParameter("password");
		logger.info("UserId:"+user.getUserId());
		logger.info("password:"+password);
		password  = DigestUtils.md5Hex(password);
		logger.info("password:"+password);
		u.setUserPwd(password);
		u.setUpdateTime(sdf.format(date));
		u.setUpdateUser(user.getUserId());
		Integer result = userInfoService.updateUserpwdByUserId(u);
		if(result > 0){
			return JSONObject.fromObject("{\"success\":true}");
		}
		return JSONObject.fromObject("{\"success\":false}");
    }

}
