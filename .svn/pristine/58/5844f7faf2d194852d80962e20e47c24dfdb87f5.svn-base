package com.idm.app.system.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.system.auth.mapper.DepartmentMapper;
import com.idm.app.system.auth.model.Department;
import com.idm.app.system.auth.model.DepartmentExample;


@Service
public class DepartmentService {
	@Resource
    DepartmentMapper departmentMapper;
	
	public Integer selectCountByAll(String depNo, String depName){
		DepartmentExample example = new DepartmentExample();
		if(depNo!=null && !"".equals(depNo))	example.createCriteria().andDepNoEqualsTo(depNo);
		if(depName!=null && !"".equals(depName)) example.createCriteria().andDepNameEqualsTo(depName);
//		example.createCriteria().andStatusEqualsTo("1");
		return departmentMapper.selectCountByAll(example);
	}
	
	public List<Department> selectByAll(int size, int page,  String depNo, String depName){
		DepartmentExample example = new DepartmentExample();
		if(depNo!=null && !"".equals(depNo))	example.createCriteria().andDepNoEqualsTo(depNo);
		if(depName!=null && !"".equals(depName)) example.createCriteria().andDepNameEqualsTo(depName);
//		example.createCriteria().andStatusEqualsTo("1");
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("updatetime");
		
		return departmentMapper.selectByAll(example);
	}
	
	public Integer saveDepInfo(Department dep) {
		return departmentMapper.saveDepInfo(dep);
	}

	public Integer updateDepInfo(Department dep) {
		return departmentMapper.updateDepInfo(dep);
	}
	
	public Integer deleteDepInfo(String depNo) {
		return departmentMapper.deleteDepInfo(depNo);
	}
	
	public Department selectDepInfoBydepNo(String depNo) {
		return departmentMapper.selectDepInfoBydepNo(depNo);
	}
	
	public Department selectDepInfoBydepName(String depName) {
		return departmentMapper.selectDepInfoBydepName(depName);
	}
}
