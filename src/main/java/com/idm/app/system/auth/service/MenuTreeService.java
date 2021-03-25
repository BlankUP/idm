package com.idm.app.system.auth.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.system.auth.mapper.MenuTreeMapper;
import com.idm.app.system.auth.mapper.RoleMapper;
import com.idm.app.system.auth.model.MenuTree;
import com.idm.app.system.auth.model.MenuTreeExample;

@Service
public class MenuTreeService {
	
	@Resource
	private MenuTreeMapper menuTreeMapper;
	
	@Resource
	private RoleMapper roleMapper;
	
	public List<Map<String,Object>> queryMenuTreeData(String roleNo) {
		MenuTreeExample example = new MenuTreeExample();
		example.setOrderByClause("sort");
		example.createCriteria().andStatusEqualsTo("1").andParentIdIsNull();
		List<MenuTree> mtList = menuTreeMapper.selectMenuTreeData(example);
		
		String functions = roleMapper.selectFunctionsByRole(roleNo);   //获取角色权限列表
		List<Map<String,Object>> mtResult = new ArrayList<Map<String,Object>>();
		for(MenuTree pmenu: mtList) {
			String pId = pmenu.getMenuId();
			Map<String, Object> mMap = new HashMap<String, Object>();
			List<Map<String,Object>> mResult = new ArrayList<Map<String,Object>>();
			mMap.put("id", pId);
			mMap.put("name", pmenu.getMenuName());
			if(functions!=null && functions.indexOf(pmenu.getMenuId())!=-1) {
				mMap.put("checked", true);
			}
			
			MenuTreeExample example1 = new MenuTreeExample();
			example1.setOrderByClause("sort desc");
			example1.createCriteria().andStatusEqualsTo("1").andParentIdEqualsTo(pId);
			List<MenuTree> mList = menuTreeMapper.selectMenuTreeData(example1);
			for(MenuTree menu: mList) {
				Map<String, Object> map = new HashMap<String, Object>();
				String id = pId + ":" + menu.getMenuId();
				map.put("id", id);
				map.put("name", menu.getMenuName());
				if(functions!=null && functions.indexOf(id)!=-1) {
					map.put("checked", true);
				}
				mResult.add(map);
			}
			mMap.put("children", mResult);
			mtResult.add(mMap);
		}
		return mtResult;
	} 
	
	public Integer saveMenuTreeData(String roleNo, String functions) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleNo", roleNo);
		params.put("functions", functions);
		return menuTreeMapper.saveMenuTreeData(params);
	}
}
