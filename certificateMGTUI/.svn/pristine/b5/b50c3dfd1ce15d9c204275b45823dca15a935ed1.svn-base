package com.ule.cermanager.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * @Author fanxunli
 * @Description:
 * @Param:
 * @Return:
 * @Create: 19-1-10 下午5:46
 */
public class ConvertUtil {
	 public static void main(String[] args) {  
	        try{
	            /*File f = new File("/home/sivan/cer/wallkey.pfx");
	            FileInputStream fis = new FileInputStream( f );
	            byte[] bytes = new byte[fis.available()];    
	            fis.read(bytes);    
	            fis.close();
	                
	            // 生成字符串    
	            String imgStr = byte2hex( bytes );    
	            System.out.println( imgStr);    */
	                
	            /*OutputStream o = new FileOutputStream("/home/sivan/user-rsa111.pfx");
	            byte[] imgByte = hex2byte( imgStr );    
	            InputStream in = new ByteArrayInputStream( imgByte );    
	            byte[] b = new byte[1024];    
	            int nRead = 0;    
	            while( ( nRead = in.read(b) ) != -1 ){    
	                o.write( b, 0, nRead );    
	            }    
	            o.flush();    
	            o.close();    
	            in.close();  */
	                
	                
	        }catch(Exception e){    
	            e.printStackTrace();    
	        }finally{    
	        }
		// 生成字符串    
         String imgStr = byte2hex( "abced6666666".getBytes() );
         System.out.println( imgStr);

         byte[] imgByte = hex2byte( imgStr );
         System.out.println( new String(imgByte));
	    }
	    /** 
	     * 二进制转字符串 
	     * @param b byte数组 
	     * @return 二进制字符串 
	     */  
	    public static String byte2hex(byte[] b){  
	        StringBuffer sb = new StringBuffer();  
	        String stmp = "";  
	        for (int n = 0; n < b.length; n++) {  
	            stmp = Integer.toHexString(b[n] & 0XFF);  
	            if (stmp.length() == 1) {  
	                sb.append("0" + stmp);  
	            } else {  
	                sb.append(stmp);  
	            }  
	        }  
	        return sb.toString();  
	    }  
	    /** 
	     * 字符串转二进制 
	     * @param str 字符串 
	     * @return byte数组 
	     */  
	    public static byte[] hex2byte(String str) {  
	        if (str == null)  
	            return null;  
	        str = str.trim();  
	        int len = str.length();  
	        if (len == 0 || len % 2 == 1)  
	            return null;  
	        byte[] b = new byte[len / 2];  
	        try {  
	            for (int i = 0; i < str.length(); i += 2) {  
	                b[i / 2] = (byte) Integer.decode("0X" + str.substring(i, i + 2)).intValue();  
	            }  
	            return b;  
	        } catch (Exception e) {  
	            return null;  
	        }  
	    }  
}
