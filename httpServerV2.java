import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class httpServerV2 {
    //主框架
   private ServerSocket serverSocket = null;

    public httpServerV2(int port) throws IOException {
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
                    try {
                        process(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void process(Socket clientSocket) throws IOException {
        try {
            //1.读取并解析请求
            httpRequest request = httpRequest.build(clientSocket.getInputStream());
            System.out.println("request: "+request);
            httpResponse response = httpResponse.build(clientSocket.getOutputStream());
            response.setHeader("Content-Type:","text/html");
            //2.根据请求计算响应
            if (request.getUrl().startsWith("/hello")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>hello</h1>");
            } else if (request.getUrl().startsWith("/calc")) {
                //使用这个逻辑进行计算
                String aStr = request.getParameter("a");
                String bStr = request.getParameter("b");
                //将a b转成整数
                int a = Integer.parseInt(aStr);
                int b = Integer.parseInt(bStr);
                int ret = a+b;
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1> ret = " +ret+"</h1>");
            } else if(request.getUrl().startsWith("/cookieUser")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("set-cookie: ","User=name");
                response.writeBody("<h1>set-cookieUser</h1>");
            } else if(request.getUrl().startsWith("/cookieTime")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("set-cookie","Time= "+System.currentTimeMillis()/1000);
                response.writeBody("<h1>set-cookieTime</h1>");
            }
            else {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>default</h1>");
            }
            //3.把响应写回到客户端
            response.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //同时会关闭getInputStream和getOutputStream
            clientSocket.close();
        }

    }

    public static void main(String[] args) throws IOException {
        httpServerV2 serverV2 = new httpServerV2(9090);
        serverV2.start();
    }
}
