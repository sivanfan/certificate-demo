package com.ule.cerservice.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName ShellUtil
 * @Author fanxl
 * @Description //TODO
 * @Date 14:47  2019/3/7
 * @Version 1.0
 **/
public class ShellUtil {
    public static int runShell(String shStr) throws Exception {

        Process process;
        process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", shStr});
        int result=process.waitFor();
        return result;
    }
}
