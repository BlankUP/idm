package com.idm.app.ruleengine.modelManage.modelMonitor.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.ruleengine.modelManage.modelMonitor.mapper.VDmAysDataMapper;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VDmAysData;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VDmAysDataExample;
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
 * @Description: 支用模型分析数据监控
 * @Create: 2018/11/6 15:11
 * @Version: 1.0
 */
@Controller
public class DMInModelAysDataController {

    @Resource
    VDmAysDataMapper vDmAysDataMapper;

    private Logger logger = Logger.getLogger(DMInModelAysDataController.class);

    @RequestMapping("/dm_ays_data_page")
    public String indexManage(Model model){

        return "modelManage/modelMonitor/dm_ays_data";
    }

    @RequestMapping("/dm_ays_data")
    @ResponseBody
    public Object indexService(String ruleName,String modleName,String productNo,String page,String rows, HttpServletRequest request){
        //request.getAttribute("modleName");
        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            VDmAysDataExample example = new VDmAysDataExample();
            VDmAysDataExample.Criteria criteria = example.createCriteria();
            if(StringUtils.isNotBlank(ruleName)){
                criteria.andRuleNameLike("%"+ruleName+"%");
            }
            if(StringUtils.isNotBlank(modleName)){
                modleName = new String(modleName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andModelNameLike("%"+modleName+"%");
            }
            if(StringUtils.isNotBlank(productNo)){
                criteria.andProdIdLike("%"+productNo+"%");
            }
            example.or(criteria);
            List<VDmAysData> data = vDmAysDataMapper.selectByExample(example);
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
