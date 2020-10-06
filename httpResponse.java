import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class httpResponse {
    //表示一个HTTP响应(序列化操作)
    private String version = "HTTP/1.1";
    private int status; //状态码
    private String message; //状态码描述信息
    private Map<String,String> headers = new HashMap<>();
    private StringBuilder body = new StringBuilder(); //进行字符串拼接
    //当代码需要把响应写回客户端的时候 就往outputStream中写
    private OutputStream outputStream = null;

    public static httpResponse build(OutputStream outputStream) {
        httpResponse response = new httpResponse();
        //outputStream的初始化 其他属性内容无法确定
        response.outputStream = outputStream;
        return response;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setHeader(String key,String val) {
        headers.put(key,val);
    }
    public void writeBody(String content) {
        body.append(content);
    }
    //以上设置均在内存中
    //接下来用专门的方法将其用HTTP协议规则写在socket中
    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version+" "+status+" "+message+"\n");
        //写出header 有body就得写content-length
        //+""是为转成字符串
        headers.put("Content-Length: ",body.toString().getBytes().length+"");
        for (Map.Entry<String,String> entry : headers.entrySet()) {
            bufferedWriter.write(entry.getKey()+": "+entry.getValue()+"\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }
}
