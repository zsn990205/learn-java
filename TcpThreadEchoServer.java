import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpThreadEchoServer {
    private ServerSocket serverSocket = null;

    public TcpThreadEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        Socket client = serverSocket.accept();
        while (true) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    processConnection(client);
                }
            };
            t.start();
        }
    }
    public void processConnection(Socket client) {
        System.out.printf("[%s:%d] 客户端上线\n",client.getInetAddress().toString(),
                client.getPort());
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {
            while (true) {
                //处理客户端发送的请求 因为是服务器要读取客户端的请求
                String request = bufferedReader.readLine();
                //根据请求得出响应
                String response = process(request);
                //将响应写回给客户端
                bufferedWriter.write(response+"\n");
                bufferedWriter.flush();
                System.out.printf("[%s:%d] req : %s;res : %s\n",client.getInetAddress().toString(),
                     client.getPort(),request,response);
            }
        } catch(IOException e) {
            //e.getStackTrace();
            System.out.printf("[%s:%d] 客户端下线",client.getInetAddress().toString(),
                    client.getPort());
        }

    }
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadEchoServer server = new TcpThreadEchoServer(9090);
        server.start();
    }
}
