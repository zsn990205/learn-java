import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class httpServerV1 {
    //http底层基于TCP实现
    private ServerSocket serverSocket = null;

    public httpServerV1(int port) throws IOException {
       serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
            System.out.println("服务器启动");
            ExecutorService executorService = Executors.newCachedThreadPool();
            while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket) {
        //由于是文本协议 仍然使用字符流处理
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
        //下面的请求得严格按照HTTP的协议实现
        //1.读取请求并解析
          //a) 解析首行
            String firstLine  = bufferedReader.readLine();
          //首行之间的方法 url 版本号之间使用空格隔开
            String[] firstLineTokens = firstLine.split(" ");
            String method = firstLineTokens[0];
            String url = firstLineTokens[1];
            String version = firstLineTokens[2];
          //b) 解析header
            //按行读取 使用键值对的形式按行读取 键值对之间使用:+空格的方式
            Map<String,String> headers = new HashMap<>();
            String line = "";
            //使用循环按行读取
            //当读取的行不为空并且字符长度(不是空字符串)不为0 就一直读下去
            //对于空行来说 去掉\n就变成了空字符串
            while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
                //键值对之间使用 :和空格 来切分 必须是 :+空格
              String[] headerTokens = line.split(": ");
              headers.put(headerTokens[0],headerTokens[1]);
            }
          //c) 解析body (暂时不考虑body的情况)
            //请求解析完毕 加上打印日志 观察内容的正确与否
            //打印首行
            System.out.printf("%s %s %s\n",method, url, version);
            //打印header 这是一个HashMap使用for each循环
            for (Map.Entry<String,String> entry : headers.entrySet()) {
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
            System.out.println();
        //2.根据请求计算响应
            //全部返回hello这样的html
            String resp = "";
            if (url.equals("/ok")) {
                bufferedWriter.write(version+" 200 OK\n");
                resp = "<h1>hello</h1>";
            } else if (url.equals("/notFound")) {
                bufferedWriter.write(version+" 404 notFound\n");
                resp = "<h1>notFound</h1>";
            } else if(url.equals("/seeOther")) {
                //重定向
                bufferedWriter.write(version+" 303 seeOther\n");
                //将当前页面重定向到搜狗搜索
                bufferedWriter.write("location: http://www.sougou.com\n");
                resp = "";
            } else
             {
                bufferedWriter.write(version+" 200 OK\n");
                resp = "<h1>default</h1>";
            }
        //3.把响应返回给客户端
            //首行
            bufferedWriter.write(version+" 200 OK\n");
            //header
            bufferedWriter.write("Content-Type: text/html\n");
            bufferedWriter.write("Content-length: "+resp.getBytes().length+"\n");
            //这是header结束的标志 空行
            bufferedWriter.write("\n");
            //body
            bufferedWriter.write(resp);
            //此处下面的close操作也会自动刷新flush 加不加flush问题不大
            bufferedWriter.flush();
        }
        catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        httpServerV1 serverV1 = new httpServerV1(9090);
        serverV1.start();
    }
}
