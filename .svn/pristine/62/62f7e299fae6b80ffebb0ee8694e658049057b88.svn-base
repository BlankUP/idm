package com.idm.app.apiservice.datasourceManage.externalDatasourceManage.controller;

import com.alibaba.druid.proxy.jdbc.ClobProxyImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.apiservice.datasourceManage.externalDatasourceManage.mapper.VExternalDataMapper;
import com.idm.app.apiservice.datasourceManage.externalDatasourceManage.model.VExternalData;
import com.idm.app.apiservice.datasourceManage.externalDatasourceManage.model.VExternalDataExample;
import com.idm.common.page.PageVo;
import com.idm.common.util.MybatisUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author lifadeng
 * @Description: 外部数据源管理
 * @Create: 2018/11/7 20:11
 * @Version: 1.0
 */
@Controller
public class ExternalDatasourceController {

    @Resource
    VExternalDataMapper externalDataMapper;

    private Logger logger = Logger.getLogger(ExternalDatasourceController.class);

    @RequestMapping("/external_data_page")
    public String external_data_page(Model model){

        return "datasourceManage/externalDatasourceManage";
    }

    @RequestMapping("/external_data")
    @ResponseBody
    public Object indexService(String querySeqNo,String custName,String certNum,String serviceId,String serviceName,String page,String rows, HttpServletRequest request){

        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            VExternalDataExample example = new VExternalDataExample();
            VExternalDataExample.Criteria criteria = example.createCriteria();
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
            if(StringUtils.isNotBlank(serviceId)){
                criteria.andServiceIdLike("%"+serviceId+"%");
            }
            if(StringUtils.isNotBlank(serviceName)){
                serviceName = new String(serviceName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andServiceNameLike("%"+serviceName+"%");
            }
            example.or(criteria);
            List<VExternalData> data = externalDataMapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo(data);
            pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
            pv.setRows(data);
        }catch (Exception e){
            logger.error(e);
            pv.setError(e.getMessage());
        }
        return pv;
    }

    @RequestMapping("/external_data_clob")
    @ResponseBody
    public Object external_data_clob(String uuid,String tableName){
        Map map = externalDataMapper.selectClobByUUIDAndTableName(tableName,uuid);
        if(map!=null){
            try{
                ClobProxyImpl cpi = (ClobProxyImpl)map.get("RESULTDATE");
                String data = MybatisUtil.ClobToString(cpi.getRawClob());
                return data;
            }catch (Exception e){
                logger.error(e);
                return e.getMessage();
            }
        }
        return null;
    }

}
