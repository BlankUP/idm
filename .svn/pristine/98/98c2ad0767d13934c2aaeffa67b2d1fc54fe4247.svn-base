package com.idm.app.ruleengine.datasourceManage.innerDatasourceManage.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.ruleengine.datasourceManage.common.mapper.VColCommentsMapper;
import com.idm.app.ruleengine.datasourceManage.common.model.VColComments;
import com.idm.app.ruleengine.datasourceManage.common.model.VColCommentsExample;
import com.idm.app.ruleengine.datasourceManage.innerDatasourceManage.mapper.BankInnerDataMapper;
import com.idm.app.ruleengine.datasourceManage.innerDatasourceManage.model.BankInnerData;
import com.idm.app.ruleengine.datasourceManage.innerDatasourceManage.model.BankInnerDataExample;
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
import java.util.List;
import java.util.Map;

/**
 * @Author lifadeng
 * @Description: 外部数据源管理
 * @Create: 2018/11/12 10:43
 * @Version: 1.0
 */
@Controller
public class InnerDataController {

    @Resource
    BankInnerDataMapper bankInnerDataMapper;
    @Resource
    VColCommentsMapper vColCommentsMapper;

    private Logger logger = Logger.getLogger(InnerDataController.class);

    @RequestMapping("/inner_data_page")
    public String external_data_page(Model model){

        return "datasourceManage/bankInnerData";
    }

    @RequestMapping("/inner_data")
    @ResponseBody
    public Object indexService(String querySeqNo,String custName,String certNum,String page,String rows, HttpServletRequest request){

        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageVo pv = null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            BankInnerDataExample example = new BankInnerDataExample();
            BankInnerDataExample.Criteria criteria = example.createCriteria();
            if(StringUtils.isNotBlank(custName)){
                custName = new String(custName.getBytes("ISO-8859-1"),"utf-8");
                criteria.andCustNameLike("%"+custName+"%");
            }
            if(StringUtils.isNotBlank(certNum)){
                criteria.andCertNumLike("%"+certNum+"%");
            }

            example.or(criteria);
            List<BankInnerData> data = bankInnerDataMapper.selectByExample(example);
            PageInfo pageInfo = new PageInfo(data);
            pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
            pv.setRows(data);
        }catch (Exception e){
            logger.error(e);
            pv.setError(e.getMessage());
        }
        return pv;
    }

    @RequestMapping("/get_data_by_uuid")
    @ResponseBody
    public Object get_data_by_uuid(String uuid, HttpServletRequest request){

        VColCommentsExample epm = new VColCommentsExample();
        VColCommentsExample.Criteria cte = epm.createCriteria();
        cte.andTableNameEqualTo("HANLINACADEMICIAN");
        ArrayList notin = new ArrayList();
        notin.add("UUID");
        notin.add("CUST_ID");
        notin.add("CUST_NAME");
        notin.add("BIRTH");
        notin.add("GENDER");
        notin.add("CERT_TYPE");
        notin.add("CERT_NUM");
        notin.add("MOBILE_NUM");
        notin.add("INPUTTIME");
        cte.andColumnNameNotIn(notin);
        cte.andColumnNameNotLike("%DATE%");
        cte.andColumnNameNotLike("%DT%");
        List<VColComments> cols = vColCommentsMapper.selectByExample(epm);

        List<Map<String,Object>> data = bankInnerDataMapper.selectByUUID(uuid);
        if(data!=null && data.size()>0){
            Map<String,Object> bid = data.get(0);
            JSONArray array = new JSONArray();
            for(int i=0;i<cols.size();i++){
                JSONObject result = new JSONObject();
                result.put("column_name",cols.get(i).getColumnName());
                result.put("column_value",bid.get(cols.get(i).getColumnName()));
                result.put("column_comments",cols.get(i).getComments());
                array.add(result);
            }
            return array;
        }
        return null;
    }

}
