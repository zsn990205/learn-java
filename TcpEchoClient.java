
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    //1.启动客户端(一定不要绑定端口号) 和服务器建立连接
    //2.进入主循环
    // a) 读取用户输入的内容
    // b) 构造请求并发送给服务器
    // c) 读取服务器的响应数据
    // d) 将响应数据的内容显示到客户端桌面上
    private Socket socket = null;

    public TcpEchoClient(String serverIp,int serverPort) throws IOException {
        //此处的socket在建立tcp连接
        socket = new Socket(serverIp,serverPort);
    }
    public void start() {
        System.out.println("启动客户端");
        Scanner scanner = new Scanner(System.in);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (true) {
                // a) 读取用户输入的内容
                System.out.println("->");
                //这个nextLine忽略了末尾的\n 这个是一行一行的读取数据
                String request = scanner.nextLine();
                if ("exit".equals(request)) {
                    break;
                }
                // b) 构造请求发送给服务器
                // \n 和服务器的readLine相对应 因为客户端发啥数据服务器才能读到啥数据(自定义协议)
                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();
                // c)读取响应数据
                //同样也对应服务器版本的\n
                //自定义的时候得同时兼顾服务器和客户端的响应和请求
                String response = bufferedReader.readLine();

                // d)将响应数据写回到显示界面
                System.out.println(response);
            }
        }
        catch(IOException e){
                e.getStackTrace();
            }
        }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();
    }
}

