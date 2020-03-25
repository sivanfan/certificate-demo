package com.ule.cerclient.config;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @Description 工具包需要用到的配置参数类
 * @author fanxl
 *
 */
public class Config {
	public  static String serviceUrl;

	static{
		Properties config = new Properties();
		InputStream in = new Config().getClass().getClassLoader().getResourceAsStream("cersign.properties");
		try {
			config.load(in);
			serviceUrl=config.getProperty("certificateServiceUrl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getServiceUrl() {
		return serviceUrl;
	}

	public static void setServiceUrl(String serviceUrl) {
		Config.serviceUrl = serviceUrl;
	}
}
