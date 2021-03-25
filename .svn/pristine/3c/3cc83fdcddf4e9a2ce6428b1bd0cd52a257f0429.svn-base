package com.idm.app.ruleengine.modelManage.indexManage.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.ruleengine.modelManage.indexManage.mapper.VModelIndexHitDataMapper;
import com.idm.app.ruleengine.modelManage.indexManage.model.IndexData;
import com.idm.app.ruleengine.modelManage.indexManage.model.VModelIndexHitData;
import com.idm.app.ruleengine.modelManage.indexManage.model.VModelIndexHitDataExample;
import com.idm.common.page.PageVo;
import org.apache.commons.lang.StringUtils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 指标管理
 */
@Controller
public class IndexManageController {

    @Resource
    VModelIndexHitDataMapper modelIndexHitDataMapper;

    private Logger logger = Logger.getLogger(IndexManageController.class);

    @RequestMapping("/indexStatistics")
    public String indexManage(Model model){

        return "modelManage/indexMonitor/indexStatistics";
    }

    @RequestMapping("/custIndexQuery")
    public String custIndexQuery(Model model){

        return "modelManage/indexMonitor/custIndexQuery";
    }

    @RequestMapping("/index_service")
    @ResponseBody
    public Object indexService(String ruleNo,String modleName,String productNo,String querySeqNo,String custName,String certNum,String custNo,String page,String rows, HttpServletRequest request){
        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            VModelIndexHitDataExample example = new VModelIndexHitDataExample();
            VModelIndexHitDataExample.Criteria criteria = example.createCriteria();
            criteria.andProdNameIsNotNull();
            if(StringUtils.isNotBlank(ruleNo)){
                criteria.andRuleIdLike("%"+ruleNo+"%");
            }
            if(StringUtils.isNotBlank(modleName)){
                modleName = new String(modleName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andModelNameLike("%"+modleName+"%");
            }
            if(StringUtils.isNotBlank(productNo)){
                criteria.andProdIdLike("%"+productNo+"%");
            }
            if(StringUtils.isNotBlank(querySeqNo)){
                criteria.andQuerySeqNoLike("%"+querySeqNo+"%");
            }
            if(StringUtils.isNotBlank(custName)){
                custName = new String(custName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andCustNameLike("%"+custName+"%");
            }
            if(StringUtils.isNotBlank(certNum)){
                criteria.andCertNumLike("%"+certNum+"%");
            }
            if(StringUtils.isNotBlank(custNo)){
                criteria.andCustNoLike("%"+custNo+"%");
            }
            example.or(criteria);
            List<VModelIndexHitData> data = modelIndexHitDataMapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo(data);
            pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
            pv.setRows(data);
        }catch (Exception e){
            logger.error(e);
            pv.setError(e.getMessage());
        }
        return pv;
    }

    @RequestMapping("/index_line_service")
    @ResponseBody
    public Object index_line_service(String type, String ruleNo,String modleName,String productNo,String page,String rows, HttpServletRequest request){
        JSONObject result = new JSONObject();
        List<IndexData> line_data = null;
        if("use".equals(type)){ //使用率
            line_data =  modelIndexHitDataMapper.selectByLineData(ruleNo,modleName,productNo);
        }else if("hit".equals(type)){//命中率
            line_data =  modelIndexHitDataMapper.selectByLineHitData(ruleNo,modleName,productNo);
        }

        if(line_data!=null && line_data.size()>0){
            ArrayList array = new ArrayList();
            for(int i=0;i<line_data.size();i++){
                IndexData tmp = line_data.get(i);
                Map map = new HashMap<>();
                map.put("name",tmp.getKey());
                map.put("icon","bar");
                array.add(map);
            }
            result.put("array", JSONObject.toJSON(array));
        }
        result.put("data", line_data);
        result.put("msg", "success");

        return result;
    }
}
