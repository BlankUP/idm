package com.idm.app.ruleengine.modelManage.modelMonitor.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.ruleengine.modelManage.modelMonitor.mapper.VScoreModelDataMapper;
import com.idm.app.ruleengine.modelManage.modelMonitor.mapper.VScoreModelDetailMapper;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.*;
import com.idm.common.page.PageVo;
import com.idm.common.util.DownloadUtil;
import com.idm.common.util.ExcelExport;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author lifadeng
 * @Description: 评分模型数据监控
 * @Create: 2018/11/6 15:11
 * @Version: 1.0
 */
@Controller
public class ScoreModelDataController {

    @Resource
    VScoreModelDataMapper scoreModelDataMapper;
    @Resource
    VScoreModelDetailMapper scoreModelDetailMapper;

    private Logger logger = Logger.getLogger(ScoreModelDataController.class);

    @RequestMapping("/score_model_data_page")
    public String indexManage(Model model){

        return "modelManage/modelMonitor/score_model_data";
    }

    @RequestMapping("/score_model_data")
    @ResponseBody
    public Object indexService(String querySeqNo,String custName,String prodId, String modleName, String certNum, String page,String rows, HttpServletRequest request){
        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            VScoreModelDataExample example = new VScoreModelDataExample();
            VScoreModelDataExample.Criteria criteria = example.createCriteria();

            if(StringUtils.isNotBlank(querySeqNo)){
                criteria.andQuerySeqNoLike("%"+querySeqNo.trim()+"%");
            }
            if(StringUtils.isNotBlank(custName)){
                custName = new String(custName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andCustNameLike("%"+custName.trim()+"%");
            }
            if(StringUtils.isNotBlank(prodId)){
                criteria.andProdIdLike("%"+prodId.trim()+"%");
            }
            if(StringUtils.isNotBlank(modleName)){
                modleName = new String(modleName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andModelNameLike("%"+modleName+"%");
            }
            if(StringUtils.isNotBlank(certNum)){
                criteria.andCertNumLike("%"+certNum.trim()+"%");
            }
            example.or(criteria);
            List<VScoreModelData> data = scoreModelDataMapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo(data);
            pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
            pv.setRows(data);
        }catch (Exception e){
            logger.error(e);
            pv.setError(e.getMessage());
        }
        return pv;
    }

    @RequestMapping("/score_model_detail")
    @ResponseBody
    public Object detailService(String querySeqNo, HttpServletRequest request){
        try{
            VScoreModelDetailExample example = new VScoreModelDetailExample();
            VScoreModelDetailExample.Criteria criteria = example.createCriteria();

            if(StringUtils.isNotBlank(querySeqNo)){
                criteria.andQuerySeqNoEqualTo(querySeqNo.trim());
            }
            example.or(criteria);
            List<VScoreModelDetail> data = scoreModelDetailMapper.selectByExample(example);
            return data;
        }catch (Exception e){
            logger.error(e);
            return e.getMessage();
        }
    }


    @RequestMapping("/score_model_data_export")
    @ResponseBody
    public Object score_model_data_export(String querySeqNo, String custName, String prodId, String modleName, String certNum, String page, String rows, HttpServletRequest request, HttpServletResponse response){
        //int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        //int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            //PageHelper.startPage(pageNum,pageSize);
            VScoreModelDataExample example = new VScoreModelDataExample();
            VScoreModelDataExample.Criteria criteria = example.createCriteria();

            if(StringUtils.isNotBlank(querySeqNo)){
                criteria.andQuerySeqNoLike("%"+querySeqNo.trim()+"%");
            }
            if(StringUtils.isNotBlank(custName)){
                custName = new String(custName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andCustNameLike("%"+custName.trim()+"%");
            }
            if(StringUtils.isNotBlank(prodId)){
                criteria.andProdIdLike("%"+prodId.trim()+"%");
            }
            if(StringUtils.isNotBlank(modleName)){
                modleName = new String(modleName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andModelNameLike("%"+modleName+"%");
            }
            if(StringUtils.isNotBlank(certNum)){
                criteria.andCertNumLike("%"+certNum.trim()+"%");
            }
            example.or(criteria);
            List<VScoreModelData> data = scoreModelDataMapper.selectByExample(example);
            //PageInfo pageInfo = new PageInfo(data);
            for(int i=0;i<data.size();i++){
                data.get(i).setCertType("身份证");
            }
            String sheetName = "评分模型数据导出";
            String[] fields = {"querySeqNo","custName","certType","certNum","prodName","modelName","creditScore","creditMoney","baseLine","amountAssets","salaryAmount","quotaAdjustment","dayRate","dateTime"};
            String[] titles = {"业务流水号", "客户名称", "证件类型", "证件号码", "产品名称","模型名称","授信评分","授信额度","基础额度","资产额度","工资额度","额度调整","执行利率(万分之)", "授信日期"};
            byte[] bytes = ExcelExport.exportSingleSheet(sheetName,fields,titles,data);
            DownloadUtil.downloadExcel(bytes,sheetName,request,response);
            return null;
        }catch (Exception e){
            logger.error(e);
            return e.getMessage();
        }
    }
}
