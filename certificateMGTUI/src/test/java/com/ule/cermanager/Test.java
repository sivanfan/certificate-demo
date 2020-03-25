package com.ule.cermanager;

import com.alibaba.fastjson.JSON;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.ule.cermanager.model.systemside.ProjectInfo;
import com.ule.cermanager.utils.UnirestUtil;
import com.mashape.unirest.http.HttpResponse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 2018/7/9.
 */
public class Test {

    public static void main(String[] args) {
        try {
            HttpResponse<String> response = Unirest.get("http://gr.uletm.com/sam/api/all")
                    .header("Content-Type", "application/json")
                    .asString();
            List<ProjectInfo> list =JSON.parseArray(response.getBody(), ProjectInfo.class);
            Set modles=new HashSet();
            for (ProjectInfo info:list){
                modles.add(info.getModule());
            }
            List<String> modelnames=new ArrayList<>(modles);
            ConcurrentHashMap<String,List<String>> module_apps=new ConcurrentHashMap();
            for (String modelname:modelnames){
                List<String> apps=new ArrayList();
                for (ProjectInfo info:list){
                    if (modelname.equals(info.getModule())){
                        apps.add(info.getApp());
                    }
                }
                module_apps.put(modelname,apps);
            }

            System.out.println(module_apps.get("ulepayment").size());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

}
