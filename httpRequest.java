import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class httpRequest {
    //解析并表示请求(反序列化过程)->Bit流转换成结构化数据
    private String method;
    //url的参数 index.html?[a=10&b=20]->url参数->也是键值对
    private String url;
    private String version;
    private Map<String,String> headers = new HashMap<>();
    //储存的是url的参数
    private Map<String,String> parameters = new HashMap<>();

    //请求的构造模式 使用工厂模式
    //此处的参数是从socket获得的InputStream对象
    //以下是解析请求的过程
    public static httpRequest build(InputStream inputStream) throws IOException {
        httpRequest request = new httpRequest();
        //此处不将其写入try catch 写入就意味着BufferedReader会关闭 会影响到clientSocket状态
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //1.解析首行
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        //2.解析url参数
        //看看?是否存在 ?之后就是具体的url的值
        //pos是?的下标 ?之后如果没有就不必解析了
        int pos = request.url.indexOf("?");
        if (pos != -1) {
            //subString 是将从?之后的下标开始到url的结束
            //也就是 a=10&b=20
          String parameters = request.url.substring(pos+1);
          //借助这个方法来解析键值对之后的key和value
            //parameters是分开 a=10&b=20 的参数
            //切分的结果 k:a v:10 k:b v:20
            parseKV(parameters,request.parameters);
        }
        //3.解析header
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
            String[] headerTokens = line.split(": ");
            request.headers.put(headerTokens[0],headerTokens[1]);
        }
        //4.解析body
        return request;
    }
    //类的get方法 因为是从网上解析来的用户不应该修改
    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }
    public String getHeader(String key) {
        return headers.get(key);
    }
    public String getParameter(String key) {
        return parameters.get(key);
    }
    private static void parseKV(String input, Map<String, String> output) {
        //先按照 & 区分成 a=10   b=20
        String[] kvTokens = input.split("&");
        //针对区分结果再按照=区分 得到 a 10 b 20键和值
        for (String kv: kvTokens) {
            String[] ret = kv.split("=");
            //将结果放进输出数组中
            output.put(ret[0],ret[1]);
        }
    }

    @Override
    public String toString() {
        return "httpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                ", parameters=" + parameters +
                '}';
    }
}
