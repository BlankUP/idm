package com.idm.app.system.exceptioninfo.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.system.exceptioninfo.model.ErrBaseInfo;
import com.idm.app.system.exceptioninfo.service.ExceptionInfoService;
import com.idm.common.page.PageVo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ExceptionInfoController {
    private Logger logger = Logger.getLogger(ExceptionInfoController.class);

    @Autowired
    private ExceptionInfoService exceptionInfoService;

    @RequestMapping("/exception_base")
    public String exceptionBase()
    {
        return "exceptionBase";
    }

    @RequestMapping("/exception_base_query")
    @ResponseBody
    public Object queyExceptionInfo(HttpServletRequest request, String page, String rows)
    {
        int pageNum = Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        String errCode = request.getParameter("errCode");
        String errMsg = request.getParameter("errMsg");
        logger.info(">>>errCode["+errCode+"]");
        logger.info(">>>errMsg["+errMsg+"]");

        PageHelper.startPage(pageNum, pageSize);
        PageVo pv = null;
        PageInfo pageInfo=null;

        ErrBaseInfo errBaseInfo = new ErrBaseInfo();
        errBaseInfo.setErrCode(errCode);
        errBaseInfo.setErrMsg(errMsg);

        List<ErrBaseInfo> errList = exceptionInfoService.queryErrBaseInfo(errBaseInfo);
        if(errList!=null && errList.size()>0)
        {
            logger.info("查询成功，总记录["+errList.size()+"]");
            pageInfo = new PageInfo(errList);
            pv =new PageVo(pageNum, pageSize, pageInfo.getTotal());
            pv.setRows(errList);
            return pv;
        }
        else if(errList!=null && errList.size()==0 )
        {
            logger.info(">>无记录");
            pv = new PageVo(pageSize, pageNum, 0);
            pv.setError("无记录");
            return pv;
        }
        else
        {
            logger.info(">>数据库错误");
            pv = new PageVo(pageSize, pageNum, 0);
            pv.setError("数据库错误");
            return pv;
        }

    }

    @RequestMapping("/exception_base_save")
    @ResponseBody
    public String AddOrUpdateErrInfo(HttpServletRequest request)
    {
        /**
        for(String str:request.getParameterMap().keySet())
        {
            logger.info(">>["+str+"]");
        }
         ***/

        String option = request.getParameter("option");
        String errCode=request.getParameter("errCode");
        String errMsg=request.getParameter("errMsg");
        String reasonMsg=request.getParameter("reasonMsg");
        String solutionMsg=request.getParameter("solutionMsg");

        logger.info(">>>option["+option+"]");
        logger.info(">>>errCode["+errCode+"]");
        logger.info(">>>errMsg["+errMsg+"]");
        logger.info(">>>reasonMsg["+reasonMsg+"]");
        logger.info(">>>solutionMsg["+solutionMsg+"]");

        ErrBaseInfo errBaseInfo = new ErrBaseInfo();
        errBaseInfo.setErrCode(errCode);
        errBaseInfo.setErrMsg(errMsg);
        errBaseInfo.setReasonMsg(reasonMsg);
        errBaseInfo.setSolutionMsg(solutionMsg);
        if("add".equals(option))
        {

            try {
                exceptionInfoService.addErrBaseInfo(errBaseInfo);
            } catch (Exception e) {
                logger.info(">>>"+e.getMessage());

                e.printStackTrace();
                return "添加数据失败";
            }
        }
        if("update".equals(option))
        {
            exceptionInfoService.updateErrBaseInfo(errBaseInfo);
        }

        return null;
    }

}
