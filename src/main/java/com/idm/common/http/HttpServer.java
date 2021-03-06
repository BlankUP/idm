package com.idm.common.http;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductInterface;
import com.idm.app.idpconfig.proModelParaConfig.service.ProductConfigService;

/**
 * <p>
 * Title: HttpServer
 * </p>
 * 
 * @Description: http服务端
 * @author wangke
 * @date 2019年2月19日
 * @version 1.0
 */
@Controller
@RequestMapping("/api/pmp/notification")
public class HttpServer {

	static Logger logger = Logger.getLogger(HttpServer.class);
	@Autowired
	private ProductConfigService productConfigService;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> service(@RequestBody String jsonStr) {
		logger.info("******接收到的请求数据:" + jsonStr);
		Map<String, String> returnMap = new HashMap<String, String>();
		JSONObject json1 = (JSONObject) JSON.parseObject(jsonStr);
		String uuid = json1.getString("uuid");
		JSONArray responseData = (JSONArray) json1.get("responseData");

		try {

			ProductInterface productInterface = new ProductInterface();
			// 保存推送原始报文
			productInterface.setUuid(uuid);
			productInterface.setData(jsonStr);
			productInterface.setCreateTime(sdf.format(new Date()));
			productConfigService.addProductInterface(productInterface);

			for (int i = 0; i < responseData.size(); i++) {
				// 获取JSON中数据
				JSONObject data = (JSONObject) responseData.get(i);
				logger.info("data:" + data);
				String productCode = data.getString("PRODUCT_CODE");
				String sort = data.getString("PRODUCT_SORT");
				String prodeucName = data.getString("PRODUCT_NAME");
				String status = data.getString("IS_EFFECT");
				// 装入产品实体类
				ProductBaseInfo product = new ProductBaseInfo();
				product.setProductcode(productCode);
				product.setProductid(productCode);
				product.setProductname(prodeucName);
				product.setSort(sort);
				product.setStatus(status);
				product.setCreatetime(sdf.format(new Date()));
				product.setUpdatetime(sdf.format(new Date()));

				logger.info("product:" + product);
				int num = productConfigService.selectCountByCodeAll(product);
				logger.info("num:" + num);
				if (num == 0) {

					productConfigService.addProductInfo(product);
				} else {
					productConfigService.updateProductInfo(product);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("产品数据接收失败，uuid：" + uuid);
			returnMap.put("uuid", uuid);// 以实际的传输uuid数据为准
			returnMap.put("returnMsg", "ERROR");// 值：SUCCESS、ERROR
			return returnMap;
			// TODO: handle exception
		}

		returnMap.put("uuid", uuid);// 以实际的传输uuid数据为准
		returnMap.put("returnMsg", "SUCCESS");// 值：SUCCESS、ERROR
		return returnMap;
	}

}