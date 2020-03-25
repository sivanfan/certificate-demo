package com.ule.cerclient.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.util.Map;

/**
 * @Author fanxunli
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
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
}