package com.idm.app.ruleengine.modelManage.modelMonitor.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.ruleengine.modelManage.modelMonitor.mapper.VBlRuleIndexDataMapper;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VBlRuleIndexData;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VBlRuleIndexDataExample;
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
 * @Description: 准入模型数据监控
 * @Create: 2018/11/6 15:11
 * @Version: 1.0
 */
@Controller
public class BLInModelDataController {

    @Resource
    VBlRuleIndexDataMapper vBlRuleIndexDataMapper;

    private Logger logger = Logger.getLogger(BLInModelDataController.class);

    @RequestMapping("/in_model_data_page")
    public String indexManage(Model model){

        return "modelManage/modelMonitor/bl_data";
    }

    @RequestMapping("/in_model_data")
    @ResponseBody
    public Object indexService(String querySeqNo, String custName, String certNum, String prodId, String modleName, String page,String rows, HttpServletRequest request){
        //request.getAttribute("modleName");
        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            VBlRuleIndexDataExample example = new VBlRuleIndexDataExample();
            VBlRuleIndexDataExample.Criteria criteria = example.createCriteria();
            criteria.andModelNameIsNotNull();
            if(StringUtils.isNotBlank(querySeqNo)){
                criteria.andQuerySeqNoLike("%"+querySeqNo+"%");
            }
            if(StringUtils.isNotBlank(custName)){
                custName = new String(custName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andCustNameLike("%"+custName+"%");
            }
            if(StringUtils.isNotBlank(prodId)){
                criteria.andProdIdLike("%"+prodId+"%");
            }
            if(StringUtils.isNotBlank(modleName)){
                modleName = new String(modleName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andModelNameLike("%"+modleName+"%");
            }
            if(StringUtils.isNotBlank(certNum)){
                criteria.andCertNumLike("%"+certNum+"%");
            }
            example.or(criteria);
            List<VBlRuleIndexData> data = vBlRuleIndexDataMapper.selectByExample(example);
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
