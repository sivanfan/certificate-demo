package com.ule.cerclient.service;

import com.ule.cerclient.exception.CerSignException;

/**
 * @Author fanxl
 * @Description //TODO
 * @Date 11:29 2019/1/18
 * @Param 
 * @return 
 **/
public interface CerSignService {
	/**
	 * @Author fanxl
	 * @Description //TODO
	 * @Date 11:30 2019/1/18
	 * @Param [busiName, sysName, cerType]
	 * @return java.lang.Byte[]
	 **/
	byte[] getInsideCerFile(String busiName,String sysName,int cerType,int cerEnv) throws CerSignException;
	/**
	 * @Author fanxl
	 * @Description //TODO
	 * @Date 11:30 2019/1/18
	 * @Param [busiName, sysName, channelCode]
	 * @return java.lang.Byte[]
	 **/
	byte[] getOutsideCerFile(String busiName,String sysName,String channelCode,int cerEnv) throws CerSignException;
}
