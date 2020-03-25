package com.ule.cermanager.utils;

import com.alibaba.fastjson.JSON;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.ule.cermanager.model.systemside.ProjectInfo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @ClassName ProjectInfoUtil
 * @Author fanxl
 * @Description //TODO
 * @Date 10:25  2019/2/22
 * @Version 1.0
 **/
public class ProjectInfoUtil {
    private final static ConcurrentHashMap<String,List<String>> module_apps=new ConcurrentHashMap();

    public static List<String> getProjectInfoMap(String url){
        List<String>  modles=new ArrayList<>();
        try {
            HttpResponse<String> response = Unirest.get(url)
                    .header("Content-Type", "application/json")
                    .asString();
            List<ProjectInfo> list = JSON.parseArray(response.getBody(), ProjectInfo.class);
            for (ProjectInfo info:list){
                modles.add(info.getModule());
            }
            for (String model:modles){
                List<String> apps=new ArrayList();
                for (ProjectInfo info:list){
                    if (model.equals(info.getModule())){
                        apps.add(info.getApp());
                    }
                }
                module_apps.put(model,apps);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return  modles.stream().distinct().sorted(Comparator.comparing(String::toLowerCase)).collect(Collectors.toList());
    }

    public static List<String> getApps(String moduleNme){
        List<String>  apps=new ArrayList<>();
        if (module_apps.get(moduleNme)!=null){
            apps=module_apps.get(moduleNme);
        }
        return apps.stream().distinct().sorted(Comparator.comparing(String::toLowerCase)).collect(Collectors.toList());
    }
}
