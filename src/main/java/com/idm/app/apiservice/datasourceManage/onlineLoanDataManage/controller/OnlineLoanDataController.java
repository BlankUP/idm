package com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.apiservice.datasourceManage.externalDatasourceManage.mapper.VExternalDataMapper;
import com.idm.app.apiservice.datasourceManage.externalDatasourceManage.model.VExternalData;
import com.idm.app.apiservice.datasourceManage.externalDatasourceManage.model.VExternalDataExample;
import com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.mapper.OLRequestParamMapper;
import com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.mapper.OLResponseParamMapper;
import com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.model.OLRequestParam;
import com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.model.OLRequestParamExample;
import com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.model.OLResponseParam;
import com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.model.OLResponseParamExample;
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
 * @Description: 网贷数据
 * @Create: 2018/11/12 15:59
 * @Version: 1.0
 */
@Controller
public class OnlineLoanDataController {

    @Resource
    OLRequestParamMapper requestParamMapper;
    @Resource
    OLResponseParamMapper responseParamMapper;

    private Logger logger = Logger.getLogger(OnlineLoanDataController.class);

    @RequestMapping("/ol_request_data_page")
    public String ol_request_data_page(Model model){

        return "datasourceManage/onlineLoanRequestData";
    }

    @RequestMapping("/ol_response_data_page")
    public String ol_response_data_page(Model model){

        return "datasourceManage/onlineLoanResponseData";
    }

    /**
     * 网贷请求数据
     * @param querySeqNo
     * @param custName
     * @param certNum
     * @param page
     * @param rows
     * @param request
     * @return
     */
    @RequestMapping("/ol_request_data")
    @ResponseBody
    public Object ol_request_data(String querySeqNo,String custName,String certNum,String page,String rows, HttpServletRequest request){

        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            OLRequestParamExample example = new OLRequestParamExample();
            OLRequestParamExample.Criteria criteria = example.createCriteria();
            if(StringUtils.isNotBlank(querySeqNo)){
                criteria.andQuerySeqNoLike("%"+querySeqNo+"%");
            }
            if(StringUtils.isNotBlank(custName)){
                custName = new String(custName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andUserNameLike("%"+custName+"%");
            }
            if(StringUtils.isNotBlank(certNum)){
                criteria.andIdNumberLike("%"+certNum+"%");
            }

            example.or(criteria);
            List<OLRequestParam> data = requestParamMapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo(data);
            pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
            pv.setRows(data);
        }catch (Exception e){
            logger.error(e);
            pv.setError(e.getMessage());
        }
        return pv;
    }

    /**
     * 网贷响应数据
     * @param querySeqNo
     * @param custName
     * @param certNum
     * @param page
     * @param rows
     * @param request
     * @return
     */
    @RequestMapping("/ol_response_data")
    @ResponseBody
    public Object ol_response_data(String querySeqNo,String custName,String certNum,String page,String rows, HttpServletRequest request){

        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            OLResponseParamExample example = new OLResponseParamExample();
            OLResponseParamExample.Criteria criteria = example.createCriteria();
            if(StringUtils.isNotBlank(querySeqNo)){
                criteria.andQuerySeqNoLike("%"+querySeqNo+"%");
            }
            if(StringUtils.isNotBlank(custName)){
                custName = new String(custName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andUserNameLike("%"+custName+"%");
            }
            if(StringUtils.isNotBlank(certNum)){
                criteria.andIdNumberLike("%"+certNum+"%");
            }

            example.or(criteria);
            List<OLResponseParam> data = responseParamMapper.selectByExample(example);
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
