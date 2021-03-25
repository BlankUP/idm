package com.idm.app.system.exceptioninfo.service;

import com.idm.app.system.exceptioninfo.mapper.ExceptionInfoMapper;
import com.idm.app.system.exceptioninfo.model.ErrBaseInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExceptionInfoService {

    @Resource
    private ExceptionInfoMapper exceptionInfoMapper;

    public List<ErrBaseInfo> queryErrBaseInfo(ErrBaseInfo errBaseInfo)
    {
        return exceptionInfoMapper.queryErrBaseInfo(errBaseInfo);
    }

    public void addErrBaseInfo(ErrBaseInfo errBaseInfo) throws Exception
    {
        exceptionInfoMapper.addErrBaseInfo(errBaseInfo);
    }

    public void updateErrBaseInfo(ErrBaseInfo errBaseInfo)
    {
        exceptionInfoMapper.updateErrBaseInfo(errBaseInfo);
    }
}
