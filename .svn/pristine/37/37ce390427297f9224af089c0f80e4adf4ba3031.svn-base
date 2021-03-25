package com.idm.app.system.auth.mapper;

import java.util.List;

import com.idm.app.system.auth.model.Department;
import com.idm.app.system.auth.model.DepartmentExample;
public interface DepartmentMapper {
	Integer selectCountByAll(DepartmentExample example);
	List<Department> selectByAll(DepartmentExample example);
	Integer saveDepInfo(Department department);
	Integer updateDepInfo(Department department);
	Integer deleteDepInfo(String depNo);
	Department selectDepInfoBydepNo(String depNo);
	Department selectDepInfoBydepName(String depName);
}
