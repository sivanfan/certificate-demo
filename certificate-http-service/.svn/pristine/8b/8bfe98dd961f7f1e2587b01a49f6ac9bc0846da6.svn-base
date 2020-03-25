package com.ule.cerservice;

import com.ule.cerservice.utils.UnirestUtil;
import com.mashape.unirest.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/7/9.
 */
public class Test {
    /**
     * 冒泡排序
     * @param arr
     */
    public static void BubbleSort(int[] arr) {
        int temp;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
      /*  BigDecimal BOP_TRANSAC_AMT=new BigDecimal(100);
        BigDecimal	DECLARE_AMT=new BigDecimal(99999.67);
        BigDecimal b=BOP_TRANSAC_AMT.divide(DECLARE_AMT,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(b);


        System.out.println((int)(2*2*0.85));*/


        /*int[] arr = new int[]{1,6,5,3,2};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));*/

       /* String s="\"N/A\",\"N/A\",\"\",\"成功\",\"\",1";
        String[] a=commaDivider(s);
        System.out.println(a);*/

        HttpResponse<String> response= UnirestUtil.post("http://localhost:8764/testRestful","cerinfo","creereereree");
        System.out.println(response.getBody());
    }


    public static String [] commaDivider(String sss){
        //双引号开始标记
        int qutationStart =0;
        //双引号结束标记
        int qutationEnd =0;
        char[] charStr = sss.toCharArray();
        //用于拼接字符 作为一个字段值
        StringBuffer sbf = new StringBuffer();
        //结果list
        List<String> list = new ArrayList<String>();
        for(int i=0;i<charStr.length;i++) {
            if(qutationStart == 0&&charStr[i] == '\"') {
                qutationStart = 1;
                qutationEnd = 0;
                continue;
            } else if(qutationStart == 1&&charStr[i] == '\"'){
                qutationStart = 0;
                qutationEnd = 1;
                if(i == charStr.length-1) {
                    list.add(sbf.toString());
                    sbf.setLength(0);
                }
                continue;
            } else if(qutationStart == 1&&charStr[i] == ','&&qutationEnd == 0) {
                //处理 \"PAMINS INDUSTRIAL CO., LIMITED\"这种不规范的字符串
                sbf.append(charStr[i]);
                continue;
            } else if(charStr[i] == ',') {
                list.add(sbf.toString());
                sbf.setLength(0);
                continue;
            }
            sbf.append(charStr[i]);
            if(i == charStr.length-1&&sbf.length()!=0) {
                list.add(sbf.toString());
                sbf.setLength(0);
            }
        }

        return (String[])list.toArray(new String[list.size()]);
    }
}
