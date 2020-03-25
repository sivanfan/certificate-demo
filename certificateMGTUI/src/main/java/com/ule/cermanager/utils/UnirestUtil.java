package com.ule.cermanager.utils;

/**
 * @Author fanxunli
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @description
 * @author fanxunli
 * @date
 * @return
 */
public class UnirestUtil {

    public static HttpResponse<String> post(String url,Map queryMap){
        try {
            HttpResponse<String> jsonResponse = Unirest.post(url)
                    .header("accept", "application/json")
                    .fields(queryMap)
                    .asString();
            return jsonResponse;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static HttpResponse<String> get(String renderJson , String requestUrl) throws UnirestException{
        String getRequest = assembleGetRequest(renderJson,requestUrl);
        HttpResponse<String> response = Unirest.get(getRequest)
                .header("Content-Type", "application/json")
                .asString();
        return response;
    }

    @SuppressWarnings("unchecked")
    private static String assembleGetRequest(String renderJson, String requestUrl) {
        if(StringUtils.isBlank(renderJson)||StringUtils.isBlank(requestUrl)){
            return requestUrl;
        }
        StringBuffer sb = new StringBuffer(requestUrl+"?");
        Map<String,Object> map = JSON.parseObject(renderJson,Map.class);

        Iterator<Entry<String, Object>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, Object> next = it.next();
            String key = next.getKey();
            Object value = next.getValue();
            sb
                    .append(key)
                    .append("=")
                    .append(value)
                    .append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}