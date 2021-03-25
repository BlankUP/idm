package com.idm.app.system.login.service;

import com.idm.app.system.login.mapper.IDMUserMapper;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.login.model.IDMUserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginService {

    @Resource
    IDMUserMapper userMapper;

    public IDMUser findByUserId(String user_id){
        IDMUserExample example = new IDMUserExample();
        example.createCriteria().andUserIdEqualTo(user_id);
        List<IDMUser> list =  userMapper.selectByExample(example);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }
//控制登录次数
	public void insertLoginNum(String username) {

	int loginNum = userMapper.selectLoginNum(username);
	}
	public void updateUserStatus(IDMUser user) {
		userMapper.updateUserStatus(user);
	}
}
