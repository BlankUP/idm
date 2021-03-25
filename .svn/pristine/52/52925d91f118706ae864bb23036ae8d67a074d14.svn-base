package com.idm.app.system.exceptionManage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.apiservice.exceptionManage.mapper.ErrorlogInfoMapper;
import com.idm.app.apiservice.exceptionManage.model.ErrorlogInfo;
import com.idm.app.apiservice.exceptionManage.model.ErrorlogInfoExample;
import com.idm.app.ruleengine.exceptionManage.mapper.ErrorMessageMapper;
import com.idm.app.ruleengine.exceptionManage.model.ErrorMessage;
import com.idm.app.ruleengine.exceptionManage.model.ErrorMessageExample;
import com.idm.common.page.PageVo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author lifadeng
 * @Description: 异常管理
 * @Create: 2018/11/13 10:57
 * @Version: 1.0
 */
@Controller
public class ExceptionManageController {

    @Resource
    ErrorlogInfoMapper errorlogInfoMapper;
    @Resource
    ErrorMessageMapper errorMessageMapper;

    private Logger logger = Logger.getLogger(ExceptionManageController.class);

    @RequestMapping("/exception_api_page")
    public String exception_api_page(Model model){

        return "exceptionManage/exception_api_page";
    }

    @RequestMapping("/exception_api_data")
    @ResponseBody
    public Object exception_api_data(String querySeqNo,String custName,String certNum,String page,String rows, HttpServletRequest request){

        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            ErrorlogInfoExample example = new ErrorlogInfoExample();
            ErrorlogInfoExample.Criteria criteria = example.createCriteria();
            if(StringUtils.isNotBlank(querySeqNo)){
                criteria.andQuerySeqLike("%"+querySeqNo.trim()+"%");
            }

            example.or(criteria);
            List<ErrorlogInfo> data = errorlogInfoMapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo(data);
            pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
            pv.setRows(data);
        }catch (Exception e){
            logger.error(e);
            pv.setError(e.getMessage());
        }
        return pv;
    }

    @RequestMapping("/exception_ruleengine_page")
    public String exception_manage_page(Model model){

        return "exceptionManage/exception_ruleengine_page";
    }

    @RequestMapping("/exception_ruleengine_data")
    @ResponseBody
    public Object exception_manage_data(String querySeqNo,String custName,String certNum,String page,String rows, HttpServletRequest request){

        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            ErrorMessageExample example = new ErrorMessageExample();
            ErrorMessageExample.Criteria criteria = example.createCriteria();
            if(StringUtils.isNotBlank(querySeqNo)){
                criteria.andQueryseqnoLike("%"+querySeqNo.trim()+"%");
            }

            example.or(criteria);
            List<ErrorMessage> data = errorMessageMapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo(data);
            pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
            pv.setRows(data);
        }catch (Exception e){
            logger.error(e);
            pv.setError(e.getMessage());
        }
        return pv;
    }

}
