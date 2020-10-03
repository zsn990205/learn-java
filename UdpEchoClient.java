import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    //核心流程(4步):
    //初始化
    //1.从用户这里读取输入的数据
    //2.将请求发送给服务器
    //3.服务器读取响应
    //4.将响应返回给客户端
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;
    //启动客户端的时候 需要指定连接哪台服务器
    public UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        //客户端中创建socket不需要绑定端口号(由操作系统自动分配给客户端一个空闲的端口)
        //通常情况下 一个端口号只能被一个进程绑定
        //服务器必须绑定端口 因为只有服务器绑定了端口客户端才能固定访问
        //假设客户端也绑定了一个端口号 那么一个主机只能为一个客户端服务 那就很菜了
        socket = new DatagramSocket();
    }
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
        //1.读取用户输入的数据
            System.out.print("->");
            String request = scanner.nextLine();
            if (request.equals("exit")) {
                break;
            }
        //2.客户端构造请求发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp),serverPort);
            socket.send(requestPacket);
        //3.从服务器读取响应
        //和读取服务器的代码一样
        DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
        socket.receive(responsePacket);
        String response = new String(responsePacket.getData(),0,
                responsePacket.getLength()).trim();
        //4.显示响应数据
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        //IP是环回IP 自己响应自己 本机之间的操作
        //如果不在同一个主机上 此处的IP为服务器的IP
        //端口得和服务器绑定的相匹配
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
