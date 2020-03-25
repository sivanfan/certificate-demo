package com.ule.cerclient.utils;

import com.ule.cerclient.service.CerSignService;
import com.ule.cerclient.service.impl.CerSignServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CerUtil {

    public static Map getCerInfo(byte[] cer){
        Map infoMap=new HashMap();
        try {
            // 读取证书文件
            InputStream inStream = new ByteArrayInputStream(cer);
            // 创建X509工厂类
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            // 创建证书对象
            X509Certificate oCert = (X509Certificate) cf.generateCertificate(inStream);
            inStream.close();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            // 获得证书版本
            String cerVersion = String.valueOf(oCert.getVersion());
            System.out.println("证书版本:" + cerVersion);
            infoMap.put("Version",cerVersion);
            // 获得证书序列号
            String SerialNumber = oCert.getSerialNumber().toString(16);
            System.out.println("证书序列号:" + SerialNumber);
            infoMap.put("SerialNumber",SerialNumber);
            // 获得证书有效期
            Date beforedate = oCert.getNotBefore();
            String NotBefore = dateformat.format(beforedate);
            System.out.println("证书生效日期:" + NotBefore);
            infoMap.put("NotBefore",NotBefore);

            Date afterdate = oCert.getNotAfter();
            String NotAfter = dateformat.format(afterdate);
            System.out.println("证书失效日期:" + NotAfter);
            infoMap.put("NotAfter",NotAfter);

            // 获得证书主体信息
            String SubjectDNName = oCert.getSubjectDN().getName();
            System.out.println("证书拥有者:" + SubjectDNName);
            infoMap.put("SubjectDNName",SubjectDNName);

            // 获得证书颁发者信息
            String IssuerDNName = oCert.getIssuerDN().getName();
            System.out.println("证书颁发者:" + IssuerDNName);
            infoMap.put("IssuerDNName",IssuerDNName);

            // 获得证书签名算法名称
            String SigAlgName = oCert.getSigAlgName();
            System.out.println("证书签名算法:" + SigAlgName);
            infoMap.put("SigAlgName",SigAlgName);

        } catch (Exception e) {
            System.out.println("解析证书出错！");
            e.printStackTrace();
        }
        return infoMap;
    }

    private static CerSignService cerSignService = new CerSignServiceImpl();
    public static void main(String[] args) throws Exception{
        //byte[] cer=cerSignService.getOutsideCerFile("ep","ep-order","weixin");


        File f = new File("I:\\cer\\wallkey.pfx");
        FileInputStream fis = new FileInputStream( f );
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fis.close();
        String imgStr = ConvertUtil.byte2hex( bytes );
        System.out.println( imgStr);

       // CerUtil.getCerInfo(cer);
    }
}
