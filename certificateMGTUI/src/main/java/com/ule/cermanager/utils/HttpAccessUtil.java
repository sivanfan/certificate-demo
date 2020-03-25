package com.ule.cermanager.utils;

import com.ule.cermanager.model.Request;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName HttpAccessUtil
 * @Author fanxl
 * @Description //TODO
 * @Date 9:39  2019/1/25
 * @Version 1.0
 **/
public class HttpAccessUtil {

    /**
     * 采取post方式提交序列化后的object对象 </br>
     * 另请参考：java.io.ObjectInputStream/ObjectOutputStream
     *
     * @param requestUrl       请求地址
     * @param connTimeoutMills 设置连接主机超时，单位：毫秒
     * @param readTimeoutMills 设置从主机读取数据超时，单位：毫秒
     * @param serializedObject 序列化后的object对象
     * @return remoteHttp返回的结果
     */
    public static Request httpPostSerialObject(String requestUrl, int connTimeoutMills,
                                              int readTimeoutMills, Object serializedObject) throws Exception {
        HttpURLConnection httpUrlConn = null;
        InputStream inputStream = null;
        //InputStreamReader inputStreamReader = null;
        //BufferedReader bufferedReader = null;
        ObjectOutputStream oos = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            httpUrlConn = (HttpURLConnection) url.openConnection();
            // 设置content_type=SERIALIZED_OBJECT
            // 如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException
            httpUrlConn.setRequestProperty("Content-Type", "application/x-java-serialized-object");
            httpUrlConn.setConnectTimeout(connTimeoutMills);
            httpUrlConn.setReadTimeout(readTimeoutMills);
            // 设置是否向httpUrlConn输出，因为是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false
            httpUrlConn.setDoOutput(true);
            // 设置是否从httpUrlConn读入，默认情况下是true
            httpUrlConn.setDoInput(true);
            // 不使用缓存
            httpUrlConn.setUseCaches(false);

            // 设置请求方式，默认是GET
            httpUrlConn.setRequestMethod("POST");
            httpUrlConn.addRequestProperty("Charset","UTF-8");//设置字符编码类型
            httpUrlConn.connect();

            if (serializedObject != null) {
                // 此处getOutputStream会隐含的进行connect，即：如同调用上面的connect()方法，
                // 所以在开发中不调用上述的connect()也可以，不过建议最好显式调用
                // write object(impl Serializable) using ObjectOutputStream
                oos = new ObjectOutputStream(httpUrlConn.getOutputStream());
                oos.writeObject(serializedObject);
                oos.flush();
                // outputStream不是一个网络流，充其量是个字符串流，往里面写入的东西不会立即发送到网络，
                // 而是存在于内存缓冲区中，待outputStream流关闭时，根据输入的内容生成http正文。所以这里的close是必须的
                oos.close();
            }
            // 将返回的输入流转换成字符串
            // 无论是post还是get，http请求实际上直到HttpURLConnection的getInputStream()这个函数里面才正式发送出去
            inputStream = httpUrlConn.getInputStream();//注意，实际发送请求的代码段就在这里

            ObjectInputStream ois = null;
            ois = new ObjectInputStream(inputStream);
            Object value = ois.readObject();
            //Object body=((Request)value).getBody();
            return (Request)value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //bufferedReader.close();
                //inputStreamReader.close();
                inputStream.close();
                oos.close();
                if (httpUrlConn != null) {
                    httpUrlConn.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
