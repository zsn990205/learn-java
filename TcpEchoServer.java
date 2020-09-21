import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {
    //1.初始化服务器
    //2.进入主循环
    // 1)先从内核中获取一个Tcp连接(Udp无连接) (Tcp有连接)
    // 2)处理这个Tcp连接
    //   a)读取请求并解析
    //   b)根据请求计算响应
    //   c)把响应写回客户端
    private ServerSocket serversocket = null;

    public TcpEchoServer(int port) throws IOException {
        serversocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //1)先从内核中获取一个Tcp连接
           Socket clientSocket = serversocket.accept();
           //2)处理这个连接
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s:%d] 客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        //通过clientSocket来和客户端进行交互 先获取到clientSocket的流对象
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
        //此处先实现一个长连接版本的服务器
            //当客户端断开连接的时候 这个循环结束
            //当客户端断开连接的时候 服务器再去调用readLine就会触发异常(IOException)
            while (true) {
         //   a)读取请求并解析
                //readLine按行读取(每条数据占一行)->自定义协议
                // 客户端发送的请求必须也是按行输入
                String request = bufferedReader.readLine();
         //   b)根据请求计算响应
                String response = process(request);
         //   c)把响应写回客户端(客户端也得按行来读)
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();
                System.out.printf("[%s:%d] req: %s; res: %s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        }
        catch(IOException e) {
            System.out.printf("[%s:%d] 客户端下线\n",clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
