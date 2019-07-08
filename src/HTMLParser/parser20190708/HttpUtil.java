package HTMLParser.parser20190708;


import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by ZhaoTao on 2016/3/15.
 */
public class HttpUtil {

    /**
     * @param u
     * @param json
     * @return
     * @throws IOException
     */

    public static String openUrl(String u, String json) throws IOException {
        URL url = new URL(u);    // 把字符串转换为URL请求地址
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接


        if (null != json) {
//        	connection.setRequestMethod("POST");
//        	connection.setRequestProperty("Content-Type", "application/x-javascript; charset="+ "UTF-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.connect();// 连接会话
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
            osw.write(json);
            osw.flush();
            osw.close();
        } else {
            connection.connect();// 连接会话
        }

        // 获取输入流
        int respCode = connection.getResponseCode();
        String temp = null;
        if (respCode == 200) {
            temp = ConvertStream2Json(connection.getInputStream());
            //log.info(temp);
        }
        connection.disconnect();// 断开连接
        return temp;
    }

    /**
     * @param u
     * @param json
     * @return
     * @throws IOException
     */

    public static String openUrl1(String u, String json) throws IOException {
        URL url = new URL(u);    // 把字符串转换为URL请求地址
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接


        if (null != json) {
//        	connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=" + "UTF-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.connect();// 连接会话
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
            osw.write(json);
            osw.flush();
            osw.close();
        } else {
            connection.connect();// 连接会话
        }

        // 获取输入流
        int respCode = connection.getResponseCode();
        String temp = null;
        if (respCode == 200) {
            temp = ConvertStream2Json(connection.getInputStream());
            //log.info(temp);
        }
        connection.disconnect();// 断开连接
        return temp;
    }

    public static String openUrl2(String u, String json) throws IOException {
        // 建立连接
        URL url = new URL(u);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        // //设置连接属性
        httpConn.setDoOutput(true);// 使用 URL 连接进行输出
        httpConn.setDoInput(true);// 使用 URL 连接进行输入
        httpConn.setUseCaches(false);// 忽略缓存
        httpConn.setRequestMethod("POST");// 设置URL请求方法

        // 设置请求属性
        // 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
        byte[] requestStringBytes = json.getBytes("utf-8");
        httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length);
        httpConn.setRequestProperty("Content-Type", "application/octet-stream");
        httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
        httpConn.setRequestProperty("Charset", "UTF-8");


        // 建立输出流，并写入数据
        OutputStream outputStream = httpConn.getOutputStream();
        outputStream.write(requestStringBytes);
        outputStream.close();
        // 获得响应状态
        int responseCode = httpConn.getResponseCode();

        StringBuffer sb = new StringBuffer();
        if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
            // 当正确响应时处理数据
            String readLine;
            BufferedReader responseReader;
            // 处理响应流，必须与服务器响应流输出的编码一致
            responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            while ((readLine = responseReader.readLine()) != null) {
                sb.append(readLine).append("\n");
            }
            responseReader.close();
        }
        return sb.toString();
    }


    private static String ConvertStream2Json(InputStream inputStream) {
        String jsonStr = "";
        // ByteArrayOutputStream相当于内存输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        // 将输入流转移到内存输出流中
        try {
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, len);
            }
            // 将内存流转换为字符串
            jsonStr = new String(out.toByteArray(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }


    public static String openUrlJsonParam(String u, String json, String content, String type) throws IOException {
        URL url = new URL(u);    // 把字符串转换为URL请求地址
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
        if (null != json) {
            connection.setRequestMethod("POST");
            connection.setRequestProperty(content, type);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.connect();// 连接会话
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            osw.write(json);
            osw.flush();
            osw.close();
        } else {
            connection.connect();// 连接会话
        }

        // 获取输入流
        int respCode = connection.getResponseCode();
        String temp = null;
        if (respCode == 200) {
            temp = ConvertStream2Json(connection.getInputStream());
            /* log.info(temp);*/
        }
        connection.disconnect();// 断开连接
        return temp;
    }

    /**
     * 对象转化为参数
     *
     * @param o
     * @param t
     * @param prefix 前缀
     * @return
     * @throws Exception
     */
    public static String getParms(Object o, Class t, String prefix) throws Exception {
        StringBuilder sb = new StringBuilder();
        PropertyDescriptor[] properties = Introspector.getBeanInfo(t)  //获得对象属性集合
                .getPropertyDescriptors();
        Method getMethod = null;
        for (PropertyDescriptor p : properties) {
            if ("class".equals(p.getName())) {
                continue;
            }
            getMethod = p.getReadMethod();
            String value = (String) getMethod.invoke(o);
            if (null != value) {
                if (null != prefix) {
                    sb.append(prefix).append(".");
                }
                sb.append(p.getName()).append("=").append(value).append("&");
            }
        }
        if (sb.length() > 0) {
            return sb.toString().substring(0, sb.length() - 1);
        }
        return "";
    }

}
