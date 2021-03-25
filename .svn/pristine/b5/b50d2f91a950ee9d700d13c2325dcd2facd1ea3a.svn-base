package com.idm.app.system.auth.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;

import com.idm.app.system.auth.model.MenuTree;
import com.idm.app.system.auth.model.MenuTreeExample;

public interface MenuTreeMapper {

	@Options(flushCache=Options.FlushCachePolicy.TRUE)
	public List<MenuTree> selectMenuTreeData(MenuTreeExample example);
	
	public Integer saveMenuTreeData(Map<String, Object> params);
}
