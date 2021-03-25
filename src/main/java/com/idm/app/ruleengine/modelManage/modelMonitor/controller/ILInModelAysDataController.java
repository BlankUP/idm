package com.idm.app.ruleengine.modelManage.modelMonitor.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.ruleengine.modelManage.modelMonitor.mapper.VIlAysDataMapper;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VIlAysData;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VIlAysDataExample;
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
 * @Description: 贷中模型分析数据监控
 * @Create: 2018/11/6 15:11
 * @Version: 1.0
 */
@Controller
public class ILInModelAysDataController {

    @Resource
    VIlAysDataMapper vIlAysDataMapper;

    private Logger logger = Logger.getLogger(ILInModelAysDataController.class);

    @RequestMapping("/il_ays_data_page")
    public String indexManage(Model model){

        return "modelManage/modelMonitor/il_ays_data";
    }

    @RequestMapping("/il_ays_data")
    @ResponseBody
    public Object indexService(String ruleName,String modleName,String productNo,String page,String rows, HttpServletRequest request){
        //request.getAttribute("modleName");
        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            VIlAysDataExample example = new VIlAysDataExample();
            VIlAysDataExample.Criteria criteria = example.createCriteria();
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
            List<VIlAysData> data = vIlAysDataMapper.selectByExample(example);
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
