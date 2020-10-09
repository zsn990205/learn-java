import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class httpRequest {
private String method;
private String url;
private String version;
private Map<String,String> headers = new HashMap<>(); //解析header
private Map<String,String> parameters = new HashMap<>(); //解析url参数和body的参数
private Map<String,String> cookies = new HashMap<>(); //解析cookie
private String body;

    public static httpRequest build (InputStream inputStream) throws IOException {
        httpRequest request = new httpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //1.解析首行 包括 method url version
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        //2.解析url ?后是Url (不是很清楚)
        int pos = request.url.indexOf("?");
        if (pos != -1) {
           //说明url存在 此时可以对url进行解析
           String parameters = request.url.substring(pos+1);
           parseKV(parameters,request.parameters);
        }
        //3.解析headers headers是以键值对形式存储的
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
            //headers的内容是以": "分开的
            String[] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0],headerTokens[1]);
        }
        //4.解析cookies
        String cookie = request.headers.get("cookie");
        if (cookie != null) {
            parseCookie(cookie,request.cookies);
        }
        //5.解析body
        //思路:body中需要解析的包括:POST PUT方法
        //得到这个方法之后 先去求字节长度并设置缓冲区 body字符串的长度就是读到的缓冲区的长度
        //根据缓冲区buffer和缓冲区长度设置body的字符串
        //对body字符串进行解析 同url解析
        //body在method为POST时才需要解析
        if ("POST".equalsIgnoreCase(request.method) ||
                "PUT".equalsIgnoreCase(request.method)) {
        //在这里 countLength得到的是 字节长度
            //去拿headers方法中的Content-Length 从而才能设置缓冲区
            int countLength = Integer.parseInt(request.headers.get("Content-Length"));
        //设置缓冲区
        //假设上面的字节长度为100 那么缓冲区一定要远远大于字节长度 万一长了放不下就凉了
        //在这里 不用吝惜
        //char字符的字节长度为200
            char[] buffer = new char[countLength];
            int len = bufferedReader.read(buffer);
            //构建字符串
            request.body = new String(buffer,0,len);
            //body中的格式形如:username="哈哈哈"&password=123;
            //上面定义了 url和body的参数都在parameters中 因此公用parseKV方法
            parseKV(request.body,request.parameters);
        }
        return request;
    }

    private static void parseCookie(String input, Map<String, String> output) {
        //cookie是以;=方式存储的
        String[] cookie = input.split(";");
        for (String c : cookie) {
            String[] cookies = c.split("=");
            output.put(cookies[0],cookies[1]);
        }
    }

    private static void parseKV(String input, Map<String, String> output) {
        //先将url以 & 分开
        String[] kvTokens = input.split("&");
        for (String kv : kvTokens) {
        //再将其以"="形式分开
        String[] ret = kv.split("=");
        output.put(ret[0],ret[1]);
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getBody() {
        return body;
    }
    public String getHeaders(String key) {
        return headers.get(key);
    }
    public String getParameter(String key) {
        return parameters.get(key);
    }
    public String getCookie(String k) {
        return cookies.get(k);
    }
}
