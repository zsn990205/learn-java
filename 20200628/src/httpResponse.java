import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class httpResponse {
    //写会浏览器 设置的操作均与写有关
private String version = "HTTP/1.1";
private int status;
private String message;
private Map<String,String> headers = new HashMap<>();
private StringBuilder body = new StringBuilder();
private OutputStream outputStream = null;

   public static httpResponse build(OutputStream outputStream) {
       httpResponse response = new httpResponse();
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

    public void writeBody(String k) {
        body.append(k);
    }

    public void setHeaders(String k,String v) {
       headers.put(k,v);
    }
    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //写首行元素
        bufferedWriter.write(version+" "+status+" "+message+"\n");
        headers.put("Content-Length: ",body.toString().getBytes().length+"");
        for (Map.Entry<String,String> e : headers.entrySet()) {
            bufferedWriter.write(e.getKey()+": "+e.getValue()+"\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }

}
