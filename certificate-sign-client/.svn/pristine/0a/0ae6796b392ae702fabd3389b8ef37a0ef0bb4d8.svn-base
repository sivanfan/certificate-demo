package com.ule.cerclient.service.impl;

import com.mashape.unirest.http.HttpResponse;
import com.ule.cerclient.config.Config;
import com.ule.cerclient.constant.Constants;
import com.ule.cerclient.exception.CerSignException;
import com.ule.cerclient.service.CerSignService;
import com.ule.cerclient.utils.ConvertUtil;
import com.ule.cerclient.utils.UnirestUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author fanxl
 * @Description 获取内外部证书
 * @Date 11:39 2019/1/18
 **/
public class CerSignServiceImpl implements CerSignService {
	private static Logger log = LogManager.getLogger(CerSignServiceImpl.class);
	/*
	 * @Author fanxl
	 * @Description 获取内部颁发的证书
	 * @Date 14:00 2019/1/18
	 * @Param [busiName, sysName, cerType]
	 * @return byte[]
	 **/
	@Override
	public byte[] getInsideCerFile(String busiName, String sysName, int cerType,int cerEnv) throws CerSignException {
		Map queryMap=new HashMap();
		queryMap.put("busiName",busiName);
		queryMap.put("sysName",sysName);
		queryMap.put("cerType",cerType);
		queryMap.put("cerSendType",1);
		queryMap.put("cerEnv",cerEnv);

		HttpResponse<String> response= UnirestUtil.post(Config.getServiceUrl()+"/cermanager/getCerInfo",queryMap);
		if("nocer".equals(response.getBody())){
			throw new CerSignException(Constants.RETURN_FAIL,"CerFile not found.");
		}else {
			return ConvertUtil.hex2byte(response.getBody());
		}
	}
	/*
	 * @Author fanxl
	 * @Description 获取外部颁发的证书
	 * @Date 14:00 2019/1/18
	 * @Param [busiName, sysName, channelCode]
	 * @return byte[]
	 **/
	@Override
	public byte[] getOutsideCerFile(String busiName, String sysName, String channelCode,int cerEnv) throws CerSignException {
		Map queryMap=new HashMap();
		queryMap.put("busiName",busiName);
		queryMap.put("sysName",sysName);
		queryMap.put("channelCode",channelCode);
		queryMap.put("cerSendType",2);
		queryMap.put("cerEnv",cerEnv);

		HttpResponse<String> response= UnirestUtil.post(Config.getServiceUrl()+"/cermanager/getCerInfo",queryMap);
		if("nocer".equals(response.getBody())){
			throw new CerSignException("999999","CerFile not found.");
		}else {
			log.info("cerString:"+response.getBody());
			return ConvertUtil.hex2byte(response.getBody());
		}
	}
}
